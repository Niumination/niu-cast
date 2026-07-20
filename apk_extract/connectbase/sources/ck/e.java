package ck;

import c1.z;
import vj.e0;
import vj.o1;
import vj.v;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1771")
public abstract class e extends o1 {
    @Override // vj.o1
    public boolean b() {
        return h().b();
    }

    @Override // vj.o1
    public void c(y2 y2Var) {
        h().c(y2Var);
    }

    @Override // vj.o1
    public void d(o1.i iVar) {
        h().d(iVar);
    }

    @Override // vj.o1
    @Deprecated
    public void e(o1.j jVar, v vVar) {
        h().e(jVar, vVar);
    }

    @Override // vj.o1
    public void f() {
        h().f();
    }

    @Override // vj.o1
    public void g() {
        h().g();
    }

    public abstract o1 h();

    public String toString() {
        return z.c(this).j("delegate", h()).toString();
    }
}
