package uz.darkor.darkor_22.mapper.system.file;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.mapper.BaseMapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper extends BaseMapper {

    FileDTO toDto(Gallery entity);

    List<Gallery> fromListDto(List<FileDTO> dto);

    Gallery fromDto(FileDTO entity);

}
