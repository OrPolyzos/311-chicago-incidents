package com.uoa.di.csr.model.validation;

public class RegexPatterns {

    /**
     * Regex pattern
     **/
    public static final String REGEX_START = "^[";
    public static final String REGEX_END = "]";
    public static final String ENG_ALPHABET_LOWER_CASE = "a-z";
    public static final String ENG_ALPHABET_UPPER_CASE = "A-Z";
    public static final String NUMBERS = "0-9";
    public static final String ALPHANUMERICAL = ENG_ALPHABET_LOWER_CASE + ENG_ALPHABET_UPPER_CASE + NUMBERS;
    public static final String PASSWORD_SYMBOLS = "@#$%^&";
    public static final String ROLES_REGEX = "^(ADMIN|USER)";
    /**
     * Messages
     **/
    public static final String CANNOT_BE_EMPTY_MESSAGE = "Cannot be empty";
    public static final String CAN_BE_ONE_OF_THE_AVAILABLE_CHOICES = "Can be only one of the available choices";
    public static final String BETWEEN_6_16_MESSAGE = "Can be 6-16 characters long";
    public static final String BETWEEN_1_128_MESSAGE = "Can be 1-128 characters long";
    public static final String ENG_ALPHABET_MESSAGE = "Can contain only " + ENG_ALPHABET_LOWER_CASE + ", " + ENG_ALPHABET_UPPER_CASE;
    public static final String ALPHANUMERICAL_MESSAGE = "Can contain only " + ENG_ALPHABET_LOWER_CASE + ", " + ENG_ALPHABET_UPPER_CASE + ", " + NUMBERS;
    public static final String PASSWORD_MESSAGE = "Can contain only " + ENG_ALPHABET_LOWER_CASE + ", " + ENG_ALPHABET_UPPER_CASE + ", " + NUMBERS + ", " + PASSWORD_SYMBOLS;
    public static final String EMAIL_ADDRESS_MESSAGE = "Invalid email address";

}
