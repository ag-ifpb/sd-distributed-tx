package br.edu.ifpb.pod.accountmanager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifpb.pod.Account;
import br.edu.ifpb.pod.AccountManager;

@SuppressWarnings("serial")
public class AccountManagerImpl extends UnicastRemoteObject implements AccountManager {
	private Account accountSource;
	private Account accountDest;
	private String source;
	private String dest;
	
	private Account getAccountA() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10990);
		Account account = (Account) registry.lookup("AccountA");
		return account;
	}
	
	private Account getAccountB() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10990);
		Account account = (Account) registry.lookup("AccountB");
		return account;
	}
	
	private Account getAccountC() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10990);
		Account account = (Account) registry.lookup("AccountC");
		return account;
	}
	
	public AccountManagerImpl() throws RemoteException{
		super();
	}

	@Override
	public void transfer(String source, String dest, double value) throws RemoteException {
		//
		try {
			//
			accountSource = null;
			accountDest = null;
			//source
			if ("A".equals(source)){
				accountSource = getAccountA();
			} else if ("B".equals(source)){
				accountSource = getAccountB();
			} else if ("C".equals(source)){
				accountSource = getAccountC();
			}
			//dest
			if ("A".equals(dest)){
				accountDest = getAccountA();
			} else if ("B".equals(dest)){
				accountDest = getAccountB();
			} else if ("C".equals(dest)){
				accountDest = getAccountC();
			}
			//operações de crédito/débito
			accountSource.debit(value);
			accountDest.credit(value);
			//
			printBalance();
			//POG
			this.dest = dest;
			this.source = source;
		}
		catch(NotBoundException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void printBalance() throws RemoteException {
		System.out.println("Saldo da conta " + source + ": " + accountSource.balance());
		System.out.println("Saldo da conta " + dest + ": " + accountDest.balance());
	}

}
