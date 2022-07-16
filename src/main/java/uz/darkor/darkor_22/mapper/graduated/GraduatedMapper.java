package uz.darkor.darkor_22.mapper.graduated;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.entity.course.Graduated;
import uz.darkor.darkor_22.mapper.GenericMapper;


@Mapper(componentModel = "spring")
public interface GraduatedMapper
        extends GenericMapper<GraduatedCreateDTO, GraduatedUpdateDTO, GraduatedGetDTO, Graduated> {
}
