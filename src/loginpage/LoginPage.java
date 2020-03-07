/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        VBox vbox = new VBox(10,add,view);
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
       
     HBox hbox= new HBox(5 , sign,exit );
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
         String a= "ahmad123";
         String n = "narwa123";
         String s = "soso123";

        exit.setOnAction((ActionEvent ev)->{ 
        Platform.exit();
        System.exit(0);
        });
        
       File file = new File("input.txt");
        Scene scene2 = new Scene(vbox,300, 250);
        PrintWriter output = new PrintWriter(file);
        output.print("Ahamd "+MD5.hash(a)+"\n");
        output.print("narwa "+MD5.hash(n)+"\n");
        output.print("soso "+MD5.hash(s));
        output.close(); 
        Scanner input = new Scanner(file);

        
        
       
           sign.setOnAction((ActionEvent event) -> {
               String val =MD5.hash(password.getText());
               while(input.hasNext()){
                    String line = input.nextLine();
                   if (line.contains(val)&&line.contains(name.getText()) ){
                       scene2.getStylesheets().add("StyleFx.css");
                       primaryStage.setScene(scene2);
                       primaryStage.setTitle("Options page!");
                       primaryStage.show();
                          input.close();
                   }else{System.out.println("not working"); }
                   
                   
                   
               }
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
