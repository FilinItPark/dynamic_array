import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 1ommy
 * @version 21.10.2023
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*int[] ages = new int[10]; // возраста пользователей нашего сайта

        for (int i = 0; i < ages.length; i++) {
            ages[i] = 1980 + i;
        }
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }
        System.out.println();
        int[] new_array = new int[2 * ages.length];

        for (int i = 0; i < ages.length; i++) {
            new_array[i] = ages[i];
        } // 10 свободных ячеек*/

        DynamicArray<String> names = new DynamicArray<>(10);

        /*
        int, char, double,float,short - примитивы,не классы
        Integer, Character, Double, Float, Short - классы-обертки
         */

      /*  try {
            array.insert(5, 1);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            System.out.println("я отработаю всегда");
        }*/
        names.insert("Hello");
        names.insert("World");
        names.insert("Ivan");
        names.insert("Array");
        names.insert("Andrey");
        System.out.println();
        System.out.println(names);
        System.out.println();

     /*   Summary binaryNumber = new Summary();
        Summary binaryNumber2 = new Summary();
        Summary = binaryNumber + binaryNumber2;
*/

        FileOutputStream outputStream = new FileOutputStream("./pornhub.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(names);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("./pornhub.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        var namesFromFile = (DynamicArray<String>) objectInputStream.readObject();

        System.out.println(namesFromFile);
        int[] ages = new int[10]; // возраста пользователей нашего сайта

        for (int i = 0; i < ages.length; i++) {
            ages[i] = 1980 + i;
        }

        for (var age : ages) {
            System.out.println(age);
        }

        for (String name : names) {
            System.out.println(name);
        }

        for (Iterator<String> it = names.iterator(); it.hasNext(); ) {
            String name = it.next();

            System.out.println(name);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Age", 19);
        map.put("Weight", 73);
        map.put("Height", 182);


        for (Map.Entry<String, Integer> element : map.entrySet()) {
            System.out.println(element.getKey() + ":" + element.getValue());
        }
        for (var element : map.entrySet()) {
            System.out.println(element.getKey() + ":" + element.getValue());
        }
    }
}