package com.geektrust.service;

import com.geektrust.constants.ProjectConstants;
import com.geektrust.enums.Kingdoms;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WinningService {

    public void checkSupportForSpaceKingdom(Map<String, String> sentKingdomMsgMap) {

        Map<String, String> kingdomEmblemMap = Kingdoms.getKingdomEmblemMap();
        List<String> allyKingdoms = new LinkedList<>();
        for (Map.Entry<String, String> k : sentKingdomMsgMap.entrySet()) {

            StringBuffer sentMsg = new StringBuffer(k.getValue());
            String emblem = kingdomEmblemMap.get(k.getKey());
            boolean isSupporting = checkIsSupporting(emblem, sentMsg);

            if (isSupporting == true) {
                allyKingdoms.add(k.getKey());
            }

        }

        if (!allyKingdoms.isEmpty()) {
            allyKingdoms.add(0, ProjectConstants.SPACE_KINGDOM);

            allyKingdoms.forEach((s) -> {
                System.out.print(s + ProjectConstants.SPACE_DELIMITER);

            });
        }else {
            System.out.println(ProjectConstants.NONE);
        }

    }

    private boolean checkIsSupporting(String emblem, StringBuffer sentMsg) {

        boolean isSupporting = true;
        for (int i = 0; i < emblem.length(); i++) {

            char c = (char) (ProjectConstants.A_CHAR + ((emblem.charAt(i) - ProjectConstants.A_CHAR) + emblem.length()) % ProjectConstants.TOTAL_NUMBER_OF_CHARACTER);

            int ind = sentMsg.indexOf(Character.toString(c));
            if (ind == -1) {
                isSupporting = false;
                break;
            } else {
                sentMsg.setCharAt(ind, '#');
            }

        }

        return isSupporting;
    }
}

