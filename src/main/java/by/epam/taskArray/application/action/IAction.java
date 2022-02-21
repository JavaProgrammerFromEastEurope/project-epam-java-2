package by.epam.taskArray.application.action;

import by.epam.taskArray.application.exception.StopApplicationException;

public interface IAction {
    String description();

    void action() throws StopApplicationException;
}
