package com.austin.challenge.e242_new;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunnyPlant {
    public static void main(String[] args) {
    	beginSim(200, 15);
    }
    
    public static void beginSim(final Integer people, Integer production) {
    	
        List<Plant> plants = IntStream.rangeClosed(1, production)
        		.mapToObj(plant -> new Plant()).collect(Collectors.toList());
        
        while (production < people) {
            plants.forEach(Plant::addWeek);		// grow plants
            production = plants.stream().mapToInt(Plant::getFruits).sum();		// get sum of all fruits
            IntStream.rangeClosed(1, production).forEach(p -> plants.add(new Plant()));  // plant fruits
        }
        
        // return life of oldest plant
        System.out.println(plants.stream().mapToInt(Plant::getWeek).max().getAsInt());
    }
}

/**
 * A plant that produces 1 more fruit each week.
 * 
 * @author not Austin Malmberg
 *
 */
class Plant {
    private Integer week;

    Plant() {
        week = 1;
    }

    public void addWeek() {
        week++;
    }

    public Integer getWeek() {
        return week;
    }

    public Integer getFruits() {
        return week - 1;
    }
}
