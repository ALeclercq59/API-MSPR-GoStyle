package com.gostyle.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coupon;

    private String libelle;
    private String description;
    private LocalDate date_end;
    private Long compteur;
    private Long info;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "avoir",
            joinColumns = @JoinColumn(name = "id_coupon"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    @ToString.Exclude
    @JsonIgnoreProperties("coupon")
    @JsonIgnore
    private List<User> users;
}
