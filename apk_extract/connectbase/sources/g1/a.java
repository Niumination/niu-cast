package g1;

import java.util.Map;
import kn.r;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public abstract class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[][] f6347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final char f6349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final char f6350f;

    public a(b escaperMap, char safeMin, char safeMax) {
        escaperMap.getClass();
        char[][] cArr = escaperMap.f6352a;
        this.f6347c = cArr;
        this.f6348d = cArr.length;
        if (safeMax < safeMin) {
            safeMax = 0;
            safeMin = r.f9345c;
        }
        this.f6349e = safeMin;
        this.f6350f = safeMax;
    }

    @Override // g1.d, g1.h
    public final String b(String s10) {
        s10.getClass();
        for (int i10 = 0; i10 < s10.length(); i10++) {
            char cCharAt = s10.charAt(i10);
            if ((cCharAt < this.f6348d && this.f6347c[cCharAt] != null) || cCharAt > this.f6350f || cCharAt < this.f6349e) {
                return d(s10, i10);
            }
        }
        return s10;
    }

    @Override // g1.d
    @gm.a
    public final char[] c(char c10) {
        char[] cArr;
        if (c10 < this.f6348d && (cArr = this.f6347c[c10]) != null) {
            return cArr;
        }
        if (c10 < this.f6349e || c10 > this.f6350f) {
            return f(c10);
        }
        return null;
    }

    @gm.a
    public abstract char[] f(char c10);

    public a(Map<Character, String> replacementMap, char safeMin, char safeMax) {
        this(b.a(replacementMap), safeMin, safeMax);
    }
}
