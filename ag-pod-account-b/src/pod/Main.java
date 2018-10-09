package pod;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {
		//propriedade para acesso externo ao servidor RMI
		System.setProperty("java.rmi.server.hostname", "127.0.0.1");
	    //disponibilizar conta
	    Account account = new AccountImpl();
	    //Registry registry = LocateRegistry.createRegistry(10001);
	    Registry registry = LocateRegistry.getRegistry("127.0.0.1", 10001);
	    registry.bind("AccountB", account);
	    //log
	    System.out.println("Transação Liberada.");
	}
}
