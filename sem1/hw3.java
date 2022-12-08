package sem1;


import java.util.Scanner;



public class hw3
{
    public static void main(String[] args) {
    int excep = 0;
    while (excep == 0) {
        try{
            excep = main_menu();
        }
        catch (NumberFormatException e) {
            System.out.println ("Ошибка ввода! Повторите! \n");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("Ошибка ввода! Повторите! \n");
        }
    }
}
        
	static String[] inputData() {
	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 1 + 2)");
	    Scanner enterData = new Scanner(System.in);
            String data = enterData.nextLine();
            String [] data_elem = data.split(" ");
            return data_elem;
	}
	
	static int calculator (float numOne, float numTwo, String symbol) {
	    switch (symbol) {
            case "+":
                System.out.printf ("Сумма чисел %f и %f равна %f", numOne,numTwo, numOne+numTwo);
                break;
            case "-":
                System.out.printf ("Разность чисел %f и %f равна %f", numOne,numTwo, numOne-numTwo);
                break;
            case "*":
                System.out.printf ("Произведение чисел %f и %f равно %f", numOne,numTwo, numOne*numTwo);
                break;
            case "/":
                if (numTwo != 0) {
                    System.out.printf ("Частное %f и %f равно %f", numOne,numTwo, numOne/numTwo);
                }
                else {
                    System.out.println ("Ошибка! На 0 делить нельзя!");
                }
                break;
            case "%":
                System.out.printf ("Остаток от деления числа %f на число %f равно %f", numOne,numTwo, numOne%numTwo);
                break;
            case "^":
                float result = numOne;
                if (numTwo%1 == 0) {
                    if (numTwo>0) {
                        for (int i = 1; i < numTwo; i++) result*=numOne;
                    }
                    else {
                        for (int i = 1; i < -numTwo; i++) result*=numOne;
                        result = 1/result;
                    }
                    if (numTwo == 0) result = 1;
                    System.out.printf ("Число %f в степени %f равно %f", numOne,numTwo, result);
                }
                else {
                    System.out.println ("Ошибка! Степень должна быть целым числом!");
                }
                break;
            default:
                System.out.print ("Я не знаю такого действия!");
                break;
	    }
        System.out.printf ("\n\nЖелаете еще что-нибудь посчитать? \n1 - Повторить операцию с числами %f и %f\n2 - Выполнить новую операцию\n3 - Выход\n", numOne, numTwo);
        Scanner answer = new Scanner(System.in);
        String user_answ = answer.nextLine();
        int excep = repeat_operation(user_answ, numOne, numTwo);
        return excep;
	}
	
	
	static int main_menu() {
    	String [] elements = inputData();
        while (elements.length>3) {
            System.out.printf ("Ошибка ввода! Повторите! \n");
            elements = inputData();
        }
        float num_1 = Float.parseFloat (elements[0]);
        float num_2 = Float.parseFloat (elements[2]);
        int excep = calculator(num_1, num_2, elements[1]);
        return excep;
	}
	
	
	static int repeat_operation (String answ, float numOne, float numTwo) {
    switch (answ) {
        case "1":
            System.out.println ("Какое действие будем использовать?\nВведите одно из предложенных действий\n+ - * / % ^\n");
            Scanner act = new Scanner(System.in);
            String action = act.nextLine();
            int excep = calculator (numOne, numTwo, action);
            return excep;
        case "2":
            excep = main_menu();
            return excep;
        case "3":
            System.out.println ("До свидания!");
            return 1;
	    default:
	        System.out.println ("Ошибка. Попробуйте в следующий раз!");
	        return 1;
        }
	}
}