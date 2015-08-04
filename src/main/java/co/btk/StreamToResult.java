//package co.btk;
//
//import sun.nio.ch.sctp.ResultContainer;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Objects;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.function.UnaryOperator;
//import java.util.stream.Stream;
//
///**
// * REFERENCE:
// *      http://www.dotnetperls.com/lambda-java
// *            // http://stackoverflow.com/questions/22382453/java-8-streams-flatmap-method-example
//        https://books.google.co.uk/books?id=2QfzBgAAQBAJ&pg=PA63&lpg=PA63&dq=Stream.of+string%5B%5D&source=bl&ots=mbhxDw1xfR&sig=sLpQsdJHkbUZRdPZeiJLc4klkw0&hl=en&sa=X&ved=0CEUQ6AEwBmoVChMIusiXgfSCxwIVgklyCh0gIw67#v=onepage&q=Stream.of%20string%5B%5D&f=false
// */
//public class StreamToResult {
//
//    // "flatMap" is a functional structure that takes in a container of containers, and produces a single flat container
//    // with all the elements of all the containers.
//
//    public static void main(String[] args) {
//        StreamToResult lesson = new StreamToResult();
//        lesson.runExercises();
//    }
//
//    public void runExercises() {
//        System.out.println("JDK 8 Lambda class types");
//        System.out.println("Running function...");
//        exampleFunction();
//        System.out.println("Running supplier...");
//        exampleSupplier();
//        System.out.println("Running predicate...");
//        examplePredicate();
//        System.out.println("Running consumer...");
//        exampleConsumer();
//        System.out.println("Running unaryOperator...");
//        exampleUnaryOperator();
//        System.out.println("Running unaryOperator with replaceAll...");
//        exampleReplaceAllUsingUnaryOperator();
//        System.out.println("Running lamba performance comparison...");
//        examplePerformance();
//    }
//
//    private void exampleFunction() {
//
//        // Create a Function from a lambda expression. Input and Return types defined.
//        Function<Integer, Integer> func = x -> x * 2;
//        int result = func.apply(10);
//        System.out.println("example1 - function in action: " + result);
//    }
//
//    private void exampleSupplier() {
//
//        // A Supplier provides values. Call get() on it to retrieve its value.
//        // Pass lambdas to the display method... These conform to the Supplier class.
//        display(() -> 10);
//        display(() -> 100);
//        display(() -> (int) (Math.random() * 100));
//    }
//
//    static void display(Supplier<Integer> arg) {
//        System.out.println(arg.get());
//    }
//
//    private void examplePredicate() {
//
//        // Predicate is a boolean returning method
//        ArrayList<String> list = new ArrayList<>();
//        list.add("cat");
//        list.add("dog");
//        list.add("cheetah");
//        list.add("deer");
//
//        list.removeIf(element -> element.startsWith("c"));
//        System.out.println(list.toString());
//    }
//
//    private void exampleConsumer() {
//
//        // Consumer acts upon a value but returns nothing
//        Consumer<Integer> consumer = x -> display(x - 1);
//
//        // Use the consumer with three numbers.
//        consumer.accept(1);
//        consumer.accept(2);
//        consumer.accept(3);
//    }
//
//    static void display(int value) {
//
//        switch (value) {
//            case 1:
//                System.out.println("There is 1 value");
//                return;
//            default:
//                System.out.println("There are " + Integer.toString(value) + " values");
//                return;
//        }
//    }
//
//    private void exampleUnaryOperator() {
//
//        // This returns one value of the same type as its one parameter.
//        UnaryOperator<Integer> operator = v -> v * 100;
//
//        // This is a generalized form of UnaryOperator. Essentially the same.
//        Function<Integer, Integer> function = v -> v * 100;
//
//        System.out.println(operator.apply(5));
//        System.out.println(function.apply(6));
//
//    }
//
//    private void exampleReplaceAllUsingUnaryOperator() {
//
//        // Add ten to each element in the ArrayList.
//        // "forEach" method on ArrayList does not change element values.
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.replaceAll(element -> element + 10);
//        System.out.println(list);
//    }
//
//    private void exampleBiConsumer() {
//
//        // BiConsumer is a functional object that receives two parameters.
//        HashMap<String, String> hash = new HashMap<>();
//        hash.put("cat", "orange");
//        hash.put("dog", "black");
//        hash.put("snake", "green");
//
//        hash.forEach((string1, string2) -> System.out.println(string1 + "..."
//                + string2 + ", " + string1.length()));
//    }
//
//    private void examplePerformance() {
//
//        // Lambdas are not super performant.
//
//        Function<Integer, Integer> function = element -> element + 1;
//
//        long t1 = System.currentTimeMillis();
//
//        // Version 1: apply a function specified as a lambda expression.
//        for (int i = 0; i < 10000000; i++) {
//            int result = function.apply(i);
//        }
//
//        long t2 = System.currentTimeMillis();
//
//        // Version 2: call a static method.
//        for (int i = 0; i < 10000000; i++) {
//            int result = methodForExample(i);
//        }
//
//        long t3 = System.currentTimeMillis();
//
//        // ... Benchmark results.
//        System.out.println(t2 - t1);
//        System.out.println(t3 - t2);
//    }
//
//    static int methodForExample(int element) {
//        return element + 1;
//    }
//
//
//    public class ResultMap<T> implements Function<Result<T>, Stream<T>> {
//
//        private final Consumer<Exception> exceptionHandler;
//
//        public ResultMap(final Consumer<Exception> exceptionHandler) {
//            Objects.requireNonNull(exceptionHandler, "exception handler");
//            this.exceptionHandler = exceptionHandler;
//        }
//
//        @Override
//        public Stream<T> apply(final Result<T> resultContainer) {
//            if (resultContainer == null) Stream.empty();
//
//            // first arg - what to do with exceptions
//            // second arg - what to do with results
//            return resultContainer.map(error -> {
//                    exceptionHandler.accept(error);
//                    return Stream.empty();
//                }, Stream::of
//            );
//        }
//
//    }
//
//}
//
