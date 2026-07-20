package pl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    public static final class a {
        @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ Object b(n nVar, int i10, jn.l lVar, um.d dVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return nVar.k0(i10, lVar, dVar);
        }

        public static /* synthetic */ int c(n nVar, int i10, jn.l lVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeAvailable");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return nVar.k(i10, lVar);
        }
    }

    @os.m
    Object A(long j10, @os.l um.d<? super l2> dVar);

    @os.m
    Object H(byte b10, @os.l um.d<? super l2> dVar);

    @os.m
    @lm.k(message = "Use write { } instead.")
    @tl.f0
    Object J(@os.l jn.p<? super p0, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar);

    @os.m
    Object L(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar);

    @os.m
    Object M(@os.l ByteBuffer byteBuffer, @os.l um.d<? super l2> dVar);

    @os.m
    @tl.f0
    Object N(@os.l um.d<? super l2> dVar);

    @os.m
    Throwable a();

    boolean e();

    @os.m
    Object e0(short s10, @os.l um.d<? super l2> dVar);

    boolean f(@os.m Throwable th2);

    @os.m
    Object f0(float f10, @os.l um.d<? super l2> dVar);

    void flush();

    void g(@os.l tl.q qVar);

    @os.m
    Object g0(@os.l jn.l<? super ByteBuffer, Boolean> lVar, @os.l um.d<? super l2> dVar);

    @os.m
    Object h(@os.l tl.e eVar, @os.l um.d<? super l2> dVar);

    @os.m
    Object h0(int i10, @os.l um.d<? super l2> dVar);

    @os.m
    Object i(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super l2> dVar);

    @os.m
    Object j0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar);

    int k(int i10, @os.l jn.l<? super ByteBuffer, l2> lVar);

    @os.m
    Object k0(int i10, @os.l jn.l<? super ByteBuffer, l2> lVar, @os.l um.d<? super l2> dVar);

    @os.m
    Object m0(@os.l tl.o0 o0Var, @os.l um.d<? super l2> dVar);

    long o();

    @os.l
    tl.q o0();

    @os.m
    Object p(@os.l tl.v vVar, @os.l um.d<? super l2> dVar);

    int q();

    boolean q0();

    @os.m
    Object s(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar);

    @os.m
    Object t(double d10, @os.l um.d<? super l2> dVar);

    @os.m
    Object z(@os.l ByteBuffer byteBuffer, int i10, int i11, @os.l um.d<? super l2> dVar);
}
