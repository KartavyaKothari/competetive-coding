class PuzzleConversion{
    static convertInput(int [][]intial, int [][]goal){
        int initialnew[][] = new int[3][3];
        int goalNew[][] = new int[3][3];

        initialnew[0][0] = intial[0][0];
        initialnew[0][1] = intial[0][1];
        initialnew[0][2] = intial[0][2];    
        initialnew[1][0] = intial[1][2];
        initialnew[1][1] = intial[2][2];
        initialnew[1][2] = intial[2][1];
        initialnew[2][0] = intial[2][0];
        initialnew[2][1] = intial[1][0];
        initialnew[2][2] = intial[1][1];

        goalNew[0][0] = goal[0][0];
        goalNew[0][1] = goal[0][1];
        goalNew[0][2] = goal[0][2];    
        goalNew[1][0] = goal[1][2];
        goalNew[1][1] = goal[2][2];
        goalNew[1][2] = goal[2][1];
        goalNew[2][0] = goal[2][0];
        goalNew[2][1] = goal[1][0];
        goalNew[2][2] = goal[1][1];

        intial = initialnew;
        goal = goalNew;
    }

    static convertOuput(int [][]intial, int [][]goal){
        int initialnew[][] = new int[3][3];
        int goalNew[][] = new int[3][3];

        initialnew[0][0] = intial[0][0];
        initialnew[0][1] = intial[0][1];
        initialnew[0][2] = intial[0][2];    
        initialnew[1][2] = intial[1][0];
        initialnew[2][2] = intial[1][1];
        initialnew[2][1] = intial[1][2];
        initialnew[2][0] = intial[2][0];
        initialnew[1][0] = intial[2][1];
        initialnew[1][1] = intial[2][2];

        goalNew[0][0] = goal[0][0];
        goalNew[0][1] = goal[0][1];
        goalNew[0][2] = goal[0][2];    
        goalNew[1][2] = goal[1][0];
        goalNew[2][2] = goal[1][1];
        goalNew[2][1] = goal[1][2];
        goalNew[2][0] = goal[2][0];
        goalNew[1][0] = goal[2][1];
        goalNew[1][1] = goal[2][2];

        intial = initialnew;
        goal = goalNew;
    }
}