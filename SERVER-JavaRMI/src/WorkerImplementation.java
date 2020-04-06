import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WorkerImplementation extends UnicastRemoteObject implements Worker {
    public WorkerImplementation() throws RemoteException{
        super();
    }

    @Override
    public ResultType work(Task task) throws RemoteException {
        return task.work();
    }
}
