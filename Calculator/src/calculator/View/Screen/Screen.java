/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.View.Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author tudv
 */
public class Screen extends JPanel {

    public JTextArea taxtResult = new JTextArea(4, 50);
    public JTextArea taxt = new JTextArea(5, 50);
    public JScrollPane scroll_taxtResult = new JScrollPane(taxtResult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    public JScrollPane scroll_taxt = new JScrollPane(taxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public Screen() {
        Font font1 = taxtResult.getFont();
        float size1 = font1.getSize() + 5.0f;
        taxtResult.setFont(font1.deriveFont(size1));

        Font font2 = taxt.getFont();
        float size2 = font2.getSize() + 5.0f;
        taxt.setFont(font2.deriveFont(size2));

        this.setLayout(new BorderLayout());
        this.add(scroll_taxt, BorderLayout.PAGE_START);
        taxt.setBorder(new CompoundBorder(new LineBorder(Color.BLACK, 1), new EmptyBorder(10, 10, 10, 10)));
        taxtResult.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));

        this.add(scroll_taxtResult, BorderLayout.CENTER);
        this.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
    }

}
