package r1;

/* JADX INFO: loaded from: classes.dex */
public enum y {
    SIMULTANEOUSLY,
    INDIVIDUALLY;

    public static y forId(int i8) {
        if (i8 == 1) {
            return SIMULTANEOUSLY;
        }
        if (i8 == 2) {
            return INDIVIDUALLY;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Unknown trim path type "));
    }
}
