package uz.darkor.darkor_22.service.post;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.post.PostCriteria;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostLocalizedDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;
import uz.darkor.darkor_22.entity.home.Post;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.post.PostMapper;
import uz.darkor.darkor_22.repository.post.PostRepository;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl extends AbstractService<PostMapper, PostRepository>  {
    final FileRepository fileRepository;
    public PostServiceImpl(PostMapper mapper, PostRepository repository, FileRepository fileRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
    }


    public PostLocalizedDTO create(PostCreateDTO DTO,String lang) {

        Post post = new Post();
        post.setGalleryEn(fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setGalleryRu(fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setGalleryUz(fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setTitleEn(DTO.getTitleEn());
        post.setTitleRu(DTO.getTitleRU());
        post.setTitleUz(DTO.getTitleUz());
        post.setDescriptionEn(DTO.getDescriptionEn());
        post.setDescriptionRu(DTO.getDescriptionRu());
        post.setDescriptionUz(DTO.getDescriptionUz());


        repository.save(post);
        return mapper.toGetDTO(post).getLocalizationDto(lang);

    }


    public PostLocalizedDTO update(PostUpdateDTO DTO,String lang) {
        Post post = repository.findByCode(DTO.getCode())
                .orElseThrow(() -> new NotFoundException("HomeService topilmadi"));
        post.setGalleryEn(fileRepository.findById(DTO.getGalleryEn().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setGalleryRu(fileRepository.findById(DTO.getGalleryRu().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setGalleryUz(fileRepository.findById(DTO.getGalleryUz().getId()).orElseThrow(() -> new NotFoundException("Not null")));
        post.setTitleEn(DTO.getTitleEn());
        post.setTitleRu(DTO.getTitleRU());
        post.setTitleUz(DTO.getTitleUz());
        post.setDescriptionEn(DTO.getDescriptionEn());
        post.setDescriptionRu(DTO.getDescriptionRu());
        post.setDescriptionUz(DTO.getDescriptionUZ());
        repository.save(post);
        return mapper.toGetDTO(post).getLocalizationDto(lang);
    }


    public Boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public PostLocalizedDTO get(Long id, String language) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("HomeService topilmadi"));

        return mapper.toGetDTO(post).getLocalizationDto(language);
    }


    public List<PostLocalizedDTO> list(PostCriteria criteria, String language) {
        List<PostLocalizedDTO> postGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Post> posts = repository.findAll(request).stream().toList();
        for (Post c : posts) {
            postGetDTOS.add(mapper.toGetDTO(c).getLocalizationDto(language));
        }
        return postGetDTOS;
    }
}
