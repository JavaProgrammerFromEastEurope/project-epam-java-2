package by.epam.taskArray.entity;

public class StatusArray extends ParameterArray {

    public StatusArray() {
        this(new Number[4]);
    }

    private StatusArray(Number[] statusArray) {
        super(statusArray);
    }

    public double getAverage() {
        return (double) super.array[0];
    }

    public void setAverage(double value) {
        super.array[0] = value;
    }

    public int getMax() {
        return (int) super.array[1];
    }

    public void setMax(int value) {
        super.array[1] = value;
    }

    public int getMin() {
        return (int) super.array[2];
    }

    public void setMin(int value) {
        super.array[2] = value;
    }

    public int getQuantity() {
        return (int) super.array[3];
    }

    public void setLength(int value) {
        super.array[3] = value;
    }
}
