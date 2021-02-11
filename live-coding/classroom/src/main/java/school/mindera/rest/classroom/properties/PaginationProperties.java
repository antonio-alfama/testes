package school.mindera.rest.classroom.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "school.classroom.pagination")
public class PaginationProperties {

    private Integer defaultPage;
    private Integer resultsPerPage;

}
