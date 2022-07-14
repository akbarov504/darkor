package uz.darkor.darkor_22.mapper.gallery;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.system.gallery.FileDTO;
//import uz.darkor.darkor_22.dto.system.gallery.GalleryGetDTO;
import uz.darkor.darkor_22.entity.system.Gallery;

@Mapper(componentModel = "spring")
public interface GalleryMapper {

//    GalleryGetDTO fromFileDtoToDto(FileDTO fileDTO);

    Gallery fromFileDto(FileDTO fileDTO);

}
