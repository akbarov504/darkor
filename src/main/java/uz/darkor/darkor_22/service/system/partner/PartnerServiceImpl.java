package uz.darkor.darkor_22.service.system.partner;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.entity.system.Partner;
import uz.darkor.darkor_22.mapper.system.partner.PartnerMapper;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.repository.system.partner.PartnerRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartnerServiceImpl extends AbstractService<PartnerMapper, PartnerRepository> implements PartnerService {
    private final FileRepository fileRepository;

    public PartnerServiceImpl(PartnerMapper mapper, PartnerRepository repository, FileRepository fileRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
    }

    @Override
    public PartnerGetDTO create(PartnerCreateDTO DTO) {
        Optional<Gallery> byId = fileRepository.findById(DTO.getLogo().getId());
        Partner partner = mapper.fromCreateDTO(DTO);
        partner.setLogo(byId.get());
        Partner save = repository.save(partner);
        return mapper.toGetDTO(save);
    }

    @Override
    public PartnerGetDTO update(PartnerUpdateDTO DTO) {
        Partner byCode = repository.findByCode(DTO.getCode());
        Partner partner = mapper.fromUpdateDTO(DTO, byCode);
        Partner save = repository.save(partner);
        return mapper.toGetDTO(save);
//        return null;
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

    public List<PartnerGetDTO> getAll() {
        return mapper.toListDTO(repository.findAll());
    }
}
