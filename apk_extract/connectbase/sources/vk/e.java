package vk;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import fl.t0;
import fl.v1;
import ik.b0;
import ik.c0;
import ik.j0;
import ik.n1;
import ik.p0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.w;
import lm.l2;
import nk.a0;
import nm.k0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@t0
@j
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public p0 f17589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final n1 f17590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final c0 f17591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public ArrayList<a0> f17592d;

    public e() {
        this(null, null, null, null, 15, null);
    }

    @Override // vk.h
    @l
    public n1 a() {
        return this.f17590b;
    }

    @Override // vk.h
    @l
    public c0 b() {
        return this.f17591c;
    }

    @Override // vk.h
    public void c(@l p0 p0Var) {
        l0.p(p0Var, "<set-?>");
        this.f17589a = p0Var;
    }

    @Override // vk.h
    public List d() {
        return this.f17592d;
    }

    @l
    public ArrayList<a0> e() {
        return this.f17592d;
    }

    public void f(@l ArrayList<a0> arrayList) {
        l0.p(arrayList, "<set-?>");
        this.f17592d = arrayList;
    }

    @Override // vk.h
    @l
    public p0 getMethod() {
        return this.f17589a;
    }

    public e(@l p0 p0Var, @l n1 n1Var, @l c0 c0Var, @l List<? extends a0> list) {
        l0.p(p0Var, "method");
        l0.p(n1Var, RtspHeaders.Values.URL);
        l0.p(c0Var, "headers");
        l0.p(list, "versions");
        this.f17589a = p0Var;
        this.f17590b = n1Var;
        this.f17591c = c0Var;
        this.f17592d = list.isEmpty() ? new ArrayList<>() : new ArrayList<>(list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(p0 p0Var, n1 n1Var, c0 c0Var, List list, int i10, w wVar) {
        p0 p0Var2;
        if ((i10 & 1) != 0) {
            p0.f8135b.getClass();
            p0Var2 = p0.f8136c;
        } else {
            p0Var2 = p0Var;
        }
        this(p0Var2, (i10 & 2) != 0 ? new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null) : n1Var, (i10 & 4) != 0 ? new c0(0, 1, null) : c0Var, (i10 & 8) != 0 ? k0.INSTANCE : list);
    }

    public e(@l n1 n1Var, @l b0 b0Var) {
        l0.p(n1Var, RtspHeaders.Values.URL);
        l0.p(b0Var, "headers");
        c0 c0Var = new c0(0, 1, null);
        c0Var.b(b0Var);
        l2 l2Var = l2.f10208a;
        this(null, n1Var, c0Var, null, 9, null);
    }

    public e(@l dk.b bVar) {
        l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        n1.a aVar = n1.f8120j;
        n1 n1VarA = v1.a(aVar, bVar);
        c0 c0Var = new c0(0, 1, null);
        c0Var.b(bVar.d().b());
        j0.f8048a.getClass();
        String str = j0.f8063h0;
        n1 n1VarA2 = v1.a(aVar, bVar);
        l2 l2Var = l2.f10208a;
        c0Var.v(str, n1VarA2.c());
        this(null, n1VarA, c0Var, null, 9, null);
    }
}
