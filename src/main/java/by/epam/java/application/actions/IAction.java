package by.epam.java.application.actions;

import by.epam.java.application.exceptions.StopApplicationException;

public interface IAction {
    String description();
    void action() throws StopApplicationException;
}
