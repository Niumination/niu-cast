package p001if;

import k3.b0;
import ze.m;
import ze.n;
import ze.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f5835b;

    public p(i iVar, p pVar) {
        this.f5834a = iVar;
        this.f5835b = pVar;
    }

    @Override // ze.m
    public final n a(b0 b0Var, p1 p1Var) {
        p pVar = this.f5835b;
        return pVar != null ? new n(this, pVar.a(b0Var, p1Var)) : new o(this);
    }
}
