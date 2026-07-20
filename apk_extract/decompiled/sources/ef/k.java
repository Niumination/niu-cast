package ef;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f4937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f4939d;

    public k(t tVar, boolean z2) {
        this.f4936a = tVar;
        this.f4938c = z2;
        i iVar = new i(tVar);
        this.f4937b = iVar;
        this.f4939d = new f(iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(b bVar) throws IOException {
        t tVar = this.f4936a;
        try {
            tVar.K(9L);
            int iA = m.a(tVar);
            if (iA < 0 || iA > 16384) {
                m.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
                throw null;
            }
            byte b9 = (byte) (tVar.readByte() & UByte.MAX_VALUE);
            byte b10 = (byte) (tVar.readByte() & UByte.MAX_VALUE);
            int i8 = tVar.readInt() & Integer.MAX_VALUE;
            Logger logger = m.f4945a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(j.a(true, i8, iA, b9, b10));
            }
            switch (b9) {
                case 0:
                    boolean z2 = (b10 & 1) != 0;
                    if ((b10 & 32) != 0) {
                        m.c("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                        throw null;
                    }
                    short s2 = (b10 & 8) != 0 ? (short) (tVar.readByte() & UByte.MAX_VALUE) : (short) 0;
                    bVar.n(z2, i8, tVar, m.b(iA, b10, s2), iA);
                    tVar.m(s2);
                    return true;
                case 1:
                    if (i8 == 0) {
                        m.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                        throw null;
                    }
                    boolean z3 = (b10 & 1) != 0;
                    short s3 = (8 & b10) != 0 ? (short) (tVar.readByte() & UByte.MAX_VALUE) : (short) 0;
                    if ((b10 & 32) != 0) {
                        h(bVar, i8);
                        iA -= 5;
                    }
                    ArrayList arrayListG = g(m.b(iA, b10, s3), s3, b10, i8);
                    e eVar = e.SPDY_SYN_STREAM;
                    bVar.o(arrayListG, i8, z3);
                    return true;
                case 2:
                    if (iA != 5) {
                        m.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i8 != 0) {
                        h(bVar, i8);
                        return true;
                    }
                    m.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                    throw null;
                case 3:
                    if (iA != 4) {
                        m.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i8 == 0) {
                        m.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int i9 = tVar.readInt();
                    a aVarFromHttp2 = a.fromHttp2(i9);
                    if (aVarFromHttp2 != null) {
                        bVar.f(i8, aVarFromHttp2);
                        return true;
                    }
                    m.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i9));
                    throw null;
                case 4:
                    if (i8 != 0) {
                        m.c("TYPE_SETTINGS streamId != 0", new Object[0]);
                        throw null;
                    }
                    if ((b10 & 1) == 0) {
                        if (iA % 6 != 0) {
                            m.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(iA));
                            throw null;
                        }
                        o oVar = new o();
                        for (int i10 = 0; i10 < iA; i10 += 6) {
                            short sK = tVar.k();
                            int i11 = tVar.readInt();
                            switch (sK) {
                                case 1:
                                case 6:
                                    break;
                                case 2:
                                    if (i11 != 0 && i11 != 1) {
                                        m.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                        throw null;
                                    }
                                    break;
                                case 3:
                                    sK = 4;
                                    break;
                                case 4:
                                    if (i11 < 0) {
                                        m.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                        throw null;
                                    }
                                    sK = 7;
                                    break;
                                    break;
                                case 5:
                                    if (i11 < 16384 || i11 > 16777215) {
                                        m.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i11));
                                        throw null;
                                    }
                                    break;
                                default:
                                    continue;
                                    break;
                            }
                            oVar.c(sK, i11);
                        }
                        bVar.e(oVar);
                        int i12 = oVar.f4951a;
                        int i13 = i12 & 2;
                        int[] iArr = (int[]) oVar.f4952b;
                        if ((i13 != 0 ? iArr[1] : -1) >= 0) {
                            int i14 = (i12 & 2) != 0 ? iArr[1] : -1;
                            f fVar = this.f4939d;
                            fVar.f4917c = i14;
                            fVar.f4918d = i14;
                            int i15 = fVar.f4920h;
                            if (i14 < i15) {
                                if (i14 == 0) {
                                    Arrays.fill(fVar.e, (Object) null);
                                    fVar.f = fVar.e.length - 1;
                                    fVar.f4919g = 0;
                                    fVar.f4920h = 0;
                                } else {
                                    fVar.a(i15 - i14);
                                }
                            }
                        }
                    } else if (iA != 0) {
                        m.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                        throw null;
                    }
                    return true;
                case 5:
                    if (i8 == 0) {
                        m.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                        throw null;
                    }
                    short s10 = (8 & b10) != 0 ? (short) (tVar.readByte() & UByte.MAX_VALUE) : (short) 0;
                    bVar.k(g(m.b(iA - 4, b10, s10), s10, b10, i8), i8, tVar.readInt() & Integer.MAX_VALUE);
                    return true;
                case 6:
                    if (iA != 8) {
                        m.c("TYPE_PING length != 8: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i8 != 0) {
                        m.c("TYPE_PING streamId != 0", new Object[0]);
                        throw null;
                    }
                    bVar.j((b10 & 1) != 0, tVar.readInt(), tVar.readInt());
                    return true;
                case 7:
                    if (iA < 8) {
                        m.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i8 != 0) {
                        m.c("TYPE_GOAWAY streamId != 0", new Object[0]);
                        throw null;
                    }
                    int i16 = tVar.readInt();
                    int i17 = tVar.readInt();
                    int i18 = iA - 8;
                    a aVarFromHttp3 = a.fromHttp2(i17);
                    if (aVarFromHttp3 == null) {
                        m.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i17));
                        throw null;
                    }
                    qj.j jVarG = qj.j.EMPTY;
                    if (i18 > 0) {
                        jVarG = tVar.g(i18);
                    }
                    bVar.l(i16, aVarFromHttp3, jVarG);
                    return true;
                case 8:
                    if (iA != 4) {
                        m.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    long j8 = ((long) tVar.readInt()) & 2147483647L;
                    if (j8 != 0) {
                        bVar.d(i8, j8);
                        return true;
                    }
                    m.c("windowSizeIncrement was 0", new Object[0]);
                    throw null;
                default:
                    tVar.m(iA);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public final void c() throws IOException {
        if (this.f4938c) {
            return;
        }
        qj.j jVar = m.f4946b;
        qj.j jVarG = this.f4936a.g(jVar.size());
        Logger logger = m.f4945a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("<< CONNECTION " + jVarG.hex());
        }
        if (jVar.equals(jVarG)) {
            return;
        }
        m.c("Expected a connection header but was %s", jVarG.utf8());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4936a.close();
    }

    public final ArrayList g(int i8, short s2, byte b9, int i9) throws IOException {
        i iVar = this.f4937b;
        iVar.e = i8;
        iVar.f4929b = i8;
        iVar.f4932h = s2;
        iVar.f4930c = b9;
        iVar.f4931d = i9;
        while (true) {
            f fVar = this.f4939d;
            t tVar = fVar.f4916b;
            boolean zT = tVar.T();
            ArrayList arrayList = fVar.f4915a;
            if (zT) {
                ArrayList arrayList2 = new ArrayList(arrayList);
                arrayList.clear();
                return arrayList2;
            }
            byte b10 = tVar.readByte();
            int i10 = b10 & UByte.MAX_VALUE;
            if (i10 == 128) {
                throw new IOException("index == 0");
            }
            if ((b10 & ByteCompanionObject.MIN_VALUE) == 128) {
                int iE = fVar.e(i10, 127);
                int i11 = iE - 1;
                if (i11 >= 0) {
                    d[] dVarArr = h.f4926b;
                    if (i11 <= dVarArr.length - 1) {
                        arrayList.add(dVarArr[i11]);
                    }
                }
                int length = fVar.f + 1 + (i11 - h.f4926b.length);
                if (length >= 0) {
                    d[] dVarArr2 = fVar.e;
                    if (length <= dVarArr2.length - 1) {
                        arrayList.add(dVarArr2[length]);
                    }
                }
                throw new IOException(a1.a.o(iE, "Header index too large "));
            }
            if (i10 == 64) {
                qj.j jVarD = fVar.d();
                h.a(jVarD);
                fVar.c(new d(jVarD, fVar.d()));
            } else if ((b10 & 64) == 64) {
                fVar.c(new d(fVar.b(fVar.e(i10, 63) - 1), fVar.d()));
            } else if ((b10 & 32) == 32) {
                int iE2 = fVar.e(i10, 31);
                fVar.f4918d = iE2;
                if (iE2 < 0 || iE2 > fVar.f4917c) {
                    throw new IOException("Invalid dynamic table size update " + fVar.f4918d);
                }
                int i12 = fVar.f4920h;
                if (iE2 < i12) {
                    if (iE2 == 0) {
                        Arrays.fill(fVar.e, (Object) null);
                        fVar.f = fVar.e.length - 1;
                        fVar.f4919g = 0;
                        fVar.f4920h = 0;
                    } else {
                        fVar.a(i12 - iE2);
                    }
                }
            } else if (i10 == 16 || i10 == 0) {
                qj.j jVarD2 = fVar.d();
                h.a(jVarD2);
                arrayList.add(new d(jVarD2, fVar.d()));
            } else {
                arrayList.add(new d(fVar.b(fVar.e(i10, 15) - 1), fVar.d()));
            }
        }
    }

    public final void h(b bVar, int i8) throws EOFException {
        t tVar = this.f4936a;
        int i9 = tVar.readInt();
        bVar.m(i8, i9 & Integer.MAX_VALUE, (tVar.readByte() & UByte.MAX_VALUE) + 1, (Integer.MIN_VALUE & i9) != 0);
    }
}
