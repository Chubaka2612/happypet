package com.epam.sdet.happypet.core.common.asserts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * {@code AssertHelper} is collection of useful utility methods that support assertion
 * conditions in tests
 */
public final class AssertHelper {

    private AssertHelper () {

    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void areEqual(Object expected, Object actual, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("Expected: %s; ", expected))
               .append(String.format("Actual: %s;", actual));
        System.out.println(message.toString());
        Assertions.assertEquals(expected, actual, businessContext);
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void areNotEqual(Object expected, Object actual, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("Expected: %s; ", expected))
               .append(String.format("Actual: %s;", actual));
        System.out.println(message.toString());
        Assertions.assertNotEquals(expected, actual, businessContext);
    }

    /**
     * <em>Assert</em> that {@code actual} is null.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void isNull(Object actual, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(("Expected: null; "))
               .append(String.format("Actual: %s;", actual));
        System.out.println(message.toString());
        Assertions.assertNull(actual, businessContext);
    }

    /**
     * <em>Assert</em> that {@code actual} is not null.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void isNotNull(Object actual, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
                .append(String.format("Expected: %s != null; ", actual))
                .append(String.format("Actual: %s;", actual));
        System.out.println(message.toString());
        Assertions.assertNotNull(actual, businessContext);
    }

    /**
     * <em>Assert</em> that {@code condition} is true.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void isTrue(boolean condition, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
                .append(String.format("Expected: %s; ", true))
                .append(String.format("Actual: %s;", condition));
        System.out.println(message.toString());
        Assertions.assertTrue(condition, businessContext);
    }

    /**
     * <em>Assert</em> that {@code condition} is false.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void isFalse(boolean condition, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("Expected: %s; ", false))
               .append(String.format("Actual: %s;", condition));
        System.out.println(message.toString());
        Assertions.assertFalse(condition, businessContext);
    }

    /**
     * <em>Assert</em> that {@code arg1} is less then {@code arg2}.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void less(int arg1, int arg2, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("First value: %s; ", arg1))
               .append(String.format("Second value: %s;", arg2));
        System.out.println(message.toString());
        Assertions.assertTrue(arg1 < arg2, businessContext);
    }

    /**
     * <em>Assert</em> that {@code arg1} is greater then {@code arg2}.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void greater(int arg1, int arg2, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("First value: %s; ", arg1))
               .append(String.format("Second value: %s;", arg2));
        System.out.println(message.toString());
        Assertions.assertTrue(arg1 > arg2, businessContext);
    }

    /**
     * <em>Assert</em> that content of {@code array1} is equal to content of {@code array2}.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static <T> void arraysAreEqual(T [] array1, T [] array2, String businessContext) {
        StringBuilder message = new StringBuilder("Assert: ")
                .append(businessContext).append(".");
        message.append(System.lineSeparator())
               .append(String.format("Expected: %s; ", Arrays.toString(array1)))
               .append(String.format("Actual: %s;", Arrays.toString(array2)));
        System.out.println(message.toString());
        Assertions.assertArrayEquals(array1, array2, businessContext);
    }

    /**
     * <em>Assert</em> that fields values of {@code expected} are equal to fields values of {@code actual}
     * Specific fields that are be compared can be excluded with {@code fieldNamesToExclude}.
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static <T> void fieldsAreEqual(T expected, T actual, String businessContext, List<String> fieldNamesToExclude) {

        Field [] expectedFields = expected.getClass().getDeclaredFields();
        Assertions.assertAll(
                () -> {
                    for(Field field : expectedFields) {
                        if(!Modifier.isPublic(field.getModifiers())) {
                            field.setAccessible(true);
                        }

                        if(Arrays.asList(fieldNamesToExclude).contains(field.getName())) {
                            System.out.println(String.format("Field %s excluded from comparison;", field.getName()));
                            continue;
                        }

                        Object expectedObject = field.get(expected);
                        Object actualObject = field.get(actual);

                        StringBuilder message = new StringBuilder(businessContext);
                        message.append(System.lineSeparator())
                               .append(String.format(" Field: %s; ", field.getName()))
                               .append(String.format(" Expected: %s; ", expectedObject))
                               .append(String.format(" Actual: %s;", actualObject));
                        System.out.println(message.toString());
                        Assertions.assertEquals(expectedObject, actualObject, businessContext);
                    }
                }
        );
    }

    /**
     * <em>Assert</em> all {@code executables}
     * <p>Fails with the supplied failure {@code businessContext}.
     */
    public static void assertAll(String businessContext, Executable... executables) {
        System.out.println(businessContext);
        Assertions.assertAll(executables);
    }
}