package utils;

import constants.Domains;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@UtilityClass
public class RandomUtils {
    private final int LETTERS_CAPITAL_MIN_ASCII = 65;       // 'A'
    private final int LETTERS_CAPITAL_MAX_ASCII = 90;       // 'Z'
    private final int LETTERS_LOWER_MIN_ASCII = 97;         // 'a'
    private final int LETTERS_LOWER_MAX_ASCII = 122;        // 'z'
    private final int CYRILLIC_LETTERS_MIN_ASCII = 1040;    // 'А'
    private final int CYRILLIC_LETTERS_MAX_ASCII = 1103;    // 'я'
    private final int DIGIT_MIN_ASCII = 48;                 // '0'
    private final int DIGIT_MAX_ASCII = 57;                 // '9'
    private final String SPECIAL_CHARS = "!@#$%&*";
    private final int DEFAULT_STRING_LENGTH = 10;

    public String getRandomAlphabeticString() {
        return getRandomAlphabeticString(DEFAULT_STRING_LENGTH);
    }

    public String getRandomAlphabeticString(int length) {
        return ThreadLocalRandom.current()
                .ints(LETTERS_CAPITAL_MIN_ASCII, LETTERS_LOWER_MAX_ASCII + 1)
                .filter(i -> (i <= LETTERS_CAPITAL_MAX_ASCII || i >= LETTERS_LOWER_MIN_ASCII))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String generatePassword(int length) {
        int requiredSymbolsCount = 6;
        if (length < requiredSymbolsCount) {
            throw new IllegalArgumentException("Password must be at least %d characters long".formatted(requiredSymbolsCount));
        }

        StringBuilder password = new StringBuilder();
        password.append(getRandomChar(LETTERS_CAPITAL_MIN_ASCII, LETTERS_CAPITAL_MAX_ASCII));
        password.append(getRandomChar(LETTERS_LOWER_MIN_ASCII, LETTERS_LOWER_MAX_ASCII));
        password.append(getRandomChar(DIGIT_MIN_ASCII, DIGIT_MAX_ASCII));
        password.append(getRandomChar(SPECIAL_CHARS));
        password.append(getRandomChar(CYRILLIC_LETTERS_MIN_ASCII, CYRILLIC_LETTERS_MAX_ASCII));

        int remainingLength = length - password.length();
        password.append(getRandomAlphabeticString(remainingLength));

        return shuffleString(password.toString());
    }

    public int getRandomInt(int boundExclusive) {
        return ThreadLocalRandom.current().nextInt(boundExclusive);
    }

    public char getRandomChar(int minAscii, int maxAscii) {
        return (char) ThreadLocalRandom.current().nextInt(minAscii, maxAscii + 1);
    }

    public char getRandomChar(String str) {
        return str.charAt(getRandomInt(str.length()));
    }

    public String shuffleString(String input) {
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(characters);
        StringBuilder output = new StringBuilder(input.length());
        characters.forEach(output::append);
        return output.toString();
    }

    public Domains getRandomDomain() {
        Domains[] domains = Domains.values();
        return domains[getRandomInt(domains.length)];
    }
}
