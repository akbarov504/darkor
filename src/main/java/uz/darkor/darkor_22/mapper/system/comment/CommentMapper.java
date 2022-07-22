package uz.darkor.darkor_22.mapper.system.comment;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.entity.system.Comment;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.course.CourseMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {FileMapper.class, CourseMapper.class})
public interface CommentMapper extends GenericMapper<CommentCreateDTO, CommentUpdateDTO, CommentGetDTO, Comment> {

//    CommentGetDTO toGetDtoMY(Comment entity);
//
//    Comment fromCreateDtoMy(CommentCreateDTO dto);

    List<CommentGetDTO> toGetListDtoMy(List<Comment> entities);

}
