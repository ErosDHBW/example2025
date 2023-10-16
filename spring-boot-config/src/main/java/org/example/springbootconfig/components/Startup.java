package org.example.springbootconfig.components;

import org.example.springbootconfig.config.UserSettings;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
class Startup {
    Logger log = LoggerFactory.getLogger(Startup.class);

    @Value("${my-app.welcome-text}")
    private String welcomeText;

    final private UserSettings userSettings;

    @Inject
    Startup(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    @PostConstruct
    public void doStartup() {
        log.info("Starting up! " + welcomeText);
        log.info("Welcome user " + userSettings);
    }

}
