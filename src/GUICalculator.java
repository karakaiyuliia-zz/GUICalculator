/**
 * Program Name:	GUICalculator.java
 * Purpose:			A GUI class which instantiates a Calculator object and performs calculator operations on that object 
 * Coder:			Yuliia Karakai, 0778693
 * Date:				Apr 3, 2017
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class GUICalculator extends JFrame
{
	//declare Calculator object
	Calculator calc = new Calculator();
	
	//Class wide scope area
	JButton addBtn, substractBtn, multiplyBtn, divideBtn, backBtn, clearBtn, percentBtn, rootBtn, squareBtn, dotBtn, plsmnsBtn, btn0, btn1, btn2,
	btn3, btn4, btn5, btn6, btn7, btn8, btn9, empty1, empty2, equalBtn;
	JTextField valueFld;
	
	//JMenu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu convert = new JMenu("Convert");
	private JMenu help = new JMenu("Help");
	
	//Menu Items
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem hex = new JMenuItem("Hex");
	private JMenuItem dec = new JMenuItem("Dec");
	private JMenuItem oct = new JMenuItem("Oct");
	private JMenuItem bin = new JMenuItem("Bin");
	private JMenuItem howTo = new JMenuItem("How To Use");
	private JMenuItem about = new JMenuItem("About");
	
	
	//constructors 
	public GUICalculator()
	{
		super("Calculator");
		
		calc = new Calculator();
		
		//boilerplate
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(6, 4));
		this.setSize(300, 365);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//JPanel subcontainers
		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		this.add(rootPanel);
		
		//do the text field 
		valueFld = new JTextField();
		Border original = valueFld.getBorder();
		Border empty = BorderFactory.createLineBorder(this.getBackground(), 10);
		valueFld.setBorder(new CompoundBorder(empty, original));
		topPanel.add(valueFld);
		valueFld.setFont(new Font("SansSerif", Font.PLAIN, 22));
		valueFld.setText("0.0");
		valueFld.setHorizontalAlignment(valueFld.RIGHT);
		valueFld.setEditable(false);
		valueFld.setBackground(Color.WHITE);
		
		
		rootPanel.add(valueFld, BorderLayout.NORTH);
		
		//do the button
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(6,4, 10, 10));
		this.getLayeredPane().add(btnPanel);
		
		rootPanel.add(btnPanel);
		
		//add the buttons 
		clearBtn = new JButton("C");
		backBtn = new JButton("←");
		percentBtn = new JButton("%");
		plsmnsBtn= new JButton("+/-");
		squareBtn= new JButton("X²");
		rootBtn= new JButton("√");
		empty1= new JButton("");
		divideBtn = new JButton("/");
		btn7= new JButton("7");
		btn8= new JButton("8");
		btn9= new JButton("9");
		multiplyBtn = new JButton("x");
		btn4= new JButton("4");
		btn5= new JButton("5");
		btn6= new JButton("6");
		substractBtn = new JButton("-");
		btn1= new JButton("1");
		btn2= new JButton("2");
		btn3= new JButton("3");
		addBtn = new JButton("+");
		empty2= new JButton("");
		btn0 = new JButton("0");
		dotBtn= new JButton(".");
		equalBtn = new JButton("=");

		
		//add to their container 
		btnPanel.add(clearBtn);
		btnPanel.add(backBtn);
		btnPanel.add(percentBtn);
		btnPanel.add(plsmnsBtn);
		btnPanel.add(squareBtn);
		btnPanel.add(rootBtn);
		btnPanel.add(empty1);
		btnPanel.add(divideBtn);
		btnPanel.add(btn7);
		btnPanel.add(btn8);
		btnPanel.add(btn9);
		btnPanel.add(multiplyBtn);
		btnPanel.add(btn4);
		btnPanel.add(btn5);
		btnPanel.add(btn6);
		btnPanel.add(substractBtn);
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		btnPanel.add(addBtn);
		btnPanel.add(empty2);
		btnPanel.add(btn0);
		btnPanel.add(dotBtn);
		btnPanel.add(equalBtn);
		
		//change the buttons font and color
		Font font = new Font("Serif", Font.PLAIN, 22);
		for (Component comp : btnPanel.getComponents()) 
		{
		    if (comp instanceof JButton) 
		    {
		        ((JButton)comp).setFont(font);
		    }
		}
		
		for (Component comp : btnPanel.getComponents()) 
		{
		    if (comp instanceof JButton) 
		    {
		        ((JButton)comp).setBackground(Color.WHITE);
		        ((JButton)comp).setOpaque(true);
		    }
		}
		
		//add menus 
		menuBar.add(file);
		menuBar.add(convert);
		menuBar.add(help);
		
		//add menu items 
		file.add(exit);
		convert.add(hex);
		convert.add(dec);
		convert.add(oct);
		convert.add(bin);
		help.add(howTo);
		help.add(about);
		
		this.setJMenuBar(menuBar);
		
		//register a listener 
		ButtonListener listener = new ButtonListener();
		exit.addActionListener(listener);
		hex.addActionListener(listener);
		oct.addActionListener(listener);
		bin.addActionListener(listener);
		howTo.addActionListener(listener);
		about.addActionListener(listener);
		about.addActionListener(listener);
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
		btn5.addActionListener(listener);
		btn6.addActionListener(listener);
		btn7.addActionListener(listener);
		btn8.addActionListener(listener);
		btn9.addActionListener(listener);
		btn0.addActionListener(listener);
		backBtn.addActionListener(listener);
		plsmnsBtn.addActionListener(listener);
		addBtn.addActionListener(listener);
		substractBtn.addActionListener(listener);
		multiplyBtn.addActionListener(listener);
		divideBtn.addActionListener(listener);
		percentBtn.addActionListener(listener);
		rootBtn.addActionListener(listener);
		squareBtn.addActionListener(listener);
		dotBtn.addActionListener(listener);
		equalBtn.addActionListener(listener);
		clearBtn.addActionListener(listener);
		valueFld.addActionListener(listener);
		
		
		this.setVisible(true);
	}
	
	/**
	* Class Name:	ButtonListener
	* Purpose:	assign  action to all components
	* Implements:	ActionListener		
	*/ 
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ev)
		{
			try{
				
			
			if(ev.getActionCommand().equals("Exit"))
			{
					System.exit(0);
			}
			else if(ev.getActionCommand().equals("How To Use"))
			{
					JOptionPane.showMessageDialog(null, "Press the button with appropriate number, choose what you would like to do - multiply, divide, "
							+ "substract or add and then hit the \"=\" button.\nIf you want to find percentage, square root or square, just enter the number and"
							+ " press the corresponding button.");
			}
			else if(ev.getActionCommand().equals("About"))
			{
				JOptionPane.showMessageDialog(null, "This is Yuliia's calculator app.\nFor instructions hit \"How To Use\" button.");
			}
		   else if(ev.getActionCommand().equals("Hex"))
		   {
			
				String value = valueFld.getText();
				value = calc.convertHex(calc.getOperand());
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("Oct"))
			{
				String value = valueFld.getText();
				value = calc.convertOct(calc.getOperand());
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("Bin"))
			{
				String value = valueFld.getText();
				value = calc.convertBin(calc.getOperand());
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("1"))
			{
				String value = "1";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("2"))
			{
				String value = "2";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("3"))
			{
				String value = "3";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("4"))
			{
				String value = "4";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("5"))
			{
				String value = "5";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("6"))
			{
				String value = "6";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("7"))
			{
				String value = "7";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("8"))
			{
				String value = "8";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("9"))
			{
				String value = "9";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("0"))
			{
				String value = "0";
				calc.buildOperand(value);
				value = calc.getOperand();
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("="))
			{
				double result = 0.0;
				result = calc.calculate();
				valueFld.setText(Double.toString(result));
			}
			else if(ev.getActionCommand().equals("+"))
			{
				calc.buildExpression("Add");
			}
			else if(ev.getActionCommand().equals("-"))
			{
				calc.buildExpression("Sub");
			}
			else if(ev.getActionCommand().equals("x"))
			{
				calc.buildExpression("Mul");
			}
			else if(ev.getActionCommand().equals("/"))
			{
				calc.buildExpression("Div");
			}
			else if(ev.getActionCommand().equals("X²"))
			{
				String value = valueFld.getText();
				double result = Double.parseDouble(value);
				result = result * result;
				value = Double.toString(result);
				calc.setOperand(value);
				valueFld.setText(value);
				
			}
			else if(ev.getActionCommand().equals("√"))
			{
				String value = valueFld.getText();
				double result = Double.parseDouble(value);
				result = Math.sqrt(result);
				value = Double.toString(result);
				calc.setOperand(value);
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("←"))
			{
				String value = valueFld.getText();
				value = calc.backspace(value);
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("%"))
			{
				String value = valueFld.getText();
				value = calc.findPercentage(value);
				valueFld.setText(value);
			}
			else if(ev.getActionCommand().equals("+/-"))
			{
				String value = valueFld.getText();
				double result = Double.parseDouble(value);
				result*=-1;
				value = Double.toString(result);
				valueFld.setText(value);
				calc.setOperand(value);
			}
		  else if(ev.getActionCommand().equals("."))
			{
			  String value = valueFld.getText();
			  if(!calc.isDecimalPressed())
			  {
				  calc.setDecimalPressed(true);
				  calc.buildOperand(".");
				  valueFld.setText(value + ".");
			  }
			
			}
		  else if(ev.getActionCommand().equals("C"))
		  {
			  calc.clear();
			  valueFld.setText("");
		  }
		}
			catch(LongOperandException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
			catch(EmptyOperandException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.getMessage();
				e.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args)
	{
			new GUICalculator();
	}	//End of main method
} //End of class