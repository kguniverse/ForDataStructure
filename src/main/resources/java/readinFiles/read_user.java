package readinFiles;

import DS.common.Edge;
import DS.common.Node;
import DS.common.Schedule;
import DS.common.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class read_user {
    public static ArrayList<User> user;
    public static Map<String, User> user_map;
    public read_user() {
        try {
            String filePath = "src/main/resources/java/readinFiles/user.txt";
            FileInputStream fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String strTmp = "";
            while((strTmp = buffReader.readLine())!=null){
                User us = new User();
                user.add(us);
                us.setID(strTmp);
                strTmp = buffReader.readLine();
                user_map.put(us.getID(), us);
                us.setPass(strTmp);
                String tem = strTmp;
                for(int i = 0; i < Integer.parseInt(tem); i++) {
                    Schedule sch = new Schedule();
                    strTmp = buffReader.readLine();
                    sch.setTime(strTmp);
                    strTmp = buffReader.readLine();
                    sch.setEvent(strTmp);
                    strTmp = buffReader.readLine();
                    sch.setSite(strTmp);
                    us.setSchedule(sch);
                }
                System.out.println(strTmp);
            }
            buffReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
