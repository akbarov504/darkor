package uz.darkor.darkor_22.controller.course.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseLocalizationDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.course.CourseServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = BaseUtils.PATH + "/course/*")
public class CourseControllerImpl extends AbstractController<CourseServiceImpl> implements CourseController {
    public CourseControllerImpl(CourseServiceImpl service) {
        super(service);
    }


    @PostMapping("create/")
    public ResponseEntity<Data<CourseLocalizationDTO>> createMy(@RequestBody CourseCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.CREATED);
    }

    @PutMapping("update/")
    public ResponseEntity<Data<CourseLocalizationDTO>> updateMy(@RequestBody CourseUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.delete(id)), HttpStatus.OK);
    }

//    @GetMapping("get/")
//    public ResponseEntity<Data<CourseLocalizationDTO>> getMy(@pathVariable Long id, @RequestHeader("accept-language") String lang) {
//        return new ResponseEntity<>(new Data<>(service.get(id, lang)), HttpStatus.OK);
//
//    }

    @GetMapping("list/")
    public ResponseEntity<Data<List<CourseLocalizationDTO>>> listMy(@Valid CourseCriteria criteria, @RequestHeader("accept-language") String lang) {
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)), HttpStatus.OK);
    }

    @GetMapping("forUpdate/{id}")
    public ResponseEntity<Data<CourseUpdateDTO>> getForUpdateCourse(@PathVariable Long id){
        return new ResponseEntity<>(new Data<>(service.getForUpdate(id)),HttpStatus.OK);
    }




    @Override
    public ResponseEntity<Data<CourseGetDTO>> create(CourseCreateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return null;
    }
    @Override
    public ResponseEntity<Data<CourseGetDTO>> update(CourseUpdateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return null;
    }
    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        BaseUtils.setSessionLang(lang);
        return null;
    }
    @Override
    public ResponseEntity<Data<CourseGetDTO>> get(UUID code, String lang) {
        return null;
    }
    @Override
    public ResponseEntity<Data<List<CourseGetDTO>>> list(CourseCriteria criteria, String lang) {
        return null;
    }
}
