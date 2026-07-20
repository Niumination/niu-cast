package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class ib {
    public static void a(int i8, Object[] objArr) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (objArr[i9] == null) {
                throw new NullPointerException(a1.a.o(i9, "at index "));
            }
        }
    }
}
