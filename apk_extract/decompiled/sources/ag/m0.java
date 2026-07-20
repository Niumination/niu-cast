package ag;

import java.io.EOFException;
import java.io.IOException;
import jh.u0;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xi.a f773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xi.a f774b;

    static {
        byte[] bArrI = lh.a.i("\r\n", Charsets.UTF_8);
        f773a = new xi.a(bArrI, 0, bArrI.length);
        byte[] byteArray = {45, 45};
        Intrinsics.checkNotNullParameter(byteArray, "bytes");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        f774b = new xi.a(byteArray);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public static final Object a(xi.a aVar, u0 u0Var, jh.k kVar, v vVar, long j8, ContinuationImpl continuationImpl) throws Throwable {
        j0 j0Var;
        xi.a aVar2;
        jh.j0 j0Var2;
        long jLongValue;
        long jLongValue2;
        Object objC;
        long j10;
        jh.o oVar = u0Var;
        jh.j0 j0Var3 = kVar;
        if (continuationImpl instanceof j0) {
            j0Var = (j0) continuationImpl;
            int i8 = j0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                j0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                j0Var = new j0(continuationImpl);
            }
        } else {
            j0Var = new j0(continuationImpl);
        }
        j0 j0Var4 = j0Var;
        Object objC2 = j0Var4.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = j0Var4.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objC2);
            bg.b bVarB = vVar.b("Content-Length");
            Long lBoxLong = bVarB != null ? Boxing.boxLong(bg.g.e(bVarB)) : null;
            if (lBoxLong == null) {
                j0Var4.L$0 = j0Var3;
                j0Var4.label = 1;
                objC2 = jh.g0.n(u0Var, aVar, kVar, j8, true, j0Var4);
                if (objC2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j0Var2 = j0Var3;
                jLongValue = ((Number) objC2).longValue();
                j0Var4.L$0 = null;
                j0Var4.J$0 = jLongValue;
                j0Var4.label = 4;
                if (((jh.k) j0Var2).h(j0Var4) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!new LongRange(0L, j8).contains(lBoxLong.longValue())) {
                    long jLongValue3 = lBoxLong.longValue();
                    StringBuilder sb2 = new StringBuilder("Multipart content length exceeds limit ");
                    sb2.append(jLongValue3);
                    sb2.append(" > ");
                    throw new IOException(o.d.p(sb2, j8, "; limit is defined using 'formFieldLimit' argument"));
                }
                long jLongValue4 = lBoxLong.longValue();
                aVar2 = aVar;
                j0Var4.L$0 = aVar2;
                j0Var4.L$1 = oVar;
                j0Var4.L$2 = j0Var3;
                j0Var4.label = 2;
                objC2 = jh.g0.c(oVar, j0Var3, jLongValue4, j0Var4);
                if (objC2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jLongValue2 = ((Number) objC2).longValue();
                j0Var4.L$0 = j0Var3;
                j0Var4.L$1 = null;
                j0Var4.L$2 = null;
                j0Var4.J$0 = jLongValue2;
                j0Var4.label = 3;
                objC = c(oVar, aVar2, j0Var4);
                if (objC == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j10 = jLongValue2;
                objC2 = objC;
                j0Var2 = j0Var3;
                jLongValue = ((Number) objC2).longValue() + j10;
                j0Var4.L$0 = null;
                j0Var4.J$0 = jLongValue;
                j0Var4.label = 4;
                if (((jh.k) j0Var2).h(j0Var4) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i9 == 1) {
            j0Var2 = (jh.j0) j0Var4.L$0;
            ResultKt.throwOnFailure(objC2);
            jLongValue = ((Number) objC2).longValue();
            j0Var4.L$0 = null;
            j0Var4.J$0 = jLongValue;
            j0Var4.label = 4;
            if (((jh.k) j0Var2).h(j0Var4) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i9 == 2) {
            jh.j0 j0Var5 = (jh.j0) j0Var4.L$2;
            jh.o oVar2 = (jh.o) j0Var4.L$1;
            aVar2 = (xi.a) j0Var4.L$0;
            ResultKt.throwOnFailure(objC2);
            j0Var3 = j0Var5;
            oVar = oVar2;
            jLongValue2 = ((Number) objC2).longValue();
            j0Var4.L$0 = j0Var3;
            j0Var4.L$1 = null;
            j0Var4.L$2 = null;
            j0Var4.J$0 = jLongValue2;
            j0Var4.label = 3;
            objC = c(oVar, aVar2, j0Var4);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
            j10 = jLongValue2;
            objC2 = objC;
            j0Var2 = j0Var3;
            jLongValue = ((Number) objC2).longValue() + j10;
            j0Var4.L$0 = null;
            j0Var4.J$0 = jLongValue;
            j0Var4.label = 4;
            if (((jh.k) j0Var2).h(j0Var4) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i9 == 3) {
            j10 = j0Var4.J$0;
            j0Var2 = (jh.j0) j0Var4.L$0;
            ResultKt.throwOnFailure(objC2);
            jLongValue = ((Number) objC2).longValue() + j10;
            j0Var4.L$0 = null;
            j0Var4.J$0 = jLongValue;
            j0Var4.label = 4;
            if (((jh.k) j0Var2).h(j0Var4) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jLongValue = j0Var4.J$0;
            ResultKt.throwOnFailure(objC2);
        }
        return Boxing.boxLong(jLongValue);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(u0 u0Var, ContinuationImpl continuationImpl) throws Throwable {
        k0 k0Var;
        Throwable th2;
        bg.c cVar;
        if (continuationImpl instanceof k0) {
            k0Var = (k0) continuationImpl;
            int i8 = k0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                k0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                k0Var = new k0(continuationImpl);
            }
        } else {
            k0Var = new k0(continuationImpl);
        }
        Object obj = k0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = k0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            bg.c cVar2 = new bg.c();
            try {
                k0Var.L$0 = cVar2;
                k0Var.label = 1;
                Object objD = b0.d(u0Var, cVar2, new bg.h(), k0Var);
                if (objD != coroutine_suspended) {
                    obj = objD;
                    cVar = cVar2;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th2 = th3;
                cVar = cVar2;
                cVar.e();
                throw th2;
            }
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        cVar = (bg.c) k0Var.L$0;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Throwable th4) {
            th2 = th4;
            cVar.e();
            throw th2;
        }
        coroutine_suspended = (v) obj;
        if (coroutine_suspended == null) {
            throw new EOFException("Failed to parse multipart headers: unexpected end of stream");
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(jh.o oVar, xi.a aVar, ContinuationImpl continuationImpl) {
        l0 l0Var;
        if (continuationImpl instanceof l0) {
            l0Var = (l0) continuationImpl;
            int i8 = l0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                l0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                l0Var = new l0(continuationImpl);
            }
        } else {
            l0Var = new l0(continuationImpl);
        }
        Object objQ = l0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = l0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objQ);
            l0Var.L$0 = aVar;
            l0Var.label = 1;
            objQ = jh.g0.q(oVar, aVar, l0Var);
            if (objQ == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (xi.a) l0Var.L$0;
            ResultKt.throwOnFailure(objQ);
        }
        return Boxing.boxLong(((Boolean) objQ).booleanValue() ? aVar.f11008a.length : 0L);
    }
}
