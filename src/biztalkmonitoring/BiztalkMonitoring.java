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
import java.util.stream.Stream;

/**testing
 *
 * @author aves
 */
public class BiztalkMonitoring {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("powershell.exe C:\\Temp\\biztalkquery.ps1");
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
            BiztalkMonitoring passline = new BiztalkMonitoring();
            //passline.cutString(line);
        }
        reader.close();
        proc.getOutputStream().close();
    }*/
    
    public void cutString(String line){
        
        
        
    }
    /*public static void main(String[] args) {
        boolean status;
        checker ftpcheck = new checker();
        status = ftpcheck.serverListening("1.188.114.36", 3389);
        if (status){
           System.out.print("Success");
        } else {
            System.out.print("Failure");
        }
        
    }*/
    
    public static void main(String[] args) {
    String[] entries_0 = new String[10000];
    String str2 = "ftp://";
    int cnt2 = 0;
    String[] ftp_entries = new String[100000];
    //Load Path File
      sourceReader file = new sourceReader();
      entries_0 = file.readFile("C:\\biztalkmonitoring\\biztalkoutput.txt");
      for (int cnt=1; cnt < file.cnt; cnt++)
      {
          //System.out.println(entries[cnt]);
          String entries = entries_0[cnt].replaceAll("\\s+"," ");
          if (entries.toLowerCase().contains(str2.toLowerCase())) {
          
              //System.out.println(entries);
              String delims_0 = "[ ]";
              String[] tokens_0 = entries.split(delims_0);
              String instance_id = tokens_0[8];
              //System.out.println(instance_id);
              String delims = str2;
              String[] tokens = entries.split(delims);
              //System.out.println(tokens[1]);
              String delims2 = "[/]";
              String[] tokens2 = tokens[1].split(delims2);
              //System.out.println(tokens2[0]);
              String delims3 = "[:]";
              String[] tokens3 = tokens2[0].split(delims3);
              //System.out.println("IP: " + tokens3[0] + " Port: " + tokens3[1]);
              ftp_entries[cnt2] = tokens3[0] + " " + tokens3[1];
              cnt2++;
              
              
          } else {
              //System.out.println(entries[cnt]);
          }
          
         
          
      }
      
      
      
      //Check FTP ports
      checker ftpcheck = new checker();
      //Stream.of(ftp_entries).distinct().forEach(i -> System.out.println(" " + i));
      try
        { 
        Stream.of(ftp_entries).distinct().forEach(i -> ftpcheck.serverListening(i));
        //Stream<String> array1 = Stream.of(ftp_entries).distinct();
         }
        catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
        //System.out.println(array1[0]);
        String ftpresult = ftpcheck.ftpResult();
        sourceWriter logFile = new sourceWriter();
        logFile.writeFile(ftpresult);
      
    }
}   
