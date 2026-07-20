package n1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@a
public final class k extends g1.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f11289e = {'+'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f11290f = jq.j.f8822b.toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f11292d;

    public k(String safeChars, boolean plusForSpace) {
        safeChars.getClass();
        if (safeChars.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String strConcat = safeChars.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        if (plusForSpace && strConcat.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.f11291c = plusForSpace;
        this.f11292d = h(strConcat);
    }

    public static boolean[] h(String safeChars) {
        char[] charArray = safeChars.toCharArray();
        int iMax = -1;
        for (char c10 : charArray) {
            iMax = Math.max((int) c10, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c11 : charArray) {
            zArr[c11] = true;
        }
        return zArr;
    }

    @Override // g1.l, g1.h
    public String b(String s10) {
        s10.getClass();
        int length = s10.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = s10.charAt(i10);
            boolean[] zArr = this.f11292d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return e(s10, i10);
            }
        }
        return s10;
    }

    @Override // g1.l
    @gm.a
    public char[] d(int cp2) {
        boolean[] zArr = this.f11292d;
        if (cp2 < zArr.length && zArr[cp2]) {
            return null;
        }
        if (cp2 == 32 && this.f11291c) {
            return f11289e;
        }
        if (cp2 <= 127) {
            char[] cArr = f11290f;
            return new char[]{'%', cArr[cp2 >>> 4], cArr[cp2 & 15]};
        }
        if (cp2 <= 2047) {
            char[] cArr2 = f11290f;
            return new char[]{'%', cArr2[(cp2 >>> 10) | 12], cArr2[(cp2 >>> 6) & 15], '%', cArr2[((cp2 >>> 4) & 3) | 8], cArr2[cp2 & 15]};
        }
        if (cp2 <= 65535) {
            char[] cArr3 = f11290f;
            return new char[]{'%', 'E', cArr3[cp2 >>> 12], '%', cArr3[((cp2 >>> 10) & 3) | 8], cArr3[(cp2 >>> 6) & 15], '%', cArr3[((cp2 >>> 4) & 3) | 8], cArr3[cp2 & 15]};
        }
        if (cp2 > 1114111) {
            throw new IllegalArgumentException(h.a.a("Invalid unicode character value ", cp2));
        }
        char[] cArr4 = f11290f;
        return new char[]{'%', 'F', cArr4[(cp2 >>> 18) & 7], '%', cArr4[((cp2 >>> 16) & 3) | 8], cArr4[(cp2 >>> 12) & 15], '%', cArr4[((cp2 >>> 10) & 3) | 8], cArr4[(cp2 >>> 6) & 15], '%', cArr4[((cp2 >>> 4) & 3) | 8], cArr4[cp2 & 15]};
    }

    @Override // g1.l
    public int g(CharSequence csq, int index, int end) {
        csq.getClass();
        while (index < end) {
            char cCharAt = csq.charAt(index);
            boolean[] zArr = this.f11292d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            index++;
        }
        return index;
    }
}
