/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.View.Help;

/**
 *
 * @author anhpv
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class Help extends JFrame{

    public static void createDocumentStyles(StyleContext sc) {
        Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);

        // Create and add the main document style
        Style mainStyle = sc.addStyle(mainStyleName, defaultStyle);
        StyleConstants.setLeftIndent(mainStyle, 16);
        StyleConstants.setRightIndent(mainStyle, 16);
        StyleConstants.setFirstLineIndent(mainStyle, 16);
        StyleConstants.setFontFamily(mainStyle, "serif");
        StyleConstants.setFontSize(mainStyle, 12);

        // Create and add the constant width style
        Style cwStyle = sc.addStyle(charStyleName, null);
        StyleConstants.setFontFamily(cwStyle, "monospaced");
        StyleConstants.setForeground(cwStyle, Color.RED);

        // Create and add the heading style
        Style heading2Style = sc.addStyle(heading2StyleName, null);
        StyleConstants.setForeground(heading2Style, Color.red);
        StyleConstants.setFontSize(heading2Style, 16);
        StyleConstants.setFontFamily(heading2Style, "serif");
        StyleConstants.setBold(heading2Style, true);
        StyleConstants.setLeftIndent(heading2Style, 20);
        StyleConstants.setFirstLineIndent(heading2Style, 0);

        // Create and add the heading style
        Style heading2_1Style = sc.addStyle(Heading3StyleName, null);
        StyleConstants.setForeground(heading2_1Style, Color.ORANGE);
        StyleConstants.setFontSize(heading2_1Style, 14);
        StyleConstants.setFontFamily(heading2_1Style, "serif");
        StyleConstants.setBold(heading2_1Style, true);
        StyleConstants.setLeftIndent(heading2_1Style, 20);
        StyleConstants.setFirstLineIndent(heading2_1Style, 0);

        // Create and add the extended para styles
        Style paraStyle = sc.addStyle(paraStyleName, null);
        Color bgColor = Color.white;
        ExtendedStyleConstants.setParagraphBackground(paraStyle, bgColor);
        ExtendedStyleConstants.setParagraphBorder(paraStyle, BorderFactory
                .createCompoundBorder(BorderFactory.createEmptyBorder(2, 2, 2,
                                2), BorderFactory.createCompoundBorder(BorderFactory
                                .createEtchedBorder(bgColor.brighter(), bgColor
                                        .darker()), BorderFactory.createEmptyBorder(4,
                                        4, 4, 4))));
        

    }

    public static void addText(JTextPane pane, StyleContext sc,
            Style logicalStyle, Paragraph[] content) {
        // The outer loop adds paragraphs, while the
        // inner loop adds character runs.
        int paragraphs = content.length;
        for (int i = 0; i < paragraphs; i++) {
            Run[] runs = content[i].content;
            for (int j = 0; j < runs.length; j++) {
                pane.setCharacterAttributes(
                        runs[j].styleName == null ? SimpleAttributeSet.EMPTY
                                : sc.getStyle(runs[j].styleName), true);
                pane.replaceSelection(runs[j].content);
            }

            // At the end of the paragraph, add the logical style and
            // any overriding paragraph style and then terminate the
            // paragraph with a newline.
            pane.setParagraphAttributes(SimpleAttributeSet.EMPTY, true);

            if (logicalStyle != null) {
                pane.setLogicalStyle(logicalStyle);
            }

            if (content[i].styleName != null) {
                pane.setParagraphAttributes(sc.getStyle(content[i].styleName),
                        false);
            }

            if (i != paragraphs - 1) {
                pane.replaceSelection("\n");
            }
        }
    }
    
    public Help(){
        this.setTitle("Hướng dẫn dử dụng phần mềm");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {
        }
        // Create the StyleContext, the document and the pane
        final StyleContext sc = new StyleContext();
        final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
        final JTextPane pane = new JTextPane(doc);
        pane.setEditorKit(new ExtendedStyledEditorKit());
        createDocumentStyles(sc);
        // Add the text
        addText(pane, sc, sc.getStyle(mainStyleName), content);
        this.getContentPane().add(new JScrollPane(pane));
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setVisible(true);
    }
   
    // Style names
    public static final String mainStyleName = "MainStyle";

    public static final String heading2StyleName = "Heading2";

    public static final String Heading3StyleName = "Heading3";

    public static final String charStyleName = "ConstantWidth";

    public static final String paraStyleName = "ExtendedPara";

    // Inner classes used to define paragraph structure
    public static class Run {

        public Run(String styleName, String content) {
            this.styleName = styleName;
            this.content = content;
        }

        public String styleName;

        public String content;
    }

    public static class Paragraph {

        public Paragraph(String styleName, Run[] content) {
            this.styleName = styleName;
            this.content = content;
        }

        public String styleName;

        public Run[] content;
    }

    public static final Paragraph[] content = new Paragraph[]{
        ///////////////1111111111111
        new Paragraph(Heading3StyleName, new Run[]{new Run(Heading3StyleName, "1.Chức năng cơ bản")}),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Sử dụng các phím số học 0,1,2,3,4,5,6,7,8,9,+,-,*,/ "
                            + "để xây dựng các biểu số học cơ bản. " 
                ),
            }
        ),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Để kết hợp sin,cos,tan,căn bậc 2 hãy"
                        + " sử dụng các button bên trái của các phím số học."
                ),
            }
        ),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Các nút bổ trợ như : "),
                new Run(charStyleName, "e,%,pi,x!"),
                new Run(null, " giúp tính toán e, pi, phần trăm, giai thừa."),
            }
        ),
         new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Dùng nút: "),
                new Run(charStyleName, "AC"),
                new Run(null, " để reset lại toàn bộ màn hình, "),
                new Run(charStyleName, "DEL"),
                new Run(null, " để xóa những kí tự trước vị trí con trỏ hiện tại, "),
                new Run(charStyleName, "ANS"),
                new Run(null, " để lấy kết quả của phép tính đã thực hiện trước đó."),
            }
        ),
         ///       2222222222222222 
        new Paragraph(Heading3StyleName, new Run[]{new Run(Heading3StyleName, "2.Chức năng nâng cao")}),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Để thực hiện các chức năng nâng cao truy cập vào thanh  : "),
                new Run(charStyleName, "menu"),
                new Run(null, " trên cùng màn hình.")
            }
        ),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Các chức năng nâng cao tương ứng: giải phương trình bậc 1 ,phương trình bậc 2"
                        + "phương trình bậc 3, nhân 2 ma trận, cộng 2 ma trận..."),
            }
        ),
         new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Dùng nút: "),
                new Run(charStyleName, "Enter"),
                new Run(null, " để tạo các hệ số phương trình , ma trận cần tính, "),
                new Run(charStyleName, "SOVEL"),
                new Run(null, " để xử lý tiến trình giải bài toán giải bài toán.")
            }
        ),
         ///////////////// 33333333333333  
        new Paragraph(Heading3StyleName, new Run[]{new Run(Heading3StyleName, "3.Lưu ý")}),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Các biểu thức sẽ "),
                new Run(charStyleName, "không tính toán được "),
                new Run(null, " nếu trong biểu thức có dấu "),
                new Run(charStyleName, " \"(\""),
                new Run(charStyleName, " \")\""),
                new Run(null, " tương ứng của nó. "),
            }
        ),
        new Paragraph(paraStyleName,
            new Run[]{
                new Run(null, "Ví dụ: "),
                new Run(charStyleName, "sin(2,5+1"),
                new Run(null, " hoặc "),
                new Run(charStyleName, "1+ln(7*5+tan(4.5)"),
            }
        ),
    };
}

class ExtendedStyleConstants {

    public ExtendedStyleConstants(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    /**
     * The border to be used for a paragraph. Type is javax.swing.border.Border
     */
    public static final Object ParagraphBorder = ExtendedParagraphConstants.ParagraphBorder;

    /**
     * The background to be used for a paragraph. Type is java.awt.Color
     */
    public static final Object ParagraphBackground = ExtendedParagraphConstants.ParagraphBackground;

    /* Adds the border attribute */
    public static void setParagraphBorder(MutableAttributeSet a, Border b) {
        a.addAttribute(ParagraphBorder, b);
    }

    /* Gets the border attribute */
    public static Border getParagraphBorder(AttributeSet a) {
        return (Border) a.getAttribute(ParagraphBorder);
    }

    /* Adds the paragraph background attribute */
    public static void setParagraphBackground(MutableAttributeSet a, Color c) {
        a.addAttribute(ParagraphBackground, c);
    }

    /* Gets the paragraph background attribute */
    public static Color getParagraphBackground(AttributeSet a) {
        return (Color) a.getAttribute(ParagraphBackground);
    }

    /* A typesafe collection of extended paragraph attributes */
    public static class ExtendedParagraphConstants extends
            ExtendedStyleConstants implements AttributeSet.ParagraphAttribute {

        /**
         * The paragraph border attribute.
         */
        public static final Object ParagraphBorder = new ExtendedParagraphConstants(
                "ParagraphBorder");

        /**
         * The paragraph background attribute.
         */
        public static final Object ParagraphBackground = new ExtendedParagraphConstants(
                "ParagraphBackground");

        private ExtendedParagraphConstants(String name) {
            super(name);
        }
    }

    protected String name; // Name of an attribute
}

class ExtendedStyledEditorKit extends StyledEditorKit {

    public Object clone() {
        return new ExtendedStyledEditorKit();
    }

    public ViewFactory getViewFactory() {
        return defaultFactory;
    }

    /* The extended view factory */
    static class ExtendedStyledViewFactory implements ViewFactory {

        public View create(Element elem) {
            String elementName = elem.getName();
            if (elementName != null) {
                if (elementName.equals(AbstractDocument.ParagraphElementName)) {
                    return new ExtendedParagraphView(elem);
                }
            }

            // Delegate others to StyledEditorKit
            return styledEditorKitFactory.create(elem);
        }
    }

    private static final ViewFactory styledEditorKitFactory = (new StyledEditorKit())
            .getViewFactory();

    private static final ViewFactory defaultFactory = new ExtendedStyledViewFactory();
}

class ExtendedParagraphView extends ParagraphView {

    public ExtendedParagraphView(Element elem) {
        super(elem);
    }

    // Override ParagraphView methods
    protected void setPropertiesFromAttributes() {
        AttributeSet attr = getAttributes();
        if (attr != null) {
            super.setPropertiesFromAttributes();
            paraInsets = new Insets(getTopInset(), getLeftInset(),
                    getBottomInset(), getRightInset());

            border = ExtendedStyleConstants.getParagraphBorder(attr);
            bgColor = ExtendedStyleConstants.getParagraphBackground(attr);
            if (bgColor != null && border == null) {
                // Provide a small margin if the background
                // is being filled and there is no border
                border = smallBorder;
            }

            if (border != null) {
                Insets borderInsets = border.getBorderInsets(getContainer());
                setInsets((short) (paraInsets.top + borderInsets.top),
                        (short) (paraInsets.left + borderInsets.left),
                        (short) (paraInsets.bottom + borderInsets.bottom),
                        (short) (paraInsets.right + borderInsets.right));
            }
        }
    }

    public void paint(Graphics g, Shape a) {
        Container comp = getContainer();
        Rectangle alloc = new Rectangle(a.getBounds());

        alloc.x += paraInsets.left;
        alloc.y += paraInsets.top;
        alloc.width -= paraInsets.left + paraInsets.right;
        alloc.height -= paraInsets.top + paraInsets.bottom;

        if (bgColor != null) {
            Color origColor = g.getColor();
            g.setColor(bgColor);
            g.fillRect(alloc.x, alloc.y, alloc.width, alloc.height);
            g.setColor(origColor);
        }

        if (border != null) {
            // Paint the border
            border.paintBorder(comp, g, alloc.x, alloc.y, alloc.width,
                    alloc.height);
        }
        super.paint(g, a); // Note: pass ORIGINAL allocation
    }

    // Attribute cache
    protected Color bgColor; // Background color, or null for transparent.

    protected Border border; // Border, or null for no border

    protected Insets paraInsets; // Original paragraph insets

    protected static final Border smallBorder = BorderFactory
            .createEmptyBorder(2, 2, 2, 2);
}
