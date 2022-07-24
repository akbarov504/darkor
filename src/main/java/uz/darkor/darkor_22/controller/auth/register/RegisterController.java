package uz.darkor.darkor_22.controller.auth.register;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.auth.register.RegisterCriteria;
import uz.darkor.darkor_22.dto.auth.register.RegisterCreateDTO;
import uz.darkor.darkor_22.dto.auth.register.RegisterGetDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.auth.register.RegisterService;
import uz.darkor.darkor_22.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = BaseUtils.PATH + "/register/*")
public class RegisterController extends AbstractController<RegisterService> {
    public RegisterController(RegisterService service) {
        super(service);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Data<RegisterGetDTO>> create(@RequestBody @Valid RegisterCreateDTO dto) {
        RegisterGetDTO registerGetDTO = service.create(dto);
        return new ResponseEntity<>(new Data<>(registerGetDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Data<List<RegisterGetDTO>>> list(@Valid RegisterCriteria criteria) {
        List<RegisterGetDTO> list = service.list(criteria);
        return new ResponseEntity<>(new Data<>(list), HttpStatus.OK);
    }

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public ResponseEntity<Boolean> generate() throws Exception {
        return new ResponseEntity<>(service.generate(), HttpStatus.OK);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> download() throws Exception {
        Resource file = service.download();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\"" + "registered_user.xlsx" + "\"").body(file);
    }
}
