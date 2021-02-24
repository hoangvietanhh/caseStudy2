package methods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTxt {
        public void writeFile(ArrayList<String> list, String path){
            try{
                FileWriter fw = new FileWriter(path);
                StringBuilder result = new StringBuilder();
                for (String str:list) {
                    result.append(str).append("\n");
                }
                fw.write(result.toString());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public ArrayList<String> readFile(String path){
            try{
                ArrayList<String> list = new ArrayList<>();
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line = "";

                while((line = br.readLine())!=null){
                    list.add(line);
                }
                return list;


            } catch (IOException e) {
                return null;
            }
        }
}
