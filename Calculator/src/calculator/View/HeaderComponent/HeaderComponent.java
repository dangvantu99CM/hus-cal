/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.View.HeaderComponent;

import calculator.MenuData.MenuData;
import calculator.MenuData.MenuItem;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author tudv
 */
public class HeaderComponent extends JMenuBar{

    public HeaderComponent(MenuData menuData) {
        createMenu(menuData.setListDataMenuBar());
    }

    private void createMenu(ArrayList<MenuItem> listMenu) {
        for (MenuItem item : listMenu) {
            this.add(this.createHeader(item));
        }
    }

    private JMenu createHeader(MenuItem data) {
        JMenu menuBar = new JMenu();
        menuBar.setText(data.text);
        menuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (data.action != null) {
                    data.action.onClick(data);
                }
            }
        });
        if (data.listChild != null && data.listChild.size() > 0) {
            for (MenuItem item : data.listChild) {
                menuBar.add(createHeader(item));
            }
        }
        return menuBar;
    }
}
