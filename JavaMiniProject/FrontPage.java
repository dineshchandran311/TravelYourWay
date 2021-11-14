import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

class MyDefaultMetalThemes extends DefaultMetalTheme {
    // public ColorUIResource getWindowTitleInactiveBackground() {
    //   return new ColorUIResource(java.awt.Color.WHITE);
    // }
  
    public ColorUIResource getWindowTitleBackground() {
      return new ColorUIResource(new Color(199, 245, 255));
    }
  
    // public ColorUIResource getPrimaryControlHighlight() {
    //   return new ColorUIResource(java.awt.Color.PINK);
    // }
  
    public ColorUIResource getPrimaryControlDarkShadow() {
      return new ColorUIResource(java.awt.Color.BLACK);
    }
  
    public ColorUIResource getPrimaryControl() {
      return new ColorUIResource(java.awt.Color.WHITE);
    }
  
    // public ColorUIResource getControlHighlight() {
    //   return new ColorUIResource(java.awt.Color.WHITE);
    // }
  
    // public ColorUIResource getControlDarkShadow() {
    //   return new ColorUIResource(java.awt.Color.BLACK);
    // }
  
    // public ColorUIResource getControl() {
    //   return new ColorUIResource(java.awt.Color.WHITE);
    // }
  }
public class FrontPage {
  JFrame frame ;
    FrontPage()
    {
        Color c = new Color(199, 245, 255);
        Color c1 = new Color(0, 0, 0);

        frame = new JFrame("                                                                                                                                                                                                                       TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
    	  frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        ImageIcon img = new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\BUS.png");
        frame.setIconImage(img.getImage());

        JPanel panell = new JPanel();
        panell.setBackground(java.awt.Color.white);
        frame.setContentPane(panell);

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalThemes());
        try {
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
        e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1536,820);

        JButton newBooking = new JButton("New Booking");
        newBooking.setPreferredSize(new Dimension(300,70));
        newBooking.setForeground(new Color(255, 255, 255));
        newBooking.setBackground(new Color(135, 184, 29));
        newBooking.setFont(new Font("SansSerif",  Font.BOLD | Font.ITALIC, 25));

        JButton PrintReceipt = new JButton("Print Receipt");
        PrintReceipt.setPreferredSize(new Dimension(300,70));
        PrintReceipt.setForeground(new Color(255, 255, 255));
        PrintReceipt.setBackground(new Color(135, 184, 29));
        PrintReceipt.setFont(new Font("SansSerif",  Font.BOLD | Font.ITALIC, 25));

        JLabel PrintReceipt1 = new JLabel("We Cordially Welcome You To \"Travel Your Way\" !!");
        PrintReceipt1.setPreferredSize(new Dimension(650,30));
        PrintReceipt1.setForeground(new Color(15, 70, 99));
        PrintReceipt1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));

        JLabel PrintReceipt2 = new JLabel("You Will Have a Fantabulous Journey With us... ");
        PrintReceipt2.setPreferredSize(new Dimension(600,30));
        PrintReceipt2.setForeground(new Color(15, 70, 99));
        PrintReceipt2.setFont(new Font("SansSerif",  Font.BOLD | Font.ITALIC, 25));

        JPanel p1=new JPanel();
        p1.setBackground(Color.BLACK);
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,400);
        p1.add(PrintReceipt,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,450,0,0);
        p1.add(newBooking,gc);


        JPanel p2=new JPanel();
        p2.setPreferredSize(new Dimension(1500,140));
        p2.setBackground(Color.BLACK);
        p2.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        p2.add(PrintReceipt1,g);
        g.gridx = 0;
        g.gridy = 1;
        p2.add(PrintReceipt2,g);


        frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\travel.png")));
        frame.setLayout(new FlowLayout());

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc2 = new GridBagConstraints();

        gc2.gridx = 0;
        gc2.gridy = 0;
        gc2.insets = new Insets(-155,0,0,0);
        frame.add(p2,gc2);
        gc2.gridx = 0;
        gc2.gridy = 1;
        gc2.insets = new Insets(400,0,0,0);
        frame.add(p1,gc2);


        newBooking.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ee)
          {
              new Miniproj("","",0,"");
              frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
          }
      });

      PrintReceipt.addActionListener(new ActionListener()
        {
    		public void actionPerformed(ActionEvent e)
    		{
    			String name = JOptionPane.showInputDialog("Enter First Name!");
    			String number = JOptionPane.showInputDialog("Enter Mobile Number(countrycode number)");
    			frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
    			new confirmationPage(name,number);
    		}
      });

        p1.setOpaque(false);
        p2.setOpaque(false);
        frame.setBackground(c);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new FrontPage();
    }
}