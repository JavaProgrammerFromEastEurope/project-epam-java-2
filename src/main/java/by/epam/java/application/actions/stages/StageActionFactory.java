package by.epam.java.application.actions.stages;

import by.epam.java.application.actions.IAction;
import by.epam.java.application.actions.stages.impl.*;
import by.epam.java.application.exceptions.WrongStageException;

import java.util.HashMap;

import static java.lang.System.out;

public class StageActionFactory {

    private final HashMap<Integer, IAction> defaultStage = new HashMap<>();

    private static final StageActionFactory instance = new StageActionFactory();

    private StageActionFactory() {
        defaultStage.put(0, new StopApplicationAction());
        defaultStage.put(1, new FirstStageAction());
        defaultStage.put(2, new SecondStageAction());
        defaultStage.put(3, new ThirdStageAction());
        defaultStage.put(4, new FourthStageAction());
        defaultStage.put(5, new FifthStageAction());
    }

    public static StageActionFactory getInstance() {
        return instance;
    }

    public IAction getActionStage(int index) throws WrongStageException {
        if (defaultStage.containsKey(index)) {
            return defaultStage.get(index);
        }
        throw new WrongStageException(index);
    }

    public void showStageMenu() {
        defaultStage.forEach((key, value) ->
                out.printf("%d - %s%n", key, value.description()));
        out.println("Choose the action you want:");
    }
}
