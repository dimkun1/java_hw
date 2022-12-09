 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class hw2 {
    
    static Logger log;
    
    public static void loging (int switcher, String msg) throws SecurityException, IOException {

        try (FileInputStream ins = new FileInputStream("log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(hw2.class.getName());
            Handler fh  = null;
            fh = new FileHandler("hw2.txt" + "run.log",  1000000, 1, true);
            log.addHandler(fh);
            switch(switcher)
                {
                case 1:
                    log.log(Level.INFO, msg);
                    break;
                case 2:
                    log.log(Level.WARNING, msg);
                    break;
            }
            fh.close();
        }
        catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

	public static void main(String[] args) throws SecurityException, IOException {
    loging (1, "Запуск программы\n");
    int excep = 0;
    while (excep == 0) {
        try{
            excep = main_menu();
        }
        catch (NumberFormatException e) {
            System.out.println ("Ошибка ввода! Повторите! >>>\n");
            loging (2, "Ошибка ввода! Неверный формат!\n");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("Ошибка ввода! Повторите! >>>\n");
            loging (2, "Ошибка ввода! Неверное число элементов!\n");
        }
    }
}

	static String[] inputData() throws SecurityException, IOException {
	    System.out.println (" Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 1 + 2) >>>");
	    Scanner enterData = new Scanner(System.in);
        String data = enterData.nextLine();
        System.out.println();
        String [] data_elem = data.split(" ");
        loging (1,  "Введено значение для подсчёта " + data + "\n");
        return data_elem;
	}
	
	static int calculator (float numOne, float numTwo, String symbol) throws SecurityException, IOException {
	    switch (symbol) {
            case "+":
                loging (1,  "Запуск операции сложения\n");
                System.out.printf ("Сумма чисел %f и %f равна %f\n\n", numOne,numTwo, numOne+numTwo);
                loging (1,  "Успешное сложение\n");
                break;
            case "-":
                loging (1,  "Запуск операции вычитания\n");
                System.out.printf ("Разность чисел %f и %f равна %f\n\n", numOne,numTwo, numOne-numTwo);
                loging (1,  "Успешное вычитание\n");
                break;
            case "*":
                loging (1,  "Запуск операции умножения\n");
                System.out.printf ("Произведение чисел %f и %f равно %f\n\n", numOne,numTwo, numOne*numTwo);
                loging (1,  "Успешное умножение\n");
                break;
            case "/":
                if (numTwo != 0) {
                    loging (1,  "Запуск операции деления\n");
                    System.out.printf ("Частное %f и %f равно %f\n\n", numOne,numTwo, numOne/numTwo);
                    loging (1,  "Успешное деление\n");
                }
                else {
                    loging (2,  "Ошибка запуска операции деления - деление на 0!\n");
                    System.out.println ("Ошибка! На 0 делить нельзя!\n\n");
                }
                break;
            case "%":
                loging (1,  "Запуск нахождения остатка от деления\n");
                System.out.printf ("Остаток от деления числа %f на число %f равно %f\n\n", numOne,numTwo, numOne%numTwo);
                break;
            case "^":
                float result = numOne;
                loging (1,  "Запуск операции возведения в степень\n");
                if (numTwo%1 == 0) {
                    if (numTwo>0) {
                        for (int i = 1; i < numTwo; i++) result*=numOne;
                    }
                    else {
                        for (int i = 1; i < -numTwo; i++) result*=numOne;
                        result = 1/result;
                    }
                    if (numTwo == 0) result = 1;
                    System.out.printf ("Число %f в степени %f равно %f\n\n", numOne,numTwo, result);
                    loging (1,  "Успешное возведение в степень\n");
                }
                else {
                    loging (2,  "Ошибка запуска операции возведения в степень - степень не является целым числом!\n");
                    System.out.println ("Ошибка! Степень должна быть целым числом!\n\n");
                }
                break;
            default:
                loging (2,  "Ошибка выбора действия. Действия " + symbol + " не предусмотрено!\n");
                System.out.print ("Я не знаю такого действия!\n\n");
                break;
	    }
        System.out.printf ("Желаете еще что-нибудь посчитать? >>>\n1 - Повторить операцию с числами %f и %f\n2 - Выполнить новую операцию\n3 - Выход\n\n", numOne, numTwo);
        Scanner answer = new Scanner(System.in);
        loging (1,  "Запрос нового действия\n");
        String user_answ = answer.nextLine();
        int excep = repeat_operation(user_answ, numOne, numTwo);
        return excep;
	}
	
	
	static int main_menu() throws SecurityException, IOException {
    	String [] elements = inputData();
        while (elements.length>3) {
            System.out.printf ("Ошибка ввода! Повторите! >>>\n");
            elements = inputData();
        }
        float num_1 = Float.parseFloat (elements[0]);
        float num_2 = Float.parseFloat (elements[2]);
        int excep = calculator(num_1, num_2, elements[1]);
        return excep;
	}
	
	
	static int repeat_operation (String answ, float numOne, float numTwo) throws SecurityException, IOException {
    switch (answ) {
        case "1":
            loging (1, "Предложение выбора действия с числами\n" + numOne + " и "+ numTwo);
            System.out.println ("Какое действие будем использовать?\nВведите одно из предложенных действий >>>\n\n+ - * / % ^\n");
            Scanner act = new Scanner(System.in);
            System.out.println ();
            String action = act.nextLine();
            loging (1, "Повторная операция с числами\n" + numOne + " и " + numTwo + " - " + action);
            int excep = calculator (numOne, numTwo, action);
            return excep;
        case "2":
            loging (1, "Новый ввод данных\n");
            excep = main_menu();
            return excep;
        case "3":
            loging (1, "Выход по команде пользователя\n");
            System.out.println ("Приходите еще!");
            return 1;
	    default:
	        loging (2, "Выход в результате неверного ввода пользователя\n");
	        System.out.println ("Не понял Вас. Давайте попробуем в следующий раз!");
	        return 1;
        }
	}
}    
    

