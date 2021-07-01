package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class SquareMatrix implements Serializable 
{

	private static final long serialVersionUID = -6371366483772059801L;
	
	// it stores the side length of the matrix.  
	private int side;
	
	// it stores the string which is to be matched in the matrix
	private String match;
	
	// It stores the matching result
	private boolean matchResult;
	
	// it stores the square matrix
	private char[][] squareMatrix;
	
	/**
	 * This method is used to fill the matrix with the Alphabets
	 * @return The matrix filled with the alphabets
	 */
	public char[][] fillSquareMatrix()
	{
		squareMatrix = new char[side][side];
		int minValue = 65;
		
		for(int i = 0; i < squareMatrix.length; i++)
		{
			for(int j = 0; j < squareMatrix.length; j++)
			{
				squareMatrix[i][j] = (char)(Math.random()*25 + minValue);
			}
		}
		
		return squareMatrix;
	}
	
	
	
}
