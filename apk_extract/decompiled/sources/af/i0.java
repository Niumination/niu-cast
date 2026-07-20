package af;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends d {
    public static final k2 e = new k2(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k2 f316h = new k2(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k2 f317i = new k2(5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k2 f318j = new k2(6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k2 f319k = new k2(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f323d;

    public i0() {
        this.f320a = new ArrayDeque();
    }

    public final void A() throws IOException {
        boolean z2 = this.f323d;
        ArrayDeque arrayDeque = this.f320a;
        if (!z2) {
            ((d) arrayDeque.remove()).close();
            return;
        }
        this.f321b.add((d) arrayDeque.remove());
        d dVar = (d) arrayDeque.peek();
        if (dVar != null) {
            dVar.c();
        }
    }

    public final int B(h0 h0Var, int i8, Object obj, int i9) throws IOException {
        a(i8);
        ArrayDeque arrayDeque = this.f320a;
        if (!arrayDeque.isEmpty() && ((d) arrayDeque.peek()).o() == 0) {
            A();
        }
        while (i8 > 0 && !arrayDeque.isEmpty()) {
            d dVar = (d) arrayDeque.peek();
            int iMin = Math.min(i8, dVar.o());
            i9 = h0Var.e(dVar, iMin, obj, i9);
            i8 -= iMin;
            this.f322c -= iMin;
            if (((d) arrayDeque.peek()).o() == 0) {
                A();
            }
        }
        if (i8 <= 0) {
            return i9;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public final int E(g0 g0Var, int i8, Object obj, int i9) {
        try {
            return B(g0Var, i8, obj, i9);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // af.d
    public final void c() throws IOException {
        ArrayDeque arrayDeque = this.f321b;
        ArrayDeque arrayDeque2 = this.f320a;
        if (arrayDeque == null) {
            this.f321b = new ArrayDeque(Math.min(arrayDeque2.size(), 16));
        }
        while (!this.f321b.isEmpty()) {
            ((d) this.f321b.remove()).close();
        }
        this.f323d = true;
        d dVar = (d) arrayDeque2.peek();
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // af.d, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        while (true) {
            ArrayDeque arrayDeque = this.f320a;
            if (arrayDeque.isEmpty()) {
                break;
            } else {
                ((d) arrayDeque.remove()).close();
            }
        }
        if (this.f321b != null) {
            while (!this.f321b.isEmpty()) {
                ((d) this.f321b.remove()).close();
            }
        }
    }

    @Override // af.d
    public final boolean g() {
        Iterator it = this.f320a.iterator();
        while (it.hasNext()) {
            if (!((d) it.next()).g()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [af.d] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [af.d] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [af.i0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [af.i0] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // af.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final af.d h(int r8) throws java.io.IOException {
        /*
            r7 = this;
            if (r8 > 0) goto L5
            af.l4 r7 = af.m4.f457a
            return r7
        L5:
            r7.a(r8)
            int r0 = r7.f322c
            int r0 = r0 - r8
            r7.f322c = r0
            r0 = 0
            r1 = r0
        Lf:
            java.util.ArrayDeque r2 = r7.f320a
            java.lang.Object r3 = r2.peek()
            af.d r3 = (af.d) r3
            int r4 = r3.o()
            if (r4 <= r8) goto L23
            af.d r8 = r3.h(r8)
            r3 = 0
            goto L39
        L23:
            boolean r5 = r7.f323d
            if (r5 == 0) goto L2f
            af.d r3 = r3.h(r4)
            r7.A()
            goto L35
        L2f:
            java.lang.Object r3 = r2.poll()
            af.d r3 = (af.d) r3
        L35:
            int r8 = r8 - r4
            r6 = r3
            r3 = r8
            r8 = r6
        L39:
            if (r0 != 0) goto L3d
            r0 = r8
            goto L5a
        L3d:
            if (r1 != 0) goto L57
            af.i0 r1 = new af.i0
            r4 = 2
            if (r3 != 0) goto L45
            goto L50
        L45:
            int r2 = r2.size()
            int r2 = r2 + r4
            r4 = 16
            int r4 = java.lang.Math.min(r2, r4)
        L50:
            r1.<init>(r4)
            r1.w(r0)
            r0 = r1
        L57:
            r1.w(r8)
        L5a:
            if (r3 > 0) goto L5d
            return r0
        L5d:
            r8 = r3
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: af.i0.h(int):af.d");
    }

    @Override // af.d
    public final void i(OutputStream outputStream, int i8) throws IOException {
        B(f319k, i8, outputStream, 0);
    }

    @Override // af.d
    public final void k(ByteBuffer byteBuffer) {
        E(f318j, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // af.d
    public final void l(byte[] bArr, int i8, int i9) {
        E(f317i, i9, bArr, i8);
    }

    @Override // af.d
    public final int m() {
        return E(e, 1, null, 0);
    }

    @Override // af.d
    public final int o() {
        return this.f322c;
    }

    @Override // af.d
    public final void s() {
        if (!this.f323d) {
            throw new InvalidMarkException();
        }
        ArrayDeque arrayDeque = this.f320a;
        d dVar = (d) arrayDeque.peek();
        if (dVar != null) {
            int iO = dVar.o();
            dVar.s();
            this.f322c = (dVar.o() - iO) + this.f322c;
        }
        while (true) {
            d dVar2 = (d) this.f321b.pollLast();
            if (dVar2 == null) {
                return;
            }
            dVar2.s();
            arrayDeque.addFirst(dVar2);
            this.f322c = dVar2.o() + this.f322c;
        }
    }

    @Override // af.d
    public final void t(int i8) {
        E(f316h, i8, null, 0);
    }

    public final void w(d dVar) throws IOException {
        boolean z2 = this.f323d;
        ArrayDeque arrayDeque = this.f320a;
        boolean z3 = z2 && arrayDeque.isEmpty();
        if (dVar instanceof i0) {
            i0 i0Var = (i0) dVar;
            while (!i0Var.f320a.isEmpty()) {
                arrayDeque.add((d) i0Var.f320a.remove());
            }
            this.f322c += i0Var.f322c;
            i0Var.f322c = 0;
            i0Var.close();
        } else {
            arrayDeque.add(dVar);
            this.f322c = dVar.o() + this.f322c;
        }
        if (z3) {
            ((d) arrayDeque.peek()).c();
        }
    }

    public i0(int i8) {
        this.f320a = new ArrayDeque(i8);
    }
}
