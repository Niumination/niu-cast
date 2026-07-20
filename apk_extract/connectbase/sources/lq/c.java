package lq;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final r f10245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10246b;

    public /* synthetic */ c(r rVar, long j10, w wVar) {
        this(rVar, j10);
    }

    @Override // lq.r
    public long a() {
        return e.h0(this.f10245a.a(), this.f10246b);
    }

    @Override // lq.r
    public boolean b() {
        return r.a.b(this);
    }

    @Override // lq.r
    @os.l
    public r c(long j10) {
        return new c(this.f10245a, e.i0(this.f10246b, j10));
    }

    @Override // lq.r
    public boolean d() {
        return r.a.a(this);
    }

    @Override // lq.r
    @os.l
    public r e(long j10) {
        return r.a.c(this, j10);
    }

    public final long f() {
        return this.f10246b;
    }

    @os.l
    public final r g() {
        return this.f10245a;
    }

    public c(r rVar, long j10) {
        l0.p(rVar, "mark");
        this.f10245a = rVar;
        this.f10246b = j10;
    }
}
