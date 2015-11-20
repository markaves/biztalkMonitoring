/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biztalkmonitoring;

import java.net.Socket;

/**
 *
 * @author aves
 */
public class checker {
    
    
    public static String[] conn = new String[1000];
    public static int cnt2=0;
    
    
    public static boolean serverListening(String connect)
    {   
     String delims_0 = "[ ]";
     String[] tokens_0 = connect.split(delims_0);   
        
     //System.out.println(connect);

     
    Socket s = null;
    try
    {
        s = new Socket(tokens_0[0], Integer.parseInt(tokens_0[1]));
        return true;
    }
    catch (Exception e)
    {
        System.out.println("false");
        conn[cnt2] = connect;
        cnt2++;
        return false;
    }
    finally
    {
        if(s != null)
            try {s.close();}
            catch(Exception e){}
    }
    }
  
    public String ftpResult(){
        String result="";
        for(int i = 0; i < cnt2; i++)
        {
           result = result + " " + conn[i]; 
        }
        return result;
    }
 
}
