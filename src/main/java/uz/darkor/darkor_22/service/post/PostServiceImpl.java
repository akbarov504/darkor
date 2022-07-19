package uz.darkor.darkor_22.service.post;

import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import uz.darkor.darkor_22.criteria.post.PostCriteria;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;
import uz.darkor.darkor_22.dto.home.statistics.StatisticsGetDTO;
import uz.darkor.darkor_22.entity.home.HomeService;
import uz.darkor.darkor_22.entity.home.Post;
import uz.darkor.darkor_22.entity.home.Statistics;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.post.PostMapper;
import uz.darkor.darkor_22.repository.post.PostRepository;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl extends AbstractService<PostMapper, PostRepository> implements PostService {

    public PostServiceImpl(PostMapper mapper, PostRepository repository) {
        super(mapper, repository);
    }

    @Override
    public PostGetDTO create(PostCreateDTO DTO) {
        return repository.save(mapper.fromCreateDTO(DTO)).getLocalizationDto("uz");

    }

    @Override
    public PostGetDTO update(PostUpdateDTO DTO) {
        Post post = repository.findByCode(DTO.getCode())
                .orElseThrow(() -> new NotFoundException("HomeService topilmadi"));
        return repository.save(mapper.fromUpdateDTO(DTO,post)).getLocalizationDto("uz");
    }

    @Override
    public Boolean delete(UUID key) {
        try {
            repository.deleteByCode(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public PostGetDTO get(UUID key, String language) {
        Post post = repository.findByCode(key)
                .orElseThrow(() -> new NotFoundException("HomeService topilmadi"));
        return post.getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<PostGetDTO> list(PostCriteria criteria, String language) {
        List<PostGetDTO> postGetDTOS = new ArrayList<>();
        PageRequest request = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<Post> posts = repository.findAll(request).stream().toList();
        for (Post c : posts) {
            postGetDTOS.add(c.getLocalizationDto(BaseUtils.getSessionLang()));
        }
        return postGetDTOS;
    }
}
