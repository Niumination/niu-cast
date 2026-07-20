package g1;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6361b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Character, String> f6360a = new HashMap();

    public static class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final char[][] f6362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6363d;

        public a(char[][] replacements) {
            this.f6362c = replacements;
            this.f6363d = replacements.length;
        }

        @Override // g1.d, g1.h
        public String b(String s10) {
            int length = s10.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = s10.charAt(i10);
                char[][] cArr = this.f6362c;
                if (cCharAt < cArr.length && cArr[cCharAt] != null) {
                    return d(s10, i10);
                }
            }
            return s10;
        }

        @Override // g1.d
        @gm.a
        public char[] c(char c10) {
            if (c10 < this.f6363d) {
                return this.f6362c[c10];
            }
            return null;
        }
    }

    @t1.a
    public e a(char c10, String r10) {
        Map<Character, String> map = this.f6360a;
        Character chValueOf = Character.valueOf(c10);
        r10.getClass();
        map.put(chValueOf, r10);
        if (c10 > this.f6361b) {
            this.f6361b = c10;
        }
        return this;
    }

    @t1.a
    public e b(char[] cs2, String r10) {
        r10.getClass();
        for (char c10 : cs2) {
            a(c10, r10);
        }
        return this;
    }

    public char[][] c() {
        char[][] cArr = new char[this.f6361b + 1][];
        for (Map.Entry<Character, String> entry : this.f6360a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public h d() {
        return new a(c());
    }
}
