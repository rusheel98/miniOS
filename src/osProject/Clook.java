package osProject;

import java.util.Arrays;

public class Clook {
	int[] x;
	int start;

	public Clook(int[] clook, int start) 
	{
		this.x = clook;
		this.start = start;
	}

	public int[] calculate() 
	{
		int[] temp = new int[x.length];
		int[] temp1 = new int[x.length];
		int a = 0, b = 0;
		for (int i = 0; i < x.length; i++) 
		{
			if (x[i] > start) {
				temp[a] = x[i];
				a++;
			} else if(x[i]<start) {
				temp1[b] = x[i];
				b++;
			}
		}
		int first[] = new int[a+1];
		int[] second = new int[b];

		first[0] = start;
		for (int i = 0; i < first.length-1; i++) {
			first[i+1] = temp[i];			
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = temp1[i];
		}

		Arrays.sort(first);
		Arrays.sort(second);

		int c = 0;
		int[] finalX = new int[first.length+second.length];
		for (int i = 0; i < first.length; i++) {
			finalX[c] = first[i];
			c++;
		}

		for (int i = 0; i < second.length; i++) {
			finalX[c] = second[i];
			c++;
		}
		/*
		for(int i=0;i<finalX.length;i++)
			System.out.print(finalX[i]+" ->");
		*/
		return finalX;
	}

}
