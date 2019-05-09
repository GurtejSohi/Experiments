package com.gurtej.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class MapBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<Integer, String> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, String.class);
        mapBinder.addBinding(2).toInstance("Two");
        mapBinder.addBinding(4).toInstance("Four");
    }
}
