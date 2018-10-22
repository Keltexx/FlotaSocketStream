package servidor.flota.sockets;


import java.io.IOException;
import java.net.SocketException;

import partida.flota.sockets.*;
import comun.flota.sockets.MyStreamSocket;

/**
 * Clase ejecutada por cada hebra encargada de servir a un cliente del juego Hundir la flota.
 * El metodo run contiene la logica para gestionar una sesion con un cliente.
 */

 // Revisar el apartado 5.5. del libro de Liu

class HiloServidorFlota implements Runnable {
   MyStreamSocket myDataSocket;
   private Partida partida = null;

	/**
	 * Construye el objeto a ejecutar por la hebra para servir a un cliente
	 * @param	myDataSocket	socket stream para comunicarse con el cliente
	 */
   HiloServidorFlota(MyStreamSocket myDataSocket) {
      // Por implementar
	  this.myDataSocket = myDataSocket;
	  partida = new Partida();
   }
 
   /**
	* Gestiona una sesion con un cliente	
   */
   public void run( ) {
      boolean done = false;
      int operacion = 0;
      // ...
      try {
         while (!done) {
        	 // Recibe una peticion del cliente
        	 // Extrae la operación y los argumentos
        	 String[] stream = myDataSocket.receiveMessage().split("#");
             operacion = Integer.parseInt(stream[0]);
             switch (operacion) {
	             case 0:  // fin de conexión con el cliente
	            	 // ...
	            	 break;
	
	             case 1: { // Crea nueva partida
	            	 // ...
	            	 int nf = Integer.parseInt(stream[1]);
	            	 int nc = Integer.parseInt(stream[2]);
	            	 int nb = Integer.parseInt(stream[3]);
	            	 partida = new Partida(nf, nc, nb);
	            	 break;
	             }             
	             case 2: { // Prueba una casilla y devuelve el resultado al cliente
	            	 // ... 
	            	 int f = Integer.parseInt(stream[1]);
	            	 int c = Integer.parseInt(stream[2]);
	            	 int res = partida.pruebaCasilla(f, c);
	            	 try{
	            		 myDataSocket.sendMessage(""+res);
	            	 }catch(IOException e){
	            		 e.printStackTrace();
	            	 }
	                 break;
	             }
	             case 3: { // Obtiene los datos de un barco y se los devuelve al cliente
	            	 // ... 
	                 break;
	             }
	             case 4: { // Devuelve al cliente la solucion en forma de vector de cadenas
	        	   // Primero envia el numero de barcos 
	               // Despues envia una cadena por cada barco
	               break;
	             }
             } // fin switch
         } // fin while   
      } // fin try
      catch (Exception ex) {
    	  System.out.println("Exception caught in thread: " + ex);
      } // fin catch
   } //fin run
   
} //fin class 
