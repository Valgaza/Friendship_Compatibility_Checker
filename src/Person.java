import java.util.List;

public class Person {
    private String name;
    private int age;
    private String favoriteColor;
    private List<String> hobbies;
    private List<String> interests;
    private String personalityType;
    private String communicationStyle;
    private String conflictResolutionStyle;
    private List<String> coreValues;

    public Person(String name, int age, String favoriteColor, List<String> hobbies, List<String> interests, String personalityType,
                  String communicationStyle, String conflictResolutionStyle, List<String> coreValues) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.hobbies = hobbies;
        this.interests = interests;
        this.personalityType = personalityType;
        this.communicationStyle = communicationStyle;
        this.conflictResolutionStyle = conflictResolutionStyle;
        this.coreValues = coreValues;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public String getFavoriteColor() { return favoriteColor; }

    public List<String> getHobbies() { return hobbies; }

    public List<String> getInterests() { return interests; }

    public String getPersonalityType() { return personalityType; }

    public String getCommunicationStyle() { return communicationStyle; }

    public String getConflictResolutionStyle() { return conflictResolutionStyle; }

    public List<String> getCoreValues() { return coreValues; }
}
