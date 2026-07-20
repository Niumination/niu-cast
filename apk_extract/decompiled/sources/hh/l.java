package hh;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + str.length());
        for (int i8 = 0; i8 < str.length(); i8++) {
            sb2.append(str.charAt(i8));
            if (str2.length() > i8) {
                sb2.append(str2.charAt(i8));
            }
        }
        return sb2.toString();
    }
}
