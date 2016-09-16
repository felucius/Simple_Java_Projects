/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author M
 */
public interface IAnimal extends Remote{
    public String[] breeds() throws RemoteException;
    public String[] dogNames() throws RemoteException;
    public String[] catNames() throws RemoteException;
    public String animalShelter() throws RemoteException;
    public String[] employees() throws RemoteException;
}
