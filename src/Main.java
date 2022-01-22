import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] B;
        B = new int[20];
        System.out.println("Массив:" );
        for (int n= 1; n < B.length; n++) {
            B[n] = ((int)(Math.random() * 31));
        }
        for (int n : B) System.out.print(n + " "); //Выводим изначальный массив

        System.out.print("\nОтсортированный массив: \n");
        Arrays.sort(B); //Сортируем массив

        for (int n : B) System.out.print(n + " ");
        int left = 0; // левая граница
        int right =B.length - 1; // правая граница

        do
        {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int n = left; n < right; n++)
            {
                if(B[n] > B[n+1])
                {
                    B[n] ^= B[n+1];
                    B[n+1] ^= B[n];
                    B[n] ^= B[n+1];
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int n = right; n > left ; n--)
            {
                if(B[n] < B[n-1])
                {
                    B[n] ^= B[n-1];
                    B[n-1] ^= B[n];
                    B[n] ^= B[n-1];
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);
        System.out.println("\nСортировка перемшиванием:");
        for (int n : B) System.out.print(n + " "); // вывод массива на экран
    }
}