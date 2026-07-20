package gd;

import android.view.View;
import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Lambda implements Function0 {
    final /* synthetic */ OSBottomSheetContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(OSBottomSheetContainer oSBottomSheetContainer) {
        super(0);
        this.this$0 = oSBottomSheetContainer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        return this.this$0.findViewById(R$id.touch_outside);
    }
}
