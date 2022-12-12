import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class Controller {

    String name;
    Color seatColor;
    String[] nameSelected = { "", "", "", "", "", "", "", "", "" };
    Color[] colorSelected = new Color[9];
    int check = 0, count = 0, checkStatus = 0;
    int randomList[] = new int[9];
    Color defaultColor = new Color(0, 0, 0, 0);

    Random r = new Random();

    @FXML
    private Button addStudent;

    @FXML
    private ColorPicker color;

    @FXML
    private Label seatEight;

    @FXML
    private Label seatFive;

    @FXML
    private Label seatFour;

    @FXML
    private Label seatNine;

    @FXML
    private Label seatOne;

    @FXML
    private Label seatSeven;

    @FXML
    private Label seatSix;

    @FXML
    private Label seatThree;

    @FXML
    private Label seatTwo;

    @FXML
    private Label studentEight;

    @FXML
    private Label studentFive;

    @FXML
    private Label studentFour;

    @FXML
    private TextField studentName;

    @FXML
    private Label studentNine;

    @FXML
    private Label studentOne;

    @FXML
    private Label studentSeven;

    @FXML
    private Label studentSix;

    @FXML
    private Label studentThree;

    @FXML
    private Label studentTwo;

    @FXML
    private Label errorMsg;

    @FXML
    void onButtonClicked(ActionEvent event) {
        if (check == 0) {
            randomListMaker();
            check = 1;
        }
        name = studentName.getText();
        seatColor = color.getValue();
        checkStatus = 0;
        if (count > 0) {
            for (int i = 0; i <= count; i++) {
                if (nameSelected[i].equals(name)) {
                    errorMsg.setText(name + " is already present in class");
                    checkStatus = 1;
                    break;
                } else if (colorSelected[i] ==  seatColor) {
                    errorMsg.setText("Color is already taken");
                    checkStatus = 1;
                    break;
                } else if (count > 8) {
                    errorMsg.setText("Classroom is full");
                    checkStatus = 1;
                    break;
                }
            }
            if (checkStatus == 0) {
                checkInput(name, seatColor, randomList[count]);
                nameSelected[count] = name;
                colorSelected[count] = seatColor;
                color.setValue(defaultColor);
                errorMsg.setText("");
                studentName.setText("");
                count++;
            }
        } else {
            checkInput(name, seatColor, randomList[count]);
            nameSelected[count] = name;
            colorSelected[count] = seatColor;
            color.setValue(defaultColor);
            studentName.setText("");
            count++;
        }
    }

    public void randomListMaker() {
        for (int i = 0; i < 9; i++) {
            randomList[i] = r.nextInt(0, 9);
            for (int j = 0; j < i; j++) {
                if (randomList[i] == randomList[j]) {
                    i -= 1;
                    break;
                }
            }
        }
    }

    public void checkInput(String name, Color seatColor, int number) {
        switch (number) {
            case 0:
                studentOne.setText(name);
                seatOne.setTextFill(color.getValue());
                //seatOne.setTextFill(Color.web(name));
                //seatOne.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 1:

                studentTwo.setText(name);
                seatTwo.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 2:

                studentThree.setText(name);
                seatThree.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 3:

                studentFour.setText(name);
                seatFour.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 4:

                studentFive.setText(name);
                seatFive.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 5:

                studentSix.setText(name);
                seatSix.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 6:

                studentSeven.setText(name);
                seatSeven.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 7:

                studentEight.setText(name);
                seatEight.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

            case 8:

                studentNine.setText(name);
                seatNine.setBackground(new Background(new BackgroundFill(seatColor, CornerRadii.EMPTY, Insets.EMPTY)));
                break;

        }
    }   
}