package yj;

import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public class c extends k1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0.c f20879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.j
    public final y2 f20880d;

    public c(i0.c cVar, y2 y2Var) {
        this.f20879c = (i0.c) c1.h0.F(cVar, "stream");
        c1.h0.e(y2Var == null || !y2Var.r(), "Should not cancel with OK status");
        this.f20880d = y2Var;
    }

    @gm.j
    public y2 d() {
        return this.f20880d;
    }

    public i0.c e() {
        return this.f20879c;
    }
}
