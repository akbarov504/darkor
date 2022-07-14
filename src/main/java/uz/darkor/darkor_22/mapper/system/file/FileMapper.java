package uz.darkor.darkor_22.mapper.system.file;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.mapper.BaseMapper;

@Mapper(componentModel = "spring")
public interface FileMapper extends BaseMapper {

    FileDTO toDto(Gallery entity);

}
