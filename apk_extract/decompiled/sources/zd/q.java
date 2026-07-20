package zd;

import android.view.View;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.OSSegmentedTab;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends Lambda implements Function0 {
    final /* synthetic */ OSSegmentedTab this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(OSSegmentedTab oSSegmentedTab) {
        super(0);
        this.this$0 = oSSegmentedTab;
    }

    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        return this.this$0.findViewById(R$id.segment_indicator);
    }
}
