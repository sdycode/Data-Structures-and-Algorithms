

import java.util.Arrays;

public class BackTrack {
    public static void main(String[] args) {
        int mazesize = 3;
        boolean[][] maze = {

                { true, true, true }, { true, true, true }, { true, true, true } };

        // printAllDirPaths("", 0, 0, maze);

        int[][] pathArr = new int[maze.length][maze[0].length];
        printAllDirPathsInMatrix("", 0, 0, maze, pathArr,1 );
    }

    private static void printAllDirPathsInMatrix(String path, int r, int c, boolean[][] maze,int[][] pathArr, int step) {
        int rsize = maze.length - 1;// no of rows
        int csize = maze[0].length - 1; // no of column
        if (r == rsize && c == csize) {
            pathArr[r][c]=step;
            System.out.println(path);
            for (int[] arr :pathArr) {
                System.out.println(Arrays.toString(arr));
                
            }
            System.out.println();
            return;
        }
        if (maze[r][c] == false) {
            return;
        }

        pathArr[r][c]= step;
        maze[r][c] = false;
        if (r < rsize) {

            printAllDirPathsInMatrix(path + "D", r + 1, c, maze,pathArr,step+1);
        }
        if (c < csize) {
            printAllDirPathsInMatrix(path + "R", r, c + 1, maze,pathArr,step+1);
        }
        if (r > 0) {
            printAllDirPathsInMatrix(path + "U", r - 1, c, maze,pathArr,step+1);
        }
        if (c > 0) {
            printAllDirPathsInMatrix(path + "L", r, c - 1, maze,pathArr,step+1);
        }
        pathArr[r][c]= 0;
        maze[r][c] = true;
        return;
    }

    private static void printAllDirPaths(String path, int r, int c, boolean[][] maze) {
        int rsize = maze.length - 1;// no of rows
        int csize = maze[0].length - 1; // no of column
        if (r == rsize && c == csize) {
            System.out.println(path);
            return;
        }
        if (maze[r][c] == false) {
            System.out.println("-------------");
        boolean a =     maze[r][c] ;
            return;
        }
        maze[r][c] = false;
        if (r < rsize) {

            printAllDirPaths(path + "D", r + 1, c, maze);
        }
        if (c < csize) {
            printAllDirPaths(path + "R", r, c + 1, maze);
        }
        if (r > 0) {
            printAllDirPaths(path + "U", r - 1, c, maze);
        }
        if (c > 0) {
            printAllDirPaths(path + "L", r, c - 1, maze);
        }

        maze[r][c] = true;
        return;
    }
}
