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
 * Набор характеристик.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "group_attributes")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class GroupAttributes {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "attributesSetId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Тип группы харакетристик.
     */
    @Column(name = "groupId")
    private UUID groupId;

    /**
     * Идентификатор родительского набора.
     */
    @Column(name = "attributesSetId")
    private UUID attributesSetId;

}
