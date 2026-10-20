package ch.zhaw.avalanger.model;

import lombok.Getter;

@Getter
public class AvalangeCreateDTO {
    private String country;
    private String description;

    public AvalangeCreateDTO(String country, String description) {
        this.country = country;
        this.description = description;
    }
}
