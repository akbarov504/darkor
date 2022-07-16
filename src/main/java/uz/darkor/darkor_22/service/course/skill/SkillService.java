package uz.darkor.darkor_22.service.course.skill;

import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.skill.SkillCreateDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillUpdateDTO;
import uz.darkor.darkor_22.service.BaseService;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.List;
import java.util.UUID;

public interface SkillService extends GenericCUDService<SkillCreateDTO, SkillUpdateDTO, SkillGetDTO, UUID>,
        GenericGLService<SkillGetDTO, BaseCriteria, UUID>, BaseService {
    List<SkillGetDTO> getByCourseCode(UUID code);

    List<SkillGetDTO> getByEmployeeDetail(UUID code);
}
