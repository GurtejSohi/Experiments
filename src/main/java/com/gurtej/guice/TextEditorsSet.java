package com.gurtej.guice;

import com.google.inject.Inject;

import java.util.Set;

public class TextEditorsSet {

    Set<TextEditor> textEditors;

    @Inject
    public TextEditorsSet(Set<TextEditor> textEditors) {
        this.textEditors = textEditors;
    }

    public void makeSpellChecks() {
        for (TextEditor textEditor : textEditors) {
            textEditor.makeSpellCheck();
        }
    }
}
