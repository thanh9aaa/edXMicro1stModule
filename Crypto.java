import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your String: ");
        String s = sc.nextLine();

        System.out.print("Enter the shift number to decrypt: ");
        int shift = sc.nextInt();

        System.out.print("Enter group size: ");
        int groupSize = sc.nextInt();

        String encrypt = encryptString(s, shift, groupSize);

        System.out.println(encrypt);

        System.out.print("Enter the secret encoder key: ");
        int unshift = sc.nextInt();

        String decryptedText = decryptString(encrypt, unshift);
        System.out.println(decryptedText);
    }
    // replace all punctuation and space, then uppercase the input String.
    public static String normalizeText(String s){
        s = s.replaceAll("\\s+","");
        s = s.replaceAll("[^a-z A-Z ]","");
        s= s.toUpperCase();

        return s;
    }

    // shift the character in the String s to 'shift' amount of char.
    public static String caesarify(String s, int shift){
        String s1 = "";
        for(int i = 0; i < s.length(); i++){
            char c = (char)(s.charAt(i) + shift);
            if(c > 'Z') s1 += (char) (s.charAt(i) - 26 + shift);
            else s1 += (char)(s.charAt(i) + shift);
        }
        return s1;
    }

    //group char from String to small substring at chosen size
    public static String groupify(String s, int groupSize) {
        String s1 = "";
        for (int i = 0; i < s.length() ; i++){
            s1 += s.charAt(i);
            if (s1.substring(0, i+1).length() % groupSize ==0 && i >= 1){
                s1 += ' ';
            }
        }
        return s1;
    }

    public static String obify(String s){
        String obifiedText = s.replaceAll("(A|E|O|I|U|Y)","OB$1");
        return obifiedText;
    }

    public static String ungroupify(String s){
        s = s.replaceAll("\\s","");
        return s;
    }

    public static String unobify(String s){
        String unobifiedText = s.replaceAll("(O|B)","");
        return unobifiedText;
    }

    public static String decryptString(String s, int shift){
        s = ungroupify(s);
        s = caesarify(s, shift);
        s = unobify(s);
        return s;
    }

    public static String encryptString(String s, int shift,int groupSize){
        String s1 = normalizeText(s);
        s1 = obify(s1);
        s1 = caesarify(s1, shift);
        s1 = groupify(s1, groupSize);
        return s1;

    }
}
