package gd;

import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Lambda implements Function0 {
    final /* synthetic */ OSBottomSheetContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(OSBottomSheetContainer oSBottomSheetContainer) {
        super(0);
        this.this$0 = oSBottomSheetContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OSBottomSheetPanel invoke() {
        return (OSBottomSheetPanel) this.this$0.findViewById(R$id.drag_panel);
    }
}
