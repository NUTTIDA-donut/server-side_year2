package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class ProductPageDTO {
    private List<SimpleProductDTO> content;
    private int number;
    private int size;
    private int totalPages;
    private int numberOfElements;
    private int totalElements;
    private boolean last;
    private boolean first;
}