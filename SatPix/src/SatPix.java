import java.io.*;
import java.util.Scanner;

public class SatPix {
	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("bigPicture.txt");
		int sizeOfLargestPasture=0;
		for (int x=0; x<booleanArr.length; x++)
		{
			for (int y=0; y<booleanArr[x].length; y++)
			{
				int currentField =recursivelyMeasureAndMarkPasture(x, y, booleanArr);
				if (currentField>sizeOfLargestPasture)
				{
					sizeOfLargestPasture=currentField;
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		System.out.println(sizeOfLargestPasture);
		out.close();
		}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		Scanner scan = new Scanner (new File(fileName));
		int coulum = scan.nextInt();
		int row = scan.nextInt();
		boolean [][] array = new boolean [coulum][row];
		for (int x=0; x<coulum; x++)
		{
			String hello =scan.next();
			for (int y=0; y<row; y++)
			{
				if (hello.substring(y, y+1).equals("*"))
				{
					array[x][y]=true;
				}
				else
				{
					array[x][y]=false;
				}
			}
		}
		return array;
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		if (row >=arr.length||row<0)
		{
			return 0;
			
		}
		else if (col >=arr[row].length||col<0)
		{
			return 0;
		}
		else
		{
			
			if (arr[row][col]==true)
			{
				arr[row][col]=false;
				return 1+recursivelyMeasureAndMarkPasture(row, col++, arr)+recursivelyMeasureAndMarkPasture(row, col--, arr)+recursivelyMeasureAndMarkPasture(row++, col, arr)+recursivelyMeasureAndMarkPasture(row--, col, arr);
			}
			return 0;
		}
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
	}
	
}