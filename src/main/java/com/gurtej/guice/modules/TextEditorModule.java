package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.gurtej.guice.SpellChecker;
import com.gurtej.guice.SpellCheckerImpl;
import com.gurtej.guice.WinWordSpellCheckerImpl;

public class TextEditorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);

        // can chain bindings:
        bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);

        // can install another guice module inside a guice module
        install(new MapBinderModule());

        /**
         * Only to demonstrate (see documentation of {@link MapBinder} for details):
         * "Contributing mapbindings from different modules is supported"
         */
        MapBinder<Integer, String> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, String.class);
        mapBinder.addBinding(1).toInstance("One");
        mapBinder.addBinding(3).toInstance("Three");
    }
}
