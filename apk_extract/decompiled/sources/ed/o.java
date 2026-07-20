package ed;

import android.widget.TextView;
import com.transsion.widgetPerGuide.R$id;
import com.transsion.widgetPerGuide.perguide.PerGuideSpecialDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Lambda implements Function0 {
    final /* synthetic */ PerGuideSpecialDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PerGuideSpecialDialog perGuideSpecialDialog) {
        super(0);
        this.this$0 = perGuideSpecialDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R$id.tv_text_button);
    }
}
