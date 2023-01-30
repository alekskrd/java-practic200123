package lesson3;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import java.util.*;

public class Main {

    private static final String[] solarSystemPlanets =
            new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    private static Random rand = new Random();


    public static void main(String[] args) {
//        ex0();
//        ex2_1();
//        ex2_2();
//        ex2_3();
        ex2_4();
    }

    private static void ex0() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});


        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(s6));
    }

    public static void ex2_1() {
        List<String> planets = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        for (String planet : solarSystemPlanets) {
            System.out.printf("%s\t%s%n", planet, Collections.frequency(planets, planet));
        }
    }

    private static void ex2_2() {
        List<String> planets = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        Collections.sort(planets);
        System.out.println(planets);

        String prevPlanet = planets.get(0);
        String planet = planets.get(0);
        int count = 1;
        for (int i = 1; i < planets.size(); i++) {
            planet = planets.get(i);
            if (!planet.equals(prevPlanet)) {

                System.out.println(prevPlanet + " " + count);
                prevPlanet = planet;
                count = 0;
            }
            count++;
        }

        System.out.println(planet + " " + count);
    }


    private static void ex2_3() {
        List<String> planets = new ArrayList<>();
        HashMap<String, Integer> planetCount = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        for (String planet : planets) {
            if (planetCount.containsKey(planet)) {
                planetCount.put(planet, planetCount.get(planet) + 1);
            } else {
                planetCount.put(planet, 1);
            }
        }

        for (String planet : planetCount.keySet()) {
            System.out.printf("%s\t%s%n", planet, planetCount.get(planet));
        }
    }

    private static void ex2_4() {
        Multiset<String> planets = HashMultiset.create();

        for (int i = 0; i < 100; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }

        System.out.println(planets);
    }
}
