package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
interface ViewPumpActivityFactory {
    @Nullable
    View onActivityCreateView(View view, View view2, String str, Context context, AttributeSet attributeSet);
}
