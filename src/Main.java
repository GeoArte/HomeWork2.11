import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        Stream<Integer> stream = Stream.of(1, 3, 4, 6, 7, 9);
        Comparator<Integer> order = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max) -> {
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        };
        findMinMax(stream, order, minMaxConsumer);
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(9);
        list.add(8);
        list.add(2);
        HowManyIntegers(list);
    }

    public static <T> void findMinMax(
    Stream <? extends T> stream,
    Comparator <? super T> order,
    BiConsumer <? super T, ? super T> minMaxConsumer)
    {
        List<T> list = stream.collect(Collectors.toList());
        if (list.size() == 0)
        {
            minMaxConsumer.accept(null, null);
        }
        else
        {
            T min = (T) list.stream().min(order).orElse(null);
            T max = (T) list.stream().max(order).orElse(null);
            minMaxConsumer.accept(min, max);
        }
    }
    public static void HowManyIntegers(List<Integer> list)
    {
        Predicate<Integer> predicate = (a) -> a%2 == 0;
        int count = (int) list.stream().filter(predicate).count();
        System.out.println("Количество чётных числел в списке :" + count);
    }
}

