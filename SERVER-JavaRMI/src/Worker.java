import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Worker extends Remote {
    ResultType prime(Task task) throws RemoteException;
    ResultType med(Task task) throws RemoteException;
}
