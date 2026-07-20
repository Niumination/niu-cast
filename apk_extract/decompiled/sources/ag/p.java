package ag;

import java.nio.charset.Charset;
import k3.ha;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f777a = new k(2048, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f779c;

    static {
        Charset charset = Charsets.UTF_8;
        f778b = lh.a.i("\r\n", charset);
        f779c = lh.a.i("0\r\n\r\n", charset);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(jh.j0 j0Var, byte[] bArr, int i8, int i9, ContinuationImpl continuationImpl) {
        o oVar;
        int i10;
        jh.j0 j0Var2;
        int i11;
        byte[] bArr2;
        int i12;
        jh.j0 j0Var3;
        byte[] bArr3;
        if (continuationImpl instanceof o) {
            oVar = (o) continuationImpl;
            int i13 = oVar.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                oVar.label = i13 - Integer.MIN_VALUE;
            } else {
                oVar = new o(continuationImpl);
            }
        } else {
            oVar = new o(continuationImpl);
        }
        Object obj = oVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i14 = oVar.label;
        if (i14 != 0) {
            if (i14 == 1) {
                int i15 = oVar.I$2;
                i9 = oVar.I$1;
                i8 = oVar.I$0;
                bArr = (byte[]) oVar.L$1;
                jh.j0 j0Var4 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                i10 = i15;
                j0Var = j0Var4;
            } else if (i14 == 2) {
                i11 = oVar.I$2;
                i12 = oVar.I$1;
                i8 = oVar.I$0;
                bArr2 = (byte[]) oVar.L$1;
                j0Var2 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                oVar.L$0 = j0Var2;
                oVar.L$1 = null;
                oVar.I$0 = i11;
                oVar.label = 3;
                if (jh.o0.d(j0Var2, bArr2, i8, i12, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j0Var3 = j0Var2;
                oVar.L$0 = j0Var3;
                oVar.I$0 = i11;
                oVar.label = 4;
                jh.l0 l0Var = jh.o0.f6300a;
                bArr3 = f778b;
                if (jh.o0.d(j0Var3, bArr3, 0, bArr3.length, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.I$0 = i11;
                oVar.label = 5;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i14 == 3) {
                i11 = oVar.I$0;
                j0Var3 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                oVar.L$0 = j0Var3;
                oVar.I$0 = i11;
                oVar.label = 4;
                jh.l0 l0Var2 = jh.o0.f6300a;
                bArr3 = f778b;
                if (jh.o0.d(j0Var3, bArr3, 0, bArr3.length, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.I$0 = i11;
                oVar.label = 5;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i14 == 4) {
                i11 = oVar.I$0;
                j0Var3 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                oVar.L$0 = null;
                oVar.I$0 = i11;
                oVar.label = 5;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i14 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i11 = oVar.I$0;
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxInt(i11);
        }
        ResultKt.throwOnFailure(obj);
        i10 = i9 - i8;
        oVar.L$0 = j0Var;
        oVar.L$1 = bArr;
        oVar.I$0 = i8;
        oVar.I$1 = i9;
        oVar.I$2 = i10;
        oVar.label = 1;
        if (bg.g.g(j0Var, i10, oVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        oVar.L$0 = j0Var;
        oVar.L$1 = bArr;
        oVar.I$0 = i8;
        oVar.I$1 = i9;
        oVar.I$2 = i10;
        oVar.label = 2;
        jh.l0 l0Var3 = jh.o0.f6300a;
        jh.k kVar = (jh.k) j0Var;
        kVar.k().t((short) 3338);
        Object objB = ha.b(kVar, oVar);
        if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objB = Unit.INSTANCE;
        }
        if (objB == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0Var2 = j0Var;
        i11 = i10;
        int i16 = i9;
        bArr2 = bArr;
        i12 = i16;
        oVar.L$0 = j0Var2;
        oVar.L$1 = null;
        oVar.I$0 = i11;
        oVar.label = 3;
        if (jh.o0.d(j0Var2, bArr2, i8, i12, oVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0Var3 = j0Var2;
        oVar.L$0 = j0Var3;
        oVar.I$0 = i11;
        oVar.label = 4;
        jh.l0 l0Var4 = jh.o0.f6300a;
        bArr3 = f778b;
        if (jh.o0.d(j0Var3, bArr3, 0, bArr3.length, oVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        oVar.L$0 = null;
        oVar.I$0 = i11;
        oVar.label = 5;
        if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Boxing.boxInt(i11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0157 -> B:17:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5101. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static final java.lang.Object b(jh.o r20, jh.j0 r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.p.b(jh.o, jh.j0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:116:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[LOOP:0: B:104:0x009a->B:118:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a0 A[Catch: all -> 0x00d5, TryCatch #1 {all -> 0x00d5, blocks: (B:35:0x009a, B:37:0x00a0, B:39:0x00a6, B:41:0x00b0, B:80:0x0175, B:82:0x0179, B:85:0x0184, B:94:0x01b2), top: B:104:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b0 A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #1 {all -> 0x00d5, blocks: (B:35:0x009a, B:37:0x00a0, B:39:0x00a6, B:41:0x00b0, B:80:0x0175, B:82:0x0179, B:85:0x0184, B:94:0x01b2), top: B:104:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00df A[Catch: all -> 0x0108, TryCatch #2 {all -> 0x0108, blocks: (B:50:0x00d9, B:52:0x00df, B:54:0x00f2, B:56:0x00ff, B:59:0x010e, B:77:0x0169, B:78:0x0170), top: B:105:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2 A[Catch: all -> 0x0108, TryCatch #2 {all -> 0x0108, blocks: (B:50:0x00d9, B:52:0x00df, B:54:0x00f2, B:56:0x00ff, B:59:0x010e, B:77:0x0169, B:78:0x0170), top: B:105:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ff A[Catch: all -> 0x0108, TryCatch #2 {all -> 0x0108, blocks: (B:50:0x00d9, B:52:0x00df, B:54:0x00f2, B:56:0x00ff, B:59:0x010e, B:77:0x0169, B:78:0x0170), top: B:105:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x010e A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #2 {all -> 0x0108, blocks: (B:50:0x00d9, B:52:0x00df, B:54:0x00f2, B:56:0x00ff, B:59:0x010e, B:77:0x0169, B:78:0x0170), top: B:105:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0123  */
    /* JADX WARN: Code duplicated, block: B:66:0x0143  */
    /* JADX WARN: Code duplicated, block: B:67:0x0145 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:64:0x0137, B:67:0x0145, B:69:0x014b, B:72:0x0155, B:73:0x015c, B:74:0x015d, B:75:0x0164), top: B:103:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x014b A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:64:0x0137, B:67:0x0145, B:69:0x014b, B:72:0x0155, B:73:0x015c, B:74:0x015d, B:75:0x0164), top: B:103:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0155 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:64:0x0137, B:67:0x0145, B:69:0x014b, B:72:0x0155, B:73:0x015c, B:74:0x015d, B:75:0x0164), top: B:103:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x015d A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:64:0x0137, B:67:0x0145, B:69:0x014b, B:72:0x0155, B:73:0x015c, B:74:0x015d, B:75:0x0164), top: B:103:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0169 A[Catch: all -> 0x0108, TRY_ENTER, TryCatch #2 {all -> 0x0108, blocks: (B:50:0x00d9, B:52:0x00df, B:54:0x00f2, B:56:0x00ff, B:59:0x010e, B:77:0x0169, B:78:0x0170), top: B:105:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0171  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00ff -> B:103:0x0137). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0123 -> B:63:0x012e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0171 -> B:104:0x009a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:37:0x00a0
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(jh.o r17, jh.j0 r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.p.c(jh.o, jh.j0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
