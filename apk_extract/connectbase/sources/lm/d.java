package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {r.class})
    public static final char a(int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException(h.a.a("Invalid Char code: ", i10));
        }
        return (char) i10;
    }

    public static final int b(char c10) {
        return c10;
    }

    @an.f
    @an.g
    @p2(markerClass = {r.class})
    @f1(version = "1.5")
    public static /* synthetic */ void c(char c10) {
    }
}
