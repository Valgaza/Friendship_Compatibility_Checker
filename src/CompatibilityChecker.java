public class CompatibilityChecker {
    public static double calculateCompatibility(Person p1, Person p2) {
        double score = 0;
        score += calculateAgeScore(p1.getAge(), p2.getAge());
        score += calculateHobbyScore(p1.getHobbies(), p2.getHobbies());
        score += calculatePersonalityScore(p1.getPersonalityType(), p2.getPersonalityType());
        return score;
    }

    private static double calculateAgeScore(int age1, int age2) {
        return Math.abs(age1 - age2) <= 5 ? 10 : 0;
    }

    private static double calculateHobbyScore(String hobbies1, String hobbies2) {
        try {
            String[] list1 = hobbies1.split(",");
            String[] list2 = hobbies2.split(",");
            int commonCount = (int) java.util.Arrays.stream(list1)
                    .filter(java.util.Arrays.asList(list2)::contains)
                    .count();
            return (commonCount / (double) Math.max(list1.length, list2.length)) * 20;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero in hobby calculation.");
            return 0;
        }
    }

    private static double calculatePersonalityScore(String type1, String type2) {
        return type1.equalsIgnoreCase(type2) ? 15 : 5;
    }
}
