package qd;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Lambda implements Function0 {
    public static final c INSTANCE = new c();

    public c() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ValueAnimator invoke() {
        return ValueAnimator.ofFloat(0.0f, 6.2831855f);
    }
}
