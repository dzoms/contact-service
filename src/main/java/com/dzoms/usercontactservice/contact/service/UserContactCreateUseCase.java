package com.dzoms.usercontactservice.contact.service;

import com.dzoms.usercontactservice.contact.domain.UserContactEntity;
import com.dzoms.usercontactservice.contact.domain.UserContactRepository;
import com.dzoms.usercontactservice.contact.mapping.UserContactMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transfer.contract.domain.common.OperationStatus;
import transfer.contract.domain.usercontact.UserContactOperationErrorCode;
import transfer.contract.domain.usercontact.UserContactOperationResultTo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Use case создания пользовательского контакта.
 */
@Service
@RequiredArgsConstructor
public class UserContactCreateUseCase {
    /**
     * Маппер для пользовательских контактов.
     */
    private final UserContactMapper mapper;
    /**
     * Репозиторий пользовательских контактов.
     */
    private final UserContactRepository repository;

    /**
     * Запрос на создание нового пользовательского контакта.
     *
     * @param user1Id идентификатор 1 пользователя
     * @param user2Id идентификатор 2 пользователя
     * @return результат операции создания
     */
    @Transactional
    public UserContactOperationResultTo createUserContact(final UUID user1Id, final UUID user2Id) {
        var resultTo = UserContactOperationResultTo.builder().build();

        if (user1Id.equals(user2Id)) {
            return resultTo.toBuilder()
                    .status(OperationStatus.FAILED)
                    .errors(List.of(UserContactOperationResultTo.BoardOperationErrorTo.builder()
                            .Id(null)
                            .errorCode(UserContactOperationErrorCode.USER_ADDS_HIMSELF)
                            .build()))
                    .build();
        }

        Optional<UserContactEntity> contact = repository.findUserContactEntityByUser1IdAndUser2Id(user1Id, user2Id);

        if (contact.isPresent()) {
            return resultTo.toBuilder()
                    .status(OperationStatus.FAILED)
                    .errors(List.of(UserContactOperationResultTo.BoardOperationErrorTo.builder()
                            .Id(contact.get().getId())
                            .errorCode(UserContactOperationErrorCode.USER_CONTACT_ALREADY_EXIST)
                            .build()))
                    .build();
        }

        UserContactEntity entity = UserContactEntity.builder()
                .user1Id(user1Id)
                .user2Id(user2Id)
                .build();
        repository.save(entity);

        return resultTo;
    }
}
