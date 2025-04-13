package Ejer2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 2, 7, 10, 4, 17);
        List<Integer> list2 = Arrays.asList(4, 2, 7, 10, 4, 1, 6);
        List<Integer> list3 = Arrays.asList(4, 2, 7, 1, 4, 6);
        List<Integer> list4 = Arrays.asList(9, 2, 7, 1, 7);

        System.out.println("Resultado 1: "+ QuickSelect.quickSelect(list1, 3)); // ➜ 4
        System.out.println("Resultado 2: "+ QuickSelect.quickSelect(list2, 5)); // ➜ 6
        System.out.println("Resultado 3: "+ QuickSelect.quickSelect(list3, 1)); // ➜ 1
        System.out.println("Resultado 4: "+ QuickSelect.quickSelect(list4, 4)); // ➜ 7
    }
}
