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
    public static boolean serverListening(String host, int port)
    {
    Socket s = null;
    try
    {
        s = new Socket(host, port);
        return true;
    }
    catch (Exception e)
    {
        return false;
    }
    finally
    {
        if(s != null)
            try {s.close();}
            catch(Exception e){}
    }
    }
}
