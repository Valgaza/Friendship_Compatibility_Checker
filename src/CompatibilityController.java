import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class CompatibilityController {

    @FXML
    private TextField name1Field, age1Field, color1Field, hobby1Field, interest1Field, personality1Field, communicationStyle1Field, conflictResolution1Field, values1Field;
    @FXML
    private TextField name2Field, age2Field, color2Field, hobby2Field, interest2Field, personality2Field, communicationStyle2Field, conflictResolution2Field, values2Field;

    @FXML
    private Label resultLabel;

    private final CompatibilityChecker checker = new CompatibilityChecker();

    @FXML
    public void checkCompatibility() {
        // Get input for Person 1
        String name1 = name1Field.getText();
        int age1 = Integer.parseInt(age1Field.getText());
        String color1 = color1Field.getText();

        List<String> hobbies1 = Arrays.asList(hobby1Field.getText().split(","));
        List<String> interests1 = Arrays.asList(interest1Field.getText().split(","));
        String personality1 = personality1Field.getText();
        String communicationStyle1 = communicationStyle1Field.getText();
        String conflictResolution1 = conflictResolution1Field.getText();
        List<String> values1 = Arrays.asList(values1Field.getText().split(","));

        // Get input for Person 2
        String name2 = name2Field.getText();
        int age2 = Integer.parseInt(age2Field.getText());
        String color2 = color2Field.getText();

        List<String> hobbies2 = Arrays.asList(hobby2Field.getText().split(","));
        List<String> interests2 = Arrays.asList(interest2Field.getText().split(","));
        String personality2 = personality2Field.getText();
        String communicationStyle2 = communicationStyle2Field.getText();
        String conflictResolution2 = conflictResolution2Field.getText();
        List<String> values2 = Arrays.asList(values2Field.getText().split(","));

        // Create Person objects
        Person person1 = new Person(name1, age1, color1, hobbies1, interests1, personality1, communicationStyle1, conflictResolution1, values1);
        Person person2 = new Person(name2, age2, color2, hobbies2, interests2, personality2, communicationStyle2, conflictResolution2, values2);

        // Calculate compatibility (now returns double)
        double score = checker.checkCompatibility(person1, person2);

        // Show result (format to 2 decimal places)
        resultLabel.setText(String.format("Friendship Compatibility: %.2f%%", score));
    }
}
