package gg;

import java.nio.channels.ReadableByteChannel;
import jh.z0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.k $channel;
    final /* synthetic */ ReadableByteChannel $nioChannel;
    final /* synthetic */ fg.s $selectable;
    final /* synthetic */ fg.u $selector;
    final /* synthetic */ x $socketOptions;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(fg.s sVar, x xVar, jh.k kVar, ReadableByteChannel readableByteChannel, fg.u uVar, Continuation<? super f> continuation) {
        super(2, continuation);
        this.$selectable = sVar;
        this.$socketOptions = xVar;
        this.$channel = kVar;
        this.$nioChannel = readableByteChannel;
        this.$selector = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        f fVar = new f(this.$selectable, this.$socketOptions, this.$channel, this.$nioChannel, this.$selector, continuation);
        fVar.L$0 = obj;
        return fVar;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0171 A[Catch: all -> 0x00a4, PHI: r1 r5 r6 r7 r8
      0x0171: PHI (r1v24 fg.u) = (r1v10 fg.u), (r1v22 fg.u), (r1v25 fg.u) binds: [B:29:0x00d4, B:68:0x01b0, B:56:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r5v21 fg.s) = (r5v7 fg.s), (r5v19 fg.s), (r5v22 fg.s) binds: [B:29:0x00d4, B:68:0x01b0, B:56:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r6v18 java.nio.channels.ReadableByteChannel) = 
      (r6v4 java.nio.channels.ReadableByteChannel)
      (r6v16 java.nio.channels.ReadableByteChannel)
      (r6v19 java.nio.channels.ReadableByteChannel)
     binds: [B:29:0x00d4, B:68:0x01b0, B:56:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r7v18 jh.k) = (r7v4 jh.k), (r7v16 jh.k), (r7v19 jh.k) binds: [B:29:0x00d4, B:68:0x01b0, B:56:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r8v20 lg.c) = (r8v6 lg.c), (r8v18 lg.c), (r8v21 lg.c) binds: [B:29:0x00d4, B:68:0x01b0, B:56:0x016e] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x00a4, blocks: (B:94:0x0240, B:43:0x0122, B:45:0x012a, B:47:0x0134, B:51:0x014f, B:53:0x0157, B:55:0x015d, B:58:0x0171, B:64:0x0196, B:67:0x01aa, B:61:0x0191, B:70:0x01b4, B:98:0x024c, B:100:0x0250, B:101:0x0253, B:103:0x025b, B:112:0x027c, B:95:0x0246, B:96:0x0249, B:21:0x009f, B:26:0x00bb, B:29:0x00d4, B:32:0x00ed, B:35:0x00f8, B:37:0x0104, B:40:0x010e, B:7:0x002c, B:91:0x0236, B:82:0x01f8, B:88:0x021f, B:85:0x021a, B:93:0x023e, B:71:0x01b7, B:75:0x01d4, B:77:0x01dc, B:79:0x01e2, B:12:0x004c, B:15:0x0069, B:18:0x0086), top: B:122:0x0009, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0190  */
    /* JADX WARN: Code duplicated, block: B:61:0x0191 A[Catch: all -> 0x00a4, TryCatch #2 {all -> 0x00a4, blocks: (B:94:0x0240, B:43:0x0122, B:45:0x012a, B:47:0x0134, B:51:0x014f, B:53:0x0157, B:55:0x015d, B:58:0x0171, B:64:0x0196, B:67:0x01aa, B:61:0x0191, B:70:0x01b4, B:98:0x024c, B:100:0x0250, B:101:0x0253, B:103:0x025b, B:112:0x027c, B:95:0x0246, B:96:0x0249, B:21:0x009f, B:26:0x00bb, B:29:0x00d4, B:32:0x00ed, B:35:0x00f8, B:37:0x0104, B:40:0x010e, B:7:0x002c, B:91:0x0236, B:82:0x01f8, B:88:0x021f, B:85:0x021a, B:93:0x023e, B:71:0x01b7, B:75:0x01d4, B:77:0x01dc, B:79:0x01e2, B:12:0x004c, B:15:0x0069, B:18:0x0086), top: B:122:0x0009, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0195 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x01b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0157 -> B:43:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x015b -> B:43:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01b0 -> B:58:0x0171). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01b2 -> B:43:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x01dc -> B:93:0x023e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x01e0 -> B:93:0x023e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0233 -> B:91:0x0236). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gg.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(z0 z0Var, Continuation<? super Unit> continuation) {
        return ((f) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
