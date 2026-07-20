package rq;

import java.util.List;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@z0
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.g f14814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final xm.e f14815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<StackTraceElement> f14817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f14818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final Thread f14819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final xm.e f14820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final List<StackTraceElement> f14821h;

    public d(@os.l e eVar, @os.l um.g gVar) {
        this.f14814a = gVar;
        this.f14815b = eVar.f14822a;
        this.f14816c = eVar.f14823b;
        this.f14817d = eVar.b();
        this.f14818e = eVar._state;
        this.f14819f = eVar.lastObservedThread;
        this.f14820g = eVar.f();
        this.f14821h = eVar.h();
    }

    @os.l
    public final um.g a() {
        return this.f14814a;
    }

    @os.m
    public final xm.e b() {
        return this.f14815b;
    }

    @os.l
    public final List<StackTraceElement> c() {
        return this.f14817d;
    }

    @os.m
    public final xm.e d() {
        return this.f14820g;
    }

    @os.m
    public final Thread e() {
        return this.f14819f;
    }

    public final long f() {
        return this.f14816c;
    }

    @os.l
    public final String g() {
        return this.f14818e;
    }

    @in.i(name = "lastObservedStackTrace")
    @os.l
    public final List<StackTraceElement> h() {
        return this.f14821h;
    }
}
