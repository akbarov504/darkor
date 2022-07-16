package uz.darkor.darkor_22.controller.system.comment;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.system.comment.CommentCriteria;
import uz.darkor.darkor_22.dto.system.comment.CommentCreateDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentGetDTO;
import uz.darkor.darkor_22.dto.system.comment.CommentUpdateDTO;

import java.util.UUID;

public interface CommentController extends GenericCUDController<CommentCreateDTO, CommentUpdateDTO, CommentGetDTO, UUID>, GenericGLController<CommentGetDTO, CommentCriteria, UUID> {
}
