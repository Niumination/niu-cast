package ed;

import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.perguide.PerGuideDialog;
import com.transsion.widgetsliquid.effect.OSMaskFrameLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Lambda implements Function0 {
    final /* synthetic */ PerGuideDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PerGuideDialog perGuideDialog) {
        super(0);
        this.this$0 = perGuideDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OSMaskFrameLayout invoke() {
        return (OSMaskFrameLayout) this.this$0.findViewById(R$id.announcement_top_mask);
    }
}
