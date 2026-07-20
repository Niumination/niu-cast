package vp;

/* JADX INFO: loaded from: classes3.dex */
public enum o1 {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;

    @os.l
    private final String label;
    private final int superpositionFactor;

    o1(String str, boolean z10, boolean z11, int i10) {
        this.label = str;
        this.allowsInPosition = z10;
        this.allowsOutPosition = z11;
        this.superpositionFactor = i10;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @os.l
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    @os.l
    public String toString() {
        return this.label;
    }
}
