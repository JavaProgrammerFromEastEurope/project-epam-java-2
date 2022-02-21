package by.epam.taskArray.application.action.stages;

import by.epam.taskArray.controller.impl.ServiceController;

public abstract class BaseStageAction {

    public final ServiceController serviceActions;

    public BaseStageAction() {
        this.serviceActions = new ServiceController();
    }
}
