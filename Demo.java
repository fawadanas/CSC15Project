import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smoker_Count = 0;
        int non_Smoker_Count = 0;

        try {
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                // Read all policy information from file
                String policy_Number = fileScanner.nextLine();
                String provider_Name = fileScanner.nextLine();
                String first_Name = fileScanner.nextLine();
                String last_Name = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smoking_Status = fileScanner.nextLine();
                float height = Float.parseFloat(fileScanner.nextLine());
                float weight = Float.parseFloat(fileScanner.nextLine());

                // Create PolicyHolder object
                PolicyHolder holder = new PolicyHolder(first_Name, last_Name, age, smoking_Status, height, weight);
                
                // Create Policy object and add to ArrayList
                Policy policy = new Policy(policy_Number, provider_Name, holder);
                policies.add(policy);

                // Count smokers and non-smokers
                if (smoking_Status.equalsIgnoreCase("smoker")) {
                    smoker_Count++;
                } else {
                    non_Smoker_Count++;
                }

                // Skip any empty lines between records
                if (fileScanner.hasNext()) {
                    fileScanner.nextLine();
                }
            }
            fileScanner.close();

            // Display information for each policy (implicitly calls toString())
            for (Policy policy : policies) {
                System.out.println(policy);
                System.out.println();  // Add blank line between policies
            }

            // Display statistics
            System.out.println("\nThere were " + Policy.getPolicyCount() + " Policy objects created.");
            System.out.println("Number of smokers: " + smoker_Count);
            System.out.println("Number of non-smokers: " + non_Smoker_Count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}