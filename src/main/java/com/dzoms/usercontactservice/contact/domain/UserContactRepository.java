package com.dzoms.usercontactservice.contact.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий {@link UserContactEntity}
 */
public interface UserContactRepository extends JpaRepository<UserContactEntity, UUID> {
    Optional<UserContactEntity> findUserContactEntityByUser1IdAndUser2Id(UUID user1Id, UUID user2Id);

    @Query("SELECT u FROM UserContactEntity u WHERE u.user1Id = :userId OR u.user2Id = :userId")
    List<UserContactEntity> findAllUserContact(@Param("userId") UUID userId);
}
