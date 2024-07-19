package com.nlmk.mes.rolling.certification.domain;

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
 * Атрибуты событий.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "events_attributes")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class EventAttributes {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "evenAttrId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор события.
     */
    @Column(name = "eventId")
    private UUID eventId;

    /**
     * Идентификатор сертификата.
     */
    @Column(name = "certId")
    private UUID certId;

    /**
     * Значение атрибута события.
     */
    @Column(name = "attrValue")
    private String eventAttrValue;

}
