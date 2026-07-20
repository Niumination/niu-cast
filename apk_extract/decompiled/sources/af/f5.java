package af;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f288d;

    public f5(float f, float f4) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f288d = atomicInteger;
        this.f287c = (int) (f4 * 1000.0f);
        int i8 = (int) (f * 1000.0f);
        this.f285a = i8;
        this.f286b = i8 / 2;
        atomicInteger.set(i8);
    }

    public final boolean a() {
        AtomicInteger atomicInteger;
        int i8;
        int i9;
        do {
            atomicInteger = this.f288d;
            i8 = atomicInteger.get();
            if (i8 == 0) {
                return false;
            }
            i9 = i8 - 1000;
        } while (!atomicInteger.compareAndSet(i8, Math.max(i9, 0)));
        return i9 > this.f286b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f5)) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return this.f285a == f5Var.f285a && this.f287c == f5Var.f287c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f285a), Integer.valueOf(this.f287c)});
    }
}
