package uz.darkor.darkor_22.controller.course.course.courseDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.course.CourseDetailCriteria;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailCreateDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailGetDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailLocalizationDTO;
import uz.darkor.darkor_22.dto.course.course_detail.CourseDetailUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.course.courseDetails.CourseDetailsServiceImpl;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;

@RestController
@RequestMapping(value = BaseUtils.PATH + "/courseDetails/*")
public class CourseDetailControllerImpl extends AbstractController<CourseDetailsServiceImpl> implements CourseDetailController {

    public CourseDetailControllerImpl(CourseDetailsServiceImpl service) {
        super(service);
    }

    @PostMapping("create/")
    public ResponseEntity<Data<CourseDetailLocalizationDTO>> createMy(@RequestBody CourseDetailCreateDTO DTO) {
        CourseDetailLocalizationDTO courseDetailLocalizationDTO = service.create(DTO);
        return new ResponseEntity<>(new Data<>(courseDetailLocalizationDTO), HttpStatus.OK);
    }

    @PutMapping("update/")
    public ResponseEntity<Data<CourseDetailLocalizationDTO>> updateMy(@RequestBody CourseDetailUpdateDTO DTO) {
        CourseDetailLocalizationDTO update = service.update(DTO);
        return new ResponseEntity<>(new Data<>(update), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Data<Boolean>> deleteMy(@PathVariable Long id) {
        Boolean delete = service.delete(id);
        return new ResponseEntity<>(new Data<>(delete), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Data<CourseDetailLocalizationDTO>> getMy(@PathVariable Long id, @RequestHeader("accept-language") String lang) {
        CourseDetailLocalizationDTO courseDetailLocalizationDTO = service.get(id, lang);
        return new ResponseEntity<>(new Data<>(courseDetailLocalizationDTO), HttpStatus.OK);
    }

    @GetMapping("get/list/")
    public ResponseEntity<Data<List<CourseDetailLocalizationDTO>>> listMy(@RequestBody CourseDetailCriteria criteria, @RequestHeader("accept-language") String lang) {
        List<CourseDetailLocalizationDTO> list = service.list(criteria, lang);
        return new ResponseEntity<>(new Data<>(list), HttpStatus.OK);
    }




    @Override
    public ResponseEntity<Data<CourseDetailGetDTO>> create(CourseDetailCreateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<CourseDetailGetDTO>> update(CourseDetailUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long code) {
        return null;
    }

    @Override
    public ResponseEntity<Data<CourseDetailGetDTO>> get(Long code, String lang) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<CourseDetailGetDTO>>> list(CourseDetailCriteria criteria, String lang) {
        return null;
    }
}
