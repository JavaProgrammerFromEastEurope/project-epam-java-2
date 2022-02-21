package by.epam.taskArray.entity;

public abstract class ParameterArray {

    protected Number[] array;

    public ParameterArray(Number[] array) {
        this.array = array;
    }

    public Number[] getArray() {
        return array;
    }
}
