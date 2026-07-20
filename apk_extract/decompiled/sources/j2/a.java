package j2;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a f = new a(10485760, 200, ModuleDescriptor.MODULE_VERSION, 604800000, 81920);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6038d;
    public final int e;

    public a(long j8, int i8, int i9, long j10, int i10) {
        this.f6035a = j8;
        this.f6036b = i8;
        this.f6037c = i9;
        this.f6038d = j10;
        this.e = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6035a == aVar.f6035a && this.f6036b == aVar.f6036b && this.f6037c == aVar.f6037c && this.f6038d == aVar.f6038d && this.e == aVar.e;
    }

    public final int hashCode() {
        long j8 = this.f6035a;
        int i8 = (((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f6036b) * 1000003) ^ this.f6037c) * 1000003;
        long j10 = this.f6038d;
        return this.e ^ ((i8 ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb2.append(this.f6035a);
        sb2.append(", loadBatchSize=");
        sb2.append(this.f6036b);
        sb2.append(", criticalSectionEnterTimeoutMs=");
        sb2.append(this.f6037c);
        sb2.append(", eventCleanUpAge=");
        sb2.append(this.f6038d);
        sb2.append(", maxBlobByteSizePerRow=");
        return h0.a.m(sb2, "}", this.e);
    }
}
