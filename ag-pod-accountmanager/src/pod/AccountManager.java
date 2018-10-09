package pod;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AccountManager extends Remote {
  void transfer(String srcAccount, float value) throws RemoteException;
}
  