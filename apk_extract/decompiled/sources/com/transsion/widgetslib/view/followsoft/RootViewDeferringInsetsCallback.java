package com.transsion.widgetslib.view.followsoft;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class RootViewDeferringInsetsCallback extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f3254d;
    public WindowInsetsCompat e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3255h;

    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        this.f3254d = view;
        this.e = windowInsetsCompat;
        boolean z2 = this.f3255h;
        int i8 = this.f3251a;
        if (!z2) {
            i8 |= this.f3252b;
        }
        Insets insets = windowInsetsCompat.getInsets(i8);
        view.getContext();
        boolean zS = j.s();
        boolean z3 = this.f3253c;
        if (zS) {
            if (insets.bottom <= a(96)) {
                if (z3) {
                    view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
                } else {
                    view.setPadding(insets.left, insets.top, insets.right, 0);
                }
            }
        } else if (insets.bottom <= a(48)) {
            if (z3) {
                view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            } else {
                view.setPadding(insets.left, insets.top, insets.right, 0);
            }
        }
        return WindowInsetsCompat.CONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        View view;
        if (!this.f3255h || (windowInsetsAnimationCompat.getTypeMask() & this.f3252b) == 0) {
            return;
        }
        this.f3255h = false;
        WindowInsetsCompat windowInsetsCompat = this.e;
        if (windowInsetsCompat == null || (view = this.f3254d) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        if ((windowInsetsAnimationCompat.getTypeMask() & this.f3252b) != 0) {
            this.f3255h = true;
        }
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        return windowInsetsCompat;
    }
}
