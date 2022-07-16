package uz.darkor.darkor_22.controller.post;

import uz.darkor.darkor_22.controller.GenericCUDController;
import uz.darkor.darkor_22.controller.GenericGLController;
import uz.darkor.darkor_22.criteria.post.PostCriteria;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;

import java.util.UUID;

public interface PostController extends GenericCUDController<PostCreateDTO, PostUpdateDTO, PostGetDTO, UUID>, GenericGLController<PostGetDTO, PostCriteria,UUID> {
}
