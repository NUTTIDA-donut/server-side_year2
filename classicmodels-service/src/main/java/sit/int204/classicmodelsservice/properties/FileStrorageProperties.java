package sit.int204.classicmodelsservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ConfigurationProperties(prefix = "file")
public class FileStrorageProperties {
    private String uploadDir ;
}
