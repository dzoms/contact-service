package com.dzoms.usercontactservice.contact.controller;

import com.dzoms.usercontactservice.contact.service.UserContactCreateUseCase;
import com.dzoms.usercontactservice.contact.service.UserContactFindUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import transfer.contract.domain.usercontact.UserContactOperationResultTo;
import transfer.contract.domain.usercontact.UserContactTo;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для взаимодействия с пользвоательскими контактами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-contact")
@Tag(name = "UserContactController",
        description = "Контроллер для взаимодействия с пользвоательскими контактами")
@CrossOrigin
public class UserContactController {
    /**
     * Use case для поиска контактов пользователей.
     */
    private final UserContactFindUseCase findUseCase;
    /**
     * Use case для создания контактов пользователей.
     */
    private final UserContactCreateUseCase createUseCase;

    /**
     * Запрос на создание нового пользовательского контакта.
     * @param userId идентификатор пользователя, которого добавляют в контакт.
     * @return результат операции создания
     */
    @PostMapping
    @Operation(summary = "Создать пользовательский контакт")
    @ResponseStatus(HttpStatus.CREATED)
    public UserContactOperationResultTo createUserContact(final @Valid @RequestBody UUID userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return createUseCase.createUserContact(userId, UUID.fromString(authentication.getName()));
    }

    /**
     * Запрос на создание нового пользовательского контакта.
     * @return результат операции создания
     */
    @GetMapping(value = "/{userId}", produces = "application/json")
    @Operation(summary = "Получить пользовательские контакты")
    @ResponseStatus(HttpStatus.OK)
    public List<UserContactTo> getUserContact(@PathVariable final UUID userId) {
        return findUseCase.getAllUserContact(userId);
    }
}
