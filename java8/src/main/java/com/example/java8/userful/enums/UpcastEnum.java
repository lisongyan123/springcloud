package com.example.java8.userful.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class UpcastEnum {

    enum Search { HITHER,YON}

    enum Size {
        Small,
        Medium,
        Large;

        @Override
        public String toString() {
            String id = name();
            String lower = id.substring(1).toLowerCase();
            return id.charAt(0) + lower;
        }
    }

    public static void main(String[] args) {
        /**
         * HITHER
         * YON
         */
        Arrays.stream(Search.HITHER.getClass().getEnumConstants()).forEach(System.out::println);

        System.out.println("---------------------- 分割线 ---------------------");

        /**
         * Small
         * Medium
         * Large
         */
        Stream.of(Size.values()).forEach(System.out::println);

        System.out.println("---------------------- 分割线 ---------------------");

        /**
         * Map entry: Small=0.8
         * Map entry: Medium=1.0
         * Map entry: Large=1.2
         */
        Map<Size, Double> map = new EnumMap<Size, Double>(Size.class);
        map.put(Size.Small, 0.8);
        map.put(Size.Medium, 1.0);
        map.put(Size.Large, 1.2);
        map.entrySet().stream().forEach(System.out::println);
    }
}
