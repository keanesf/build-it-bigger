package com.udacity.gradle.builditbigger.backend;

import com.keanesf.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private JokeProvider jokeProvider;

    public JokeBean() {
        jokeProvider = new JokeProvider();
    }
    public String getJoke() {
        return jokeProvider.getRandomJoke();
    }
}