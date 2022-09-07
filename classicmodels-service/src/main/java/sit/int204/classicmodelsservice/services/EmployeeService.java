package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.dtos.EmployeeDTO;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.repositories.EmployeeRepository;
import sit.int204.classicmodelsservice.utils.ListMapper;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private ListMapper listMapper;

    public Employee save(EmployeeDTO newEmployee){
        Employee e = modelMapper.map(newEmployee,Employee.class);
        return repository.saveAndFlush(e);
    }
    public List<EmployeeDTO> getEmployees(){
        List<Employee> employeeList = repository.findAll();
        return  listMapper.mapList(employeeList,EmployeeDTO.class,modelMapper);
    }
}
