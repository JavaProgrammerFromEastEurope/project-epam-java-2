package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.exception.StopApplicationException;

public class StopApplicationAction implements IAction {

    @Override
    public String description() {
        return "Exit From Application\n";
    }

    @Override
    public void action() throws StopApplicationException {
        throw new StopApplicationException();
    }
}
