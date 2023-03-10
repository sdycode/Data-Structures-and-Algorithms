

import java.util.*;

public class MazeObstacle {
    public static void main(String[] args) {
        int mazesize = 3;
        boolean[][] maze = {

                { true, true, true }, { true, false, true }, { true, true, true } };
        System.out.println(getPathsForSingleObstacle("", 0, 0, mazesize, maze));
    }

    private static List<String> getPathsForSingleObstacle(String path, int r, int c, int size, boolean[][] maze) {
        List<String> paths = new ArrayList<>();

        if (r == size - 1 && c == size - 1) {
            paths.add(path);
            return paths;
        }

        if (maze[r][c]== false) {
            return paths;
        } else {
            if (r < size) {

                paths.addAll(getPathsForSingleObstacle(path + "D", r + 1, c, size, maze));
            }
            if (c < size) {
                paths.addAll(getPathsForSingleObstacle(path + "R", r, c + 1, size, maze));
            }
        }

        return paths;
    }
}
