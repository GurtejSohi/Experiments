package com.gurtej.guice;

/**
 * Guice will use no args constructor for constructing an object of this class
 */
public class SpellCheckerImpl implements SpellChecker {

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling of SpellCheckerImpl");
    }
}
