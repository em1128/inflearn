
public class t2{
    public static void main(String[] args){
        String s = "(){}[]";
        char[] br={};
        boolean checkBr[]={};
        int countCheck=0;
        int countCheckAll=0;
        br=s.toCharArray();
        checkBr = new boolean[br.length];
        System.out.println(br);
        for(int k=0;k<br.length-1;k++){
            countCheck = 0;
            for (int i = 0; i < checkBr.length; i++) {
                checkBr[i]=false;
            }

            for (int i = 0; i < br.length-1; i++) {
                for(int j=0;(i+j)<br.length;j++){
                    if(checkBracket(br[i], br[i+j])==true)
                    {
                        checkBr[i]=true;
                        checkBr[i+j]=true;
                    }
                }
            }
            for(boolean c:checkBr){
                if(c==true) countCheck++;
            }
            if(countCheck==checkBr.length) countCheckAll++;
            char temp;
            for(int i=0;i<br.length-1;i++){
                temp = br[i];
                br[i] = br[i+1];
                br[i+1] = temp;
            }
            System.out.println(br);
    }
        System.out.println(countCheckAll);
    }
    private static boolean checkBracket(char open,char close){
        if(open=='[' && close==']')
            return true;
        else if(open=='{' && close=='}')
            return true;
        else if(open=='(' && close==')')
            return true;
        else
            return false;
    }
    
}