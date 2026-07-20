package se;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q5 extends FunctionReferenceImpl implements Function2 {
    public static final q5 INSTANCE = new q5();

    public q5() {
        super(2, b6.class, "<init>", "<init>(Landroid/content/Context;Lcom/welink/protocol/nfbd/NearLanManager;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final b6 invoke(Context context, com.welink.protocol.nfbd.m mVar) {
        return new b6(context, mVar);
    }
}
