package bq;

import eo.h1;
import eo.y;
import java.util.Collection;
import java.util.List;
import kn.l0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final h f1061a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f1062b = "should not have varargs or parameters with default values";

    @Override // bq.b
    @m
    public String a(@os.l y yVar) {
        return b.a.a(this, yVar);
    }

    @Override // bq.b
    public boolean b(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        List<h1> listH = yVar.h();
        l0.o(listH, "functionDescriptor.valueParameters");
        List<h1> list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (h1 h1Var : list) {
            l0.o(h1Var, "it");
            if (lp.a.a(h1Var) || h1Var.s0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // bq.b
    @os.l
    public String getDescription() {
        return f1062b;
    }
}
