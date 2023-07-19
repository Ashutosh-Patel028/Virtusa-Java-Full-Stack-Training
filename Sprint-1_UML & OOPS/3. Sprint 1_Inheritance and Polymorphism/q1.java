import java.util.Scanner;
//Rotate Matrix Elements both Clockwise and AntiClockwise
//finally solved this question

class Clock{
    int[][] rotate(int mat[][],int rotate){
        return mat;
    }
}

class Clockwise extends Clock{
    int[][] rotate(int mat[][],int rotate){
        int row = 0, col = 0;
		int prev, curr;
        int m=mat.length,n=mat[0].length;
        int res[][]=new int[m][n];
        if(m%2!=0){ //odd no. of rows & columns
            res[m/2][n/2]=mat[m/2][n/2];
        }
        while (row < m && col < n)
        {
      
            if (row + 1 == m || col + 1 == n)
                break;
            prev = mat[row + 1][col];
            for (int i = col; i < n; i++)
            {
                curr = mat[row][i];
                res[row][i] = prev;
                prev = curr;
            }
            row++;
            for (int i = row; i < m; i++)
            {
                curr = mat[i][n-1];
                res[i][n-1] = prev;
                prev = curr;
            }
            n--;
            if (row < m)
            {
                for (int i = n-1; i >= col; i--)
                {
                    curr = mat[m-1][i];
                    res[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;
            if (col < n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    res[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
        rotate--;
        if(rotate>0){
            return rotate(res,rotate);
        }else{
            return res;
        }
    }
}

class AntiClockwise extends Clock{
    int[][] rotate(int mat[][],int rotate){
        int row = 0, col = 0;
		int prev, curr;
        int m=mat.length,n=mat[0].length;
        int res[][]=new int[m][n];
        if(m%2!=0){ //odd no. of rows & columns
            res[m/2][n/2]=mat[m/2][n/2];
        }
        while (row < m && col < n)
		{
	
			if (row + 1 == m || col + 1 == n)
				break;
			prev = mat[row][col+1];
			for (int i = row; i < m; i++)
			{
				curr = mat[i][col];
				res[i][col] = prev;
				prev = curr;
			}
			col++;
			for (int i = col; i < n; i++)
			{
				curr = mat[m-1][i];
				res[m-1][i] = prev;
				prev = curr;
			}
			m--;
			if (col < n)
			{
				for (int i = m-1; i >= row; i--)
				{
					curr = mat[i][n-1];
					res[i][n-1] = prev;
					prev = curr;
				}
			}
			n--;
			if (row < m)
			{
				for (int i = n-1; i >= col; i--)
				{
					curr = mat[row][i];
					res[row][i] = prev;
					prev = curr;
				}
			}
			row++;
        }
        rotate--;
        if(rotate>0){
            return rotate(res,rotate);
        }else{
            return res;
        }
    }
}

class Main{
    public static void main(String[] args) {
        int row,column;
        Scanner sc=new Scanner(System.in);
        row=sc.nextInt();
        column=sc.nextInt();
        int matrix[][]=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int rotate = sc.nextInt();

        Clockwise cw=new Clockwise();
        int res1[][] = cw.rotate(matrix, rotate);
        System.out.println("Clockwise ");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(res1[i][j] +" ");
            }
            System.out.println();
        }

        AntiClockwise acw = new AntiClockwise();
        int res2[][]=acw.rotate(matrix, rotate);
        System.out.println("AntiClockwise ");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(res2[i][j] +" ");
            }
            System.out.println();
        }
        sc.close();
    }
}