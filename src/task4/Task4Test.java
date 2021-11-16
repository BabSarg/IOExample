package task4;

import task2.Customer;

import java.io.*;

public class Task4Test {

    public static void main(String[] args) {

        try(ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("customerSeralizable.txt"));
        ObjectInputStream ips = new ObjectInputStream(new FileInputStream("customerSeralizable.txt"))){
            Customer customer = new Customer("Tom","+374 77 777777", 33);

            ops.writeObject(customer);
            Customer o = (Customer)ips.readObject();
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
