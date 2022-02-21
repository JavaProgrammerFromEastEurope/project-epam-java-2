package by.epam.taskArray.application.action.stages.impl;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.BaseStageAction;

public class SecondStageAction extends BaseStageAction implements IAction {

    @Override
    public String description() {
        return  "Replacing array elements by condition:\n" +
                "\tCompress the array by throwing out every second element.\n";
    }

    @Override
    public void action() {
        serviceActions.calcSecondFunction();
    }
}
