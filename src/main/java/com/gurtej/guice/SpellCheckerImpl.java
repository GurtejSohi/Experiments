package com.gurtej.guice;

import com.google.inject.Inject;

/**
 * For injection using Guice:
 * "Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private."
 */
public class SpellCheckerImpl implements SpellChecker {

    /**
     * Guice will throw an error: look at it. To get rid of it, uncomment the below line
     */
//    @Inject
    public SpellCheckerImpl(Integer x) {
        System.out.println(x);
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling of SpellCheckerImpl");
    }
}
