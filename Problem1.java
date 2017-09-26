
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    int[] beeperList = new int[9];
    int x = 0;
    int i = 0;
    int tempCount = 0;
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        findFloor();
        for (i = 0; i < 8; i++) {
            collectBeepers();
        }
        rearrangeArray();
    }
    public void collectBeepers() {
        faceEast();
        findABeeperColumn();
        collectColumn();
        returnToFloor();
    }
    public void findFloor() {
        move();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    public void faceEast() { 
        while(!facingEast()) {
            turnLeft();
        }
    } 
    public void findABeeperColumn() { 
        while(!nextToABeeper()) {
            move();
            x++;
        }
        turnLeft();
    }
    public void collectColumn() { 
        tempCount = 0;
        for (int x = 0; x < 10; x++) {
            if(nextToABeeper()){
                pickBeeper();
                move();
                tempCount++;
            }
        }
        beeperList[x] = tempCount;
    }
    public void returnToFloor() { 
        turnLeft();
        turnLeft();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }
    public void rearrangeArray() {
        int index = 0;
        for (index = 0; index < 8; index++) {
            if (beeperList[index] > beeperList[index + 1]) {
                int temp = beeperList[index];
                beeperList[index] = beeperList[index + 1];
                beeperList[index + 1] = temp;
                if (beeperList[index - 1] > beeperList[index]) {
                    int temp2 = beeperList[index];
                    beeperList[index] = beeperList[index - 1];
                    beeperList[index - 1] = temp2;
                }
            }
        }
    }
    public int[] getBeeperList() { 
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
}

