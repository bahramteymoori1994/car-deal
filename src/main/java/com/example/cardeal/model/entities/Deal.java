package com.example.cardeal.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
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
@Table(name = "deal")
public class Deal extends AbstractBaseEntity
{
    @Column(name = "COUNT_STUFF")
    private Integer count;

    @Column(name = "REGISTERED_DATE_TIME")
    @CreationTimestamp
    private Date registeredDateTime;

    @OneToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
    private Person person;

    @OneToMany(mappedBy = "deal", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Car.class)
    @JsonIgnore
    private List<Car> cars;

    @Column(name = "SELL_PRICE")
    private Long sellPrice;
}