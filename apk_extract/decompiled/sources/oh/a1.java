package oh;

import k3.bc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.o1;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 implements li.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jh.j0 f8475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f8476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nh.d f8478d;
    public final ni.m e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j0 f8479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g2 f8480i;

    public a1(jh.j0 writeChannel, CoroutineContext coroutineContext, boolean z2, nh.d pool) {
        Intrinsics.checkNotNullParameter(writeChannel, "writeChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.f8475a = writeChannel;
        this.f8476b = coroutineContext;
        this.f8477c = z2;
        this.f8478d = pool;
        this.e = bc.a(8, 6, null);
        this.f8479h = new j0();
        this.f8480i = li.l0.o(this, new li.f0("ws-writer"), li.j0.ATOMIC, new z0(this, null));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    /* JADX WARN: Code duplicated, block: B:31:0x009b A[Catch: all -> 0x00bf, d -> 0x00c3, TryCatch #5 {d -> 0x00c3, all -> 0x00bf, blocks: (B:36:0x00b6, B:26:0x0082, B:29:0x0093, B:31:0x009b, B:33:0x00a3, B:43:0x00c7, B:45:0x00cb, B:46:0x00d5, B:47:0x00e9, B:25:0x0078), top: B:94:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a3 A[Catch: all -> 0x00bf, d -> 0x00c3, TryCatch #5 {d -> 0x00c3, all -> 0x00bf, blocks: (B:36:0x00b6, B:26:0x0082, B:29:0x0093, B:31:0x009b, B:33:0x00a3, B:43:0x00c7, B:45:0x00cb, B:46:0x00d5, B:47:0x00e9, B:25:0x0078), top: B:94:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00be  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[Catch: all -> 0x00bf, d -> 0x00c3, TryCatch #5 {d -> 0x00c3, all -> 0x00bf, blocks: (B:36:0x00b6, B:26:0x0082, B:29:0x0093, B:31:0x009b, B:33:0x00a3, B:43:0x00c7, B:45:0x00cb, B:46:0x00d5, B:47:0x00e9, B:25:0x0078), top: B:94:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00cb A[Catch: all -> 0x00bf, d -> 0x00c3, TryCatch #5 {d -> 0x00c3, all -> 0x00bf, blocks: (B:36:0x00b6, B:26:0x0082, B:29:0x0093, B:31:0x009b, B:33:0x00a3, B:43:0x00c7, B:45:0x00cb, B:46:0x00d5, B:47:0x00e9, B:25:0x0078), top: B:94:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d5 A[Catch: all -> 0x00bf, d -> 0x00c3, TryCatch #5 {d -> 0x00c3, all -> 0x00bf, blocks: (B:36:0x00b6, B:26:0x0082, B:29:0x0093, B:31:0x009b, B:33:0x00a3, B:43:0x00c7, B:45:0x00cb, B:46:0x00d5, B:47:0x00e9, B:25:0x0078), top: B:94:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b2 -> B:36:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00cb -> B:26:0x0082). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(oh.a1 r9, java.nio.ByteBuffer r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.a1.a(oh.a1, java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:107:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:111:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:112:0x01df  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:120:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:123:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:127:0x0208  */
    /* JADX WARN: Code duplicated, block: B:130:0x020d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0216  */
    /* JADX WARN: Code duplicated, block: B:134:0x0222  */
    /* JADX WARN: Code duplicated, block: B:139:0x0235  */
    /* JADX WARN: Code duplicated, block: B:187:0x0270 A[EDGE_INSN: B:187:0x0270->B:143:0x0270 BREAK  A[LOOP:1: B:61:0x0141->B:140:0x0260], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0270 A[EDGE_INSN: B:188:0x0270->B:143:0x0270 BREAK  A[LOOP:1: B:61:0x0141->B:140:0x0260], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0270 A[EDGE_INSN: B:189:0x0270->B:143:0x0270 BREAK  A[LOOP:1: B:61:0x0141->B:140:0x0260], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0260 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0149  */
    /* JADX WARN: Code duplicated, block: B:66:0x0152  */
    /* JADX WARN: Code duplicated, block: B:67:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x0160  */
    /* JADX WARN: Code duplicated, block: B:72:0x0166  */
    /* JADX WARN: Code duplicated, block: B:73:0x0177  */
    /* JADX WARN: Code duplicated, block: B:76:0x0184  */
    /* JADX WARN: Code duplicated, block: B:77:0x0186  */
    /* JADX WARN: Code duplicated, block: B:79:0x018a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x018d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0192  */
    /* JADX WARN: Code duplicated, block: B:87:0x019e  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11, types: [ni.m] */
    /* JADX WARN: Type inference failed for: r12v17, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x02ea -> B:163:0x02ed). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x02f6 -> B:164:0x02f3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:190:0x0268
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(oh.s r20, java.nio.ByteBuffer r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            Method dump skipped, instruction units count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.a1.b(oh.s, java.nio.ByteBuffer, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8476b;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0099 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x009a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(ContinuationImpl continuationImpl) throws Throwable {
        x0 x0Var;
        v0 v0Var;
        Throwable th2;
        v0 v0Var2;
        a1 a1Var;
        v0 v0Var3;
        g2 g2Var;
        v0 v0Var4;
        if (continuationImpl instanceof x0) {
            x0Var = (x0) continuationImpl;
            int i8 = x0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                x0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                x0Var = new x0(this, continuationImpl);
            }
        } else {
            x0Var = new x0(this, continuationImpl);
        }
        Object obj = x0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = x0Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                v0Var2 = (v0) x0Var.L$2;
                v0Var3 = (v0) x0Var.L$1;
                a1Var = (a1) x0Var.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (ni.x unused) {
                    v0Var = v0Var3;
                    v0Var2.a();
                    g2Var = a1Var.f8480i;
                    x0Var.L$0 = v0Var;
                    x0Var.L$1 = null;
                    x0Var.L$2 = null;
                    x0Var.label = 2;
                    if (g2Var.S(x0Var) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    v0Var4 = v0Var;
                    v0Var3 = v0Var4;
                } catch (Throwable th3) {
                    th2 = th3;
                    v0Var2.a();
                    throw th2;
                }
            } else if (i9 == 2) {
                v0Var4 = (v0) x0Var.L$0;
                ResultKt.throwOnFailure(obj);
                v0Var3 = v0Var4;
            } else {
                if (i9 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        v0Var = new v0((p1) this.f8476b.get(o1.f7483a));
        try {
            ni.m mVar = this.e;
            x0Var.L$0 = this;
            x0Var.L$1 = v0Var;
            x0Var.L$2 = v0Var;
            x0Var.label = 1;
            if (mVar.r(v0Var, x0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            v0Var3 = v0Var;
        } catch (ni.x unused2) {
            a1Var = this;
            v0Var2 = v0Var;
            v0Var2.a();
            g2Var = a1Var.f8480i;
            x0Var.L$0 = v0Var;
            x0Var.L$1 = null;
            x0Var.L$2 = null;
            x0Var.label = 2;
            if (g2Var.S(x0Var) == coroutine_suspended) {
                return coroutine_suspended;
            }
            v0Var4 = v0Var;
            v0Var3 = v0Var4;
        } catch (Throwable th4) {
            th2 = th4;
            v0Var2 = v0Var;
            v0Var2.a();
            throw th2;
        }
        x0Var.L$0 = null;
        x0Var.L$1 = null;
        x0Var.L$2 = null;
        x0Var.label = 3;
        Object objS = v0Var3.f8532a.S(x0Var);
        if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objS = Unit.INSTANCE;
        }
        if (objS == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
