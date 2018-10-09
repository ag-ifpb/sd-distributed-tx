package pod;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
  private static final int PORT = 10001;
  private static final String HOST_A = "127.0.0.1";//wenstay
  private static final String HOST_B = "127.0.0.1";//dijalma
  //private static final String HOST_C = "192.168.1.102";//laerton
  //private static final String HOST_D = "192.168.1.104";//pedro
  //private static final String HOST_E = "192.168.1.103";//michele
  //private static final String HOST_F = "192.168.1.106";//aluisio

  private static Account getAccountA() throws AccessException,
      RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry(HOST_A, PORT);
    return (Account) registry.lookup("AccountA");
  }

  private static Account getAccountB() throws AccessException,
      RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry(HOST_B, PORT);
    return (Account) registry.lookup("AccountB");
  }

  private static TxCoord getTxCoord() throws AccessException, RemoteException,
      NotBoundException {
    Registry registry = LocateRegistry.getRegistry("localhost", 10003);
    return (TxCoord) registry.lookup("TxCoord");
  }

  public static void startAccountManagerService(AccountManager am) throws RemoteException,
      AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(10004);
    registry.bind("AccountManager", am);
  }

  public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
    //
    TxCoord tx = getTxCoord();
    Account a = getAccountA();
    Account b = getAccountB();
    //Account c = getAccountC();
    //Account d = getAccountD();
    //Account e = getAccountE();
    //Account f = getAccountF();
    //
    System.out.println("A: " + a.print());//
    System.out.println("B: " + b.print());//
    //System.out.println(c.print());
    //System.out.println(d.print());
    //System.out.println(e.print());
    //System.out.println(f.print());
    
    //
    AccountManager manager = new AccountManagerImpl(tx, a, b/*, c, d, e*/);
    //
    System.setProperty("java.rmi.server.hostname", "127.0.0.1");
    startAccountManagerService(manager);
    //
    System.out.println("Servidor liberado para uso.");
  }

}
