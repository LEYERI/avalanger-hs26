package ch.zhaw.avalanger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Document("avalanges")
public class Avalange {
    @Id
    private String id;
    private String country;
    private String state;
    private String description;
}
