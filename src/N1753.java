import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1753 {
	static int v,e,k;
	static int[][] in;
	public static void main(String[] args) throws IOException{
		input();
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		in = new int[v][3];
	}
	static class MinHeap{
		int[] heap;
		int l, index;
		MinHeap(int l){
			heap = new int[l+1];
			this.l = l;
			index = 0;
		}
		void insert(int v){
			heap[index++] = v;
			for(int i = index-1; i>1;i/=2) {
				if(heap[i]<heap[i/2]) {
					swap(i,i/2);
				}
			}
		}
		void swap(int a,int b) {
			int temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;
		}
		int min() {
			return heap[1];
		}
	}
}
