package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.repositories.OfficeRepository;
import sit.int204.classicmodelsservice.services.OfficeService;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeRepository repository;

    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office> getOffices() {
        return repository.findAll();
    }

    @GetMapping("/{officeCode}")
    public Office getOffice(@PathVariable String officeCode) {
        return service.getOffice(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployees(@PathVariable String officeCode) {
        Office office = repository.findById(officeCode).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        officeCode + "does not exist !!!"));
        return office.getEmployees();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office create(@RequestBody Office newOffice) {
        return repository.saveAndFlush(newOffice);
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode) {
        repository.findById(officeCode).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, officeCode + " does not exost !!!")
        );
        repository.deleteById(officeCode);
    }

    @PutMapping("/{officeCode}")
    public Office update(@RequestBody Office updateOffice, @PathVariable String officeCode){
        Office office = repository.findById(officeCode).map(o -> mapOffice(o, updateOffice))
                .orElseGet(() ->
                {
                    updateOffice.setId(officeCode);
                    return updateOffice;
                });
        return repository.saveAndFlush(office);
    }


    private Office mapOffice(Office existingOffice, Office updateOffice) {
        existingOffice.setAddressLine1(updateOffice.getAddressLine1());
        existingOffice.setAddressLine2(updateOffice.getAddressLine2());
        existingOffice.setCity(updateOffice.getCity());
        existingOffice.setCountry(updateOffice.getCountry());
        existingOffice.setPhone(updateOffice.getPhone());
        existingOffice.setPostalCode(updateOffice.getPostalCode());
        existingOffice.setState(updateOffice.getState());
        existingOffice.setTerritory(updateOffice.getTerritory());
        return existingOffice;
    }
}
