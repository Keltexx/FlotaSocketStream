
package cliente.flota.sockets;
import java.net.*;
import java.io.*;

import comun.flota.sockets.*;

/**
 * Esta clase implementa el intercambio de mensajes
 * asociado a cada una de las operaciones basicas que comunican cliente y servidor
 */

public class AuxiliarClienteFlota {

   private MyStreamSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;
   
   private final int FIN = 0, NUEVAPARTIDA = 1, PRUEBACASILLA = 2, GETBARCO = 3, GETSOLUCION = 4;

	/**
	 * Constructor del objeto auxiliar del cliente
	 * Crea un socket de tipo 'MyStreamSocket' y establece una conexión con el servidor
	 * 'hostName' en el puerto 'portNum'
	 * @param	hostName	nombre de la máquina que ejecuta el servidor
	 * @param	portNum		numero de puerto asociado al servicio en el servidor
	 */
   AuxiliarClienteFlota(String hostName,
                     String portNum) throws SocketException,
                     UnknownHostException, IOException {
	   
  	   // Por implementar
	   serverPort = Integer.parseInt(portNum);
	   serverHost = InetAddress.getByName(hostName);
	   this.mySocket = new MyStreamSocket(serverHost, serverPort);
   } // end constructor
   
   /**
	 * Usa el socket para enviar al servidor una petición de fin de conexión
	 * con el formato: "0"
	 * @throws	IOException
	 */
   public void fin( ) {
	   
	   // Por implementar
	   
   } // end fin 
  
   /**
    * Usa el socket para enviar al servidor una petición de creación de nueva partida 
    * con el formato: "1#nf#nc#nb"
    * @param nf	número de filas de la partida
    * @param nc	número de columnas de la partida
    * @param nb	número de barcos de la partida
    * @throws IOException
    */
   public void nuevaPartida(int nf, int nc, int nb)  throws IOException {
	   // Por implementar
	   try{
		   String stream = NUEVAPARTIDA + "#"+nf+"#"+nc+"#"+nb;
		   mySocket.sendMessage(stream);
		   System.out.println(stream);
	   } catch(IOException e){
		   e.printStackTrace();
	   }
   } // end nuevaPartida

   /**
    * Usa el socket para enviar al servidor una petición de disparo sobre una casilla 
    * con el formato: "2#f#c"
    * @param f	fila de la casilla
    * @param c	columna de la casilla
    * @return	resultado del disparo devuelto por la operación correspondiente del objeto Partida
    * 			en el servidor.
    * @throws IOException
    */
   public int pruebaCasilla(int f, int c) throws IOException {
	   // Por implementar
	   int res = 0;
	   try{
		   String stream = PRUEBACASILLA + "#"+f+"#"+c;
		   mySocket.sendMessage(stream);
		   try{
			   res = Integer.parseInt(mySocket.receiveMessage());
		   }catch (NumberFormatException ex){
			   ex.printStackTrace();
		   }
	   }catch (IOException e){
		   e.printStackTrace();
	   }
	   
	   return res; // cambiar por el retorno correcto
	   
    } // end getCasilla
   
   /**
    * Usa el socket para enviar al servidor una peticion de los datos de un barco
    * con el formato: "3#idBarco"
    * @param idBarco	identidad del Barco
    * @return			resultado devuelto por la operación correspondiente del objeto Partida
    * 					en el servidor.
    * @throws IOException
    */
   public String getBarco(int idBarco) throws IOException {
	   
	   // Por implementar
	   return null; // cambiar por el retorno correcto
	   
    } // end getCasilla
   
   /**
    * Usa el socket para enviar al servidor una petición de los datos de todos los barcos
    * con el formato: "4"
    * @return	resultado devuelto por la operación correspondiente del objeto Partida
    * 			en el servidor
    * @throws IOException
    */
   public String[] getSolucion() throws IOException {
	   
	   // Por implementar
	   return null; // cambiar por el retorno correcto
	   
    } // end getSolucion
   


} //end class
