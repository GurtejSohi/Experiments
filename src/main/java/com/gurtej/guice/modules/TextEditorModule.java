package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import com.gurtej.guice.SpellChecker;
import com.gurtej.guice.SpellCheckerImpl;
import com.gurtej.guice.TextEditor;
import com.gurtej.guice.WinWordSpellCheckerImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextEditorModule extends AbstractModule {

    @Override
    protected void configure() {

        /**
         * {@link Multibinder} and {@link MapBinder} are quite similar as both of them are used to inject a collection
         * of elements. The only diff. is that Multibinder is used to inject a Set of elements whereas MapBinder
         * is used to inject a Map.
         */
        Multibinder<TextEditor> textEditorMultibinder = Multibinder.newSetBinder(binder(), TextEditor.class);

        /**
         * demonstrates use of {@link Key} and {@link PrivateModule}
         */
        for (int i = 0; i < 3; i++) {
            Key<TextEditor> textEditorKey = Key.get(TextEditor.class, Names.named(String.valueOf(i)));

            int finalI = i;
            install(new PrivateModule() {
                @Override
                protected void configure() {
                    if (finalI % 2 == 0) {
                        bind(SpellChecker.class).to(SpellCheckerImpl.class);
                        bind(Integer.class).annotatedWith(Names.named("X")).toInstance(finalI);
                    } else {
                        bind(SpellChecker.class).to(WinWordSpellCheckerImpl.class);
                    }
                    bind(textEditorKey).to(TextEditor.class);
                    expose(textEditorKey);
                }
            });

            textEditorMultibinder.addBinding().to(textEditorKey);
        }

        TextEditor textEditorInstance = new TextEditor(
                new SpellCheckerImpl(10052019),
                new HashMap<>());
        textEditorMultibinder.addBinding().toInstance(textEditorInstance);


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
