package sort;

public class BubbleSortX extends Sort {

    @Override
    public void sort(Comparable[] a) {
        // �Ż���ð���������� O(n)����� O(n^2)
        boolean exched = false;
        for(int i = 1; i <= a.length - 1; i++) {
            for(int j = 0; j < a.length - 1; j++) {
                if(less(a[j+1], a[j])) {
                    exch(a, j, j+1);
                    exched = true;
                }
            }
            if(exched == false) {
                return;
            }
        }
    }

}
