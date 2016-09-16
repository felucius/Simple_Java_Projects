/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.server.UnicastRemoteObject;
import Interface.IAnimal;
import java.rmi.RemoteException;

/**
 *
 * @author M
 */

/*
UnicastRemoteObject sends the object with its content trough the IP
The interface implementation is needed to give it context. This information is
going to be send with UnicastRemoteObject
*/
public class Animal extends UnicastRemoteObject implements IAnimal {

    public Animal() throws RemoteException {
        /*
        Thanks to UnicastRemoteObject this object does not have to be exported
        manually. This would have been the case with 'extends RemoteServer' 
        UnicastRemoteObject does this automatically
         */
    }

    /*
    All the methods below are getting some content.
    */
    @Override
    public String[] breeds() throws RemoteException {
        String[] breeds = {"Bulldog", "American shorthair cat", "Yorkshire terrier", "Norwegian forest cat",
            "Labrador", "Munchkin cat"};
        return breeds;
    }

    @Override
    public String[] dogNames() throws RemoteException {
        String[] dogNames = {"Felix", "Joshua", "Max", "Rupert", "Rex", "Nala"};
        return dogNames;
    }

    @Override
    public String[] catNames() throws RemoteException {
        String[] catNames = {"Mittens", "Furry", "Truffels", "Mr mc Shire", "Noodles", "Dan -the amazing- cat"};
        return catNames;
    }

    @Override
    public String animalShelter() throws RemoteException {
        String shelter = "St. Loveable shelter";
        return shelter;
    }

    @Override
    public String[] employees() throws RemoteException {
        String[] employees = {"Peter", "Hanna", "Angie", "Chris", "Ronald"};
        return employees;
    }

}
