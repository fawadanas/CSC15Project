import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for policy details
        System.out.print("Enter policy number: ");
        String policyNumber = sc.nextLine();  // Read the policy number
        
        System.out.print("Enter provider name: ");
        String providerName = sc.nextLine();  // Read the provider name
        
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();  // Read the first name
        
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();  // Read the last name
        
        System.out.print("Enter age: ");
        int age = getIntInput(sc, "Age");  // Get valid integer for age
        
        System.out.print("Enter smoking status (smoker/non-smoker): ");
        String smokingStatus = sc.nextLine();  // Read smoking status
        
        System.out.print("Enter height (in inches): ");
        float height = getFloatInput(sc, "Height");  // Get valid float for height
        
        System.out.print("Enter weight (in pounds): ");
        float weight = getFloatInput(sc, "Weight");  // Get valid float for weight
        
        // Create the Policy object
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
        
        // Display policy details
        displayPolicyDetails(policy);
    }

    // Method to safely get an integer input from the user
    public static int getIntInput(Scanner sc, String fieldName) {
        int value = -1;
        while (true) {
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();  // Consume the newline character
                break;
            } else {
                System.out.print("Invalid " + fieldName + " input. Please enter a valid integer: ");
                sc.nextLine();  // Clear invalid input
            }
        }
        return value;
    }

    // Method to safely get a float input from the user
    public static float getFloatInput(Scanner sc, String fieldName) {
        float value = -1;
        while (true) {
            if (sc.hasNextFloat()) {
                value = sc.nextFloat();
                sc.nextLine();  // Consume the newline character
                break;
            } else {
                System.out.print("Invalid " + fieldName + " input. Please enter a valid float: ");
                sc.nextLine();  // Clear invalid input
            }
        }
        return value;
    }

    // Method to display policy details
    public static void displayPolicyDetails(Policy policy) {
        System.out.println("\nPolicy Details:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder: " + policy.getFirstName() + " " + policy.getLastName());
        System.out.println("Age: " + policy.getAge());
        System.out.println("Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Height: " + policy.getHeight() + " inches");
        System.out.println("Weight: " + policy.getWeight() + " pounds");
        System.out.println("BMI: " + policy.calculateBMI());
        System.out.println("Insurance Price: $" + policy.calculateInsurancePrice());
    }
}
