import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        System.out.println("231RDB335 Kirills Bogdanovs 3. grupa");
		
		String fileName;
		System.out.println("input file name:");
		fileName = sc.nextLine().trim();
		sc.close();
		try {
            FileReader fin = new FileReader(fileName);
            sc = new Scanner(fin);
            System.out.println("result:");
            while (sc.hasNextLine()){
                String str = sc.nextLine();
                String[] parts = str.split("\\s+");
                if (parts.length < 3) continue;

                String name = parts[0];
                String lastname = parts[1];
                double vid = 0;
                int zemakcetr = 0;
                int izglcount = 0;

                for (int i = 2; i < parts.length; i++){
                    try {
                        int grade = Integer.parseInt(parts[i]);
                        vid += grade;
                        izglcount++;
                        if (grade < 4){
                            zemakcetr++;
                        }
                    } catch (NumberFormatException e) {
                }
            }
            if (izglcount > 0){
                vid /= izglcount;
            }
            if (vid <= 5){
                System.out.println(name + " " + lastname + " " + zemakcetr);
            }
        }
		sc.close();
    } catch (IOException e) {
		System.out.println("error reading file");
        }
    }
}