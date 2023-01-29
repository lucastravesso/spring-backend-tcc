package com.system.backend.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractPersistenceEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @Type(type = "uuid-char")
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "Insertion_Date")
    private LocalDate insertionDate;

    @Column(name = "Inactivation_Date")
    private LocalDate inactivationDate;
}
