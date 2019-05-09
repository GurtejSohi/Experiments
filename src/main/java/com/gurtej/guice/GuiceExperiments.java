package com.gurtej.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.gurtej.guice.modules.TextEditorModule;

public class GuiceExperiments {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor editor = injector.getInstance(TextEditor.class);
        editor.makeSpellCheck();
    }
}

