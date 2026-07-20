package m3;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static int a(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 90) {
            return 1;
        }
        if (i8 == 180) {
            return 2;
        }
        if (i8 == 270) {
            return 3;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Invalid rotation: "));
    }
}
