public class testWorkCalculate {

    public  int calculateInt(String operand, int a, int b){
        switch (operand) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

    public  int calculateRomeForConvertInt(String operand, String a, String b) {

        int numberForConvert1 = 0;
        int numberForConvert2 = 0;

        int values = 0;

        for (int i = 0; i < a.length(); i++)
        {
            char test1 = a.charAt( i );
            int values1 = romeValues( test1 );
            try{
                if ( values1 == 0)
                {
                    throw new NumberFormatException("Введено задание не по ТЗ, римская цифра содержит лишний элемент или его нет");
                }
            }
            catch (NumberFormatException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }

            if (forConv1 < values1)
                values1 = values1 - forConv1 - 1;
            numberForConvert1 = numberForConvert1 + values1;
            forConv1 = numberForConvert1;

        }

        for (int i = 0; i < b.length(); i++) {
            char test2 = b.charAt(i);
            int values2 = romeValues(test2);
            try {
                if (values2 == 0) {
                    throw new NumberFormatException("Введено задание не по ТЗ, римская цифра содержит лишний элемент или его нет");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            if (forConv2 < values2)
                values2 = values2 - forConv2 - 1;
            numberForConvert2 = numberForConvert2 + values2;
            forConv2 = numberForConvert2;
        }

        try {
            if ((numberForConvert1 < 0 || numberForConvert1 > 10) || (numberForConvert2 < 0 || numberForConvert2 > 10)) {
                throw new NullPointerException("Вы ввели число не входящее в диапозон от I до X");
            }
        }

        catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        values = calculateInt(operand, numberForConvert1, numberForConvert2);

        try{
            if ((values <= 0)){
                throw new NumberFormatException("Ваша римская цифра <= 0");
            }
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        return values;
    }   // перевод римских цифр в арабские

    public  int romeValues (char rome){

        switch (rome) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            default:   return 0;
        }
    } //Данные по римским цифрам для проверки и конвертации

    public  String intForConvertRome (int values){

        String endValues = "";
        int valuesIn = values;

        while (valuesIn > 0){      // пока значение больше 0, из цикла не выйдет
            for (int i = 0; i < intValues.length; i++)
            {
                if ( valuesIn < intValues[i] )
                {
                    valuesIn = valuesIn - intValues[i-1];
                    endValues = endValues + romesValues[i-1];
                    break;
                }
            }
        }


        return endValues;
    }

    static int intValues[]  = {1, 4, 5, 9, 10, 50, 100, 500};    // массив для конвертации

    static String romesValues[]  = { "I", "IV", "V", "IX", "X", "L", "C", "D"};   // массив для рассчета значения на выход метода intForConvertRome

    static int forConv1 = 1000, forConv2 = 1000;
}
