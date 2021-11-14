import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

class MyDefaultMetalTheme extends DefaultMetalTheme {
    public ColorUIResource getWindowTitleInactiveBackground() {
      return new ColorUIResource(java.awt.Color.RED);
    }
  
    public ColorUIResource getWindowTitleBackground() {
      return new ColorUIResource(new Color(199, 245, 255));
    }
  
    public ColorUIResource getPrimaryControlHighlight() {
      return new ColorUIResource(java.awt.Color.PINK);
    }
  
    public ColorUIResource getPrimaryControlDarkShadow() {
      return new ColorUIResource(java.awt.Color.BLACK);
    }
  
    public ColorUIResource getPrimaryControl() {
      return new ColorUIResource(java.awt.Color.WHITE);
    }
  
    public ColorUIResource getControlHighlight() {
      return new ColorUIResource(java.awt.Color.WHITE);
    }
  
    public ColorUIResource getControlDarkShadow() {
      return new ColorUIResource(java.awt.Color.BLACK);
    }
  
    public ColorUIResource getControl() {
      return new ColorUIResource(java.awt.Color.WHITE);
    }
  }
class adminstratorlogin {
	String a,b;
    adminstratorlogin()
    {
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
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color c = new Color(199, 245, 255);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;

        JLabel l13 = new JLabel("Username");
        l13.setFont(new Font("SansSerif", Font.BOLD, 20));
        c2.gridx = 0;
        c2.gridy = 0;
        c2.insets = new Insets(20,20,20,20);
        panel.add(l13, c2);

        JTextField tf = new JTextField();
        //tf.setBorder(border);
        tf.setPreferredSize(new Dimension(200,30));
        tf.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(20,20,20,20);
        panel.add(tf, c2);
        
        JLabel l14 = new JLabel("Password");
        l14.setFont(new Font("SansSerif", Font.BOLD, 20));
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(20,20,20,20);
        panel.add(l14, c2);

        JPasswordField tf1 = new JPasswordField();
        tf1.setPreferredSize(new Dimension(200,30));
        tf1.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 1;
        c2.insets = new Insets(20,20,20,20);
        panel.add(tf1, c2);
        
        Button btn = new Button("Sumbit");
        btn.setPreferredSize(new Dimension(150,50));
        btn.setBackground(c);
        btn.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 1;
        c2.gridy = 2;
        c2.insets = new Insets(20,20,20,20);
        panel.add(btn, c2);
        
        Button btn1 = new Button("New User");
        btn1.setBackground(c);
        btn1.setPreferredSize(new Dimension(150,50));
        btn1.setFont(new Font("SansSerif",Font.BOLD,20));  
        c2.gridx = 0;
        c2.gridy = 2;
        c2.insets = new Insets(20,20,20,20);
        panel.add(btn1, c2);

        panel.setOpaque(false);
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Rahul\\OneDrive\\Pictures\\bggg.jpg")));
        f.setLayout(new GridBagLayout());
        f.add(panel);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

              if(tf.getText().equals("") && String.valueOf(tf1.getPassword()).equals(""))
              {
                JOptionPane.showMessageDialog(f,"Please Enter Valid Details");
              }
              else{
                a = tf.getText();
                b = new String(tf1.getPassword());
                
                int flag = 0;
                try{
                    String location = "C:\\Users\\Rahul\\Downloads\\Busdetails.accdb";
                    String databaseURL = "jdbc:ucanaccess://" + location;
                    Connection connection = DriverManager.getConnection(databaseURL);
                    System.out.println("Connection done Successfully");

                    String sql = "SELECT * FROM DBBB";
                     
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);
                     
                    while (result.next()) {
                        if(result.getString(2).equals(a) && result.getString(3).equals(b))
                        {
                            new FrontPage();
                            flag = 1;
                            f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
                            break;
                        }
                    }  
                    if(flag == 0)
                    {
                        JOptionPane.showMessageDialog(f,"Invalid Credentials !","Alert",JOptionPane.INFORMATION_MESSAGE);
                        tf1.setText("");
                        tf.setText("");
                    }
                    
                }
                catch(Exception ee)
                {
                    System.out.println("Exception handelled");
                }
              }
                
            }
        });      

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee)
            {
                new administratorDB();
                f.dispatchEvent(new WindowEvent(f,WindowEvent.WINDOW_CLOSING));
            }
        });

        f.setVisible(true);
        f.setSize(1536,820);
    }
	public static void main(String[] args) {
		new adminstratorlogin();
	}
}