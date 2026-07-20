package ed;

import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.perguide.PerGuideDialog;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Lambda implements Function0 {
    final /* synthetic */ PerGuideDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PerGuideDialog perGuideDialog) {
        super(0);
        this.this$0 = perGuideDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OSScrollbarLayout invoke() {
        return (OSScrollbarLayout) this.this$0.findViewById(R$id.os_damp);
    }
}
