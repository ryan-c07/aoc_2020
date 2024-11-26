import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day2Input.txt");
        System.out.println(fileData);
        partOne(fileData);
        partTwo(fileData);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
    public static void partOne(ArrayList<String> data){
        int correctPasswords = 0;
        for (String sample : data) {
            String[] split = sample.split(" ");
            int min = Integer.parseInt(split[0].substring(0,split[0].indexOf("-")));
            int max = Integer.parseInt(split[0].substring(split[0].indexOf("-") + 1));
            String letter = split[1].substring(0,1);
            String password = split[2];
            int count = 0;
            for (int i = 0; i < password.length(); i++){
                if (password.substring(i, i + 1).equals(letter)){
                    count++;
                }
            }
            if (count >= min && count <= max){
                correctPasswords++;
            }
        }
        System.out.println(correctPasswords);
    }
    public static void partTwo(ArrayList<String> data){
        int correctPasswords = 0;
        for (String sample : data) {
            String[] split = sample.split(" ");
            int min = Integer.parseInt(split[0].substring(0,split[0].indexOf("-")));
            int max = Integer.parseInt(split[0].substring(split[0].indexOf("-") + 1));
            String letter = split[1].substring(0,1);
            String password = split[2];
            int count = 0;
            if (password.substring(min - 1, min).equals(letter)){
                count++;
            }
            if (password.substring(max - 1, max).equals(letter)){
                count++;
            }
            if (count == 1){
                correctPasswords++;
            }
        }
        System.out.println(correctPasswords);
    }
}