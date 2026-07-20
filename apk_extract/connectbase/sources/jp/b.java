package jp;

import eo.h0;
import java.util.List;
import kn.l0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class b extends g<List<? extends g<?>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<h0, f0> f8771b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@os.l List<? extends g<?>> list, @os.l jn.l<? super h0, ? extends f0> lVar) {
        super(list);
        l0.p(list, "value");
        l0.p(lVar, "computeType");
        this.f8771b = lVar;
    }

    @Override // jp.g
    @os.l
    public f0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        f0 f0VarInvoke = this.f8771b.invoke(h0Var);
        if (!ao.h.c0(f0VarInvoke) && !ao.h.o0(f0VarInvoke)) {
            ao.h.B0(f0VarInvoke);
        }
        return f0VarInvoke;
    }
}
