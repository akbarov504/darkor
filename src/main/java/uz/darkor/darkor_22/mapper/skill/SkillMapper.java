package uz.darkor.darkor_22.mapper.skill;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.course.skill.SkillCreateDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillGetDTO;
import uz.darkor.darkor_22.dto.course.skill.SkillUpdateDTO;
import uz.darkor.darkor_22.entity.course.Course;
import uz.darkor.darkor_22.entity.course.Skill;
import uz.darkor.darkor_22.mapper.GenericMapper;

@Mapper(componentModel = "spring", uses = Course.class)
public interface SkillMapper extends GenericMapper<SkillCreateDTO, SkillUpdateDTO, SkillGetDTO, Skill> {
}
