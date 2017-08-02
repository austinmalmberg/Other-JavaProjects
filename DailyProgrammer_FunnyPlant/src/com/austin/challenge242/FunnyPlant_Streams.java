package com.austin.challenge242;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunnyPlant_Streams {
    public static void main(String[] args) {
    	beginSim(200, 15);
    }
    
    public static void beginSim(final Integer people, Integer production) {
    	
        List<Plant_Stream> plants = IntStream.rangeClosed(1, production)
        		.mapToObj(plant -> new Plant_Stream()).collect(Collectors.toList());
        
        while (production < people) {
            plants.forEach(Plant_Stream::addWeek);		// grow plants
            production = plants.stream().mapToInt(Plant_Stream::getFruits).sum();		// get sum of all fruits
            IntStream.rangeClosed(1, production).forEach(p -> plants.add(new Plant_Stream()));  // plant fruits
        }
        
        // return life of oldest plant
        System.out.println(plants.stream().mapToInt(Plant_Stream::getWeek).max().getAsInt());
    }
}

/**
 * A plant that produces 1 more fruit each week.
 * 
 * @author not Austin Malmberg
 *
 */
class Plant_Stream {
    private Integer week;

    Plant_Stream() {
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