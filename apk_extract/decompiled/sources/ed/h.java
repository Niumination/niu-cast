package ed;

import com.transsion.widgetPerGuide.perguide.PerGuideAdapter;
import com.transsion.widgetPerGuide.perguide.PerGuideDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Lambda implements Function0 {
    final /* synthetic */ PerGuideDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PerGuideDialog perGuideDialog) {
        super(0);
        this.this$0 = perGuideDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final PerGuideAdapter invoke() {
        return new PerGuideAdapter(this.this$0.u);
    }
}
