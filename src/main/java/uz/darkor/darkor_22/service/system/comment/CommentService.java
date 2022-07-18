package uz.darkor.darkor_22.service.system.comment;

import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface CommentService extends GenericCUDService<CommentCreateDTO, CommentUpdateDTO, CommentGetDTO, UUID>,
        GenericGLService<CommentGetDTO, CommentCriteria, UUID> {

}
