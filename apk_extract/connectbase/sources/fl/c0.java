package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends jl.d {
    /* JADX WARN: Multi-variable type inference failed */
    public c0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ c0(String str, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "Invalid data format" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@os.l String str) {
        super(str);
        kn.l0.p(str, "message");
    }
}
