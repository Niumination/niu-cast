package ik;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@fl.t0
public final class d0 extends fl.q1 implements b0 {
    /* JADX WARN: Multi-variable type inference failed */
    public d0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // fl.q1
    @os.l
    public String toString() {
        return kn.l0.C("Headers ", entries());
    }

    public /* synthetic */ d0(Map map, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? nm.d1.z() : map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@os.l Map<String, ? extends List<String>> map) {
        super(true, map);
        kn.l0.p(map, "values");
    }
}
