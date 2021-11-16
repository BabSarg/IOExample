package task5;

import task2.Customer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Task5Test {

    public static void main(String[] args) {
        Customer customer = new Customer("Tom","+347 77 77 77 77", 77);
        customer.setCardNumber("123456789");
        byte[] encode = Base64.getEncoder().encode(customer.getCardNumber().getBytes(StandardCharsets.UTF_8));
        String encodeString = new String(encode);
        customer.setCardNumber(encodeString);
        System.out.println(customer);

        try (ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("customerCardNumber.txt"));
             ObjectInputStream ips = new ObjectInputStream(new FileInputStream("customerCardNumber.txt"))){

            ops.writeObject(customer);
            Customer o = (Customer) ips.readObject();

            byte[] decode = Base64.getDecoder().decode(o.getCardNumber().getBytes(StandardCharsets.UTF_8));
            String dencodeString = new String(decode);
            o.setCardNumber(dencodeString);
            System.out.println(o);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
