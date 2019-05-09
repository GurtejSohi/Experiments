package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.gurtej.guice.SpellChecker;
import com.gurtej.guice.SpellCheckerImpl;
import com.gurtej.guice.WinWordSpellCheckerImpl;

public class TextEditorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);

        // can chain bindings:
        bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);
    }
}
