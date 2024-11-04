/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.View.StoreHistory;

import calculator.Model.Da.LinkedListStack;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anhpv
 */
public class History {

    private String expresion = "";
    private String result = "";
    private String time = "";

    public LinkedListStack<History> stack = new LinkedListStack<>();

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;

    public History(String expr, String result, String time) {
        this.expresion = expr;
        this.result = result;
        this.time = time;
    }

    public History() {
    }

    public void run() {
        JFrame jf = new JFrame();
        jf.setTitle("History");
        jf.setSize(800, 600);
        jf.setLocation(300, 80);
        jf.setLayout(new BorderLayout());
        table = new JTable();
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane();
        jf.add(scrollPane, BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        updateModel();
        jf.setVisible(true);
    }

    public void updateModel() {
        scrollPane.setViewportView(table);
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("STT");
        model.addColumn("Thời gian");
        model.addColumn("Biểu thức");
        model.addColumn("Kết quả");
       // model.addColumn("Kết quả");
        int index = 0;
        for (History item : stack) {
            Object[] values = new Object[5];
            values[0] = String.valueOf(++index);
            values[1] = item.time;
            values[2] = item.expresion;
            values[3] = item.result;
        //    values[4] = new JButton("Xóa");
            model.addRow(values);
        }
        table.setModel(model);
    }

    public static void main(String[] args) {
        History h = new History();
        h.run();
    }

}
