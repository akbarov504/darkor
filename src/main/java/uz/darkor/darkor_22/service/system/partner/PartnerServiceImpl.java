package uz.darkor.darkor_22.service.system.partner;

import org.springframework.stereotype.Service;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.entity.system.Gallery;
import uz.darkor.darkor_22.entity.system.Partner;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.system.partner.PartnerMapper;
import uz.darkor.darkor_22.repository.system.file.FileRepository;
import uz.darkor.darkor_22.repository.system.partner.PartnerRepository;
import uz.darkor.darkor_22.service.AbstractService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class
PartnerServiceImpl extends AbstractService<PartnerMapper, PartnerRepository> {
    private final FileRepository fileRepository;

    public PartnerServiceImpl(PartnerMapper mapper, PartnerRepository repository, FileRepository fileRepository) {
        super(mapper, repository);
        this.fileRepository = fileRepository;
    }


    public PartnerGetDTO create(PartnerCreateDTO DTO) {
        Optional<Gallery> byId = fileRepository.findById(DTO.getLogo().getId());
        Partner partner = mapper.fromCreateDTO(DTO);
        partner.setLogo(byId.get());
        Partner save = repository.save(partner);
        return mapper.toGetDTO(save);
    }


    public PartnerGetDTO update(PartnerUpdateDTO DTO) {
        Partner byCode = repository.findById(DTO.getId()).orElseThrow(() ->  new NotFoundException("Not Found"));
        Partner partner = mapper.fromUpdateDTO(DTO, byCode);
        Partner save = repository.save(partner);
        return mapper.toGetDTO(save);

    }


    public Boolean delete(Long id ){
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public PartnerGetDTO get(Long id) {
        try {
            return mapper.toGetDTO(repository.findById(id).get());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }



    public List<PartnerGetDTO> getAll() {
        return mapper.toListDTO(repository.findAll());
    }
}
