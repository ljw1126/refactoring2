package com.example.refactoring2.ch01;

import java.util.Map;

public class Plays {
    private final Map<String, Play> playMap;

    public Plays(Map<String, Play> playMap) {
        this.playMap = playMap;
    }

    public Play get(String playId) {
        return playMap.get(playId);
    }
}
