package j1;

/* JADX INFO: loaded from: classes.dex */
public enum h0 {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    public boolean useSoftwareRendering(int i8, boolean z2, int i9) {
        int i10 = g0.f5961a[ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return (z2 && i8 < 28) || i9 > 4 || i8 <= 25;
        }
        return true;
    }
}
