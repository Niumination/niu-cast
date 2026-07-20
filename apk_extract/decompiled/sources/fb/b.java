package fb;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5014b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f5015a = c.f5017b;

    @Override // fb.a
    public final void a(int i8) {
        this.f5015a.a(i8);
    }

    @Override // fb.a
    public final void b(boolean z2) {
        this.f5015a.b(z2);
    }

    @Override // fb.a
    public final void c(Application context, int i8, int i9, int i10) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5015a.c(context, i8, i9, i10);
    }

    @Override // fb.a
    public final void d(Application context, int i8, int i9, int i10, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5015a.d(context, i8, i9, i10, i11);
    }

    @Override // fb.a
    public final void e() {
        this.f5015a.e();
    }
}
