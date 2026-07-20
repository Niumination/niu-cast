package ik;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@fl.t0
public final class d1 extends fl.q1 implements b1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final z1 f7952f;

    /* JADX WARN: Multi-variable type inference failed */
    public d1() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // ik.b1
    @os.l
    public z1 c() {
        return this.f7952f;
    }

    @Override // fl.q1
    @os.l
    public String toString() {
        return kn.l0.C("Parameters ", entries());
    }

    public /* synthetic */ d1(Map map, z1 z1Var, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? nm.d1.z() : map, (i10 & 2) != 0 ? z1.DEFAULT : z1Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(@os.l Map<String, ? extends List<String>> map, @os.l z1 z1Var) {
        super(true, map);
        kn.l0.p(map, "values");
        kn.l0.p(z1Var, "urlEncodingOption");
        this.f7952f = z1Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ d1(Map map) {
        this(map, z1.DEFAULT);
        kn.l0.p(map, "values");
    }

    public /* synthetic */ d1(Map map, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? nm.d1.z() : map);
    }
}
