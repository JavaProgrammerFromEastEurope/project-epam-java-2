package by.epam.java.application.actions.stages.impl;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.BaseStageAction;

public class FifthStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return "Determination the number of positive/negative array elements.\n";
    }

    @Override
    public void action() {
        serviceActions.calcFifthFunction();
    }
}
