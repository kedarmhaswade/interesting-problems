package org.kedar.probs.gen;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Oct 11, 2010
 * Time: 11:57:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindrome {
    private final String s;

    public LongestPalindrome(String s) {
        this.s = s;
    }

    public String get() {
        int len = s.length();
        for (int i = len ; i >= 1 ; i--) {
            int begin = 0;
            while ((begin+i) <= len) {
                String lp = getPalindrome(s, begin, i);
                if (lp != null) {
                    return lp;
                }
                begin++;
            }
        }
        return null;
    }

    private static String getPalindrome(String in, int begin, int plen) {
        int len = in.length();
        if (len < (begin + plen)) {
            System.err.println("for: " + in + " in.length < (begin+plen) :: " + len + " : " + begin + "+" + plen);
            return null;
        }
        for (int i = begin, j = 0 ; j < plen/2 ; i++, j++) {
            if (in.charAt(i) != in.charAt(begin+plen-1-j)) {
                return null;
            }
        }
        return in.substring(begin, begin+plen);
    }
    public static void main(String... args) {
        String s = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(new LongestPalindrome(s).get());
    }
}
