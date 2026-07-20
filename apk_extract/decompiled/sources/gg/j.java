package gg;

import java.nio.channels.WritableByteChannel;
import jh.w0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends SuspendLambda implements Function2 {
    final /* synthetic */ jh.k $channel;
    final /* synthetic */ WritableByteChannel $nioChannel;
    final /* synthetic */ fg.s $selectable;
    final /* synthetic */ fg.u $selector;
    final /* synthetic */ x $socketOptions;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(fg.s sVar, x xVar, jh.k kVar, fg.u uVar, WritableByteChannel writableByteChannel, Continuation<? super j> continuation) {
        super(2, continuation);
        this.$selectable = sVar;
        this.$socketOptions = xVar;
        this.$channel = kVar;
        this.$selector = uVar;
        this.$nioChannel = writableByteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        j jVar = new j(this.$selectable, this.$socketOptions, this.$channel, this.$selector, this.$nioChannel, continuation);
        jVar.L$0 = obj;
        return jVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007c A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:8:0x0017, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:35:0x0097, B:37:0x00ac, B:39:0x00b2, B:53:0x010c, B:55:0x0110, B:40:0x00ba, B:44:0x00ce, B:48:0x00d7, B:49:0x00fe, B:50:0x00ff, B:52:0x0105, B:59:0x0130, B:61:0x0134, B:15:0x0038, B:20:0x0052, B:22:0x0056, B:25:0x0060), top: B:85:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0084 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:8:0x0017, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:35:0x0097, B:37:0x00ac, B:39:0x00b2, B:53:0x010c, B:55:0x0110, B:40:0x00ba, B:44:0x00ce, B:48:0x00d7, B:49:0x00fe, B:50:0x00ff, B:52:0x0105, B:59:0x0130, B:61:0x0134, B:15:0x0038, B:20:0x0052, B:22:0x0056, B:25:0x0060), top: B:85:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ac A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:8:0x0017, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:35:0x0097, B:37:0x00ac, B:39:0x00b2, B:53:0x010c, B:55:0x0110, B:40:0x00ba, B:44:0x00ce, B:48:0x00d7, B:49:0x00fe, B:50:0x00ff, B:52:0x0105, B:59:0x0130, B:61:0x0134, B:15:0x0038, B:20:0x0052, B:22:0x0056, B:25:0x0060), top: B:85:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x0105 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:8:0x0017, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:35:0x0097, B:37:0x00ac, B:39:0x00b2, B:53:0x010c, B:55:0x0110, B:40:0x00ba, B:44:0x00ce, B:48:0x00d7, B:49:0x00fe, B:50:0x00ff, B:52:0x0105, B:59:0x0130, B:61:0x0134, B:15:0x0038, B:20:0x0052, B:22:0x0056, B:25:0x0060), top: B:85:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0110 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:8:0x0017, B:28:0x0074, B:30:0x007c, B:32:0x0084, B:35:0x0097, B:37:0x00ac, B:39:0x00b2, B:53:0x010c, B:55:0x0110, B:40:0x00ba, B:44:0x00ce, B:48:0x00d7, B:49:0x00fe, B:50:0x00ff, B:52:0x0105, B:59:0x0130, B:61:0x0134, B:15:0x0038, B:20:0x0052, B:22:0x0056, B:25:0x0060), top: B:85:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x012d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x010e -> B:28:0x0074). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x012b -> B:28:0x0074). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gg.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(w0 w0Var, Continuation<? super Unit> continuation) {
        return ((j) create(w0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
