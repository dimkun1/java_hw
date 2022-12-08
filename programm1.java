// import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * programm1
 */
public class programm1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        
        int nowIime = LocalTime.of(12,0,0).getHour();
        System.out.println(nowIime);

        
        if (nowIime <= 0 && nowIime < 10){System.out.printf("Доброе утро, %s!", name);}
        if (nowIime > 10 && nowIime <= 18){System.out.printf("Добрый день, %s!", name);}
        if (nowIime > 19 && nowIime <= 24){System.out.printf("Добрый вечер, %s!", name);}



        iScanner.close();
        
    }
}