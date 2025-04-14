/**
 * This class represents an insurance policy 
  with various attributes and calculations.
 */
public class Policy {
    private String policy_Number;
    private String provider_Name;
    private PolicyHolder policy_Holder;
    private static int policy_Count = 0;

    /**
      default Constructor
     */
    public Policy() {
        this.policy_Number = "";
        this.provider_Name = "";
        this.policy_Holder = new PolicyHolder();
        policy_Count++;
    }

    /**
     * Constructor with all necessary arguments policyNumber 
      The policy number providerName The provider name 
      policyHolder The policy holder object
     */
    public Policy(String policyN, String providerN, PolicyHolder policy_Holder) {
        policy_Number = policyN;
        provider_Name = providerN;
        this.policy_Holder = new PolicyHolder(policy_Holder.getFirstName(), 
                                           policy_Holder.getLastName(),
                                           policy_Holder.getAge(),
                                           policy_Holder.getSmokingStatus(),
                                           policy_Holder.getHeight(),
                                           policy_Holder.getWeight());
        policy_Count++;
    }

    // Getters and Setters
    public String getPolicyNumber() { return policy_Number; }
    public void setPolicyNumber(String policy_Number) { this.policy_Number = policy_Number; }
    
    public String getProviderName() { return provider_Name; }
    public void setProviderName(String provider_Name) { this.provider_Name = provider_Name; }
    
    public PolicyHolder getPolicyHolder() { 
        return new PolicyHolder(policy_Holder.getFirstName(),
                              policy_Holder.getLastName(),
                              policy_Holder.getAge(),
                              policy_Holder.getSmokingStatus(),
                              policy_Holder.getHeight(),
                              policy_Holder.getWeight());
    }
    
    public void setPolicyHolder(PolicyHolder policy_Holder) {
        this.policy_Holder = new PolicyHolder(policy_Holder.getFirstName(),
                                           policy_Holder.getLastName(),
                                           policy_Holder.getAge(),
                                           policy_Holder.getSmokingStatus(),
                                           policy_Holder.getHeight(),
                                           policy_Holder.getWeight());
    }
    
    public static int getPolicyCount() { return policy_Count; }

     /*Calculates the insurance price based on 
        policyholder attributes The calculated insurance price
     */
    public double calculateInsurancePrice() {
        double fee = 600;  // base fee

        // Add fee if age > 50
        if (policy_Holder.getAge() > 50) {
            fee += 75;
        }
        
        // Add fee if smoker
        if (policy_Holder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            fee += 100;
        }

        // Add additional fee based on BMI
        double bmi = policy_Holder.calculateBMI();
        if (bmi > 35) {
            fee += (bmi - 35) * 20;
        }
        
        return fee;
    }

    /**
     * Returns a string representation of the Policy 
      Formatted string with policy details
     */
    @Override
    public String toString() {
        return String.format("Policy Number: %s\nProvider Name: %s\n%s\nInsurance Price: $%.2f",
                           policy_Number, provider_Name, policy_Holder.toString(), calculateInsurancePrice());
    }
}