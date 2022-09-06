package ua.issoft.store.dataBase;

import lombok.SneakyThrows;
import ua.issoft.domain.*;
import ua.issoft.store.RandomStorePopulator;
import ua.issoft.store.Store;
import ua.issoft.store.StoreHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DataBase {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASS = "";

    Connection connection = null;
    Statement statement = null;

    @SneakyThrows
    public Store getStoreFromDB(Store store) {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
        String sql = "SELECT CATEGORY, NAME , RATE , PRICE FROM STOREDB";
        ResultSet resultSet = statement.executeQuery(sql);
        MilkCategory milkCategory = new MilkCategory();
        BikeCategory bikeCategory = new BikeCategory();
        PhoneCategory phoneCategory = new PhoneCategory();

        while(resultSet.next()) {
            String sCategory = resultSet.getString("CATEGORY");
            String sName = resultSet.getString("NAME");
            int iRate = resultSet.getInt("RATE");
            int iPrice = resultSet.getInt("PRICE");
            if (sCategory.equals("Milk")) {
                milkCategory.addToList(new Product(sName, iRate, iPrice));
            }
            if (sCategory.equals("Bike")) {
                bikeCategory.addToList(new Product(sName, iRate, iPrice));
            }
            if (sCategory.equals("Phone")) {
                phoneCategory.addToList(new Product(sName, iRate, iPrice));
            }
        }
        store.addToSet(milkCategory);
        store.addToSet(bikeCategory);
        store.addToSet(phoneCategory);

        resultSet.close();
        statement.close();
        connection.close();
        return store;
    }

    @SneakyThrows
    public void fillStoreDB(){
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        statement = connection.createStatement();
        StoreHelper storeHelper = new StoreHelper();
        Set<Category> categorySet = storeHelper.getCategorySet();
        RandomStorePopulator rsp = new RandomStorePopulator();
        for (Category category : categorySet) {
            for (int a = rsp.generateMaxProductAmount(); a > 0; a--) {
                Product product = rsp.generateRandomProduct(category.getName());
                String sCategory = category.getName();
                String sName = product.getName();
                String sRate = String.valueOf(product.getRate());
                String sPrice = String.valueOf(product.getPrice());
                String sql = "INSERT into STOREDB VALUES ('" +sCategory+"', '" + sName + "', " + sRate + ", " + sPrice + ");";
                statement.executeUpdate(sql);
            }
        }
        statement.close();
        connection.close();
    }
}
