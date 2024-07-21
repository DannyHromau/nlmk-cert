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
 * Единица продукции в сертификате.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "unit_certificate")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class UnitCertificate {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "metalUnitId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор сертификата.
     */
    @Column(name = "certId")
    private UUID certId;

    /**
     * Номер плавки.
     */
    @Column(name = "heat")
    private Integer heat;

    /**
     * Год плавки.
     */
    @Column(name = "heat_year")
    private Integer heatYear;

    /**
     * Номер УНРС.
     */
    @Column(name = "strand")
    private Integer strand;

    /**
     * Номер сляба.
     */
    @Column(name = "slab")
    private Integer slabNum;

    /**
     * Номер горячекатанной партии.
     */
    @Column(name = "hnum")
    private Integer hotRolledBatchNum;

    /**
     * Год горячекатанной партии.
     */
    @Column(name = "hnumYear")
    private Integer hotRolledBatchYear;

    /**
     * Номер рулона.
     */
    @Column(name = "roll")
    private Integer rollNum;

    /**
     * Номер пачки/бунта.
     */
    @Column(name = "bundle")
    private Integer bundleNum;

    /**
     * Номер холоднокатанной партии.
     */
    @Column(name = "tnum")
    private Integer coldRolledBatchNum;

    /**
     * Год холоднокатанной партии.
     */
    @Column(name = "tnumYear")
    private Integer coldRolledBatchYear;

}
