
/*    1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
      a + b, a - b, a * b, a / b.
      2. Данные передаются в одну строку (смотри пример)! Решения, в которых каждое число и арифмитеческая операция
        передаются с новой строки считаются неверными.
      3. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
      4. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
        На выходе числа не ограничиваются по величине и могут быть любыми.
      5. Калькулятор умеет работать только с целыми числами.
      6. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
        при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
      7. При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно,
        при вводе арабских - ответ ожидается арабскими.
      8. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
      9. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
         приложение выбрасывает исключение и завершает свою работу.
     10. езультатом операции деления является целое число, остаток отбрасывается.
         Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
         Результатом работы калькулятора с римскими числами могут быть только положительные числа,
         если результат работы меньше единицы, выбрасывается исключение

*/

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два Арабских числа либо две Римские цифры: ");
        String str = scanner.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) throws Exception {

        int num1 = 0;
        int num2 = 0;
        String oper;

        String[] string = input.split("\\W");
        String[] space = input.split("\\w+");
        if (space.length != 2)
            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        String result = null;
        if(roman.isRoman(string[0]) && roman.isRoman(string[1])){
            num1 = roman.convertToArabian(string[0]);
            num2 = roman.convertToArabian(string[1]);
            oper = space[space.length - 1];
            int arabian = calc(num1, num2, oper);
            if(arabian<=0){
                throw new Exception("Римское число не может быть орицательным или равным нулю");
            }
            result = roman.convertToRoman(arabian);

        }

        else if(!roman.isRoman(string[0]) && !roman.isRoman(string[1])) {
            num1 = Integer.parseInt(string[0]);
            num2 = Integer.parseInt(string[1]);
            oper = space[space.length - 1];
            int arabian = calc(num1, num2, oper);
            result = String.valueOf(arabian);
        }

        else{
            throw new Exception("Числа должны быть в одинаковом формате");
        }
        return result;
    }

    static int calc(int x, int y, String oper) throws IOException {
        if (x > 10 || y > 10) {
            throw new IOException("Ошибка! Число должно быть в диапазоне от 1 до 10!");
        }
        switch (oper) {
            case "*":
                return x * y;
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "/":
                return x / y;
            default:

        }
        return 0;
    }

}
class roman {
    static String[] romanNumArray  = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
            "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI",
            "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
            "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
            "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val){
        for (int i = 0; i < romanNumArray.length; i++) {
            if(val.equals(romanNumArray[i])){
                return true;
            }
        }
        return false;
    }
    public static int convertToArabian(String roman){
        for (int i = 0; i < romanNumArray.length; i++) {
            if(roman.equals(romanNumArray[i])){
                return i;
            }
        }
        return -1;
    }
    public static String convertToRoman(int arabian){
        return romanNumArray[arabian];
    }
}
