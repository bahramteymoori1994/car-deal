package com.example.cardeal.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@Setter
@Getter
@ToString
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @CreatedDate
    private Date createdDateTime;

    @LastModifiedDate
    private Date lastModifiedDateTime;
}