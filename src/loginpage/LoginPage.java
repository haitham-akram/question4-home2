/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Haitham
 */
public class LoginPage extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        Button sign = new Button();
        Button exit = new Button();
        Button add = new Button();
        Button view = new Button();
        VBox vbox = new VBox(10, add, view);
        vbox.setAlignment(Pos.CENTER);
        
        TextField name = new TextField();
        PasswordField password = new PasswordField();
        Label user = new Label("User Name:");
        Label pass = new Label("Password:");
        Label wel = new Label("Welcome");
        wel.setId("la");
        user.setId("lab");
        pass.setId("lab");
        sign.setText("Sign up");
        exit.setText("Exit");
        add.setText("Add Studant");
        view.setText("View Studant");
        
        HBox hbox = new HBox(5, sign, exit);
        GridPane grid = new GridPane();
        grid.add(wel, 0, 0);
        grid.add(user, 0, 1);
        grid.add(pass, 0, 2);
        grid.add(name, 1, 1);
        grid.add(password, 1, 2);
        grid.add(hbox, 1, 3);
        grid.setHgap(8);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(0, 0, 0, 50));
        String a = "ahmad123";
        String n = "narwa123";
        String s = "soso123";
        
        exit.setOnAction((ActionEvent ev) -> {
            Platform.exit();
            System.exit(0);
        });
        
        File file = new File("input.txt");
        Scene scene2 = new Scene(vbox, 300, 250);
        PrintWriter output = new PrintWriter(file);
        output.print("Ahmad " + MD5.hash(a) + "\n");
        output.print("narwa " + MD5.hash(n) + "\n");
        output.print("soso " + MD5.hash(s));
        output.close();
        Scanner input = new Scanner(file);
        
        sign.setOnAction((ActionEvent event) -> {
            String val = MD5.hash(password.getText());
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.contains(val) && line.contains(name.getText())) {
                    scene2.getStylesheets().add("StyleFx.css");
                    primaryStage.setScene(scene2);
                    primaryStage.setTitle("Options page!");
                    primaryStage.show();
                    input.close();
                } else {
                    System.out.println("not working");
                }
                
            }
        });
        Label st = new Label("Studant Data");
        Label id1 = new Label("Id:");
        Label name1 = new Label("Name:");
        Label major1 = new Label("Major:");
        Label grade1 = new Label("Grade:");
        id1.setId("lab");
        name1.setId("lab");
        major1.setId("lab");
        grade1.setId("lab");
        st.setId("la");
        TextField Id = new TextField();
        TextField Name = new TextField();
        TextField Major = new TextField();
        TextField Grade = new TextField();
        ListView all = new ListView();
        GridPane grid1 = new GridPane();
        grid1.add(id1, 0, 0);
        grid1.add(Id, 1, 0);
        grid1.add(name1, 0, 1);
        grid1.add(Name, 1, 1);
        grid1.add(major1, 0, 2);
        grid1.add(Major, 1, 2);
        grid1.add(grade1, 0, 3);
        grid1.add(Grade, 1, 3);
        Button Adds = new Button("Add");
        Button Reset = new Button("Reset");
        Button Exit = new Button("Exit");
        HBox hbox3 = new HBox(7, Adds, Reset, Exit);
        grid1.add(hbox3, 1, 4);
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        hbox3.setPadding(new Insets(0, 0, 0, 50));
        GridPane grid2 = new GridPane();
        Label nul = new Label("");
        grid2.add(st, 0, 0);
        grid2.add(nul, 1, 0);
        grid2.add(grid1, 0, 1);
        grid2.add(all, 1, 1);
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(30, 0, 0, 0));
        grid2.setHgap(10);
        all.setPrefHeight(230);
        all.setPrefWidth(300);
        Scene scene3 = new Scene(grid2, 600, 500);
        add.setOnAction((ActionEvent event) -> {
            scene3.getStylesheets().add("StyleFx.css");
            primaryStage.setScene(scene3);
            primaryStage.setTitle("Studant entry page");
            primaryStage.show();
            
        });
        List<ClassStudant> list = new ArrayList<>();
        Adds.setOnAction((ActionEvent event) -> {
             //int i=0;
            int ID = Integer.parseInt(Id.getText());
            String NAME = Name.getText();
            String MAJOR = Major.getText();
            double GRADE = Double.parseDouble(Grade.getText());
            ClassStudant std = new ClassStudant(ID, NAME, MAJOR, GRADE);
          //ClassStudant[] info = new ClassStudant[i+1];
          //  info[i] = std;
            
            list.add(std);
            
 Collections.sort(list, (ClassStudant emp1, ClassStudant emp2) -> (Double.compare(emp2.getGrade(), emp1.getGrade())));
         

            all.getItems().setAll(list);
        }
        );
        
        Reset.setOnAction((ActionEvent event) -> {
            all.getItems().clear();
            list.clear();
        });
        Exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
            System.exit(0);
            
        });
        
        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add("StyleFx.css");
        primaryStage.setTitle("login page!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
