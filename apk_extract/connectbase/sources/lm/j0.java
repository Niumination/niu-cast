package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public j0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(@os.l String str) {
        super(str);
        kn.l0.p(str, "message");
    }

    public /* synthetic */ j0(String str, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
