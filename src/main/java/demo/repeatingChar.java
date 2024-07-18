package demo;

public class repeatingChar {
    public static void main(String[] args) {
        String s = "xxxyyy";
        int index=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            String sub = null;
            if (i==0) {
                sub = s.substring(i+1, s.length());
                System.out.println(sub);
            }else if (i!=0) {
                sub = s.substring(0, i)+s.substring(i+1, s.length());
                System.out.println(sub);
            }

            if (!sub.contains(String.valueOf(s.charAt(i)))) {
                index=i;
                break;
            }else{
                count++;
            }
        }

        
        System.out.println(index);
        System.out.println(count);

        String e ="ABCabc123,)*$%@!@";
        String y= e.replaceAll("[^a-z,^A-Z,^0-9]", "");
        System.out.println(y);
        String b="aaassdf1234fggff";
        String h=b.replaceAll("[^0-9]", "");
        System.out.println(h);
    }
}
