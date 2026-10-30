package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import models.EnvConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvConfigReader {
    private final String ENVIRONMENT_PATH = JsonUtils.RESOURCES_PATH + "environment/";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private EnvConfig cachedEnvConfig;

    public EnvConfig getEnvData() {
        if (cachedEnvConfig == null) {
            String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
            cachedEnvConfig = JsonUtils.deserializeJson(envConfigPath, EnvConfig.class);
        }
        return cachedEnvConfig;
    }

    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }
}
