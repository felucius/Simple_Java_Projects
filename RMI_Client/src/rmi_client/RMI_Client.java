/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_client;

import Interface.IAnimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author M
 */
public class RMI_Client {
    // Binding name so client can connect with correct server
    private static String BINDING_NAME = "animal";
    // Registry for looking up information from the registry
    private Registry registry = null;
    // Object to bind the registry information to it
    private IAnimal animal = null;
    
    /*
    Also here we are going to put every method in a 'try-catch' block. Because
    the connection is remote and therefore can fail. We catch the errors so the
    application does not crash
    */
    public RMI_Client(){
        // Locate and get the registry
        try {
            registry = LocateRegistry.getRegistry();
            System.out.println("Client: Registry located and found");
        } catch (Exception e) {
            System.out.println("Client: Could not find registry. Check if registry does exist");
            System.out.println("Error:" + System.err);
        }
        
        // Looking up in the registry to get the correct information
        try {
            animal = (IAnimal)registry.lookup(BINDING_NAME);
            System.out.println("Client: Registry is looking up...");
        } catch (Exception e) {
            System.out.println("Client: Could not find registry. Check if registry exists");
            System.out.println("Error: " + System.err);
        }
        
        // Test RMI connection with the methods
        try {
            getAnimalShelter();
            getEmployees();
            getBreeds();
            getCatNames();
            getDogNames();
        } catch (Exception e) {
            System.out.println("Client: Could not display information. Check if methods are correct");
            System.out.println("Error: " + System.err);
        }
    }
    
    /*
    Here we create RMI methods. These methods are going to be used to test the RMI connection
    Here we will call the method name from the interface. If the connection is established we will
    receive the information from the Animal class.
    
    All these methods have an 'throws RemoteException'. The reason behind this is
    that the connection is still remote. The connection may fail and therefore the
    method cannot be displayed.
    */
    public void getBreeds() throws RemoteException{
        String[] breeds = animal.breeds();
        for(int i = 0; i < breeds.length; i++){
            System.out.println("Client: Types of animal breeds: " + breeds[i]);
        }
    }
    
    public void getDogNames() throws RemoteException{
        //String[] dogNames = animal.dogNames();
        for(String dogNames : animal.dogNames()){
            for(String breed : animal.breeds()){
                System.out.println("Client: Dog name: " + dogNames + " belongs to the breed: " + breed);
            }
        }
    }
    
    public void getCatNames() throws RemoteException{
        for(String breed : animal.breeds()){
            for(String catNames : animal.catNames()){
                System.out.println("Client: Cat name: " + catNames + " belongs to the breed: " + breed);
            }
        }
    }
    
    public void getAnimalShelter() throws RemoteException{
        System.out.println("Client: Animal shelter: " + animal.animalShelter());
    }
    
    public void getEmployees() throws RemoteException{
        String[] employees = animal.employees();
        for(int i = 0; i < employees.length; i++){
            System.out.println("Cliet: Employees that are working at: " + animal.animalShelter() + " are: " + employees[i]);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Client: Client started...");
        RMI_Client client = new RMI_Client();
    }
    
}
