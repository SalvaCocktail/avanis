package avanis.utils.api.util;

public interface AvanisUtils {

    String sanitizeInput(String input);

    String sanitizeInputSimpleText(String input);

    boolean deleteMessage(long userId, long messageId);

    boolean updateMessage(long userId, long messageId, String newMessage);
}
