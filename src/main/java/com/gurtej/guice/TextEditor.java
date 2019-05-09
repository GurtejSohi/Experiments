package com.gurtej.guice;

import com.google.inject.Inject;

import java.util.Map;

public class TextEditor {
    private SpellChecker spellChecker;

    /**
     * @param spellChecker
     * @param map only for demonstrating use of MapBinder
     */
    @Inject
    public TextEditor(SpellChecker spellChecker, Map<Integer, String> map) {
        this.spellChecker = spellChecker;
        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", val: " + v);
        });
    }

    public void makeSpellCheck() {
        spellChecker.checkSpelling();
    }
}
