package com.example.ebudgetv1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.net.URL;

public class MyBudgetController implements Initializable {

        //Declare Navigation Variables
        private Stage stage;
        private Scene scene;
        private Parent root;

        //Income FilePath
        final static String filePath = "C:/Users/Eric/IdeaProjects/EBudgetV1/src/main/resources/Serialisation/income.txt.txt";
        //Expenditure FilePath
        final static String filePath2 = "C:/Users/Eric/IdeaProjects/EBudgetV1/src/main/resources/Serialisation/expenditure.txt.txt";

        //FXML Tags
        @FXML
        private PieChart chart_PieChart;

        @FXML
        private PieChart chart_PieChart2;


        //Scene Interactivity
        @FXML
        void AddIncome(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("add-income.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void AddExpenditure(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("add-expenditure.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        //Navigation Methods
        // Remove this and replace with navigation to homepage
        @FXML
        void SwitchToMyBudget(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("my-budget.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void SwitchToFinancialProjection(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("finacial-projection.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void signOut(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        }

        public static Map<String, Integer> getHashMapFromTextFile() {

                Map<String, Integer> mapFileContents = new HashMap<String, Integer>();
                BufferedReader br = null;

                try {
                        //create file object
                        File file = new File(filePath);

                        //create BufferedReader object from the File
                        br = new BufferedReader(new FileReader(file));

                        String line = null;

                        //read file line by line
                        while ((line = br.readLine()) != null) {

                                //split the line by :
                                String[] parts = line.split(",");

                                //first part is category, second is amount
                                String category = parts[0].trim();
                                Integer amount = Integer.parseInt(parts[1].trim());

                                //put category, amount in HashMap if they are not empty
                                if (!category.equals("") && !amount.equals(""))
                                        mapFileContents.put(category, amount);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {

                        //Always close the BufferedReader
                        if (br != null) {
                                try {
                                        br.close();
                                } catch (Exception e) {
                                }
                                ;
                        }
                }

                return mapFileContents;

        }

        public static Map<String, Integer> getHashMapFromTextFile2() {

                Map<String, Integer> mapFileContents = new HashMap<String, Integer>();
                BufferedReader br = null;

                try {
                        //create file object
                        File file = new File(filePath2);

                        //create BufferedReader object from the File
                        br = new BufferedReader(new FileReader(file));

                        String line = null;

                        //read file line by line
                        while ((line = br.readLine()) != null) {

                                //split the line by :
                                String[] parts = line.split(",");

                                //first part is category, second is amount
                                String category = parts[0].trim();
                                Integer amount = Integer.parseInt(parts[1].trim());

                                //put category, amount in HashMap if they are not empty
                                if (!category.equals("") && !amount.equals(""))
                                        mapFileContents.put(category, amount);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {

                        //Always close the BufferedReader
                        if (br != null) {
                                try {
                                        br.close();
                                } catch (Exception e) {
                                }
                                ;
                        }
                }

                return mapFileContents;

        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                //read text file to HashMap
                Map<String, Integer> mapFromFile = getHashMapFromTextFile();

                //iterate over HashMap entries
                for (Map.Entry<String, Integer> entry : mapFromFile.entrySet()) {
                        PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                        chart_PieChart2.getData().add(slice);

                }

                //read text file to HashMap
                Map<String, Integer> mapFromFile2 = getHashMapFromTextFile2();

                //iterate over HashMap entries
                for (Map.Entry<String, Integer> entry : mapFromFile2.entrySet()) {
                        PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
                        chart_PieChart.getData().add(slice);
                }


                }
        }