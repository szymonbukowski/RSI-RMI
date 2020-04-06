import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WorkerImplementation extends UnicastRemoteObject implements Worker {
    public WorkerImplementation() throws RemoteException{
        super();
    }

    @Override
    public ResultType prime(Task task) throws RemoteException {
        return task.prime();
    }

    @Override
    public ResultType med(Task task) throws RemoteException {
        return task.med();
    }
}
