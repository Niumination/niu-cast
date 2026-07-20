package ed;

import android.widget.TextView;
import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.perguide.PerGuideBaseDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Lambda implements Function0 {
    final /* synthetic */ PerGuideBaseDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PerGuideBaseDialog perGuideBaseDialog) {
        super(0);
        this.this$0 = perGuideBaseDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R$id.tv_title);
    }
}
