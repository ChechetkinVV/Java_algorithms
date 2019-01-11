import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("Hi from collections!");
        Collection<Integer> collection = new ArrayList<Integer>();
        //Collection<Integer> collection = new TreeSet<Integer>();
        collection.add(10);
        collection.add(10);

        collection.add(20);

        System.out.println("min: " + Collections.min(collection));
        System.out.println("max: " + Collections.max(collection));
        System.out.println("frequency: " + Collections.frequency(collection, 10));

        for (int item:collection){
            System.out.println("item: " + item);

        }
    }
}
/*Ниже список ссылок на эти статьи, которые давал Игорь Долгов по окончании курса Java 1/
Java собеседование - коллекции    http://habrahabr.ru/post/162017/
структуры данных в картинках - LinkedList    http://habrahabr.ru/post/127864/
структуры данных в картинках - ArrayList    http://habrahabr.ru/post/128269/
структуры данных в картинках - HashMap    http://habrahabr.ru/post/128017/
TreeSet vs. HashSet    http://stackoverflow.com/questions/1463284/hashset-vs-treeset/
структуры данных в картинках - HashMap    http://ru.wikipedia.org/wiki/%D0%A5%D0%B5%D1%88-%D1%82%D0%B0%D0%B1%D0%BB%D0%B8%D1%86%D0%B0#.D0.9C.D0.B5.D1.82.D0.BE.D0.B4_.D1.86.D*/