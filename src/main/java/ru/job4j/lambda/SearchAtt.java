package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > size;
            }
        };
        return filter(predicate, list);
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(name);
            }
        };
        return filter(predicate, list);
    }

    public static List<Attachment> filter(Predicate<Attachment> predicate, List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13),
                new Attachment("image 4", 2),
                new Attachment("image 5", 1009),
                new Attachment("image 6", 76),
                new Attachment("image 6", 1103),
                new Attachment("image 7", 56)
        );
        System.out.println(filterSize(attachments, 50));
        System.out.println();
        System.out.println(filterName(attachments, "6"));
    }
}