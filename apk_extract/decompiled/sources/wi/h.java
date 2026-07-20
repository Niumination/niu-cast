package wi;

import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f10776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f10779d;
    public boolean e;
    public h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f10780g;

    public h() {
        this.f10776a = new byte[8192];
        this.e = true;
        this.f10779d = null;
    }

    public final /* synthetic */ int a() {
        return this.f10776a.length - this.f10778c;
    }

    public final /* synthetic */ int b() {
        return this.f10778c - this.f10777b;
    }

    public final h c() {
        h hVar = this.f;
        h hVar2 = this.f10780g;
        if (hVar2 != null) {
            Intrinsics.checkNotNull(hVar2);
            hVar2.f = this.f;
        }
        h hVar3 = this.f;
        if (hVar3 != null) {
            Intrinsics.checkNotNull(hVar3);
            hVar3.f10780g = this.f10780g;
        }
        this.f = null;
        this.f10780g = null;
        return hVar;
    }

    public final void d(h segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f10780g = this;
        segment.f = this.f;
        h hVar = this.f;
        if (hVar != null) {
            Intrinsics.checkNotNull(hVar);
            hVar.f10780g = segment;
        }
        this.f = segment;
    }

    public final h e() {
        q gVar = this.f10779d;
        if (gVar == null) {
            h hVar = i.f10781a;
            gVar = new g();
            this.f10779d = gVar;
        }
        int i8 = this.f10777b;
        int i9 = this.f10778c;
        g.f10774c.incrementAndGet((g) gVar);
        Unit unit = Unit.INSTANCE;
        return new h(this.f10776a, i8, i9, gVar);
    }

    public final void f(h sink, int i8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.e) {
            throw new IllegalStateException("only owner can write");
        }
        if (sink.f10778c + i8 > 8192) {
            q qVar = sink.f10779d;
            if (qVar != null && ((g) qVar).f10775b > 0) {
                throw new IllegalArgumentException();
            }
            int i9 = sink.f10778c;
            int i10 = sink.f10777b;
            if ((i9 + i8) - i10 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f10776a;
            ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr, 0, i10, i9, 2, (Object) null);
            sink.f10778c -= sink.f10777b;
            sink.f10777b = 0;
        }
        int i11 = sink.f10778c;
        int i12 = this.f10777b;
        ArraysKt.copyInto(this.f10776a, sink.f10776a, i11, i12, i12 + i8);
        sink.f10778c += i8;
        this.f10777b += i8;
    }

    public h(byte[] bArr, int i8, int i9, q qVar) {
        this.f10776a = bArr;
        this.f10777b = i8;
        this.f10778c = i9;
        this.f10779d = qVar;
        this.e = false;
    }
}
