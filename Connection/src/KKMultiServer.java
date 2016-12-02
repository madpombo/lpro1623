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
 
public class KKMultiServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = null;
      boolean listening = true;
      
      try {
         serverSocket = new ServerSocket(4422);
      } catch (IOException e) {
         System.err.println("Could not listen on port: 4422.");
         System.exit(-1);
      }
 
      while (listening)
	 new KKMultiServerThread(serverSocket.accept()).start();
 
      serverSocket.close();
   }
}

