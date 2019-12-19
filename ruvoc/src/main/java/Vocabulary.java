import java.util.ArrayList;

public class Vocabulary {

   public static void getVoc(int numVoc){
       ArrayList<String> listVoc = ReadWrite.vocRead("Voc" + numVoc + ".txt");
       for(String s : listVoc){
           System.out.println(s);
       }
   }

   public static void setVoc (String line) {
       String[] keyVal = line.split(" ");
       if(keyVal[1].length()==5){
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc2.txt");
           listVoc.add(line);
           ReadWrite.vocWrite("Voc2.txt",listVoc);
       } else if (keyVal[1].length()==4) {
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc1.txt");
           listVoc.add(line);
           ReadWrite.vocWrite("Voc1.txt",listVoc);
       }
   }

   public static void delVal(String key) {
       if(isString(key)){
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc1.txt");
           for(String s : listVoc){
               String[] keyVal = s.split(" ");
               if(keyVal[0].equals(key)){
                   listVoc.remove(s);
                   ReadWrite.vocWrite("Voc1.txt",listVoc);
                   break;
               }
           }
       } else {
           Integer.parseInt(key);
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc2.txt");
           for(String s : listVoc){
               String[] keyVal = s.split(" ");
               if(keyVal[0].equals(key)){
                   listVoc.remove(s);
                   ReadWrite.vocWrite("Voc2.txt",listVoc);
                   break;
               }
           }
       }

   }

    private static boolean isString(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

   public static void findVal(String key) {
       if(isString(key)){
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc1.txt");
           for(String s : listVoc){
               String[] keyVal = s.split(" ");
               if(keyVal[0].equals(key)){
                   System.out.println(keyVal[1]);
                   break;
               }
           }
       } else {
           Integer.parseInt(key);
           ArrayList<String> listVoc = ReadWrite.vocRead("Voc2.txt");
           for(String s : listVoc){
               String[] keyVal = s.split(" ");
               if(keyVal[0].equals(key)){
                   System.out.println(keyVal[1]);
                   break;
               }
           }
       }

   }
}
