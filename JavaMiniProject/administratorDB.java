import java.sql.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
// import javax.swing.JRootPane;
// import javax.swing.SwingUtilities;
// import javax.swing.UIManager;
// import javax.swing.plaf.ColorUIResource;
// import javax.swing.plaf.metal.DefaultMetalTheme;
// import javax.swing.plaf.metal.MetalLookAndFeel;

// class MyDefaultMetalTheme extends DefaultMetalTheme {
//     public ColorUIResource getWindowTitleInactiveBackground() {
//       return new ColorUIResource(java.awt.Color.RED);
//     }
  
//     public ColorUIResource getWindowTitleBackground() {
//       return new ColorUIResource(new Color(199, 245, 255));
//     }
  
//     public ColorUIResource getPrimaryControlHighlight() {
//       return new ColorUIResource(java.awt.Color.PINK);
//     }
  
//     public ColorUIResource getPrimaryControlDarkShadow() {
//       return new ColorUIResource(java.awt.Color.BLACK);
//     }
  
//     public ColorUIResource getPrimaryControl() {
//       return new ColorUIResource(java.awt.Color.WHITE);
//     }
  
//     public ColorUIResource getControlHighlight() {
//       return new ColorUIResource(java.awt.Color.WHITE);
//     }
  
//     public ColorUIResource getControlDarkShadow() {
//       return new ColorUIResource(java.awt.Color.BLACK);
//     }
  
//     public ColorUIResource getControl() {
//       return new ColorUIResource(java.awt.Color.WHITE);
//     }
//   }

public class administratorDB {
    administratorDB()
    {
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        
        JFrame f = new JFrame("                                                                                                                                                                                                                       TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
    	f.setUndecorated(true);
        f.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        ImageIcon img = new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\BUS.png");
        f.setIconImage(img.getImage());

        JPanel panell = new JPanel();
        panell.setBackground(java.awt.Color.white);
        f.setContentPane(panell);

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
        try {
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
        e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(f);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
      //panel.setBackground(new Color(213, 134, 145, 123));
       //panel.setBorder(border);
               
        JLabel l13 = new JLabel("Username",JLabel.LEFT);
        l13.setForeground(Color.BLACK);
        l13.setFont(new Font("SansSerif", Font.BOLD,24));
        c2.gridx = 0;
        c2.gridy = 0;
        c2.insets = new Insets(20,20,20,0);
        panel.add(l13, c2);

        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(200,30));
        //tf.setBackground(new Color(230, 251, 252));
        tf.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(20,0,20,20);
        tf.setBorder(border);
        panel.add(tf, c2);
        
        JLabel l14 = new JLabel("Password",JLabel.LEFT);
        l14.setForeground(Color.black);
        l14.setFont(new Font("SansSerif", Font.BOLD, 24));
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(20,20,20,0);
        panel.add(l14, c2);

        JPasswordField tf1 = new JPasswordField();
        //tf1.setBackground(new Color(230, 251, 252));
        tf1.setPreferredSize(new Dimension(200,30));
        tf1.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 1;
        c2.insets = new Insets(20,0,20,20);
        tf1.setBorder(border);
        panel.add(tf1, c2);
        
        
        JLabel l15 = new JLabel("Confirm Password",JLabel.LEFT);
        l15.setForeground(Color.BLACK);
        l15.setFont(new Font("SansSerif", Font.BOLD, 24));
        c2.gridx = 0;
        c2.gridy = 2;
        c2.insets = new Insets(20,20,20,0);
        panel.add(l15, c2);

        JPasswordField tf2 = new JPasswordField();
        //tf2.setBackground(new Color(230, 251, 252));
        tf2.setPreferredSize(new Dimension(200,30));
        tf2.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 2;
        c2.insets = new Insets(20,0,20,20);
        tf2.setBorder(border);
        panel.add(tf2, c2);

        Button btn = new Button("Sign up");
        btn.setBackground(new Color(230, 251, 252));
        btn.setPreferredSize(new Dimension(150,50));
        btn.setFont(new Font("SansSerif",Font.BOLD,24));  
        c2.gridx = 0;
        c2.gridy = 3;
        c2.insets = new Insets(20,175,20,0);
        panel.add(btn, c2);
        
        panel.setOpaque(false);
        
        
btn.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ee)
    {
        if(tf.getText().equals("") && String.valueOf(tf1.getPassword()).equals("") && String.valueOf(tf2.getPassword()).equals(""))
        {
          JOptionPane.showMessageDialog(f,"Please Enter Valid Details");
        }
        else{

            if(new String(tf1.getPassword()).equals(new String(tf2.getPassword())))
            {
                try {
                    String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
                    String databaseURL = "jdbc:ucanaccess://" + location;
                    Connection connection = DriverManager.getConnection(databaseURL);
                    System.out.println("Connection done Successfully");
        
                    PreparedStatement ps = connection.prepareStatement("insert into DBBB (Userr,Password) values(?,?)");
                    ps.setString(1, tf.getText());
                    ps.setString(2, new String(tf1.getPassword()));
                    ps.executeUpdate();
                    connection.close();
                    f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
                    new adminstratorlogin();
                }
                    catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(f,"Passwords Don't Match ! Re-enter Properly !","Alert",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");
                tf2.setText("");
            }
        }
        
    }
});
       
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\bus5.jpg")));
        f.setLayout(new FlowLayout(FlowLayout.RIGHT,30,300));
        f.add(panel);
       
        
        f.setVisible(true);
        f.setSize(1536,820);
    }
    
    public static void main(String[] args) {
        new administratorDB();
    }
}