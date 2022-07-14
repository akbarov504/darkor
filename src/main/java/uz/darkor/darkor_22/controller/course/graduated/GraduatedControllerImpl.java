package uz.darkor.darkor_22.controller.course.graduated;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.course.graduated.GraduatedService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(BaseUtils.PATH + "/graduated/*")
public class GraduatedControllerImpl extends AbstractController<GraduatedService> implements GraduatedController {

    public GraduatedControllerImpl(GraduatedService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<GraduatedGetDTO>> create(GraduatedCreateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<GraduatedGetDTO>> update(GraduatedUpdateDTO DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code) {
        return null;
    }

    @Override
    public ResponseEntity<Data<GraduatedGetDTO>> get(UUID code, String lang) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<GraduatedGetDTO>>> list(BaseCriteria criteria, String lang) {
        return null;
    }
}
