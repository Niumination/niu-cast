package dj;

import java.util.regex.Pattern;
import k3.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4606b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4608d;
    public final Object e;

    public l0(String str, long j8, qj.t source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f4608d = str;
        this.f4607c = j8;
        this.e = source;
    }

    @Override // dj.m0
    public final long a() {
        switch (this.f4606b) {
            case 0:
                break;
        }
        return this.f4607c;
    }

    @Override // dj.m0
    public final x c() {
        switch (this.f4606b) {
            case 0:
                return (x) this.e;
            default:
                String toMediaTypeOrNull = (String) this.f4608d;
                if (toMediaTypeOrNull == null) {
                    return null;
                }
                Pattern pattern = x.f4641d;
                Intrinsics.checkNotNullParameter(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
                try {
                    return w1.a(toMediaTypeOrNull);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }

    @Override // dj.m0
    public final qj.h g() {
        switch (this.f4606b) {
            case 0:
                return (qj.f) this.f4608d;
            default:
                return (qj.t) this.e;
        }
    }

    public l0(qj.f fVar, x xVar, long j8) {
        this.f4608d = fVar;
        this.e = xVar;
        this.f4607c = j8;
    }
}
