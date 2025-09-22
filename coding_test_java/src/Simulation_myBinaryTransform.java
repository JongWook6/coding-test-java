public class Simulation_myBinaryTransform {

    private static int trans;
    private static int zeros;

    public int[] solution(String s) {
        trans = 0;
        zeros = 0;

        while(!s.equals("1")){
            s = toBinary(eliminateZero(s));
        }

        return new int[]{trans, zeros};
    }

    private static String eliminateZero(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }
        }
        return s.replace("0", "");
    }

    private static String toBinary(String s){
        int num = s.length();
        StringBuilder sb = new StringBuilder();
        while(num > 1){
            if(num % 2 == 0){
                sb.insert(0, "0");
            } else {
                sb.insert(0, "1");
            }
            num = num / 2;
        }
        sb.insert(0, "1");
        trans++;

        return sb.toString();
    }

}
