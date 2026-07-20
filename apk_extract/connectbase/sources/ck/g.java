package ck;

import c1.z;
import java.util.List;
import vj.d0;
import vj.e0;
import vj.o1;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1771")
public abstract class g extends o1.j {
    @Override // vj.o1.j
    public vj.f a() {
        return k().a();
    }

    @Override // vj.o1.j
    public List<d0> c() {
        return k().c();
    }

    @Override // vj.o1.j
    public vj.a d() {
        return k().d();
    }

    @Override // vj.o1.j
    public vj.h e() {
        return k().e();
    }

    @Override // vj.o1.j
    public Object f() {
        return k().f();
    }

    @Override // vj.o1.j
    public void g() {
        k().g();
    }

    @Override // vj.o1.j
    public void h() {
        k().h();
    }

    @Override // vj.o1.j
    public void i(o1.l lVar) {
        k().i(lVar);
    }

    @Override // vj.o1.j
    public void j(List<d0> list) {
        k().j(list);
    }

    public abstract o1.j k();

    public String toString() {
        return z.c(this).j("delegate", k()).toString();
    }
}
