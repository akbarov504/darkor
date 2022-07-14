package uz.darkor.darkor_22.service.course.graduated;

import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;

import java.util.UUID;

public interface GraduatedService
        extends GenericCUDService<GraduatedCreateDTO, GraduatedUpdateDTO, GraduatedGetDTO, UUID>,
        GenericGLController<GraduatedGetDTO, BaseCriteria, UUID>, BaseService {
}
