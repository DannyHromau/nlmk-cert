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
 * Пользователи.
 *
 * @author Daniil Hromau
 */
@Data
@Table(name = "users")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class User {

    /**
     * ID записи.
     */
    @Id
    @Column(name = "userId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    /**
     * Идентификатор пользователя из сервиса авторизации (sub).
     */
    @Column(name = "authorizationUserId")
    private UUID authorizationUserId;

    /**
     * Имя пользователя.
     */
    @Column(name = "userName")
    private String username;

    /**
     * Идентификатор должности.
     */
    @Column(name = "postId")
    private UUID positionId;

    /**
     * Имя.
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * Фаимлия.
     */
    @Column(name = "surname")
    private String lastName;

    /**
     * Отчество.
     */
    @Column(name = "middleName")
    private String patronymic;

}
