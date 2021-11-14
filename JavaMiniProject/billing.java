import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class billing implements ActionListener {

	HashMap<String,Integer> productPrice=new HashMap<String,Integer>(); 
	HashMap<String,Integer> productQuantity = new HashMap<String,Integer>();
	JButton[] buttons;
	JButton[] buttons2;
	DefaultTableModel model;
	Object data[][];
	JButton calculate;
	JLabel price;
	JButton payment;
	JFrame f;
	String fromV,toV,dateV,timeV,priceV,tablename,type;
	String[] value = new String[8];
	int k;
	//billing()
	billing(String fromV,String toV,String dateV,String timeV,String priceV,String tablename,String[] value,String type)
	{
		this.fromV = fromV;
		this.toV = toV;
		this.dateV = dateV;
		this.timeV = timeV;
		this.priceV = priceV;
		this.tablename = tablename;
		this.type = type;
		for(int i = 0 ; i<8 ; i++)
			this.value[i] = value[i];
		//Color c5 = new Color(199, 245, 255);
		Color c4 = new Color(214, 255, 254);
		Color c = new Color(60, 143, 63);
		Color c2 = new Color(244, 67, 54);
		Color c1 = new Color(255,255,255);
		//Color c3 = new Color(121, 162, 232);
		Font  font1  = new Font(Font.SANS_SERIF, Font.BOLD,25);
		Font  font2  = new Font(Font.SANS_SERIF, Font.PLAIN,20);
		
		f = new JFrame("                                                                                                                                                                                                                       TRAVEL YOUR WAY !                                                                                                                                                                                                        ");
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
		f.getContentPane().setBackground(c4);
		
		productPrice.put("Lays",10);
		productPrice.put("Kurkure",10);
		productPrice.put("Hide and Seek",30);
		productPrice.put("Purified Water",20);
		productPrice.put("Coca Cola 500ml",70);
		productPrice.put("Mirinda 500ml",40);
		productPrice.put("Pepsi 500ml",40);
		productPrice.put("7up 500ml",35);
		productPrice.put("Jim Jam",30);
		productPrice.put("Black bourbon",25);
		
		
		productPrice = sortByValue(productPrice);  
		
		for(Map.Entry<String, Integer> iter : productPrice.entrySet())
		{
			productQuantity.put(iter.getKey(), 0);
		}
		
		JPanel buttonPanel = new JPanel();

		buttons = new JButton[10];
		int i = 0;
		for(String key : productPrice.keySet())
		{
			buttons[i] = new JButton(key);
			buttons[i].setBackground(c);
			buttons[i].setForeground(c1);
			buttons[i].setFont(font1);
			buttonPanel.add(buttons[i]);
			i++;
		}
		buttonPanel.setLayout(new GridLayout(5,2,20,30));
		
		String[] columnNames = {"Product","Price","Quantity"};
		data = new Object[10][3];
		JTable table = new JTable(data,columnNames);
		model = new DefaultTableModel();
		table.setModel(model);
		table.setRowHeight(46);
		table.getTableHeader().setFont(font1);
		table.setFont(font2);
        table.getTableHeader().setBackground(new Color(85, 85, 85));
        table.getTableHeader().setForeground(c1);
		model.setColumnIdentifiers(columnNames);
		model.setRowCount(10);
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(500,500));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );

		JPanel buttonPanel2 = new JPanel();
		buttons2 = new JButton[10];
		int i2 = 0;
		for(String key : productPrice.keySet())
		{
			buttons2[i2] = new JButton(key);
			buttons2[i2].setBackground(c2);
			buttons2[i2].setForeground(c1);
			buttons2[i2].setFont(font1);
			buttonPanel2.add(buttons2[i2]);
			i2++;
		}
		buttonPanel2.setLayout(new GridLayout(5,2,20,30));
		
		for(i = 0 ; i<10 ; i++)
		{
			buttons[i].addActionListener(this);
			buttons2[i].addActionListener(this);
		}
		f.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(-50,0,50,20);
		f.add(buttonPanel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(-50,0,0,0);
		f.add(sp,gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.insets = new Insets(-50,20,50,0);
		f.add(buttonPanel2,gc);
		
		JPanel p1 = new JPanel();
		calculate = new JButton("Price Calculate");
		calculate.addActionListener(this);
		calculate.setFont(font1);
		calculate.setBackground(c2);
		calculate.setForeground(c1);
		calculate.addActionListener(this);
		p1.add(calculate);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(100,0,0,10);
		f.add(p1,gc);
		
		JPanel p2 = new JPanel();
		JLabel totalprice = new JLabel("Total Price:");
		totalprice.setFont(font1);
		totalprice.setForeground(new Color(85, 85, 85));
		p2.setPreferredSize(new Dimension(500,50));
		p2.add(totalprice);
		price = new JLabel("0");
		price.setForeground(new Color(85, 85, 85));
		price.setFont(font1);
		p2.add(price);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(100,10,0,0);
		f.add(p2,gc);
		
		JPanel p3 = new JPanel();
		payment= new JButton("Proceed to pay");
		payment.setBackground(c);
		payment.setForeground(c1);
		payment.setFont(font1);
		payment.addActionListener(this);
		p3.add(payment);
		gc.gridx = 2;
		gc.gridy = 1;
		gc.insets = new Insets(100,20,0,0);
		f.add(p3,gc);

		p1.setBackground(c4);
		p2.setBackground(c4);
		p3.setBackground(c4);
		sp.setBackground(c4);
		buttonPanel.setBackground(c4);
		buttonPanel2.setBackground(c4);
		f.setSize(1536,820);
		f.setVisible(true);
		
	}
	public static String findKey(HashMap<String,Integer> hp,int index)
	{
		int i = 0;
		for(Map.Entry<String, Integer> f : hp.entrySet())
		{
			if(i==index)
			{
				return f.getKey();
			}
			i++;
		}
		return null;
	}
	public static int findValue(HashMap<String,Integer> hp,int index)
	{
		int i = 0;
		for(Map.Entry<String, Integer> f : hp.entrySet())
		{
			if(i==index)
			{
				return f.getValue();
			}
			i++;
		}
		return -1;
	}
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        LinkedList<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == calculate)
		{
			int cost = 0;
			for(int i = 0 ; i<10 ; i++)
			{
				if(data[i][1] != null && data[i][1]!="")
				{
					cost += ((int)data[i][1]) * ((int)data[i][2]);
				}
			}
			price.setText(String.valueOf(cost));
		}
		else if(e.getSource() == payment )
		{
			 int a=JOptionPane.showConfirmDialog(f,"Are you sure?");  
			 if(a==JOptionPane.YES_OPTION)
			 {  
				 calculate.doClick();
				 priceV =String.valueOf( Float.parseFloat(priceV) + Float.parseFloat(price.getText()));
				 System.out.println(priceV+" total price");
				 Object[][] snack = new Object[k][3];
				 System.out.println(k);
				 for(int x = 0 ; x<k ; x++)	
					 snack[x] = data[x];
				 for(int x = 0 ; x<k ; x++)
				 {
					 System.out.println(String.valueOf(snack[x][0]));
					 System.out.println(String.valueOf(snack[x][1]));
					 System.out.println(String.valueOf(snack[x][2]));
				 }
				 f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
				 new Paymentpage(fromV,toV,dateV,timeV,priceV,tablename,value,snack,k,type);
			 }
		}
		else
		{
			for(int i = 0 ; i<10 ; i++)
			{
				if(e.getSource() == buttons[i])
				{
					String key = findKey(productPrice,i);
					
					productQuantity.put(key,(productQuantity.get(key)+1));
					
					data = new Object[10][3];
					k = 0;
					for(Map.Entry<String, Integer> p : productPrice.entrySet())
					{
						if(productQuantity.get(p.getKey())!=0)
						{
							data[k][0] = p.getKey();
							data[k][1] = p.getValue();
							data[k][2] = productQuantity.get(p.getKey());
							k++;
						}
					}
					model.setRowCount(0);
					for(int j = 0 ; j<10 ;j++)
						model.addRow(data[j]);
					
				}
				else if(e.getSource() == buttons2[i])
				{
					String key = findKey(productPrice,i);
					if(productQuantity.get(key)>1)
					{
						model.setRowCount(0);
						productQuantity.put(key,(productQuantity.get(key)-1));
						k = 0;
						data = new Object[10][3];
						for(Map.Entry<String, Integer> p : productPrice.entrySet())
						{
							if(productQuantity.get(p.getKey())!=0)
							{
								data[k][0] = p.getKey();
								data[k][1] = p.getValue();
								data[k][2] = productQuantity.get(p.getKey());
								k++;
							}
						}
						
						for(int j = 0 ; j<10 ;j++)
							model.addRow(data[j]);
					}
					else if(productQuantity.get(key)==1)
					{
						model.setRowCount(0);
						productQuantity.put(key,0);
						k = 0;
						data = new Object[10][3];
						for(Map.Entry<String, Integer> p : productPrice.entrySet())
						{
							if(productQuantity.get(p.getKey())!=0)
							{
								data[k][0] = p.getKey();
								data[k][1] = p.getValue();
								data[k][2] = productQuantity.get(p.getKey());
								k++;
							}
						}
						
						for(int j = 0 ; j<10 ;j++)
							model.addRow(data[j]);
					}
				}
			}
			calculate.doClick();
		}
	}
	public static void main(String args[])
	{
		String[] st = {};
		new billing("","","","","","",st,"");
		//new billing();
	}
}