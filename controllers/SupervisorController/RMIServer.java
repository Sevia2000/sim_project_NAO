import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 

import java.util.ArrayList;

import java.awt.geom.Point2D;

public class RMIServer extends UnicastRemoteObject implements RMIServerIntf
{
    public double x = 0;
    public double y = 0;
    public double angle = 0;
    
    public ArrayList<String> commands = new ArrayList<String>();
    
    public RMIServer() throws RemoteException
    {
    
    }
    
    public double getAngle()
    {
        return angle;
    }
    
    public Point2D.Double getLocation()
    {
        return new Point2D.Double(x, y);
    }

    public void addCommand(String command)
    {
        commands.add(command);
    }
    


}