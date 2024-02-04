package com.digi.dto.requestdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String home;
}
