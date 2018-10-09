package br.edu.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TxLocal extends Remote{
	void prepare() throws RemoteException;
	void commit() throws RemoteException;
	void rollback() throws RemoteException;
}
