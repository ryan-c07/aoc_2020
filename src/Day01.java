import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day1Input.txt");
        System.out.println(fileData);
        System.out.println(findValues(fileData));
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
    public static int findValues(ArrayList<String> data){
        for (int i = 0; i < data.size(); i++){
            for (int j = i + 1; j < data.size(); j++){
                for (int k = j + 1; k < data.size(); k++) {
                    if (Integer.parseInt(data.get(i)) + Integer.parseInt(data.get(j)) + Integer.parseInt(data.get(k)) == 2020) {
                        return Integer.parseInt(data.get(i)) * Integer.parseInt(data.get(j)) * Integer.parseInt(data.get(k));
                    }
                }
            }
        }
        return -1;
    }
}