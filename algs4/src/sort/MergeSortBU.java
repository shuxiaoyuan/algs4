package sort;

public class MergeSortBU extends MergeSort {

	// �Ե����ϵ�˼��
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N = a.length;
		aux = new Comparable[N];
		
		// ����һ��һ���ع鲢��Ȼ�������������ع鲢��Ȼ���ĸ�...
		for(int sz = 1; sz < N; sz = sz + sz) {
			// lo Ϊÿ������ߵ�Ԫ�ص��±�
			for(int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
		
	}

}
