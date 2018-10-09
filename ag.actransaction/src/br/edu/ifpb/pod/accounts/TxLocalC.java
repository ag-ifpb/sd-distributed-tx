package br.edu.ifpb.pod.accounts;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifpb.pod.Account;
import br.edu.ifpb.pod.TxLocal;

@SuppressWarnings("serial")
public class TxLocalC extends UnicastRemoteObject implements TxLocal {
	private Double oldState = null;
	private Account account;
	
	protected TxLocalC() throws RemoteException {}
	
	public TxLocalC(AccountC account) throws RemoteException {
		this.account = account; 
	}

	@Override
	public void prepare() throws RemoteException {
		oldState = account.balance();
	}

	@Override
	public void commit() throws RemoteException {
		oldState = null;
	}

	@Override
	public void rollback() throws RemoteException {
		double newState = account.balance();
		double diff = newState - oldState;
		if (diff > 0){
			account.debit(Math.abs(diff));
		}
		else {
			account.credit(Math.abs(diff));
		}
	}

}
