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
	    int lrp[] = computeP(p,m);
	    int k = -1;
	
	   for(int i=0;i<n;i++){
	        
	       while( k>-1 &&p[k+1]!=t[i]){
	           k=lrp[k]-1;
	       }
	       if(p[k+1]==t[i])
	       k++;
	       if(k+1==m){
	           System.out.println("Index is at "+(i-m+1));
	           k=lrp[k]-1;
	       }
	       
	    
	        
	   }
	}
	static int[] computeP(char p[],int m){
	    
	    int lrp[] = new int[m];
	    int k = -1;
	    lrp[0] =0;
	    for(int i=1;i<m;i++){
	        
	        while( k>-1 &&p[k+1]!=p[i]){
	            k=lrp[k]-1;
	        }
	        if(p[k+1]==p[i])
	        k++;
	        lrp[i]=k+1;
	    }
	    System.out.println(Arrays.toString(lrp));
	    return lrp;
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