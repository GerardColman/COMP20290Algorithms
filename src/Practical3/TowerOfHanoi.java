package Practical3;

public class TowerOfHanoi {
    public static void main(String[] args){
        TowerOfHanoi TOH = new TowerOfHanoi();
        System.out.println(TOH.TowerOfHanoi(1, "A", "B", "C"));
    }
    public String TowerOfHanoi(int disks, String Src, String Dest, String Aux){
        if(disks == 1){
            return moveDisks(Src,Dest);
        }else{
            TowerOfHanoi(disks -1, Src, Aux, Dest);
            TowerOfHanoi(disks - 1, Aux, Dest, Src);
        }
    }
    public String moveDisks(String source, String dest){

        return "Moved disk from " + source + " to " + dest;
    }
}
