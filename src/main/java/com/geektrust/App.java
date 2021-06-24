package com.geektrust;

import com.geektrust.constants.ProjectConstants;
import com.geektrust.service.WinningService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void addKingdomToMap(Set<String> kingdomSet, Map<String,String> sentKingdomMsgMap,String kingdom,String message){

        if (!kingdomSet.contains(kingdom.toUpperCase())){
            sentKingdomMsgMap.put(kingdom.toUpperCase(),message.toLowerCase());
            kingdomSet.add(kingdom.toUpperCase());
        } else {
            sentKingdomMsgMap.remove(kingdom.toUpperCase());
        }
    }

    public static void main(String[] args) throws IOException {

        File file;
        Map<String,String> sentKingdomMsgMap = new LinkedHashMap<>();
        WinningService winningService = new WinningService();
        if(args.length >0){

            String fileName = args[0];
            file = new File(fileName);

            BufferedReader bf = new BufferedReader(new FileReader(file));

            String readLine;
            Set<String> kingdomSet = new HashSet<>();
            while ((readLine = bf.readLine())!=null){

                int firstSpaceIndex = readLine.indexOf(ProjectConstants.SPACE_DELIMITER);
                String kingdom = readLine.substring(0,firstSpaceIndex);
                String message = readLine.substring(firstSpaceIndex+1);
                addKingdomToMap(kingdomSet,sentKingdomMsgMap,kingdom,message);


            }
            winningService.checkSupportForSpaceKingdom(sentKingdomMsgMap);
        }




    }
}
