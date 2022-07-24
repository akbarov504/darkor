package uz.darkor.darkor_22.controller.employee.detail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.darkor.darkor_22.controller.AbstractController;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailLocalizedDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.employee.detail.EmployeeDetailService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = BaseUtils.PATH + "/employee_detail/*")
public class EmployeeDetailControllerImpl extends AbstractController<EmployeeDetailService> implements EmployeeDetailController {

    public EmployeeDetailControllerImpl(EmployeeDetailService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Data<EmployeeDetailLocalizedDTO>> create(EmployeeDetailCreateDTO DTO, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<EmployeeDetailLocalizedDTO>> update(EmployeeDetailUpdateDTO DTO, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(UUID code, String lang) {
        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<EmployeeDetailLocalizedDTO>> get(UUID code, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.get(code, lang)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<List<EmployeeDetailLocalizedDTO>>> list(BaseCriteria criteria, String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.list(criteria, lang)), HttpStatus.OK);
    }

    @PostMapping("get_by_employee/{code}")
    public ResponseEntity<Data<EmployeeDetailLocalizedDTO>> getByEmployeeCode(@PathVariable UUID code, @RequestHeader("accept-language") String lang) {
        BaseUtils.setSessionLang(lang);
        return new ResponseEntity<>(new Data<>(service.getAllByEmployee(code)), HttpStatus.OK);
    }
}
