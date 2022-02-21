package by.epam.taskArray.application;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.StageActionFactory;
import by.epam.taskArray.application.exception.StopApplicationException;
import by.epam.taskArray.application.exception.WrongValueException;
import by.epam.taskArray.application.util.Input;

import static java.lang.System.out;

public class Application {

    static final StageActionFactory stageFactory
                    = StageActionFactory.getInstance();

    public static void startEntertainment() {
        out.println("Welcome! Entertainment has become!");
        actionStages();
    }

    private static void actionStages() {
        while (true) try {
            getActionStage().action();
        } catch (StopApplicationException e) {
            break;
        }
    }

    private static IAction getActionStage() {
        stageFactory.showStageMenu();
        int index = Input.anyIntInitialize();
        try {
            return stageFactory.getActionStage(index);
        } catch (WrongValueException e) {
            out.println(e.getMessage());
        }
        return getActionStage();
    }
}
