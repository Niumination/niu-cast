package yl;

import os.l;

/* JADX INFO: loaded from: classes2.dex */
@in.i(name = "PollersKt")
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final ThreadLocal<f<Thread>> f21459a = new ThreadLocal<>();

    @in.i(name = "getParkingImpl")
    @l
    public static final f<Thread> a() {
        f<Thread> fVar = f21459a.get();
        return fVar == null ? c.f21447a : fVar;
    }

    @in.i(name = "isParkingAllowed")
    public static final boolean b() {
        return a() != h.f21460a;
    }

    @in.i(name = "prohibitParking")
    public static final void c() {
        f21459a.set(h.f21460a);
    }
}
