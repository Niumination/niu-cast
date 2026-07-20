package com.transsion.widgetslib.view;

import af.z0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class LoadingView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3120d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieAnimationView f3122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z0 f3123c;

    public LoadingView(@NonNull Context context) {
        super(context);
        this.f3121a = true;
        a();
    }

    public final void a() {
        Context context = getContext();
        String[] strArr = j.f8764a;
        boolean zC = hd.a.c(context);
        try {
            addView(LayoutInflater.from(getContext()).inflate(R$layout.os_layout_loading, (ViewGroup) null));
            this.f3122b = (LottieAnimationView) findViewById(R$id.loadingView);
            z0 z0Var = new z0(this, zC, 1);
            this.f3123c = z0Var;
            post(z0Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        try {
            z0 z0Var = this.f3123c;
            if (z0Var != null) {
                removeCallbacks(z0Var);
            }
            if (this.f3121a) {
                removeAllViews();
            }
            LottieAnimationView lottieAnimationView = this.f3122b;
            if (lottieAnimationView != null) {
                lottieAnimationView.setProgress(0.0f);
                this.f3122b.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAutoAnim(boolean z2) {
        this.f3121a = z2;
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3121a = true;
        a();
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3121a = true;
        a();
    }
}
