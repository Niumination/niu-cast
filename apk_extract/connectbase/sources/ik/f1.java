package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@fl.t0
public final class f1 extends fl.s1 implements b1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(@os.l String str, @os.l List<String> list) {
        super(true, str, list);
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
    }

    @Override // ik.b1
    @os.l
    public z1 c() {
        return b1.b.e(this);
    }

    @Override // fl.s1
    @os.l
    public String toString() {
        return kn.l0.C("Parameters ", entries());
    }
}
