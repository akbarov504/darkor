package uz.darkor.darkor_22.controller.course.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.course.CourseCriteria;
import uz.darkor.darkor_22.dto.course.course.CourseCreateDTO;
import uz.darkor.darkor_22.dto.course.course.CourseGetDTO;
import uz.darkor.darkor_22.dto.course.course.CourseUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.course.CourseServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/course/*")
public class CourseControllerImpl extends AbstractController<CourseServiceImpl> implements CourseController {
    public CourseControllerImpl(CourseServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<CourseGetDTO>> create(CourseCreateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Data<CourseGetDTO>> update(CourseUpdateDTO DTO,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code,String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CourseGetDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code, lang)), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Data<List<CourseGetDTO>>> list(CourseCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)), HttpStatus.OK);
    }

    @GetMapping("forUpdate/{id}")
    public ResponseEntity<Data<CourseUpdateDTO>> getForUpdateCourse(@PathVariable Long id){
        return new ResponseEntity<>(new Data<>(service.getForUpdate(id)),HttpStatus.OK);
    }
}
