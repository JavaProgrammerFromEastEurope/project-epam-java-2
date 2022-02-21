package by.epam.taskArray.application.specification;

/**
 * @param <T>
 */
@FunctionalInterface
public interface Specification<T> {
    boolean specify(T array);

    default boolean specify(T array, boolean higher) {
        return false;
    }
}
