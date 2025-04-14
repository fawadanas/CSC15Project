/**
 * This class represents a policy holder with personal information and health metrics.
 */
public class PolicyHolder {
    private String first_Name;
    private String last_Name;
    private int age;
    private String smoking_Status;
    private float height;
    private float weight;

    /**
     default constructor 
     */
    public PolicyHolder() {
        this.first_Name = "";
        this.last_Name = "";
        this.age = 0;
        this.smoking_Status = "non-smoker";
        this.height = 0.0f;
        this.weight = 0.0f;
    }

    /**
     parameterized constructor 
     */
    public PolicyHolder(String first_Name, String last_Name, int age, 
                       String smoking_Status, float height, float weight) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.age = age;
        this.smoking_Status = smoking_Status;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters
    public String getFirstName() { return first_Name; }
    public void setFirstName(String first_Name) { this.first_Name = first_Name; }
    
    public String getLastName() { return last_Name; }
    public void setLastName(String last_Name) { this.last_Name = last_Name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getSmokingStatus() { return smoking_Status; }
    public void setSmokingStatus(String smoking_Status) { this.smoking_Status = smoking_Status; }
    
    public float getHeight() { return height; }
    public void setHeight(float height) { this.height = height; }
    
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }

    /*
      Calculates the BMI
    */
    public double calculateBMI() {
        return (this.weight * 703.0) / (this.height * this.height);
    }

    /*
    Returns a string representation of the PolicyHolder
     */
    @Override
    public String toString() {
        return String.format("First Name: %s\nLast Name: %s\nAge: %d\nSmoking Status: %s\nHeight: %.1f inches\nWeight: %.1f pounds\nBMI: %.2f",
                            first_Name, last_Name, age, smoking_Status, height, weight, calculateBMI());
    }
}