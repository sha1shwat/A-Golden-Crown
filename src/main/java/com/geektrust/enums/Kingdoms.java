package com.geektrust.enums;

import java.util.HashMap;
import java.util.Map;

public enum Kingdoms {

    AIR("AIR","Owl"),
    SPACE("SPACE","Gorilla"),
    LAND("LAND","Panda"),
    WATER("WATER","Octopus"),
    ICE("ICE","Mammoth"),
    FIRE("FIRE","Dragon");

    String kingdomName;
    String emblem;

    Kingdoms(String kingdomName, String emblem) {
        this.kingdomName = kingdomName;
        this.emblem = emblem;
    }



    static Map<String,String> kingdomEmblemMap = new HashMap<>();
    static {

        for (Kingdoms k : Kingdoms.values()){

            kingdomEmblemMap.put(k.kingdomName, k.emblem.toLowerCase());
        }
    }

    public static Map<String, String> getKingdomEmblemMap() {
        return kingdomEmblemMap;
    }
}

