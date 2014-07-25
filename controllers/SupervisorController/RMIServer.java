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
    }
    
    public void generate()
    {
        SecureRandom rand = new SecureRandom();
        
        for(int i = 0; i < 8; i++)
        {
            roomCasualties[i] = 0;
        }
        int gen = 0;
        for(int i = 0; i < BOX_COUNT; i++)
        {
            gen = rand.nextInt(100) + 1;
            
			/*
			Probabilities:
			Room 1: 10
			Room 2: 5
			Room 3: 20
			Room 4: 5
			Room 5: 10
			Room 6: 15
			Room 7: 30
			Room 8: 5
			*/
			
            if(gen <= 10)
            {
                roomCasualties[0] += 1;
            }
            else if(gen <= 15)
            {
				roomCasualties[1] += 1;
            }
            else if(gen <= 35)
            {
				roomCasualties[2] += 1;
            }
			else if(gen <= 40)
			{
				roomCasualties[3] += 1;
			}
			else if(gen <= 50)
			{
				roomCasualties[4] += 1;
			}
			else if(gen <=65)
			{
				roomCasualties[5] += 1;
			}
			else if(gen <=95)
			{
				roomCasualties[6] += 1;
			}
			else
			{	roomCasualties[7] += 1;
			
			}
        }
		
		for(int i = 0; i < 8; i++)
		{
		    casualties.put("r0"+(i+1), new Integer(roomCasualties[i]));
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