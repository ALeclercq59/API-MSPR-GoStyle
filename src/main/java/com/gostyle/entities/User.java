package com.gostyle.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String mail;
    private String password;
    private String name;
    private String surname;

    @ManyToMany(mappedBy="users", fetch=FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnoreProperties("users")
    private List<Coupon> coupons;
}
