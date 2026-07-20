package gd;

import android.view.View;
import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends Lambda implements Function0 {
    final /* synthetic */ OSBottomSheetPanel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(OSBottomSheetPanel oSBottomSheetPanel) {
        super(0);
        this.this$0 = oSBottomSheetPanel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        return this.this$0.findViewById(R$id.drag_rect);
    }
}
