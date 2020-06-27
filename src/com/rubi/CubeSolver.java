package com.rubi;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

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
        Cube scrambled_cube = rotate(_cube, MOVE.U);

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
        //before solving position cube correctly
        Cube afterRemap = reMapFaces(scrambled_cube);
        Cube solved_cube = rotate(afterRemap, MOVE.UPRIME);

        return solved_cube;
    }

    public static Cube rotate(Cube cube, MOVE move) {

        //MOVE.UPRIME is reverse of U, rotate UP face by 90degree anti clockwise, as a result update the first row stickers on all faces

        //face4 00,01,02 elements  will move to face1 00,01,02
        //face1 00,01,02 elements  will move to face2 00,01,02
        //face2 00,01,02 elements  will move to face3 00,01,02
        //face3 00,01,02 elements  will move to face4 00,01,02

        return cube;
    }
//Remap faces to have white face up and RED face as FRONT
    public static Cube reMapFaces(Cube cube) {

        Face[] faces = cube.getFaceArray();
        Map<Integer, Face> remap = new HashMap<Integer, Face>();

        for (int i = 0; i < faces.length; i++) {
            if (faces[i].getFaceName() != faces[i].getCenterSticker()) {
                //1, Face1, 2, Face2
                remap.put(faces[i].getCenterSticker(), faces[i]);
            }
        }
        //convert map to array
        faces[0] = remap.get(0);
        faces[1] = remap.get(1);
        faces[2] = remap.get(2);
        faces[3] = remap.get(3);
        faces[4] = remap.get(4);
        faces[5] = remap.get(5);

        return cube;
    }

}
