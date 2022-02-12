package by.epam.java.application.actions.stages.impl;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.BaseStageAction;

public class ThirdStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return "Determining the average value of array elements.\n";
    }

    @Override
    public void action() {
        serviceActions.calcThirdFunction();
    }
}
