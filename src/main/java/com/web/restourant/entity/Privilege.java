package com.web.restourant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Privilege", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Privilege extends BaseEntity {

    @Column(length = 64)
    private String name;
}
