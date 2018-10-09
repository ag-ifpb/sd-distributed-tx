package br.edu.ifpb.pod.accounts;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifpb.pod.Account;

@SuppressWarnings("serial")
public class AccountB extends UnicastRemoteObject implements Account {
	private double balance = 980;
	
	public AccountB() throws RemoteException{
		super();
	}

	@Override
	public void debit(double value) throws RemoteException {
		balance -= value;
	}

	@Override
	public void credit(double value) throws RemoteException {
		balance += value;
	}
	
	public double balance() throws RemoteException{
		return balance;
	}

}
