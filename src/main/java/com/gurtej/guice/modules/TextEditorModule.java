package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.gurtej.guice.SpellChecker;
import com.gurtej.guice.SpellCheckerImpl;
import com.gurtej.guice.WinWordSpellCheckerImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Provides
    Map<Integer, List<Integer>> getMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(237, Arrays.asList(2, 3, 7));
        map.put(491, Arrays.asList(4, 9, 1));
        return map;
    }
}
