package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.repositories.OfficeRepository;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository repository;

    public Office getOffice(String officeCode) {
        return repository.findById(officeCode).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, officeCode + " does not exist !!!"));
    }
}
