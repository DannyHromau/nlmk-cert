package com.nlmk.mes.rolling.certification.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Атрибуты.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "unit_attributes")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class UnitAttributes {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "attrId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор набора атрибутов.
     */
    @Column(name = "attributesSetId")
    private UUID attributesSetId;

    /**
     * Код атрибута.
     */
    @Column(name = "attrCode")
    private UUID attrCode;

    /**
     * Идентификатор единицы измерения.
     */
    @Column(name = "measureId")
    private UUID measureId;

    /**
     * Идентификатор сертификата.
     */
    @Column(name = "certId")
    private UUID certId;

    /**
     * Идентификатор единицы металла в сертификате.
     */
    @Column(name = "metalUnitId")
    private UUID metalUnitId;

    /**
     * Значение атрибута.
     */
    @Column(name = "attrValue")
    private String attrValue;

}
