package nd;

import android.view.View;
import com.transsion.widgetslib.flipper.FlipperLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Lambda implements Function0 {
    final /* synthetic */ FlipperLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(FlipperLayout flipperLayout) {
        super(0);
        this.this$0 = flipperLayout;
    }

    @Override // kotlin.jvm.functions.Function0
    public final View.OnTouchListener invoke() {
        return new b4.f(this.this$0, 5);
    }
}
