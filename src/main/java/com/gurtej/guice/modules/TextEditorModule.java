package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.gurtej.guice.SpellChecker;
import com.gurtej.guice.SpellCheckerImpl;

public class TextEditorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);
    }
}
