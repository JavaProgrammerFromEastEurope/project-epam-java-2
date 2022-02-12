package by.epam.java.entity;

public class CustomArray {

    private long id;
    private String name;

    private Object[] array;
    private final int[] statusArray = new int[4];

    public long getId() {
        return id;
    }

    public Object getAverage() {
        return statusArray[0];
    }

    public Object getMax() {
        return statusArray[1];
    }

    public Object getMin() {
        return statusArray[2];
    }

    public Object getQuantity() {
        return statusArray[3];
    }

    public void setAverage(int value) {
        statusArray[0] = value;
    }

    public void setMax(int value) {
        statusArray[1] = value;
    }

    public void setMin(int value) {
        statusArray[2] = value;
    }

    public void setQuantity(int value) {
        statusArray[3] = value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}