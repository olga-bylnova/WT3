package by.bylnova.archive.server.bean;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;
    private UserRole userRole;
}
