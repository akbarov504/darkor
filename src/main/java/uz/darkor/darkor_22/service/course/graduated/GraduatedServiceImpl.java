package uz.darkor.darkor_22.service.course.graduated;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedCreateDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedGetDTO;
import uz.darkor.darkor_22.dto.course.graduated.GraduatedUpdateDTO;
import uz.darkor.darkor_22.mapper.graduated.GraduatedMapper;
import uz.darkor.darkor_22.repository.graduated.GraduatedRepository;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.UUID;

@Service
public class GraduatedServiceImpl extends AbstractService<GraduatedMapper, GraduatedRepository>
        implements GraduatedService {

    public GraduatedServiceImpl(GraduatedMapper mapper,
                                GraduatedRepository repository) {
        super(mapper, repository);
    }

    @Override
    public ResponseEntity<Data<GraduatedGetDTO>> get(UUID code, String lang) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<GraduatedGetDTO>>> list(BaseCriteria criteria, String lang) {
        return null;
    }

    @Override
    public GraduatedGetDTO create(GraduatedCreateDTO DTO) {
        return null;
    }

    @Override
    public GraduatedGetDTO update(GraduatedUpdateDTO DTO) {
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return null;
    }
}
