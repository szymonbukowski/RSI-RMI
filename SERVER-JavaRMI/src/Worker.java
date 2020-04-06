import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Worker extends Remote {
    ResultType work(Task task) throws RemoteException;
}
