package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchInMatrix implements Serializable
{
	
	private static final long serialVersionUID = 1063171675020721960L;
	
	// it stores the Square matrix of char type
	private char[][] squareMatrix;
	
	// the side length of the square matrix
	private int side;
	
	public SearchInMatrix(char[][] squareMatrix)
	{
		this.squareMatrix = squareMatrix;
		side = squareMatrix.length;
	}
	
	/**
	 * This method search in every possible row in the square matrix
	 * and return true if the provided string found.
	 * @param match The string to be found
	 * @return The true or false based on the search result
	 */
	private boolean rowSearch(String match)
	{
		boolean bool = false;
		
		char[] string = new char[side];
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			for (int j = 0; j < squareMatrix.length; j++) 
			{
				string[j] = squareMatrix[i][j];				
			}
			
			if(match(string, match))
			{
				bool = match(string, match);
				break;
			}
		}
		
		return bool;
	}
	
	/**
	 * This method search in every possible column in the square matrix
	 * and return true if the provided string found.
	 * @param match The string to be found
	 * @return The true or false based on the search result
	 */
	private boolean columnSearch(String match)
	{
		boolean bool = false;
		
		char[] string = new char[side];
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			for (int j = 0; j < squareMatrix.length; j++) 
			{
				string[j] = squareMatrix[j][i];				
			}
			
			if(match(string, match))
			{
				bool = match(string, match);
				break;
			}
		}
		
		return bool;
	}
	
	/**
	 * This method search in two main diagonals in the square matrix
	 * and return true if the provided string found.
	 * @param match The string to be found
	 * @return The true or false based on the search result
	 */
	private boolean diagonalSearch(String match)
	{
		boolean bool = false;
		
		char[] string = new char[side];
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			string[i] = squareMatrix[i][i];
		}
		
		if(match(string, match))
		{
			bool = match(string, match);
			return true;
		}
		
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			
			string[i] = squareMatrix[squareMatrix.length-(i+1)][i];
		}
		
		if(match(string, match))
		{
			bool = match(string, match);
			return true;
		}
		
		return bool;
	}
	
	
	/**
	 * This method search in every possible diagonal of the square matrix
	 * and return true if the provided string found.
	 * @param match The string to be found
	 * @return The true or false based on the search result
	 */
	private boolean advanceDiagonalSearch(String match)
	{
		boolean bool = false;
		char[] temp = new char[squareMatrix.length];
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			for(int j = 0; j < squareMatrix.length; j++)
			{
				if(String.valueOf(squareMatrix[i][j]).equalsIgnoreCase(String.valueOf(match.charAt(0))))
				{
					
					int index = 0;
					int col = j;
					
					for(int row = i; row >=0 ; row--)
					{
						if(col >= squareMatrix.length)
							break;
						
						temp[index] = squareMatrix[row][col];
						index++;
						col++;
					}
					
					if(match(temp, match))
					{
						return true;
					}
					
					index = 0;
					col = j;
					
					for(int row = i; row < squareMatrix.length; row++)
					{
						
						if(col < 0)
							break;
						
						temp[index] = squareMatrix[row][col];
					
						
						index++;
						col--;
					}
					
					if(match(temp, match))
					{
						return true;
					}
					index = 0;
					col = j;
					
					for(int row = i; row >= 0; row--)
					{
						if(col < 0)
							break;
						
						temp[index] = squareMatrix[row][col];	
						index++;
						 col--;
					}
					
					if(match(temp, match))
					{
						return true;
					}
					index = 0;
					col = j;
					
					for(int row = i; row < squareMatrix.length; row++)
					{
						if(col >=  squareMatrix.length)
							break;
						
						temp[index] = squareMatrix[row][col];
						index++;
						 col++;
					}
					
					if(match(temp, match))
					{
						return true;
					}
					
				}
			}
		}
		
		return bool;
	}
	
	
	/**
	 * This method takes a string as parameter and reverse the string,
	 * and return it.
	 * @param String The string to be reversed
	 * @return The reversed String
	 */
	public String reverseString(String string)
	{
		char temp;
		char[] value = string.toCharArray();
		
		
		
		for(int i = 0; i < value.length/2; i++)
		{
			temp = value[i];
			value[i] = value[value.length-(i+1)];
			value[value.length-(i+1)] = temp;
		}
		
		return String.valueOf(value);
	}
	
	private boolean match(char[] arr, String match)
	{
	    String	value = String.valueOf(arr);
		boolean myBool = false;
	    
		match = match.toUpperCase();
		if(value.contains(match)
				|| reverseString(value).contains(match))
		{
			myBool = true;
		}
		
		return myBool;
	}
	
	public boolean search(String match)
	{
		if(rowSearch(match))
			return true;
		else if(columnSearch(match))
			return true;
		else if(advanceDiagonalSearch(match))
			return true;
		else
			return false;
	}
}