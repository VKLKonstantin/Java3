package lesson6;

public class Mission3 {

    public static void main(String[] args) {
        int a[] = {5, 6, 7, 8};
 //       int a[] = {1, 4, 1, 4, 1, 4, 1, 4};
        System.out.println(checkArray(a));
    }

    public static boolean checkArray(int a[]) {
        int countOne = 0;
        int countFour = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                countOne++;
            }
            if (a[i] == 4) {
                countFour++;
            }
        }
        if (countOne == 0 || countFour == 0) {
            return false;
        }
        return true;
    }
}
