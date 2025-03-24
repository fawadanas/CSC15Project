import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smoker_Count = 0;
        int nonSmoker_Count = 0;

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

                // Create Policy object and add to ArrayList
                Policy policy = new Policy(policy_Number, provider_Name, first_Name, 
                                         last_Name, age, smoking_Status, height, weight);
                policies.add(policy);

                // Count smokers and non-smokers
                if (smoking_Status.equalsIgnoreCase("smoker")) {
                    smoker_Count++;
                } else {
                    nonSmoker_Count++;
                }

                // Skip any empty lines between records
                if (fileScanner.hasNext()) {
                    fileScanner.nextLine();
                }
            }
            fileScanner.close();

            // Display information for each policy
            for (Policy policy : policies) {
                displayPolicyDetails(policy);
                System.out.println();  // Add blank line between policies
            }

            // Display smoker statistics
            System.out.println("\nNumber of smokers: " + smoker_Count);
            System.out.println("Number of non-smokers: " + nonSmoker_Count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    /**
     * Displays the details of a policy
     * @param policy The Policy object to display
     */
    public static void displayPolicyDetails(Policy policy) {
        System.out.println("Policy Details:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder: " + policy.getFirstName() + " " + policy.getLastName());
        System.out.println("Age: " + policy.getAge());
        System.out.println("Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Height: " + policy.getHeight() + " inches");
        System.out.println("Weight: " + policy.getWeight() + " pounds");
        System.out.printf("BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Insurance Price: $%.2f\n", policy.calculateInsurancePrice());
    }
}