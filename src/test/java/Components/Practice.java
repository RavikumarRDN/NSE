
package Components;
import java.util.HashSet;
import java.util.stream.*;
import java.util.Arrays;
public class Practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practice p=new Practice();
		int arr[]= {90,94,87,2,3,2,3,4,5,6,7,4,5,89};
		HashSet<Integer> hst=p.uniquenumber(arr);
		System.out.println(hst);
		p.usingStream(arr);
		

	}
	
	public HashSet<Integer> uniquenumber(int arr[]) {
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int n: arr) {
			hs.add(n);
		}
		return hs;
		
	}
	public void usingStream(int arr[]) {
		Arrays.stream(arr).filter(n->n<50).distinct().sorted().forEach(n->System.out.print(n + " "));
		
	}
	
}