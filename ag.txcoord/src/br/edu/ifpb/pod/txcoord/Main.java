package br.edu.ifpb.pod.txcoord;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry regitry = LocateRegistry.createRegistry(10992);
		regitry.bind("TxCoord", new TxCoordImpl());

	}
}
