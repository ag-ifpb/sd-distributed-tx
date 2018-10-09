package pod;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class AccountImpl extends UnicastRemoteObject implements Account, TxAccount {
	private float transBalance = 0f;//saldo transacional
	private float currentBalance = 10000f;//saldo real
	private boolean inTransaction = false;//está bloqueado?
	
	protected AccountImpl() throws RemoteException {
		super();
	}

	@Override
	public void prepare() throws RemoteException {
		transBalance = currentBalance;//estado atual para o estado transacional
		inTransaction = true;//bloquear
	}

	@Override
	public void commit() throws RemoteException {
		if (inTransaction){
			currentBalance = transBalance;//atribui novo saldo
			inTransaction = false;
			transBalance = 0f;
		}
	}

	@Override
	public void rollback() throws RemoteException {
		if (inTransaction){
			transBalance = 0f;//volta para o saldo anterior
			inTransaction = false;
		}
	}

	@Override
	public void debit(float value) throws RemoteException {
		if (inTransaction){
			transBalance -= value;
		}
		else {
			throw new RemoteException("Transação não preparada.");
		}
	}

	@Override
	public void credit(float value) throws RemoteException {
		if (inTransaction){
			transBalance += value;
		}
		else {
			throw new RemoteException("Transação não preparada.");
		}
	}
	
	@Override
	public float print() throws RemoteException {
		System.out.println("Saldo atual: " + currentBalance);
		return currentBalance;
	}

}
