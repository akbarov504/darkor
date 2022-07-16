package uz.darkor.darkor_22.service.post;

import uz.darkor.darkor_22.criteria.post.PostCriteria;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;
import uz.darkor.darkor_22.service.GenericCUDService;
import uz.darkor.darkor_22.service.GenericGLService;

import java.util.UUID;

public interface PostService extends GenericCUDService<PostCreateDTO, PostUpdateDTO, PostGetDTO, UUID>, GenericGLService<PostGetDTO, PostCriteria,UUID> {
}
