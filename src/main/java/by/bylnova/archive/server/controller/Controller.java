package by.bylnova.archive.server.controller;

import by.bylnova.archive.server.controller.command.Command;
import by.bylnova.archive.server.controller.command.CommandProvider;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        char paramDelimiter = ' ';
        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
