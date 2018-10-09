package br.edu.ifpb.pod.accounts;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		//
		AccountA accountA = new AccountA();
		AccountB accountB = new AccountB();
		AccountC accountC = new AccountC();
		Registry registry = LocateRegistry.createRegistry(10990);
		registry.bind("AccountA", accountA);
		registry.bind("AccountB", accountB);
		registry.bind("AccountC", accountC);
		//
		TxLocalA txLocalA = new TxLocalA(accountA);
		TxLocalB txLocalB = new TxLocalB(accountB);
		TxLocalC txLocalC = new TxLocalC(accountC);
		Registry txregistry = LocateRegistry.createRegistry(10989);
		txregistry.bind("TxLocalA", txLocalA);
		txregistry.bind("TxLocalB", txLocalB);
		txregistry.bind("TxLocalC", txLocalC);
	}
}
