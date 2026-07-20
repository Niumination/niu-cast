package cf;

import af.k2;
import java.util.List;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a8.a f1506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8.a f1507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k2 f1508d;
    public final n5.a e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f1513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f1516n;

    public d0(y yVar, List list) {
        v8.i(list, "streamTracerFactories");
        this.f1505a = list;
        a8.a aVar = yVar.e;
        v8.i(aVar, "transportExecutorPool");
        this.f1506b = aVar;
        a8.a aVar2 = yVar.f;
        v8.i(aVar2, "scheduledExecutorServicePool");
        this.f1507c = aVar2;
        k2 k2Var = yVar.f1661d;
        v8.i(k2Var, "transportTracerFactory");
        this.f1508d = k2Var;
        n5.a aVar3 = yVar.f1660c;
        v8.i(aVar3, "handshakerSocketFactory");
        this.e = aVar3;
        this.f = yVar.f1663h;
        this.f1509g = yVar.f1664i;
        this.f1510h = yVar.f1665j;
        this.f1511i = yVar.f1667l;
        this.f1512j = yVar.f1666k;
        this.f1513k = yVar.f1668m;
        this.f1514l = yVar.f1669n;
        this.f1515m = yVar.f1670o;
        this.f1516n = yVar.p;
    }
}
