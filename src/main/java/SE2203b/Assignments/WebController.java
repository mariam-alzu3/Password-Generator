package SE2203b.Assignments;

import com.jpro.webapi.JProApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class WebController implements Initializable
{
    @FXML
    private StackPane root;
    @FXML
    private ComboBox charLength;
    @FXML
    private Label newPassword;
    @FXML
    private CheckBox uppercase, lowercase, nums, symbols;

    protected JProApplication mainApplication;


    public void setData(){

        charLength.getItems().clear();

        charLength.getItems().addAll(
                "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
    }

    @FXML
    private void generatePassword(){
        String passwordLength = charLength.getValue().toString();
        int passLength = Integer.parseInt(passwordLength);

        Random r = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYX";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String characters = "!@#$%^&*()-=+[].,?/";
        String combo = "";

        //String upperAndNums = upper + numbers;

        //String combo = upper+lower+numbers+characters;
        char[] password = new char[passLength];


        //uppercase only
        if (uppercase.isSelected() && !lowercase.isSelected() && !nums.isSelected() && !symbols.isSelected()){

            for (int i = 0; i < passLength; i++) {
                password[i] = upper.charAt(r.nextInt(upper.length()));
            }
        }

        //lowercase only
        else if (!uppercase.isSelected() && lowercase.isSelected() && !nums.isSelected() && !symbols.isSelected()) {

            for (int i = 0; i < passLength; i++) {
                password[i] = lower.charAt(r.nextInt(lower.length()));
            }
        }

        //numbers only
        else if (!uppercase.isSelected() && !lowercase.isSelected() && nums.isSelected() && !symbols.isSelected()) {

            for (int i = 0; i < passLength; i++) {
                password[i] = numbers.charAt(r.nextInt(numbers.length()));
            }
        }

        //special chars only
        else if (!uppercase.isSelected() && !lowercase.isSelected() && !nums.isSelected() && symbols.isSelected()) {

            for (int i = 0; i < passLength; i++) {
                password[i] = characters.charAt(r.nextInt(characters.length()));
            }
        }

        //uppercase & numbers
        else if (uppercase.isSelected() && !lowercase.isSelected() && nums.isSelected() && !symbols.isSelected()) {
            combo += upper + numbers;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //uppercase and lowercase
        else if (uppercase.isSelected() && lowercase.isSelected() && !nums.isSelected() && !symbols.isSelected()) {
            combo += upper + lower;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //uppercase and chars
        else if (uppercase.isSelected() && !lowercase.isSelected() && !nums.isSelected() && symbols.isSelected()) {
            combo += upper + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //lowercase and numbers
        else if (!uppercase.isSelected() && lowercase.isSelected() && nums.isSelected() && !symbols.isSelected()) {
            combo += lower + numbers;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //lowercase and chars
        else if (!uppercase.isSelected() && lowercase.isSelected() && !nums.isSelected() && symbols.isSelected()) {
            combo += lower + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //numbers and chars
        else if (!uppercase.isSelected() && !lowercase.isSelected() && nums.isSelected() && symbols.isSelected()) {
            combo += numbers + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //upper lower and number
        else if (uppercase.isSelected() && lowercase.isSelected() && nums.isSelected() && !symbols.isSelected()) {
            combo += upper + lower + numbers;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //upper lower chars
        else if (uppercase.isSelected() && lowercase.isSelected() && !nums.isSelected() && symbols.isSelected()) {
            combo += upper + lower + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //upper numbers chars
        else if (uppercase.isSelected() && !lowercase.isSelected() && nums.isSelected() && symbols.isSelected()) {
            combo += upper + numbers + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //lower nums chars
        else if (!uppercase.isSelected() && lowercase.isSelected() && nums.isSelected() && symbols.isSelected()) {
            combo += lower + numbers + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        //all
        else if (uppercase.isSelected() && lowercase.isSelected() && nums.isSelected() && symbols.isSelected()) {
            combo += upper + lower + numbers + characters;

            for (int i = 0; i < passLength; i++) {
                password[i] = combo.charAt(r.nextInt(combo.length()));
            }
        }

        newPassword.setText(String.valueOf(password));
    }



    public void init(JProApplication jProApplication)
    {
        mainApplication = jProApplication;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
