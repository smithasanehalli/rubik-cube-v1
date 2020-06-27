package com.rubi;

public class CubeSolver {
    public static void printCube(Cube cube) {
        //TODO
    }

    public static boolean isSolved(Cube cube) {
        //TODO
        //Implement code to verify each face have all same color stickers with respect to center sticker or color
        //Basically all elements of 3*3 matrix on a face must contain value equal to face name(I am representing it by a color)
        return true;
    }

    /*Move is type of rotation. For example apply "U" rotation on face0(white/up face)
    If we make this rotation on a solved cube face0 stickers remain unchanged,but all other faces 1st row colors are changed
     */
    public static Cube shuffle(Cube _cube) {

        /*
         * SOLVED CUBE
         *
         *       W W W
         *       W W W
         *       W W W
         * G G G R R R B B B O O O
         * G G G R R R B B B O O O
         * G G G R R R B B B O O O
         *       Y Y Y
         *       Y Y Y
         *       Y Y Y
         * */

        //MOVE.U this will rotate top face by 90degree clockwise, as a result shuffle the first row stickers on all faces
        Cube scrambled_cube = rotate(_cube, SIDE.UP.ordinal(), MOVE.U);

        //face1 00,01,02 elements  will move to face4 00,01,02
        //face4 00,01,02 elements  will move to face3 00,01,02
        //face3 00,01,02 elements  will move to face2 00,01,02
        //face2 00,01,02 elements  will move to face1 00,01,02

        /*
         * AFTER U rotation of top face of the CUBE
         *
         *       W W W
         *       W W W
         *       W W W
         * R R R B B B O O O G G G
         * G G G R R R B B B O O O
         * G G G R R R B B B O O O
         *       Y Y Y
         *       Y Y Y
         *       Y Y Y
         * */

        return scrambled_cube;
    }

    public static Cube solve(Cube scrambled_cube) {

        //Solution to this cube is UPRIME rotation of UP face(WHITE face)

        Cube solved_cube = rotate(scrambled_cube, SIDE.UP.ordinal(), MOVE.UPRIME);

        return solved_cube;
    }

    public static Cube rotate(Cube cube, int faceName, MOVE move) {

        //MOVE.UPRIME is reverse of U, rotate UP face by 90degree anti clockwise, as a result update the first row stickers on all faces

        //face4 00,01,02 elements  will move to face1 00,01,02
        //face1 00,01,02 elements  will move to face2 00,01,02
        //face2 00,01,02 elements  will move to face3 00,01,02
        //face3 00,01,02 elements  will move to face4 00,01,02

        return cube;
    }
}
