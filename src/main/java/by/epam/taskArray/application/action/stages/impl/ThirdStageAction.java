package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.BaseStageAction;

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
