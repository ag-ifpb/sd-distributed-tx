package pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class TxCoordImpl extends UnicastRemoteObject implements TxCoord {
  private TxAccount txAccountA;
  private TxAccount txAccountB;
  
  public TxCoordImpl(TxAccount txa, TxAccount txb) throws RemoteException {
    txAccountA = txa;
    txAccountB = txb;
  }

  @Override
  public void prepareAll() throws RemoteException {
    txAccountA.prepare();
    txAccountB.prepare();
  }

  @Override
  public void commitAll() throws RemoteException {
    txAccountA.commit();
    txAccountB.commit();
  }

  @Override
  public void rollbackAll() throws RemoteException {
    txAccountA.rollback();
    txAccountB.rollback();
  }

}
