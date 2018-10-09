package br.edu.ifpb.pod.txcoord;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifpb.pod.TxCoord;
import br.edu.ifpb.pod.TxLocal;

@SuppressWarnings("serial")
public class TxCoordImpl extends UnicastRemoteObject implements TxCoord {

	private TxLocal getTxLocalA() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		TxLocal txLocal = (TxLocal) registry.lookup("TxLocalA");
		return txLocal;
	}
	
	private TxLocal getTxLocalB() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		TxLocal txLocal = (TxLocal) registry.lookup("TxLocalB");
		return txLocal;
	}
	
	private TxLocal getTxLocalC() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		TxLocal txLocal = (TxLocal) registry.lookup("TxLocalC");
		return txLocal;
	}
	
	public TxCoordImpl() throws RemoteException {
		super();
	}

	@Override
	public void prepareAll() throws RemoteException {
		try {
			TxLocal txLocalA = getTxLocalA();
			TxLocal txLocalB = getTxLocalB();
			TxLocal txLocalC = getTxLocalC();
			//
			txLocalA.prepare();
			txLocalB.prepare();
			txLocalC.prepare();
			//
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void commitAll() throws RemoteException {
		try {
			TxLocal txLocalA = getTxLocalA();
			TxLocal txLocalB = getTxLocalB();
			TxLocal txLocalC = getTxLocalC();
			//
			txLocalA.commit();
			txLocalB.commit();
			txLocalC.commit();
			//
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rollbackAll() throws RemoteException {
		try {
			TxLocal txLocalA = getTxLocalA();
			TxLocal txLocalB = getTxLocalB();
			TxLocal txLocalC = getTxLocalC();
			//
			txLocalA.rollback();
			txLocalB.rollback();
			txLocalC.rollback();
			//
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
