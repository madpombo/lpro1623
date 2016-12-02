/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author up201405198
 */


/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 */ 
 
import java.net.*;
import java.io.*;
import java.sql.*;
 
public class KKMultiServerThread extends Thread {
   private Socket socket = null;
 
   public KKMultiServerThread(Socket socket) {
      super("KKMultiServerThread");
      this.socket = socket;
   }
 
   public void run() {
       String user, password, url;
      /*try {
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
         String inputLine, outputLine;
         KnockKnockProtocol kkp = new KnockKnockProtocol();
         outputLine = kkp.processInput(null);
         out.println(outputLine);
 
         while ((inputLine = in.readLine()) != null) {
            outputLine = kkp.processInput(inputLine);
            out.println(outputLine);
            if (outputLine.equals("Bye"))
               break;
         }
         out.close();
         in.close();
         socket.close();
 
      } catch (IOException e) {
         e.printStackTrace();
      }
      */
    // Load the JDBC driver
    try { 
        Class.forName("org.postgresql.Driver"); 
        } 
    catch (ClassNotFoundException e) {
        System.err.println(e);
        }
    
    // Connect to the database
    user = "lpro1623";
    password = "W!3663lnp";
    url = "jdbc:postgresql://dbm.fe.up.pt/lpro1623";
    Connection con = null;
    try { con = DriverManager.getConnection( url, user, password); 
    } 
    catch (SQLException e) {
         System.err.println(e);
    }
    try{
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id = 1");
    while (rs.next())
    { 
    System.out.print("Column 1 returned ");
    System.out.println(rs.getString(1));
    }
    rs.close();
    st.close();
    }
    catch(SQLException e) {
         System.err.println(e);
    }
   }
}

