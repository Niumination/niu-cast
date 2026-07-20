package d6;

import com.tencent.qgame.animplayer.AnimView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Lambda implements Function0 {
    final /* synthetic */ AnimView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(AnimView animView) {
        super(0);
        this.this$0 = animView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final f invoke() {
        return new f(this.this$0);
    }
}
