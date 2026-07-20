package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface FallbackViewCreator {
    @Nullable
    View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @Nullable AttributeSet attributeSet);
}
