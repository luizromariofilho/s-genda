package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class PhoneBookClient {

    private PhoneBookClient() {
    }

    public static void main(String[] args) {
        
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            PhoneBookServerInterface stub = (PhoneBookServerInterface) registry.lookup("ServerInterface");
            PhoneBookEntry entry1 = new PhoneBookEntry("Danilo", "Lopes", "88091386");
            PhoneBookEntry entry2 = new PhoneBookEntry("Danilo2", "Lopes", "88091381");
            PhoneBookEntry entry3 = new PhoneBookEntry("Danilo3", "Lopes", "88091382");
            System.out.println("Inserindo registro. \n");
            stub.addEntry(entry1);
            stub.addEntry(entry2);
            stub.addEntry(entry3);
            
            ArrayList<PhoneBookEntry> entries = stub.getPhoneBook();
            for (PhoneBookEntry entrie : entries) {
                System.out.print(entrie + "\n");
            }
            
            System.out.println("Deletando registro id: 2. \n");
            entry2 = new PhoneBookEntry(2, "Danilo2", "Lopes", "88091381");
            stub.deleteEntry(entry2);
            entries = stub.getPhoneBook();
            for (PhoneBookEntry entrie : entries) {
                System.out.print(entrie + "\n");
            }
            
            System.out.println("Editando registro id: 1. \n");
            PhoneBookEntry entry4 = new PhoneBookEntry(1, "Luiz Romario", "Sant'Ana", "12344433");
            stub.modifyEntry(entry4);
            entries = stub.getPhoneBook();
            for (PhoneBookEntry entrie : entries) {
                System.out.print(entrie + "\n");
            }
            
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

//        try {
//            Registry registry = LocateRegistry.getRegistry(host);
//            PhoneBookServerInterface stub = (PhoneBookServerInterface) registry.lookup("PhoneBookServer");
//            PhoneBookEntry entry1 = new PhoneBookEntry("Danilo", "Lopes", "88091386");
//            stub.addEntry(entry1);
//            ArrayList<PhoneBookEntry> entries = stub.getPhoneBook();
//            for (int i = 0; i < entries.size(); i++) {
//                System.out.print(entries);
//            }
////            String response = stub.sayHello();
////            System.out.println("response: " + response);
//        } catch (Exception e) {
//            System.err.println("Client exception: " + e.toString());
//            e.printStackTrace();
//        }
    }
}
