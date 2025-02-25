package com.dillian.initiateservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SupervisorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String biography;
}
