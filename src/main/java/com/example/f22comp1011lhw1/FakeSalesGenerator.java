package com.example.f22comp1011lhw1;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;

public class FakeSalesGenerator {
    public static void main(String[] args) {
        SecureRandom rng = new SecureRandom();

        try(
                Formatter formatter = new Formatter("salesData.txt");
                ) {
            for (int i = 1; i <= 2000; i++) {
                //INSERT INTO sales (productID, quantity, dateSold) VALUES (1,12,'2022-09-12');
                int productID = rng.nextInt(1,5);
                int unitsSold = rng.nextInt(1,25);
                LocalDate salesDate = LocalDate.now().minusDays(rng.nextInt(720));
                formatter.format("INSERT INTO sales (productID, quantity, dateSold) VALUES " +
                        "(%d,%d,'%s');\n",productID,unitsSold,salesDate);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
