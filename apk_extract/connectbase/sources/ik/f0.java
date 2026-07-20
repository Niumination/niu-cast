package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@fl.t0
public final class f0 extends fl.s1 implements b0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(@os.l String str, @os.l List<String> list) {
        super(true, str, list);
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
    }

    @Override // fl.s1
    @os.l
    public String toString() {
        return kn.l0.C("Headers ", entries());
    }
}
