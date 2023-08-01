package HomeWork5;

import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.
public class task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phonebook = new HashMap<>();
        addContact(phonebook, "Zaur", "8922728");
        addContact(phonebook, "ivan", "89898523698");
        //printMap(phonebook);
        addContact(phonebook, "ivan", "89288979580");
        addContact(phonebook, "Zaur", "8922728");
        addContact(phonebook, "Zaur", "89227286556");
        addContact(phonebook, "Zaur", "892272865123");
        addContact(phonebook, "Zaur", "892");
        //printMap(phonebook);
        LinkedHashMap<String, ArrayList<String>> phonebook2 = sortByValue(phonebook);
        printMap(phonebook2);

    }

    public static LinkedHashMap<String, ArrayList<String>> sortByValue(Map<String, ArrayList<String>> map) {
        LinkedHashMap<String, ArrayList<String>>  map2 = new LinkedHashMap<>();
        ArrayList < ArrayList<String>> al = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            al.add(new ArrayList<String>(Arrays.asList(entry.getKey().toString(), entry.getValue().toString())));

        }
        for (int i = 0; i < al.size() ; i++) {
            for (int j = i + 1; j < al.size() ; j++) {
                if (al.get(i).size() <= al.get(j).size()){
                    ArrayList <String> temp = al.get(i);
                    al.set(i, al.get(j));
                    al.set(j, temp);
                }
            }
        }
        ArrayList <String> phone2 = new ArrayList<>();
        for (int i = 0; i <al.size() ; i++) {
            for (int j = 0; j <al.get(i).size() ; j++) {
                if (j !=0) {
                    phone2.add(al.get(i).get(j));
                }
            }
            map2.put(al.get(i).get(0), phone2);
            phone2 = new ArrayList<>();
        }
        return map2;

    }

    private static void addContact(Map<String, ArrayList<String>> phonebook, String name, String number) {
        ArrayList<String> phone = new ArrayList<>();
        int count = 1;
        for (Map.Entry<String, ArrayList<String>> entry : phonebook.entrySet()) {
            if (entry.getKey().equals(name)){
                phone = entry.getValue();
                phone.add(number);
                entry.setValue(phone);
                count = 0;
                break;
            }
        }
        if (count == 1){
            phonebook.put(name, new ArrayList<>(Arrays.asList(number)));
        }
    }
    private static void printMap(Map<String, ArrayList<String>> map) {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
