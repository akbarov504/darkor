package uz.darkor.darkor_22.controller.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.post.PostCriteria;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.post.PostServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH+"/post/*")
public class PostControllerImpl extends AbstractController<PostServiceImpl> implements PostController{
    public PostControllerImpl(PostServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<PostGetDTO>> create(PostCreateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<PostGetDTO>> update(PostUpdateDTO DTO,String lang) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        return new ResponseEntity<>(new Data<>(service.delete(code)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PostGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code, lang)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<PostGetDTO>>> list(PostCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)),HttpStatus.OK);
    }
}
