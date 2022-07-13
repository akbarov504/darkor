//package uz.darkor.darkor_22.controller.employee;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import uz.darkor.darkor_22.controller.AbstractController;
//import uz.darkor.darkor_22.criteria.employee.EmployeeCriteria;
//import uz.darkor.darkor_22.dto.auth.employee.EmployeeCreateDTO;
//import uz.darkor.darkor_22.dto.auth.employee.EmployeeGetDTO;
//import uz.darkor.darkor_22.dto.auth.employee.EmployeeUpdateDTO;
//import uz.darkor.darkor_22.dto.auth.employee_with_detail.EmployeeWithDetailCreatDTO;
//import uz.darkor.darkor_22.response.Data;
//import uz.darkor.darkor_22.service.employee.EmployeeService;
//import uz.darkor.darkor_22.service.employee.detail.EmployeeDetailService;
//import uz.darkor.darkor_22.utils.BaseUtils;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping(value = BaseUtils.PATH + "/employee/*")
//public class EmployeeControllerImpl extends AbstractController<EmployeeService> implements EmployeeController {
//
//    private final EmployeeDetailService detailService;
//
//    public EmployeeControllerImpl(EmployeeService service,
//                                  @Qualifier("employeeDetailService") EmployeeDetailService detailService) {
//        super(service);
//        this.detailService = detailService;
//    }
//
//    @PostMapping(value = "create_with_detail")
//    public ResponseEntity<Data<EmployeeGetDTO>> createWithDetail(EmployeeWithDetailCreatDTO dto) {
//        EmployeeGetDTO employeeGetDTO = service.create(dto.getProfile());
//        dto.getDetail().setEmployee(employeeGetDTO);
//        detailService.create(dto.getDetail());
//        return new ResponseEntity<>(new Data<>(employeeGetDTO), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Data<EmployeeGetDTO>> create(EmployeeCreateDTO DTO) {
//        return new ResponseEntity<>(new Data<>(service.create(DTO)), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Data<EmployeeGetDTO>> update(EmployeeUpdateDTO DTO) {
//        return new ResponseEntity<>(new Data<>(service.update(DTO)), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Data<EmployeeGetDTO>> get(UUID code, String lang) {
//        BaseUtils.setSessionLang(lang);
//        return new ResponseEntity<>(new Data<>(service.get(code)), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Data<List<EmployeeGetDTO>>> list(EmployeeCriteria criteria, String lang) {
//        BaseUtils.setSessionLang(lang);
//        return new ResponseEntity<>(new Data<>(service.list(criteria)), HttpStatus.OK);
//    }
//
//    @Override
//    public ResponseEntity<Data<Boolean>> delete(UUID code) {
//        return new ResponseEntity<>(new Data<>(service.delete(code)), HttpStatus.OK);
//    }
//
//    @PostMapping("get_by_course/{code}")
//    public ResponseEntity<Data<List<EmployeeGetDTO>>> getByCourseCode(@PathVariable UUID code, String lang) {
//        BaseUtils.setSessionLang(lang);
//        return new ResponseEntity<>(new Data<>(service.getAllByCourseCode(code)), HttpStatus.OK);
//    }
//
//}
