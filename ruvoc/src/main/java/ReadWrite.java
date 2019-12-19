import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReadWrite {
    public static ArrayList<String> vocRead(String path) {
        ArrayList<String> listVoc = new ArrayList<String>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            while ((line = reader.readLine()) != null) {
                listVoc.add(line);
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Файл не найден");
        }
        return listVoc;
    }
    public static void vocWrite(String path, ArrayList<String> listVoc) {
        try{
            FileWriter writer = new FileWriter(path);
            for(String s : listVoc){
                writer.write(s+"\n");
            }
            writer.close();
        }catch (Exception e) {
            System.out.println("Файл не найден");
        }
    }
}
