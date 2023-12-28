package com.example.cardeal.model.entities;

import com.example.cardeal.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "person")
public class Person extends AbstractBaseEntity
{
    @Column(name = "FIRST_NAME", length = 20)
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    @NotBlank(message = "First name should not be blank")
    @NotNull(message = "First name should not be null")
    private String name;

    @Column(name = "LAST_NAME", length = 20)
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    @NotBlank(message = "Last name should not be blank")
    @NotNull(message = "Last name should not be null")
    private String family;

    @Column(name = "NATIONAL_CODE", length = 10, unique = true)
    @Pattern(regexp = "^\\d{10}$")
    @NotNull(message = "National code should not be null")
    private String nationalCode;

    @Column(name = "EMAIL", length = 50, unique = true)
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "PERSON_ROLE")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "PHONE_NUMBER", length = 11, unique = true)
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]\\d{10}$")
    private String phoneNumber;

    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Car.class)
    @JsonIgnore
    private List<Car> cars;

    @OneToOne(mappedBy = "person", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Deal.class)
    @JsonIgnore
    private Deal deal;
}