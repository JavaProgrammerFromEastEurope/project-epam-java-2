package by.epam.java.application.actions.stages;

import by.epam.java.controller.impl.ServiceController;

public abstract class BaseStageAction {

    public final ServiceController serviceActions;

    public BaseStageAction() {
        this.serviceActions = new ServiceController();
    }
}
