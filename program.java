import java.io.StreamCorruptedException;
import java.util.*;
import java.util.stream.IntStream;

public class program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    ex0();
    }

    static void ex1() { //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()
        System.out.println("Какой длины заполнить список ?: ");
        int n = scanner.nextInt();
        Random random = new Random();
        List<Integer> listEx1 = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            listEx1.add(random.nextInt(100));
        }
        System.out.println("Изначальный список: " + listEx1);
        System.out.println("Максимальное значение в списке: " +
                Collections.max(listEx1));
        System.out.println("Минимальное значение в списке: " +
                Collections.min(listEx1));
        average(listEx1);
    }

    static void ex0() { //Пусть дан произвольный список целых чисел, удалить из него четные числа
        List listEx0 = new ArrayList<Integer>();
        listEx0 = fullFillingList();
        System.out.println("Изначальный список: " + listEx0);
        System.out.println("Конечный список: " + delEvenNumber(listEx0));

    }

    static void average(List <Integer>list) {
        double sum = 0;
        
        for (int i = 0; i < list.size(); i++) {
            sum = sum +list.get(i);
        }
        double averageList =sum/list.size();
       System.out.println("Среднее арифметическое = "+ averageList);
        
    }

    static List fullFillingList() {
        System.out.println("Сколько элементов вы хотите положить в список? ");
        String len = scanner.nextLine();
        List list = new ArrayList<Integer>();
        while (isNum(len) != true) {
            System.out.println("Сколько элементов вы хотите положить в список? ");
            len = scanner.nextLine();
        }
        if (isNum(len) == true) {
            list = fillingList(len);
        } else {
            System.out.println("Сколько элементов вы хотите положить в список? ");
            list = fillingList(len);
        }
        return (List) list;

    }

    static List fillingList(String str) { // Хотел добавить во внутрь fullFillingList однако от туда fillingList
                                          // отказывался работать
        List list = new ArrayList<Integer>();
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

    static List delEvenNumber(List someList) {
        for (int i = 0; i < someList.size(); i++) {
            Object numFromList = someList.get(i); // Вопрос можно ли этот кусок кода заменить более коротко
            String numFromObject = numFromList.toString(); // что бы не конвертировать по 10 раз

            if (Integer.valueOf(numFromObject) % 2 == 0) {
                someList.remove(i);
                i--;
            }

        }
        return someList;
    }

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
