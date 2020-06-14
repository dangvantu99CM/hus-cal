/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MenuData;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author tudv
 */
public class MenuItem {
    public String text="";
    public ArrayList<MenuItem> listChild = new ArrayList<>();
    public ActionMenuItem action = null;
    public ImageIcon imgIcon=null;
    
    public String color="";
    public MenuItem(String text,ImageIcon imgIcon,String color,ActionMenuItem clickItem,ArrayList<MenuItem> listChild){
        this.text = text;
        this.action = clickItem;
        if(listChild != null && listChild.size() > 0){
            this.listChild.addAll(listChild);
        }
        this.imgIcon = imgIcon;
        this.color = color;
    }
}
