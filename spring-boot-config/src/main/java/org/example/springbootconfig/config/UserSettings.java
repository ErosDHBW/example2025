package org.example.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.inject.Named;

@ConfigurationProperties(prefix="my-app.default-user")
@Named
public class UserSettings {
    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
