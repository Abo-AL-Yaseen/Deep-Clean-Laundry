package com.example.project_db;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/*
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;*/
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;*/

import java.io.*;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;

import java.sql.*;


import javax.annotation.processing.Generated;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public class ManegerPageController {

    @FXML
    private TabPane tabbans;
    @FXML
    private Tab Hometab, employeeViewTab ,Employeeeditingtab ,CustomerView ,Customeredittab
            ,VehicleView ,Vehicleedittab ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations;

    @FXML
    private TableView employeeTable,customerTable ,ExpenseTable ,VehicleTable ,EmpVehTable ,AccountTable;

    @FXML
    private TableColumn<Map<String, Object>, Integer> idColumn;
    @FXML
    private TableColumn<Map<String, Object>, String> FnameColumn, SnameColumn, LnameColumn,
            idNumberColumn, cityColumn, streetColumn, positionColumn, startDateColumn ,usernameemp ,passwordemp;
    @FXML
    private TableColumn<Map<String, Object>, Double> salaryColumn;


    @FXML
    private TableColumn<Map<String, Object>, Integer> idColumncustomer, apartmentNumColumncustomer ,phoneColumncustomer
            ,rugQuantityColumncustomer, blanketQuantityColumncustomer;

    @FXML
    private TableColumn<Map<String, Object>, String> nameColumncustomer, cityColumncustomer, streetColumncustomer,
            rugStatusColumncustomer, rugDeliveryDateColumncustomer,
            blanketStatusColumncustomer, blanketDeliveryDateColumncustomer;

    @FXML
    private TableColumn<Map<String, Object>, Double> rugSizeColumncustomer ,rugPriceColumncustomer, blanketPriceColumncustomer, totalPriceColumncustomer;

    @FXML
    private TableColumn<Map<String, Object>, Double> totalIncomeColumn ,totalExpenseColumn ,profetColumn;




    @FXML
    private TableColumn<Map<String ,Object>, Integer> IdExpensecolumn ,AmountExpensecolumn;
    @FXML
    private TableColumn<Map<String, Object>, String> ExpenseTypecolumn ,Expensedatecolumn;

    @FXML
    private TableColumn<Map<String, Object>, Integer> Vehicleidcolumn;
    @FXML
    private TableColumn<Map<String, Object>, String> registraionnumbercolumn, Modelcolumn ,purchasedatecolumn;


    @FXML
    private TableColumn<Map<String, Object>, Integer> empidcolumn ,vehiidcolumn;

    @FXML
    private Button HomeButton ,EmployeeButton ,CustomerButton ,ExpenseButton
            ,VehicleButton ,AccountButton ,EmpVehButton ,LogoutButton;

    @FXML
    private Button addc ,updatec ,deletec
            ,addemp ,updateemp ,deleteemp
            ,addexp ,updateexp
            ,addveh ,updateveh;


    @FXML
    private Button AddEmployee ,UpdateemplButton ,searchupdateempButton,
            deleteempButton ,searchdeleteemp;
    @FXML
    private TextField FNameempadd ,SNameempadd ,LNameempadd ,IDNumberempadd,
            Cityempadd ,Streetempadd ,Positionempadd ,Salaryempadd ,Usernameempadd
            ,Passwordempadd;
    @FXML
    private DatePicker Startdateempadd ,Startdateempupdate ,Startdateempdelete;

    @FXML
    private TextField employeeidempupdate ,FNameempupdate, SNameempupdate, LNameempupdate, IDNumberempupdate,
            Cityempupdate, Streetempupdate, Positionempupdate, Salaryempupdate, Usernameempupdate,
            Passwordempupdate;

    @FXML
    private TextField employeeidempdelete, FNameempdelete, SNameempdelete, LNameempdelete, IDNumberempdelete,
            Cityempdelete, Streetempdelete, Positionempdelete, Salaryempdelete, Usernameempdelete,
            Passwordempdelete;




    @FXML
    private Pane addingcustomer ,updatingcustomer ,deleteingcustomer ,
            addingemployee, updatingemployee ,deleteingemployee
            ,addingexpense ,updatingexpense
            ,addingvehicle ,updatingvehicle;

    @FXML
    private Button AddCustomerButton;
    @FXML
    private TextField FNameadd, SNameadd, LNameadd, CsPhoneNumadd, Cityadd, Streetadd,
            ApartmentNumadd, Rugsizeadd, RugQuntityadd, RugStatusadd, RugPriceadd,
            BlanketQuntityadd, BlanketStatusadd, BlanketPriceadd;


    @FXML
    private Button UpdateCustomerButton ,Searchupdate;
    @FXML
    private TextField CustomerIDupdate, FNameupdate, SNameupdate, LNameupdate, CsPhoneNumupdate, Cityupdate, Streetupdate,
            ApartmentNumupdate, Rugsizeupdate, RugQuntityupdate, RugStatusupdate, RugPriceupdate,
            BlanketQuntityupdate, BlanketStatusupdate, BlanketPriceupdate, TotalPriceupdate;
    @FXML
    private DatePicker deliverydateBlanket ,deliverydateRug
            ,dateexpenseadd ,dateexpenseupdate
            ,purchasedateadd ,purchasedateupdate
            ,startdateaccount ,enddateaccount
            ,assignmentdate;


    @FXML
    private Button DeleteCustomerButton ,SearchCustomerButton;
    @FXML
    private TextField CustomerIDdelete, FNamedelete, SNamedelete, LNamedelete, CsPhoneNumdelete, Citydelete, Streetdelete,
            ApartmentNumdelete, Rugsizedelete, RugQuntitydelete, RugStatusdelete, RugPricedelete,
            BlanketQuntitydelete, BlanketStatusdelete, BlanketPricedelete, TotalPricedelete;


    @FXML
    private TextField ExpenseTypeadd ,AmountOfExpenseadd
            ,ExpenseIDupdate ,ExpenseTypeupdate ,AmountOfExpenseupdate;

    @FXML
    private Button AddExpense, UpdateExpense ,SearchExpenseUpdate;


    @FXML
    private TextField registraionnumberadd ,modeladd ,vehicleid ,registraionnumberupdate ,modelupdate;
    @FXML
    private Button BuyVehicle ,sellvehicle ,searchvehicle;


    @FXML
    private Button getallinformationaccount ,getGetallinformationempveh;

    @FXML
    private Label numofcustomer, numofvehicle ,numofemployee;

    @FXML
    private BarChart<?, ?> charmaneger;

    @FXML
    private Button reportexpense ,reportaccount;



    private void TableColumnsemp() {
        idColumn.setCellValueFactory(cellData -> {
            Integer idValue = (Integer) cellData.getValue().get("employeeid");
            return new SimpleIntegerProperty(idValue != null ? idValue : 0).asObject();
        });
        FnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("f_name")));
        SnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("s_name")));
        LnameColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("l_name")));
        idNumberColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("idnumber")));
        cityColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("city")));
        streetColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("street")));
        positionColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("positionn")));
        salaryColumn.setCellValueFactory(cellData -> {
            Double salaryValue = (Double) cellData.getValue().get("salary");
            return new SimpleDoubleProperty(salaryValue != null ? salaryValue : 0.0).asObject();
        });
        startDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("startdate")));
        usernameemp.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("username")));
        passwordemp.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("passwordd")));
    }
    private void loadInformationEmp() {
        ObservableList<Map<String, Object>> employees = FXCollections.observableArrayList();

        try  {
            Connection connection = new ConnectionDB().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeid, f_name, s_name, l_name, " +
                    "idnumber, city, street, positionn, salary, startdate ,username, passwordd FROM Employee");

            while (resultSet.next()) {
                Map<String, Object> employeeData = new HashMap<>();
                employeeData.put("employeeid", resultSet.getInt("employeeid"));
                employeeData.put("f_name", resultSet.getString("f_name"));
                employeeData.put("s_name", resultSet.getString("s_name"));
                employeeData.put("l_name", resultSet.getString("l_name"));
                employeeData.put("idnumber", resultSet.getString("idnumber"));
                employeeData.put("city", resultSet.getString("city"));
                employeeData.put("street", resultSet.getString("street"));
                employeeData.put("positionn", resultSet.getString("positionn"));
                employeeData.put("salary", resultSet.getDouble("salary"));
                employeeData.put("startdate", resultSet.getDate("startdate").toString());
                employeeData.put("username", resultSet.getString("username"));
                employeeData.put("passwordd", resultSet.getString("passwordd"));

                employees.add(employeeData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        employeeTable.setItems(employees);
    }

    private void TableColumnscustomer() {
        idColumncustomer.setCellValueFactory(cellData -> {
            Integer idValue = (Integer) cellData.getValue().get("customerid");
            return new SimpleIntegerProperty(idValue != null ? idValue : 0).asObject();
        });
        nameColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("Name")));
        phoneColumncustomer.setCellValueFactory(cellData -> {
            Integer phoneNumberValue = (Integer) cellData.getValue().get("phonenumber");
            return new SimpleIntegerProperty(phoneNumberValue != null ? phoneNumberValue : 0).asObject();
        });
        cityColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("city")));
        streetColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("street")));
        apartmentNumColumncustomer.setCellValueFactory(cellData -> {
            Integer apartmentNumValue = (Integer) cellData.getValue().get("apartmentnumber");
            return new SimpleIntegerProperty(apartmentNumValue != null ? apartmentNumValue : 0).asObject();
        });

        rugSizeColumncustomer.setCellValueFactory(cellData -> {
            Double rugSizeValue = (Double) cellData.getValue().get("rugsizze");
            return new SimpleDoubleProperty(rugSizeValue != null ? rugSizeValue : 0.0).asObject();
        });
        rugQuantityColumncustomer.setCellValueFactory(cellData -> {
            Integer quantityValue = (Integer) cellData.getValue().get("rugquantity");
            return new SimpleIntegerProperty(quantityValue != null ? quantityValue : 0).asObject();
        });
        rugStatusColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("rugstatus")));
        rugPriceColumncustomer.setCellValueFactory(cellData -> {
            Double priceValue = (Double) cellData.getValue().get("rugprice");
            return new SimpleDoubleProperty(priceValue != null ? priceValue : 0.0).asObject();
        });
        rugDeliveryDateColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("rugdeliverydate")));

        blanketQuantityColumncustomer.setCellValueFactory(cellData -> {
            Integer quantityValue = (Integer) cellData.getValue().get("blanketquantity");
            return new SimpleIntegerProperty(quantityValue != null ? quantityValue : 0).asObject();
        });
        blanketStatusColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("blanketstatus")));
        blanketPriceColumncustomer.setCellValueFactory(cellData -> {
            Double priceValue = (Double) cellData.getValue().get("blanketprice");
            return new SimpleDoubleProperty(priceValue != null ? priceValue : 0.0).asObject();
        });
        blanketDeliveryDateColumncustomer.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("blanketdeliverydate")));

        totalPriceColumncustomer.setCellValueFactory(cellData -> {
            Double totalPriceValue = (Double) cellData.getValue().get("Pr_total");
            return new SimpleDoubleProperty(totalPriceValue != null ? totalPriceValue : 0.0).asObject();
        });
    }
    private void loadInformationcustomer() {
        ObservableList<Map<String, Object>> items = FXCollections.observableArrayList();

        try  {
            Connection connection = new ConnectionDB().getConnection();
            Statement statement = connection.createStatement();

            String viewinformation = "SELECT Customer.customerid, " +
                    "CONCAT(Customer.f_name, ' ', Customer.s_name, ' ', Customer.l_name) AS Name, " +
                    "Customer.phonenumber, Customer.city, Customer.street, Customer.apartmentnumber, " +
                    "Rug.rugsizze, Rug.rugquantity, Rug.rugstatus, Rug.rugprice, Rug.rugdeliverydate, " +
                    "Blanket.blanketquantity, Blanket.blanketstatus, Blanket.blanketprice, Blanket.blanketdeliverydate, " +
                    "(COALESCE(Rug.rugsizze * 6, 0) + COALESCE(Blanket.blanketprice, 0)) AS Pr_total " +
                    "FROM Customer " +
                    "LEFT JOIN Rug ON Customer.customerid = Rug.customerid " +
                    "LEFT JOIN Blanket ON Customer.customerid = Blanket.customerid";



            ResultSet resultSet = statement.executeQuery(viewinformation);

            while (resultSet.next()) {
                Map<String, Object> information = new HashMap<>();
                information.put("customerid", resultSet.getInt("customerid"));
                information.put("Name", resultSet.getString("Name"));
                information.put("phonenumber", resultSet.getInt("phonenumber"));
                information.put("city", resultSet.getString("city"));
                information.put("street", resultSet.getString("street"));
                information.put("apartmentnumber", resultSet.getInt("apartmentnumber"));

                information.put("rugsizze", resultSet.getDouble("rugsizze"));
                information.put("rugquantity", resultSet.getInt("rugquantity"));
                information.put("rugstatus", resultSet.getString("rugstatus"));
                information.put("rugprice", resultSet.getDouble("rugprice"));
                information.put("rugdeliverydate", resultSet.getDate("rugdeliverydate") != null ? resultSet.getDate("rugdeliverydate").toString() : null);

                information.put("blanketquantity", resultSet.getInt("blanketquantity"));
                information.put("blanketstatus", resultSet.getString("blanketstatus"));
                information.put("blanketprice", resultSet.getDouble("blanketprice"));
                information.put("blanketdeliverydate", resultSet.getDate("blanketdeliverydate") != null ? resultSet.getDate("blanketdeliverydate").toString() : null);

                information.put("Pr_total", resultSet.getDouble("Pr_total"));

                items.add(information);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        customerTable.setItems(items);
    }



    private void TableColumnExpense() {
        IdExpensecolumn.setCellValueFactory(cellData -> new SimpleIntegerProperty((Integer)
                cellData.getValue().getOrDefault("expenseid", 0)).asObject());
        ExpenseTypecolumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("expensetype")));
        AmountExpensecolumn.setCellValueFactory(cellData -> {
            Integer amount = (Integer) cellData.getValue().getOrDefault("amount", 0);
            return new SimpleIntegerProperty(amount).asObject();
        });
        Expensedatecolumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("datee")));
    }
    private void loadInformationExpense() {
        ObservableList<Map<String, Object>> Expenses = FXCollections.observableArrayList();

        try  {
            Connection connection = new ConnectionDB().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT expenseid, expensetype, amount, datee FROM expense");

            while (resultSet.next()) {
                Map<String, Object> ExpenseData = new HashMap<>();
                ExpenseData.put("expenseid", resultSet.getInt("expenseid"));
                ExpenseData.put("expensetype", resultSet.getString("expensetype"));
                ExpenseData.put("amount", resultSet.getInt("amount"));
                ExpenseData.put("datee", resultSet.getDate("datee").toString());

                Expenses.add(ExpenseData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        ExpenseTable.setItems(Expenses);
    }

    private void TableColumnVehicle() {
        Vehicleidcolumn.setCellValueFactory(cellData -> new SimpleIntegerProperty((Integer)
                cellData.getValue().getOrDefault("vehicleid", 0)).asObject());
        registraionnumbercolumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("registraionnumber")));
        Modelcolumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("model")));
        purchasedatecolumn.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get("purchasedate")));
    }
    private void loadInformationVehicle() {
        ObservableList<Map<String, Object>> Vehicles = FXCollections.observableArrayList();

        try  {
            Connection connection = new ConnectionDB().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT vehicleid, registraionnumber, model, purchasedate FROM Vehicle");

            while (resultSet.next()) {
                Map<String, Object> VehicleData = new HashMap<>();
                VehicleData.put("vehicleid", resultSet.getInt("vehicleid"));
                VehicleData.put("registraionnumber", resultSet.getString("registraionnumber"));
                VehicleData.put("model", resultSet.getString("model"));
                VehicleData.put("purchasedate", resultSet.getDate("purchasedate").toString());

                Vehicles.add(VehicleData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        VehicleTable.setItems(Vehicles);
    }

    private void TableColumnAccount() {
        totalIncomeColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(
                (Double) cellData.getValue().getOrDefault("total_income", 0.0)).asObject());
        totalExpenseColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(
                (Double) cellData.getValue().getOrDefault("total_expenses", 0.0)).asObject());
        profetColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(
                (Double) cellData.getValue().getOrDefault("profet", 0.0)).asObject());
    }
    private void loadAccountInformation(LocalDate startDate, LocalDate endDate) {
        ObservableList<Map<String, Object>> accountData = FXCollections.observableArrayList();

        try {
            Connection connection = new ConnectionDB().getConnection();

            String calculateQuery = "SELECT " +
                    "(SELECT COALESCE(SUM(rugprice), 0) FROM Rug WHERE rugstatus = 'تم التسليم' AND rugdeliverydate BETWEEN ? AND ?) " +
                    "+ (SELECT COALESCE(SUM(blanketprice), 0) FROM Blanket WHERE blanketstatus = 'تم التسليم' AND blanketdeliverydate BETWEEN ? AND ?) AS total_income, " +
                    "(SELECT COALESCE(SUM(amount), 0) FROM Expense WHERE Datee BETWEEN ? AND ?) AS total_expenses, " +
                    "( " +
                    "(SELECT COALESCE(SUM(rugprice), 0) FROM Rug WHERE rugstatus = 'تم التسليم' AND rugdeliverydate BETWEEN ? AND ?) " +
                    "+ (SELECT COALESCE(SUM(blanketprice), 0) FROM Blanket WHERE blanketstatus = 'تم التسليم' AND blanketdeliverydate BETWEEN ? AND ?) " +
                    ") - " +
                    "(SELECT COALESCE(SUM(amount), 0) FROM Expense WHERE Datee BETWEEN ? AND ?) AS profet";

            PreparedStatement calculateStmt = connection.prepareStatement(calculateQuery);
            calculateStmt.setDate(1, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(2, java.sql.Date.valueOf(endDate));
            calculateStmt.setDate(3, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(4, java.sql.Date.valueOf(endDate));
            calculateStmt.setDate(5, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(6, java.sql.Date.valueOf(endDate));
            calculateStmt.setDate(7, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(8, java.sql.Date.valueOf(endDate));
            calculateStmt.setDate(9, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(10, java.sql.Date.valueOf(endDate));
            calculateStmt.setDate(11, java.sql.Date.valueOf(startDate));
            calculateStmt.setDate(12, java.sql.Date.valueOf(endDate));

            ResultSet calculateRs = calculateStmt.executeQuery();

            double totalIncome = 0, totalExpenses = 0, profet = 0;

            if (calculateRs.next()) {
                totalIncome = calculateRs.getDouble("total_income");
                totalExpenses = calculateRs.getDouble("total_expenses");
                profet = calculateRs.getDouble("profet");
            }

            String insertQuery = "INSERT INTO account (startdate, enddate, total_income, total_expenses, profet) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setDate(1, java.sql.Date.valueOf(startDate));
            insertStmt.setDate(2, java.sql.Date.valueOf(endDate));
            insertStmt.setDouble(3, totalIncome);
            insertStmt.setDouble(4, totalExpenses);
            insertStmt.setDouble(5, profet);
            insertStmt.executeUpdate();


            String selectQuery = "SELECT startdate, enddate, total_income, total_expenses, profet FROM account WHERE startdate = ? AND enddate = ? ORDER BY startdate DESC";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setDate(1, java.sql.Date.valueOf(startDate));
            selectStmt.setDate(2, java.sql.Date.valueOf(endDate));
            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> dataRow = new HashMap<>();
                dataRow.put("startdate", rs.getDate("startdate"));
                dataRow.put("enddate", rs.getDate("enddate"));
                dataRow.put("total_income", rs.getDouble("total_income"));
                dataRow.put("total_expenses", rs.getDouble("total_expenses"));
                dataRow.put("profet", rs.getDouble("profet"));

                accountData.add(dataRow);
            }

            AccountTable.setItems(accountData);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            e.printStackTrace();
        }
    }

    private void TableColumnEmployeeVehicle() {
        empidcolumn.setCellValueFactory(cellData -> new SimpleIntegerProperty((Integer)
                cellData.getValue().getOrDefault("employeeid", 0)).asObject());
        vehiidcolumn.setCellValueFactory(cellData -> new SimpleIntegerProperty((Integer)
                cellData.getValue().getOrDefault("vehicleid", 0)).asObject());
    }
    private void loadInformationEmployeeVehicle(LocalDate selectedDate) {
        ObservableList<Map<String, Object>> employeeVehicleData = FXCollections.observableArrayList();

        try {
            Connection connection = new ConnectionDB().getConnection();
            String query = "SELECT employeeid, vehicleid, assignmentdate FROM employeevehicle WHERE assignmentdate = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDate(1, java.sql.Date.valueOf(selectedDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Map<String, Object> dataRow = new HashMap<>();
                dataRow.put("employeeid", resultSet.getInt("employeeid"));
                dataRow.put("vehicleid", resultSet.getInt("vehicleid"));

                employeeVehicleData.add(dataRow);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        EmpVehTable.setItems(employeeVehicleData);
    }



    @FXML
    private void HomeButtonDash() {
        Tab[] tab = {employeeViewTab, Employeeeditingtab, CustomerView, Customeredittab,
                VehicleView, Vehicleedittab, ExpenseView, Expenseedittab, AccountView, Carresrvations};

        Hometab.setDisable(false);
        tabbans.getSelectionModel().select(Hometab);
        for (Tab tabs : tab) {
            tabs.setDisable(true);
        }

        String getnumcustomer = "select count(customerid) from customer;";
        String getnumveh = "select count(vehicleid) from vehicle;";
        String getnumemp = "select count(employeeid) from employee;";
        int cust = 0, veh = 0, emp = 0;
        try {
            Connection connection = new ConnectionDB().getConnection();

            PreparedStatement preparedStatementcustomer = connection.prepareStatement(getnumcustomer);
            ResultSet rs1 = preparedStatementcustomer.executeQuery();
            if (rs1.next()) {
                int numCustomers = rs1.getInt(1);
                numofcustomer.setText(String.valueOf(numCustomers));
                cust = numCustomers;
            }
            rs1.close();
            preparedStatementcustomer.close();

            PreparedStatement preparedStatementvehicle = connection.prepareStatement(getnumveh);
            ResultSet rs2 = preparedStatementvehicle.executeQuery();
            if (rs2.next()) {
                int numVehicles = rs2.getInt(1);
                numofvehicle.setText(String.valueOf(numVehicles));
                veh = numVehicles;
            }
            rs2.close();
            preparedStatementvehicle.close();

            PreparedStatement preparedStatementemployee = connection.prepareStatement(getnumemp);
            ResultSet rs3 = preparedStatementemployee.executeQuery();
            if (rs3.next()) {
                int numEmployees = rs3.getInt(1);
                numofemployee.setText(String.valueOf(numEmployees));
                emp = numEmployees;
            }
            rs3.close();
            preparedStatementemployee.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        XYChart.Series customer = new XYChart.Series();
        customer.setName("Number of Customer");
        customer.getData().add(new XYChart.Data("Customer",cust));

        XYChart.Series vehicle = new XYChart.Series();
        vehicle.setName("Number of Vehicle");
        vehicle.getData().add(new XYChart.Data("Vehicle",veh));

        XYChart.Series employee = new XYChart.Series();
        employee.setName("Number of Employee");
        employee.getData().add(new XYChart.Data("Employee",emp));

        charmaneger.getData().addAll(customer ,vehicle ,employee);


    }


    @FXML
    private void EmployeeButtonDash() {
        Tab[] tab = {Hometab,Employeeeditingtab ,CustomerView ,Customeredittab
                ,VehicleView ,Vehicleedittab ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations
        };
        employeeViewTab.setDisable(false);
        tabbans.getSelectionModel().select(employeeViewTab);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnsemp();
        loadInformationEmp();

    }

    @FXML
    private void CustomerButtonDash() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,Customeredittab
                ,VehicleView ,Vehicleedittab ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations
        };
        CustomerView.setDisable(false);
        tabbans.getSelectionModel().select(CustomerView);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnscustomer();
        loadInformationcustomer();
    }

    @FXML
    private void ExpenseButtonDash() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,Customeredittab ,CustomerView
                ,VehicleView ,Vehicleedittab ,Expenseedittab ,AccountView ,Carresrvations
        };
        ExpenseView.setDisable(false);
        tabbans.getSelectionModel().select(ExpenseView);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnExpense();
        loadInformationExpense();
    }

    @FXML
    private void VehicleButtonDash() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,Customeredittab ,CustomerView
                ,Vehicleedittab ,Expenseedittab ,ExpenseView ,AccountView ,Carresrvations
        };
        VehicleView.setDisable(false);
        tabbans.getSelectionModel().select(VehicleView);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnVehicle();
        loadInformationVehicle();

    }

    @FXML
    private void AccountButtonDash() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,Customeredittab ,CustomerView
                ,Vehicleedittab ,VehicleView ,Expenseedittab ,ExpenseView ,Carresrvations
        };
        AccountView.setDisable(false);
        tabbans.getSelectionModel().select(AccountView);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    @FXML
    private void empvehButtonDash() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,Customeredittab ,CustomerView
                ,Vehicleedittab ,VehicleView ,Expenseedittab ,ExpenseView,AccountView
        };
        Carresrvations.setDisable(false);
        tabbans.getSelectionModel().select(Carresrvations);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    @FXML
    private void LogoutButtonDash() {
        try {
            Parent manegerpage = FXMLLoader.load(getClass().getResource("login_frame.FXML"));
            Scene manegerpageScene = new Scene(manegerpage);

            Stage window = (Stage) LogoutButton.getScene().getWindow();
            window.setScene(manegerpageScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading the login page.");
        }
    }




    private void Visableemployeeadd(int count) {
        if(count == 0)
            addingemployee.setVisible(false);
        else
            addingemployee.setVisible(true);
    }

    private void Visableemployeeupdate(int count) {
        if(count == 0)
            updatingemployee.setVisible(false);
        else
            updatingemployee.setVisible(true);
    }

    private void Visableemployeedelete(int count) {
        if(count == 0)
            deleteingemployee.setVisible(false);
        else
            deleteingemployee.setVisible(true);
    }

    private boolean FieldsFilledInformationEmployeeadd() {
        List<TextField> textFields = Arrays.asList(FNameempadd ,SNameempadd ,LNameempadd
                ,IDNumberempadd , Cityempadd ,Streetempadd ,Positionempadd
                ,Salaryempadd ,Usernameempadd ,Passwordempadd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private void removeTabemployee() {
        Tab[] tab = {Hometab,employeeViewTab ,Customeredittab ,CustomerView
                ,VehicleView ,Vehicleedittab ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations
        };
        Employeeeditingtab.setDisable(false);
        tabbans.getSelectionModel().select(Employeeeditingtab);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }
    @FXML
    private void addemployee() {

        removeTabemployee();
        Visableemployeeadd(1);
        Visableemployeeupdate(0);
        Visableemployeedelete(0);
    }

    @FXML
    private void updateemployee() {

        removeTabemployee();
        Visableemployeeadd(0);
        Visableemployeeupdate(1);
        Visableemployeedelete(0);
    }

    @FXML
    private void deleteemployee() {

        removeTabemployee();
        Visableemployeeadd(0);
        Visableemployeeupdate(0);
        Visableemployeedelete(1);
    }


    private void clearFieldsAfteraddemp() {
        List<TextField> textFields = Arrays.asList(FNameempadd ,SNameempadd ,LNameempadd ,IDNumberempadd,
                Cityempadd ,Streetempadd ,Positionempadd ,Salaryempadd ,Usernameempadd
                ,Passwordempadd
                ,employeeidempupdate ,FNameempupdate, SNameempupdate, LNameempupdate, IDNumberempupdate,
                Cityempupdate, Streetempupdate, Positionempupdate, Salaryempupdate, Usernameempupdate,
                Passwordempupdate
                ,employeeidempdelete, FNameempdelete, SNameempdelete, LNameempdelete, IDNumberempdelete,
                Cityempdelete, Streetempdelete, Positionempdelete, Salaryempdelete, Usernameempdelete,
                Passwordempdelete);


        textFields.forEach(field -> field.setText(""));
    }

    @FXML
    private void AddEmployeeController() {
        if(FieldsFilledInformationEmployeeadd()) {
            addemployeeInformation();
        }
    }

    private void addemployeeInformation() {
        String insertemployee = "INSERT INTO employee(f_name, s_name, l_name ,idnumber ,city ,street, positionn," +
                " salary ,startdate, username, passwordd)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement preparedStatementemployee = connection.prepareStatement(insertemployee);
            connection.setAutoCommit(false);
            preparedStatementemployee.setString(1,FNameempadd.getText());
            preparedStatementemployee.setString(2,LNameempadd.getText());
            preparedStatementemployee.setString(3,LNameempadd.getText());
            preparedStatementemployee.setLong(4,Long.parseLong(IDNumberempadd.getText()));
            preparedStatementemployee.setString(5,Cityempadd.getText());
            preparedStatementemployee.setString(6,Streetempadd.getText());
            preparedStatementemployee.setString(7,Positionempadd.getText());
            preparedStatementemployee.setInt(8,Integer.parseInt(Salaryempadd.getText()));
            preparedStatementemployee.setDate(9, java.sql.Date.valueOf(Startdateempadd.getValue()));
            preparedStatementemployee.setString(10,Usernameempadd.getText());
            preparedStatementemployee.setString(11,Passwordempadd.getText());

            preparedStatementemployee.executeUpdate();

            connection.commit();
            connection.close();
            JOptionPane.showMessageDialog(null, "Information added successfully!");
            clearFieldsAfteraddemp();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchtoupdateemp() {
        String EmployeeIdStr = employeeidempupdate.getText();
        if (EmployeeIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Employee ID.");
        }
        int EmployeeId = Integer.parseInt(EmployeeIdStr);
        String EmployeeQuery = "SELECT * FROM Employee WHERE employeeid = ?";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement EmployeeStatement = connection.prepareStatement(EmployeeQuery);
            EmployeeStatement.setInt(1, EmployeeId);

            ResultSet EmployeeResultSet = EmployeeStatement.executeQuery();
            if (EmployeeResultSet.next()) {
                FNameempupdate.setText(EmployeeResultSet.getString("f_name"));
                SNameempupdate.setText(EmployeeResultSet.getString("s_name"));
                LNameempupdate.setText(EmployeeResultSet.getString("l_name"));
                IDNumberempupdate.setText(EmployeeResultSet.getString("idnumber"));
                Cityempupdate.setText(EmployeeResultSet.getString("city"));
                Streetempupdate.setText(EmployeeResultSet.getString("street"));
                Positionempupdate.setText(EmployeeResultSet.getString("positionn"));
                Salaryempupdate.setText(EmployeeResultSet.getString("salary"));
                Date sqlDate = EmployeeResultSet.getDate("startdate");
                LocalDate localDate = sqlDate.toLocalDate();
                Startdateempupdate.setValue(localDate);
                Usernameempupdate.setText(EmployeeResultSet.getString("username"));
                Passwordempupdate.setText(EmployeeResultSet.getString("passwordd"));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void UpdateInformationemployee() {
        String employeeIdStr = employeeidempupdate.getText();
        if (employeeIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Employee ID.");
        }

        String updateempQuery = "UPDATE employee SET f_name=?, s_name=?, l_name=?, idnumber=?, city=?, " +
                "street=?, positionn=?, salary=?, startdate=?, username=?, passwordd=? WHERE employeeid = ?;";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement updateUpdateStatement = connection.prepareStatement(updateempQuery)) {

            updateUpdateStatement.setString(1, FNameempupdate.getText());
            updateUpdateStatement.setString(2, SNameempupdate.getText());
            updateUpdateStatement.setString(3, LNameempupdate.getText());
            updateUpdateStatement.setLong(4, Long.parseLong(IDNumberempupdate.getText()));
            updateUpdateStatement.setString(5, Cityempupdate.getText());
            updateUpdateStatement.setString(6, Streetempupdate.getText());
            updateUpdateStatement.setString(7, Positionempupdate.getText());
            updateUpdateStatement.setInt(8, Integer.parseInt(Salaryempupdate.getText()));
            updateUpdateStatement.setDate(9, java.sql.Date.valueOf(Startdateempupdate.getValue()));
            updateUpdateStatement.setString(10, Usernameempupdate.getText());
            updateUpdateStatement.setString(11, Passwordempupdate.getText());
            updateUpdateStatement.setLong(12, Long.parseLong(employeeIdStr));

            int rowsAffected = updateUpdateStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee information updated successfully.");
                clearFieldsAfteraddemp();
            } else {
                JOptionPane.showMessageDialog(null, "No Employee information updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating employee information.");
        }
    }

    @FXML
    private void searchtodeleteemp() {
        String EmployeeIdStr = employeeidempdelete.getText();
        if (EmployeeIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Employee ID.");
        }
        int EmployeeId = Integer.parseInt(EmployeeIdStr);
        String EmployeeQuery = "SELECT * FROM Employee WHERE employeeid = ?";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement EmployeeStatement = connection.prepareStatement(EmployeeQuery);
            EmployeeStatement.setInt(1, EmployeeId);

            ResultSet EmployeeResultSet = EmployeeStatement.executeQuery();
            if (EmployeeResultSet.next()) {
                FNameempdelete.setText(EmployeeResultSet.getString("f_name"));
                SNameempdelete.setText(EmployeeResultSet.getString("s_name"));
                LNameempdelete.setText(EmployeeResultSet.getString("l_name"));
                IDNumberempdelete.setText(EmployeeResultSet.getString("idnumber"));
                Cityempdelete.setText(EmployeeResultSet.getString("city"));
                Streetempdelete.setText(EmployeeResultSet.getString("street"));
                Positionempdelete.setText(EmployeeResultSet.getString("positionn"));
                Salaryempdelete.setText(EmployeeResultSet.getString("salary"));
                Date sqlDate = EmployeeResultSet.getDate("startdate");
                LocalDate datee = sqlDate.toLocalDate();
                Startdateempdelete.setValue(datee);
                Usernameempdelete.setText(EmployeeResultSet.getString("username"));
                Passwordempdelete.setText(EmployeeResultSet.getString("passwordd"));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteinformationemp() {
        String customerIdStr = employeeidempdelete.getText();
        if (customerIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
        }

        try {
            int customerId = Integer.parseInt(customerIdStr);
            String deleteEmployeeQuery = "DELETE FROM Employee WHERE employeeid = ?";
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement deleteEmployeeStatement = connection.prepareStatement(deleteEmployeeQuery);

            deleteEmployeeStatement.setInt(1, customerId);
            int rowsAffected = deleteEmployeeStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                clearFieldsAfteraddemp();
            } else {
                JOptionPane.showMessageDialog(null, "No Employee found with the provided ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    private void removetabcustomer() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,CustomerView
                ,VehicleView ,Vehicleedittab ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations
        };
        Customeredittab.setDisable(false);
        tabbans.getSelectionModel().select(Customeredittab);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    private void VisableforTextadd(int count) {
        if (count == 0) {
            addingcustomer.setVisible(false);
        } else {
            addingcustomer.setVisible(true);
        }
    }

    private void VisableforTextupdate(int count) {

        if(count == 0) {
            updatingcustomer.setVisible(false);
        } else {
            updatingcustomer.setVisible(true);
        }
    }

    private void VisableforTextdelete(int count) {

        if(count == 0) {
            deleteingcustomer.setVisible(false);
        } else {
            deleteingcustomer.setVisible(true);
        }
    }
    @FXML
    private void addcc() {
        removetabcustomer();
        VisableforTextadd(1);
        VisableforTextupdate(0);
        VisableforTextdelete(0);

    }

    @FXML
    private void updatecc() {
        removetabcustomer();
        VisableforTextadd(0);
        VisableforTextupdate(1);
        VisableforTextdelete(0);
    }

    @FXML
    private void deletecc() {
        removetabcustomer();
        VisableforTextadd(0);
        VisableforTextupdate(0);
        VisableforTextdelete(1);
    }

    private boolean FieldsFilledInformationCustomeradd() {
        List<TextField> textFields = Arrays.asList(FNameadd, SNameadd, LNameadd,
                CsPhoneNumadd, Cityadd, Streetadd,
                ApartmentNumadd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private boolean FieldsFilledInformationRugadd() {
        List<TextField> textFields = Arrays.asList(Rugsizeadd, RugQuntityadd, RugStatusadd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private boolean FieldsFilledInformationBlanketadd() {
        List<TextField> textFields = Arrays.asList(BlanketQuntityadd, BlanketStatusadd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private void clearFields() {
        List<TextField> textFields = Arrays.asList(FNameadd, SNameadd, LNameadd, CsPhoneNumadd, Cityadd, Streetadd,
                ApartmentNumadd, Rugsizeadd, RugQuntityadd, RugStatusadd, RugPriceadd, BlanketQuntityadd,
                BlanketStatusadd, BlanketPriceadd
                ,CustomerIDupdate, FNameupdate, SNameupdate, LNameupdate, CsPhoneNumupdate, Cityupdate, Streetupdate,
                ApartmentNumupdate, Rugsizeupdate, RugQuntityupdate, RugStatusupdate, RugPriceupdate,
                BlanketQuntityupdate, BlanketStatusupdate, BlanketPriceupdate, TotalPriceupdate
                ,CustomerIDdelete, FNamedelete, SNamedelete, LNamedelete, CsPhoneNumdelete, Citydelete, Streetdelete,
                ApartmentNumdelete, Rugsizedelete, RugQuntitydelete, RugStatusdelete, RugPricedelete,
                BlanketQuntitydelete, BlanketStatusdelete, BlanketPricedelete, TotalPricedelete);

        textFields.forEach(field -> field.setText(""));
    }

    @FXML
    private void AddCustomerController() {
        if (FieldsFilledInformationCustomeradd() || (FieldsFilledInformationRugadd() && FieldsFilledInformationCustomeradd())) {
            addCustomer();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        }
    }

    public void addCustomer() {
        String insertCustomer = "INSERT INTO Customer (f_name, s_name, l_name, phonenumber, city, street, apartmentnumber) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement preparedStatementCustomer = connection.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
            preparedStatementCustomer.setString(1, FNameadd.getText());
            preparedStatementCustomer.setString(2, SNameadd.getText());
            preparedStatementCustomer.setString(3, LNameadd.getText());
            preparedStatementCustomer.setInt(4, Integer.parseInt(CsPhoneNumadd.getText()));
            preparedStatementCustomer.setString(5, Cityadd.getText());
            preparedStatementCustomer.setString(6, Streetadd.getText());
            preparedStatementCustomer.setInt(7, Integer.parseInt(ApartmentNumadd.getText()));

            int rowsAffected = preparedStatementCustomer.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet getcustomerid = preparedStatementCustomer.getGeneratedKeys();
                if (getcustomerid.next()) {
                    int customerId = getcustomerid.getInt(1);
                    if (FieldsFilledInformationRugadd()) {
                        addRug(customerId);
                    }
                    if (FieldsFilledInformationBlanketadd()) {
                        addBlanket(customerId);
                    }
                    JOptionPane.showMessageDialog(null, "Information added successfully!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add information.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while adding information.");
        }
    }

    public void addRug(int customerId) {
        String insertRug = "INSERT INTO Rug (rugsizze, rugquantity, rugstatus, rugprice, customerid) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = new ConnectionDB().getConnection();
            int rugSize = Integer.parseInt(Rugsizeadd.getText());
            int priceRug = 6 * rugSize;

            PreparedStatement preparedStatementRug = connection.prepareStatement(insertRug);
            preparedStatementRug.setInt(1, rugSize);
            preparedStatementRug.setInt(2, Integer.parseInt(RugQuntityadd.getText()));
            preparedStatementRug.setString(3, RugStatusadd.getText());
            preparedStatementRug.setInt(4, priceRug);
            preparedStatementRug.setInt(5, customerId);

            int rowsAffectedRug = preparedStatementRug.executeUpdate();

            if (rowsAffectedRug > 0) {
                JOptionPane.showMessageDialog(null, "Information added for Rug");
            } else {
                JOptionPane.showMessageDialog(null, "No rug information added.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addBlanket(int customerId) {
        String insertBlanket = "INSERT INTO Blanket (blanketquantity, blanketstatus, blanketprice, customerid) " +
                "VALUES (?, ?, ?, ?)";

        try {
            Connection connection = new ConnectionDB().getConnection();
            int BlanketQuntity = Integer.parseInt(BlanketQuntityadd.getText());
            int priceBlanket = 20 * BlanketQuntity;

            PreparedStatement preparedStatementBlanket = connection.prepareStatement(insertBlanket);
            preparedStatementBlanket.setInt(1, BlanketQuntity);
            preparedStatementBlanket.setString(2, BlanketStatusadd.getText());
            preparedStatementBlanket.setInt(3, priceBlanket);
            preparedStatementBlanket.setInt(4, customerId);

            int rowsAffectedBlanket = preparedStatementBlanket.executeUpdate();

            if (rowsAffectedBlanket > 0) {
                JOptionPane.showMessageDialog(null, "Information added for Blanket");
            } else {
                JOptionPane.showMessageDialog(null, "No Blanket information added.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void searchCustomerUpdate() {
        String customerIdStr = CustomerIDupdate.getText();
        if (customerIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
            return;
        }

        try {
            int customerId = Integer.parseInt(customerIdStr);
            String customerQuery = "SELECT * FROM Customer WHERE customerid = ?";
            String rugQuery = "SELECT * FROM Rug WHERE customerid = ?";
            String blanketQuery = "SELECT * FROM Blanket WHERE customerid = ?";

            try (Connection connection = new ConnectionDB().getConnection();
                 PreparedStatement customerStatement = connection.prepareStatement(customerQuery);
                 PreparedStatement rugStatement = connection.prepareStatement(rugQuery);
                 PreparedStatement blanketStatement = connection.prepareStatement(blanketQuery)) {

                customerStatement.setInt(1, customerId);
                try (ResultSet customerResultSet = customerStatement.executeQuery()) {
                    if (customerResultSet.next()) {
                        FNameupdate.setText(customerResultSet.getString("f_name"));
                        SNameupdate.setText(customerResultSet.getString("s_name"));
                        LNameupdate.setText(customerResultSet.getString("l_name"));
                        int phoneNumber = customerResultSet.getInt("phonenumber");
                        CsPhoneNumupdate.setText(String.valueOf(phoneNumber));
                        Cityupdate.setText(customerResultSet.getString("city"));
                        Streetupdate.setText(customerResultSet.getString("street"));
                        int apartmentNumber = customerResultSet.getInt("apartmentnumber");
                        ApartmentNumupdate.setText(String.valueOf(apartmentNumber));
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found.");
                    }
                }

                int rugPrice = 0;
                rugStatement.setInt(1, customerId);
                try (ResultSet rugResultSet = rugStatement.executeQuery()) {
                    if (rugResultSet.next()) {
                        Rugsizeupdate.setText(String.valueOf(rugResultSet.getInt("rugsizze")));
                        RugQuntityupdate.setText(String.valueOf(rugResultSet.getInt("rugquantity")));
                        RugStatusupdate.setText(rugResultSet.getString("rugstatus"));
                        rugPrice = rugResultSet.getInt("rugprice");
                        RugPriceupdate.setText(String.valueOf(rugPrice));
                    } else {
                        Rugsizeupdate.setText("");
                        RugQuntityupdate.setText("");
                        RugStatusupdate.setText("");
                        RugPriceupdate.setText("");
                    }
                }

                int blanketPrice = 0;
                blanketStatement.setInt(1, customerId);
                try (ResultSet blanketResultSet = blanketStatement.executeQuery()) {
                    if (blanketResultSet.next()) {
                        BlanketQuntityupdate.setText(String.valueOf(blanketResultSet.getInt("blanketquantity")));
                        BlanketStatusupdate.setText(blanketResultSet.getString("blanketstatus"));
                        blanketPrice = blanketResultSet.getInt("blanketprice");
                        BlanketPriceupdate.setText(String.valueOf(blanketPrice));
                    } else {
                        BlanketQuntityupdate.setText("");
                        BlanketStatusupdate.setText("");
                        BlanketPriceupdate.setText("");
                    }
                }

                int total = rugPrice + blanketPrice;
                TotalPriceupdate.setText(String.valueOf(total));

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching customer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Customer ID format.");
        }
    }

    private void updateCustomerFunction() {
        String customerIdStr = CustomerIDupdate.getText();
        if (customerIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
        }

        String phoneStr = CsPhoneNumupdate.getText();
        String apartmentNumStr = ApartmentNumupdate.getText();

        if (phoneStr.isBlank() || apartmentNumStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Phone number and apartment number are required.");
        }

        try {
            int customerId = Integer.parseInt(customerIdStr);
            int phoneNum = Integer.parseInt(phoneStr);
            int apartmentNum = Integer.parseInt(apartmentNumStr);

            String updateCustomerQuery = "UPDATE Customer SET phonenumber = ?, f_name = ?, s_name = ?, l_name = ?" +
                    ", apartmentnumber = ?, city = ?, street = ? WHERE customerid = ?";
            String updateRugQuery = "UPDATE Rug SET rugsizze = ?, rugquantity = ?, rugstatus = ?, rugprice = ?, rugdeliverydate = ? WHERE customerid = ?";
            String updateBlanketQuery = "UPDATE Blanket SET blanketquantity = ?, Blanketstatus = ?, Blanketprice = ?, blanketdeliverydate = ? WHERE customerid = ?";

            try (Connection connection = new ConnectionDB().getConnection();
                 PreparedStatement updateCustomerStatement = connection.prepareStatement(updateCustomerQuery);
                 PreparedStatement updateRugStatement = connection.prepareStatement(updateRugQuery);
                 PreparedStatement updateBlanketStatement = connection.prepareStatement(updateBlanketQuery)) {

                updateCustomerStatement.setInt(1, phoneNum);
                updateCustomerStatement.setString(2, FNameupdate.getText());
                updateCustomerStatement.setString(3, SNameupdate.getText());
                updateCustomerStatement.setString(4, LNameupdate.getText());
                updateCustomerStatement.setInt(5, apartmentNum);
                updateCustomerStatement.setString(6, Cityupdate.getText());
                updateCustomerStatement.setString(7, Streetupdate.getText());
                updateCustomerStatement.setInt(8, customerId);

                int customerRowsAffected = updateCustomerStatement.executeUpdate();
                if (customerRowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Customer information updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No customer information updated.");
                }

                if (!Rugsizeupdate.getText().isBlank() && !RugQuntityupdate.getText().isBlank() && !RugStatusupdate.getText().isBlank()) {
                    int rugSize = Integer.parseInt(Rugsizeupdate.getText());
                    int rugQuantity = Integer.parseInt(RugQuntityupdate.getText());
                    int rugPrice = rugSize * 6;
                    updateRugStatement.setInt(1, Integer.parseInt(Rugsizeupdate.getText()));
                    updateRugStatement.setInt(2, Integer.parseInt(RugQuntityupdate.getText()));
                    updateRugStatement.setString(3, RugStatusupdate.getText());
                    updateRugStatement.setInt(4, rugPrice);
                    updateRugStatement.setDate(5, java.sql.Date.valueOf(deliverydateRug.getValue()));
                    updateRugStatement.setInt(6, customerId);

                    int rugRowsAffected = updateRugStatement.executeUpdate();
                    if (rugRowsAffected > 0) {
//                    JOptionPane.showMessageDialog(null, "Rug information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No rug information updated.");
                    }
                }

                if (!BlanketQuntityupdate.getText().isBlank() && !BlanketStatusupdate.getText().isBlank()) {
                    int blanketQuantity = Integer.parseInt(BlanketQuntityupdate.getText());
                    int blanketPrice = blanketQuantity * 20;
                    updateBlanketStatement.setInt(1, Integer.parseInt(BlanketQuntityupdate.getText()));
                    updateBlanketStatement.setString(2, BlanketStatusupdate.getText());
                    updateBlanketStatement.setInt(3, blanketPrice);
                    updateBlanketStatement.setDate(4, java.sql.Date.valueOf(deliverydateBlanket.getValue()));
                    updateBlanketStatement.setInt(5, customerId);

                    int blanketRowsAffected = updateBlanketStatement.executeUpdate();
                    if (blanketRowsAffected > 0) {
//                    JOptionPane.showMessageDialog(null, "Blanket information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No blanket information updated.");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while updating customer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for Customer ID, phone number, and apartment number.");
        }
    }



    @FXML
    private void updateCustomer() {
        updateCustomerFunction();
        clearFields();
    }


    @FXML
    private void searchCustomerdelete() {
        String customerIdStr = CustomerIDdelete.getText();
        if (customerIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
        }

        try {
            int customerId = Integer.parseInt(customerIdStr);
            String customerQuery = "SELECT * FROM Customer WHERE customerid = ?";
            String rugQuery = "SELECT * FROM Rug WHERE customerid = ?";
            String blanketQuery = "SELECT * FROM Blanket WHERE customerid = ?";

            try (Connection connection = new ConnectionDB().getConnection();
                 PreparedStatement customerStatement = connection.prepareStatement(customerQuery);
                 PreparedStatement rugStatement = connection.prepareStatement(rugQuery);
                 PreparedStatement blanketStatement = connection.prepareStatement(blanketQuery)) {

                customerStatement.setInt(1, customerId);
                try (ResultSet customerResultSet = customerStatement.executeQuery()) {
                    if (customerResultSet.next()) {
                        FNamedelete.setText(customerResultSet.getString("f_name"));
                        SNamedelete.setText(customerResultSet.getString("s_name"));
                        LNamedelete.setText(customerResultSet.getString("l_name"));
                        CsPhoneNumdelete.setText(customerResultSet.getString("phonenumber"));
                        Citydelete.setText(customerResultSet.getString("city"));
                        Streetdelete.setText(customerResultSet.getString("street"));
                        ApartmentNumdelete.setText(customerResultSet.getString("apartmentnumber"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found.");
                    }
                }

                int rugPrice = 0;
                rugStatement.setInt(1, customerId);
                try (ResultSet rugResultSet = rugStatement.executeQuery()) {
                    if (rugResultSet.next()) {
                        Rugsizedelete.setText(String.valueOf(rugResultSet.getInt("rugsizze")));
                        RugQuntitydelete.setText(String.valueOf(rugResultSet.getInt("rugquantity")));
                        RugStatusdelete.setText(rugResultSet.getString("rugstatus"));
                        rugPrice = rugResultSet.getInt("rugprice");
                        RugPricedelete.setText(String.valueOf(rugPrice));
                    } else {
                        Rugsizedelete.setText("");
                        RugQuntitydelete.setText("");
                        RugStatusdelete.setText("");
                        RugPricedelete.setText("");
                    }
                }

                int blanketPrice = 0;
                blanketStatement.setInt(1, customerId);
                try (ResultSet blanketResultSet = blanketStatement.executeQuery()) {
                    if (blanketResultSet.next()) {
                        BlanketQuntitydelete.setText(String.valueOf(blanketResultSet.getInt("blanketquantity")));
                        BlanketStatusdelete.setText(blanketResultSet.getString("blanketstatus"));
                        blanketPrice = blanketResultSet.getInt("blanketprice");
                        BlanketPricedelete.setText(String.valueOf(blanketPrice));
                    } else {
                        BlanketQuntitydelete.setText("");
                        BlanketStatusdelete.setText("");
                        BlanketPricedelete.setText("");
                    }
                }

                int total = rugPrice + blanketPrice;
                TotalPricedelete.setText(String.valueOf(total));

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while searching customer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Customer ID format.");
        }
    }

    @FXML
    private void DeleteCustomer() {
        String customerIdStr = CustomerIDdelete.getText();
        if (customerIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
        }

        try {
            int customerId = Integer.parseInt(customerIdStr);
            String deleteCustomerQuery = "DELETE FROM Customer WHERE customerid = ?";
            String deleteRugQuery = "DELETE FROM Rug WHERE customerid = ?";
            String deleteBlanketQuery = "DELETE FROM Blanket WHERE customerid = ?";

            try (Connection connection = new ConnectionDB().getConnection();
                 PreparedStatement deleteCustomerStatement = connection.prepareStatement(deleteCustomerQuery);
                 PreparedStatement deleteRugStatement = connection.prepareStatement(deleteRugQuery);
                 PreparedStatement deleteBlanketStatement = connection.prepareStatement(deleteBlanketQuery)) {

                deleteRugStatement.setInt(1, customerId);
                deleteRugStatement.executeUpdate();

                deleteBlanketStatement.setInt(1, customerId);
                deleteBlanketStatement.executeUpdate();

                deleteCustomerStatement.setInt(1, customerId);
                int rowsAffected = deleteCustomerStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Customer deleted successfully.");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "No customer found with the provided ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred while deleting customer.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Customer ID format.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Customer ID format.");
        }
    }





    private void removetabexpense() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,CustomerView ,Customeredittab
                ,VehicleView ,Vehicleedittab ,ExpenseView ,AccountView ,Carresrvations
        };
        Expenseedittab.setDisable(false);
        tabbans.getSelectionModel().select(Expenseedittab);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    private void VisableTextaddexpense(int count) {
        if(count == 0) {
            addingexpense.setVisible(false);
        } else {
            addingexpense.setVisible(true);
        }
    }

    private void VisableTextupdateexpense(int count) {
        if(count == 0) {
            updatingexpense.setVisible(false);
        } else {
            updatingexpense.setVisible(true);
        }
    }

    @FXML
    private void addinformationexpense() {
        removetabexpense();
        VisableTextaddexpense(1);
        VisableTextupdateexpense(0);
    }

    @FXML
    private void updateinformationexpense() {
        removetabexpense();
        VisableTextaddexpense(0);
        VisableTextupdateexpense(1);
    }

    private boolean FieldsFilledInformationExpenseadd() {
        List<TextField> textFields = Arrays.asList(ExpenseTypeadd ,AmountOfExpenseadd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private void cleanafteraddexpense() {
        List<TextField> textFields = Arrays.asList(ExpenseTypeadd ,AmountOfExpenseadd);

        dateexpenseadd.setAccessibleText("");
        textFields.forEach(field -> field.setText(""));

    }

    private void cleanafterupdateexpense() {
        List<TextField> textFields = Arrays.asList(ExpenseIDupdate,ExpenseTypeupdate ,AmountOfExpenseupdate);
        dateexpenseupdate.setAccessibleText("");
        textFields.forEach(field -> field.setText(""));
    }

    @FXML
    private void AddExpenseButton() {
        if(FieldsFilledInformationExpenseadd()) {
            addExpensefunction();
            cleanafteraddexpense();
        } else
            JOptionPane.showMessageDialog(null,"Error");

    }

    private void addExpensefunction() {
        String insertexpense = "INSERT INTO expense(expensetype, amount, datee) VALUES (?, ?, ?)";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertexpense);
            preparedStatement.setString(1,ExpenseTypeadd.getText());
            preparedStatement.setDouble(2,Double.parseDouble(AmountOfExpenseadd.getText()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(dateexpenseadd.getValue()));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Done");

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void searchupdateexpense() {
        String ExpenseidStr = ExpenseIDupdate.getText();
        if (ExpenseidStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Expense ID.");
        }
        int ExpenseID = Integer.parseInt(ExpenseidStr);
        String ExpenseQuery = "SELECT * FROM Expense WHERE expenseid = ?";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement Statement = connection.prepareStatement(ExpenseQuery);
            Statement.setInt(1, ExpenseID);

            ResultSet EmployeeResultSet = Statement.executeQuery();
            if (EmployeeResultSet.next()) {
                ExpenseTypeupdate.setText(EmployeeResultSet.getString("expensetype"));
                AmountOfExpenseupdate.setText(EmployeeResultSet.getString("amount"));
                Date sqlDate = EmployeeResultSet.getDate("datee");
                LocalDate localDate = sqlDate.toLocalDate();
                dateexpenseupdate.setValue(localDate);
            } else {
                JOptionPane.showMessageDialog(null, "Expense not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateexpensecontroller() {
        String updateExpense = "UPDATE expense SET expensetype=?, amount=?, datee=? WHERE expenseid = ?";

        try (Connection connection = new ConnectionDB().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateExpense)) {
            preparedStatement.setString(1, ExpenseTypeupdate.getText());
            preparedStatement.setInt(2, Integer.parseInt(AmountOfExpenseupdate.getText()));
            if (dateexpenseupdate.getValue() != null) {
                preparedStatement.setDate(3, java.sql.Date.valueOf(dateexpenseupdate.getValue()));
            } else {
                preparedStatement.setNull(3, java.sql.Types.DATE);
            }
            preparedStatement.setInt(4, Integer.parseInt(ExpenseIDupdate.getText()));
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Expense information updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No Expense information updated.");
            }

            try {
                Thread.sleep(3000);
                cleanafterupdateexpense();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating Expense information.");
        }
    }
/*
    @FXML
    private void viewreportexpense() {
        InputStream input;
        JasperDesign jd;
        JasperReport jr;
        JasperPrint jp = null;
        OutputStream output;

        try
        {
            java.sql.Connection connection = new ConnectionDB().getConnection();
            input=new FileInputStream(new File("expenseReport.jrxml"));
            jd= JRXmlLoader.load(input);
            jr= JasperCompileManager.compileReport(jd);
            jp= JasperFillManager.fillReport(jr,null,connection);
            JFrame frame=new JFrame("Report for project");
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
            input.close();
            connection.close();
        }

        catch(Exception ex){ JOptionPane.showMessageDialog(null, ex.toString());}
    }

    @FXML
    private void viewreportaccount() {
        InputStream input;
        JasperDesign jd;
        JasperReport jr;
        JasperPrint jp = null;
        OutputStream output;

        try {
            java.sql.Connection connection = new ConnectionDB().getConnection();
            input = getClass().getResourceAsStream("/com/example/project_db/accountReport.jrxml");
            if (input == null) {
                throw new FileNotFoundException("File not found: accountReport.jrxml");
            }
            jd = JRXmlLoader.load(input);
            jr = JasperCompileManager.compileReport(jd);
            jp = JasperFillManager.fillReport(jr, null, connection);
            JFrame frame = new JFrame("Report for project");
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);
            input.close();
            connection.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

*/


    private void removetabvehicle() {
        Tab[] tab = {Hometab,employeeViewTab ,Employeeeditingtab ,CustomerView ,Customeredittab
                ,VehicleView ,ExpenseView ,Expenseedittab ,AccountView ,Carresrvations
        };
        Vehicleedittab.setDisable(false);
        tabbans.getSelectionModel().select(Vehicleedittab);
        for(Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    private void VisableTextaddvehicle(int count) {
        if(count == 0) {
            addingvehicle.setVisible(false);
        } else {
            addingvehicle.setVisible(true);
        }
    }

    private void VisableTextupdatevehicle(int count) {
        if(count == 0) {
            updatingvehicle.setVisible(false);
        } else {
            updatingvehicle.setVisible(true);
        }
    }

    @FXML
    private void addinformationvehicle() {
        removetabvehicle();
        VisableTextaddvehicle(1);
        VisableTextupdatevehicle(0);
    }

    @FXML
    private void updateinformationvehicle() {
        removetabvehicle();
        VisableTextaddvehicle(0);
        VisableTextupdatevehicle(1);
    }

    private boolean FieldsFilledInformationVehicleBuy() {
        List<TextField> textFields = Arrays.asList(registraionnumberadd ,modeladd);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private void buycar() {
        String insertvehicle = "INSERT INTO vehicle(registraionnumber, model, purchasedate) VALUES ( ?, ?, ?);";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertvehicle);
            connection.setAutoCommit(false);
            preparedStatement.setString(1,registraionnumberadd.getText());
            preparedStatement.setString(2,modeladd.getText());
            preparedStatement.setDate(3, java.sql.Date.valueOf(purchasedateadd.getValue()));

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Done");

            connection.commit();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cleancar() {
        List<TextField> textFields = Arrays.asList(registraionnumberadd ,modeladd,
                vehicleid, registraionnumberupdate ,modelupdate);

        purchasedateadd.setAccessibleText("");
        purchasedateupdate.setAccessibleHelp("");
        textFields.forEach(field -> field.setText(""));
    }

    @FXML
    private void buyvehiclecontroller() {
        if(FieldsFilledInformationVehicleBuy()){
            buycar();
            cleancar();
        }else {
            JOptionPane.showMessageDialog(null,"Error");

        }
    }

    @FXML
    private void searchcar() {
        String VehicleidStr = vehicleid.getText();
        if (VehicleidStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter Vehicle ID.");
        }
        int VehicleID = Integer.parseInt(VehicleidStr);
        String ExpenseQuery = "SELECT * FROM Vehicle WHERE vehicleid = ?";

        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement Statement = connection.prepareStatement(ExpenseQuery);
            Statement.setInt(1, VehicleID);

            ResultSet EmployeeResultSet = Statement.executeQuery();
            if (EmployeeResultSet.next()) {
                vehicleid.setText(EmployeeResultSet.getString("vehicleid"));
                registraionnumberupdate.setText(EmployeeResultSet.getString("registraionnumber"));
                modelupdate.setText(EmployeeResultSet.getString("model"));
                Date sqlDate = EmployeeResultSet.getDate("purchasedate");
                LocalDate localDate = sqlDate.toLocalDate();
                purchasedateupdate.setValue(localDate);
            } else {
                JOptionPane.showMessageDialog(null, "Vehicle not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sellcar() {
        String vehicleIdStr = vehicleid.getText();
        if (vehicleIdStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter vehicle ID.");
        }

        Connection connection = null;
        PreparedStatement deleteVehicleStatement = null;
        PreparedStatement deleteEmployeeVehicleStatement = null;
        ResultSet resultSet = null;

        try {
            int vehicleId = Integer.parseInt(vehicleIdStr);

            connection = new ConnectionDB().getConnection();
            connection.setAutoCommit(false);

            String checkVehicleQuery = "SELECT COUNT(*) FROM employeevehicle WHERE vehicleid = ?";
            PreparedStatement checkVehicleStatement = connection.prepareStatement(checkVehicleQuery);
            checkVehicleStatement.setInt(1, vehicleId);
            resultSet = checkVehicleStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                String deleteEmployeeVehicleQuery = "DELETE FROM employeevehicle WHERE vehicleid = ?";
                deleteEmployeeVehicleStatement = connection.prepareStatement(deleteEmployeeVehicleQuery);
                deleteEmployeeVehicleStatement.setInt(1, vehicleId);
                deleteEmployeeVehicleStatement.executeUpdate();
            }

            String deleteVehicleQuery = "DELETE FROM vehicle WHERE vehicleid = ?";
            deleteVehicleStatement = connection.prepareStatement(deleteVehicleQuery);
            deleteVehicleStatement.setInt(1, vehicleId);
            int rowsAffected = deleteVehicleStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Vehicle deleted successfully.");
                cleancar();
                connection.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No vehicle found with the provided ID.");
                connection.rollback();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid vehicle ID format.");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error occurred.");
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (deleteVehicleStatement != null) deleteVehicleStatement.close();
                if (deleteEmployeeVehicleStatement != null) deleteEmployeeVehicleStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void getallinformationempvehcontroller() {
        TableColumnEmployeeVehicle();
        LocalDate selectedDate = assignmentdate.getValue();

        if (selectedDate != null) {
            loadInformationEmployeeVehicle(selectedDate);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a date.");
        }
    }

    @FXML
    private void getallinformationaccountcontroller() {
        TableColumnAccount();
        LocalDate startdate = startdateaccount.getValue();
        LocalDate enddate = enddateaccount.getValue();



        if (startdate != null && enddate != null) {
            loadAccountInformation(startdate ,enddate);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a date.");
        }
    }




}