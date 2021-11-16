package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2Test {

    public static void main(String[] args) {
        List<Customer> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("customer.csv"));
            OutputStream ops = new FileOutputStream("outputCustomer.csv")) {

            String data;
            while ((data = reader.readLine()) != null){
                String[] split = data.split(",");
                Customer customer = new Customer(split[0].trim(),split[1].trim(),Integer.parseInt(split[2].trim()));
                list.add(customer);
            }

            list.sort((o1, o2) -> Integer.compare(o1.getScore(),o2.getScore()));

            for (Customer customer : list) {
                String name = customer.getName();
                String phone = customer.getPhone();
                int score = customer.getScore();
                String result = name + ", " + phone + ", " + score + "\n";
                ops.write(result.getBytes());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
