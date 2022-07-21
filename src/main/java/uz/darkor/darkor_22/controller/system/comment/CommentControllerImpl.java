package uz.darkor.darkor_22.controller.system.comment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentLocalizationDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.system.comment.CommentServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = BaseUtils.PATH + "/comment/")
public class CommentControllerImpl extends AbstractController<CommentServiceImpl> {

    public CommentControllerImpl(CommentServiceImpl service) {
        super(service);
    }

    @PostMapping("/addComment")
    public ResponseEntity<Data<CommentLocalizationDTO>> create(@RequestBody CommentCreateDTO DTO,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.createMy(DTO,lang)), HttpStatus.OK);
    }

    @PutMapping("/updated")
    public ResponseEntity<Data<CommentLocalizationDTO>> update(@RequestBody CommentUpdateDTO DTO,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.updateMy(DTO,lang)), HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.deleteMy(id)),HttpStatus.OK);
    }

    @GetMapping("/getOneComment/{id}")
    public ResponseEntity<Data<CommentLocalizationDTO>> get(@PathVariable  Long  id,@RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.getMy(id,lang)), HttpStatus.OK);
    }

    @GetMapping("/listComment")
    public ResponseEntity<Data<List<CommentLocalizationDTO>>> list(@Valid  CommentCriteria criteria,@RequestHeader("accept-language") String lang) {
        return  new ResponseEntity<>(new Data<>(service.listMy(criteria,lang)),HttpStatus.OK);
    }

    @GetMapping("getAllByCourse/{id}")
    public ResponseEntity<Data<List<CommentLocalizationDTO>>> getAllByCourse(@PathVariable Long id, @RequestHeader("accept-language") String lang){
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.getByCourse(id), service.getSize()), HttpStatus.OK);
    }
}
