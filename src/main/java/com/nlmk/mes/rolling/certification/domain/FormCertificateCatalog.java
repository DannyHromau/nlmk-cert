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
 * Каталог форм сертификатов.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "catalog_forms")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class FormCertificateCatalog {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "сatalogId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор группы.
     */
    @Column(name = "group_id")
    private UUID groupId;

    /**
     * Идентификатор формы сертификата.
     */
    @Column(name = "certForm")
    private UUID certFormId;

    /**
     * Идентификатор атрибута сертификата.
     */
    @Column(name = "attrId")
    private UUID unitAttrId;

    /**
     * Идентификатор типа сертификата.
     */
    @Column(name = "certType")
    private UUID certTypeId;

}
