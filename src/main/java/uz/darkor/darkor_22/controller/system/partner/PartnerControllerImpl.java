package uz.darkor.darkor_22.controller.system.partner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.system.partner.PartnerService;
import uz.darkor.darkor_22.service.system.partner.PartnerServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/partner/*")
public class PartnerControllerImpl extends AbstractController<PartnerServiceImpl> implements PartnerController {

    public PartnerControllerImpl(PartnerServiceImpl service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<PartnerGetDTO>> create(PartnerCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<PartnerGetDTO>> update(PartnerUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code) {
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Data<PartnerGetDTO>> get(UUID code, String lang) {
        return new ResponseEntity<>(new Data<>(service.get(code,lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<PartnerGetDTO>>> list(PartnerCriteria criteria, String lang) {
        return new ResponseEntity<>(new Data<>(service.getAll()), HttpStatus.OK);
    }
}
