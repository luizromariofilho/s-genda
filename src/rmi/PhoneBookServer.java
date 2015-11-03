package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Danilo
 */
public class PhoneBookServer {

    public static void main(String[] args) throws Exception {
        try {
            PhoneBookServerImplementation server = new PhoneBookServerImplementation();
            PhoneBookServerInterface stub = (PhoneBookServerInterface) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("ServerInterface", stub);

            System.err.println("Server ready");
        } catch (RemoteException | AlreadyBoundException e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
