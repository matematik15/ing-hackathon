package com.ing.hackathon.transactions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class generateTransactions {

        public static void main(String[] args) throws IOException {
            String output = "";
            for (int i = 0; i < 33334; i++) {
                int j = i%10;
                output += String.format("  {\n" +
                        "    \"debitAccount\": \"3230911192266193785268486%2$d\",\n" +
                        "    \"creditAccount\": \"0610502338984283474854730%2$d\",\n" +
                        "    \"amount\": 1%1$d.90\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"debitAccount\": \"3107431869813706223584581%2$d\",\n" +
                        "    \"creditAccount\": \"6610503654374940334652454%2$d\",\n" +
                        "    \"amount\": 20%1$d.90\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"debitAccount\": \"6610503654374940334652454%2$d\",\n" +
                        "    \"creditAccount\": \"3230911192266193785268486%2$d\",\n" +
                        "    \"amount\": 5%1$d.10\n" +
                        "  },", i, j);
            }

            output = output.substring(0, output.length() - 1);
            output = "[" + output + "]";

            FileWriter fileWriter = new FileWriter("src/test/resources/transactions.json");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(output);
            printWriter.close();
        }

}
