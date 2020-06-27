package com.rubi;
/*
 * Assume that the Cube is always with white face up and red side facing you, if not we can position the cube like that using positionCube function
 * Hold a cube with white side facing up and Red side facing you
 * SOLVED CUBE REPRESENTATION
 * W=0,G=1,R=2,B=3,O=4,Y=5
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

public class Cube {

    public Face[] getFaceArray() {
        return faceArray;
    }

    public void setFaceArray(Face[] faceArray) {
        this.faceArray = faceArray;
    }

    Face[] faceArray = new Face[6];

    public Cube(Face[] _faceArray) {
        this.faceArray = _faceArray;
    }
}
