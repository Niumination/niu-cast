package d6;

import com.tencent.qgame.animplayer.AnimView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Lambda implements Function0 {
    final /* synthetic */ AnimView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(AnimView animView) {
        super(0);
        this.this$0 = animView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m139invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m139invoke() {
        this.this$0.removeAllViews();
    }
}
