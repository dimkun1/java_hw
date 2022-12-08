package sem1;

/* 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
*/
import java.util.Scanner;

public class hw1
{
	public static void main(String[] args) {

		System.out.println("Введите число N, и я вычислю его треугольное число и факториал:");
		    int n = enterFunction();
		    while (n < 0){
		        System.out.printf ("Число не должно быть отрицательным! Повторите ввод: \n");
		        n = enterFunction();
		    }
		    System.out.printf ("Треугольное число для %d равно %d \n", n, treangle(n));
		    System.out.printf ("Факториал числа %d равен %d", n, factorial(n));
		}

    static int factorial (int number) {
        int mult = 1;
        for (int i = 1; i<=number; i++){
		        mult*=i;
        }
        return mult;
    }
	
    static int treangle (int number) {
        int sum = 0;
        for (int i = 1; i<=number; i++){
		        sum+=i;
        }
        return sum;
    }
    
    static int enterFunction () {
        Scanner enterNum = new Scanner(System.in);
        boolean flag = enterNum.hasNextInt();
		if (flag == true) {
            int N = enterNum.nextInt();
            return N;
		}
        else{
            System.out.printf ("Ошибка ввода! Повторите! \n");
            return -1;
		}
    }
}