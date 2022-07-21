package uz.darkor.darkor_22.controller.system.partner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.system.partner.PartnerCriteria;
import uz.darkor.darkor_22.dto.system.partner.PartnerCreateDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerGetDTO;
import uz.darkor.darkor_22.dto.system.partner.PartnerUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.system.partner.PartnerService;
import uz.darkor.darkor_22.service.system.partner.PartnerServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/partner/*")
public class PartnerControllerImpl extends AbstractController<PartnerServiceImpl>{

    public PartnerControllerImpl(PartnerServiceImpl service) {
        super(service);
    }

    @PostMapping("/add")
    public ResponseEntity<Data<PartnerGetDTO>> create(@RequestBody PartnerCreateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @PutMapping("/updated")
    public ResponseEntity<Data<PartnerGetDTO>> update(@RequestBody PartnerUpdateDTO DTO) {
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.delete(id)), HttpStatus.OK);
    }


   @GetMapping("/getOne/{id}")
    public ResponseEntity<Data<PartnerGetDTO>> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Data<>(service.get(id)), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Data<List<PartnerGetDTO>>> list() {
        return new ResponseEntity<>(new Data<>(service.getAll()), HttpStatus.OK);
    }
}
