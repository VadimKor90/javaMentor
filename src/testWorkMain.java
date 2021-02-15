import java.io.BufferedReader;
import java.io.InputStreamReader;

public class testWorkMain {

    static testWorkCalculate testworkcalculate = new testWorkCalculate(); // обращаемся к классу для обработки данных

    public static String inPut() throws Exception{
        int Count = 0; //для подсчета пробелов, если больше 2, завершение программы
        String operation;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        operation = bufferedReader.readLine();

        try{
            for(int i = 0; i < operation.length(); i++) {
                if(Character.isWhitespace(operation.charAt(i))) {      //считаем количество пробелов
                    Count++;
                    if ((Count == 1) && Character.isWhitespace(operation.charAt(i+1))){  //проверка на наличие 2ух пробелов подряд
                        throw new StringIndexOutOfBoundsException("Вы ввели данные не по ТЗ, должно быть 2 пробела, пример: a + b");
                    }
                }
            }

            if (Count == 2){
                return operation;
            }
            else throw new StringIndexOutOfBoundsException("Вы ввели данные не по ТЗ, должно быть 2 пробела, пример: a + b ");
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return "Завершение работы программы";
    }    //ввод выражения и проверка на пробелы

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        String[] words = inPut().split(" ");

        int a, b;
        try {
            if (words[0].equals(" ")){
                throw new StringIndexOutOfBoundsException("Вы ввели данные не по ТЗ, должно быть 2 пробела, пример: a + b ");
            }
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println();
            System.exit(0);
        }



        char x1 = words[0].charAt(0);
        char x2 = words[2].charAt(0);

        String operand = words[1];

        try {
            if ((operand.equals("+")) || (operand.equals("-")) || (operand.equals("*")) || (operand.equals("/"))){

                if (!Character.isDigit(x1) && !Character.isDigit(x2)) {
                    System.out.println(testworkcalculate.intForConvertRome(testworkcalculate.calculateRomeForConvertInt(operand, words[0], words[2])));
                }

                else if (Character.isDigit(x1) && Character.isDigit(x2)) {
                    try {

                        a = Integer.parseInt(words[0]);
                        b = Integer.parseInt(words[2]);

                        try {
                            if ((a < 0 || a > 10) || (b < 0 || b > 10)) {
                                throw new NullPointerException("Вы ввели число не входящее в диапозон от 1 до 10");
                            }
                            else System.out.println(testworkcalculate.calculateInt(operand,a,b));
                        }

                        catch (NullPointerException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }
                    catch (NumberFormatException e) {
                        System.out.println("Вы ввели данные не по ТЗ, введите целое арабское число");
                    }
                }

                else throw new NumberFormatException("Вы ввели арабские и римские цифры одновремено");
            }
            else throw new Exception("Вы ввели не арифметические операцию");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
