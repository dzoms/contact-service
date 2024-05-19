package com.dzoms.usercontactservice.contact.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий {@link UserContactEntity}
 */
public interface UserContactRepository extends JpaRepository<UserContactEntity, UUID> {

}
