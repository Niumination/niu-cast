package sg;

import cg.g;
import kotlin.jvm.internal.Intrinsics;
import zf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f10099a;

    public b(z value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f10099a = value;
    }

    @Override // cg.j
    public final z d() {
        return this.f10099a;
    }

    public final String toString() {
        return "HttpStatusCodeContent(" + this.f10099a + ')';
    }
}
