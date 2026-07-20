package gd;

import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Lambda implements Function0 {
    final /* synthetic */ OSBaseBottomSheetDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(OSBaseBottomSheetDialog oSBaseBottomSheetDialog) {
        super(0);
        this.this$0 = oSBaseBottomSheetDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final c invoke() {
        return new c(this.this$0);
    }
}
