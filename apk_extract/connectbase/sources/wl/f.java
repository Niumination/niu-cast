package wl;

import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final bm.h<ByteBuffer> f19701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final bm.h<h.c> f19702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final bm.h<h.c> f19703f;

    public static final class a extends bm.g<h.c> {
        @Override // bm.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h.c W0() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(f.a());
            l0.o(byteBufferAllocateDirect, "allocateDirect(BUFFER_SIZE)");
            return new h.c(byteBufferAllocateDirect, 0, 2, null);
        }
    }

    public static final class b extends bm.d<h.c> {
        public b(int i10) {
            super(i10);
        }

        @Override // bm.d
        @os.l
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public h.c n() {
            return new h.c(f.d().W0(), 0, 2, null);
        }

        @Override // bm.d
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public void h(@os.l h.c cVar) {
            l0.p(cVar, "instance");
            f.d().recycle(cVar.f19707a);
        }
    }

    static {
        int iA = n.a("BufferSize", 4096);
        f19698a = iA;
        int iA2 = n.a("BufferPoolSize", 2048);
        f19699b = iA2;
        int iA3 = n.a("BufferObjectPoolSize", 1024);
        f19700c = iA3;
        f19701d = new bm.f(iA2, iA);
        f19702e = new b(iA3);
        f19703f = new a();
    }

    public static final int a() {
        return f19698a;
    }

    @os.l
    public static final bm.h<h.c> b() {
        return f19703f;
    }

    @os.l
    public static final bm.h<h.c> c() {
        return f19702e;
    }

    @os.l
    public static final bm.h<ByteBuffer> d() {
        return f19701d;
    }
}
