package y0;

import androidx.annotation.Nullable;
import cr.d0;
import io.netty.util.internal.StringUtil;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 4;
    public static final int Q = 5;
    public static final int R = 6;
    public static final int S = 7;
    public static final int T = 8;
    public static final int U = 9;
    public static final int V = 10;
    public static final int W = 11;
    public static final int X = 12;
    public static final int Y = 13;
    public static final int Z = 14;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f20574a0 = 15;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f20575b0 = 16;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f20576c0 = 17;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f20577d0 = 18;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f20578e0 = 0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f20579f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f20580g0 = 2;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f20581h0 = 3;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f20582i0 = 4;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f20583j0 = 5;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f20584k0 = 6;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f20585l0 = 7;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f20586y = -922337203685477580L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final cr.e f20588i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final cr.c f20589n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20590p = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f20591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20592w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public String f20593x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final cr.f f20587z = cr.f.encodeUtf8("'\\");
    public static final cr.f H = cr.f.encodeUtf8("\"\\");
    public static final cr.f I = cr.f.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final cr.f J = cr.f.encodeUtf8("\n\r");
    public static final cr.f K = cr.f.encodeUtf8("*/");

    public e(cr.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f20588i = eVar;
        this.f20589n = eVar.buffer();
        b0(6);
    }

    @Override // y0.c
    public String A() throws IOException {
        String strL1;
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 10) {
            strL1 = F0();
        } else if (iP0 == 9) {
            strL1 = y0(H);
        } else if (iP0 == 8) {
            strL1 = y0(f20587z);
        } else if (iP0 == 11) {
            strL1 = this.f20593x;
            this.f20593x = null;
        } else if (iP0 == 16) {
            strL1 = Long.toString(this.f20591v);
        } else {
            if (iP0 != 17) {
                throw new a("Expected a string but was " + O() + " at path " + n());
            }
            cr.c cVar = this.f20589n;
            long j10 = this.f20592w;
            cVar.getClass();
            strL1 = cVar.L1(j10, d0.f3414a);
        }
        this.f20590p = 0;
        int[] iArr = this.f20560d;
        int i10 = this.f20557a - 1;
        iArr[i10] = iArr[i10] + 1;
        return strL1;
    }

    public final String F0() throws IOException {
        long jL1 = this.f20588i.l1(I);
        cr.c cVar = this.f20589n;
        if (jL1 == -1) {
            return cVar.K1();
        }
        cVar.getClass();
        return cVar.L1(jL1, d0.f3414a);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int J0() throws IOException {
        String str;
        String str2;
        int i10;
        byte bT = this.f20589n.t(0L);
        if (bT == 116 || bT == 84) {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        } else if (bT == 102 || bT == 70) {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (bT != 110 && bT != 78) {
                return 0;
            }
            str = d6.a.E;
            str2 = "NULL";
            i10 = 7;
        }
        int length = str.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f20588i.d0(i12)) {
                return 0;
            }
            byte bT2 = this.f20589n.t(i11);
            if (bT2 != str.charAt(i11) && bT2 != str2.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f20588i.d0(length + 1) && v0(this.f20589n.t(length))) {
            return 0;
        }
        this.f20589n.skip(length);
        this.f20590p = i10;
        return i10;
    }

    @Override // y0.c
    public c.b O() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        switch (iP0) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int O0() throws IOException {
        char c10;
        boolean z10 = true;
        long j10 = 0;
        int i10 = 0;
        char c11 = 0;
        boolean z11 = false;
        boolean z12 = true;
        while (true) {
            int i11 = i10 + 1;
            if (!this.f20588i.d0(i11)) {
                break;
            }
            byte bT = this.f20589n.t(i10);
            if (bT != 43) {
                if (bT == 69 || bT == 101) {
                    if (c11 != 2 && c11 != 4) {
                        return 0;
                    }
                    c11 = 5;
                } else if (bT == 45) {
                    c10 = 6;
                    if (c11 == 0) {
                        c11 = 1;
                        z11 = true;
                    } else if (c11 != 5) {
                        return 0;
                    }
                } else if (bT != 46) {
                    if (bT < 48 || bT > 57) {
                        if (!v0(bT)) {
                            break;
                        }
                        return 0;
                    }
                    if (c11 == z10 || c11 == 0) {
                        j10 = -(bT - 48);
                        c11 = 2;
                    } else if (c11 == 2) {
                        if (j10 == 0) {
                            return 0;
                        }
                        long j11 = (10 * j10) - ((long) (bT - 48));
                        z12 &= j10 > f20586y || (j10 == f20586y && j11 < j10);
                        j10 = j11;
                    } else if (c11 == 3) {
                        c11 = 4;
                    } else if (c11 == 5 || c11 == 6) {
                        c11 = 7;
                    }
                } else {
                    if (c11 != 2) {
                        return 0;
                    }
                    c11 = 3;
                }
                i10 = i11;
                z10 = true;
            } else {
                c10 = 6;
                if (c11 != 5) {
                    return 0;
                }
            }
            c11 = c10;
            i10 = i11;
            z10 = true;
        }
        if (c11 == 2 && z12 && ((j10 != Long.MIN_VALUE || z11) && (j10 != 0 || !z11))) {
            if (!z11) {
                j10 = -j10;
            }
            this.f20591v = j10;
            this.f20589n.skip(i10);
            this.f20590p = 16;
            return 16;
        }
        if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        }
        this.f20592w = i10;
        this.f20590p = 17;
        return 17;
    }

    public final char P0() throws IOException {
        int i10;
        if (!this.f20588i.d0(1L)) {
            throw k0("Unterminated escape sequence");
        }
        byte b10 = this.f20589n.readByte();
        if (b10 == 10 || b10 == 34 || b10 == 39 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return StringUtil.CARRIAGE_RETURN;
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            if (this.f20561e) {
                return (char) b10;
            }
            throw k0("Invalid escape sequence: \\" + ((char) b10));
        }
        if (!this.f20588i.d0(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + n());
        }
        char c10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            byte bT = this.f20589n.t(i11);
            char c11 = (char) (c10 << 4);
            if (bT >= 48 && bT <= 57) {
                i10 = bT - 48;
            } else if (bT >= 97 && bT <= 102) {
                i10 = bT - 87;
            } else {
                if (bT < 65 || bT > 70) {
                    StringBuilder sb2 = new StringBuilder("\\u");
                    cr.c cVar = this.f20589n;
                    cVar.getClass();
                    sb2.append(cVar.L1(4L, d0.f3414a));
                    throw k0(sb2.toString());
                }
                i10 = bT - 55;
            }
            c10 = (char) (i10 + c11);
        }
        this.f20589n.skip(4L);
        return c10;
    }

    public final void Q0(cr.f fVar) throws IOException {
        while (true) {
            long jL1 = this.f20588i.l1(fVar);
            if (jL1 == -1) {
                throw k0("Unterminated string");
            }
            if (this.f20589n.t(jL1) != 92) {
                this.f20589n.skip(jL1 + 1);
                return;
            } else {
                this.f20589n.skip(jL1 + 1);
                P0();
            }
        }
    }

    public final boolean S0() throws IOException {
        cr.e eVar = this.f20588i;
        cr.f fVar = K;
        long jS1 = eVar.s1(fVar);
        boolean z10 = jS1 != -1;
        cr.c cVar = this.f20589n;
        cVar.skip(z10 ? jS1 + ((long) fVar.size()) : cVar.f3404b);
        return z10;
    }

    public final void T0() throws IOException {
        long jL1 = this.f20588i.l1(J);
        cr.c cVar = this.f20589n;
        cVar.skip(jL1 != -1 ? jL1 + 1 : cVar.f3404b);
    }

    public final void U0() throws IOException {
        long jL1 = this.f20588i.l1(I);
        cr.c cVar = this.f20589n;
        if (jL1 == -1) {
            jL1 = cVar.f3404b;
        }
        cVar.skip(jL1);
    }

    @Override // y0.c
    public void c() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 3) {
            b0(1);
            this.f20560d[this.f20557a - 1] = 0;
            this.f20590p = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + O() + " at path " + n());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f20590p = 0;
        this.f20558b[0] = 8;
        this.f20557a = 1;
        this.f20589n.b();
        this.f20588i.close();
    }

    @Override // y0.c
    public void d() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 1) {
            b0(3);
            this.f20590p = 0;
        } else {
            throw new a("Expected BEGIN_OBJECT but was " + O() + " at path " + n());
        }
    }

    @Override // y0.c
    public int e0(c.a aVar) throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 < 12 || iP0 > 15) {
            return -1;
        }
        if (iP0 == 15) {
            return q0(this.f20593x, aVar);
        }
        int iR1 = this.f20588i.r1(aVar.f20564b);
        if (iR1 != -1) {
            this.f20590p = 0;
            this.f20559c[this.f20557a - 1] = aVar.f20563a[iR1];
            return iR1;
        }
        String str = this.f20559c[this.f20557a - 1];
        String strY = y();
        int iQ0 = q0(strY, aVar);
        if (iQ0 == -1) {
            this.f20590p = 15;
            this.f20593x = strY;
            this.f20559c[this.f20557a - 1] = str;
        }
        return iQ0;
    }

    @Override // y0.c
    public void f0() throws IOException {
        if (this.f20562f) {
            throw new a("Cannot skip unexpected " + O() + " at " + n());
        }
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 14) {
            U0();
        } else if (iP0 == 13) {
            Q0(H);
        } else if (iP0 == 12) {
            Q0(f20587z);
        } else if (iP0 != 15) {
            throw new a("Expected a name but was " + O() + " at path " + n());
        }
        this.f20590p = 0;
        this.f20559c[this.f20557a - 1] = d6.a.E;
    }

    @Override // y0.c
    public void g0() throws IOException {
        if (this.f20562f) {
            throw new a("Cannot skip unexpected " + O() + " at " + n());
        }
        int i10 = 0;
        do {
            int iP0 = this.f20590p;
            if (iP0 == 0) {
                iP0 = p0();
            }
            if (iP0 == 3) {
                b0(1);
            } else {
                if (iP0 == 1) {
                    b0(3);
                } else if (iP0 == 4) {
                    i10--;
                    if (i10 < 0) {
                        throw new a("Expected a value but was " + O() + " at path " + n());
                    }
                    this.f20557a--;
                } else if (iP0 == 2) {
                    i10--;
                    if (i10 < 0) {
                        throw new a("Expected a value but was " + O() + " at path " + n());
                    }
                    this.f20557a--;
                } else if (iP0 == 14 || iP0 == 10) {
                    U0();
                } else if (iP0 == 9 || iP0 == 13) {
                    Q0(H);
                } else if (iP0 == 8 || iP0 == 12) {
                    Q0(f20587z);
                } else if (iP0 == 17) {
                    this.f20589n.skip(this.f20592w);
                } else if (iP0 == 18) {
                    throw new a("Expected a value but was " + O() + " at path " + n());
                }
                this.f20590p = 0;
            }
            i10++;
            this.f20590p = 0;
        } while (i10 != 0);
        int[] iArr = this.f20560d;
        int i11 = this.f20557a;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f20559c[i11 - 1] = d6.a.E;
    }

    @Override // y0.c
    public void h() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 != 4) {
            throw new a("Expected END_ARRAY but was " + O() + " at path " + n());
        }
        int i10 = this.f20557a;
        this.f20557a = i10 - 1;
        int[] iArr = this.f20560d;
        int i11 = i10 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f20590p = 0;
    }

    @Override // y0.c
    public void k() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 != 2) {
            throw new a("Expected END_OBJECT but was " + O() + " at path " + n());
        }
        int i10 = this.f20557a;
        int i11 = i10 - 1;
        this.f20557a = i11;
        this.f20559c[i11] = null;
        int[] iArr = this.f20560d;
        int i12 = i10 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f20590p = 0;
    }

    public final void l0() throws IOException {
        if (!this.f20561e) {
            throw k0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override // y0.c
    public boolean o() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        return (iP0 == 2 || iP0 == 4 || iP0 == 18) ? false : true;
    }

    @Override // y0.c
    public boolean p() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 5) {
            this.f20590p = 0;
            int[] iArr = this.f20560d;
            int i10 = this.f20557a - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iP0 == 6) {
            this.f20590p = 0;
            int[] iArr2 = this.f20560d;
            int i11 = this.f20557a - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + O() + " at path " + n());
    }

    public final int p0() throws IOException {
        int[] iArr = this.f20558b;
        int i10 = this.f20557a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iW0 = w0(true);
            this.f20589n.readByte();
            if (iW0 != 44) {
                if (iW0 != 59) {
                    if (iW0 != 93) {
                        throw k0("Unterminated array");
                    }
                    this.f20590p = 4;
                    return 4;
                }
                l0();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5) {
                    int iW1 = w0(true);
                    this.f20589n.readByte();
                    if (iW1 != 44) {
                        if (iW1 != 59) {
                            if (iW1 != 125) {
                                throw k0("Unterminated object");
                            }
                            this.f20590p = 2;
                            return 2;
                        }
                        l0();
                    }
                }
                int iW2 = w0(true);
                if (iW2 == 34) {
                    this.f20589n.readByte();
                    this.f20590p = 13;
                    return 13;
                }
                if (iW2 == 39) {
                    this.f20589n.readByte();
                    l0();
                    this.f20590p = 12;
                    return 12;
                }
                if (iW2 != 125) {
                    l0();
                    if (!v0((char) iW2)) {
                        throw k0("Expected name");
                    }
                    this.f20590p = 14;
                    return 14;
                }
                if (i11 == 5) {
                    throw k0("Expected name");
                }
                this.f20589n.readByte();
                this.f20590p = 2;
                return 2;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iW3 = w0(true);
                this.f20589n.readByte();
                if (iW3 != 58) {
                    if (iW3 != 61) {
                        throw k0("Expected ':'");
                    }
                    l0();
                    if (this.f20588i.d0(1L) && this.f20589n.t(0L) == 62) {
                        this.f20589n.readByte();
                    }
                }
            } else if (i11 == 6) {
                iArr[i10 - 1] = 7;
            } else if (i11 == 7) {
                if (w0(false) == -1) {
                    this.f20590p = 18;
                    return 18;
                }
                l0();
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iW4 = w0(true);
        if (iW4 == 34) {
            this.f20589n.readByte();
            this.f20590p = 9;
            return 9;
        }
        if (iW4 == 39) {
            l0();
            this.f20589n.readByte();
            this.f20590p = 8;
            return 8;
        }
        if (iW4 != 44 && iW4 != 59) {
            if (iW4 == 91) {
                this.f20589n.readByte();
                this.f20590p = 3;
                return 3;
            }
            if (iW4 != 93) {
                if (iW4 == 123) {
                    this.f20589n.readByte();
                    this.f20590p = 1;
                    return 1;
                }
                int iJ0 = J0();
                if (iJ0 != 0) {
                    return iJ0;
                }
                int iO0 = O0();
                if (iO0 != 0) {
                    return iO0;
                }
                if (!v0(this.f20589n.t(0L))) {
                    throw k0("Expected value");
                }
                l0();
                this.f20590p = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f20589n.readByte();
                this.f20590p = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw k0("Unexpected value");
        }
        l0();
        this.f20590p = 7;
        return 7;
    }

    @Override // y0.c
    public double q() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 16) {
            this.f20590p = 0;
            int[] iArr = this.f20560d;
            int i10 = this.f20557a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f20591v;
        }
        if (iP0 == 17) {
            cr.c cVar = this.f20589n;
            long j10 = this.f20592w;
            cVar.getClass();
            this.f20593x = cVar.L1(j10, d0.f3414a);
        } else if (iP0 == 9) {
            this.f20593x = y0(H);
        } else if (iP0 == 8) {
            this.f20593x = y0(f20587z);
        } else if (iP0 == 10) {
            this.f20593x = F0();
        } else if (iP0 != 11) {
            throw new a("Expected a double but was " + O() + " at path " + n());
        }
        this.f20590p = 11;
        try {
            double d10 = Double.parseDouble(this.f20593x);
            if (!this.f20561e && (Double.isNaN(d10) || Double.isInfinite(d10))) {
                throw new b("JSON forbids NaN and infinities: " + d10 + " at path " + n());
            }
            this.f20593x = null;
            this.f20590p = 0;
            int[] iArr2 = this.f20560d;
            int i11 = this.f20557a - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return d10;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f20593x + " at path " + n());
        }
    }

    public final int q0(String str, c.a aVar) {
        int length = aVar.f20563a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f20563a[i10])) {
                this.f20590p = 0;
                this.f20559c[this.f20557a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    @Override // y0.c
    public int t() throws IOException {
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 16) {
            long j10 = this.f20591v;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f20590p = 0;
                int[] iArr = this.f20560d;
                int i11 = this.f20557a - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new a("Expected an int but was " + this.f20591v + " at path " + n());
        }
        if (iP0 == 17) {
            cr.c cVar = this.f20589n;
            long j11 = this.f20592w;
            cVar.getClass();
            this.f20593x = cVar.L1(j11, d0.f3414a);
        } else if (iP0 == 9 || iP0 == 8) {
            String strY0 = iP0 == 9 ? y0(H) : y0(f20587z);
            this.f20593x = strY0;
            try {
                int i12 = Integer.parseInt(strY0);
                this.f20590p = 0;
                int[] iArr2 = this.f20560d;
                int i13 = this.f20557a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        } else if (iP0 != 11) {
            throw new a("Expected an int but was " + O() + " at path " + n());
        }
        this.f20590p = 11;
        try {
            double d10 = Double.parseDouble(this.f20593x);
            int i14 = (int) d10;
            if (i14 != d10) {
                throw new a("Expected an int but was " + this.f20593x + " at path " + n());
            }
            this.f20593x = null;
            this.f20590p = 0;
            int[] iArr3 = this.f20560d;
            int i15 = this.f20557a - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f20593x + " at path " + n());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f20588i + ")";
    }

    public final int u0(String str, c.a aVar) {
        int length = aVar.f20563a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f20563a[i10])) {
                this.f20590p = 0;
                int[] iArr = this.f20560d;
                int i11 = this.f20557a - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
        }
        return -1;
    }

    public final boolean v0(int i10) throws IOException {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (i10 != 47 && i10 != 61) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case ms.a.T /* 91 */:
                        case ms.a.U /* 93 */:
                            return false;
                        case ms.a.W /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        l0();
        return false;
    }

    public final int w0(boolean z10) throws IOException {
        byte bT;
        while (true) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (!this.f20588i.d0(i11)) {
                    if (z10) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                bT = this.f20589n.t(i10);
                if (bT == 10 || bT == 32 || bT == 13 || bT == 9) {
                    i10 = i11;
                }
            }
            this.f20589n.skip(i10);
            if (bT == 47) {
                if (!this.f20588i.d0(2L)) {
                    return bT;
                }
                l0();
                byte bT2 = this.f20589n.t(1L);
                if (bT2 == 42) {
                    this.f20589n.readByte();
                    this.f20589n.readByte();
                    if (!S0()) {
                        throw k0("Unterminated comment");
                    }
                } else {
                    if (bT2 != 47) {
                        return bT;
                    }
                    this.f20589n.readByte();
                    this.f20589n.readByte();
                    T0();
                }
            } else {
                if (bT != 35) {
                    return bT;
                }
                l0();
                T0();
            }
        }
    }

    @Override // y0.c
    public String y() throws IOException {
        String strY0;
        int iP0 = this.f20590p;
        if (iP0 == 0) {
            iP0 = p0();
        }
        if (iP0 == 14) {
            strY0 = F0();
        } else if (iP0 == 13) {
            strY0 = y0(H);
        } else if (iP0 == 12) {
            strY0 = y0(f20587z);
        } else {
            if (iP0 != 15) {
                throw new a("Expected a name but was " + O() + " at path " + n());
            }
            strY0 = this.f20593x;
        }
        this.f20590p = 0;
        this.f20559c[this.f20557a - 1] = strY0;
        return strY0;
    }

    public final String y0(cr.f fVar) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long jL1 = this.f20588i.l1(fVar);
            if (jL1 == -1) {
                throw k0("Unterminated string");
            }
            if (this.f20589n.t(jL1) != 92) {
                if (sb2 == null) {
                    cr.c cVar = this.f20589n;
                    cVar.getClass();
                    String strL1 = cVar.L1(jL1, d0.f3414a);
                    this.f20589n.readByte();
                    return strL1;
                }
                cr.c cVar2 = this.f20589n;
                cVar2.getClass();
                sb2.append(cVar2.L1(jL1, d0.f3414a));
                this.f20589n.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            cr.c cVar3 = this.f20589n;
            cVar3.getClass();
            sb2.append(cVar3.L1(jL1, d0.f3414a));
            this.f20589n.readByte();
            sb2.append(P0());
        }
    }
}
