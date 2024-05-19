package com.dzoms.usercontactservice.contact.service;

import com.dzoms.usercontactservice.contact.domain.UserContactRepository;
import com.dzoms.usercontactservice.contact.mapping.UserContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transfer.contract.domain.usercontact.UserContactOperationResultTo;

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
    private final UserContactRepository userContactRepository;

    public UserContactOperationResultTo addUserContact(final UUID userId) {
        return UserContactOperationResultTo.builder().build();
    }
}
