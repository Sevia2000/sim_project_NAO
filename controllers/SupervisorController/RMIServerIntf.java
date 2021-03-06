import java.rmi.Remote;
import java.rmi.RemoteException;
import java.awt.geom.Point2D;
 
public interface RMIServerIntf extends Remote {
    public double getAngle() throws RemoteException;
     public Point2D.Double getLocation() throws RemoteException;
     public void addCommand(String command) throws RemoteException;
    public int getCasualty(String codename) throws RemoteException;
    public double getDoorPosition(String node) throws RemoteException;
    public double getDoorMaxStop(String node) throws RemoteException;
    public double getDoorMinStop(String node) throws RemoteException;
    
}