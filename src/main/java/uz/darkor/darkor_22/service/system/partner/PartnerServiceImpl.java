package uz.darkor.darkor_22.service.system.partner;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.entity.system.Partner;
import uz.darkor.darkor_22.mapper.system.partner.PartnerMapper;
import uz.darkor.darkor_22.repository.system.partner.PartnerRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerServiceImpl extends AbstractService<PartnerMapper, PartnerRepository> implements PartnerService {

    public PartnerServiceImpl(PartnerMapper mapper, PartnerRepository repository) {
        super(mapper, repository);
    }

    @Override
    public PartnerGetDTO create(PartnerCreateDTO DTO) {
        Partner save = repository.save(mapper.fromCreateDTO(DTO));
        return mapper.toGetDTO(save);
    }

    @Override
    public PartnerGetDTO update(PartnerUpdateDTO DTO) {
//        Partner byCode = repository.findByCode(DTO.getCode());
//        Partner save = repository.save(mapper.fromUpdateDTO(DTO, byCode));
//        return mapper.toGetDTO(save);
        return null;
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public PartnerGetDTO get(UUID key) {
        return mapper.toGetDTO(repository.findByCode(key));
    }

    @Override
    public List<PartnerGetDTO> list(PartnerCriteria criteria) {
        return null;
    }

    public List<PartnerGetDTO> getAll(){
        return mapper.toListDTO(repository.findAll());
    }
}
