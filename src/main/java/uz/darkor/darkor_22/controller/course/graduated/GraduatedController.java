package uz.darkor.darkor_22.controller.course.graduated;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.criteria.graduated.GraduatedCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedLocalizedDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;

import java.util.UUID;

public interface GraduatedController
        extends GenericCUDController<GraduatedCreateDTO, GraduatedUpdateDTO, GraduatedLocalizedDTO, UUID>,
        GenericGLController<GraduatedLocalizedDTO, GraduatedCriteria, UUID> {
}
