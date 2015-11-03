package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public interface PhoneBookServerInterface extends java.rmi.Remote {

    public ArrayList<PhoneBookEntry> getPhoneBook() throws RemoteException;

    public boolean addEntry(PhoneBookEntry entry) throws RemoteException;

    public boolean modifyEntry(PhoneBookEntry entry) throws RemoteException;

    public boolean deleteEntry(PhoneBookEntry entry) throws RemoteException;
}
