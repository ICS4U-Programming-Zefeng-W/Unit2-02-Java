/*
 * This program uses a recursive function to get the factorial of each number in input.txt
 * and outputs it to output.txt
 *
 * By Zefeng Wang
 * Created on January 11, 2022
 *
*/

// import classes
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// class RecursiveFactorial
class RecursiveFactorial {
  public static void main(String[] args) throws IOException {
    
    // Reads each line of the file
    List<String> lines = Files.readAllLines(Paths.get("input.txt"),
                               StandardCharsets.UTF_8);
    Iterator<String> itr = lines.iterator();
    List<String> list = new ArrayList<String>();

    // Store the answers and the error messages in an array
    for (int i = 0; itr.hasNext(); i++) {
      try {
        long number = Long.parseLong(itr.next());
        if (number < 0) {
          list.add("Please enter a non-negative integer.");
        } else {
          long answer = factorial(number);
          list.add(answer <= 0 ? "Please enter a smaller number." : Long.toString(answer));
        }
      } catch (Exception e) {
        list.add("Please enter a non-negative integer.");
      }
    }

    // Write the corresponding factorials and error messages to output.txt
    FileWriter writer = new FileWriter("output.txt");
    if (list.size() == 0) {
      writer.write("Please enter at least one number in input.txt");
    } else {
      for (String input : list) {
        writer.write(input + "\n");
      }
    }
    writer.close();
  }
  
  // Recursive function to take the factorial of a number
  public static long factorial(long num) {
    if (num == 0) {
      return 1;
    } else {
      return num * factorial(num - 1);
    }
  }
}
