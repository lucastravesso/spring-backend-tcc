package com.system.backend.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    @GeneratedValue(generator = "UUID")
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "Insertion_Date")
    private LocalDate insertionDate;

    @Column(name = "Inactivation_Date")
    private LocalDate inactivationDate;
}
