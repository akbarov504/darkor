package uz.darkor.darkor_22.service.course.graduated;

import uz.darkor.darkor_22.criteria.graduated.GraduatedCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedLocalizedDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.List;
import java.util.UUID;

public interface GraduatedService
        extends GenericCUDService<GraduatedCreateDTO, GraduatedUpdateDTO, GraduatedLocalizedDTO, UUID>,
        GenericGLService<GraduatedLocalizedDTO, GraduatedCriteria, UUID>, BaseService {
    List<GraduatedLocalizedDTO> getByCourseCode(UUID code);
}
