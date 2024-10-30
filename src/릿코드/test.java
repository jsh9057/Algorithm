package 릿코드;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class test {
    @FunctionalInterface
    public interface MyInterface<T>{
        void accept(T s);
        static void staticPrint(){ System.out.println("static"); }
        static void defaultPrint(){ System.out.println("default"); }
    }


    public static void main(String[] args) {
        MyInterface myInterface = (s)-> System.out.println(s);
        MyInterface myInterface1 = (s) -> System.out.println("my1:"+s);
        myInterface1.accept("dd");
        myInterface1.accept(1);

        IntBinaryOperator op = (a, b)-> a+b;
        System.out.println(op.applyAsInt(1,2));
        Consumer<String> print = (a)-> System.out.println(a);

        print.accept("hello world");
    }
}
