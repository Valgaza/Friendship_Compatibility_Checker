import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CompatibilityController {
    @FXML private TextField name1Field, name2Field, age1Field, age2Field;
    @FXML private TextField hobbies1Field, hobbies2Field, personality1Field, personality2Field;
    @FXML private Label resultLabel;
    @FXML private Button checkButton;

    public void handleCheckCompatibility() {
        if (!validateInputs()) return;

        try {
            int age1 = Integer.parseInt(age1Field.getText());
            int age2 = Integer.parseInt(age2Field.getText());

            Person person1 = new Person(
                name1Field.getText(), age1, "", personality1Field.getText(), 
                hobbies1Field.getText(), "", "");

            Person person2 = new Person(
                name2Field.getText(), age2, "", personality2Field.getText(), 
                hobbies2Field.getText(), "", "");

            double compatibility = CompatibilityChecker.calculateCompatibility(person1, person2);
            resultLabel.setText("Compatibility Score: " + compatibility + "%");

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers for age.");
        }
    }

    private boolean validateInputs() {
        if (name1Field.getText().isEmpty() || name2Field.getText().isEmpty()) {
            resultLabel.setText("Both names must be filled.");
            return false;
        }
        if (hobbies1Field.getText().isEmpty() || hobbies2Field.getText().isEmpty()) {
            resultLabel.setText("Both hobbies must be filled.");
            return false;
        }
        return true;
    }
}
