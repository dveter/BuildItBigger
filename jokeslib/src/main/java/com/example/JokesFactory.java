package com.example;

import java.util.Random;

public class JokesFactory {

    private final String[] jokesArray = {
    "How many programmers does it take to change a light bulb?\n" +
    "None – It’s a hardware problem",

    "Why do programmers always mix up Halloween and Christmas? \n" +
    "- Because Oct 31 equals Dec 25.",

    "Whats the object-oriented way to become wealthy?\" \n" +
    "- Inheritance"
    };

    public String getJoke(){
        int idx = new Random().nextInt(jokesArray.length);
        return jokesArray[idx];
    }
}
