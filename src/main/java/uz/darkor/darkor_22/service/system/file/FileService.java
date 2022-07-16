package uz.darkor.darkor_22.service.system.file;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.dto.system.gallery.GalleryDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.enums.ContentType;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.exception.validator.BadRequestException;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.response.APIErrorDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileService extends AbstractService<FileMapper, FileRepository> {

    private static String extensions = "{jpg};{png};{PNG};{JPG};{mp4};{MP4};{webm);{WEBM};{flv};{vob};{avi};{gif};{mov}";
    String uploadDirectory = "E:\\uploads\\";


//    @Value("${path.request}")
//    private String requestt;
//    @Value("${path.api}")
//    private String api;
//    @Value("${path.url-path}")
//    private String urlPath;

    public FileService(FileMapper mapper, FileRepository repository) {
        super(mapper, repository);
    }


    public FileDTO save(MultipartFile file, ContentType type) throws IOException {

        try {
            String originalFilename = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalFilename);
            if (Objects.nonNull(extension) && !extensions.contains(extension))
                throw new RuntimeException("image format not comfortable");
            String generatedName = System.currentTimeMillis() + "." + extension;
            Path path = Paths.get(uploadDirectory + generatedName);
            System.out.println(path);

            Files.copy(file.getInputStream(), path);

            String url = "http://localhost:8080" + BaseUtils.PATH.concat("/download/".concat(generatedName));

            Gallery gallery = new Gallery(file.getSize(),
                    originalFilename,
                    generatedName,
                    extension,
                    path.toString(),
                    url,
                    type);
            Gallery responseGallery = repository.save(gallery);
//            Files.copy(file.getInputStream(), path);
            return mapper.toDto(responseGallery);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("File saqlanmadi");
        }
    }


    public org.springframework.core.io.Resource download(String name) {

        org.springframework.core.io.Resource resource = null;

        try {
            Path location = Paths.get(uploadDirectory  + name);
            resource = new UrlResource(location.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }

        } catch (MalformedURLException e) {
            throw new NotFoundException("file not found");
        }

        return resource;

    }
}