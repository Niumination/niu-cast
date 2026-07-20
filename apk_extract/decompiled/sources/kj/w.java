package kj;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f6967d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f6968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f6969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.t f6970c;

    static {
        Logger logger = Logger.getLogger(h.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "Logger.getLogger(Http2::class.java.name)");
        f6967d = logger;
    }

    public w(qj.t source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f6970c = source;
        v vVar = new v(source);
        this.f6968a = vVar;
        this.f6969b = new e(vVar);
    }

    public final boolean a(boolean z2, n handler) throws IOException {
        c errorCode;
        int i8;
        c errorCode2;
        a0[] a0VarArr;
        int i9 = 1;
        Intrinsics.checkNotNullParameter(handler, "handler");
        int i10 = 0;
        try {
            this.f6970c.K(9L);
            int iS = ej.b.s(this.f6970c);
            if (iS > 16384) {
                throw new IOException(a1.a.o(iS, "FRAME_SIZE_ERROR: "));
            }
            int i11 = this.f6970c.readByte() & UByte.MAX_VALUE;
            byte b9 = this.f6970c.readByte();
            int i12 = b9 & UByte.MAX_VALUE;
            int i13 = this.f6970c.readInt();
            int i14 = i13 & Integer.MAX_VALUE;
            Logger logger = f6967d;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(h.a(true, i14, iS, i11, i12));
            }
            if (z2 && i11 != 4) {
                StringBuilder sb2 = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = h.f6920b;
                sb2.append(i11 < strArr.length ? strArr[i11] : ej.b.i("0x%02x", Integer.valueOf(i11)));
                throw new IOException(sb2.toString());
            }
            switch (i11) {
                case 0:
                    g(handler, iS, i12, i14);
                    return true;
                case 1:
                    i(handler, iS, i12, i14);
                    return true;
                case 2:
                    if (iS != 5) {
                        throw new IOException(h0.a.h(iS, "TYPE_PRIORITY length: ", " != 5"));
                    }
                    if (i14 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    qj.t tVar = this.f6970c;
                    tVar.readInt();
                    tVar.readByte();
                    handler.getClass();
                    return true;
                case 3:
                    if (iS != 4) {
                        throw new IOException(h0.a.h(iS, "TYPE_RST_STREAM length: ", " != 4"));
                    }
                    if (i14 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i15 = this.f6970c.readInt();
                    c.Companion.getClass();
                    c[] cVarArrValues = c.values();
                    int length = cVarArrValues.length;
                    while (true) {
                        if (i10 < length) {
                            errorCode = cVarArrValues[i10];
                            if (errorCode.getHttpCode() != i15) {
                                i10++;
                            }
                        } else {
                            errorCode = null;
                        }
                    }
                    if (errorCode == null) {
                        throw new IOException(a1.a.o(i15, "TYPE_RST_STREAM unexpected error code: "));
                    }
                    handler.getClass();
                    Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                    s sVar = handler.f6928b;
                    sVar.getClass();
                    if (i14 == 0 || (i13 & 1) != 0) {
                        a0 a0VarH = sVar.h(i14);
                        if (a0VarH != null) {
                            a0VarH.k(errorCode);
                        }
                    } else {
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        sVar.f6943k.c(new q(sVar.f6938c + '[' + i14 + "] onReset", sVar, i14, errorCode, 0), 0L);
                    }
                    return true;
                case 4:
                    if (i14 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((b9 & 1) != 0) {
                        if (iS != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        handler.getClass();
                    } else {
                        if (iS % 6 != 0) {
                            throw new IOException(a1.a.o(iS, "TYPE_SETTINGS length % 6 != 0: "));
                        }
                        e0 settings = new e0();
                        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, iS), 6);
                        int first = intProgressionStep.getFirst();
                        int last = intProgressionStep.getLast();
                        int step = intProgressionStep.getStep();
                        if (step < 0 ? first >= last : first <= last) {
                            while (true) {
                                qj.t tVar2 = this.f6970c;
                                short sK = tVar2.k();
                                byte[] bArr = ej.b.f4964a;
                                int i16 = sK & UShort.MAX_VALUE;
                                i8 = tVar2.readInt();
                                if (i16 != 2) {
                                    if (i16 == 3) {
                                        i16 = 4;
                                    } else if (i16 != 4) {
                                        if (i16 == 5 && (i8 < 16384 || i8 > 16777215)) {
                                        }
                                    } else {
                                        if (i8 < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                        i16 = 7;
                                    }
                                } else if (i8 != 0 && i8 != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                settings.c(i16, i8);
                                if (first != last) {
                                    first += step;
                                }
                            }
                            throw new IOException(a1.a.o(i8, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                        }
                        handler.getClass();
                        Intrinsics.checkNotNullParameter(settings, "settings");
                        s sVar2 = handler.f6928b;
                        sVar2.f6942j.c(new k(h0.a.n(new StringBuilder(), sVar2.f6938c, " applyAndAckSettings"), handler, settings, i9), 0L);
                    }
                    return true;
                case 5:
                    k(handler, iS, i12, i14);
                    return true;
                case 6:
                    if (iS != 8) {
                        throw new IOException(a1.a.o(iS, "TYPE_PING length != 8: "));
                    }
                    if (i14 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    int i17 = this.f6970c.readInt();
                    int i18 = this.f6970c.readInt();
                    if ((b9 & 1) != 0) {
                        synchronized (handler.f6928b) {
                            try {
                                if (i17 == 1) {
                                    handler.f6928b.f6946n++;
                                } else if (i17 != 2) {
                                    if (i17 == 3) {
                                        s sVar3 = handler.f6928b;
                                        sVar3.getClass();
                                        sVar3.notifyAll();
                                    }
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    handler.f6928b.p++;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } else {
                        handler.f6928b.f6942j.c(new m(h0.a.n(new StringBuilder(), handler.f6928b.f6938c, " ping"), handler, i17, i18), 0L);
                    }
                    return true;
                case 7:
                    if (iS < 8) {
                        throw new IOException(a1.a.o(iS, "TYPE_GOAWAY length < 8: "));
                    }
                    if (i14 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i19 = this.f6970c.readInt();
                    int i20 = this.f6970c.readInt();
                    int i21 = iS - 8;
                    c.Companion.getClass();
                    c[] cVarArrValues2 = c.values();
                    int length2 = cVarArrValues2.length;
                    int i22 = 0;
                    while (true) {
                        if (i22 < length2) {
                            c cVar = cVarArrValues2[i22];
                            if (cVar.getHttpCode() == i20) {
                                errorCode2 = cVar;
                            } else {
                                i22++;
                            }
                        } else {
                            errorCode2 = null;
                        }
                    }
                    if (errorCode2 == null) {
                        throw new IOException(a1.a.o(i20, "TYPE_GOAWAY unexpected error code: "));
                    }
                    qj.j debugData = qj.j.EMPTY;
                    if (i21 > 0) {
                        debugData = this.f6970c.g(i21);
                    }
                    handler.getClass();
                    Intrinsics.checkNotNullParameter(errorCode2, "errorCode");
                    Intrinsics.checkNotNullParameter(debugData, "debugData");
                    debugData.size();
                    synchronized (handler.f6928b) {
                        Object[] array = handler.f6928b.f6937b.values().toArray(new a0[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        a0VarArr = (a0[]) array;
                        handler.f6928b.f6940h = true;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    int length3 = a0VarArr.length;
                    while (i10 < length3) {
                        a0 a0Var = a0VarArr[i10];
                        if (a0Var.f6885m > i19 && a0Var.h()) {
                            a0Var.k(c.REFUSED_STREAM);
                            handler.f6928b.h(a0Var.f6885m);
                        }
                        i10++;
                    }
                    return true;
                case 8:
                    if (iS != 4) {
                        throw new IOException(a1.a.o(iS, "TYPE_WINDOW_UPDATE length !=4: "));
                    }
                    long j8 = ((long) this.f6970c.readInt()) & 2147483647L;
                    if (j8 == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    if (i14 == 0) {
                        synchronized (handler.f6928b) {
                            s sVar4 = handler.f6928b;
                            sVar4.f6952w += j8;
                            sVar4.notifyAll();
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else {
                        a0 a0VarG = handler.f6928b.g(i14);
                        if (a0VarG != null) {
                            synchronized (a0VarG) {
                                a0VarG.f6878d += j8;
                                if (j8 > 0) {
                                    a0VarG.notifyAll();
                                }
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                    }
                    return true;
                default:
                    this.f6970c.m(iS);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(n handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (!a(true, handler)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f6970c.close();
    }

    public final void g(n nVar, int i8, int i9, int i10) throws IOException {
        int i11;
        boolean z2;
        boolean z3;
        boolean z5;
        long j8;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (i9 & 1) != 0;
        if ((i9 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        if ((i9 & 8) != 0) {
            byte b9 = this.f6970c.readByte();
            byte[] bArr = ej.b.f4964a;
            i11 = b9 & UByte.MAX_VALUE;
        } else {
            i11 = 0;
        }
        int iA = u.a(i8, i9, i11);
        qj.t source = this.f6970c;
        nVar.getClass();
        Intrinsics.checkNotNullParameter(source, "source");
        nVar.f6928b.getClass();
        if (i10 != 0 && (i10 & 1) == 0) {
            s sVar = nVar.f6928b;
            sVar.getClass();
            Intrinsics.checkNotNullParameter(source, "source");
            qj.f fVar = new qj.f();
            long j10 = iA;
            source.K(j10);
            source.W(fVar, j10);
            sVar.f6943k.c(new o(sVar.f6938c + '[' + i10 + "] onData", sVar, i10, fVar, iA, z10), 0L);
        } else {
            a0 a0VarG = nVar.f6928b.g(i10);
            if (a0VarG == null) {
                nVar.f6928b.m(i10, c.PROTOCOL_ERROR);
                long j11 = iA;
                nVar.f6928b.k(j11);
                source.m(j11);
            } else {
                Intrinsics.checkNotNullParameter(source, "source");
                byte[] bArr2 = ej.b.f4964a;
                y yVar = a0VarG.f6879g;
                long j12 = iA;
                yVar.getClass();
                Intrinsics.checkNotNullParameter(source, "source");
                while (true) {
                    if (j12 <= 0) {
                        z2 = z10;
                        break;
                    }
                    synchronized (yVar.f6979h) {
                        z3 = yVar.e;
                        z2 = z10;
                        z5 = yVar.f6976b.f9195b + j12 > yVar.f6978d;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (z5) {
                        source.m(j12);
                        yVar.f6979h.e(c.FLOW_CONTROL_ERROR);
                        break;
                    }
                    if (z3) {
                        source.m(j12);
                        break;
                    }
                    long jW = source.W(yVar.f6975a, j12);
                    if (jW == -1) {
                        throw new EOFException();
                    }
                    j12 -= jW;
                    synchronized (yVar.f6979h) {
                        try {
                            if (yVar.f6977c) {
                                qj.f fVar2 = yVar.f6975a;
                                j8 = fVar2.f9195b;
                                fVar2.a();
                            } else {
                                qj.f fVar3 = yVar.f6976b;
                                boolean z11 = fVar3.f9195b == 0;
                                fVar3.N(yVar.f6975a);
                                if (z11) {
                                    a0 a0Var = yVar.f6979h;
                                    if (a0Var == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                    a0Var.notifyAll();
                                }
                                j8 = 0;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (j8 > 0) {
                        yVar.a(j8);
                    }
                    z10 = z2;
                }
                if (z2) {
                    a0VarG.j(ej.b.f4965b, true);
                }
            }
        }
        this.f6970c.m(i11);
    }

    public final List h(int i8, int i9, int i10, int i11) throws IOException {
        v vVar = this.f6968a;
        vVar.f6965d = i8;
        vVar.f6962a = i8;
        vVar.e = i9;
        vVar.f6963b = i10;
        vVar.f6964c = i11;
        while (true) {
            e eVar = this.f6969b;
            qj.t tVar = eVar.f6904b;
            boolean zT = tVar.T();
            ArrayList arrayList = eVar.f6903a;
            if (zT) {
                List list = CollectionsKt.toList(arrayList);
                arrayList.clear();
                return list;
            }
            byte b9 = tVar.readByte();
            byte[] bArr = ej.b.f4964a;
            int i12 = b9 & UByte.MAX_VALUE;
            if (i12 == 128) {
                throw new IOException("index == 0");
            }
            if ((b9 & ByteCompanionObject.MIN_VALUE) == 128) {
                int iE = eVar.e(i12, 127);
                int i13 = iE - 1;
                if (i13 >= 0) {
                    d[] dVarArr = g.f6917a;
                    if (i13 <= dVarArr.length - 1) {
                        arrayList.add(dVarArr[i13]);
                    }
                }
                int length = eVar.f6906d + 1 + (i13 - g.f6917a.length);
                if (length >= 0) {
                    d[] dVarArr2 = eVar.f6905c;
                    if (length < dVarArr2.length) {
                        d dVar = dVarArr2[length];
                        Intrinsics.checkNotNull(dVar);
                        arrayList.add(dVar);
                    }
                }
                throw new IOException(a1.a.o(iE, "Header index too large "));
            }
            if (i12 == 64) {
                d[] dVarArr3 = g.f6917a;
                qj.j jVarD = eVar.d();
                g.a(jVarD);
                eVar.c(new d(jVarD, eVar.d()));
            } else if ((b9 & 64) == 64) {
                eVar.c(new d(eVar.b(eVar.e(i12, 63) - 1), eVar.d()));
            } else if ((b9 & 32) == 32) {
                int iE2 = eVar.e(i12, 31);
                eVar.f6907g = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + eVar.f6907g);
                }
                int i14 = eVar.f;
                if (iE2 < i14) {
                    if (iE2 == 0) {
                        ArraysKt___ArraysJvmKt.fill$default(eVar.f6905c, (Object) null, 0, 0, 6, (Object) null);
                        eVar.f6906d = eVar.f6905c.length - 1;
                        eVar.e = 0;
                        eVar.f = 0;
                    } else {
                        eVar.a(i14 - iE2);
                    }
                }
            } else if (i12 == 16 || i12 == 0) {
                d[] dVarArr4 = g.f6917a;
                qj.j jVarD2 = eVar.d();
                g.a(jVarD2);
                arrayList.add(new d(jVarD2, eVar.d()));
            } else {
                arrayList.add(new d(eVar.b(eVar.e(i12, 15) - 1), eVar.d()));
            }
        }
    }

    public final void i(n nVar, int i8, int i9, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z2 = (i9 & 1) != 0;
        if ((i9 & 8) != 0) {
            byte b9 = this.f6970c.readByte();
            byte[] bArr = ej.b.f4964a;
            i11 = b9 & UByte.MAX_VALUE;
        } else {
            i11 = 0;
        }
        if ((i9 & 32) != 0) {
            qj.t tVar = this.f6970c;
            tVar.readInt();
            tVar.readByte();
            byte[] bArr2 = ej.b.f4964a;
            nVar.getClass();
            i8 -= 5;
        }
        List requestHeaders = h(u.a(i8, i9, i11), i11, i9, i10);
        nVar.getClass();
        Intrinsics.checkNotNullParameter(requestHeaders, "headerBlock");
        nVar.f6928b.getClass();
        if (i10 != 0 && (i10 & 1) == 0) {
            s sVar = nVar.f6928b;
            sVar.getClass();
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            sVar.f6943k.c(new p(sVar.f6938c + '[' + i10 + "] onHeaders", sVar, i10, requestHeaders, z2), 0L);
            return;
        }
        synchronized (nVar.f6928b) {
            a0 a0VarG = nVar.f6928b.g(i10);
            if (a0VarG == null) {
                s sVar2 = nVar.f6928b;
                if (!sVar2.f6940h && i10 > sVar2.f6939d && i10 % 2 != sVar2.e % 2) {
                    a0 a0Var = new a0(i10, nVar.f6928b, false, z2, ej.b.u(requestHeaders));
                    s sVar3 = nVar.f6928b;
                    sVar3.f6939d = i10;
                    sVar3.f6937b.put(Integer.valueOf(i10), a0Var);
                    nVar.f6928b.f6941i.e().c(new l(nVar.f6928b.f6938c + '[' + i10 + "] onStream", a0Var, nVar, requestHeaders), 0L);
                }
            } else {
                Unit unit = Unit.INSTANCE;
                a0VarG.j(ej.b.u(requestHeaders), z2);
            }
        }
    }

    public final void k(n nVar, int i8, int i9, int i10) throws IOException {
        int i11;
        if (i10 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i9 & 8) != 0) {
            byte b9 = this.f6970c.readByte();
            byte[] bArr = ej.b.f4964a;
            i11 = b9 & UByte.MAX_VALUE;
        } else {
            i11 = 0;
        }
        int i12 = this.f6970c.readInt() & Integer.MAX_VALUE;
        List requestHeaders = h(u.a(i8 - 4, i9, i11), i11, i9, i10);
        nVar.getClass();
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        s sVar = nVar.f6928b;
        sVar.getClass();
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (sVar) {
            if (sVar.A.contains(Integer.valueOf(i12))) {
                sVar.m(i12, c.PROTOCOL_ERROR);
                return;
            }
            sVar.A.add(Integer.valueOf(i12));
            sVar.f6943k.c(new p(sVar.f6938c + '[' + i12 + "] onRequest", sVar, i12, requestHeaders), 0L);
        }
    }
}
