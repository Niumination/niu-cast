package tl;

import com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15887a = dm.a.a("max.copy.size", OSSwipeMenuLayout.D0);

    @os.l
    public static final s a(int i10) {
        ul.b.f16311i.getClass();
        return new s(i10, ul.b.f16315w);
    }

    public static /* synthetic */ s b(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return a(i10);
    }

    public static final int c() {
        return f15887a;
    }

    @os.l
    public static final ByteBuffer d(@os.l v vVar, int i10, boolean z10) {
        ByteBuffer byteBufferAllocate;
        String str;
        kn.l0.p(vVar, "<this>");
        if (z10) {
            byteBufferAllocate = ByteBuffer.allocateDirect(i10);
            str = "allocateDirect(n)";
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i10);
            str = "allocate(n)";
        }
        kn.l0.o(byteBufferAllocate, str);
        p.o(vVar, byteBufferAllocate);
        byteBufferAllocate.clear();
        return byteBufferAllocate;
    }

    public static /* synthetic */ ByteBuffer e(v vVar, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            long jS0 = vVar.S0();
            if (jS0 > 2147483647L) {
                throw new IllegalArgumentException("Unable to make a ByteBuffer: packet is too big");
            }
            i10 = (int) jS0;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return d(vVar, i10, z10);
    }

    @lm.k(message = "Migrate parameters order", replaceWith = @lm.a1(expression = "readText(out, decoder, max)", imports = {}))
    public static final int f(@os.l v vVar, @os.l CharsetDecoder charsetDecoder, @os.l Appendable appendable, int i10) {
        kn.l0.p(vVar, "<this>");
        kn.l0.p(charsetDecoder, "decoder");
        kn.l0.p(appendable, "out");
        return rl.a.b(charsetDecoder, vVar, appendable, i10);
    }

    public static /* synthetic */ int g(v vVar, CharsetDecoder charsetDecoder, Appendable appendable, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return f(vVar, charsetDecoder, appendable, i10);
    }
}
