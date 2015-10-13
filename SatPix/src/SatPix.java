import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		
		//boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		
		System.out.println(fileToBoolArray("bigPicture5.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		//out.println(sizeOfLargestPasture);
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
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		return 0;
	}
	
}