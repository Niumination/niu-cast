package v1;

import java.io.EOFException;
import java.io.IOException;
import kotlin.text.Charsets;
import qj.f;
import qj.j;
import qj.p;
import qj.t;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j f10463n = j.encodeUtf8("'\\");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j f10464o = j.encodeUtf8("\"\\");
    public static final j p = j.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f10465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f10466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10470m;

    static {
        j.encodeUtf8("\n\r");
        j.encodeUtf8("*/");
    }

    public e(t tVar) {
        this.f10460b = new int[32];
        this.f10461c = new String[32];
        this.f10462d = new int[32];
        this.f10467j = 0;
        this.f10465h = tVar;
        this.f10466i = tVar.f9222b;
        t(6);
    }

    @Override // v1.d
    public final void A() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 14) {
            long jC = this.f10465h.c(p);
            f fVar = this.f10466i;
            if (jC == -1) {
                jC = fVar.f9195b;
            }
            fVar.A(jC);
        } else if (I == 13) {
            m0(f10464o);
        } else if (I == 12) {
            m0(f10463n);
        } else if (I != 15) {
            throw new a("Expected a name but was " + s() + " at path " + getPath());
        }
        this.f10467j = 0;
        this.f10461c[this.f10459a - 1] = "null";
    }

    @Override // v1.d
    public final void B() {
        int i8 = 0;
        do {
            int I = this.f10467j;
            if (I == 0) {
                I = I();
            }
            if (I == 3) {
                t(1);
            } else {
                if (I == 1) {
                    t(3);
                } else if (I == 4) {
                    i8--;
                    if (i8 < 0) {
                        throw new a("Expected a value but was " + s() + " at path " + getPath());
                    }
                    this.f10459a--;
                } else if (I == 2) {
                    i8--;
                    if (i8 < 0) {
                        throw new a("Expected a value but was " + s() + " at path " + getPath());
                    }
                    this.f10459a--;
                } else {
                    f fVar = this.f10466i;
                    if (I == 14 || I == 10) {
                        long jC = this.f10465h.c(p);
                        if (jC == -1) {
                            jC = fVar.f9195b;
                        }
                        fVar.A(jC);
                    } else if (I == 9 || I == 13) {
                        m0(f10464o);
                    } else if (I == 8 || I == 12) {
                        m0(f10463n);
                    } else if (I == 17) {
                        fVar.A(this.f10469l);
                    } else if (I == 18) {
                        throw new a("Expected a value but was " + s() + " at path " + getPath());
                    }
                }
                this.f10467j = 0;
            }
            i8++;
            this.f10467j = 0;
        } while (i8 != 0);
        int[] iArr = this.f10462d;
        int i9 = this.f10459a - 1;
        iArr[i9] = iArr[i9] + 1;
        this.f10461c[i9] = "null";
    }

    public final void H() throws b {
        E("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:137:0x019d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:163:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:165:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:168:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:173:0x01f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:174:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:176:0x0202  */
    /* JADX WARN: Code duplicated, block: B:178:0x0209  */
    /* JADX WARN: Code duplicated, block: B:180:0x020e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0214 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:183:0x0216  */
    /* JADX WARN: Code duplicated, block: B:185:0x021d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0235  */
    /* JADX WARN: Code duplicated, block: B:196:0x023a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x019b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x00b9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x0113  */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:95:0x012c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0130  */
    public final int I() throws b, EOFException {
        int iX;
        byte bK;
        t tVar;
        int i8;
        String str;
        String str2;
        int length;
        int i9;
        int i10;
        char cK;
        char c9;
        int i11;
        int i12;
        int i13;
        int i14;
        byte bK2;
        char c10;
        int[] iArr = this.f10460b;
        int i15 = this.f10459a - 1;
        int i16 = iArr[i15];
        f fVar = this.f10466i;
        if (i16 == 1) {
            iArr[i15] = 2;
        } else if (i16 == 2) {
            int iX2 = X(true);
            fVar.readByte();
            if (iX2 != 44) {
                if (iX2 == 59) {
                    H();
                    throw null;
                }
                if (iX2 == 93) {
                    this.f10467j = 4;
                    return 4;
                }
                E("Unterminated array");
                throw null;
            }
        } else {
            if (i16 == 3 || i16 == 5) {
                iArr[i15] = 4;
                if (i16 == 5) {
                    int iX3 = X(true);
                    fVar.readByte();
                    if (iX3 != 44) {
                        if (iX3 == 59) {
                            H();
                            throw null;
                        }
                        if (iX3 == 125) {
                            this.f10467j = 2;
                            return 2;
                        }
                        E("Unterminated object");
                        throw null;
                    }
                }
                int iX4 = X(true);
                if (iX4 == 34) {
                    fVar.readByte();
                    this.f10467j = 13;
                    return 13;
                }
                if (iX4 == 39) {
                    fVar.readByte();
                    H();
                    throw null;
                }
                if (iX4 != 125) {
                    H();
                    throw null;
                }
                if (i16 == 5) {
                    E("Expected name");
                    throw null;
                }
                fVar.readByte();
                this.f10467j = 2;
                return 2;
            }
            if (i16 != 4) {
                if (i16 == 6) {
                    iArr[i15] = 7;
                } else {
                    if (i16 == 7) {
                        if (X(false) == -1) {
                            this.f10467j = 18;
                            return 18;
                        }
                        H();
                        throw null;
                    }
                    if (i16 == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
                iX = X(true);
                if (iX != 34) {
                    fVar.readByte();
                    this.f10467j = 9;
                    return 9;
                }
                if (iX != 39) {
                    H();
                    throw null;
                }
                if (iX != 44 && iX != 59) {
                    if (iX != 91) {
                        fVar.readByte();
                        this.f10467j = 3;
                        return 3;
                    }
                    if (iX != 93) {
                        if (iX != 123) {
                            fVar.readByte();
                            this.f10467j = 1;
                            return 1;
                        }
                        bK = fVar.k(0L);
                        tVar = this.f10465h;
                        if (bK != 116 || bK == 84) {
                            i8 = 5;
                            str2 = "true";
                            str = "TRUE";
                        } else {
                            if (bK != 102 && bK != 70) {
                                if (bK != 110 && bK != 78) {
                                    i8 = 0;
                                    break;
                                }
                                i8 = 7;
                                str2 = "null";
                                str = "NULL";
                                if (i8 != 0) {
                                    return i8;
                                }
                                long j8 = 0;
                                boolean z2 = true;
                                c9 = 0;
                                i11 = 0;
                                boolean z3 = false;
                                while (true) {
                                    i12 = i11 + 1;
                                    if (tVar.request(i12)) {
                                        bK2 = fVar.k(i11);
                                        if (bK2 != 43) {
                                            if (bK2 != 69 || bK2 == 101) {
                                                if (c9 != 2 || c9 == 4) {
                                                    c9 = 5;
                                                    i11 = i12;
                                                } else {
                                                    i14 = 0;
                                                }
                                            } else if (bK2 == 45) {
                                                c10 = 6;
                                                if (c9 == 0) {
                                                    c9 = 1;
                                                    z3 = true;
                                                } else {
                                                    if (c9 != 5) {
                                                        i14 = 0;
                                                    }
                                                    c9 = c10;
                                                }
                                                i11 = i12;
                                            } else if (bK2 != 46) {
                                                if (bK2 >= 48 && bK2 <= 57) {
                                                    if (c9 == 1 || c9 == 0) {
                                                        j8 = -(bK2 - 48);
                                                        c9 = 2;
                                                    } else {
                                                        if (c9 == 2) {
                                                            if (j8 != 0) {
                                                                long j10 = (10 * j8) - ((long) (bK2 - 48));
                                                                z2 &= j8 > -922337203685477580L || (j8 == -922337203685477580L && j10 < j8);
                                                                j8 = j10;
                                                            }
                                                        } else if (c9 == 3) {
                                                            c9 = 4;
                                                        } else if (c9 == 5 || c9 == 6) {
                                                            c9 = 7;
                                                        }
                                                        i11 = i12;
                                                    }
                                                    i11 = i12;
                                                } else if (!N(bK2)) {
                                                }
                                                i14 = 0;
                                            } else if (c9 == 2) {
                                                c9 = 3;
                                                i11 = i12;
                                            } else {
                                                i14 = 0;
                                            }
                                            if (i14 != 0) {
                                                return i14;
                                            }
                                            if (N(fVar.k(0L))) {
                                                H();
                                                throw null;
                                            }
                                            E("Expected value");
                                            throw null;
                                        }
                                        c10 = 6;
                                        if (c9 != 5) {
                                            i14 = 0;
                                            if (i14 != 0) {
                                                return i14;
                                            }
                                            if (N(fVar.k(0L))) {
                                                E("Expected value");
                                                throw null;
                                            }
                                            H();
                                            throw null;
                                        }
                                        c9 = c10;
                                        i11 = i12;
                                    }
                                    if (c9 == 2 || !z2 || ((j8 == Long.MIN_VALUE && !z3) || (j8 == 0 && z3))) {
                                        if (c9 != 2 || c9 == 4 || c9 == 7) {
                                            this.f10469l = i11;
                                            i13 = 17;
                                            this.f10467j = 17;
                                        } else {
                                            i14 = 0;
                                        }
                                        if (i14 != 0) {
                                            return i14;
                                        }
                                        if (N(fVar.k(0L))) {
                                            E("Expected value");
                                            throw null;
                                        }
                                        H();
                                        throw null;
                                    }
                                    if (!z3) {
                                        j8 = -j8;
                                    }
                                    this.f10468k = j8;
                                    fVar.A(i11);
                                    i13 = 16;
                                    this.f10467j = 16;
                                    i14 = i13;
                                    if (i14 != 0) {
                                        return i14;
                                    }
                                    if (N(fVar.k(0L))) {
                                        E("Expected value");
                                        throw null;
                                    }
                                    H();
                                    throw null;
                                }
                            }
                            i8 = 6;
                            str2 = "false";
                            str = "FALSE";
                        }
                        length = str2.length();
                        i9 = 1;
                        while (true) {
                            if (i9 >= length) {
                                if (tVar.request(length + 1) || !N(fVar.k(length))) {
                                    fVar.A(length);
                                    this.f10467j = i8;
                                    break;
                                }
                            } else {
                                i10 = i9 + 1;
                                if (!tVar.request(i10) && ((cK = fVar.k(i9)) == str2.charAt(i9) || cK == str.charAt(i9))) {
                                    i9 = i10;
                                }
                            }
                            i8 = 0;
                            break;
                        }
                        if (i8 != 0) {
                            return i8;
                        }
                        long j11 = 0;
                        boolean z5 = true;
                        c9 = 0;
                        i11 = 0;
                        boolean z10 = false;
                        while (true) {
                            i12 = i11 + 1;
                            if (tVar.request(i12)) {
                                bK2 = fVar.k(i11);
                                if (bK2 != 43) {
                                    if (bK2 != 69) {
                                        if (c9 != 2) {
                                        }
                                        c9 = 5;
                                        i11 = i12;
                                    } else {
                                        if (c9 != 2) {
                                        }
                                        c9 = 5;
                                        i11 = i12;
                                    }
                                    if (i14 != 0) {
                                        return i14;
                                    }
                                    if (N(fVar.k(0L))) {
                                        E("Expected value");
                                        throw null;
                                    }
                                    H();
                                    throw null;
                                }
                                c10 = 6;
                                if (c9 != 5) {
                                    i14 = 0;
                                    if (i14 != 0) {
                                        return i14;
                                    }
                                    if (N(fVar.k(0L))) {
                                        E("Expected value");
                                        throw null;
                                    }
                                    H();
                                    throw null;
                                }
                                c9 = c10;
                                i11 = i12;
                            }
                            if (c9 == 2) {
                                if (c9 != 2) {
                                }
                                this.f10469l = i11;
                                i13 = 17;
                                this.f10467j = 17;
                            } else {
                                if (c9 != 2) {
                                }
                                this.f10469l = i11;
                                i13 = 17;
                                this.f10467j = 17;
                            }
                            i14 = i13;
                            if (i14 != 0) {
                                return i14;
                            }
                            if (N(fVar.k(0L))) {
                                E("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                    }
                    if (i16 == 1) {
                        fVar.readByte();
                        this.f10467j = 4;
                        return 4;
                    }
                }
                if (i16 != 1 || i16 == 2) {
                    H();
                    throw null;
                }
                E("Unexpected value");
                throw null;
            }
            iArr[i15] = 5;
            int iX5 = X(true);
            fVar.readByte();
            if (iX5 != 58) {
                if (iX5 != 61) {
                    E("Expected ':'");
                    throw null;
                }
                H();
                throw null;
            }
        }
        iX = X(true);
        if (iX != 34) {
            fVar.readByte();
            this.f10467j = 9;
            return 9;
        }
        if (iX != 39) {
            H();
            throw null;
        }
        if (iX != 44) {
            if (iX != 91) {
                fVar.readByte();
                this.f10467j = 3;
                return 3;
            }
            if (iX != 93) {
                if (iX != 123) {
                    fVar.readByte();
                    this.f10467j = 1;
                    return 1;
                }
                bK = fVar.k(0L);
                tVar = this.f10465h;
                if (bK != 116) {
                    i8 = 5;
                    str2 = "true";
                    str = "TRUE";
                    length = str2.length();
                    i9 = 1;
                    while (true) {
                        if (i9 >= length) {
                            if (tVar.request(length + 1)) {
                            }
                            fVar.A(length);
                            this.f10467j = i8;
                            break;
                        }
                        i10 = i9 + 1;
                        if (!tVar.request(i10)) {
                            i9 = i10;
                        }
                    }
                    if (i8 != 0) {
                        return i8;
                    }
                    long j12 = 0;
                    boolean z11 = true;
                    c9 = 0;
                    i11 = 0;
                    boolean z12 = false;
                    while (true) {
                        i12 = i11 + 1;
                        if (tVar.request(i12)) {
                            bK2 = fVar.k(i11);
                            if (bK2 != 43) {
                                if (bK2 != 69) {
                                    if (c9 != 2) {
                                    }
                                    c9 = 5;
                                    i11 = i12;
                                } else {
                                    if (c9 != 2) {
                                    }
                                    c9 = 5;
                                    i11 = i12;
                                }
                                if (i14 != 0) {
                                    return i14;
                                }
                                if (N(fVar.k(0L))) {
                                    E("Expected value");
                                    throw null;
                                }
                                H();
                                throw null;
                            }
                            c10 = 6;
                            if (c9 != 5) {
                                i14 = 0;
                                if (i14 != 0) {
                                    return i14;
                                }
                                if (N(fVar.k(0L))) {
                                    E("Expected value");
                                    throw null;
                                }
                                H();
                                throw null;
                            }
                            c9 = c10;
                            i11 = i12;
                        }
                        if (c9 == 2) {
                            if (c9 != 2) {
                            }
                            this.f10469l = i11;
                            i13 = 17;
                            this.f10467j = 17;
                        } else {
                            if (c9 != 2) {
                            }
                            this.f10469l = i11;
                            i13 = 17;
                            this.f10467j = 17;
                        }
                        i14 = i13;
                        if (i14 != 0) {
                            return i14;
                        }
                        if (N(fVar.k(0L))) {
                            E("Expected value");
                            throw null;
                        }
                        H();
                        throw null;
                    }
                }
                i8 = 5;
                str2 = "true";
                str = "TRUE";
                length = str2.length();
                i9 = 1;
                while (true) {
                    if (i9 >= length) {
                        if (tVar.request(length + 1)) {
                        }
                        fVar.A(length);
                        this.f10467j = i8;
                        break;
                    }
                    i10 = i9 + 1;
                    if (!tVar.request(i10)) {
                        i9 = i10;
                    }
                }
                if (i8 != 0) {
                    return i8;
                }
                long j13 = 0;
                boolean z13 = true;
                c9 = 0;
                i11 = 0;
                boolean z14 = false;
                while (true) {
                    i12 = i11 + 1;
                    if (tVar.request(i12)) {
                        bK2 = fVar.k(i11);
                        if (bK2 != 43) {
                            if (bK2 != 69) {
                                if (c9 != 2) {
                                }
                                c9 = 5;
                                i11 = i12;
                            } else {
                                if (c9 != 2) {
                                }
                                c9 = 5;
                                i11 = i12;
                            }
                            if (i14 != 0) {
                                return i14;
                            }
                            if (N(fVar.k(0L))) {
                                E("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        c10 = 6;
                        if (c9 != 5) {
                            i14 = 0;
                            if (i14 != 0) {
                                return i14;
                            }
                            if (N(fVar.k(0L))) {
                                E("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        c9 = c10;
                        i11 = i12;
                    }
                    if (c9 == 2) {
                        if (c9 != 2) {
                        }
                        this.f10469l = i11;
                        i13 = 17;
                        this.f10467j = 17;
                    } else {
                        if (c9 != 2) {
                        }
                        this.f10469l = i11;
                        i13 = 17;
                        this.f10467j = 17;
                    }
                    i14 = i13;
                    if (i14 != 0) {
                        return i14;
                    }
                    if (N(fVar.k(0L))) {
                        E("Expected value");
                        throw null;
                    }
                    H();
                    throw null;
                }
                i8 = 0;
                if (i8 != 0) {
                    return i8;
                }
                long j14 = 0;
                boolean z15 = true;
                c9 = 0;
                i11 = 0;
                boolean z16 = false;
                while (true) {
                    i12 = i11 + 1;
                    if (tVar.request(i12)) {
                        bK2 = fVar.k(i11);
                        if (bK2 != 43) {
                            if (bK2 != 69) {
                                if (c9 != 2) {
                                }
                                c9 = 5;
                                i11 = i12;
                            } else {
                                if (c9 != 2) {
                                }
                                c9 = 5;
                                i11 = i12;
                            }
                            if (i14 != 0) {
                                return i14;
                            }
                            if (N(fVar.k(0L))) {
                                E("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        c10 = 6;
                        if (c9 != 5) {
                            i14 = 0;
                            if (i14 != 0) {
                                return i14;
                            }
                            if (N(fVar.k(0L))) {
                                E("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        c9 = c10;
                        i11 = i12;
                    }
                    if (c9 == 2) {
                        if (c9 != 2) {
                        }
                        this.f10469l = i11;
                        i13 = 17;
                        this.f10467j = 17;
                    } else {
                        if (c9 != 2) {
                        }
                        this.f10469l = i11;
                        i13 = 17;
                        this.f10467j = 17;
                    }
                    i14 = i13;
                    if (i14 != 0) {
                        return i14;
                    }
                    if (N(fVar.k(0L))) {
                        E("Expected value");
                        throw null;
                    }
                    H();
                    throw null;
                }
            }
            if (i16 == 1) {
                fVar.readByte();
                this.f10467j = 4;
                return 4;
            }
        }
        if (i16 != 1) {
        }
        H();
        throw null;
    }

    public final int L(String str, f5.a aVar) {
        int length = ((String[]) aVar.f4984a).length;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.equals(((String[]) aVar.f4984a)[i8])) {
                this.f10467j = 0;
                this.f10461c[this.f10459a - 1] = str;
                return i8;
            }
        }
        return -1;
    }

    public final boolean N(int i8) throws b {
        if (i8 == 9 || i8 == 10 || i8 == 12 || i8 == 13 || i8 == 32) {
            return false;
        }
        if (i8 != 35) {
            if (i8 == 44) {
                return false;
            }
            if (i8 != 47 && i8 != 61) {
                if (i8 == 123 || i8 == 125 || i8 == 58) {
                    return false;
                }
                if (i8 != 59) {
                    switch (i8) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        H();
        throw null;
    }

    public final String S() throws b, EOFException {
        String strA0;
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 14) {
            strA0 = b0();
        } else if (I == 13) {
            strA0 = a0(f10464o);
        } else if (I == 12) {
            strA0 = a0(f10463n);
        } else {
            if (I != 15) {
                throw new a("Expected a name but was " + s() + " at path " + getPath());
            }
            strA0 = this.f10470m;
        }
        this.f10467j = 0;
        this.f10461c[this.f10459a - 1] = strA0;
        return strA0;
    }

    public final int X(boolean z2) throws b, EOFException {
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            t tVar = this.f10465h;
            if (!tVar.request(i9)) {
                if (z2) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            long j8 = i8;
            f fVar = this.f10466i;
            byte bK = fVar.k(j8);
            if (bK != 10 && bK != 32 && bK != 13 && bK != 9) {
                fVar.A(j8);
                if (bK == 47) {
                    if (!tVar.request(2L)) {
                        return bK;
                    }
                    H();
                    throw null;
                }
                if (bK != 35) {
                    return bK;
                }
                H();
                throw null;
            }
            i8 = i9;
        }
    }

    @Override // v1.d
    public final void a() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 3) {
            t(1);
            this.f10462d[this.f10459a - 1] = 0;
            this.f10467j = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + s() + " at path " + getPath());
        }
    }

    public final String a0(j jVar) throws b, EOFException {
        StringBuilder sb2 = null;
        while (true) {
            long jC = this.f10465h.c(jVar);
            if (jC == -1) {
                E("Unterminated string");
                throw null;
            }
            f fVar = this.f10466i;
            if (fVar.k(jC) != 92) {
                if (sb2 == null) {
                    String strT = fVar.t(jC, Charsets.UTF_8);
                    fVar.readByte();
                    return strT;
                }
                sb2.append(fVar.t(jC, Charsets.UTF_8));
                fVar.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(fVar.t(jC, Charsets.UTF_8));
            fVar.readByte();
            sb2.append(l0());
        }
    }

    public final String b0() {
        long jC = this.f10465h.c(p);
        f fVar = this.f10466i;
        if (jC == -1) {
            return fVar.w();
        }
        fVar.getClass();
        return fVar.t(jC, Charsets.UTF_8);
    }

    @Override // v1.d
    public final void c() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 1) {
            t(3);
            this.f10467j = 0;
        } else {
            throw new a("Expected BEGIN_OBJECT but was " + s() + " at path " + getPath());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f10467j = 0;
        this.f10460b[0] = 8;
        this.f10459a = 1;
        this.f10466i.a();
        this.f10465h.close();
    }

    @Override // v1.d
    public final void g() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I != 4) {
            throw new a("Expected END_ARRAY but was " + s() + " at path " + getPath());
        }
        int i8 = this.f10459a;
        this.f10459a = i8 - 1;
        int[] iArr = this.f10462d;
        int i9 = i8 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.f10467j = 0;
    }

    @Override // v1.d
    public final void h() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I != 2) {
            throw new a("Expected END_OBJECT but was " + s() + " at path " + getPath());
        }
        int i8 = this.f10459a;
        int i9 = i8 - 1;
        this.f10459a = i9;
        this.f10461c[i9] = null;
        int[] iArr = this.f10462d;
        int i10 = i8 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f10467j = 0;
    }

    @Override // v1.d
    public final boolean i() throws b, EOFException {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        return (I == 2 || I == 4 || I == 18) ? false : true;
    }

    @Override // v1.d
    public final boolean k() throws b, EOFException {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 5) {
            this.f10467j = 0;
            int[] iArr = this.f10462d;
            int i8 = this.f10459a - 1;
            iArr[i8] = iArr[i8] + 1;
            return true;
        }
        if (I == 6) {
            this.f10467j = 0;
            int[] iArr2 = this.f10462d;
            int i9 = this.f10459a - 1;
            iArr2[i9] = iArr2[i9] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + s() + " at path " + getPath());
    }

    @Override // v1.d
    public final double l() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 16) {
            this.f10467j = 0;
            int[] iArr = this.f10462d;
            int i8 = this.f10459a - 1;
            iArr[i8] = iArr[i8] + 1;
            return this.f10468k;
        }
        if (I == 17) {
            long j8 = this.f10469l;
            f fVar = this.f10466i;
            fVar.getClass();
            this.f10470m = fVar.t(j8, Charsets.UTF_8);
        } else if (I == 9) {
            this.f10470m = a0(f10464o);
        } else if (I == 8) {
            this.f10470m = a0(f10463n);
        } else if (I == 10) {
            this.f10470m = b0();
        } else if (I != 11) {
            throw new a("Expected a double but was " + s() + " at path " + getPath());
        }
        this.f10467j = 11;
        try {
            double d7 = Double.parseDouble(this.f10470m);
            if (Double.isNaN(d7) || Double.isInfinite(d7)) {
                throw new b("JSON forbids NaN and infinities: " + d7 + " at path " + getPath());
            }
            this.f10470m = null;
            this.f10467j = 0;
            int[] iArr2 = this.f10462d;
            int i9 = this.f10459a - 1;
            iArr2[i9] = iArr2[i9] + 1;
            return d7;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f10470m + " at path " + getPath());
        }
    }

    public final char l0() throws b, EOFException {
        int i8;
        t tVar = this.f10465h;
        if (!tVar.request(1L)) {
            E("Unterminated escape sequence");
            throw null;
        }
        f fVar = this.f10466i;
        byte b9 = fVar.readByte();
        if (b9 == 10 || b9 == 34 || b9 == 39 || b9 == 47 || b9 == 92) {
            return (char) b9;
        }
        if (b9 == 98) {
            return '\b';
        }
        if (b9 == 102) {
            return '\f';
        }
        if (b9 == 110) {
            return '\n';
        }
        if (b9 == 114) {
            return '\r';
        }
        if (b9 == 116) {
            return '\t';
        }
        if (b9 != 117) {
            E("Invalid escape sequence: \\" + ((char) b9));
            throw null;
        }
        if (!tVar.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c9 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            byte bK = fVar.k(i9);
            char c10 = (char) (c9 << 4);
            if (bK >= 48 && bK <= 57) {
                i8 = bK - 48;
            } else if (bK >= 97 && bK <= 102) {
                i8 = bK - 87;
            } else {
                if (bK < 65 || bK > 70) {
                    E("\\u".concat(fVar.t(4L, Charsets.UTF_8)));
                    throw null;
                }
                i8 = bK - 55;
            }
            c9 = (char) (i8 + c10);
        }
        fVar.A(4L);
        return c9;
    }

    @Override // v1.d
    public final int m() {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 16) {
            long j8 = this.f10468k;
            int i8 = (int) j8;
            if (j8 == i8) {
                this.f10467j = 0;
                int[] iArr = this.f10462d;
                int i9 = this.f10459a - 1;
                iArr[i9] = iArr[i9] + 1;
                return i8;
            }
            throw new a("Expected an int but was " + this.f10468k + " at path " + getPath());
        }
        if (I == 17) {
            long j10 = this.f10469l;
            f fVar = this.f10466i;
            fVar.getClass();
            this.f10470m = fVar.t(j10, Charsets.UTF_8);
        } else if (I == 9 || I == 8) {
            String strA0 = I == 9 ? a0(f10464o) : a0(f10463n);
            this.f10470m = strA0;
            try {
                int i10 = Integer.parseInt(strA0);
                this.f10467j = 0;
                int[] iArr2 = this.f10462d;
                int i11 = this.f10459a - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return i10;
            } catch (NumberFormatException unused) {
            }
        } else if (I != 11) {
            throw new a("Expected an int but was " + s() + " at path " + getPath());
        }
        this.f10467j = 11;
        try {
            double d7 = Double.parseDouble(this.f10470m);
            int i12 = (int) d7;
            if (i12 != d7) {
                throw new a("Expected an int but was " + this.f10470m + " at path " + getPath());
            }
            this.f10470m = null;
            this.f10467j = 0;
            int[] iArr3 = this.f10462d;
            int i13 = this.f10459a - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return i12;
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f10470m + " at path " + getPath());
        }
    }

    public final void m0(j jVar) throws b, EOFException {
        while (true) {
            long jC = this.f10465h.c(jVar);
            if (jC == -1) {
                E("Unterminated string");
                throw null;
            }
            f fVar = this.f10466i;
            if (fVar.k(jC) != 92) {
                fVar.A(jC + 1);
                return;
            } else {
                fVar.A(jC + 1);
                l0();
            }
        }
    }

    @Override // v1.d
    public final String o() {
        String strT;
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I == 10) {
            strT = b0();
        } else if (I == 9) {
            strT = a0(f10464o);
        } else if (I == 8) {
            strT = a0(f10463n);
        } else if (I == 11) {
            strT = this.f10470m;
            this.f10470m = null;
        } else if (I == 16) {
            strT = Long.toString(this.f10468k);
        } else {
            if (I != 17) {
                throw new a("Expected a string but was " + s() + " at path " + getPath());
            }
            long j8 = this.f10469l;
            f fVar = this.f10466i;
            fVar.getClass();
            strT = fVar.t(j8, Charsets.UTF_8);
        }
        this.f10467j = 0;
        int[] iArr = this.f10462d;
        int i8 = this.f10459a - 1;
        iArr[i8] = iArr[i8] + 1;
        return strT;
    }

    @Override // v1.d
    public final c s() throws b, EOFException {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        switch (I) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.NAME;
            case 16:
            case 17:
                return c.NUMBER;
            case 18:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final String toString() {
        return "JsonReader(" + this.f10465h + ")";
    }

    @Override // v1.d
    public final int w(f5.a aVar) {
        int I = this.f10467j;
        if (I == 0) {
            I = I();
        }
        if (I < 12 || I > 15) {
            return -1;
        }
        if (I == 15) {
            return L(this.f10470m, aVar);
        }
        int iX = this.f10465h.x((p) aVar.f4985b);
        if (iX != -1) {
            this.f10467j = 0;
            this.f10461c[this.f10459a - 1] = ((String[]) aVar.f4984a)[iX];
            return iX;
        }
        String str = this.f10461c[this.f10459a - 1];
        String strS = S();
        int iL = L(strS, aVar);
        if (iL == -1) {
            this.f10467j = 15;
            this.f10470m = strS;
            this.f10461c[this.f10459a - 1] = str;
        }
        return iL;
    }
}
