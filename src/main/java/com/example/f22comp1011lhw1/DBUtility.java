package com.example.f22comp1011lhw1;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    //to access a MySQL server, we need the user name, password,
    //ip address and port #
    private static String user = "student";
    private static String pw = "student";

    //jdbc:mysql = Java DataBase Connector to MySQL Server
    //127.0.0.1 = IP address of the server (127.0.0.1 is the local host)
    //3306 = port # that MySQL server is accessible on
    //F22 = database name
    private static String connURL = "jdbc:mysql://127.0.0.1:3306/F22";

    //We also updated the pom.xml with the maven information and added requires java.sql
    //to the module-info file

    /**
     * This method will return an ArrayList<CountryCode> with all countries represented
     */
    public static ArrayList<CountryCode> getCountryCodesFromDB()
    {
        ArrayList<CountryCode> countries = new ArrayList<>();

        //create a SQL statement
        String sql = "SELECT * FROM countryCodes";

        //connecting to a DB can trigger a SQL exception, so we do the coding
        //inside of a try...catch block
        try(
                //anything inside these () are "auto-closed", the system will
                //automatically call the .close() method
                //1. Connect to the DB
                Connection conn = DriverManager.getConnection(connURL, user, pw);

                //2.  Create a statement object
                Statement statement = conn.createStatement();

                //3.  use the statement object to run the sql
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            //loop over the resultSet and create CountryCode objects
            while (resultSet.next())
            {
                countries.add(new CountryCode(resultSet.getString("country"),
                                             resultSet.getString("countryCode")));
            }
            } catch (Exception e)
        {
            e.printStackTrace();
        }

        return countries;
    }

    public static ArrayList<Manufacturer> getManufacturersFromDB() {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        String sql = "SELECT * from manufacturers ORDER BY name";
        try (
                Connection conn = DriverManager.getConnection(connURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
                //loop over the resultSet and create CountryCode objects
                while (resultSet.next()) {
                    int id = resultSet.getInt("manufacturerID");
                    String name = resultSet.getString("name");
                    String countryCode = resultSet.getString("countryCode");
                    Manufacturer manufacturer = new Manufacturer(id, name, countryCode);
                    manufacturers.add(manufacturer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return manufacturers;
    }

    public static ArrayList<BeerType> getBeerTypes() {
        ArrayList<BeerType> beerTypes = new ArrayList<>();
        String sql = "SELECT * from beerTypes ORDER BY name";
        try (
                Connection conn = DriverManager.getConnection(connURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //loop over the resultSet and create CountryCode objects
            while (resultSet.next()) {
                int id = resultSet.getInt("beerTypeID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                beerTypes.add(new BeerType(id,name,description));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beerTypes;
    }

    /**
     * Returns a list of Beer objects
     * @return
     */
    public static ArrayList<Beer> getBeerFromDB() {
        ArrayList<Beer> beer = new ArrayList<>();
        String sql = "SELECT beerID, beer.productID,rating,products.name AS beerName,products.manufacturerID,price,sku, " +
                "products.description, alcohol, " +
                "beer.bottletypeID,bottletypes.name AS bottleName,volume,manufacturers.name,countryCode, " +
                "beer.beerTypeID, beerTypes.name AS beerTypeName, beerTypes.description AS beerTypesDescription " +
                "FROM beer INNER JOIN products ON beer.productID = products.productID " +
                "INNER JOIN bottletypes ON bottletypes.bottletypeID = beer.bottletypeID " +
                "INNER JOIN manufacturers ON manufacturers.manufacturerID = products.manufacturerID " +
                "INNER JOIN beerTypes ON beerTypes.beerTypeID = beer.beerTypeID " +
                "ORDER BY beerID;";
        try (
                Connection conn = DriverManager.getConnection(connURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //loop over the resultSet and create CountryCode objects
            while (resultSet.next()) {
                //Create a Manufacturer Object
                Manufacturer manufacturer = new Manufacturer(
                            resultSet.getInt("manufacturerID"),
                            resultSet.getString("name"),
                            resultSet.getString("countryCode"));

                //Create a BeerType Object
                BeerType beerType = new BeerType(resultSet.getInt("beerTypeID"),
                        resultSet.getString("beerTypeName"),
                        resultSet.getString("beerTypesDescription"));

                //Create a bottleType Object
                BottleType bottleType = new BottleType(
                        resultSet.getInt("bottleTypeID"),
                        resultSet.getInt("volume"),
                        resultSet.getString("bottleName"));

                String beerName = resultSet.getString("beerName");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Beer newBeer = new Beer(beerName,manufacturer,description,price,
                                    beerType,bottleType,)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beerTypes;
    }
}
