package ed;

import android.widget.LinearLayout;
import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.perguide.PerGuideSpecialDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Lambda implements Function0 {
    final /* synthetic */ PerGuideSpecialDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PerGuideSpecialDialog perGuideSpecialDialog) {
        super(0);
        this.this$0 = perGuideSpecialDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R$id.ll_text_button);
    }
}
