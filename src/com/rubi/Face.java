package com.rubi;

/*
 * A cube has 6 faces and each face have 9 sticker(color).
 * I am representing each sticker position in a 2D array.
 *
 * UP face as
 *   0 1 2
 * 0 W W W
 * 1 W W W
 * 2 W W W

 * */
public class Face {

    public static final int dim = 3;

    int faceName;

    int[][] stickerPosition;

    public Face(int _faceName, int[][] _stickerPosition) {
        this.faceName = _faceName;
        this.stickerPosition = _stickerPosition;

        //considering center Sticker color as the face name
        if (faceName != stickerPosition[1][1]) {
            //then it is wrong initialization, throw exception do not initialize Face
        }
    }

    public int getFaceName() {
        return faceName;
    }

    public void setFaceName(int faceName) {
        this.faceName = faceName;
    }

    public int[][] getStickerPosition() {
        return stickerPosition;
    }

    public void setStickerPosition(int[][] stickerPosition) {
        this.stickerPosition = stickerPosition;
    }


    public int getCenterSticker() {
        return this.stickerPosition[1][1];
    }

}

