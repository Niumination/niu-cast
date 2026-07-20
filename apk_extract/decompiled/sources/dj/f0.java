package dj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f4535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4536c;

    public /* synthetic */ f0(Object obj, x xVar, int i8) {
        this.f4534a = i8;
        this.f4536c = obj;
        this.f4535b = xVar;
    }

    @Override // dj.h0
    public final long a() {
        switch (this.f4534a) {
            case 0:
                return ((qj.j) this.f4536c).size();
            default:
                return ((h0) this.f4536c).a();
        }
    }

    @Override // dj.h0
    public final x b() {
        switch (this.f4534a) {
            case 0:
                break;
        }
        return this.f4535b;
    }

    @Override // dj.h0
    public final void c(qj.g sink) {
        switch (this.f4534a) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.z((qj.j) this.f4536c);
                break;
            default:
                ((h0) this.f4536c).c(sink);
                break;
        }
    }
}
