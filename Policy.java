/**
 * This class represents an insurance policy with various attributes and calculations.
 */
public class Policy {
    private String policy_Number;
    private String provider_Name;
    private String first_Name;
    private String last_Name;
    private int age;
    private String smoking_Status;
    private float height;
    private float weight;

    /**
     * No-argument constructor with default values
     */
    public Policy() {
        this.policy_Number = "";
        this.provider_Name = "";
        this.first_Name = "";
        this.last_Name = "";
        this.age = 0;
        this.smoking_Status = "non-smoker";
        this.height = 0.0f;
        this.weight = 0.0f;
    }

    /**
     * Constructor with all necessary arguments
     * @param policy_Number The policy number
     * @param provider_Name The provider name
     * @param first_Name Policyholder's first name
     * @param last_Name Policyholder's last name
     * @param age Policyholder's age
     * @param smoking_Status Policyholder's smoking status
     * @param height Policyholder's height in inches
     * @param weight Policyholder's weight in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, float height, float weight) {
        policy_Number = policyNumber;
        provider_Name = providerName;
        first_Name = firstName;
        last_Name = lastName;
        this.age = age;
        smoking_Status = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters with Javadoc comments
    /**
     * Gets the policy number
     * @return The policy number
     */
    public String getPolicyNumber() { return policy_Number; }
    
    /**
     * Sets the policy number
     * @param policyNumber The policy number to set
     */
    public void setPolicyNumber(String policyNumber) { policy_Number = policyNumber; }
    
    /**
     * Gets the provider name
     * @return The provider name
     */
    public String getProviderName() { return provider_Name; }
    
    /**
     * Sets the provider name
     * @param providerName The provider name to set
     */
    public void setProviderName(String providerName) { provider_Name = providerName; }
    
    /**
     * Gets the first name
     * @return The first name
     */
    public String getFirstName() { return first_Name; }
    
    /**
     * Sets the first name
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) { first_Name = firstName; }
    
    /**
     * Gets the last name
     * @return The last name
     */
    public String getLastName() { return last_Name; }
    
    /**
     * Sets the last name
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) { last_Name = lastName; }
    
    /**
     * Gets the age
     * @return The age
     */
    public int getAge() { return age; }
    
    /**
     * Sets the age
     * @param age The age to set
     */
    public void setAge(int age) { this.age = age; }
    
    /**
     * Gets the smoking status
     * @return The smoking status
     */
    public String getSmokingStatus() { return smoking_Status; }
    
    /**
     * Sets the smoking status
     * @param smokingStatus The smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) { smoking_Status = smokingStatus; }
    
    /**
     * Gets the height
     * @return The height in inches
     */
    public float getHeight() { return height; }
    
    /**
     * Sets the height
     * @param height The height in inches to set
     */
    public void setHeight(float height) { this.height = height; }
    
    /**
     * Gets the weight
     * @return The weight in pounds
     */
    public float getWeight() { return weight; }
    
    /**
     * Sets the weight
     * @param weight The weight in pounds to set
     */
    public void setWeight(float weight) { this.weight = weight; }

    /**
     * Calculates the BMI (Body Mass Index)
     * @return The calculated BMI
     */
    public double calculateBMI() {
        return (this.weight * 703.0) / (this.height * this.height);
    }

    /**
     * Calculates the insurance price based on policyholder attributes
     * @return The calculated insurance price
     */
    public double calculateInsurancePrice() {
        double fee = 600;  // base fee

        // Add fee if age > 50
        if (this.age > 50) {
            fee += 75;
        }
        
        // Add fee if smoker
        if (this.smoking_Status.equalsIgnoreCase("smoker")) {
            fee += 100;
        }

        // Add additional fee based on BMI
        double bmi = calculateBMI();
        if (bmi > 35) {
            fee += (bmi - 35) * 20;
        }
        
        return fee;
    }
}