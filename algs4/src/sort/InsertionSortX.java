package sort;

public class InsertionSortX extends Sort {
	
	// algs4 ��վ�ϵİ汾����һ���������Լ�����Сֵ���ڵ�һ��λ��
	//������ SortCompare ���Եõ��Ľ���ǲ����Լ�д������汾��
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 1; i < a.length; i++) {
			int j = i;
			Comparable k = a[j];
			while(j > 0 && less(k, a[j - 1])) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = k;
		}
	}

}
