import java.util.Scanner;

public class StartClass {
    public static void main(String[] args){
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.println("Введите одну из комманд: ");
            String num = in.nextLine();

            if (num.equals("Прочитать  список 1")){
                Vocabulary.getVoc(1);
            } else if (num.equals("Прочитать  список 2")){
                Vocabulary.getVoc(2);
            } else if (num.equals("Удалить запись по ключу")){
                System.out.println("Ввведите ключ: ");
                num = in.nextLine();
                Vocabulary.delVal(num);
            } else if (num.equals("Найти запись по ключу")) {
                System.out.println("Ввведите ключ: ");
                num = in.nextLine();
                Vocabulary.findVal(num);
            } else if (num.equals("Добавить запись")){
                System.out.println("Введите ключ-значение через пробел");
                num = in.nextLine();
                Vocabulary.setVoc(num);
            } else if (num.equals("Выход")) {
                break;
            } else {
                System.out.println("Комманда не найдена");
            }
        }


    }
}
