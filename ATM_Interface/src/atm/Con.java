/*
 * Copyright (c) 2024 Poovarasan H. All rights reserved.
 * This project is developed and maintained by Poovarasan H.
 */
package atm;

import java.sql.*;

public class Con{
    Connection connection;
    Statement statement;
    public Con(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSystem","root","admin");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
