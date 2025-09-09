package avanis.my.account.portlet.utils;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final String ONE_LOWERCASE = "(?=.*[a-z])";
    private static final String ONE_UPPERCASE = "(?=.*[A-Z])";
    private static final String ONE_DIGIT = "(?=.*\\d)";
    private static final String ONE_SYMBOL = "(?=.*[-!\"#\\$%&()*,./:;?@\\[\\]^_`{|}~+<=>])";
    private static final String REGEX_MIN_LENGTH = ".{" + MIN_LENGTH + ",}";
    private static final String REGEX_PASSWORD_VALIDATE = "^" + ONE_DIGIT + ONE_LOWERCASE + ONE_UPPERCASE + ONE_SYMBOL + REGEX_MIN_LENGTH + "$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PASSWORD_VALIDATE);


    public static boolean validate(String password) {
        boolean isValid = PATTERN.matcher(password).matches();

        return isValid;
    }

}

