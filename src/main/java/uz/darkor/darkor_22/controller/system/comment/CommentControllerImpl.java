package uz.darkor.darkor_22.controller.system.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.system.comment.CommentServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = BaseUtils.PATH + "/comment/")
public class CommentControllerImpl extends AbstractController<CommentServiceImpl> implements CommentController {

    public CommentControllerImpl(CommentServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<CommentGetDTO>> create(CommentCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CommentGetDTO>> update(CommentUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code) {
        return null;
    }

    @Override
    public ResponseEntity<Data<CommentGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code,lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<CommentGetDTO>>> list(CommentCriteria criteria, String lang) {
       return null;
    }

    @GetMapping("getAllByCourse/{code}")
    public ResponseEntity<Data<List<CommentGetDTO>>> getAllByCourse(@PathVariable UUID code, @RequestHeader("accept-language") String lang){
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.getByCourse(code), service.getSize()), HttpStatus.OK);
    }
}
