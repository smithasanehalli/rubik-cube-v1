package com.rubi;

public class TestCubeApp {

    public static void main(String[] args) {
        // TODO
        //1.Construct and initialize the rubix cube with correct faces;
        //2.Scramble the cube
        //3.get current state and Store the pattern of 6 faces
        //4.Get the possible moves to correct the cubes position from database which has all the possible combination of faces
        //and moves required to solve that state.


        //6 faces and 6 colors
        Face[] faces = new Face[6];

        //each faces has 9 small squares or stickers, considering face0 is white face or UP side
        //represent these 9 stickers in 3*3 matrix of int each value represents color of that square
        //W = 0,
        int[][] face0_stickers = new int[3][3];
        /*
            0 1 2
          0 W W W
          1 W w W
          2 W W W
         */
        //top row
        face0_stickers[0][0] = COLOR.WHITE.ordinal();
        face0_stickers[0][1] = COLOR.WHITE.ordinal();
        face0_stickers[0][2] = COLOR.WHITE.ordinal();

        //middle row
        face0_stickers[1][0] = COLOR.WHITE.ordinal();
        face0_stickers[1][1] = COLOR.WHITE.ordinal();
        face0_stickers[1][2] = COLOR.WHITE.ordinal();

        //bottom row
        face0_stickers[2][0] = COLOR.WHITE.ordinal();
        face0_stickers[2][1] = COLOR.WHITE.ordinal();
        face0_stickers[2][2] = COLOR.WHITE.ordinal();


        faces[SIDE.UP.ordinal()] = new Face(SIDE.UP.ordinal(), face0_stickers);

        //Similarly initialize all faces
        /*
         * G G G
         * G G G
         * G G G
         * */

        int[][] face1_stickers = new int[3][3];//GREEN
        int[][] face2_stickers = new int[3][3];//RED
        int[][] face3_stickers = new int[3][3];//BLUE
        int[][] face4_stickers = new int[3][3];//ORANGE
        int[][] face5_stickers = new int[3][3];//YELLOW

        faces[SIDE.LEFT.ordinal()] = new Face(SIDE.LEFT.ordinal(), face1_stickers);
        faces[SIDE.FRONT.ordinal()] = new Face(SIDE.FRONT.ordinal(), face2_stickers);
        faces[SIDE.RIGHT.ordinal()] = new Face(SIDE.RIGHT.ordinal(), face3_stickers);
        faces[SIDE.BACK.ordinal()] = new Face(SIDE.BACK.ordinal(), face4_stickers);
        faces[SIDE.DOWN.ordinal()] = new Face(SIDE.DOWN.ordinal(), face5_stickers);

        //initialize rubik cube
        Cube cube = new Cube(faces);

        //Print all the values for visual reference
        CubeSolver.printCube(cube);

        //Make some moves and rearrange colors
        CubeSolver.shuffle(cube);

        //Solve cube by making predictable moves
        CubeSolver.solve(cube);

        System.out.println("\n\n After U\n\n");
        CubeSolver.printCube(cube);

        //verify all faces have matrix of same colors
        boolean result = CubeSolver.isSolved(cube);

        System.out.println("\n\n Solved: " + result + "\n\n");
    }

}

