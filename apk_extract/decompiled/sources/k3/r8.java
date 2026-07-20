package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class r8 {
    public static String a(String str) {
        int length = str.length();
        int i8 = 0;
        while (i8 < length) {
            char cCharAt = str.charAt(i8);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i8 < length) {
                    char c9 = charArray[i8];
                    if (c9 >= 'A' && c9 <= 'Z') {
                        charArray[i8] = (char) (c9 ^ ' ');
                    }
                    i8++;
                }
                return String.valueOf(charArray);
            }
            i8++;
        }
        return str;
    }
}
