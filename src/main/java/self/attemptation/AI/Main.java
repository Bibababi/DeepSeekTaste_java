package self.attemptation.AI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello, DeepSeek!");
        System.out.println("=================================================================");
        DeepSeekClient client = new DeepSeekClient();


        while(true) {

            System.out.print("【我】---------------------------------\n");
            String prompt = br.readLine();
            if(prompt.equalsIgnoreCase("exit")) {break;}

            try {
                String respons;
                respons = client.sendRequest(prompt);
                Pattern p = Pattern.compile("(?<=\"content\":\").*?(?=\"})");
                Matcher m = p.matcher(respons);
                System.out.println("【DeepSeek】-----------------------------");
                while (m.find()) {
                    String content = m.group();
                    //content=content.replace("\"","");
                    String[] contentArray = content.split("\\\\n");
                    for (String s : contentArray) {
                        System.out.println(s);
                    }
                    //System.out.println(content);
                }

                //System.out.println(respons);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("");
        }




    }
}
