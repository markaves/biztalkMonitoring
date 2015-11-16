/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biztalkmonitoring;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author aves
 */
public class BiztalkMonitoring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("powershell.exe C:\\Temp\\biztalkquery.ps1");
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
        reader.close();
        proc.getOutputStream().close();
    }
    
}
