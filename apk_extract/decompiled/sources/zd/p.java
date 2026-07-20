package zd;

import android.widget.FrameLayout;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.OSSegmentedTab;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends Lambda implements Function0 {
    final /* synthetic */ OSSegmentedTab this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(OSSegmentedTab oSSegmentedTab) {
        super(0);
        this.this$0 = oSSegmentedTab;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FrameLayout invoke() {
        return (FrameLayout) this.this$0.findViewById(R$id.segment_container);
    }
}
