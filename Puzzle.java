import java.util.*;

public class Puzzle {
    
    public int dimension = 3;
    
    int[] row = { 1, 0, -1, 0 };
    int[] col = { 0, -1, 0, 1 };
    
    public int calculateCost(int[][] initial, int[][] goal) {

        int count = 0;
        int n = initial.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (initial[i][j] != 0 && initial[i][j] != goal[i][j])
                    count++;
            }
        }

        return count;
    }
    
    public void printMatrix(int[][] matrix) {

        matrix = convertOuput(matrix);
        
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }
    
    public boolean isSafe(int x, int y) {

        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    public void printPath(Node root) {

        if (root == null)
            return;

        printPath(root.parent);
        printMatrix(root.matrix);
        System.out.println();
    }

    public boolean isSolvable(int[][] matrix) {

        int count = 0;
        List<Integer> array = new ArrayList<Integer>();
        
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                array.add(matrix[i][j]);
            }
        }
        
        Integer[] anotherArray = new Integer[array.size()];
        array.toArray(anotherArray);
        
        for (int i = 0; i < anotherArray.length - 1; i++) {

            for (int j = i + 1; j < anotherArray.length; j++) {

                if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
                    count++;
                }
            }
        }
        
        return count % 2 == 0;
    }
    
    static int[][] convertInput(int [][]intial){
        int initialnew[][] = new int[3][3];

        initialnew[0][0] = intial[0][0];
        initialnew[0][1] = intial[0][1];
        initialnew[0][2] = intial[0][2];    
        initialnew[2][1] = intial[1][0];
        initialnew[2][2] = intial[1][1];
        initialnew[1][0] = intial[1][2];
        initialnew[2][0] = intial[2][0];
        initialnew[1][2] = intial[2][1];
        initialnew[1][1] = intial[2][2];

        return initialnew;
    }

    static int[][] convertOuput(int [][]intial){
        int initialnew[][] = new int[3][3];

        initialnew[0][0] = intial[0][0];
        initialnew[0][1] = intial[0][1];
        initialnew[0][2] = intial[0][2];    
        initialnew[1][2] = intial[1][0];
        initialnew[2][2] = intial[1][1];
        initialnew[2][1] = intial[1][2];
        initialnew[2][0] = intial[2][0];
        initialnew[1][0] = intial[2][1];
        initialnew[1][1] = intial[2][2];

        return initialnew;
    }
    
    public void solve(int[][] initial, int[][] goal, int x, int y) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>(1000, (a, b) -> (a.cost + a.level) - (b.cost + b.level));
        Node root = new Node(initial, x, y, x, y, 0, null);
        root.cost = calculateCost(initial, goal);
        pq.add(root);
        
        while (!pq.isEmpty()) {

            Node min = pq.poll();

            if (min.cost == 0) {

                printPath(min);
                return;
            }
            
            for (int i = 0; i < 4; i++) {

                if (isSafe(min.x + row[i], min.y + col[i])) {

                    Node child = new Node(min.matrix, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1, min);
                    child.cost = calculateCost(child.matrix, goal);
                    pq.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {

    //  int[][] initial = { {1, 8, 2}, {0, 4, 3}, {7, 6, 5} };
    //  int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        int[][] initial = { {2, 8, 3}, {1, 6, 4}, {7, 0, 5} };
        int[][] goal    = { {1, 2, 3}, {8, 0, 4}, {7, 6, 5} };
        
        initial = convertInput(initial);
        goal = convertInput(goal);

        int x = 1, y = 0;
        
        Puzzle puzzle = new Puzzle();

        if (puzzle.isSolvable(initial)) {

            puzzle.solve(initial, goal, x, y);
        } 

        else
            System.out.println("The given initial is impossible to solve");
    }
}
