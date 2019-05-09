package com.gurtej.guice;

import com.google.inject.Inject;

public class SpellCheckerImpl implements SpellChecker {

    @Inject
    public SpellCheckerImpl(Integer x) {
        System.out.println(x);
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling of SpellCheckerImpl");
    }
}
