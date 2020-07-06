
// The Idea is to use Proper Prefix. First will compute the  longest prefix repeating(LPR) the apply KMP algo.
// Sample test case
// Input
// 1
// abaababa 
// ab
// Ouptut 
// [0, 0]<- LRP array
// Index is at 0
// Index is at 3
// Index is at 5
import java.io.*;
import java.util.*;

class KMP {
    private static BufferedReader br;
	private static StringTokenizer st;
	public static void main (String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		rl();
		int t = nin();
		while(t-->0){
		    rl();
		    char []txt = nca();
		     rl();
		    char []p = nca();
		  findIndexMathcing(txt,p);
		}
	}
	static void findIndexMathcing(char t[],char p[]){
	    int m = p.length;
	    int n = t.length;
	    int LPR[] = computeP(p,m);
	    int k = -1;
	
	   for(int i=0;i<n;i++){
	        
	       while( k>-1 &&p[k+1]!=t[i]){
	           k=LPR[k]-1;
	       }
	       if(p[k+1]==t[i])
	       k++;
	       if(k+1==m){
	           System.out.println("Index is at "+(i-m+1));
	           k=LPR[k]-1;
	       }
	       
	    
	        
	   }
	}
	static int[] computeP(char p[],int m){
	    
	    int LPR[] = new int[m];
	    int k = -1;
	    LPR[0] =0;
	    for(int i=1;i<m;i++){
	        
	        while( k>-1 &&p[k+1]!=p[i]){
	            k=LPR[k]-1;
	        }
	        if(p[k+1]==p[i])
	        k++;
	        LPR[i]=k+1;
	    }
	    System.out.println(Arrays.toString(LPR));
	    return LPR;
	}
    private static void rl() throws Exception{
		st = new StringTokenizer(br.readLine());
    }
	private static int nin(){
		return Integer.parseInt(st.nextToken());
    }
	
    private static char[] nca(){
		return st.nextToken().toCharArray();
    }
}