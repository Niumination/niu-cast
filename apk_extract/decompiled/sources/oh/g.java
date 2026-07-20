package oh;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends SuspendLambda implements Function2 {
    final /* synthetic */ ni.g0 $ponger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, ni.g0 g0Var, Continuation<? super g> continuation) {
        super(2, continuation);
        this.this$0 = kVar;
        this.$ponger = g0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        g gVar = new g(this.this$0, this.$ponger, continuation);
        gVar.L$0 = obj;
        return gVar;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x030f A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x031c A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x037f A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x039b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x039c  */
    /* JADX WARN: Code duplicated, block: B:112:0x03ab A[Catch: all -> 0x009c, TRY_ENTER, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0170 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0171  */
    /* JADX WARN: Code duplicated, block: B:43:0x0184 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0192 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0225  */
    /* JADX WARN: Code duplicated, block: B:73:0x024e A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0252 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:77:0x026b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x026c A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0270 A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #3 {all -> 0x004a, blocks: (B:9:0x0045, B:109:0x03a4, B:41:0x017c, B:43:0x0184, B:45:0x0192, B:46:0x01ae, B:48:0x01b2, B:50:0x01ba, B:52:0x01c6, B:53:0x01c8, B:56:0x01e5, B:65:0x0226, B:67:0x022a, B:69:0x0230, B:72:0x024a, B:73:0x024e, B:75:0x0252, B:78:0x026c, B:79:0x0270, B:114:0x03b8, B:14:0x006e, B:22:0x00c3, B:25:0x00e8, B:29:0x0105, B:32:0x012a), top: B:161:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:81:0x028f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0290  */
    /* JADX WARN: Code duplicated, block: B:85:0x02a0 A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x02a4 A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x02aa A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x02b1 A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x02cc A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02d0 A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02de A[Catch: all -> 0x009c, TryCatch #5 {all -> 0x009c, blocks: (B:83:0x029c, B:85:0x02a0, B:87:0x02a4, B:88:0x02a6, B:90:0x02aa, B:91:0x02b1, B:92:0x02cc, B:94:0x02d0, B:96:0x02de, B:101:0x030f, B:102:0x031b, B:103:0x031c, B:105:0x037f, B:112:0x03ab, B:113:0x03b7, B:17:0x0097), top: B:164:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x02f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:99:0x02fa  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [T, java.lang.Object, oh.s] */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r14v18, types: [T, java.lang.Object] */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x039c -> B:109:0x03a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x022e -> B:100:0x0302). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x02fa -> B:100:0x0302). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 1260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
