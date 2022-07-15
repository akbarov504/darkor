package uz.darkor.darkor_22.controller.course.skill;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.skill.SkillCreateDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillUpdateDTO;

import java.util.UUID;

public interface SkillController extends GenericCUDController<SkillCreateDTO, SkillUpdateDTO, SkillGetDTO, UUID>,
        GenericGLController<SkillGetDTO, BaseCriteria, UUID> {
}
