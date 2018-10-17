package servidor.flota.sockets;

import java.net.ServerSocket;
import java.io.*;
import java.net.*;
import comun.flota.sockets.MyStreamSocket;

/**
 * Este modulo contiene la logica de aplicacion del servidor del juego Hundir la flota
 * Utiliza sockets en modo stream para llevar a cabo la comunicacion entre procesos.
 * Puede servir a varios clientes de modo concurrente lanzando una hebra para atender a cada uno de ellos.
 * Se le puede indicar el puerto del servidor en linea de ordenes.
 */


public class ServidorFlotaSockets {
   
   public static void main(String[] args) {
	   int puertoServidor = 7; //Puerto por defecto
	   String mensaje;
	   
	   if(args.length == 1)
		   puertoServidor = Integer.parseInt(args[0]);
	   try {
		   //instancia un socket stream para aceptar las conexiones
		   ServerSocket miSocketConecion = new ServerSocket(puertoServidor);
//		   System.out.println("ServidorFlotaSockets listo.);
		   
		   while (true) {		//bucle infinito, espera para aceptar conexión
			   
//			   System.out-println("Espera un conexión.);
			   MiSocketStream miSocketDatos = new MiSocketStream(miSocketConexion.acecpt());
//			   System.out.printls("conexión aceptada");
			   
			   //Arranca hilo para manejar la sesión de cliente
			   Thread elHilo = new Thread(new HiloServidorFlota(miSocketDatos));
			   elHilo.start();
			   //continúa con el siguiente cliente
		   } // fin del while infinito
	   } //fin del try
	   catch (Exception ex) {
		   ex.printStackTrace();
	   } //fin del catch
	   
	  // Acepta conexiones vía socket de distintos clientes.
	  // Por cada conexión establecida lanza una hebra de la clase HiloServidorFlota.
	   

	  // Revisad el apartado 5.5 del libro de Liu
 
   } //fin main
} // fin class
