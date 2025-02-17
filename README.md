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
public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private float height;  // Changed to float
    private float weight;  // Changed to float

    // No-argument constructor with default values
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0f;
        this.weight = 0.0f;
    }

    // Constructor with all necessary arguments
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, float height, float weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters for each field
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    
    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    
    public float getHeight() { return height; }
    public void setHeight(float height) { this.height = height; }
    
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }

    // Method to calculate BMI
    public double calculateBMI() {
        return (this.weight * 703.0) / (this.height * this.height);
    }

    // Method to calculate the insurance price
    public double calculateInsurancePrice() {
        double price = 600;  // base fee

        // Add fee if age > 50
        if (this.age > 50) {
            price += 75;
        }
        
        // Add fee if smoker
        if (this.smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }

        // Add additional fee based on BMI
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        
        return price;
    }
}
