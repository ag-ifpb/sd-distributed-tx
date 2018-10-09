package pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TxAccount extends Remote {
  //prepara a transação localmente
  void prepare() throws RemoteException;//identificar a transacao
  //realiza um commit localmente
  void commit() throws RemoteException;
  //realiza um rollback localmente
  void rollback() throws RemoteException;
}
