package by.bylnova.archive.server.controller.command.impl;

import by.bylnova.archive.server.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong command sent";
    }
}
