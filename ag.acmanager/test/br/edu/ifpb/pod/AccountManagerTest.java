package br.edu.ifpb.pod;

import java.rmi.RemoteException;

import br.edu.ifpb.pod.accountmanager.AccountManagerImpl;
import junit.framework.TestCase;

public class AccountManagerTest extends TestCase {

	public void test() throws RemoteException{
		AccountManager accountManager = new AccountManagerImpl();
		accountManager.transfer("A", "B", 50);
		//980 + 50 = 1030
		//200 - 50 = 150
	}
	
}
