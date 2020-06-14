/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.View.MainComponent;

import calculator.MenuData.ActionMenu;
import calculator.MenuData.MenuData;
import calculator.MenuData.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author tudv
 */
public class MainComponent extends JPanel {

    private final int SIZE_ROW = 5;
    private final int SIZE_COL = 7;

    private JButton[][] buttonMatrix = new JButton[SIZE_ROW][SIZE_COL];
    private MenuData menuData = null;

    public MainComponent(ActionMenu actionMenu) {
        menuData = new MenuData(actionMenu);
        if (menuData.initMenuItem().size() > 0) {
            initMainComponent(menuData.initMenuItem());;
        }
    }

    public void initMainComponent(ArrayList<MenuItem> listMenuItem) {
        this.setLayout(new GridLayout(SIZE_ROW, SIZE_COL, 10, 10));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
//        this.add(new JTextArea(4, 200));
        addData(listMenuItem);
    }

    public void addData(ArrayList<MenuItem> listMenuItem) {

        int count = 0;

        if (listMenuItem == null || listMenuItem.size() <= 0) {
            return;
        }

        for (int i = 0; i < SIZE_ROW; i++) {
            for (int j = 0; j < SIZE_COL; j++) {
                MenuItem it = listMenuItem.get(count);
                if (it.text.equalsIgnoreCase("SQRT")) {
                    ImageIcon sqrt_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\sqrt_1.png");
                    Image image = sqrt_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    sqrt_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(sqrt_icon);
                } else if (it.text.equalsIgnoreCase("pi")) {
                    ImageIcon pi_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\pi_1_1.png");
                    Image image = pi_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    pi_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(pi_icon);
                } else if (it.text.equalsIgnoreCase("x^y")) {
                    ImageIcon x_deg_y_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\x^y.png");
                    Image image = x_deg_y_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    x_deg_y_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(x_deg_y_icon);
                } else if (it.text.equalsIgnoreCase("+")) {
                    ImageIcon x_deg_y_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\add_2.png");
                    Image image = x_deg_y_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    x_deg_y_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(x_deg_y_icon);
                } else if (it.text.equalsIgnoreCase("-")) {
                    ImageIcon x_deg_y_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\subtract_1.png");
                    Image image = x_deg_y_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    x_deg_y_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(x_deg_y_icon);
                } else if (it.text.equalsIgnoreCase("*")) {
                    ImageIcon x_deg_y_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\mul.png");
                    Image image = x_deg_y_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    x_deg_y_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(x_deg_y_icon);
                } else if (it.text.equalsIgnoreCase("/")) {
                    ImageIcon x_deg_y_icon = new ImageIcon("C:\\Users\\Henry\\Documents\\NetBeansProjects\\Calculator\\src\\calculator\\Resource\\Image\\divide.png");
                    Image image = x_deg_y_icon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    x_deg_y_icon = new ImageIcon(newimg);  // transform it back
                    buttonMatrix[i][j] = new JButton(x_deg_y_icon);
                } else {
                    buttonMatrix[i][j] = new JButton(it.text);
                }
                String[] arrColor = it.color.split(",");
                Color c = new Color(Integer.parseInt(arrColor[0]),Integer.parseInt(arrColor[1]),Integer.parseInt(arrColor[2]));
                buttonMatrix[i][j].setSize(100, 200);
                buttonMatrix[i][j].setBackground(c);
                Font newButtonFont = new Font(buttonMatrix[i][j].getFont().getName(), buttonMatrix[i][j].getFont().getStyle(), 15);
                buttonMatrix[i][j].setFont(newButtonFont);
                buttonMatrix[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (it != null) {
                            System.out.println("aaaaaaaaaa" + it.text);
                            it.action.onClick(it);
                        }
                    }
                });
                this.add(buttonMatrix[i][j]);
                count++;
            }
        }
    }

}
