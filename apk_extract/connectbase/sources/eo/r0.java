package eo;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final i f4626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<vp.c1> f4627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final r0 f4628c;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(@os.l i iVar, @os.l List<? extends vp.c1> list, @os.m r0 r0Var) {
        kn.l0.p(iVar, "classifierDescriptor");
        kn.l0.p(list, "arguments");
        this.f4626a = iVar;
        this.f4627b = list;
        this.f4628c = r0Var;
    }

    @os.l
    public final List<vp.c1> a() {
        return this.f4627b;
    }

    @os.l
    public final i b() {
        return this.f4626a;
    }

    @os.m
    public final r0 c() {
        return this.f4628c;
    }
}
