package ul;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import kn.l1;
import kn.w;
import kn.x0;
import lm.y;
import os.l;
import os.m;
import tl.o0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public class b extends tl.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public final bm.h<b> f16319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final qn.f f16320g;

    @l
    private volatile /* synthetic */ Object nextRef;

    @l
    private volatile /* synthetic */ int refCount;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f16312n = {l1.k(new x0(b.class, n1.d.a.f11176d, "getOrigin()Lio/ktor/utils/io/core/internal/ChunkBuffer;", 0))};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public static final e f16311i = new e();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public static final bm.h<b> f16315w = new d();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public static final bm.h<b> f16316x = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @l
    public static final bm.h<b> f16317y = new C0436b();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final bm.h<b> f16318z = new c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f16313p = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "nextRef");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f16314v = AtomicIntegerFieldUpdater.newUpdater(b.class, "refCount");

    public static final class a implements bm.h<b> {

        /* JADX INFO: renamed from: ul.b$a$a, reason: collision with other inner class name */
        public static final class C0435a extends h {
            @Override // ul.h
            @l
            public Void a() {
                throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.");
            }
        }

        @Override // bm.h
        public int Q1() {
            return 1;
        }

        @Override // bm.h
        public b W0() {
            return b.f16311i.a();
        }

        @l
        public b b() {
            return b.f16311i.a();
        }

        @Override // bm.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void recycle(@l b bVar) {
            l0.p(bVar, "instance");
            if (bVar == b.f16311i.a()) {
                return;
            }
            new C0435a().a();
            throw new y();
        }

        @Override // bm.h, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            bm.h.a.a(this);
        }

        @Override // bm.h
        public void dispose() {
        }
    }

    /* JADX INFO: renamed from: ul.b$b, reason: collision with other inner class name */
    public static final class C0436b extends bm.g<b> {
        @Override // bm.h
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b W0() {
            return new o0(ql.e.f14042a.c(4096), (b) null, this);
        }

        @Override // bm.g, bm.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void recycle(@l b bVar) {
            l0.p(bVar, "instance");
            if (!(bVar instanceof o0)) {
                throw new IllegalArgumentException("Only IoBuffer instances can be recycled.");
            }
            ql.e.f14042a.a(bVar.f15820a);
        }
    }

    public static final class c extends bm.g<b> {
        @Override // bm.h
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b W0() {
            throw new UnsupportedOperationException("This pool doesn't support borrow");
        }

        @Override // bm.g, bm.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void recycle(@l b bVar) {
            l0.p(bVar, "instance");
        }
    }

    public static final class d implements bm.h<b> {
        @Override // bm.h
        public int Q1() {
            return tl.h.a().Q1();
        }

        @Override // bm.h
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b W0() {
            return tl.h.a().W0();
        }

        @Override // bm.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void recycle(@l b bVar) {
            l0.p(bVar, "instance");
            if (!(bVar instanceof o0)) {
                throw new IllegalArgumentException("Only IoBuffer instances can be recycled.");
            }
            tl.h.a().recycle(bVar);
        }

        @Override // bm.h, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            bm.h.a.a(this);
        }

        @Override // bm.h
        public void dispose() {
            tl.h.a().dispose();
        }
    }

    public static final class e {
        public e() {
        }

        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ void e() {
        }

        @l
        public final b a() {
            o0.H.getClass();
            return o0.L;
        }

        @l
        public final bm.h<b> c() {
            return b.f16316x;
        }

        @l
        public final bm.h<b> d() {
            return b.f16317y;
        }

        @l
        public final bm.h<b> f() {
            return b.f16318z;
        }

        @l
        public final bm.h<b> g() {
            return b.f16315w;
        }

        public e(w wVar) {
        }
    }

    public static final class f extends h {
        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException("Unable to reset buffer with origin");
        }
    }

    public static final class g extends h {
        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException("A chunk couldn't be a view of itself.");
        }
    }

    public b(ByteBuffer byteBuffer, b bVar, bm.h<b> hVar) {
        super(byteBuffer);
        this.f16319f = hVar;
        if (!(bVar != this)) {
            new g().a();
            throw new y();
        }
        this.nextRef = null;
        this.refCount = 1;
        this.f16320g = new sl.b.a(bVar);
    }

    public final void J1() {
        int i10;
        do {
            i10 = this.refCount;
            if (i10 <= 0) {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!f16314v.compareAndSet(this, i10, i10 + 1));
    }

    public final void S1(b bVar) {
        if (!j.d.a(f16313p, this, null, bVar)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    @m
    public final b Y1() {
        return (b) f16313p.getAndSet(this, null);
    }

    @Override // tl.e
    @l
    /* JADX INFO: renamed from: b2 */
    public b o() {
        b bVarG2 = g2();
        if (bVarG2 == null) {
            bVarG2 = this;
        }
        bVarG2.J1();
        b bVar = new b(this.f15820a, bVarG2, this.f16319f);
        p(bVar);
        return bVar;
    }

    @m
    public final b f2() {
        return (b) this.nextRef;
    }

    @m
    public final b g2() {
        return (b) this.f16320g.a(this, f16312n[0]);
    }

    @m
    public final bm.h<b> h2() {
        return this.f16319f;
    }

    public final int i2() {
        return this.refCount;
    }

    public void j2(@l bm.h<b> hVar) {
        l0.p(hVar, "pool");
        if (k2()) {
            b bVarG2 = g2();
            if (bVarG2 != null) {
                n2();
                bVarG2.j2(hVar);
            } else {
                bm.h<b> hVar2 = this.f16319f;
                if (hVar2 != null) {
                    hVar = hVar2;
                }
                hVar.recycle(this);
            }
        }
    }

    public final boolean k2() {
        int i10;
        int i11;
        do {
            i10 = this.refCount;
            if (i10 <= 0) {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
            i11 = i10 - 1;
        } while (!f16314v.compareAndSet(this, i10, i11));
        return i11 == 0;
    }

    public final void l2(@m b bVar) {
        if (bVar == null) {
            Y1();
        } else {
            S1(bVar);
        }
    }

    public final void m2(b bVar) {
        this.f16320g.b(this, f16312n[0], bVar);
    }

    public final void n2() {
        if (!f16314v.compareAndSet(this, 0, -1)) {
            throw new IllegalStateException("Unable to unlink: buffer is in use.");
        }
        Y1();
        m2(null);
    }

    public final void o2() {
        int i10;
        do {
            i10 = this.refCount;
            if (i10 < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
            if (i10 > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!f16314v.compareAndSet(this, i10, 1));
    }

    @Override // tl.e
    public final void reset() {
        if (!(g2() == null)) {
            new f().a();
            throw new y();
        }
        super.reset();
        this.f15821b.f15876e = null;
        this.nextRef = null;
    }

    public /* synthetic */ b(ByteBuffer byteBuffer, b bVar, bm.h hVar, w wVar) {
        this(byteBuffer, bVar, hVar);
    }
}
