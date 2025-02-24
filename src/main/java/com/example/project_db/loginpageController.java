package com.example.project_db;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.sql.*;

import static javafx.application.Application.launch;

public class loginpageController {
    @FXML
    private Button loginButton;
    @FXML
    private JFXTextField Tusername;
    @FXML
    private JFXPasswordField Tpassword;
    @FXML
    private Label loginmessagelabel;

    @FXML
    private void setLoginButtonController() {
        if (Tusername.getText().isBlank() == false && Tpassword.getText().isBlank() == false) {
            loginpage();
        }

        else {
            loginmessagelabel.setText("Please Enter username and password");
        }
    }

    public void loginpage() {
        ConnectionDB connect = new ConnectionDB();
        Connection connection = connect.getConnection();

        String login = "SELECT positionn FROM Employee WHERE username = ? AND passwordd = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(login);
            preparedStatement.setString(1, Tusername.getText());
            preparedStatement.setString(2, Tpassword.getText());
            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next()) {
                String position = queryResult.getString("positionn");

                if ("Maneger".equals(position)) {
                    Parent manegerpage = FXMLLoader.load(getClass().getResource("maneger.FXML"));
                    Scene manegerpageScene = new Scene(manegerpage);

                    Stage window = (Stage) loginButton.getScene().getWindow();
                    window.setScene(manegerpageScene);
                    window.show();

                } else if("Driver".equals(position) || "Worker".equals(position)) {
                    Parent employeepage = FXMLLoader.load(getClass().getResource("employee.FXML"));
                    Scene employeepageScene = new Scene(employeepage);

                    Stage window = (Stage) loginButton.getScene().getWindow();
                    window.setScene(employeepageScene);
                    window.show();
                }
            } else {
                loginmessagelabel.setText("Incorrect Username or Password");
                Tpassword.setText("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
