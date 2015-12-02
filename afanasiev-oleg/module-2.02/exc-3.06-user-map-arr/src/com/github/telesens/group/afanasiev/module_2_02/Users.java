package com.github.telesens.group.afanasiev.module_2_02;

import java.util.Map;
import java.util.Properties;

/**
 * Created by oleg on 12/2/15.
 */
public class Users {
    private Properties logins;

    public Users() {
        logins = new Properties();
    }

    public String getPassword(String login) {
        return logins.getProperty(login);
    }

    public void setPassword(String login, String password) {
        logins.setProperty(login, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry user : logins.entrySet()) {
            sb.append(String.format("%s -> %s %n", user.getKey(), user.getValue()));
        }

        return sb.toString();
    }
}
