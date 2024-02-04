package com.digi.dto.requestdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer year;
    private String email;
    private String password;
}
