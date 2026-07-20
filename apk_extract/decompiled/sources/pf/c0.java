package pf;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements vf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zf.x f8831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zf.r0 f8832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zg.h f8833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zf.t f8834d;
    public final /* synthetic */ vf.c e;

    public c0(vf.c cVar) {
        this.e = cVar;
        this.f8831a = cVar.f10558b;
        this.f8832b = cVar.f10557a.b();
        this.f8833c = cVar.f;
        this.f8834d = cVar.f10559c.o();
    }

    @Override // vf.b
    public final zf.x X() {
        return this.f8831a;
    }

    @Override // zf.w
    public final zf.r a() {
        return this.f8834d;
    }

    @Override // vf.b
    public final cg.j getContent() {
        vf.c cVar = this.e;
        Object obj = cVar.f10560d;
        cg.j jVar = obj instanceof cg.j ? (cg.j) obj : null;
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + cVar.f10560d).toString());
    }

    @Override // vf.b, li.g0
    public final CoroutineContext getCoroutineContext() {
        throw new IllegalStateException("Call is not initialized");
    }

    @Override // vf.b
    public final zf.r0 getUrl() {
        return this.f8832b;
    }

    @Override // vf.b
    public final zg.h i() {
        return this.f8833c;
    }
}
