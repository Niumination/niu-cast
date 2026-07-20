package wl;

import java.nio.ByteBuffer;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final ByteBuffer f19707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public final j f19708b;

    public static final class a extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final a f19709c = new a();

        public a() {
            super(i.a(), i.f19723c);
        }

        @Override // wl.h
        public boolean a() {
            return true;
        }

        @os.l
        public String toString() {
            return "IDLE(empty)";
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final c f19710c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l c cVar) {
            super(cVar.f19707a, cVar.f19708b);
            l0.p(cVar, "initial");
            this.f19710c = cVar;
        }

        @Override // wl.h
        public boolean a() {
            return true;
        }

        @Override // wl.h
        public h d() {
            return this.f19710c.f19714f;
        }

        @Override // wl.h
        public h e() {
            return this.f19710c.f19715g;
        }

        @os.l
        public final c h() {
            return this.f19710c;
        }

        @os.l
        public d i() {
            return this.f19710c.f19714f;
        }

        @os.l
        public g j() {
            return this.f19710c.f19715g;
        }

        @os.l
        public String toString() {
            return "IDLE(with buffer)";
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final ByteBuffer f19711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final ByteBuffer f19712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final b f19713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final d f19714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final g f19715g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final e f19716h;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i10, int i11, w wVar) {
            this(byteBuffer, (i11 & 2) != 0 ? 8 : i10);
        }

        @Override // wl.h
        public boolean a() {
            throw new IllegalStateException("Not available for initial state");
        }

        @Override // wl.h
        @os.l
        public ByteBuffer b() {
            return this.f19712d;
        }

        @Override // wl.h
        @os.l
        public ByteBuffer c() {
            return this.f19711c;
        }

        @Override // wl.h
        public h d() {
            return this.f19714f;
        }

        @Override // wl.h
        public h e() {
            return this.f19715g;
        }

        @os.l
        public final b h() {
            return this.f19713e;
        }

        @os.l
        public final d i() {
            return this.f19714f;
        }

        @os.l
        public final e j() {
            return this.f19716h;
        }

        @os.l
        public final g k() {
            return this.f19715g;
        }

        @os.l
        public d l() {
            return this.f19714f;
        }

        @os.l
        public g m() {
            return this.f19715g;
        }

        @os.l
        public String toString() {
            return "Initial";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@os.l ByteBuffer byteBuffer, int i10) {
            super(byteBuffer, new j(byteBuffer.capacity() - i10));
            l0.p(byteBuffer, "backingBuffer");
            if (byteBuffer.position() != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (byteBuffer.limit() != byteBuffer.capacity()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            l0.o(byteBufferDuplicate, "backingBuffer.duplicate()");
            this.f19711c = byteBufferDuplicate;
            ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
            l0.o(byteBufferDuplicate2, "backingBuffer.duplicate()");
            this.f19712d = byteBufferDuplicate2;
            this.f19713e = new b(this);
            this.f19714f = new d(this);
            this.f19715g = new g(this);
            this.f19716h = new e(this);
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final c f19717c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l c cVar) {
            super(cVar.f19707a, cVar.f19708b);
            l0.p(cVar, "initial");
            this.f19717c = cVar;
        }

        @Override // wl.h
        @os.l
        public ByteBuffer b() {
            return this.f19717c.f19712d;
        }

        @Override // wl.h
        public h e() {
            return this.f19717c.f19716h;
        }

        @Override // wl.h
        public h f() {
            return this.f19717c.f19713e;
        }

        @os.l
        public e h() {
            return this.f19717c.f19716h;
        }

        @os.l
        public b i() {
            return this.f19717c.f19713e;
        }

        @os.l
        public String toString() {
            return "Reading";
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final c f19718c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@os.l c cVar) {
            super(cVar.f19707a, cVar.f19708b);
            l0.p(cVar, "initial");
            this.f19718c = cVar;
        }

        @Override // wl.h
        @os.l
        public ByteBuffer b() {
            return this.f19718c.f19712d;
        }

        @Override // wl.h
        @os.l
        public ByteBuffer c() {
            return this.f19718c.f19711c;
        }

        @Override // wl.h
        public h f() {
            return this.f19718c.f19715g;
        }

        @Override // wl.h
        public h g() {
            return this.f19718c.f19714f;
        }

        @os.l
        public g h() {
            return this.f19718c.f19715g;
        }

        @os.l
        public d i() {
            return this.f19718c.f19714f;
        }

        @os.l
        public String toString() {
            return "Reading+Writing";
        }
    }

    public static final class f extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final f f19719c = new f();

        public f() {
            super(i.a(), i.f19723c);
        }

        @os.l
        public String toString() {
            return "Terminated";
        }
    }

    public static final class g extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final c f19720c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@os.l c cVar) {
            super(cVar.f19707a, cVar.f19708b);
            l0.p(cVar, "initial");
            this.f19720c = cVar;
        }

        @Override // wl.h
        @os.l
        public ByteBuffer c() {
            return this.f19720c.f19711c;
        }

        @Override // wl.h
        public h d() {
            return this.f19720c.f19716h;
        }

        @Override // wl.h
        public h g() {
            return this.f19720c.f19713e;
        }

        @os.l
        public e h() {
            return this.f19720c.f19716h;
        }

        @os.l
        public b i() {
            return this.f19720c.f19713e;
        }

        @os.l
        public String toString() {
            return "Writing";
        }
    }

    public /* synthetic */ h(ByteBuffer byteBuffer, j jVar, w wVar) {
        this(byteBuffer, jVar);
    }

    public boolean a() {
        return false;
    }

    @os.l
    public ByteBuffer b() {
        throw new IllegalStateException(l0.C("read buffer is not available in state ", this).toString());
    }

    @os.l
    public ByteBuffer c() {
        throw new IllegalStateException(l0.C("write buffer is not available in state ", this).toString());
    }

    @os.l
    public h d() {
        throw new IllegalStateException(l0.C("Reading is not available in state ", this).toString());
    }

    @os.l
    public h e() {
        throw new IllegalStateException(l0.C("Writing is not available in state ", this).toString());
    }

    @os.l
    public h f() {
        throw new IllegalStateException(l0.C("Unable to stop reading in state ", this).toString());
    }

    @os.l
    public h g() {
        throw new IllegalStateException(l0.C("Unable to stop writing in state ", this).toString());
    }

    public h(ByteBuffer byteBuffer, j jVar) {
        this.f19707a = byteBuffer;
        this.f19708b = jVar;
    }
}
