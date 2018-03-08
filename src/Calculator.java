import java.util.ArrayList;

/**
 * Program Name:	Calculator.java
 * Purpose:			a class to be used to create a calculator object
 * Coder:			Yuliia Karakai, 0778693
 * Date:				Apr 1, 2017
 */

public class Calculator
{
	//data members 
	private String operand;
	private String operator;
	private boolean decimalPressed;
	private ArrayList<String> list;
	
	//constructor 
	public Calculator(){
		this.operand = ""; 
		this.operator = "";
		this.decimalPressed = false;
		this.list = new ArrayList<>();
	}

	//getters and setters
	public String getOperand()
	{
		return operand;
	}

	public void setOperand(String operand)
	{
		this.operand = operand;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public boolean isDecimalPressed()
	{
		return decimalPressed;
	}

	public void setDecimalPressed(boolean decimalPressed)
	{
		this.decimalPressed = decimalPressed;
	}
	
	/**
	* Method Name:	clear()
	* Purpose:	clear the fields
	* Parameters:		
	* Returns: 		
	*/ 
	public void clear()
	{
		
		this.operand = ""; 
		this.operator = "";
		this.decimalPressed = false;				
	}
	
	/**
	* Method Name:	backspace
	* Purpose:	delete one substring 
	* Parameters:	String value
	* Returns: 	String
	*/ 
	public String backspace(String value) throws EmptyOperandException
	{
		if(operand.equals(""))
		{
			throw new EmptyOperandException();
		}
		value = value.substring(0,value.length()-1);
		return value;
	}
	
	/**
	* Method Name:	findPercentage
	* Purpose:	find percentage 
	* Parameters:	String value
	* Returns: 		String
	*/ 
	public String findPercentage(String value) throws EmptyOperandException
	{
		if(operand.equals(""))
		{
			throw new EmptyOperandException();
		}
		double percent = Double.parseDouble(value);
		return "" + percent/100;
	}
	
	/**
	* Method Name:	togglePlusMinus
	* Purpose:	determine if the value is negative or not
	* Parameters:		boolean flag
	* Returns: 		String
	*/ 
	public String togglePlusMinus(boolean flag) throws EmptyOperandException
	{
		if(flag)
		{
			operand = "-" + operand;
			return operand;
		}
		else
		{
			return operand.substring(1);
		}
	}
	
	/**
	* Method Name:	findSquared
	* Purpose:	find square if the value
	* Parameters:	String value
	* Returns: 		String
	*/ 
	public String findSquared(String value) throws EmptyOperandException
	{
		if(value.equals(""))
		{
			throw new EmptyOperandException();
		}
		double square = Double.parseDouble(value);
		return "" + square*square;
	}
	
	/**
	* Method Name:	findSquareRoot
	* Purpose:	find square root
	* Parameters:	String value	
	* Returns: 	String 	
	*/ 
	public String findSquareRoot(String value) throws EmptyOperandException
	{
		if(value.equals(""))
		{
			throw new EmptyOperandException();
		}
		double root = Double.parseDouble(value);
		root = Math.sqrt(root);
		return "" + root;
	}
	
	/**
	* Method Name:	buildOperand
	* Purpose:	make an operand
	* Parameters:	String value	
	* Returns: 		
	*/ 
	public void buildOperand(String value) throws LongOperandException
	{
		if(operand.length() >= 16)
		{
			throw new LongOperandException();
		}
		operand+=value;
	}
	
	/**
	* Method Name:	buildExpression
	* Purpose:	build expression, add operand and operator to the list
	* Parameters:	String value
	* Returns: 		
	*/ 
	public void buildExpression(String value) throws EmptyOperandException, ArithmeticException
	{
		if(operand.equals(""))
		{
			throw new EmptyOperandException();
		}
		operator = value;
		list.add(operand);
		list.add(operator);
		
		//clear fields
		clear();
	}
	
	/**
	* Method Name:	calculate
	* Purpose:	calculate the result with BEDMAS rule
	* Parameters:		
	* Returns: 	double 
	*/ 
	public double calculate() throws EmptyOperandException
	{
		double result = 0.0;
		String[] bedmas = {"Expo", "Root", "Div", "Mul", "Add", "Sub"};
		list.add(operand);
		//calculate 
		do
		{
			for(int i = 1; i < list.size(); i+=2)
			{		
				if(list.get(i) == "Div")
				{
					double o1 = Double.parseDouble(list.get(i-1));
					double o2 = Double.parseDouble(list.get(i+1));
						if(list.size() < 3)
						{
							throw new EmptyOperandException();
						}
						//div calc
						result = o1/o2;
						
						//put result back in list
						list.remove(i-1);
						list.remove(i-1);
						list.remove(i-1);
						String result1 = Double.toString(result);
						list.add(i-1, result1);
					}
				else if(list.get(i) == "Mul")
				{
					double o1 = Double.parseDouble(list.get(i-1));
					double o2 = Double.parseDouble(list.get(i+1));
					if(list.size() < 3)
					{
							throw new EmptyOperandException();
					}
					//mul calc
					result = o1*o2;
					
					//put result back in list
					list.remove(i-1);
					list.remove(i-1);
					list.remove(i-1);
					String result1 = Double.toString(result);
					list.add(i-1, result1);
					
				}
			}
	
			for(int i = 1; i < list.size(); i+=2)
			{				
				 if(list.get(i) == "Add")
				 {
					 double o1 = Double.parseDouble(list.get(i-1));
					 double o2 = Double.parseDouble(list.get(i+1));
						if(list.size() < 3)
						{
							throw new EmptyOperandException();
						}
						//add calc
						result = o1+o2;
						
						//put result back in list
						list.remove(i-1);
						list.remove(i-1);
						list.remove(i-1);
						String result1 = Double.toString(result);
						list.add(i-1, result1);
				
			      }
					else if(list.get(i) == "Sub")
					{
						double o1 = Double.parseDouble(list.get(i-1));
						double o2 = Double.parseDouble(list.get(i+1));
						if(list.size() < 3)
						{
							throw new EmptyOperandException();
						}
						//sub calc
						result = o1-o2;
						
						//put result back in list
						list.remove(i-1);
						list.remove(i-1);
						list.remove(i-1);
						String result1 = Double.toString(result);
						list.add(i-1, result1);
				}
		  }
			
  }while(list.size() > 1);
		clear();
		list.clear();
		return result;
	}
	
	/**
	* Method Name:	convertHex
	* Purpose:	convert decimal to hexadecimal
	* Parameters:	String value	
	* Returns: 	String	
	*/ 
	public String convertHex(String value) throws EmptyOperandException
	{
		if(operand.equals(""))
		{
			throw new EmptyOperandException();
		}
		try
		{
			double res = Double.parseDouble(value);
			res += 0.5;
			int toHexValue = (int)res;
			int base = 16; 
			String digits = "0123456789ABCDEF";
		    if (toHexValue <= 0.0) 
		    {
		   	 return "0";
		    }
		    String hex = "";
		    while (toHexValue > 0) {
		        int digit = toHexValue % base;  
		        hex = digits.charAt(digit) + hex; 
		        toHexValue = toHexValue / base;
		    }
		    return "" + hex;
		}
		catch(Exception e)
		{
			
		}
		return value;

	}
	
	/**
	* Method Name:	convertOct
	* Purpose:	convert decimal to octal
	* Parameters:	String value	
	* Returns: 	String 	
	*/ 
	public String convertOct(String value) throws EmptyOperandException
	{
		double res = Double.parseDouble(value);
		res += 0.5;
		int toOctValue = (int)res;
		int count=0;
	   int result = 0;
	   while(toOctValue !=0) 
	   {
	        int temp = (int) ((toOctValue%8) * Math.pow(10, count));
	        count++;
	        result += temp;
	        toOctValue /= 8;
	    }
	    return "" + result;
	}
	
	/**
	* Method Name:	convertBin
	* Purpose:	convert decimal to binary
	* Parameters:	String value	
	* Returns: 	String	
	*/ 
	public String convertBin(String value) throws EmptyOperandException
	{
		double res = Double.parseDouble(value);
		res += 0.5;
		int toBinValue = (int)res;
		String result = "";
		while(toBinValue > 0){


	        int mod = toBinValue % 2;
	        result = mod+ result;

	        toBinValue /= 2;
	    }
		return result;
	}

	/**
	* Method Name:	toString
	* Purpose:	returns a String representation of the Calculator object
	* Parameters:		
	* Returns: 	String	
	*/ 
	public String toString() 
	{
	    return this.operand + this.operator;
   }
	
}
//End of class