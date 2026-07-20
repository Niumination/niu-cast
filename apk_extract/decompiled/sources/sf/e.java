package sf;

import jh.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zf.r;
import zf.y;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends wf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f10091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f10092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.b f10093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f10094d;
    public final CoroutineContext e;

    public e(d call, Function0 block, wf.b origin, r headers) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f10091a = call;
        this.f10092b = block;
        this.f10093c = origin;
        this.f10094d = headers;
        this.e = origin.getCoroutineContext();
    }

    @Override // zf.w
    public final r a() {
        return this.f10094d;
    }

    @Override // wf.b
    public final kf.c b() {
        return this.f10091a;
    }

    @Override // wf.b
    public final o d() {
        return (o) this.f10092b.invoke();
    }

    @Override // wf.b
    public final ch.d e() {
        return this.f10093c.e();
    }

    @Override // wf.b
    public final ch.d f() {
        return this.f10093c.f();
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.e;
    }

    @Override // wf.b
    public final z h() {
        return this.f10093c.h();
    }

    @Override // wf.b
    public final y j() {
        return this.f10093c.j();
    }
}
