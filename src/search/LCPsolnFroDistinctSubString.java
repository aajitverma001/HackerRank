package search;
import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.util.Arrays;


  public class LCPsolnFroDistinctSubString {


public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter Desired String ");
    String string=br.readLine();
    int length=string.length();
    String[] prefixArr=new String[length];
    for(int i=0;i<length;++i)
    {
        prefixArr[i]=string.substring(length-1-i,length);
    }

    Arrays.sort(prefixArr);
    for(int i=0;i<length;++i)
    System.out.println(prefixArr[i]);

    long num_substring=prefixArr[0].length();

    for(int i=0;i<length-1;++i)
    {
        int j=0;
        for(;j<prefixArr[i].length();++j)
        {
        	System.out.println(" f   " + prefixArr[i].substring(0,j+1));
        	System.out.println(" S   " + (prefixArr)[i+1].substring(0,j+1));
        	if(!((prefixArr[i].substring(0,j+1)).equals((prefixArr)[i+1].substring(0,j+1))))
            {
        		System.err.println(" f   " + prefixArr[i].substring(0,j+1));
            	System.err.println(" S   " + (prefixArr)[i+1].substring(0,j+1));
        		break;
            }
        }
        System.out.println("num1 " + num_substring);
        System.out.println("i " + i +" j "+ j);
        num_substring+=prefixArr[i+1].length()-j;
        System.out.println("num2 " + num_substring);
    }
    System.out.println("unique substrings = "+num_substring);
}

  }