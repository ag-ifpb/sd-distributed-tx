package pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class AccountManagerImpl extends UnicastRemoteObject implements AccountManager {
  private TxCoord txCoord;
  private Account accountA;
  private Account accountB;

  protected AccountManagerImpl(TxCoord tx, Account a, Account b) throws RemoteException {
    txCoord = tx;
    accountA = a;
    accountB = b;
  }

  @Override
  public void transfer(String srcAccount, float value) throws RemoteException {
    //
	float part = value;
    //
    try {
      //preparar a transação
      txCoord.prepareAll();
      //inicializa a operação
      if ("A".equals(srcAccount)){
        accountA.debit(value);
        accountB.credit(part);
      }
      else if ("B".equals(srcAccount)){
        accountB.debit(value);
        accountA.credit(part);
      }
      else {
        throw new RemoteException("Conta não encontrada.");
      }
      //commit
      txCoord.commitAll();
    }
    catch (RemoteException e){
      txCoord.rollbackAll();
      throw new RemoteException(e.getMessage());
    }
  }

}
