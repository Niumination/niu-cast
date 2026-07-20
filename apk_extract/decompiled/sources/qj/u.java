package qj;

import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9227d;
    public final boolean e;
    public u f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u f9228g;

    public u() {
        this.f9224a = new byte[8192];
        this.e = true;
        this.f9227d = false;
    }

    public final u a() {
        u uVar = this.f;
        if (uVar == this) {
            uVar = null;
        }
        u uVar2 = this.f9228g;
        Intrinsics.checkNotNull(uVar2);
        uVar2.f = this.f;
        u uVar3 = this.f;
        Intrinsics.checkNotNull(uVar3);
        uVar3.f9228g = this.f9228g;
        this.f = null;
        this.f9228g = null;
        return uVar;
    }

    public final void b(u segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f9228g = this;
        segment.f = this.f;
        u uVar = this.f;
        Intrinsics.checkNotNull(uVar);
        uVar.f9228g = segment;
        this.f = segment;
    }

    public final u c() {
        this.f9227d = true;
        return new u(this.f9224a, this.f9225b, this.f9226c, true);
    }

    public final void d(u sink, int i8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i9 = sink.f9226c;
        int i10 = i9 + i8;
        byte[] bArr = sink.f9224a;
        if (i10 > 8192) {
            if (sink.f9227d) {
                throw new IllegalArgumentException();
            }
            int i11 = sink.f9225b;
            if (i10 - i11 > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i11, i9, 2, (Object) null);
            sink.f9226c -= sink.f9225b;
            sink.f9225b = 0;
        }
        int i12 = sink.f9226c;
        int i13 = this.f9225b;
        ArraysKt.copyInto(this.f9224a, bArr, i12, i13, i13 + i8);
        sink.f9226c += i8;
        this.f9225b += i8;
    }

    public u(byte[] data, int i8, int i9, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f9224a = data;
        this.f9225b = i8;
        this.f9226c = i9;
        this.f9227d = z2;
        this.e = false;
    }
}
