package g1;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public abstract class d extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6359b = 2;

    public static char[] e(char[] dest, int index, int size) {
        if (size < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr = new char[size];
        if (index > 0) {
            System.arraycopy(dest, 0, cArr, 0, index);
        }
        return cArr;
    }

    @Override // g1.h
    public String b(String string) {
        string.getClass();
        int length = string.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (c(string.charAt(i10)) != null) {
                return d(string, i10);
            }
        }
        return string;
    }

    @gm.a
    public abstract char[] c(char c10);

    public final String d(String s10, int index) {
        int length = s10.length();
        char[] cArrA = k.a();
        int length2 = cArrA.length;
        int i10 = 0;
        int i11 = 0;
        while (index < length) {
            char[] cArrC = c(s10.charAt(index));
            if (cArrC != null) {
                int length3 = cArrC.length;
                int i12 = index - i10;
                int i13 = i11 + i12;
                int i14 = i13 + length3;
                if (length2 < i14) {
                    length2 = ((length - index) * 2) + i14;
                    cArrA = e(cArrA, i11, length2);
                }
                if (i12 > 0) {
                    s10.getChars(i10, index, cArrA, i11);
                    i11 = i13;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrC, 0, cArrA, i11, length3);
                    i11 += length3;
                }
                i10 = index + 1;
            }
            index++;
        }
        int i15 = length - i10;
        if (i15 > 0) {
            int i16 = i15 + i11;
            if (length2 < i16) {
                cArrA = e(cArrA, i11, i16);
            }
            s10.getChars(i10, length, cArrA, i11);
            i11 = i16;
        }
        return new String(cArrA, 0, i11);
    }
}
