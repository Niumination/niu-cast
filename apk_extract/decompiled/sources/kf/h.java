package kf;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import zf.r;
import zf.r0;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements vf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6860a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vf.b f6861b;

    public h(g call, vf.b origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f6861b = origin;
    }

    @Override // vf.b
    public final x X() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.X();
    }

    @Override // zf.w
    public final r a() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.a();
    }

    @Override // vf.b
    public final cg.j getContent() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.getContent();
    }

    @Override // vf.b, li.g0
    public final CoroutineContext getCoroutineContext() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.getCoroutineContext();
    }

    @Override // vf.b
    public final r0 getUrl() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.getUrl();
    }

    @Override // vf.b
    public final zg.h i() {
        switch (this.f6860a) {
            case 0:
                break;
        }
        return this.f6861b.i();
    }

    public h(sf.d call, vf.b origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f6861b = origin;
    }
}
