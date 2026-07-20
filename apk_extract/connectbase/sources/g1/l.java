package g1;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public abstract class l extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6375b = 32;

    public static int c(CharSequence seq, int index, int end) {
        seq.getClass();
        if (index >= end) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i10 = index + 1;
        char cCharAt = seq.charAt(index);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + index + " in '" + ((Object) seq) + "'");
        }
        if (i10 == end) {
            return -cCharAt;
        }
        char cCharAt2 = seq.charAt(i10);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i10 + " in '" + ((Object) seq) + "'");
    }

    private static char[] f(char[] dest, int index, int size) {
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
        int iG = g(string, 0, length);
        return iG == length ? string : e(string, iG);
    }

    @gm.a
    public abstract char[] d(int cp2);

    public final String e(String s10, int index) {
        int length = s10.length();
        char[] cArrA = k.a();
        int i10 = 0;
        int length2 = 0;
        while (index < length) {
            int iC = c(s10, index, length);
            if (iC < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrD = d(iC);
            int i11 = (Character.isSupplementaryCodePoint(iC) ? 2 : 1) + index;
            if (cArrD != null) {
                int i12 = index - i10;
                int i13 = length2 + i12;
                int length3 = cArrD.length + i13;
                if (cArrA.length < length3) {
                    cArrA = f(cArrA, length2, (length - index) + length3 + 32);
                }
                if (i12 > 0) {
                    s10.getChars(i10, index, cArrA, length2);
                    length2 = i13;
                }
                if (cArrD.length > 0) {
                    System.arraycopy(cArrD, 0, cArrA, length2, cArrD.length);
                    length2 += cArrD.length;
                }
                i10 = i11;
            }
            index = g(s10, i11, length);
        }
        int i14 = length - i10;
        if (i14 > 0) {
            int i15 = i14 + length2;
            if (cArrA.length < i15) {
                cArrA = f(cArrA, length2, i15);
            }
            s10.getChars(i10, length, cArrA, length2);
            length2 = i15;
        }
        return new String(cArrA, 0, length2);
    }

    public int g(CharSequence csq, int start, int end) {
        while (start < end) {
            int iC = c(csq, start, end);
            if (iC < 0 || d(iC) != null) {
                break;
            }
            start += Character.isSupplementaryCodePoint(iC) ? 2 : 1;
        }
        return start;
    }
}
