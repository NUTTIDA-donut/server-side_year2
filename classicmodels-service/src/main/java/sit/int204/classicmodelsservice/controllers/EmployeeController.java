package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dtos.EmployeeDTO;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.repositories.OfficeRepository;
import sit.int204.classicmodelsservice.services.EmployeeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @Autowired
    private OfficeRepository officeRepo;

    @GetMapping("")
    public List<EmployeeDTO> getAllEmployee(){
        return service.getEmployees();
    }


    @PostMapping("")
    public Employee create(@RequestBody EmployeeDTO newEmployee) {
        return service.save(newEmployee);
    }
}
