package by.epam.java.application;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.StageActionFactory;
import by.epam.java.application.exceptions.StopApplicationException;
import by.epam.java.application.exceptions.WrongStageException;
import by.epam.java.application.utils.Input;

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
        } catch (WrongStageException e) {
            out.println(e.getMessage());
        }
        return getActionStage();
    }
}
