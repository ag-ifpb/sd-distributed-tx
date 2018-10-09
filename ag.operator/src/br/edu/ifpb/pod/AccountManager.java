package br.edu.ifpb.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountManager extends Remote{
	void transfer(String source, String dest, double value) throws RemoteException;
	void printBalance() throws RemoteException;
}
