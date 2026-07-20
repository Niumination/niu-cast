package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wi.k f760b;

    public c0(wi.k body, int i8) {
        this.f759a = i8;
        switch (i8) {
            case 1:
                Intrinsics.checkNotNullParameter(body, "body");
                this.f760b = body;
                break;
            default:
                Intrinsics.checkNotNullParameter(body, "body");
                this.f760b = body;
                break;
        }
    }

    @Override // ag.g0
    public final void a() throws Exception {
        switch (this.f759a) {
            case 0:
                this.f760b.close();
                break;
            default:
                this.f760b.close();
                break;
        }
    }
}
