package dj;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f4515n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4519d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4526m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public c(boolean z2, boolean z3, int i8, int i9, boolean z5, boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, String str) {
        this.f4516a = z2;
        this.f4517b = z3;
        this.f4518c = i8;
        this.f4519d = i9;
        this.e = z5;
        this.f = z10;
        this.f4520g = z11;
        this.f4521h = i10;
        this.f4522i = i11;
        this.f4523j = z12;
        this.f4524k = z13;
        this.f4525l = z14;
        this.f4526m = str;
    }

    public final String toString() {
        String str = this.f4526m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f4516a) {
            sb2.append("no-cache, ");
        }
        if (this.f4517b) {
            sb2.append("no-store, ");
        }
        int i8 = this.f4518c;
        if (i8 != -1) {
            sb2.append("max-age=");
            sb2.append(i8);
            sb2.append(", ");
        }
        int i9 = this.f4519d;
        if (i9 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i9);
            sb2.append(", ");
        }
        if (this.e) {
            sb2.append("private, ");
        }
        if (this.f) {
            sb2.append("public, ");
        }
        if (this.f4520g) {
            sb2.append("must-revalidate, ");
        }
        int i10 = this.f4521h;
        if (i10 != -1) {
            sb2.append("max-stale=");
            sb2.append(i10);
            sb2.append(", ");
        }
        int i11 = this.f4522i;
        if (i11 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i11);
            sb2.append(", ");
        }
        if (this.f4523j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f4524k) {
            sb2.append("no-transform, ");
        }
        if (this.f4525l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.f4526m = string;
        return string;
    }
}
