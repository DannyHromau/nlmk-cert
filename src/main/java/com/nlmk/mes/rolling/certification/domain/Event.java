package com.nlmk.mes.rolling.certification.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * События.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "events")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Event {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "eventId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор статуса в справочнике.
     */
    @Column(name = "statusId")
    private UUID eventStatusId;

    /**
     * Идентификатор сертификата.
     */
    @Column(name = "certId")
    private UUID certId;

    /**
     * Дата начала события.
     */
    @Column(name = "dateBeginEvent")
    private ZonedDateTime dateBeginEvent;

    /**
     * Дата конца события.
     */
    @Column(name = "dateEndEvent")
    private ZonedDateTime dateEndEvent;
}
