package utils;

import lombok.experimental.UtilityClass;
import models.EmailData;

@UtilityClass
public class TestDataReader {
    private final String TEST_DATA_PATH = JsonUtils.RESOURCES_PATH + "testData/";
    private final String EMAIL_DATA_FILE_PATH = TEST_DATA_PATH + "emailData.json";

    public EmailData getEmailData() {
        return JsonUtils.deserializeJson(EMAIL_DATA_FILE_PATH, EmailData.class);
    }
}
