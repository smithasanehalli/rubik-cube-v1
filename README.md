
# Rubik's Cube Notation

The documentation below describes the program to represent Rubik cube in Java. Standard twist notation is used: U, L, F, R, B and D desribe 90-degree clockwise twists of the up, left, front, right, back, and down faces, respectively. Adding an apostrophe indicates a counter-clockwise twist, so U' means twist the up face 90-degrees counter-clockwise. Adding a 2 to a move indicates a 180-degree twist; F2 means to twist the front face twice. With 6 faces and three types of moves per face, there are a total of 18 face twists. There's more information,  <a href="https://ruwix.com/the-rubiks-cube/notation/"> here </a>

A Rubik's Cube is made up of cubies (the cubies are the small cubes with stickers on them). There are corner cubies, which are the cubies with three stickers. Edge cubies are the cubies with two stickers. And there are center cubies, which are stationary and cannot be moved with the 18 twists described above.

Detailed explaination of the classes and how to store state of a Cube. 

### There are three enum classes :
1. Enum COLOR - WHITE, GREEN, RED, BLUE, ORANGE, YELLOW and their ordinal values are 0,1,2,3,4,5  respectively;
2. Enum SIDE - UP, LEFT, FRONT, RIGHT, BACK, DOWN and their ordinal values are 0,1,2,3,4,5  respectively. Side represents faces of Cube. To visualise hold a Cube with white side facing up and Red side facing you.
3. Enum MOVE - Possible twists or rotations of cubies
	L, LPRIME, L2,
	R, RPRIME, R2,
	U, UPRIME, U2,
	D, DPRIME, D2,
	F, FPRIME, F2,
	B, BPRIME, B2,
	Y, YPRIME, Y2,
	X, XPRIME, X2,
	Z, ZPRIME, Z2,
	M, MPRIME, M2,
	E, EPRIME, E2,
	S, SPRIME, S2

### Rubik Cube is represent using class called "Cube", which has an array of 6 "Faces".
### Each Face object represent a side of the Cube. Each Face has a unique name represented by its centre sticker color and  a 2D array of 9 stickers(colours)

### Solved Cube representation looks like:
W=0,G=1,R=2,B=3,O=4,Y=5

### STATE 1

           W W W
           W W W
           W W W
    G G G  R R R  B B B  O O O
    G G G  R R R  B B B  O O O
    G G G  R R R  B B B  O O O
           Y Y Y
           Y Y Y
           Y Y Y

### Slightly scrambled cube with only a U twist on ‘STATE 1’ looks like: 

### STATE 2

           W W W
           W W W
           W W W
    R R R  B B B  O O O  G G G
    G G G  R R R  B B B  O O O
    G G G  R R R  B B B  O O O
           Y Y Y
           Y Y Y
           Y Y Y
           
When the top face is rotated 90 degree clockwise, 4 faces are effected and only their first row sticker color are changed.
All 3 sticker on top row of face1 are shifted to face4 similarly face4 to face3, face3 to face2 and face2 strikers to face1.
face0 and face5 are not effected during this twist.
Implimentation should update the colours on each face based on the rotation.

Solution to solve Cube in ‘STATE 2’ is U’(UPRIME) rotation. UPRIME is just opposite of U rotation.

### After UPRIME twist on scrambled cube 'STATE 1' looks like: 

### STATE 3

           W W W
           W W W
           W W W
    G G G  R R R  B B B  O O O
    G G G  R R R  B B B  O O O
    G G G  R R R  B B B  O O O
           Y Y Y
           Y Y Y
           Y Y Y

When the top face of ‘STATE 2’ Cube is rotated 90 degree anti clockwise(UPRIME), 4 faces are effected and only their first row sticker color are changed.
Reverse the logic of U rotation, all 3 sticker on top row of face4 are shifted to face1 similarly face1 to face2, face2 to face3 and face3 strikers to face4.
Update the colours on each face object based on the rotation.


#### Reason behind going with 2D array/Bitboard Structure approach is :

To solve it using human approach I.e layer by layer we can use 3 dimension array of 6*3*3 and start solving bottom layer middle layer and top layer, this is not efficient for different sizes of cubes.

With random moves a 3*3 Rubik's cube can have over 43 quintillion possible states or combinations and is difficult to store all states. 
We can model to store it interns of 6 faces and using color codes.
To store the state of a face we can use 6 64-bit integers. Twisting can be done using bitwise operations, and face comparisons can be done using masks and 64-bit integer comparison.

Each face of the cube is made up of 9 stickers, but the center is stationary so only 8 need to be stored. And there are 6 colors, so a color can be stored in a single byte. The 8 stickers on a face of a Rubik’s Cube can therefore be stored in 64 bits.

Given these (arbitrary) color definitions:
enum Color {WHITE, GREEN, RED, BLUE, ORANGE, YELLOW};

A face might look like this, stored in a single 64-bit integer:
00000000 00000001 00000010 00000011 00000100 00000101 00000000 00000001
Which is decoded as:
W G R
G   B
W Y O

An advantage of using this structure is that the rolq and rorq bitwise assembly instructions can be used to move a face. Rolling by 16 bits effects a 90-degree twist, and rolling by 32 bits gives a 180-degree twist. The adjacent pieces need to be up-kept manually — e.g. after rotating the top face, the top-most colors of the front, left, back, and right faces need to be moved, too. Turning faces in this manner is really fast. For example, rolling
00000000 00000001 00000010 00000011 00000100 00000101 00000000 00000001
by 16 bits yields
00000000 00000001 00000000 00000001 00000010 00000011 00000100 00000101
Decoded, that looks like this:
W G W
Y   G
O B R


References

https://en.wikipedia.org/wiki/Optimal_solutions_for_Rubik%27s_Cube 
