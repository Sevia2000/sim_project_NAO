import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 

import java.util.Map;
import java.util.HashMap;

import java.util.Random;
import java.security.SecureRandom;

import java.util.ArrayList;

import java.awt.geom.Point2D;

public class RMIServer extends UnicastRemoteObject implements RMIServerIntf
{
    public double x = 0;
    public double y = 0;
    public double angle = 0;
    public int[] roomCasualties = new int[8];
    
    private static final int BOX_COUNT = 50;
    
    public Map<String, Integer> casualties = new HashMap<String, Integer>();
 
    public ArrayList<String> commands = new ArrayList<String>();
    
    public RMIServer() throws RemoteException
    {
        //out of 100
   
    }
    
    public void generate()
    {
        SecureRandom rand = new SecureRandom();
        
        for(int i = 0; i < 8; i++)
        {
            roomCasualties[i] = 0;
        }
        
        for(int i = 0; i < BOX_COUNT; i++)
        {
            byte[] bytes = new byte[20];
            rand.setSeed(bytes);
            
            int gen = rand.nextInt(100) + 1;
            
            if(gen <= 5)
            {
                roomCasualties[0] += 1;
            }
            else if(gen <= 15)
            {
            
            }
            else if(gen <= )
            {
            
            }
        }
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
    
    public int getCasualty(String room)
    {
        return casualties.get(room).intValue();
    }
    


}