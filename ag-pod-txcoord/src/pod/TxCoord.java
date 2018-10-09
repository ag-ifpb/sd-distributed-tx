package pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TxCoord extends Remote{
  //solicita a todos os participantes para preparar transação
  void prepareAll() throws RemoteException;
  //solicita a todos os participantes para fazer commit local
  void commitAll() throws RemoteException;
  //solicita a todos os participantes para fazer rollback local
  void rollbackAll() throws RemoteException;
}
