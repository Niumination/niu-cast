package hg;

import af.r5;
import java.io.EOFException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k3.ha;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final byte[] a(SecretKeySpec secret, byte[] label, byte[] seed, int i8) throws NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(seed, "seed");
        byte[] bArrPlus = ArraysKt.plus(label, seed);
        Mac mac = Mac.getInstance(secret.getAlgorithm());
        Intrinsics.checkNotNullExpressionValue(mac, "getInstance(...)");
        if (i8 < 12) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        byte[] bArrPlus2 = new byte[0];
        byte[] bArrDoFinal = bArrPlus;
        while (bArrPlus2.length < i8) {
            mac.reset();
            mac.init(secret);
            mac.update(bArrDoFinal);
            bArrDoFinal = mac.doFinal();
            mac.reset();
            mac.init(secret);
            mac.update(bArrDoFinal);
            mac.update(bArrPlus);
            byte[] bArrDoFinal2 = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal2, "doFinal(...)");
            bArrPlus2 = ArraysKt.plus(bArrPlus2, bArrDoFinal2);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArrPlus2, i8);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(gg.s sVar, jh.k kVar, jh.k kVar2, r5 r5Var, CoroutineContext coroutineContext, ContinuationImpl continuationImpl) throws p0 {
        m0 m0Var;
        gg.s sVar2;
        l0 l0Var;
        if (continuationImpl instanceof m0) {
            m0Var = (m0) continuationImpl;
            int i8 = m0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                m0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                m0Var = new m0(continuationImpl);
            }
        } else {
            m0Var = new m0(continuationImpl);
        }
        Object obj = m0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = m0Var.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                l0 l0Var2 = new l0(kVar, kVar2, r5Var, coroutineContext);
                m0Var.L$0 = sVar;
                m0Var.L$1 = coroutineContext;
                m0Var.L$2 = l0Var2;
                m0Var.label = 1;
                if (l0Var2.f(m0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar2 = sVar;
                l0Var = l0Var2;
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l0Var = (l0) m0Var.L$2;
                coroutineContext = (CoroutineContext) m0Var.L$1;
                sVar2 = (gg.s) m0Var.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return new d1(l0Var.f5371i, l0Var.f5372j, sVar2, coroutineContext);
        } catch (ni.x e) {
            throw new p0("Negotiation failed due to EOS", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(jh.o oVar, ContinuationImpl continuationImpl) throws EOFException {
        k kVar;
        int i8;
        if (continuationImpl instanceof k) {
            kVar = (k) continuationImpl;
            int i9 = kVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                kVar.label = i9 - Integer.MIN_VALUE;
            } else {
                kVar = new k(continuationImpl);
            }
        } else {
            kVar = new k(continuationImpl);
        }
        Object objI = kVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = kVar.label;
        if (i10 != 0) {
            if (i10 == 1) {
                oVar = (jh.o) kVar.L$0;
                ResultKt.throwOnFailure(objI);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i8 = kVar.I$0;
                ResultKt.throwOnFailure(objI);
            }
            return Boxing.boxInt((i8 << 8) + (((Number) objI).byteValue() & UByte.MAX_VALUE));
        }
        ResultKt.throwOnFailure(objI);
        kVar.L$0 = oVar;
        kVar.label = 1;
        objI = jh.g0.i(oVar, kVar);
        if (objI == coroutine_suspended) {
            return coroutine_suspended;
        }
        int iByteValue = ((Number) objI).byteValue() & UByte.MAX_VALUE;
        kVar.L$0 = null;
        kVar.I$0 = iByteValue;
        kVar.label = 2;
        Object objI2 = jh.g0.i(oVar, kVar);
        if (objI2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        objI = objI2;
        i8 = iByteValue;
        return Boxing.boxInt((i8 << 8) + (((Number) objI).byteValue() & UByte.MAX_VALUE));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(jh.o oVar, ContinuationImpl continuationImpl) throws p0, EOFException {
        l lVar;
        jh.o oVar2;
        u0 u0Var;
        v0 v0Var;
        f1 f1Var;
        Object objC;
        v0 v0Var2;
        f1 f1Var2;
        jh.o oVar3;
        int iIntValue;
        v0 v0Var3;
        if (continuationImpl instanceof l) {
            lVar = (l) continuationImpl;
            int i8 = lVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                lVar.label = i8 - Integer.MIN_VALUE;
            } else {
                lVar = new l(continuationImpl);
            }
        } else {
            lVar = new l(continuationImpl);
        }
        Object objE = lVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = lVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                u0Var = (u0) lVar.L$1;
                oVar2 = (jh.o) lVar.L$0;
                ResultKt.throwOnFailure(objE);
            } else if (i9 == 2) {
                v0Var = (v0) lVar.L$1;
                oVar2 = (jh.o) lVar.L$0;
                ResultKt.throwOnFailure(objE);
                f1Var = (f1) objE;
                lVar.L$0 = oVar2;
                lVar.L$1 = v0Var;
                lVar.L$2 = f1Var;
                lVar.label = 3;
                objC = c(oVar2, lVar);
                if (objC == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jh.o oVar4 = oVar2;
                v0Var2 = v0Var;
                f1Var2 = f1Var;
                objE = objC;
                oVar3 = oVar4;
                iIntValue = ((Number) objE).intValue() & 65535;
                if (iIntValue > 18432) {
                    throw new p0(a1.a.o(iIntValue, "Illegal TLS frame size: "), null, 2, null);
                }
                lVar.L$0 = v0Var2;
                lVar.L$1 = f1Var2;
                lVar.L$2 = null;
                lVar.label = 4;
                objE = jh.g0.j(oVar3, iIntValue, lVar);
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                v0Var3 = v0Var2;
            } else if (i9 == 3) {
                f1Var2 = (f1) lVar.L$2;
                v0Var2 = (v0) lVar.L$1;
                oVar3 = (jh.o) lVar.L$0;
                ResultKt.throwOnFailure(objE);
                iIntValue = ((Number) objE).intValue() & 65535;
                if (iIntValue > 18432) {
                    throw new p0(a1.a.o(iIntValue, "Illegal TLS frame size: "), null, 2, null);
                }
                lVar.L$0 = v0Var2;
                lVar.L$1 = f1Var2;
                lVar.L$2 = null;
                lVar.label = 4;
                objE = jh.g0.j(oVar3, iIntValue, lVar);
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                v0Var3 = v0Var2;
            } else {
                if (i9 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f1Var2 = (f1) lVar.L$1;
                v0Var3 = (v0) lVar.L$0;
                ResultKt.throwOnFailure(objE);
            }
            return new t0(v0Var3, f1Var2, (wi.k) objE);
        }
        ResultKt.throwOnFailure(objE);
        u0 u0Var2 = v0.Companion;
        lVar.L$0 = oVar;
        lVar.L$1 = u0Var2;
        lVar.label = 1;
        Object objI = jh.g0.i(oVar, lVar);
        if (objI == coroutine_suspended) {
            return coroutine_suspended;
        }
        oVar2 = oVar;
        u0Var = u0Var2;
        objE = objI;
        int iByteValue = ((Number) objE).byteValue() & UByte.MAX_VALUE;
        u0Var.getClass();
        v0Var = (iByteValue < 0 || iByteValue >= 256) ? null : v0.byCode[iByteValue];
        if (v0Var == null) {
            throw new IllegalArgumentException(a1.a.o(iByteValue, "Invalid TLS record type code: "));
        }
        lVar.L$0 = oVar2;
        lVar.L$1 = v0Var;
        lVar.label = 2;
        objE = e(oVar2, lVar);
        if (objE == coroutine_suspended) {
            return coroutine_suspended;
        }
        f1Var = (f1) objE;
        lVar.L$0 = oVar2;
        lVar.L$1 = v0Var;
        lVar.L$2 = f1Var;
        lVar.label = 3;
        objC = c(oVar2, lVar);
        if (objC == coroutine_suspended) {
            return coroutine_suspended;
        }
        jh.o oVar5 = oVar2;
        v0Var2 = v0Var;
        f1Var2 = f1Var;
        objE = objC;
        oVar3 = oVar5;
        iIntValue = ((Number) objE).intValue() & 65535;
        if (iIntValue > 18432) {
            throw new p0(a1.a.o(iIntValue, "Illegal TLS frame size: "), null, 2, null);
        }
        lVar.L$0 = v0Var2;
        lVar.L$1 = f1Var2;
        lVar.L$2 = null;
        lVar.label = 4;
        objE = jh.g0.j(oVar3, iIntValue, lVar);
        if (objE == coroutine_suspended) {
            return coroutine_suspended;
        }
        v0Var3 = v0Var2;
        return new t0(v0Var3, f1Var2, (wi.k) objE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object e(jh.o oVar, ContinuationImpl continuationImpl) throws EOFException {
        m mVar;
        e1 e1Var;
        if (continuationImpl instanceof m) {
            mVar = (m) continuationImpl;
            int i8 = mVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                mVar.label = i8 - Integer.MIN_VALUE;
            } else {
                mVar = new m(continuationImpl);
            }
        } else {
            mVar = new m(continuationImpl);
        }
        Object obj = mVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = mVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            e1 e1Var2 = f1.Companion;
            mVar.L$0 = e1Var2;
            mVar.label = 1;
            Object objC = c(oVar, mVar);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objC;
            e1Var = e1Var2;
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1Var = (e1) mVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int iIntValue = ((Number) obj).intValue() & 65535;
        e1Var.getClass();
        return e1.a(iIntValue);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object f(gg.m mVar, CoroutineContext coroutineContext, r5 r5Var, ContinuationImpl continuationImpl) throws IOException {
        n0 n0Var;
        if (continuationImpl instanceof n0) {
            n0Var = (n0) continuationImpl;
            int i8 = n0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                n0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                n0Var = new n0(continuationImpl);
            }
        } else {
            n0Var = new n0(continuationImpl);
        }
        n0 n0Var2 = n0Var;
        Object objB = n0Var2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = n0Var2.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objB);
                gg.s sVar = mVar.f5186a;
                jh.k kVar = mVar.f5187b;
                jh.k kVar2 = mVar.f5188c;
                n0Var2.L$0 = mVar;
                n0Var2.label = 1;
                objB = b(sVar, kVar, kVar2, r5Var, coroutineContext, n0Var2);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mVar = (gg.m) n0Var2.L$0;
                ResultKt.throwOnFailure(objB);
            }
            return (gg.s) objB;
        } catch (Throwable th2) {
            mVar.f5187b.b(th2);
            jh.o0.a(mVar.f5188c, th2);
            mVar.f5186a.close();
            throw th2;
        }
    }

    public static final Object g(gg.m mVar, CoroutineContext coroutineContext, gi.a aVar, nf.i iVar) throws NoSuchAlgorithmException, KeyStoreException {
        o0 o0Var = new o0();
        aVar.invoke(o0Var);
        SecureRandom secureRandom = new SecureRandom();
        ArrayList arrayList = o0Var.f5374a;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        Intrinsics.checkNotNull(trustManagerFactory);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        ArrayList arrayList2 = new ArrayList();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                arrayList2.add(trustManager);
            }
        }
        return f(mVar, coroutineContext, new r5(secureRandom, arrayList, (X509TrustManager) CollectionsKt.first((List) arrayList2), o0Var.f5375b, o0Var.f5376c), iVar);
    }

    public static final void h(wi.a aVar, byte[] bArr, int i8) {
        int i9 = (i8 + 7) >>> 3;
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (bArr[i10] != 0) {
                break;
            } else {
                i10++;
            }
        }
        int length2 = i9 - (bArr.length - i10);
        if (length2 > 0) {
            lh.a.k(aVar, new byte[length2], 0, length2);
        }
        lh.a.k(aVar, bArr, i10, bArr.length - i10);
    }

    public static final void i(wi.a aVar, ECPoint point, int i8) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        wi.a aVar2 = new wi.a();
        aVar2.s((byte) 4);
        byte[] byteArray = point.getAffineX().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        h(aVar2, byteArray, i8);
        byte[] byteArray2 = point.getAffineY().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
        h(aVar2, byteArray2, i8);
        aVar.s((byte) lh.a.e(aVar2));
        lh.a.m(aVar, aVar2);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object j(jh.j0 j0Var, t0 t0Var, ContinuationImpl continuationImpl) {
        o oVar;
        byte code;
        jh.j0 j0Var2;
        t0 t0Var2;
        byte code2;
        Object objB;
        jh.j0 j0Var3;
        wi.k kVar;
        if (continuationImpl instanceof o) {
            oVar = (o) continuationImpl;
            int i8 = oVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                oVar.label = i8 - Integer.MIN_VALUE;
            } else {
                oVar = new o(continuationImpl);
            }
        } else {
            oVar = new o(continuationImpl);
        }
        Object obj = oVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (oVar.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                byte code3 = (byte) t0Var.f5379a.getCode();
                oVar.L$0 = j0Var;
                oVar.L$1 = t0Var;
                oVar.label = 1;
                if (jh.o0.c(j0Var, code3, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                code = (byte) (t0Var.f5380b.getCode() >> 8);
                oVar.L$0 = j0Var;
                oVar.L$1 = t0Var;
                oVar.label = 2;
                if (jh.o0.c(j0Var, code, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t0 t0Var3 = t0Var;
                j0Var2 = j0Var;
                t0Var2 = t0Var3;
                code2 = (byte) t0Var2.f5380b.getCode();
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 3;
                if (jh.o0.c(j0Var2, code2, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                short sE = (short) lh.a.e(t0Var2.f5381c);
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 4;
                jh.l0 l0Var = jh.o0.f6300a;
                jh.k kVar2 = (jh.k) j0Var2;
                kVar2.k().t(sE);
                objB = ha.b(kVar2, oVar);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jh.j0 j0Var4 = j0Var2;
                t0 t0Var4 = t0Var2;
                j0Var3 = j0Var4;
                kVar = t0Var4.f5381c;
                oVar.L$0 = j0Var3;
                oVar.L$1 = null;
                oVar.label = 5;
                if (jh.o0.e(j0Var3, kVar, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                t0Var = (t0) oVar.L$1;
                j0Var = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                code = (byte) (t0Var.f5380b.getCode() >> 8);
                oVar.L$0 = j0Var;
                oVar.L$1 = t0Var;
                oVar.label = 2;
                if (jh.o0.c(j0Var, code, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t0 t0Var5 = t0Var;
                j0Var2 = j0Var;
                t0Var2 = t0Var5;
                code2 = (byte) t0Var2.f5380b.getCode();
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 3;
                if (jh.o0.c(j0Var2, code2, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                short sE2 = (short) lh.a.e(t0Var2.f5381c);
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 4;
                jh.l0 l0Var2 = jh.o0.f6300a;
                jh.k kVar3 = (jh.k) j0Var2;
                kVar3.k().t(sE2);
                objB = ha.b(kVar3, oVar);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jh.j0 j0Var5 = j0Var2;
                t0 t0Var6 = t0Var2;
                j0Var3 = j0Var5;
                kVar = t0Var6.f5381c;
                oVar.L$0 = j0Var3;
                oVar.L$1 = null;
                oVar.label = 5;
                if (jh.o0.e(j0Var3, kVar, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                t0Var2 = (t0) oVar.L$1;
                j0Var2 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                code2 = (byte) t0Var2.f5380b.getCode();
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 3;
                if (jh.o0.c(j0Var2, code2, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                short sE3 = (short) lh.a.e(t0Var2.f5381c);
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 4;
                jh.l0 l0Var3 = jh.o0.f6300a;
                jh.k kVar4 = (jh.k) j0Var2;
                kVar4.k().t(sE3);
                objB = ha.b(kVar4, oVar);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jh.j0 j0Var6 = j0Var2;
                t0 t0Var7 = t0Var2;
                j0Var3 = j0Var6;
                kVar = t0Var7.f5381c;
                oVar.L$0 = j0Var3;
                oVar.L$1 = null;
                oVar.label = 5;
                if (jh.o0.e(j0Var3, kVar, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                t0Var2 = (t0) oVar.L$1;
                j0Var2 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                short sE4 = (short) lh.a.e(t0Var2.f5381c);
                oVar.L$0 = j0Var2;
                oVar.L$1 = t0Var2;
                oVar.label = 4;
                jh.l0 l0Var4 = jh.o0.f6300a;
                jh.k kVar5 = (jh.k) j0Var2;
                kVar5.k().t(sE4);
                objB = ha.b(kVar5, oVar);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jh.j0 j0Var7 = j0Var2;
                t0 t0Var8 = t0Var2;
                j0Var3 = j0Var7;
                kVar = t0Var8.f5381c;
                oVar.L$0 = j0Var3;
                oVar.L$1 = null;
                oVar.label = 5;
                if (jh.o0.e(j0Var3, kVar, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 4:
                t0Var2 = (t0) oVar.L$1;
                j0Var2 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                jh.j0 j0Var8 = j0Var2;
                t0 t0Var9 = t0Var2;
                j0Var3 = j0Var8;
                kVar = t0Var9.f5381c;
                oVar.L$0 = j0Var3;
                oVar.L$1 = null;
                oVar.label = 5;
                if (jh.o0.e(j0Var3, kVar, oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 5:
                j0Var3 = (jh.j0) oVar.L$0;
                ResultKt.throwOnFailure(obj);
                oVar.L$0 = null;
                oVar.label = 6;
                if (((jh.k) j0Var3).h(oVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final void k(wi.a aVar, s0 type, int i8) throws p0 {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        if (i8 > 16777215) {
            throw new p0(a1.a.o(i8, "TLS handshake size limit exceeded: "), null, 2, null);
        }
        int code = (type.getCode() << 24) | i8;
        wi.h hVarL = aVar.l(4);
        int i9 = hVarL.f10778c;
        byte[] bArr = hVarL.f10776a;
        bArr[i9] = (byte) ((code >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((code >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((code >>> 8) & 255);
        bArr[i9 + 3] = (byte) (code & 255);
        hVarL.f10778c = i9 + 4;
        aVar.f10764c += 4;
    }
}
