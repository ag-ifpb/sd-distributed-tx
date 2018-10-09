package br.edu.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Remote{
	void debit(double value) throws RemoteException;
	void credit(double value) throws RemoteException;
	double balance() throws RemoteException;
}
