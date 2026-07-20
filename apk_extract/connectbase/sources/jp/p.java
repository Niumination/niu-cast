package jp;

import eo.e1;
import eo.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kn.l0;
import nm.k0;
import vp.a1;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h0 f8789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ArrayList<f0> f8790c;

    @Override // vp.a1
    @os.l
    public Collection<f0> a() {
        return this.f8790c;
    }

    @Override // vp.a1
    @os.l
    public a1 b(@os.l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.a1
    public eo.h d() {
        return null;
    }

    @Override // vp.a1
    public boolean e() {
        return false;
    }

    @os.m
    public Void f() {
        return null;
    }

    @Override // vp.a1
    @os.l
    public List<e1> getParameters() {
        return k0.INSTANCE;
    }

    @Override // vp.a1
    @os.l
    public ao.h n() {
        return this.f8789b.n();
    }

    @os.l
    public String toString() {
        return n2.k0.a(new StringBuilder("IntegerValueType("), this.f8788a, ')');
    }
}
