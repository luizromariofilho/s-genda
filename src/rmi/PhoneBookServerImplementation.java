package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class PhoneBookServerImplementation implements PhoneBookServerInterface {

    private final ArrayList<PhoneBookEntry> entries;
    private int proxId = 0;

    public PhoneBookServerImplementation() throws RemoteException {
        super();
        entries = new ArrayList<>();
    }

    @Override
    public ArrayList<PhoneBookEntry> getPhoneBook() throws RemoteException {
        return this.entries;
    }

    @Override
    public boolean addEntry(PhoneBookEntry entry) throws RemoteException {
        for (int i = 0; i < entries.size(); i++) {
            if (entry.getTelefone().equals(entries.get(i).getTelefone())) {
                return false;
            }
        }
        entry.setId(++proxId);
        entries.add(entry);
        return true;
    }

    @Override
    public boolean modifyEntry(PhoneBookEntry entry) throws RemoteException {
        for (PhoneBookEntry e : entries) {
            if (e.getId() == entry.getId()) {
                e.setNome(entry.getNome());
                e.setSobrenome(entry.getSobrenome());
                e.setTelefone(entry.getTelefone());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEntry(PhoneBookEntry entry) throws RemoteException {
        for (int i = 0; i < entries.size(); i++) {
            PhoneBookEntry e = entries.get(i);
            if (e.getId() == entry.getId()) {
                entries.remove(i);
                return true;
            }
        }
        return false;
    }

}
