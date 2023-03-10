

import java.util.ArrayList;
import java.util.*;

public class Maze1 {
    public static void main(String[] args) {
        int mazesize = 3;
        // System.out.println(getNoofPathsToReachEnd(3, 3));
        // System.out.println(
        // getActualPathsToReachEndInMaze("", 3, 3));
        // System.out.println(getNoofPathsToReachEndInDRAndDiagonal(3, 3));
        // System.out.println(
        // getActualPathsToReachEndInMazeInDRAndDiagonal("", 3, 3));

        System.out.println(
                getActualPathsToReachEndInMazeInDRAndDiagonalWithZeroIndexing("", 0, 0, mazesize));

    }

    private static List<String> getActualPathsToReachEndInMaze(String path, int r, int c) {
        List<String> paths = new ArrayList<>();
        if (r == 1 && c == 1) {
            paths.add(path);
            return paths;
        }
        if (r > 1) {
            paths.addAll(getActualPathsToReachEndInMaze(path + "D", r - 1, c));
        }

        if (c > 1) {
            paths.addAll(getActualPathsToReachEndInMaze(path + "R", r, c - 1));
        }

        return paths;
    }

    private static int getNoofPathsToReachEnd(int r, int c) {

        if (r == 1 || c == 1) {
            return 1;
        }

        int count = 0;

        count += getNoofPathsToReachEnd(r - 1, c);
        count += getNoofPathsToReachEnd(r, c - 1);
        return count;
    }

    private static int getNoofPathsToReachEndInDRAndDiagonal(int r, int c) {

        if (r == 1 || c == 1) {
            return 1;
        }

        int count = 0;

        count += getNoofPathsToReachEndInDRAndDiagonal(r - 1, c);
        count += getNoofPathsToReachEndInDRAndDiagonal(r, c - 1);
        count += getNoofPathsToReachEndInDRAndDiagonal(r - 1, c - 1);
        return count;
    }

    private static List<String> getActualPathsToReachEndInMazeInDRAndDiagonal(String path, int r, int c) {
        List<String> paths = new ArrayList<>();
        if (r == 1 && c == 1) {
            paths.add(path);
            return paths;
        }
        if (r > 1) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonal(path + "D", r - 1, c));
        }

        if (c > 1) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonal(path + "R", r, c - 1));
        }

        if (c > 1 && r > 1) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonal(path + "C", r - 1, c - 1));
        }

        return paths;
    }

    private static List<String> getActualPathsToReachEndInMazeInDRAndDiagonalWithZeroIndexing(String path, int r, int c,
            int size) {
        List<String> paths = new ArrayList<>();
        if (r == size - 1 && c == size - 1) {
            paths.add(path);
            return paths;
        }
        if (r < size) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonalWithZeroIndexing(path + "D", r + 1, c, size));
        }

        if (c < size) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonalWithZeroIndexing(path + "R", r, c + 1, size));
        }

        if (c < size && r < size) {
            paths.addAll(getActualPathsToReachEndInMazeInDRAndDiagonalWithZeroIndexing(path + "C", r + 1, c + 1, size));
        }

        return paths;
    }
}
