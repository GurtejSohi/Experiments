package com.gurtej.guice;

import com.google.inject.Inject;

import javax.inject.Named;

public class SpellCheckerImpl implements SpellChecker {

    @Inject
    public SpellCheckerImpl(@Named("X") Integer x) {
        System.out.println(x);
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling of SpellCheckerImpl");
    }
}
