package Practical3;

public class TowerOfHanoi {
    public static void main(String[] args){
        TowerOfHanoi TOH = new TowerOfHanoi();
        TOH.TowerOfHanoi(3, "A", "B", "C");
    }
    static void TowerOfHanoi(int disks, String src, String dest, String aux) {
        if (disks == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        TowerOfHanoi(disks-1, src, aux, dest);
        System.out.println("Move disk " + disks + " " + src + " to " + dest);
        TowerOfHanoi(disks-1, aux, dest, src);
    }
}