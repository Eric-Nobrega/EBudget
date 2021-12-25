package com.example.ebudgetv1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;
import java.time.LocalDate;

public class AddIncomeController {
    //Declare Navigation Variables
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private DatePicker dp_SelectDate;

    @FXML
    private TextField tf_Category;

    @FXML
    private TextField tf_Amount;

    public void SwitchToMyBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("my-budget.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Add Income Amount & Category
    // Create instance/object of Transaction Class
    @FXML
    void addIncome(ActionEvent event) throws IOException {
        //Create Parameter Friendly Variables

        LocalDate dateParameter = dp_SelectDate.getValue();
        String SAmount = String.valueOf(tf_Amount.getText());
        int amount = Integer.parseInt(SAmount);
        String category = String.valueOf(tf_Category.getText());

        System.out.println(amount);
        System.out.println(category);

        File f = new File("C:/Users/Eric/IdeaProjects/EBudgetV1/src/main/resources/Serialisation/income.txt.txt");
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
