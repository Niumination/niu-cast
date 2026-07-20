package zd;

import android.widget.LinearLayout;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.OSSegmentedTab;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends Lambda implements Function0 {
    final /* synthetic */ OSSegmentedTab this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(OSSegmentedTab oSSegmentedTab) {
        super(0);
        this.this$0 = oSSegmentedTab;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LinearLayout invoke() {
        return (LinearLayout) this.this$0.findViewById(R$id.capsule_tab_container);
    }
}
