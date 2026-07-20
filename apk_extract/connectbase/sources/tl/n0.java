package tl;

/* JADX INFO: loaded from: classes2.dex */
@f0
public final class n0 extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public n0() {
        this((String) null, 1, (kn.w) (0 == true ? 1 : 0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@os.l String str) {
        super(str);
        kn.l0.p(str, "message");
    }

    public /* synthetic */ n0(String str, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "Not enough free space" : str);
    }

    public n0(int i10, int i11) {
        this("Not enough free space to write " + i10 + " bytes, available " + i11 + " bytes.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n0(@os.l String str, int i10, int i11) {
        this("Not enough free space to write " + str + " of " + i10 + " bytes, available " + i11 + " bytes.");
        kn.l0.p(str, "name");
    }

    public n0(long j10, long j11) {
        this(k.d.a(j.b.a("Not enough free space to write ", j10, " bytes, available "), j11, " bytes."));
    }
}
