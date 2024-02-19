package grind169.week1;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    /*
     *  Problem: https://leetcode.com/problems/flood-fill/description/
     *  Impressive Solution:
     *    https://leetcode.com/problems/flood-fill/solutions/473494/java-dfs-bfs-solutions-space-complexity-analysis-clean-concise/
     *
     *  Test Cases:
     *      See the problem link
     */

    class DfsSolution {
        // Time Complexity : O(n*m), Space Complexity : O(n*m)
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) return image;
            floodFill(image, sr, sc, image[sr][sc], color);
            return image;
        }

        public void floodFill(int[][] image, int sr, int sc, int srcColor, int color) {
            if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) return;
            if (image[sr][sc] == srcColor) {
                image[sr][sc] = color;
                floodFill(image, sr-1, sc, srcColor, color);
                floodFill(image, sr+1, sc, srcColor, color);
                floodFill(image, sr, sc-1, srcColor, color);
                floodFill(image, sr, sc+1, srcColor, color);
            }
        }
    }

    class BfsSolution {
        // Time Complexity : O(n*m), Space Complexity : O(n*m)
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) return image;
            int srcColor = image[sr][sc];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
                    continue;
                if (image[row][col] == srcColor) {
                    image[row][col] = color;
                    queue.offer(new int[]{row+1, col});
                    queue.offer(new int[]{row-1, col});
                    queue.offer(new int[]{row, col+1});
                    queue.offer(new int[]{row, col-1});
                }
            }
            return image;
        }
    }
}

