package com.gurtej.guice;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class WinWordSpellCheckerImpl extends SpellCheckerImpl {

    @Inject
    public WinWordSpellCheckerImpl(Map<Integer, List<Integer>> map) {
        super(42);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : [");
            for (Integer i : entry.getValue()) {
                System.out.print(i + ", ");
            }
            System.out.println("]");
        }
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling." );
    }
}