package telran.pomegranate;

import telran.pomegranate.model.Box;
import telran.pomegranate.model.Pomegranate;
import telran.pomegranate.model.Seed;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PomegranateAppl {
    private static final int MIN_BOXES_Q = 100;
    private static final int MAX_BOXES_Q = 200;
    private static final int MIN_BOXES_N = 100;
    private static final int MAX_BOXES_N = 200;
    private static final int MIN_GRANATES = 10;
    private static final int MAX_GRANATES = 20;
    private static final int MIN_SEEDS = 400;
    private static final int MAX_SEEDS = 700;
    private static final int SEED_WEIGHT = 2;

    public static void main(String[] args) {

        List<Box> boxes = getBoxes();



        System.out.println("Total amount of seeds = "+ totalSeeds(boxes));
        System.out.println("Max seeds in a box = "+ maxSeedsInBox(boxes));
        System.out.println("Boxes with maximum seeds: " + boxesWIthMaxSeeds(boxes));

    }

    public static long totalSeeds(List<Box> boxes){
        return boxes.stream()
                .flatMap(Box::stream)
                .flatMap(Pomegranate::stream)
                .count();
    }

    public static long maxSeedsInBox(List<Box> boxes){
        return boxes.stream()
                .mapToLong(box -> box.stream()
                        .flatMap(Pomegranate::stream)
                        .count()
                )
                .max()
                .orElse(0);
    }

    public static List<String> boxesWIthMaxSeeds (List<Box> boxes){
        long maxSeeds = maxSeedsInBox(boxes);

        return boxes.stream()
                .filter(box -> box.stream()
                        .flatMap(Pomegranate::stream)
                        .count() == maxSeeds
                )
                .map(Box::getName)
                .collect(Collectors.toList());
    }






    public static List<Box> getBoxes() {
        return IntStream.rangeClosed(0, getRandomNumber(MIN_BOXES_Q, MAX_BOXES_Q))
                .mapToObj(i -> new Box(String.valueOf(getRandomNumber(MIN_BOXES_N, MAX_BOXES_N)), getGranates()))
                .collect(Collectors.toList());
    }


    private static List<Pomegranate> getGranates() {
        return IntStream.rangeClosed(0, getRandomNumber(MIN_GRANATES, MAX_GRANATES))
                .mapToObj(i -> new Pomegranate(getSeeds()))
                .collect(Collectors.toList());
    }

    private static List<Seed> getSeeds(){
        return IntStream.rangeClosed(0, getRandomNumber(MIN_SEEDS, MAX_SEEDS))
                .mapToObj(i -> new Seed(SEED_WEIGHT))
                .collect(Collectors.toList());
    }


    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1)+min;

    }



}
