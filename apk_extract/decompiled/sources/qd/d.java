package qd;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.view.OSLoadingView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Lambda implements Function0 {
    final /* synthetic */ OSLoadingView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(OSLoadingView oSLoadingView) {
        super(0);
        this.this$0 = oSLoadingView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ValueAnimator invoke() {
        return ValueAnimator.ofFloat(0.0f, this.this$0.f3166a);
    }
}
