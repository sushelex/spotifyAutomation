package com.playlists;

import io.cucumber.java.sl.In;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Practice {

    public static void doPrint(String data)
    {
        System.out.println(data);
    }

    public static void main(String[] args)
    {
        List<String> str = List.of("java", "c", "cpp", "azure", "python", "AI");
        str.stream().map(String::toUpperCase).forEach(Practice::doPrint);

        Supplier<String> objRef = ()-> new String();
        Supplier<String> objRefNew = String::new;
    }
    public static void main5(String[] args)
    {
        BiPredicate<Integer, Integer> biPredicate = (x, y)->{

            return x>y&&y<10;
        };
        System.out.println("BiPredicate>>>"+biPredicate.test(10, 5));
        BiFunction<Integer, Integer, String> biFunction = (x, y)->{
          return " "+x+y;
        };
        System.out.println("BiFunction>>>"+biFunction.apply(10, 20));

        BiConsumer<String, String> biConsumer = (x, y)->{
          System.out.println("x's value is>>>"+x);
            System.out.println("y's value is>>>"+y);
        };
        System.out.println("calling BiConsumer function>>>");
        biConsumer.accept("sushil", "kumar");

        BinaryOperator<Integer> binaryOperator = (x, y)->{
            return x+y*y;
        };
        System.out.println("Binary operator>>"+binaryOperator.apply(10, 20));

        IntBinaryOperator intBinaryOperator = (x, y)->{
            return x*x+y;
        };
        System.out.println("IntBinary sum is>>>"+intBinaryOperator.applyAsInt(10, 20));

    }
    public static void main4(String[] RGS)
    {
        List<Integer> l = List.of(10, 20, 30 ,40, 43, 32, 11, 23);
//        Function<Integer, Integer> mappingFunction = x -> x * x;
//        List<Integer> list = mapAndNewList(l, mappingFunction);
//        list.stream().forEach(System.out::println);
        List<Integer> doubleNumber = mapAndNewList(l, x->x+x);
        doubleNumber.stream().forEach(System.out::println);
        Supplier<Integer> supplier  = ()->{
            Random random = new Random();
            return random.nextInt(10);
        };
        System.out.println("output from supplier>>"+supplier.get());

        UnaryOperator<Integer> unaryOperator = (x)->3*x;
        System.out.println("Unary operator output>>"+unaryOperator.apply(20));
    }

    private static List<Integer> mapAndNewList(List<Integer> l, Function<Integer, Integer> mappingFunction) {
        return l.stream().map(mappingFunction).collect(Collectors.toList());
    }

    public static void main3(String[] RGS)
    {
        List<Integer> l = List.of(10, 20, 30 ,40, 43, 32, 11, 23);
        Predicate<Integer> p = x->x%4==0;
        l.stream().filter(p).forEach(System.out::println);
    }
    public static void main2(String [] argd)
    {
        List <Integer> l = List.of(10, 20, 30 ,40, 43, 32, 11, 23);
        printNum(l);
        l.stream().map(a->a+1).sorted().collect(Collectors.toList());
        l.stream().map(a->a+1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        l.stream().map(a->a+1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("print even");
        l.stream().filter(Practice::isEven).forEach(System.out::print);
        System.out.println("use map::"+l.stream().map(a->a+1).reduce(0, Integer::sum));
        System.out.println("filter and map::"+l.stream().filter(a->a%2==0).map(b->b+1).reduce(0, Integer::sum));
        System.out.println("use reduce function");
        System.out.println("sum of list numbers::"+l.stream().reduce(0, (a, b)->a+b));
        System.out.println("other operations x>y::"+l.stream().reduce(0, (x, y) -> x>y?x:y));
        System.out.println("other operations x<y::"+l.stream().reduce(0, (x, y) -> x<y?x:y));


    }

    private static boolean isEven(Integer integer) {
        if(integer%2 == 0)
            return true;
        else return false;
    }

    private static void printNum(List l) {
        l.stream().forEach((System.out::print));
//        l.stream().forEach(Practice::print);
    }

    private static void print(Object o) {
        System.out.println(o);
    }




}
