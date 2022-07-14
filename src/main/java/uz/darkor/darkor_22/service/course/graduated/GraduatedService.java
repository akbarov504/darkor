package uz.darkor.darkor_22.service.course.graduated;

import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.List;
import java.util.UUID;

public interface GraduatedService
        extends GenericCUDService<GraduatedCreateDTO, GraduatedUpdateDTO, GraduatedGetDTO, UUID>,
        GenericGLService<GraduatedGetDTO, BaseCriteria, UUID>, BaseService {
    List<GraduatedGetDTO> getByCourseCode(UUID code);
}
