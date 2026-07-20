package kf;

import jh.n;
import jh.o;
import k3.fa;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import zf.r;
import zf.t;
import zf.y;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends wf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6862a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f6863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f6864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f6865d;
    public final ch.d e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ch.d f6866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f6867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f6868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r f6869k;

    public i(c call, vf.g responseData) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        this.f6867i = call;
        this.f6863b = responseData.f;
        this.f6864c = responseData.f10573a;
        this.f6865d = responseData.f10576d;
        this.e = responseData.f10574b;
        this.f6866h = responseData.f10577g;
        Object obj = responseData.e;
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar == null) {
            o.f6299a.getClass();
            oVar = n.f6298b;
        }
        this.f6868j = oVar;
        this.f6869k = responseData.f10575c;
    }

    @Override // zf.w
    public final r a() {
        switch (this.f6862a) {
            case 0:
                return this.f6869k;
            default:
                return (t) this.f6869k;
        }
    }

    @Override // wf.b
    public final c b() {
        switch (this.f6862a) {
            case 0:
                return (g) this.f6867i;
            default:
                return this.f6867i;
        }
    }

    @Override // wf.b
    public final o d() {
        switch (this.f6862a) {
            case 0:
                return fa.a((byte[]) this.f6868j);
            default:
                return (o) this.f6868j;
        }
    }

    @Override // wf.b
    public final ch.d e() {
        switch (this.f6862a) {
            case 0:
                break;
        }
        return this.e;
    }

    @Override // wf.b
    public final ch.d f() {
        switch (this.f6862a) {
            case 0:
                break;
        }
        return this.f6866h;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        switch (this.f6862a) {
            case 0:
                break;
        }
        return this.f6863b;
    }

    @Override // wf.b
    public final z h() {
        switch (this.f6862a) {
            case 0:
                break;
        }
        return this.f6864c;
    }

    @Override // wf.b
    public final y j() {
        switch (this.f6862a) {
            case 0:
                break;
        }
        return this.f6865d;
    }

    public i(g call, byte[] body, wf.b origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f6867i = call;
        this.f6868j = body;
        this.f6864c = origin.h();
        this.f6865d = origin.j();
        this.e = origin.e();
        this.f6866h = origin.f();
        this.f6869k = origin.a();
        this.f6863b = origin.getCoroutineContext();
    }
}
