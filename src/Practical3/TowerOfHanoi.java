//public class TowerOfHanoi {
//    public static void main(String[] args){
//        TowerOfHanoi TOH = new TowerOfHanoi();
//        System.out.println(TOH.TowerOfHanoi(1, "A", "B", "C"));
//    }
//    public String TowerOfHanoi(int disks, String Source, String Aux, String Dest){
//        if(disks == 1){
//            return moveDisks(Source,Dest);
//        }else{
//            return TowerOfHanoi(disks - 1, "Source", "Aux", "Dest");
//            return TowerOfHanoi(disks -1, "Aux", "Dest", "Source");
//        }
//    }
//    public String moveDisks(String source, String dest){
//        return source + " to " + dest;
//    }
//}
