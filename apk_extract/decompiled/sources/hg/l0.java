package hg;

import af.r5;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import k3.bc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5 f5366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f5367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wi.a f5368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f5369d;
    public final Lazy e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f5370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ni.c0 f5371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ni.a f5372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ni.c0 f5373k;
    private volatile SecretKeySpec masterSecret;
    private volatile x0 serverHello;

    public l0(jh.k rawInput, jh.k rawOutput, r5 config, CoroutineContext coroutineContext) {
        ni.a aVar;
        Intrinsics.checkNotNullParameter(rawInput, "rawInput");
        Intrinsics.checkNotNullParameter(rawOutput, "rawOutput");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f5366a = config;
        this.f5367b = coroutineContext;
        wi.a state = new wi.a();
        Intrinsics.checkNotNullParameter(state, "state");
        this.f5368c = state;
        byte[] bArr = new byte[32];
        ((SecureRandom) config.f557b).nextBytes(bArr);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        bArr[0] = (byte) (jCurrentTimeMillis >> 24);
        bArr[1] = (byte) (jCurrentTimeMillis >> 16);
        bArr[2] = (byte) (jCurrentTimeMillis >> 8);
        bArr[3] = (byte) jCurrentTimeMillis;
        this.f5369d = bArr;
        final int i8 = 0;
        this.e = LazyKt.lazy(new Function0(this) { // from class: hg.x

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l0 f5385b;

            {
                this.f5385b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i9 = i8;
                l0 l0Var = this.f5385b;
                switch (i9) {
                    case 0:
                        return l0.b(l0Var);
                    default:
                        return l0.a(l0Var);
                }
            }
        });
        final int i9 = 1;
        this.f5370h = LazyKt.lazy(new Function0(this) { // from class: hg.x

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l0 f5385b;

            {
                this.f5385b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i10 = i9;
                l0 l0Var = this.f5385b;
                switch (i10) {
                    case 0:
                        return l0.b(l0Var);
                    default:
                        return l0.a(l0Var);
                }
            }
        });
        this.f5371i = ni.b0.b(this, new li.f0("cio-tls-parser"), new d0(rawInput, this, null), 2);
        li.f0 f0Var = new li.f0("cio-tls-encoder");
        f0 f0Var2 = new f0(this, rawOutput, null);
        li.j0 j0Var = li.j0.DEFAULT;
        CoroutineContext coroutineContextB = li.y.b(this, f0Var);
        ni.m mVarA = bc.a(0, 6, null);
        if (j0Var.isLazy()) {
            ni.z zVar = new ni.z(coroutineContextB, mVarA, false);
            zVar.e = IntrinsicsKt.createCoroutineUnintercepted(f0Var2, zVar, zVar);
            aVar = zVar;
        } else {
            aVar = new ni.a(coroutineContextB, mVarA, true);
        }
        j0Var.invoke(f0Var2, aVar, aVar);
        this.f5372j = aVar;
        this.f5373k = ni.b0.b(this, new li.f0("cio-tls-handshake"), new b0(this, null), 2);
    }

    public static ig.g a(l0 l0Var) {
        x0 x0Var = l0Var.serverHello;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        c suite = x0Var.f5388c;
        byte[] keyMaterial = (byte[]) l0Var.e.getValue();
        Intrinsics.checkNotNullParameter(suite, "suite");
        Intrinsics.checkNotNullParameter(keyMaterial, "keyMaterial");
        int i8 = ig.f.$EnumSwitchMapping$0[suite.f5345n.ordinal()];
        if (i8 == 1) {
            return new ig.e(suite, keyMaterial);
        }
        if (i8 == 2) {
            return new ig.a(suite, keyMaterial);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static byte[] b(l0 l0Var) {
        x0 x0Var = l0Var.serverHello;
        x0 x0Var2 = null;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        c cVar = x0Var.f5388c;
        SecretKeySpec masterSecret = l0Var.masterSecret;
        if (masterSecret == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
            masterSecret = null;
        }
        x0 x0Var3 = l0Var.serverHello;
        if (x0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
        } else {
            x0Var2 = x0Var3;
        }
        byte[] seed = ArraysKt.plus(x0Var2.f5386a, l0Var.f5369d);
        int i8 = cVar.f5346o;
        int i9 = cVar.p;
        int i10 = cVar.f5338g;
        byte[] bArr = h.f5357a;
        Intrinsics.checkNotNullParameter(masterSecret, "masterSecret");
        Intrinsics.checkNotNullParameter(seed, "seed");
        return n.a(masterSecret, h.f5358b, seed, (i10 * 2) + (i8 * 2) + (i9 * 2));
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0429  */
    /* JADX WARN: Code duplicated, block: B:143:0x0433  */
    /* JADX WARN: Code duplicated, block: B:144:0x043e  */
    /* JADX WARN: Code duplicated, block: B:299:0x0441 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x041d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:? A[LOOP:13: B:139:0x0423->B:303:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.Throwable, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r1v25, types: [T, java.lang.Object, java.security.cert.X509Certificate] */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44, types: [java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r8v62 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008a -> B:24:0x0091). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r29) {
        /*
            Method dump skipped, instruction units count: 1717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hg.l0.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x028e  */
    /* JADX WARN: Code duplicated, block: B:102:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:104:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100  */
    /* JADX WARN: Code duplicated, block: B:51:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0129  */
    /* JADX WARN: Code duplicated, block: B:54:0x0152  */
    /* JADX WARN: Code duplicated, block: B:56:0x0168  */
    /* JADX WARN: Code duplicated, block: B:57:0x0175  */
    /* JADX WARN: Code duplicated, block: B:59:0x017d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0185  */
    /* JADX WARN: Code duplicated, block: B:63:0x018b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0192  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x0233 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x0238  */
    /* JADX WARN: Code duplicated, block: B:90:0x0249  */
    /* JADX WARN: Code duplicated, block: B:91:0x024d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0286  */
    /* JADX WARN: Code duplicated, block: B:97:0x028a A[RETURN] */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x028e, please report this as an issue */
    public final Object e(p pVar, Certificate certificate, b bVar, g gVar, ContinuationImpl continuationImpl) throws Exception {
        a0 a0Var;
        Certificate certificate2;
        g gVar2;
        p pVar2;
        x0 x0Var;
        int i8;
        KeyAgreement keyAgreement;
        byte[] preSecret;
        int i9;
        final wi.a aVar;
        PublicKey key;
        Object objP;
        l0 l0Var;
        byte[] bArr;
        PublicKey publicKey;
        SecureRandom random;
        byte[] bArrDoFinal;
        x0 x0Var2;
        x0 x0Var3;
        l0 l0Var2;
        SecretKeySpec secretKey;
        x0 x0Var4;
        Object objP2;
        l0 l0Var3 = this;
        b bVar2 = bVar;
        final int i10 = 0;
        final int i11 = 1;
        if (continuationImpl instanceof a0) {
            a0Var = (a0) continuationImpl;
            int i12 = a0Var.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i12 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(l0Var3, continuationImpl);
            }
        } else {
            a0Var = new a0(l0Var3, continuationImpl);
        }
        Object obj = a0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i13 = a0Var.label;
        x0 x0Var5 = null;
        if (i13 != 0) {
            if (i13 == 1) {
                g gVar3 = (g) a0Var.L$4;
                bVar2 = (b) a0Var.L$3;
                certificate2 = (Certificate) a0Var.L$2;
                pVar2 = (p) a0Var.L$1;
                l0 l0Var4 = (l0) a0Var.L$0;
                ResultKt.throwOnFailure(obj);
                gVar2 = gVar3;
                l0Var3 = l0Var4;
            } else if (i13 == 2) {
                bArr = (byte[]) a0Var.L$3;
                if (a0Var.L$2 != null) {
                    throw new ClassCastException();
                }
                l0Var = (l0) a0Var.L$0;
                ResultKt.throwOnFailure(obj);
                x0Var2 = l0Var.serverHello;
                if (x0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                    x0Var2 = null;
                }
                SecretKeySpec preMasterSecret = new SecretKeySpec(bArr, x0Var2.f5388c.f5343l.getMacName());
                byte[] clientRandom = l0Var.f5369d;
                x0Var3 = l0Var.serverHello;
                if (x0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                    x0Var3 = null;
                }
                byte[] serverRandom = x0Var3.f5386a;
                byte[] bArr2 = h.f5357a;
                Intrinsics.checkNotNullParameter(preMasterSecret, "preMasterSecret");
                Intrinsics.checkNotNullParameter(clientRandom, "clientRandom");
                Intrinsics.checkNotNullParameter(serverRandom, "serverRandom");
                l0Var.masterSecret = new SecretKeySpec(n.a(preMasterSecret, h.f5357a, ArraysKt.plus(clientRandom, serverRandom), 48), preMasterSecret.getAlgorithm());
                ArraysKt___ArraysJvmKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
                l0Var2 = l0Var;
                a0Var.L$0 = l0Var2;
                a0Var.L$1 = null;
                a0Var.L$2 = null;
                a0Var.L$3 = null;
                a0Var.label = 4;
                if (l0Var2.m(a0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                secretKey = l0Var2.masterSecret;
                if (secretKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
                    secretKey = null;
                }
                a0Var.L$0 = null;
                a0Var.label = 5;
                wi.a aVar2 = l0Var2.f5368c;
                x0Var4 = l0Var2.serverHello;
                if (x0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                } else {
                    x0Var5 = x0Var4;
                }
                byte[] digest = f.a(aVar2, x0Var5.f5388c.f5343l.getOpenSSLName());
                Intrinsics.checkNotNullParameter(digest, "digest");
                Intrinsics.checkNotNullParameter(secretKey, "secretKey");
                final wi.a aVar3 = new wi.a();
                byte[] bArrA = n.a(secretKey, h.f5359c, digest, 12);
                lh.a.k(aVar3, bArrA, 0, bArrA.length);
                objP2 = l0Var2.p(s0.Finished, new Function1() { // from class: hg.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        wi.j sendHandshakeRecord = (wi.j) obj2;
                        switch (i11) {
                            case 0:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar3);
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar3);
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }, a0Var);
                if (objP2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objP2 = Unit.INSTANCE;
                }
                if (objP2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i13 == 3) {
                l0Var2 = (l0) a0Var.L$0;
                ResultKt.throwOnFailure(obj);
                a0Var.L$0 = l0Var2;
                a0Var.L$1 = null;
                a0Var.L$2 = null;
                a0Var.L$3 = null;
                a0Var.label = 4;
                if (l0Var2.m(a0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                secretKey = l0Var2.masterSecret;
                if (secretKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
                    secretKey = null;
                }
                a0Var.L$0 = null;
                a0Var.label = 5;
                wi.a aVar4 = l0Var2.f5368c;
                x0Var4 = l0Var2.serverHello;
                if (x0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                } else {
                    x0Var5 = x0Var4;
                }
                byte[] digest2 = f.a(aVar4, x0Var5.f5388c.f5343l.getOpenSSLName());
                Intrinsics.checkNotNullParameter(digest2, "digest");
                Intrinsics.checkNotNullParameter(secretKey, "secretKey");
                final wi.a aVar5 = new wi.a();
                byte[] bArrA2 = n.a(secretKey, h.f5359c, digest2, 12);
                lh.a.k(aVar5, bArrA2, 0, bArrA2.length);
                objP2 = l0Var2.p(s0.Finished, new Function1() { // from class: hg.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        wi.j sendHandshakeRecord = (wi.j) obj2;
                        switch (i11) {
                            case 0:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar5);
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar5);
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }, a0Var);
                if (objP2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objP2 = Unit.INSTANCE;
                }
                if (objP2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i13 == 4) {
                l0Var2 = (l0) a0Var.L$0;
                ResultKt.throwOnFailure(obj);
                secretKey = l0Var2.masterSecret;
                if (secretKey == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
                    secretKey = null;
                }
                a0Var.L$0 = null;
                a0Var.label = 5;
                wi.a aVar6 = l0Var2.f5368c;
                x0Var4 = l0Var2.serverHello;
                if (x0Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                } else {
                    x0Var5 = x0Var4;
                }
                byte[] digest3 = f.a(aVar6, x0Var5.f5388c.f5343l.getOpenSSLName());
                Intrinsics.checkNotNullParameter(digest3, "digest");
                Intrinsics.checkNotNullParameter(secretKey, "secretKey");
                final wi.a aVar7 = new wi.a();
                byte[] bArrA3 = n.a(secretKey, h.f5359c, digest3, 12);
                lh.a.k(aVar7, bArrA3, 0, bArrA3.length);
                objP2 = l0Var2.p(s0.Finished, new Function1() { // from class: hg.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        wi.j sendHandshakeRecord = (wi.j) obj2;
                        switch (i11) {
                            case 0:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar7);
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                                lh.a.m(sendHandshakeRecord, aVar7);
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }, a0Var);
                if (objP2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objP2 = Unit.INSTANCE;
                }
                if (objP2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i13 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (bVar2 != null) {
            a0Var.L$0 = l0Var3;
            a0Var.L$1 = pVar;
            certificate2 = certificate;
            a0Var.L$2 = certificate2;
            a0Var.L$3 = bVar2;
            gVar2 = gVar;
            a0Var.L$4 = gVar2;
            a0Var.label = 1;
            Object objN = l0Var3.n(a0Var);
            if (objN == coroutine_suspended) {
                return coroutine_suspended;
            }
            pVar2 = pVar;
            obj = objN;
        } else {
            certificate2 = certificate;
            gVar2 = gVar;
            pVar2 = pVar;
        }
        x0Var = l0Var3.serverHello;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        p pVar3 = x0Var.f5388c.f5337d;
        int[] iArr = y.$EnumSwitchMapping$0;
        i8 = iArr[pVar3.ordinal()];
        if (i8 != 1) {
            keyAgreement = KeyAgreement.getInstance("ECDH");
            Intrinsics.checkNotNull(keyAgreement);
            if (gVar2 != null) {
                throw new p0("ECDHE_ECDSA: Encryption info should be provided", null, 2, null);
            }
            keyAgreement.init(gVar2.f5356c);
            keyAgreement.doPhase(gVar2.f5354a, true);
            preSecret = keyAgreement.generateSecret();
            Intrinsics.checkNotNull(preSecret);
        } else {
            if (i8 == 2) {
                throw new NoWhenBranchMatchedException();
            }
            preSecret = new byte[48];
            ((SecureRandom) l0Var3.f5366a.f557b).nextBytes(preSecret);
            preSecret[0] = 3;
            preSecret[1] = 3;
        }
        a0Var.L$0 = l0Var3;
        a0Var.L$1 = bVar2;
        a0Var.L$2 = null;
        a0Var.L$3 = preSecret;
        a0Var.L$4 = null;
        a0Var.label = 2;
        i9 = iArr[pVar2.ordinal()];
        if (i9 != 1) {
            aVar = new wi.a();
            if (gVar2 != null) {
                throw new p0("ECDHE: Encryption info should be provided", null, 2, null);
            }
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            key = gVar2.f5355b;
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof ECPublicKey) {
                throw new p0("Unsupported public key type: " + key, null, 2, null);
            }
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            int fieldSize = eCPublicKey.getParams().getCurve().getField().getFieldSize();
            ECPoint w8 = eCPublicKey.getW();
            Intrinsics.checkNotNullExpressionValue(w8, "getW(...)");
            n.i(aVar, w8, fieldSize);
        } else {
            if (i9 == 2) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = new wi.a();
            publicKey = certificate2.getPublicKey();
            Intrinsics.checkNotNullExpressionValue(publicKey, "getPublicKey(...)");
            random = (SecureRandom) l0Var3.f5366a.f557b;
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(preSecret, "preSecret");
            Intrinsics.checkNotNullParameter(publicKey, "publicKey");
            Intrinsics.checkNotNullParameter(random, "random");
            if (preSecret.length == 48) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            Intrinsics.checkNotNull(cipher);
            cipher.init(1, publicKey, random);
            bArrDoFinal = cipher.doFinal(preSecret);
            if (bArrDoFinal.length <= 65535) {
                throw new p0("Encrypted premaster secret is too long", null, 2, null);
            }
            aVar.t((short) bArrDoFinal.length);
            Intrinsics.checkNotNull(bArrDoFinal);
            lh.a.k(aVar, bArrDoFinal, 0, bArrDoFinal.length);
        }
        objP = l0Var3.p(s0.ClientKeyExchange, new Function1() { // from class: hg.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                wi.j sendHandshakeRecord = (wi.j) obj2;
                switch (i10) {
                    case 0:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar);
                        break;
                    default:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar);
                        break;
                }
                return Unit.INSTANCE;
            }
        }, a0Var);
        if (objP != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objP = Unit.INSTANCE;
        }
        if (objP == coroutine_suspended) {
            return coroutine_suspended;
        }
        l0Var = l0Var3;
        bArr = preSecret;
        x0Var2 = l0Var.serverHello;
        if (x0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var2 = null;
        }
        SecretKeySpec preMasterSecret2 = new SecretKeySpec(bArr, x0Var2.f5388c.f5343l.getMacName());
        byte[] clientRandom2 = l0Var.f5369d;
        x0Var3 = l0Var.serverHello;
        if (x0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var3 = null;
        }
        byte[] serverRandom2 = x0Var3.f5386a;
        byte[] bArr3 = h.f5357a;
        Intrinsics.checkNotNullParameter(preMasterSecret2, "preMasterSecret");
        Intrinsics.checkNotNullParameter(clientRandom2, "clientRandom");
        Intrinsics.checkNotNullParameter(serverRandom2, "serverRandom");
        l0Var.masterSecret = new SecretKeySpec(n.a(preMasterSecret2, h.f5357a, ArraysKt.plus(clientRandom2, serverRandom2), 48), preMasterSecret2.getAlgorithm());
        ArraysKt___ArraysJvmKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
        l0Var2 = l0Var;
        a0Var.L$0 = l0Var2;
        a0Var.L$1 = null;
        a0Var.L$2 = null;
        a0Var.L$3 = null;
        a0Var.label = 4;
        if (l0Var2.m(a0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        secretKey = l0Var2.masterSecret;
        if (secretKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
            secretKey = null;
        }
        a0Var.L$0 = null;
        a0Var.label = 5;
        wi.a aVar8 = l0Var2.f5368c;
        x0Var4 = l0Var2.serverHello;
        if (x0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
        } else {
            x0Var5 = x0Var4;
        }
        byte[] digest4 = f.a(aVar8, x0Var5.f5388c.f5343l.getOpenSSLName());
        Intrinsics.checkNotNullParameter(digest4, "digest");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        final wi.a aVar9 = new wi.a();
        byte[] bArrA4 = n.a(secretKey, h.f5359c, digest4, 12);
        lh.a.k(aVar9, bArrA4, 0, bArrA4.length);
        objP2 = l0Var2.p(s0.Finished, new Function1() { // from class: hg.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                wi.j sendHandshakeRecord = (wi.j) obj2;
                switch (i11) {
                    case 0:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar9);
                        break;
                    default:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar9);
                        break;
                }
                return Unit.INSTANCE;
            }
        }, a0Var);
        if (objP2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objP2 = Unit.INSTANCE;
        }
        if (objP2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
        if (obj != null) {
            throw new ClassCastException();
        }
        x0Var = l0Var3.serverHello;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        p pVar4 = x0Var.f5388c.f5337d;
        int[] iArr2 = y.$EnumSwitchMapping$0;
        i8 = iArr2[pVar4.ordinal()];
        if (i8 != 1) {
            keyAgreement = KeyAgreement.getInstance("ECDH");
            Intrinsics.checkNotNull(keyAgreement);
            if (gVar2 != null) {
                throw new p0("ECDHE_ECDSA: Encryption info should be provided", null, 2, null);
            }
            keyAgreement.init(gVar2.f5356c);
            keyAgreement.doPhase(gVar2.f5354a, true);
            preSecret = keyAgreement.generateSecret();
            Intrinsics.checkNotNull(preSecret);
        } else {
            if (i8 == 2) {
                throw new NoWhenBranchMatchedException();
            }
            preSecret = new byte[48];
            ((SecureRandom) l0Var3.f5366a.f557b).nextBytes(preSecret);
            preSecret[0] = 3;
            preSecret[1] = 3;
        }
        a0Var.L$0 = l0Var3;
        a0Var.L$1 = bVar2;
        a0Var.L$2 = null;
        a0Var.L$3 = preSecret;
        a0Var.L$4 = null;
        a0Var.label = 2;
        i9 = iArr2[pVar2.ordinal()];
        if (i9 != 1) {
            aVar = new wi.a();
            if (gVar2 != null) {
                throw new p0("ECDHE: Encryption info should be provided", null, 2, null);
            }
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            key = gVar2.f5355b;
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof ECPublicKey) {
                throw new p0("Unsupported public key type: " + key, null, 2, null);
            }
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            int fieldSize2 = eCPublicKey2.getParams().getCurve().getField().getFieldSize();
            ECPoint w10 = eCPublicKey2.getW();
            Intrinsics.checkNotNullExpressionValue(w10, "getW(...)");
            n.i(aVar, w10, fieldSize2);
        } else {
            if (i9 == 2) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = new wi.a();
            publicKey = certificate2.getPublicKey();
            Intrinsics.checkNotNullExpressionValue(publicKey, "getPublicKey(...)");
            random = (SecureRandom) l0Var3.f5366a.f557b;
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(preSecret, "preSecret");
            Intrinsics.checkNotNullParameter(publicKey, "publicKey");
            Intrinsics.checkNotNullParameter(random, "random");
            if (preSecret.length == 48) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            Intrinsics.checkNotNull(cipher2);
            cipher2.init(1, publicKey, random);
            bArrDoFinal = cipher2.doFinal(preSecret);
            if (bArrDoFinal.length <= 65535) {
                throw new p0("Encrypted premaster secret is too long", null, 2, null);
            }
            aVar.t((short) bArrDoFinal.length);
            Intrinsics.checkNotNull(bArrDoFinal);
            lh.a.k(aVar, bArrDoFinal, 0, bArrDoFinal.length);
        }
        objP = l0Var3.p(s0.ClientKeyExchange, new Function1() { // from class: hg.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                wi.j sendHandshakeRecord = (wi.j) obj2;
                switch (i10) {
                    case 0:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar);
                        break;
                    default:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar);
                        break;
                }
                return Unit.INSTANCE;
            }
        }, a0Var);
        if (objP != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objP = Unit.INSTANCE;
        }
        if (objP == coroutine_suspended) {
            return coroutine_suspended;
        }
        l0Var = l0Var3;
        bArr = preSecret;
        x0Var2 = l0Var.serverHello;
        if (x0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var2 = null;
        }
        SecretKeySpec preMasterSecret3 = new SecretKeySpec(bArr, x0Var2.f5388c.f5343l.getMacName());
        byte[] clientRandom3 = l0Var.f5369d;
        x0Var3 = l0Var.serverHello;
        if (x0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var3 = null;
        }
        byte[] serverRandom3 = x0Var3.f5386a;
        byte[] bArr4 = h.f5357a;
        Intrinsics.checkNotNullParameter(preMasterSecret3, "preMasterSecret");
        Intrinsics.checkNotNullParameter(clientRandom3, "clientRandom");
        Intrinsics.checkNotNullParameter(serverRandom3, "serverRandom");
        l0Var.masterSecret = new SecretKeySpec(n.a(preMasterSecret3, h.f5357a, ArraysKt.plus(clientRandom3, serverRandom3), 48), preMasterSecret3.getAlgorithm());
        ArraysKt___ArraysJvmKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
        l0Var2 = l0Var;
        a0Var.L$0 = l0Var2;
        a0Var.L$1 = null;
        a0Var.L$2 = null;
        a0Var.L$3 = null;
        a0Var.label = 4;
        if (l0Var2.m(a0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        secretKey = l0Var2.masterSecret;
        if (secretKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
            secretKey = null;
        }
        a0Var.L$0 = null;
        a0Var.label = 5;
        wi.a aVar10 = l0Var2.f5368c;
        x0Var4 = l0Var2.serverHello;
        if (x0Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
        } else {
            x0Var5 = x0Var4;
        }
        byte[] digest5 = f.a(aVar10, x0Var5.f5388c.f5343l.getOpenSSLName());
        Intrinsics.checkNotNullParameter(digest5, "digest");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        final wi.a aVar11 = new wi.a();
        byte[] bArrA5 = n.a(secretKey, h.f5359c, digest5, 12);
        lh.a.k(aVar11, bArrA5, 0, bArrA5.length);
        objP2 = l0Var2.p(s0.Finished, new Function1() { // from class: hg.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                wi.j sendHandshakeRecord = (wi.j) obj2;
                switch (i11) {
                    case 0:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar11);
                        break;
                    default:
                        Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                        lh.a.m(sendHandshakeRecord, aVar11);
                        break;
                }
                return Unit.INSTANCE;
            }
        }, a0Var);
        if (objP2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objP2 = Unit.INSTANCE;
        }
        if (objP2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:45:0x0104  */
    /* JADX WARN: Code duplicated, block: B:48:0x010d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0113  */
    /* JADX WARN: Code duplicated, block: B:53:0x011d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0139 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x013a  */
    /* JADX WARN: Code duplicated, block: B:61:0x014a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x016a  */
    /* JADX WARN: Code duplicated, block: B:68:0x017e  */
    /* JADX WARN: Code duplicated, block: B:77:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x016a, please report this as an issue */
    public final Object f(ContinuationImpl continuationImpl) throws Exception {
        e0 e0Var;
        f fVar;
        int i8;
        l0 l0Var;
        int i9;
        f fVar2;
        l0 l0Var2;
        x0 x0Var;
        c cVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        f fVar3;
        l0 l0Var3;
        Iterator it;
        jg.c cVar2;
        if (continuationImpl instanceof e0) {
            e0Var = (e0) continuationImpl;
            int i10 = e0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                e0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                e0Var = new e0(this, continuationImpl);
            }
        } else {
            e0Var = new e0(this, continuationImpl);
        }
        Object obj = e0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = e0Var.label;
        if (i11 != 0) {
            if (i11 == 1) {
                int i12 = e0Var.I$0;
                fVar = (f) e0Var.L$1;
                l0 l0Var4 = (l0) e0Var.L$0;
                ResultKt.throwOnFailure(obj);
                i8 = i12;
                this = l0Var4;
            } else if (i11 == 2) {
                i9 = e0Var.I$0;
                l0Var2 = (l0) e0Var.L$2;
                fVar2 = (f) e0Var.L$1;
                l0Var = (l0) e0Var.L$0;
                ResultKt.throwOnFailure(obj);
                l0Var2.serverHello = (x0) obj;
                x0Var = l0Var.serverHello;
                if (x0Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serverHello");
                    x0Var = null;
                }
                l0Var.getClass();
                cVar = x0Var.f5388c;
                if (((ArrayList) l0Var.f5366a.e).contains(cVar)) {
                    throw new IllegalStateException(h0.a.n(new StringBuilder("Unsupported cipher suite "), cVar.f5335b, " in SERVER_HELLO").toString());
                }
                List list = jg.k.f6277a;
                arrayList = new ArrayList();
                for (Object obj2 : list) {
                    cVar2 = (jg.c) obj2;
                    if (cVar2.f6271a != cVar.f5343l && cVar2.f6272b == cVar.f5344m) {
                        arrayList.add(obj2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    throw new p0("No appropriate hash algorithm for suite: " + cVar, null, 2, null);
                }
                arrayList2 = x0Var.f5389d;
                if (!arrayList2.isEmpty()) {
                    if (!arrayList.isEmpty()) {
                        it = arrayList.iterator();
                        do {
                            if (it.hasNext()) {
                            }
                        } while (!arrayList2.contains((jg.c) it.next()));
                    }
                    throw new p0("No sign algorithms in common. \nServer candidates: " + arrayList2 + " \nClient candidates: " + arrayList, null, 2, null);
                }
                e0Var.L$0 = l0Var;
                e0Var.L$1 = fVar2;
                e0Var.L$2 = null;
                e0Var.I$0 = i9;
                e0Var.label = 3;
                if (l0Var.d(e0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fVar3 = fVar2;
                l0Var3 = l0Var;
                e0Var.L$0 = fVar3;
                e0Var.L$1 = null;
                e0Var.I$0 = i9;
                e0Var.label = 4;
                if (l0Var3.h(e0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 3) {
                i9 = e0Var.I$0;
                fVar3 = (f) e0Var.L$1;
                l0Var3 = (l0) e0Var.L$0;
                ResultKt.throwOnFailure(obj);
                e0Var.L$0 = fVar3;
                e0Var.L$1 = null;
                e0Var.I$0 = i9;
                e0Var.label = 4;
                if (l0Var3.h(e0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i11 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        fVar = new f(this.f5368c);
        e0Var.L$0 = this;
        e0Var.L$1 = fVar;
        i8 = 0;
        e0Var.I$0 = 0;
        e0Var.label = 1;
        Object objP = p(s0.ClientHello, new ag.d0(this, 11), e0Var);
        if (objP != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objP = Unit.INSTANCE;
        }
        if (objP == coroutine_suspended) {
            return coroutine_suspended;
        }
        e0Var.L$0 = this;
        e0Var.L$1 = fVar;
        e0Var.L$2 = this;
        e0Var.I$0 = i8;
        e0Var.label = 2;
        Object objJ = this.j(e0Var);
        if (objJ == coroutine_suspended) {
            return coroutine_suspended;
        }
        l0Var = this;
        i9 = i8;
        obj = objJ;
        fVar2 = fVar;
        l0Var2 = l0Var;
        l0Var2.serverHello = (x0) obj;
        x0Var = l0Var.serverHello;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        l0Var.getClass();
        cVar = x0Var.f5388c;
        if (((ArrayList) l0Var.f5366a.e).contains(cVar)) {
            throw new IllegalStateException(h0.a.n(new StringBuilder("Unsupported cipher suite "), cVar.f5335b, " in SERVER_HELLO").toString());
        }
        List list2 = jg.k.f6277a;
        arrayList = new ArrayList();
        while (r8.hasNext()) {
            cVar2 = (jg.c) obj2;
            if (cVar2.f6271a != cVar.f5343l) {
            }
        }
        if (!arrayList.isEmpty()) {
            throw new p0("No appropriate hash algorithm for suite: " + cVar, null, 2, null);
        }
        arrayList2 = x0Var.f5389d;
        if (!arrayList2.isEmpty()) {
            if (!arrayList.isEmpty()) {
                it = arrayList.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!arrayList2.contains((jg.c) it.next()));
            }
            throw new p0("No sign algorithms in common. \nServer candidates: " + arrayList2 + " \nClient candidates: " + arrayList, null, 2, null);
        }
        e0Var.L$0 = l0Var;
        e0Var.L$1 = fVar2;
        e0Var.L$2 = null;
        e0Var.I$0 = i9;
        e0Var.label = 3;
        if (l0Var.d(e0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        fVar3 = fVar2;
        l0Var3 = l0Var;
        e0Var.L$0 = fVar3;
        e0Var.L$1 = null;
        e0Var.I$0 = i9;
        e0Var.label = 4;
        if (l0Var3.h(e0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f5367b;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(ContinuationImpl continuationImpl) throws Throwable {
        g0 g0Var;
        if (continuationImpl instanceof g0) {
            g0Var = (g0) continuationImpl;
            int i8 = g0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                g0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                g0Var = new g0(this, continuationImpl);
            }
        } else {
            g0Var = new g0(this, continuationImpl);
        }
        Object objJ = g0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = g0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objJ);
            ni.c0 c0Var = this.f5373k;
            g0Var.L$0 = this;
            g0Var.label = 1;
            objJ = c0Var.f8323d.j(g0Var);
            if (objJ == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (l0) g0Var.L$0;
            ResultKt.throwOnFailure(objJ);
        }
        q0 q0Var = (q0) objJ;
        if (q0Var.f5377a != s0.Finished) {
            throw new p0("Finished handshake expected, received: " + q0Var, null, 2, null);
        }
        byte[] bArrB = wi.o.b(q0Var.f5378b);
        wi.a aVar = this.f5368c;
        x0 x0Var = this.serverHello;
        if (x0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serverHello");
            x0Var = null;
        }
        byte[] handshakeHash = f.a(aVar, x0Var.f5388c.f5343l.getOpenSSLName());
        SecretKeySpec secretKey = this.masterSecret;
        if (secretKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterSecret");
            secretKey = null;
        }
        int length = bArrB.length;
        Intrinsics.checkNotNullParameter(handshakeHash, "handshakeHash");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        byte[] bArrA = n.a(secretKey, h.f5360d, handshakeHash, length);
        if (Arrays.equals(bArrB, bArrA)) {
            return Unit.INSTANCE;
        }
        throw new p0(StringsKt__IndentKt.trimMargin$default("Handshake: ServerFinished verification failed:\n                |Expected: " + ArraysKt___ArraysKt.joinToString$default(bArrA, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "\n                |Actual: " + ArraysKt___ArraysKt.joinToString$default(bArrB, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "\n                ", null, 1, null), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(ContinuationImpl continuationImpl) throws Throwable {
        h0 h0Var;
        jg.n next;
        if (continuationImpl instanceof h0) {
            h0Var = (h0) continuationImpl;
            int i8 = h0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                h0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                h0Var = new h0(this, continuationImpl);
            }
        } else {
            h0Var = new h0(this, continuationImpl);
        }
        Object objJ = h0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = h0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objJ);
            h0Var.label = 1;
            objJ = this.f5373k.f8323d.j(h0Var);
            if (objJ == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objJ);
        }
        q0 q0Var = (q0) objJ;
        if (q0Var.f5377a != s0.ServerHello) {
            throw new IllegalStateException(("Expected TLS handshake ServerHello but got " + q0Var.f5377a).toString());
        }
        wi.a aVar = q0Var.f5378b;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        e1 e1Var = f1.Companion;
        int iA = aVar.a() & UShort.MAX_VALUE;
        e1Var.getClass();
        f1 f1VarA = e1.a(iA);
        byte[] out = new byte[32];
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        wi.o.e(aVar, out, 0, 32);
        int i10 = aVar.readByte() & UByte.MAX_VALUE;
        if (i10 > 32) {
            throw new p0(h0.a.h(i10, "sessionId length limit of 32 bytes exceeded: ", " specified"), null, 2, null);
        }
        byte[] out2 = new byte[32];
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(out2, "out");
        wi.o.e(aVar, out2, 0, i10);
        short sA = aVar.a();
        short s2 = (short) (aVar.readByte() & 255);
        if (s2 != 0) {
            throw new p0(h0.a.h(s2, "Unsupported TLS compression method ", " (only null 0 compression method is supported)"), null, 2, null);
        }
        if (((int) lh.a.e(aVar)) == 0) {
            return new x0(f1VarA, out, out2, sA, CollectionsKt.emptyList());
        }
        int iA2 = aVar.a() & UShort.MAX_VALUE;
        if (((int) lh.a.e(aVar)) != iA2) {
            StringBuilder sbU = a1.a.u(iA2, "Invalid extensions size: requested ", ", available ");
            sbU.append(lh.a.e(aVar));
            throw new p0(sbU.toString(), null, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        while (lh.a.e(aVar) > 0) {
            int iA3 = aVar.a() & UShort.MAX_VALUE;
            int iA4 = aVar.a() & UShort.MAX_VALUE;
            jg.n.Companion.getClass();
            Iterator<jg.n> it = jg.n.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.getCode() != ((short) iA3));
            jg.n nVar = next;
            if (nVar == null) {
                throw new p0(a1.a.o(iA3, "Unknown server hello extension type: "), null, 2, null);
            }
            wi.a aVar2 = new wi.a();
            byte[] bArrC = wi.o.c(aVar, iA4);
            lh.a.k(aVar2, bArrC, 0, bArrC.length);
            Unit unit = Unit.INSTANCE;
            arrayList.add(new jg.l(nVar, aVar2));
        }
        return new x0(f1VarA, out, out2, sA, arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m(ContinuationImpl continuationImpl) throws Exception {
        i0 i0Var;
        Throwable th2;
        wi.k kVar;
        if (continuationImpl instanceof i0) {
            i0Var = (i0) continuationImpl;
            int i8 = i0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                i0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                i0Var = new i0(this, continuationImpl);
            }
        } else {
            i0Var = new i0(this, continuationImpl);
        }
        Object obj = i0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = i0Var.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (wi.k) i0Var.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th2 = th3;
                kVar.close();
                throw th2;
            }
        }
        ResultKt.throwOnFailure(obj);
        wi.a aVar = new wi.a();
        aVar.s((byte) 1);
        try {
            ni.a aVar2 = this.f5372j;
            t0 t0Var = new t0(v0.ChangeCipherSpec, aVar);
            i0Var.L$0 = aVar;
            i0Var.label = 1;
            if (aVar2.r(t0Var, i0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th2 = th4;
            kVar = aVar;
            kVar.close();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(ContinuationImpl continuationImpl) {
        j0 j0Var;
        if (continuationImpl instanceof j0) {
            j0Var = (j0) continuationImpl;
            int i8 = j0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                j0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                j0Var = new j0(this, continuationImpl);
            }
        } else {
            j0Var = new j0(this, continuationImpl);
        }
        Object obj = j0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = j0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it = ((ArrayList) this.f5366a.f558c).iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            s0 s0Var = s0.Certificate;
            Function1 bVar = new ag.b(10);
            j0Var.L$0 = null;
            j0Var.label = 1;
            if (p(s0Var, bVar, j0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (j0Var.L$0 != null) {
                throw new ClassCastException();
            }
            ResultKt.throwOnFailure(obj);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object p(s0 s0Var, Function1 function1, ContinuationImpl continuationImpl) throws Exception {
        k0 k0Var;
        Throwable th2;
        t0 t0Var;
        if (continuationImpl instanceof k0) {
            k0Var = (k0) continuationImpl;
            int i8 = k0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                k0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                k0Var = new k0(this, continuationImpl);
            }
        } else {
            k0Var = new k0(this, continuationImpl);
        }
        Object obj = k0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = k0Var.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t0Var = (t0) k0Var.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th2 = th3;
                t0Var.f5381c.close();
                throw th2;
            }
        }
        ResultKt.throwOnFailure(obj);
        wi.a aVar = new wi.a();
        function1.invoke(aVar);
        wi.a aVar2 = new wi.a();
        n.k(aVar2, s0Var, (int) lh.a.e(aVar));
        lh.a.m(aVar2, aVar);
        f.c(this.f5368c, aVar2);
        t0 t0Var2 = new t0(v0.Handshake, aVar2);
        try {
            ni.a aVar3 = this.f5372j;
            k0Var.L$0 = t0Var2;
            k0Var.label = 1;
            if (aVar3.r(t0Var2, k0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th4) {
            th2 = th4;
            t0Var = t0Var2;
            t0Var.f5381c.close();
            throw th2;
        }
    }
}
