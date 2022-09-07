package sit.int204.classicmodelsservice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dtos.ProductPageDTO;
import sit.int204.classicmodelsservice.dtos.SimpleProductDTO;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    @Autowired
    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public ProductPageDTO getAllProduct(int page, int pageSize, String sortBy) {
        return modelMapper.map(repository.findAll(
                        PageRequest.of(page, pageSize, Sort.by(sortBy))),
                ProductPageDTO.class);
    }
    public SimpleProductDTO getProduct(String id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        id + " does't exist !!"));
        return modelMapper.map(product, SimpleProductDTO.class);
    }
}