import java.util.Arrays;

public class Main {

        //Поиск перебором
        public static int bruteForce(double[] array, double key) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key)
                    return i;
            }
            return -1;
        }

        // Двоичный поиск
        public static int binarySearchRecursively(double[] sortedArray, double key) {
            return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
        }

        private static int binarySearchRecursively
        (double[] sortedArray, double key, int low, int high) {
            int middle = (low + high) / 2;

            if (high < low) {
                return -1;
            }

            if (key == sortedArray[middle]) {
                return middle;
            } else if (key < sortedArray[middle]) {
                return binarySearchRecursively(
                        sortedArray, key, low, middle - 1);
            } else {
                return binarySearchRecursively(
                        sortedArray, key, middle + 1, high);
            }
        }

        // Вспомогательный метод для тестов
        private static double[] generateRandomArray(int length) {
            double[] array = new double[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Math.random();
            }
            return array;
        }

        public static void main(String[] args) {
            double[] array = generateRandomArray(100000000);
            Arrays.sort(array);

            long time = System.currentTimeMillis(); // текущее время, unix-time
            bruteForce(array, 0.5);
            System.out.println("Время поиска перебором элемента массива длиной "+ array.length + " элементов: "
                    + (System.currentTimeMillis() - time) + " мс");

            time = System.currentTimeMillis();
            binarySearchRecursively(array, 0.5);
            System.out.println("Время двоичного поиска элемента массива длиной "+ array.length + " элементов: "
                    + (System.currentTimeMillis() - time) + " мс");
        }
}