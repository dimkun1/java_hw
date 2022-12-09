/*
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */

 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;
 import java.util.logging.*;
 
 public class hw1 {
     public static void main (String [] Args) throws SecurityException, IOException {
         Logger logger = Logger.getLogger(hw1.class.getName());
         FileHandler fh = new FileHandler("hw1.txt" + "run.log",  0, 1, true);
         logger.addHandler(fh);
         SimpleFormatter sFormat = new SimpleFormatter();
         fh.setFormatter(sFormat);
         logger.log(Level.WARNING, "Запуск программы\n");
 
         System.out.println("Введите массив целых чисел через пробел");
         int [] arrayForSort = enterData();
         System.out.println();
         
         logger.log(Level.INFO, "Ввод элементов массива пользователя завершен\n");
        
         for (int i: arrayForSort) {
             System.out.printf(i+ " ");
         }
         System.out.println("\n");
         int [] sortArray = sortMethod(arrayForSort);
         
         logger.log(Level.INFO, "Сортировка массива завершена\n");
 
         System.out.println();
         for (int i: sortArray) {
             System.out.printf(i + " ");
         }
         System.out.println("\n");
         
         logger.log(Level.INFO, "Вывод отсортированного массива\n");
     }
 
 //Метод ввода элементов массива для сортировки
     static int [] enterData() throws SecurityException, IOException {
         Scanner sc = new Scanner(System.in);
         String dataForArray = sc.nextLine();
         String [] stringArray = dataForArray.split(" ");
         int len = stringArray.length;
         int [] array = new int [len];
         try {
             FileWriter fw = new FileWriter("hw1.txtrun.log", true);
             for (int i = 0; i < len; i++) {
                 try {
                     array[i] = Integer.parseInt(stringArray[i]);
                 }
                 catch (Exception e) {
                     System.out.printf("Вы ввели какую-то дичь для %d элемента. Я заменил его на 0\n", i+1);
                     fw.write("Ошибка преобразования данных пользователя. Замена на 0\n");
                     array[i] = 0;
                 }
             }
             fw.flush();
             fw.close();
         }
         catch(IOException ex){
             System.out.println(ex.getMessage());
         }
         return array;
     }
 
 //Метод сортировки элементов массива
     static int [] sortMethod (int [] arrayForSort) throws SecurityException, IOException {
         int len = arrayForSort.length;
         try {
             FileWriter fw = new FileWriter("hw1.txtrun.log",true);
             for (int i = 0; i < len; i++) {
                 int booble = arrayForSort[0];
                 for (int j = 1; j < len; j++) {
                     if (arrayForSort[j] < arrayForSort[j-1]) {
                         arrayForSort[j-1] = arrayForSort[j];
                         arrayForSort[j] = booble;
                         fw.write("Элемент " + String.valueOf(arrayForSort[j-1]) + " меняется местами с элементом " + String.valueOf(arrayForSort[j] + "\n"));
                         booble = arrayForSort[j];
                         fw.write("В 'пузырек' кладем значение " + String.valueOf(arrayForSort[j]) + "\n");
                     }
                     else {
                         booble = arrayForSort[j];
                         fw.write(String.valueOf(arrayForSort[j]) + " >= " + String.valueOf(arrayForSort[j-1])
 + ". Кладем значение " + String.valueOf(arrayForSort[j] + " в 'пузырек' и переходим к нему\n"));
                     }
                     fw.write("Массив преобразован в ");
                     for (int k:arrayForSort) {
                         fw.write(Integer.toString(k) + " ");
                     }
                     fw.write('\n');
                 }
             }
             fw.flush();
             fw.close();
         }
         catch(IOException ex){
             System.out.println(ex.getMessage());
         }
         return arrayForSort;
     }
 }