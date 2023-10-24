package AoC_2022.Day1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Reads a list of caloric values where each new line represents a new person
 * with these caloric values.
 * Solves the tasks of showing the elf with the highest caloric amount and what it is.
 * And the top three caloric amount elves combined together.
 */
public class Day1 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
         System.out.println("This is the answer for day 1 1st: "+get_Highest_Elf());
         System.out.println("This is the answer for day 1 2nd: "+get_3_Highest_Elf());
    }

    /** 
     * Will return a list of all calories each elf has. Every empty line represents a new elf.
     * The calories are added together for each elf.
     * @param input_path a relative url for the input file for calculation.
     * @return a list containing all elves calories added together
    */
    public static ArrayList<Integer> getInput(String input_path) throws FileNotFoundException, IOException{
        ArrayList<Integer> elves_calories = new ArrayList<Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(input_path))) {
        String line;
        Integer calories = 0;
        while ((line = br.readLine()) != null) {
            if(line.isEmpty()){
                elves_calories.add(calories);
                calories= 0;
            }
            else{
                calories+= Integer.parseInt(line);
            }
        }
    }
    return elves_calories;
    }

    /** 
     * Gets the highest calorie amount within the list.
     * @return the highest amount within the list
    */
    public static Integer get_Highest_Elf() throws FileNotFoundException, IOException{
        ArrayList<Integer> elf_calories = getInput("AoC_2022/Day1/input.txt");
        Integer max = Collections.max(elf_calories);
        return max;
    }

    /** 
     * Gets the top three highest calorie amounts within the list added together.
     * @return the combined amount of calories from the top three elves.
    */
    public static Integer get_3_Highest_Elf() throws FileNotFoundException, IOException{
        ArrayList<Integer> elf_calories = getInput("AoC_2022/Day1/input.txt");
        Collections.sort(elf_calories);
        Collections.reverse(elf_calories);
        Integer top_three = elf_calories.get(0)+ elf_calories.get(1)+ elf_calories.get(2); 
        return top_three;
    }
}