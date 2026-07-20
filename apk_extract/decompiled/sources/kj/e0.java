package kj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f6909b = new int[10];

    public final int a() {
        if ((this.f6908a & 128) != 0) {
            return this.f6909b[7];
        }
        return 65535;
    }

    public final void b(e0 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i8 = 0; i8 < 10; i8++) {
            if (((1 << i8) & other.f6908a) != 0) {
                c(i8, other.f6909b[i8]);
            }
        }
    }

    public final void c(int i8, int i9) {
        if (i8 >= 0) {
            int[] iArr = this.f6909b;
            if (i8 >= iArr.length) {
                return;
            }
            this.f6908a = (1 << i8) | this.f6908a;
            iArr[i8] = i9;
        }
    }
}
