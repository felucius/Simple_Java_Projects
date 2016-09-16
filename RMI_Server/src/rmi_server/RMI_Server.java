/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author M
 */
public class RMI_Server {
    // Binding name is needed so the client can connect to the correct server
    private static String BINDING_NAME = "animal";
    // Port number is needed to make the connection with the RMI server. RMI is port number 1099
    private static int PORT_NUMBER = 1099;
    // Registry is needed to bind the object to it
    private Registry registry = null;
    // Object is needed to bind its content to the registry
    private Animal animal = null;
    
    /*
    All methods within the constructor are going to be within a 'try-catch' block
    the reason for this is that the remote connection can be unsuccesful. Therefore
    we need to try this and if it fails we give a error message so the application does not
    crash on us.
    */
    public RMI_Server(){
        // Create object
        try {
            animal = new Animal();
            System.out.println("Server: Object succesfully created");
        } catch (Exception e) {
            System.out.println("Server: Cannot create object. Check if object is not null");
            System.out.println("Error: " + System.err);
        }
        
        // Create registry on RMI port number 1099
        try {
            registry = LocateRegistry.createRegistry(PORT_NUMBER);
            System.out.println("Server: Registry succesfully create on port number: " + PORT_NUMBER);
        } catch (Exception e) {
            System.out.println("Server: Cannot create registry on given port number. Check for valid port number");
            System.out.println("Error: " + System.err);
        }
        
        // Bind object and binding name to registry
        try {
            registry.rebind(BINDING_NAME, animal);
            System.out.println("Server: Binding name: " + BINDING_NAME + " and object are succesful bound to registry");
        } catch (Exception e) {
            System.out.println("Server: Cannot bind object or binding name. Check if registry is not null");
            System.out.println("Error: " + System.err);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Server: Server is starting..");
        RMI_Server server = new RMI_Server();
    }
    
}
