package com.dzoms.usercontactservice.contact.controller;

import com.dzoms.usercontactservice.contact.service.UserContactCreateUseCase;
import com.dzoms.usercontactservice.contact.service.UserContactFindUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transfer.contract.domain.usercontact.UserContactOperationResultTo;

import java.util.UUID;

/**
 * Контролелр для взаимодействия с пользвоательскими контактами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-contact")
@Tag(name = "UserContactController",
        description = "Контролелр для взаимодействия с пользвоательскими контактами")
public class UserContactController {
    /**
     * Use case для поиска контактов пользователей.
     */
    private final UserContactFindUseCase findUseCase;
    /**
     * Use case для создания контактов пользователей.
     */
    private final UserContactCreateUseCase createUseCase;

    @PostMapping
    @Operation(summary = "Добавить пользователя в контакты")
    @ResponseStatus(HttpStatus.CREATED)
    public UserContactOperationResultTo addUserContact(final @Valid @RequestBody UUID userId) {
        return createUseCase.addUserContact(userId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
