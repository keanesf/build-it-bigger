package com.keanesf;

import java.util.Random;

public class JokeProvider {

    private String[] jokes;
    private Random random;

    public JokeProvider() {
        jokes = new String[6];
        jokes[0] = "How many programmers does it take to change a light bulb? None – It’s a hardware problem";
        jokes[1] = "There are only 10 kinds of people in this world: those who know binary and those who don’t.";
        jokes[2] = "Programming is 10% science, 20% ingenuity, and 70% getting the ingenuity to work with the science.";
        jokes[3] = "The generation of random numbers is too important to be left to chance.";
        jokes[4] = "I just saw my life flash before my eyes and all I could see was a close tag…";
        jokes[5] = "The computer is mightier than the pen, the sword, and usually, the programmer.";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

}
