package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository repository;

    public SimpleCustomerDTO getSimpleCustomerById(Integer id){
        Customer customer = repository.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer id " + id  + "Does Not Exist !!!"
        ));
        return modelMapper.map(customer,SimpleCustomerDTO.class);


//// no Model Mapper
//        return repository.findById(id).map(customer -> convertEntityToDTO(customer))
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND , id + " Does Not Exists !!!"));
    }



//    private SimpleCustomerDTO convertEntityToDTO(Customer customer){
//        SimpleCustomerDTO simpleCustomerDTO = new SimpleCustomerDTO();
//        simpleCustomerDTO.setCustomerName(customer.getCustomerName());
//
//        simpleCustomerDTO.setSalesPerson(customer.getSalesRepEmployee().getLastName());
//        return simpleCustomerDTO;
//    }
}


