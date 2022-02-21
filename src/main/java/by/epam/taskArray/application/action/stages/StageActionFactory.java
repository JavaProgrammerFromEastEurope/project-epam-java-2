package by.epam.taskArray.application.action.stages;

import by.epam.taskArray.application.action.IAction;
import by.epam.taskArray.application.action.stages.impl.*;
import by.epam.taskArray.application.exception.WrongValueException;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class StageActionFactory {

    private static final StageActionFactory instance = new StageActionFactory();

    private final Map<Integer, IAction> defaultStage = new HashMap<>();

    public static StageActionFactory getInstance() {
        return instance;
    }

    private StageActionFactory() {
        defaultStage.put(0, new StopApplicationAction());
        defaultStage.put(1, new FirstStageAction());
        defaultStage.put(2, new SecondStageAction());
        defaultStage.put(3, new ThirdStageAction());
        defaultStage.put(4, new FourthStageAction());
        defaultStage.put(5, new FifthStageAction());
    }

    public IAction getActionStage(int index) throws WrongValueException {
        if (defaultStage.containsKey(index)) {
            return defaultStage.get(index);
        }
        throw new WrongValueException(index);
    }

    public void showStageMenu() {
        defaultStage.forEach((key, value) ->
                out.printf("%d - %s%n", key, value.description()));
        out.println("Choose the action you want:");
    }
}
