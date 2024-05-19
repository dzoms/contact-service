package transfer.contract.domain.usercontact;

import lombok.Builder;

import java.util.UUID;

/**
 * To-класс для пользовательского контакта.
 *
 * @param id идентификатор контакта
 * @param user1Id идентификатор 1 пользователя
 * @param user2Id идентификатор 2 пользователя
 */
@Builder(toBuilder = true)
public record UserContactTo(UUID id, UUID user1Id, UUID user2Id) {
}
