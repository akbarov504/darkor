package uz.darkor.darkor_22.mapper.post;

import org.mapstruct.Mapper;
import uz.darkor.darkor_22.dto.home.post.PostCreateDTO;
import uz.darkor.darkor_22.dto.home.post.PostGetDTO;
import uz.darkor.darkor_22.dto.home.post.PostUpdateDTO;
import uz.darkor.darkor_22.entity.home.Post;
import uz.darkor.darkor_22.mapper.GenericMapper;
import uz.darkor.darkor_22.mapper.system.file.FileMapper;

@Mapper(componentModel = "spring", uses = {FileMapper.class})
public interface PostMapper extends GenericMapper<PostCreateDTO, PostUpdateDTO, PostGetDTO, Post> {
}
