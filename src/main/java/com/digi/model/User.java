package com.digi.model;

import com.digi.enums.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;
    private Integer year;
    private String email;
    private String password;
    @Column(name = "verification_code")
    private String verifyCode;
    @Column(name = "reset_token")
    private String resetToken;
    @Enumerated(EnumType.STRING)
    private Status status;
}
