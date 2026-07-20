package g1;

import java.util.Map;
import kn.r;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b
public abstract class c extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[][] f6353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final char f6357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final char f6358h;

    public c(b escaperMap, int safeMin, int safeMax, String unsafeReplacement) {
        escaperMap.getClass();
        char[][] cArr = escaperMap.f6352a;
        this.f6353c = cArr;
        this.f6354d = cArr.length;
        if (safeMax < safeMin) {
            safeMax = -1;
            safeMin = Integer.MAX_VALUE;
        }
        this.f6355e = safeMin;
        this.f6356f = safeMax;
        if (safeMin >= 55296) {
            this.f6357g = r.f9345c;
            this.f6358h = (char) 0;
        } else {
            this.f6357g = (char) safeMin;
            this.f6358h = (char) Math.min(safeMax, 55295);
        }
    }

    @Override // g1.l, g1.h
    public final String b(String s10) {
        s10.getClass();
        for (int i10 = 0; i10 < s10.length(); i10++) {
            char cCharAt = s10.charAt(i10);
            if ((cCharAt < this.f6354d && this.f6353c[cCharAt] != null) || cCharAt > this.f6358h || cCharAt < this.f6357g) {
                return e(s10, i10);
            }
        }
        return s10;
    }

    @Override // g1.l
    @gm.a
    public final char[] d(int cp2) {
        char[] cArr;
        if (cp2 < this.f6354d && (cArr = this.f6353c[cp2]) != null) {
            return cArr;
        }
        if (cp2 < this.f6355e || cp2 > this.f6356f) {
            return h(cp2);
        }
        return null;
    }

    @Override // g1.l
    public final int g(CharSequence csq, int index, int end) {
        while (index < end) {
            char cCharAt = csq.charAt(index);
            if ((cCharAt < this.f6354d && this.f6353c[cCharAt] != null) || cCharAt > this.f6358h || cCharAt < this.f6357g) {
                break;
            }
            index++;
        }
        return index;
    }

    @gm.a
    public abstract char[] h(int cp2);

    public c(Map<Character, String> replacementMap, int safeMin, int safeMax, String unsafeReplacement) {
        this(b.a(replacementMap), safeMin, safeMax, unsafeReplacement);
    }
}
