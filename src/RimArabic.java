import java.util.InputMismatchException; // Класс создания исключения, поиска ошибки  ввода
import java.util.Scanner;                // Класс, позволяет считать данные с консоли


public class RimArabic {       // Основной класс программы
    static char operation; // создаем статическую арифметическую переменную

    public static void main (String[] args) {  // Основной метод программы, точка входа
        Scanner scanner = new Scanner(System.in); //создаем статический метод Сканнер
        int x1, x2;     // создаем переменные x1, x2
        int result;     // создаем переменную решения

        System.out.println("Введите операцию Арабских чисел в диапазона от 1 до 10");
        System.out.println("Либо два римских числа от I до X ");
        System.out.println("вида - AxB - где 'x' - арифметическая операция и нажмите ВВОД "); // Выводим  построчнй тект на экран консоли, после запуска программы
        String strIn = scanner.nextLine();         // Считываем введеную строку в консоли
        char[] massCh = new char[10];              // создаем пустой символьный массив длинной 10 символов?!
        for (int i = 0; i < strIn.length(); i++) { // создаем цикл считывания строки для определния введеной арифеметической операции
            massCh[i] = strIn.charAt(i);           // Присваеваем в символьный массив символы введеные в консоли?!
            if (massCh[i] == '+') {                // создаем условие "Елси" - в строке введен "+" - произвести операцию сложения
                operation = '+';
            }
            if (massCh[i] == '-') {   // создаем условие "Елси" - в строке введен "-" - произвести операцию вычитания
                operation = '-';
            }
            if (massCh[i] == '*') {    // создаем условие "Елси" - в строке введен "*" - произвести операцию умножения
                operation = '*';
            }
            if (massCh[i] == '/') {    // создаем условие "Елси" - в строке введен "/" - произвести операцию деления
                operation = '/';
            }
        }
        String massChString = String.valueOf(massCh);        // создаем строку, которой присваеваем возвратной значение строки массива?!
        String[] mass = massChString.split("[+-/*]");  // делим строку на части удаляем операцию
        String str1 = mass[0];         // присваеваем первомы элементу массива значение
        String str2 = mass[1];         // присваеваем второму элементу массива значение
        String str3 = str2.trim();     // удаляем пробилы в начале и конце строки
        x1 = rimInNum(str1);           // присваеваем первому введеному числу значние из массива римских чисел, или арабское
        x2 = rimInNum(str3);           // присваеваем второму введеному числу значние из массива римских чисел
        if (x1 < 0 && x2 < 0) {              // создаем условие на проверку введенных чисел "больше 0"
            throw new IllegalArgumentException("Ошибка ввода"); // Если числа меньшк нуля, выдаем ошибку
        } else if(x1 > 10 && x2 > 10) {  // создаем условие на проверку введенных чисел "не больше 10"
            System.out.println("Неверный ввод, только цифры от 1 до 10!"); // вывводим на экран сообщение, если введенные числа больше 10
            throw new IllegalArgumentException("Ошибка ввода"); // выдаем ошибку
        }

        if ((str1.equals("1") || str1.equals("2") || str1.equals("3") || str1.equals("4") || str1.equals("5") || str1.equals("6") || str1.equals("7") || str1.equals("8") || str1.equals("9") || str1.equals("10"))
                && (str3.equals("1") || str3.equals("2") || str3.equals("3") || str3.equals("4") || str3.equals("5") || str3.equals("6") || str3.equals("7") || str3.equals("8") || str3.equals("9") || str3.equals("10")))  {
            result = calc(x1, x2, operation); // создаем условие "Если" где проверяем введенные арабское число от 1 до 10
            System.out.println(result); // вываодим результат для арабских чисел
        } else if((str1.equals("I") || str1.equals("II") || str1.equals("III") || str1.equals("IV") || str1.equals("V") || str1.equals("VI") || str1.equals("VII") || str1.equals("VIII") || str1.equals("IX") || str1.equals("X"))
                && (str3.equals("I") || str3.equals("II") || str3.equals("III") || str3.equals("IV") || str3.equals("V") || str3.equals("VI") || str3.equals("VII") || str3.equals("VIII") || str3.equals("IX") || str3.equals("X"))) {
            result = calc(x1, x2, operation); // создаем условие "Если" где проверяем введенные арабское число от I до X
            String resRim = NumInRim(result);
            System.out.println("Введены римские цифры, ответ: " + resRim); // выводим результат Римских чисел
        } else {
            throw new IllegalArgumentException("Ошибка ввода"); // выдаем ощибку в остальных случаях ввода
        }

    }

    private static String NumInRim (int Arabic) {
        String[] rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };                                   // создаем массив Римских цифр?!
        //  final String rm = rim[Arabic];       // указываем, что введенные значения не могут изменяться
        return rim[Arabic];                           // возвращаем полученное значение
    }


    private static int rimInNum (String rim) { // создаем метод, который перевеодет римские цифры в арабские
        try {                                  // определяем блок кода, где должно проиходить изменение при ввводе
            if (rim.equals("I")) {             // сравниваем введенный символ с "I"
                return 1;                      // символ совпал - возвращаем ему значние "1"
            } else if (rim.equals("II")) {     // сравниваем введенный символ с "II"
                return 2;                      // символ совпал - возвращаем ему значние "2"
            } else if (rim.equals("III")) {    // сравниваем введенный символ с "III"
                return 3;                      // символ совпал - возвращаем ему значние "3"
            } else if (rim.equals("IV")) {     // сравниваем введенный символ с "IV"
                return 4;                      // символ совпал - возвращаем ему значние "4"
            } else if (rim.equals("V")) {      // сравниваем введенный символ с "V"
                return 5;                      // сравниваем введенный символ с "5"
            } else if (rim.equals("VI")) {     // сравниваем введенный символ с "VI"
                return 6;                      // сравниваем введенный символ с "6"
            } else if (rim.equals("VII")) {    // сравниваем введенный символ с "VII"
                return 7;                      // сравниваем введенный символ с "7"
            } else if (rim.equals("VIII")) {   // сравниваем введенный символ с "VIII"
                return 8;                      // сравниваем введенный символ с "8"
            } else if (rim.equals("IX")) {     // сравниваем введенный символ с "IX"
                return 9;                      // сравниваем введенный символ с "9"
            } else if (rim.equals("X")) {      // сравниваем введенный символ с "X"
                return 10;                     // сравниваем введенный символ с "10"
            }
        } catch (InputMismatchException n) {   // ловим ошибку ввода
            throw new InputMismatchException("Ошибка ввода"); // укзываем, что при совершении ошибки ввода, создаем исключение
        }
        return Integer.parseInt(rim);    // Возвращаем арабское число
    }

    public static int calc (int y1, int y2, char op) {  // создаем класс калькулятора
        int result = 0;
        switch (op) {                                   // создаем операцию переключени в зависимости от введеной операции
            case '+':                                   // вариант со сложением
                result = y1 + y2;
                break;
            case '-':
                result = y1 - y2;
                break;
            case '*':
                result = y1 * y2;
                break;
            case '/':
                result = y1 / y2;

                break;
            default:
                throw new IllegalArgumentException("Ошибка ввода"); // выдаем ошибку при неверной операции
        }
        return result;
    }
}