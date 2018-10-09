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
  
  public static TxAccount getTxAccountA() throws AccessException, RemoteException, 
      NotBoundException{
    Registry registry = LocateRegistry.getRegistry(HOST_A, PORT);
    return (TxAccount) registry.lookup("AccountA");
  }
  
  public static TxAccount getTxAccountB() throws AccessException, RemoteException, 
      NotBoundException{
    Registry registry = LocateRegistry.getRegistry(HOST_B, PORT);
    return (TxAccount) registry.lookup("AccountB");
  }
  
  public static void startTxService(TxCoord txCoord) throws RemoteException, 
      AlreadyBoundException{
    Registry registry = LocateRegistry.createRegistry(10003);
    registry.bind("TxCoord", txCoord);
    System.out.println("Coordenador iniciado na porta 10003");
  }

  public static void main(String[] args) throws AccessException, 
      RemoteException, NotBoundException, AlreadyBoundException {
	//propriedade para acesso externo ao servidor RMI
	System.setProperty("java.rmi.server.hostname", "10.3.181.63");
    //localizar a transação de A
    TxAccount txa = getTxAccountA();
    System.out.println("passed: Host A");
    //localizar a transação de B
    TxAccount txb = getTxAccountB();
    System.out.println("passed: Host B");
    //localizar a transação de C
    //TxAccount txc = getTxAccountC();
    //System.out.println("passed: Host C");
    //localizar a transação de D
    //TxAccount txd = getTxAccountD();
    //System.out.println("passed: Host D");
    //localizar a transação de E
    //TxAccount txe = getTxAccountE();
    //System.out.println("passed: Host E");
    //localizar a transação de E
    //TxAccount txf = getTxAccountF();
    //System.out.println("passed: Host F");
    //System.out.println(txf);
    //instancia do coordenador
    TxCoord txCoord = new  TxCoordImpl(txa, txb/*, txf, txd, txe*/);
    //iniciar coordanação de transações
    startTxService(txCoord);
    //log
    System.out.println("Transação Liberada.");
  }
  
}
