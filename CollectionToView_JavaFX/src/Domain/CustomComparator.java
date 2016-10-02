/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Comparator;
import javafx.scene.control.TreeItem;

/**
 *
 * @author Maxime de Lange
 */
public class CustomComparator implements Comparator<TreeItem<String>>{

    /*
    Comparing tree item string value with an other.
    */
    @Override
    public int compare(TreeItem<String> o1, TreeItem<String> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
    
}
