package by.epam.java.specifications;

@FunctionalInterface
public interface ISpecification<T> {
    boolean specify(T array);
    default boolean specify(T array, boolean higher) {
        return false;
    }
}
