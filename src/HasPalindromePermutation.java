import java.util.*;


public class HasPalindromePermutation {
	  public static void main(String[] args) {
	        Scanner myScan = new Scanner(System.in);
	        String inputString = myScan.nextLine();
	       
	        String ans=getResult(inputString);
	        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
	        System.out.println(ans);
	        myScan.close();
	    }
	    
	    static String getResult(String inputString){
	        Map<String,Integer> charCount = new HashMap<String,Integer>();
	        for(int i=0;i< inputString.length();i++){
	            String c = String.valueOf(inputString.charAt(i));
	            if(charCount.containsKey(c)){
	                charCount.put(c,charCount.get(c)+1);
	            } else {
	                charCount.put(c,1);
	            }
	        }
	        int oddCount=0;
	        for(Map.Entry<String,Integer> en: charCount.entrySet()){
	            if(en.getValue()%2 != 0){
	                oddCount++;
	            } 
	        }
	        if(oddCount>1){
	            return "NO";
	        }
	        return "YES";
	    }
}
