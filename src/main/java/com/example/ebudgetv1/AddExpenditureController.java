package com.example.ebudgetv1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class AddExpenditureController {
    //Declare Navigation Variables
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private DatePicker dp_SelectDate;

    @FXML
    private TextField tf_Category;

    @FXML
    private TextField tf_Submit;

    public void SwitchToMyBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("my-budget.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Add Income Entry & Category
    // Create instance/object of Transaction Class
    @FXML
    void addExpenditure(ActionEvent event) throws IOException {
        //Create Parameter Friendly Variables

        LocalDate dateParameter = dp_SelectDate.getValue();
        String SAmount = String.valueOf(tf_Submit.getText());
        int amount = Integer.parseInt(SAmount);
        String category = String.valueOf(tf_Category.getText());

        System.out.println(amount);
        System.out.println(category);

        File f = new File("C:/Users/Eric/IdeaProjects/EBudgetV1/src/main/resources/Serialisation/expenditure.txt.txt");
        try{
            if(f.exists()==false){
                System.out.println("File Does Not Exist");
                f.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(f, true));
                out.print(category + "," + amount + "\n");
                out.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }

}

