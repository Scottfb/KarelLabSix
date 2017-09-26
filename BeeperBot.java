
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    int x = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        while(frontIsClear()) {
            collectBeepers();
            x++;
        }
    }
    public void collectBeepers() {
        faceEast();
        findABeeperColumn();
        collectColumn();
        returnToFloor();
    }
    public void faceEast() { 
        while(!facingEast()) {
            turnLeft();
        }
    }
    public void findABeeperColumn() { 
        while(!nextToABeeper() && frontIsClear()) {
            move();
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
    public int[] getBeeperList() { 
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
}

