package com.dzoms.usercontactservice.contact.service;

import com.dzoms.usercontactservice.contact.domain.UserContactEntity;
import com.dzoms.usercontactservice.contact.domain.UserContactRepository;
import com.dzoms.usercontactservice.contact.mapping.UserContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transfer.contract.domain.usercontact.UserContactTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Use case создания пользовательского контакта.
 */
@Service
@RequiredArgsConstructor
public class UserContactFindUseCase {
    /**
     * Маппер для пользовательских контактов.
     */
    private final UserContactMapper mapper;
    /**
     * Репозиторий пользовательских контактов.
     */
    private final UserContactRepository repository;

    /**
     * Получение всех контактов пользователей.
     *
     * @param userId идентификатор пользователя, который должен быть в контактах
     * @return список контактов пользователя
     */
    public List<UserContactTo> getAllUserContact(UUID userId) {
        List<UserContactEntity> contactEntities = repository.findAllUserContact(userId);
        return contactEntities.stream()
                .map(mapper::mapFromEntity).toList();
    }
}
