package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public r0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public r0(@os.m String str) {
        super(str);
    }

    public /* synthetic */ r0(String str, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "Resource not found" : str);
    }
}
