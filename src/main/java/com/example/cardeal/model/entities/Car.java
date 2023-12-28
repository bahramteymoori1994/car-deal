package com.example.cardeal.model.entities;

import com.example.cardeal.model.enums.CarModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@EntityListeners(AuditingEntityListener.class)
@Table(name = "car")
public class Car extends AbstractBaseEntity
{
    @Column(name = "CAR_NAME", length = 20)
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "COMPANY_NAME", length = 20)
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "CAR_MODEL")
    @Enumerated(value = EnumType.STRING)
    private CarModel carModel;

    @Column(name = "CAR_COUNT")
    private Integer carCount;

    @Column(name = "CAR_BUY_PRICE")
    private Long carBuyPrice;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "DEAL_ID", referencedColumnName = "id")
    private Deal deal;
}