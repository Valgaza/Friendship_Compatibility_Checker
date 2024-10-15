import java.util.List;

public class CompatibilityChecker {

    // Enhanced compatibility logic based on multiple factors
    public double checkCompatibility(Person p1, Person p2) {
        double compatibilityScore = 0;

        // Age difference logic (scaled with diminishing returns)
        int ageDifference = Math.abs(p1.getAge() - p2.getAge());
        compatibilityScore += calculateAgeScore(ageDifference);

        // Favorite color match (low weight)
        if (p1.getFavoriteColor().equalsIgnoreCase(p2.getFavoriteColor())) {
            compatibilityScore += 5; // Lower importance for favorite color
        }

        // Hobbies and Interests (weighted by overlap and shared specificity)
        compatibilityScore += calculateSharedHobbies(p1.getHobbies(), p2.getHobbies());
        compatibilityScore += calculateSharedInterests(p1.getInterests(), p2.getInterests());

        // Myers-Briggs personality type matching (complementary personalities)
        compatibilityScore += calculatePersonalityScore(p1.getPersonalityType(), p2.getPersonalityType());

        // Communication style compatibility
        if (p1.getCommunicationStyle().equalsIgnoreCase(p2.getCommunicationStyle())) {
            compatibilityScore += 15; // Communication is a crucial factor
        }

        // Conflict resolution style compatibility
        if (p1.getConflictResolutionStyle().equalsIgnoreCase(p2.getConflictResolutionStyle())) {
            compatibilityScore += 10; // Conflict resolution is important for harmony
        }

        // Core values alignment
        compatibilityScore += calculateValuesAlignment(p1.getCoreValues(), p2.getCoreValues());

        // Ensure that the score does not exceed 100%
        return Math.min(compatibilityScore, 100);
    }

    // Calculate score based on age difference
    private double calculateAgeScore(int ageDifference) {
        if (ageDifference <= 2) return 15;  // Full points for very close age
        else if (ageDifference <= 5) return 10;
        else if (ageDifference <= 10) return 5;
        else return 0;  // No points if age gap is larger than 10 years
    }

    // Calculate shared hobbies score (max 20 points)
    private double calculateSharedHobbies(List<String> hobbies1, List<String> hobbies2) {
        int commonHobbies = getCommonElementsCount(hobbies1, hobbies2);
        return (commonHobbies / (double) Math.max(hobbies1.size(), hobbies2.size())) * 20;
    }

    // Calculate shared interests score (max 25 points)
    private double calculateSharedInterests(List<String> interests1, List<String> interests2) {
        int commonInterests = getCommonElementsCount(interests1, interests2);
        return (commonInterests / (double) Math.max(interests1.size(), interests2.size())) * 25;
    }

    // Calculate personality compatibility based on Myers-Briggs type (max 15 points)
    private double calculatePersonalityScore(String personality1, String personality2) {
        if (isComplementaryPersonality(personality1, personality2)) {
            return 15; // Full points for complementary types
        }
        if (personality1.equalsIgnoreCase(personality2)) {
            return 10; // Full match for similar types
        }
        return 0;
    }

    // Method to check if personalities are complementary (e.g., ENFP and INTJ)
    private boolean isComplementaryPersonality(String personality1, String personality2) {
        if ((personality1.equalsIgnoreCase("ENFP") && personality2.equalsIgnoreCase("INTJ")) ||
                (personality1.equalsIgnoreCase("ISTJ") && personality2.equalsIgnoreCase("ESFP"))) {
            return true;
        }
        return false;
    }

    // Calculate values alignment (max 15 points)
    private double calculateValuesAlignment(List<String> values1, List<String> values2) {
        int commonValues = getCommonElementsCount(values1, values2);
        return (commonValues / (double) Math.max(values1.size(), values2.size())) * 15;
    }

    // Helper method to count common elements in two lists
    private int getCommonElementsCount(List<String> list1, List<String> list2) {
        int commonCount = 0;
        for (String item : list1) {
            if (list2.contains(item)) {
                commonCount++;
            }
        }
        return commonCount;
    }
}
