package g3;

import kn.l0;
import os.l;
import os.m;
import r2.p;
import vj.i2;
import yj.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements z2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public i2 f6405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final g f6406c = new g();

    public f(int i10) {
        this.f6404a = i10;
    }

    @Override // z2.d
    public void b() {
        try {
            i2 i2VarF = m0.O(this.f6404a).a(new a()).f();
            this.f6405b = i2VarF;
            if (i2VarF != null) {
                i2VarF.u();
            }
            this.f6406c.start();
            u2.b bVar = u2.b.f16175b;
            String simpleName = f.class.getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            p.b(bVar, new r2.f(simpleName, true), null, 2, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            u2.b bVar2 = u2.b.f16175b;
            String simpleName2 = f.class.getSimpleName();
            l0.o(simpleName2, "getSimpleName(...)");
            p.b(bVar2, new r2.f(simpleName2, false), null, 2, null);
            this.f6405b = null;
        }
    }

    @Override // z2.d
    public void disconnect() {
        i2 i2Var = this.f6405b;
        if (i2Var != null) {
            i2Var.s();
        }
        this.f6406c.stop();
    }
}
