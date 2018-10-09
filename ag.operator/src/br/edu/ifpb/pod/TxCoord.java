package br.edu.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TxCoord extends Remote{
	void prepareAll() throws RemoteException;
	void commitAll() throws RemoteException;
	void rollbackAll() throws RemoteException;
}
