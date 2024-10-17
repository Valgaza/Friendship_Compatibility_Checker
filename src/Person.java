public class Person {
    private String name;
    private int age;
    private String favoriteColor;
    private String personalityType;
    private String hobbies;
    private String communicationStyle;
    private String conflictResolutionStyle;

    public Person(String name, int age, String favoriteColor, String personalityType, 
                  String hobbies, String communicationStyle, String conflictResolutionStyle) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.personalityType = personalityType;
        this.hobbies = hobbies;
        this.communicationStyle = communicationStyle;
        this.conflictResolutionStyle = conflictResolutionStyle;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getFavoriteColor() { return favoriteColor; }
    public String getPersonalityType() { return personalityType; }
    public String getHobbies() { return hobbies; }
    public String getCommunicationStyle() { return communicationStyle; }
    public String getConflictResolutionStyle() { return conflictResolutionStyle; }
}
