package jb;

import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ String $appVersion;
    final /* synthetic */ int $defaultVersion;
    final /* synthetic */ FunctionGuideResponse $info;
    final /* synthetic */ String $languageCode;
    final /* synthetic */ String $saveDirPath;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FunctionGuideResponse functionGuideResponse, int i8, e eVar, String str, String str2, String str3, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$info = functionGuideResponse;
        this.$defaultVersion = i8;
        this.this$0 = eVar;
        this.$saveDirPath = str;
        this.$appVersion = str2;
        this.$languageCode = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.$info, this.$defaultVersion, this.this$0, this.$saveDirPath, this.$appVersion, this.$languageCode, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:23:0x00fc A[LOOP:1: B:21:0x00f6->B:23:0x00fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x012b A[LOOP:2: B:25:0x0125->B:27:0x012b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x014c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0152  */
    /* JADX WARN: Code duplicated, block: B:33:0x015f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0168  */
    /* JADX WARN: Code duplicated, block: B:37:0x0173  */
    /* JADX WARN: Code duplicated, block: B:42:0x01b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01b5 A[EDGE_INSN: B:43:0x01b5->B:6:0x0038 BREAK  A[LOOP:0: B:18:0x00b2->B:51:0x01f5]] */
    /* JADX WARN: Code duplicated, block: B:50:0x01ee A[LOOP:3: B:29:0x014a->B:50:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0203  */
    /* JADX WARN: Code duplicated, block: B:56:0x020b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0252  */
    /* JADX WARN: Code duplicated, block: B:61:0x0276  */
    /* JADX WARN: Code duplicated, block: B:64:0x029a  */
    /* JADX WARN: Code duplicated, block: B:65:0x029e  */
    /* JADX WARN: Code duplicated, block: B:68:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01b5 -> B:6:0x0038). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x00b8
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
