package wj;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class w extends wj.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f<Void> f19406f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f<Void> f19407g = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f<byte[]> f19408i = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f<ByteBuffer> f19409n = new d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final g<OutputStream> f19410p = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<i2> f19411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque<i2> f19412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<i2> f19414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19415e;

    public class a implements f<Void> {
        @Override // wj.w.f, wj.w.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(i2 i2Var, int i10, Void r10, int i11) {
            return i2Var.readUnsignedByte();
        }
    }

    public class b implements f<Void> {
        @Override // wj.w.f, wj.w.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(i2 i2Var, int i10, Void r10, int i11) {
            i2Var.skipBytes(i10);
            return 0;
        }
    }

    public class c implements f<byte[]> {
        @Override // wj.w.f, wj.w.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(i2 i2Var, int i10, byte[] bArr, int i11) {
            i2Var.p1(bArr, i11, i10);
            return i11 + i10;
        }
    }

    public class d implements f<ByteBuffer> {
        @Override // wj.w.f, wj.w.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(i2 i2Var, int i10, ByteBuffer byteBuffer, int i11) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            i2Var.B0(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    public class e implements g<OutputStream> {
        @Override // wj.w.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(i2 i2Var, int i10, OutputStream outputStream, int i11) throws IOException {
            i2Var.P1(outputStream, i10);
            return 0;
        }
    }

    public interface f<T> extends g<T> {
        @Override // wj.w.g
        int a(i2 i2Var, int i10, T t10, int i11);
    }

    public interface g<T> {
        int a(i2 i2Var, int i10, T t10, int i11) throws IOException;
    }

    public w() {
        this.f19414d = new ArrayDeque(2);
        this.f19411a = new ArrayDeque();
    }

    @Override // wj.i2
    public void B0(ByteBuffer byteBuffer) {
        o(f19409n, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // wj.i2
    public void P1(OutputStream outputStream, int i10) throws IOException {
        n(f19410p, i10, outputStream, 0);
    }

    public void c(i2 i2Var) {
        boolean z10 = this.f19415e && this.f19411a.isEmpty();
        k(i2Var);
        if (z10) {
            this.f19411a.peek().y1();
        }
    }

    @Override // wj.b, wj.i2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f19411a.isEmpty()) {
            this.f19411a.remove().close();
        }
        if (this.f19412b != null) {
            while (!this.f19412b.isEmpty()) {
                this.f19412b.remove().close();
            }
        }
    }

    public final void d() {
        if (!this.f19415e) {
            this.f19411a.remove().close();
            return;
        }
        this.f19412b.add(this.f19411a.remove());
        i2 i2VarPeek = this.f19411a.peek();
        if (i2VarPeek != null) {
            i2VarPeek.y1();
        }
    }

    @Override // wj.i2
    public int e() {
        return this.f19413c;
    }

    public final void h() {
        if (this.f19411a.peek().e() == 0) {
            d();
        }
    }

    @Override // wj.b, wj.i2
    @gm.j
    public ByteBuffer i() {
        if (this.f19411a.isEmpty()) {
            return null;
        }
        return this.f19411a.peek().i();
    }

    public final void k(i2 i2Var) {
        if (!(i2Var instanceof w)) {
            this.f19411a.add(i2Var);
            this.f19413c = i2Var.e() + this.f19413c;
            return;
        }
        w wVar = (w) i2Var;
        while (!wVar.f19411a.isEmpty()) {
            this.f19411a.add(wVar.f19411a.remove());
        }
        this.f19413c += wVar.f19413c;
        wVar.f19413c = 0;
        wVar.close();
    }

    @Override // wj.b, wj.i2
    public boolean l() {
        Iterator<i2> it = this.f19411a.iterator();
        while (it.hasNext()) {
            if (!it.next().l()) {
                return false;
            }
        }
        return true;
    }

    @Override // wj.b, wj.i2
    public boolean markSupported() {
        Iterator<i2> it = this.f19411a.iterator();
        while (it.hasNext()) {
            if (!it.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    public final <T> int n(g<T> gVar, int i10, T t10, int i11) throws IOException {
        b(i10);
        if (!this.f19411a.isEmpty()) {
            h();
        }
        while (i10 > 0 && !this.f19411a.isEmpty()) {
            i2 i2VarPeek = this.f19411a.peek();
            int iMin = Math.min(i10, i2VarPeek.e());
            i11 = gVar.a(i2VarPeek, iMin, t10, i11);
            i10 -= iMin;
            this.f19413c -= iMin;
            h();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public final <T> int o(f<T> fVar, int i10, T t10, int i11) {
        try {
            return n(fVar, i10, t10, i11);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public void p(w wVar, int i10) {
        b(i10);
        this.f19413c -= i10;
        while (i10 > 0) {
            i2 i2VarPeek = this.f19414d.peek();
            if (i2VarPeek.e() > i10) {
                wVar.c(i2VarPeek.u(i10));
                i10 = 0;
            } else {
                wVar.c(this.f19414d.poll());
                i10 -= i2VarPeek.e();
            }
        }
    }

    @Override // wj.i2
    public void p1(byte[] bArr, int i10, int i11) {
        o(f19408i, i11, bArr, i10);
    }

    @Override // wj.i2
    public int readUnsignedByte() {
        return o(f19406f, 1, null, 0);
    }

    @Override // wj.b, wj.i2
    public void reset() {
        if (!this.f19415e) {
            throw new InvalidMarkException();
        }
        i2 i2VarPeek = this.f19411a.peek();
        if (i2VarPeek != null) {
            int iE = i2VarPeek.e();
            i2VarPeek.reset();
            this.f19413c = (i2VarPeek.e() - iE) + this.f19413c;
        }
        while (true) {
            i2 i2VarPollLast = this.f19412b.pollLast();
            if (i2VarPollLast == null) {
                return;
            }
            i2VarPollLast.reset();
            this.f19411a.addFirst(i2VarPollLast);
            this.f19413c = i2VarPollLast.e() + this.f19413c;
        }
    }

    @Override // wj.i2
    public void skipBytes(int i10) {
        o(f19407g, i10, null, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [wj.i2] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [wj.i2] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [wj.w] */
    /* JADX WARN: Type inference failed for: r1v3, types: [wj.w] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // wj.i2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public wj.i2 u(int r7) {
        /*
            r6 = this;
            if (r7 > 0) goto L7
            wj.i2 r6 = wj.j2.a()
            return r6
        L7:
            r6.b(r7)
            int r0 = r6.f19413c
            int r0 = r0 - r7
            r6.f19413c = r0
            r0 = 0
            r1 = r0
        L11:
            java.util.Deque<wj.i2> r2 = r6.f19411a
            java.lang.Object r2 = r2.peek()
            wj.i2 r2 = (wj.i2) r2
            int r3 = r2.e()
            if (r3 <= r7) goto L25
            wj.i2 r7 = r2.u(r7)
            r2 = 0
            goto L3d
        L25:
            boolean r4 = r6.f19415e
            if (r4 == 0) goto L31
            wj.i2 r2 = r2.u(r3)
            r6.d()
            goto L39
        L31:
            java.util.Deque<wj.i2> r2 = r6.f19411a
            java.lang.Object r2 = r2.poll()
            wj.i2 r2 = (wj.i2) r2
        L39:
            int r7 = r7 - r3
            r5 = r2
            r2 = r7
            r7 = r5
        L3d:
            if (r0 != 0) goto L41
            r0 = r7
            goto L60
        L41:
            if (r1 != 0) goto L5d
            wj.w r1 = new wj.w
            r3 = 2
            if (r2 != 0) goto L49
            goto L56
        L49:
            java.util.Deque<wj.i2> r4 = r6.f19411a
            int r4 = r4.size()
            int r4 = r4 + r3
            r3 = 16
            int r3 = java.lang.Math.min(r4, r3)
        L56:
            r1.<init>(r3)
            r1.c(r0)
            r0 = r1
        L5d:
            r1.c(r7)
        L60:
            if (r2 > 0) goto L63
            return r0
        L63:
            r7 = r2
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: wj.w.u(int):wj.i2");
    }

    @Override // wj.b, wj.i2
    public void y1() {
        if (this.f19412b == null) {
            this.f19412b = new ArrayDeque(Math.min(this.f19411a.size(), 16));
        }
        while (!this.f19412b.isEmpty()) {
            this.f19412b.remove().close();
        }
        this.f19415e = true;
        i2 i2VarPeek = this.f19411a.peek();
        if (i2VarPeek != null) {
            i2VarPeek.y1();
        }
    }

    public w(int i10) {
        this.f19414d = new ArrayDeque(2);
        this.f19411a = new ArrayDeque(i10);
    }
}
