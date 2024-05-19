package com.dzoms.usercontactservice.contact.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

/**
 * Сущнсоть пользовательского контакта.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "user_contact_entity")
@ToString
public class UserContactEntity {

    /**
     * id доски.
     */
    @Id
    @UuidGenerator
    private UUID id;

    /**
     * id первого пользователя.
     */
    @Column(name = "user1_id", nullable = false)
    private UUID user1Id;

    /**
     * id второго пользователя.
     */
    @Column(name = "user2_id", nullable = false)
    private UUID user2Id;

    /**
     * Сравнение 2 объектов через id.
     *
     * @param another объект для сравнения
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        UserContactEntity that = (UserContactEntity) another;
        return Objects.equals(id, that.id);
    }

    /**
     * Хэш-код идентификатора.
     * @return хэш-код идентификатора
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}