package bq;

import eo.h1;
import eo.y;
import kn.l0;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final e f1055a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f1056b = "second parameter must be of type KProperty<*> or its supertype";

    @Override // bq.b
    @m
    public String a(@os.l y yVar) {
        return b.a.a(this, yVar);
    }

    @Override // bq.b
    public boolean b(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        h1 h1Var = yVar.h().get(1);
        ao.j.b bVar = ao.j.f540k;
        l0.o(h1Var, "secondParameter");
        f0 f0VarA = bVar.a(lp.a.l(h1Var));
        if (f0VarA == null) {
            return false;
        }
        f0 type = h1Var.getType();
        l0.o(type, "secondParameter.type");
        return zp.a.m(f0VarA, zp.a.p(type));
    }

    @Override // bq.b
    @os.l
    public String getDescription() {
        return f1056b;
    }
}
