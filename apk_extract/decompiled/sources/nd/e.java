package nd;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.flipper.FlipperLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Lambda implements Function1 {
    final /* synthetic */ FlipperLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(FlipperLayout flipperLayout) {
        super(1);
        this.this$0 = flipperLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ValueAnimator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ValueAnimator valueAnimator) {
        this.this$0.setAnimator$widgetsLib_release(valueAnimator);
        this.this$0.f();
    }
}
