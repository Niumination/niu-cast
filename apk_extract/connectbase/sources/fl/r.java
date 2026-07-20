package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    @t0
    public static final boolean a(char c10) {
        return Character.toLowerCase(c10) == c10;
    }

    @t0
    @os.l
    public static final char[] b(@os.l String str) {
        kn.l0.p(str, "<this>");
        int length = str.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = str.charAt(i10);
        }
        return cArr;
    }
}
