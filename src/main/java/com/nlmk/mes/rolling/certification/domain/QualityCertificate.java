package com.nlmk.mes.rolling.certification.domain;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * Сертификат качества.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "quality_certificate")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class QualityCertificate {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "certId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Номер сертификата.
     */
    @Column(name = "certNum")
    private Integer certNum;

    /**
     * Год сертификата.
     */
    @Column(name = "certYear")
    private Integer certYear;

    /**
     * Дата создания сертификата.
     */
    @Column(name = "certDate")
    private LocalDate certDate;

    /**
     * Код цеха.
     */
    @Column(name = "workshopCode")
    private Integer workshopCode;

    /**
     * Идентификатор типа сертификата.
     */
    @Column(name = "certType")
    private UUID certType;

    /**
     * Номер заказа, связанного с сертификатом.
     */
    @Column(name = "orderNum")
    private Long orderNum;

    /**
     * Номер позиции заказа.
     */
    @Column(name = "orderPos")
    private Integer orderPos;

    /**
     * Год исполнения заказа.
     */
    @Column(name = "orderYear")
    private Integer orderYear;

    /**
     * Идентификатор типа заказа.
     */
    @Column(name = "orderType")
    private UUID orderType;

    /**
     * Ключ QR code.
     */
    @Column(name = "certQR")
    private String certQR;

    /**
     * Ссылка на QR code.
     */
    @Column(name = "certQRLink")
    private String certQRLink;

    /**
     * Идентификатор бланка сертификата.
     */
    @Column(name = "cert_form")
    private UUID certForm;

    /**
     * Идентификатор статуса в справочнике.
     */
    @Column(name = "statusID")
    private UUID statusId;
}
