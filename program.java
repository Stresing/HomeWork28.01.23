import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ex0();

    }

    static void ex0() {
        System.out.println("Сколько элементов вы хотите положить в список? ");
        String len = scanner.nextLine();
        List list = new ArrayList<>();
        while (isNum(len) != true) {
            System.out.println("сколько элементов вы хотите положить в список? ");
            len = scanner.nextLine();
        }
        if (isNum(len) == true) {
           list = fillingList(len);
        } else {
            System.out.println("сколько элементов вы хотите положить в список? ");
            list = fillingList(len);
        }
        System.out.println("Изначальный список: " + list);
        System.out.println("конечный список: " + delEvenNumber(list));
        
    }

    static List fillingList(String str) {
        List list = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(str); i++) {
            System.out.println("Вводите числа в список через enter: ");
            String num = scanner.nextLine();
            if (isNum(num) == true) {
                list.add(num);
            } else {
                i--;
            }
        }

        return (List) list;
    }

    static List delEvenNumber(List some_list) {
        for (int i = 0; i < some_list.size(); i++) {
            Object numFromList = some_list.get(i); // Вопрос можно ли этот кусок кода заменить более коротко
            String numFromObject = numFromList.toString(); //  что бы не конвертировать по 10 раз 

            if (Integer.valueOf(numFromObject) % 2 == 0) {
                some_list.remove(i);
                i--;
            }

        }
        return some_list;
    }

    // static void average(List list){
    // }
    public static boolean isNum(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.printf("Введённый вами символ:\'%s\' не число. \n ", str);
            return false;
            // TODO: handle exception

        }
    }

}
