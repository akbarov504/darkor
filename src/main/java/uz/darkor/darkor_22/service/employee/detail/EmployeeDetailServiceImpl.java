package uz.darkor.darkor_22.service.employee.detail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import uz.darkor.darkor_22.criteria.BaseCriteria;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailCreateDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailGetDTO;
import uz.darkor.darkor_22.dto.auth.employee_detail.EmployeeDetailUpdateDTO;
import uz.darkor.darkor_22.entity.auth.Employee;
import uz.darkor.darkor_22.entity.auth.EmployeeDetail;
import uz.darkor.darkor_22.exception.NotFoundException;
import uz.darkor.darkor_22.mapper.employee.EmployeeDetailMapper;
import uz.darkor.darkor_22.repository.employee.EmployeeDetailRepository;
import uz.darkor.darkor_22.response.Data;
import uz.darkor.darkor_22.service.AbstractService;
import uz.darkor.darkor_22.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeDetailServiceImpl extends AbstractService<EmployeeDetailMapper, EmployeeDetailRepository>
        implements EmployeeDetailService {

    public EmployeeDetailServiceImpl(EmployeeDetailMapper mapper,
                                     EmployeeDetailRepository repository) {
        super(mapper, repository);
    }

    @Override
    public EmployeeDetailGetDTO create(EmployeeDetailCreateDTO DTO) {
        EmployeeDetail employeeDetail = mapper.fromCreateDTO(DTO);
        return repository.save(employeeDetail).getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public EmployeeDetailGetDTO update(EmployeeDetailUpdateDTO DTO) {
        EmployeeDetail target = checkUserDetailsExistenceAndGetByCode(DTO.getCode());
        EmployeeDetail employeeDetail = mapper.fromUpdateDTO(DTO, target);
        return repository.save(employeeDetail).getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public Boolean delete(UUID key) {
        return repository.deleteByCode(key);
    }

    @Override
    public EmployeeDetailGetDTO get(UUID key) {
        EmployeeDetail employeeDetail = checkUserDetailsExistenceAndGetByCode(key);
        return employeeDetail.getLocalizationDto(BaseUtils.getSessionLang());
    }

    @Override
    public List<EmployeeDetailGetDTO> list(BaseCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<List<EmployeeDetailGetDTO>>> getAllByEmployee(Long employeeId) {
        Employee employee = employeeService.checkExistenceAndGetById(employeeId);
        EmployeeDetail employeeDetail = repository.findByEmployee(employee)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
        EmployeeDetailDto employeeDetailDto = mapper.toDto(employeeDetail);
        return new ResponseEntity<>(new Data<>(List.of(employeeDetailDto)), HttpStatus.OK);
    }

    public ResponseEntity<Data<List<EmployeeDetailDto>>> getAll(BaseCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<List<EmployeeDetailDto>>> getAll() {
        List<EmployeeDetail> employeeDetails = repository.findAll();
        List<EmployeeDetailDto> employeeDetailDtos = mapper.toDto(employeeDetails);
        return new ResponseEntity<>(new Data<>(employeeDetailDtos), HttpStatus.OK);
    }

    public ResponseEntity<Data<Boolean>> update(EmployeeDetailUpdateDto updateDto) {
        EmployeeDetail target = checkUserDetailsExistenceAndGetByCode(updateDto.getId());
        EmployeeDetail employeeDetail = mapper.fromUpdateDto(updateDto, target);
        repository.save(employeeDetail);
        return new ResponseEntity<>(new Data<>(Boolean.TRUE), HttpStatus.OK);
    }

    public ResponseEntity<Data<Void>> delete(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>(new Data<>(null), HttpStatus.OK);
    }

    private EmployeeDetail checkUserDetailsExistenceAndGetByCode(UUID code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("EMPLOYEE_DETAIL_NOT_FOUND"));
    }


}
