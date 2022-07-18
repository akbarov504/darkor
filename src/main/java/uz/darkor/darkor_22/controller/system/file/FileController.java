package uz.darkor.darkor_22.controller.system.file;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.enums.ContentType;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.system.file.FileService;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@Transactional
public class FileController extends AbstractController<FileService> {

    public FileController(FileService service) {
        super(service);
    }

    @PostMapping("/upload/{contentType}")
    public ResponseEntity<Data<FileDTO>> save(MultipartFile file, @PathVariable ContentType contentType) throws IOException {
      return new ResponseEntity<>(new Data<>(service.save(file, contentType)), HttpStatus.OK);
    }

    @GetMapping(BaseUtils.PATH + "/download/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {

        Resource file = service.download(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

    }

}
