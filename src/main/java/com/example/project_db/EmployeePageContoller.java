package com.example.project_db;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeePageContoller {

    @FXML
    private TableView customerTable ,VehicleTable;

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
    private TabPane tabbans;

    @FXML
    private Tab Hometab, CustomerView, Customeredittab, VehicleView, Vehicleedittab;
    @FXML
    private Button HomeButton, CustomerButton, VehicleButton, EmpVehButton, LogoutButton;

    @FXML
    private Pane addingcustomer ,updatingcustomer ,deleteingcustomer;

    @FXML
    private Button addc, updatec, deletec;

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
            ,assignmentdate ,datereservationcar;

    @FXML
    private Button DeleteCustomerButton ,SearchCustomerButton;
    @FXML
    private TextField CustomerIDdelete, FNamedelete, SNamedelete, LNamedelete, CsPhoneNumdelete, Citydelete, Streetdelete,
            ApartmentNumdelete, Rugsizedelete, RugQuntitydelete, RugStatusdelete, RugPricedelete,
            BlanketQuntitydelete, BlanketStatusdelete, BlanketPricedelete, TotalPricedelete;

    @FXML
    private TableColumn<Map<String, Object>, Integer> Vehicleidcolumn;
    @FXML
    private TableColumn<Map<String, Object>, String> registraionnumbercolumn, Modelcolumn ,purchasedatecolumn;

    @FXML
    private Button reservecarButton, reservationButton;

    @FXML
    private TextField vehicleid ,employeeid;

    @FXML
    private Label numofcustomer, numofvehicle;

    @FXML
    private BarChart<?, ?> charemployee;




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


    @FXML
    private void HomeButtonDash() {
        Tab[] tab = {CustomerView, Customeredittab
                , VehicleView, Vehicleedittab
        };
        Hometab.setDisable(false);
        tabbans.getSelectionModel().select(Hometab);
        for (Tab tabs : tab) {
            tabs.setDisable(true);
        }

        String getnumcustomer = "select count(customerid) from customer;";
        String getnumveh = "select count(vehicleid) from vehicle;";
        int cust = 0, veh = 0;
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


        charemployee.getData().addAll(customer ,vehicle);

    }

    @FXML
    private void customerButtonDash() {
        Tab[] tab = {Hometab, Customeredittab, VehicleView, Vehicleedittab
        };
        CustomerView.setDisable(false);
        tabbans.getSelectionModel().select(CustomerView);
        for (Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnscustomer();
        loadInformationcustomer();
    }

    @FXML
    private void VehicleButtonDash() {
        Tab[] tab = {Hometab, Customeredittab, CustomerView
                , Vehicleedittab
        };
        VehicleView.setDisable(false);
        tabbans.getSelectionModel().select(VehicleView);
        for (Tab tabs : tab) {
            tabs.setDisable(true);
        }
        TableColumnVehicle();
        loadInformationVehicle();
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


    private void removetabcustomer() {
        Tab[] tab = {Hometab,CustomerView
                ,VehicleView ,Vehicleedittab
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
    private void AddCustomerController() {
        if (FieldsFilledInformationCustomeradd() || (FieldsFilledInformationRugadd() && FieldsFilledInformationCustomeradd())) {
            addCustomer();

            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
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

    @FXML
    private void reservecar() {
        Tab[] tab = {Hometab ,CustomerView, Customeredittab
                , VehicleView
        };
        Vehicleedittab.setDisable(false);
        tabbans.getSelectionModel().select(Vehicleedittab);
        for (Tab tabs : tab) {
            tabs.setDisable(true);
        }
    }

    private boolean FieldsFilledInformationreservation() {
        List<TextField> textFields = Arrays.asList(vehicleid ,employeeid);

        return textFields.stream()
                .allMatch(field -> !field.getText().isBlank());
    }

    private void cleanstextreservation() {
        vehicleid.setText("");
        employeeid.setText("");
        datereservationcar.setAccessibleText("");
    }

    @FXML
    private void reservation() {
        if(FieldsFilledInformationreservation()) {
            reservationfunction();
            cleanstextreservation();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");

        }

    }

    private void reservationfunction() {
        String insertreservation = "INSERT INTO employeevehicle(vehicleid ,employeeid, assignmentdate)" +
                " VALUES (?, ?, ?)";
        try {
            Connection connection = new ConnectionDB().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertreservation);
            preparedStatement.setInt(1,Integer.parseInt(vehicleid.getText()));
            preparedStatement.setInt(2,Integer.parseInt(employeeid.getText()));
            preparedStatement.setDate(3,java.sql.Date.valueOf(datereservationcar.getValue()));

            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
            JOptionPane.showMessageDialog(null, "Information added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}