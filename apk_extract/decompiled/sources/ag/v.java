package ag;

import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg.c f792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f794c;

    public v(bg.c builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f792a = builder;
        this.f794c = (int[]) w.f796b.R();
    }

    public final int a(int i8) {
        Intrinsics.checkNotNullParameter("Content-Length", "name");
        se.e eVar = bg.g.f1321a;
        int iB = bg.g.b("Content-Length", 0, "Content-Length".length());
        int i9 = this.f793b;
        while (i8 < i9) {
            if (this.f794c[i8 * 8] == iB) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public final bg.b b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        se.e eVar = bg.g.f1321a;
        int iB = bg.g.b(name, 0, name.length());
        int i8 = this.f793b;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9 * 8;
            int[] iArr = this.f794c;
            if (iArr[i10] == iB) {
                return (bg.b) this.f792a.subSequence(iArr[i10 + 4], iArr[i10 + 5]);
            }
        }
        return null;
    }

    public final bg.b c(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i8 >= this.f793b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i9 = i8 * 8;
        int[] iArr = this.f794c;
        return (bg.b) this.f792a.subSequence(iArr[i9 + 2], iArr[i9 + 3]);
    }

    public final void d(int i8, int i9, int i10, int i11, int i12, int i13) {
        int i14 = this.f793b;
        int i15 = i14 * 8;
        int[] iArr = this.f794c;
        if (i15 >= iArr.length) {
            throw new NotImplementedError("An operation is not implemented: Implement headers overflow");
        }
        iArr[i15] = i8;
        iArr[i15 + 1] = i9;
        iArr[i15 + 2] = i10;
        iArr[i15 + 3] = i11;
        iArr[i15 + 4] = i12;
        iArr[i15 + 5] = i13;
        iArr[i15 + 6] = -1;
        iArr[i15 + 7] = -1;
        this.f793b = i14 + 1;
    }

    public final void e() {
        this.f793b = 0;
        int[] iArr = this.f794c;
        int[] iArr2 = w.f795a;
        this.f794c = iArr2;
        if (iArr != iArr2) {
            w.f796b.h0(iArr);
        }
    }

    public final bg.b f(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i8 >= this.f793b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i9 = i8 * 8;
        int[] iArr = this.f794c;
        return (bg.b) this.f792a.subSequence(iArr[i9 + 4], iArr[i9 + 5]);
    }

    public final String toString() {
        StringBuilder out = new StringBuilder();
        int[] iArr = w.f795a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter("", "indent");
        Intrinsics.checkNotNullParameter(out, "out");
        int i8 = this.f793b;
        for (int i9 = 0; i9 < i8; i9++) {
            out.append((CharSequence) "");
            out.append((CharSequence) c(i9));
            out.append((CharSequence) " => ");
            out.append((CharSequence) f(i9));
            out.append((CharSequence) "\n");
        }
        String string = out.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
