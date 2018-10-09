import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ConnTest {
  //private static final String HOST_A = "192.168.1.101";OK
  //private static final String HOST_B = "192.168.1.106";OK
  private static final String HOST_C = "192.168.1.102";//OK
  //private static final String HOST_D = "192.168.1.104";
  //private static final String HOST_E = "192.168.1.105";OK

  public static void main(String[] args) throws RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry(HOST_C, 10001);
    System.out.println(registry.lookup("TxServ"));
  }
}
