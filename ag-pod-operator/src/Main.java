import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.Account;
import pod.AccountManager;

public class Main {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		//
		Registry amRegistry = LocateRegistry.getRegistry("127.0.0.1", 10004);
		AccountManager manager = (AccountManager) amRegistry.lookup("AccountManager");
		//
		Registry acRegistry = LocateRegistry.getRegistry("127.0.0.1", 10001);
		Account accountA = (Account) acRegistry.lookup("AccountA");
		Account accountB = (Account) acRegistry.lookup("AccountB");
		//iniciar transações
		
		manager.transfer("B", 500);
		System.out.println(accountA.print());//9800 + 500 = 10300
		System.out.println(accountB.print());//10100 - 500 = 9600
	}
}
