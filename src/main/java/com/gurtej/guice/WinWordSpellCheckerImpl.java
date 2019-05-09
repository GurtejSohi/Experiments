package com.gurtej.guice;

public class WinWordSpellCheckerImpl extends SpellCheckerImpl {

    public WinWordSpellCheckerImpl() {
        super(42);
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling." );
    }
}