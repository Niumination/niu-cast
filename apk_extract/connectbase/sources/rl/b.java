package rl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kn.l0;
import lm.a1;
import lm.k;
import os.l;
import tl.d1;
import tl.f0;
import tl.g0;
import tl.m;
import tl.q0;
import tl.s;
import tl.v;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @f0
    @l
    public static final String a(@l CharsetDecoder charsetDecoder, @l g0 g0Var, int i10) throws Throwable {
        l0.p(charsetDecoder, "<this>");
        l0.p(g0Var, "input");
        StringBuilder sb2 = new StringBuilder((int) Math.min(i10, o(g0Var)));
        a.b(charsetDecoder, g0Var, sb2, i10);
        String string = sb2.toString();
        l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String b(CharsetDecoder charsetDecoder, g0 g0Var, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return a(charsetDecoder, g0Var, i10);
    }

    @f0
    @l
    public static final v c(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11) {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        s sVarA = w0.a(0);
        try {
            m(charsetEncoder, sVarA, charSequence, i10, i11);
            return sVarA.z2();
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @k(message = "Use writeText on Output instead.", replaceWith = @a1(expression = "dst.writeText(input, fromIndex, toIndex, charset)", imports = {"io.ktor.utils.io.core.writeText"}))
    public static final void d(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11, @l q0 q0Var) {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        l0.p(q0Var, "dst");
        m(charsetEncoder, q0Var, charSequence, i10, i11);
    }

    @f0
    public static final void e(@l CharsetEncoder charsetEncoder, @l char[] cArr, int i10, int i11, @l q0 q0Var) {
        int i12;
        l0.p(charsetEncoder, "<this>");
        l0.p(cArr, "input");
        l0.p(q0Var, "dst");
        if (i10 >= i11) {
            return;
        }
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                int iG = g(charsetEncoder, cArr, i10, i11, bVarO);
                if (iG < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                i10 += iG;
                if (i10 >= i11) {
                    i12 = 0;
                } else {
                    i12 = iG == 0 ? 8 : 1;
                }
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    h(charsetEncoder, q0Var);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    public static /* synthetic */ v f(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return c(charsetEncoder, charSequence, i10, i11);
    }

    public static final int g(@l CharsetEncoder charsetEncoder, @l char[] cArr, int i10, int i11, @l tl.e eVar) {
        l0.p(charsetEncoder, "<this>");
        l0.p(cArr, "input");
        l0.p(eVar, "dst");
        int i12 = i11 - i10;
        return a.i(charsetEncoder, new ul.a(cArr, i10, i12), 0, i12, eVar);
    }

    public static final int h(CharsetEncoder charsetEncoder, q0 q0Var) {
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        int i10 = 1;
        int i11 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int i12 = mVar.f15872a - mVar.f15874c;
                i10 = a.h(charsetEncoder, bVarO) ? 0 : i10 + 1;
                m mVar2 = bVarO.f15821b;
                i11 += i12 - (mVar2.f15872a - mVar2.f15874c);
                if (i10 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return i11;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    @k(message = "Internal API. Will be hidden in future releases. Use encodeToByteArray instead.", replaceWith = @a1(expression = "encodeToByteArray(input, fromIndex, toIndex)", imports = {}))
    @l
    public static final byte[] i(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11) {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        return a.j(charsetEncoder, charSequence, i10, i11);
    }

    public static /* synthetic */ byte[] j(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return i(charsetEncoder, charSequence, i10, i11);
    }

    @l
    public static final byte[] k(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11) {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        if (i10 >= i11) {
            return ul.k.f16328a;
        }
        ul.b.e eVar = ul.b.f16311i;
        eVar.getClass();
        ul.b bVar = (ul.b) ul.b.f16315w.W0();
        try {
            int i12 = i10 + a.i(charsetEncoder, charSequence, i10, i11, bVar);
            if (i12 == i11) {
                m mVar = bVar.f15821b;
                byte[] bArr = new byte[mVar.f15874c - mVar.f15873b];
                tl.l.N(bVar, bArr, 0, 0, 6, null);
                eVar.getClass();
                bVar.j2(ul.b.f16315w);
                return bArr;
            }
            s sVarA = w0.a(0);
            try {
                sVarA.E(bVar.o());
                m(charsetEncoder, sVarA, charSequence, i12, i11);
                byte[] bArrI = d1.i(sVarA.z2(), 0, 1, null);
                eVar.getClass();
                bVar.j2(ul.b.f16315w);
                return bArrI;
            } catch (Throwable th2) {
                sVarA.close();
                throw th2;
            }
        } catch (Throwable th3) {
            ul.b.f16311i.getClass();
            bVar.j2(ul.b.f16315w);
            throw th3;
        }
    }

    public static /* synthetic */ byte[] l(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return k(charsetEncoder, charSequence, i10, i11);
    }

    public static final int m(@l CharsetEncoder charsetEncoder, @l q0 q0Var, @l CharSequence charSequence, int i10, int i11) {
        int i12;
        l0.p(charsetEncoder, "<this>");
        l0.p(q0Var, RtspHeaders.Values.DESTINATION);
        l0.p(charSequence, "input");
        if (i10 >= i11) {
            return 0;
        }
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        int i13 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int i14 = mVar.f15872a - mVar.f15874c;
                int i15 = a.i(charsetEncoder, charSequence, i10, i11, bVarO);
                if (i15 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                i10 += i15;
                m mVar2 = bVarO.f15821b;
                i13 += i14 - (mVar2.f15872a - mVar2.f15874c);
                if (i10 >= i11) {
                    i12 = 0;
                } else {
                    i12 = i15 == 0 ? 8 : 1;
                }
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return h(charsetEncoder, q0Var) + i13;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    @f0
    @l
    public static final v n(@l CharsetEncoder charsetEncoder, @l v vVar) {
        l0.p(charsetEncoder, "<this>");
        l0.p(vVar, "input");
        s sVarA = w0.a(0);
        try {
            a.m(charsetEncoder, vVar, sVarA);
            return sVarA.z2();
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static final long o(@l g0 g0Var) {
        l0.p(g0Var, "<this>");
        if (g0Var instanceof v) {
            return ((v) g0Var).S0();
        }
        if (g0Var instanceof tl.a) {
            return Math.max(((tl.a) g0Var).S0(), 16L);
        }
        return 16L;
    }
}
