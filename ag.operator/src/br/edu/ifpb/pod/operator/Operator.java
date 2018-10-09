package br.edu.ifpb.pod.operator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.edu.ifpb.pod.AccountManager;
import br.edu.ifpb.pod.TxCoord;

public class Operator {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		//TxCoord
		Registry txregistry = LocateRegistry.getRegistry(10992);
		TxCoord txCoord = (TxCoord) txregistry.lookup("TxCoord");
		//AccountManager
		Registry acregistry = LocateRegistry.getRegistry(10991);
		AccountManager manager = (AccountManager) acregistry.lookup("AccountManager");
		//transação
		txCoord.prepareAll();
		manager.transfer("A", "B", 100);
		txCoord.rollbackAll();
		manager.printBalance();
	}
}
