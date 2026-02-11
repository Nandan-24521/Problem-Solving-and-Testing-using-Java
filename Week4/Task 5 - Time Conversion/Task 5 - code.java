import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String period = s.substring(s.length() - 2);
        
        String time = s.substring(0, s.length() - 2);
        
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        String minutes = timeParts[1];
        String seconds = timeParts[2];
        
        if (period.equals("AM")) {
            if (hours == 12) {
                hours = 0;
            }
        } else { 
            if (hours != 12) {
                hours += 12;
            }
        }

        String hoursStr = String.format("%02d", hours);

        return hoursStr + ":" + minutes + ":" + seconds;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
