package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> stream;

    private EasyStream(List<Integer> source) {
        stream = new ArrayList<>(source);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        if (!stream.isEmpty()) {
            List<Integer> mappedList = new ArrayList<>();
            for (var element : stream) {
                mappedList.add(fun.apply(element));
            }
            return new EasyStream(mappedList);
        }
        return null;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        if (!stream.isEmpty()) {
            List<Integer> filteredList = new ArrayList<>();
            for (var element : stream) {
                if (fun.test(element)) {
                    filteredList.add(element);
                }
            }
            return new EasyStream(filteredList);
        }
        return null;
    }

    public List<Integer> collect() {
        return stream;
    }

}