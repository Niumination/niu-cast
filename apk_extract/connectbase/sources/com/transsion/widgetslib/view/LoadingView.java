package com.transsion.widgetslib.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.widgetslib.R;
import hj.h;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f2377f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2378g = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2379i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LottieAnimationView f2382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f2383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2384e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2385a;

        public a(boolean z10) {
            this.f2385a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            LoadingView.this.f2384e = 0;
            int measuredWidth = LoadingView.this.getMeasuredWidth();
            Resources resources = LoadingView.this.getContext().getResources();
            String str3 = "loading_medium.json";
            if (resources != null) {
                if (measuredWidth <= resources.getDimensionPixelSize(R.dimen.os_loading_small_size)) {
                    LoadingView loadingView = LoadingView.this;
                    if (loadingView.f2380a) {
                        str2 = "loading_small_colorfull.json";
                    } else {
                        str2 = this.f2385a ? "loading_small_night.json" : "loading_small.json";
                    }
                    str3 = str2;
                    loadingView.f2384e = 2;
                } else if (measuredWidth <= resources.getDimensionPixelSize(R.dimen.os_loading_medium_size)) {
                    LoadingView loadingView2 = LoadingView.this;
                    if (loadingView2.f2380a) {
                        str3 = "loading_medium_colorfull.json";
                    } else if (this.f2385a) {
                        str3 = "loading_medium_night.json";
                    }
                    loadingView2.f2384e = 0;
                } else {
                    LoadingView loadingView3 = LoadingView.this;
                    if (loadingView3.f2380a) {
                        str = "loading_large_colorfull.json";
                    } else {
                        str = this.f2385a ? "loading_large_night.json" : "loading_large.json";
                    }
                    str3 = str;
                    loadingView3.f2384e = 1;
                }
            }
            InputStream inputStreamOpen = null;
            try {
                try {
                    try {
                        inputStreamOpen = LoadingView.this.getContext().getAssets().open(str3);
                        LoadingView.this.f2382c.setAnimation(str3);
                        LoadingView loadingView4 = LoadingView.this;
                        if (loadingView4.f2381b) {
                            loadingView4.f2382c.z();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } catch (Exception e10) {
                        Log.e("LoadingView", "open asset file error", e10);
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (Throwable th2) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th2;
            }
        }
    }

    public LoadingView(@NonNull Context context) {
        super(context);
        this.f2381b = true;
        e();
    }

    public final void e() {
        boolean z10 = h.z(getContext());
        try {
            addView(LayoutInflater.from(getContext()).inflate(R.layout.os_layout_loading, (ViewGroup) null));
            this.f2382c = (LottieAnimationView) findViewById(R.id.loadingView);
            a aVar = new a(z10);
            this.f2383d = aVar;
            post(aVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void f() {
        try {
            Runnable runnable = this.f2383d;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            if (this.f2381b) {
                removeAllViews();
            }
            LottieAnimationView lottieAnimationView = this.f2382c;
            if (lottieAnimationView != null) {
                lottieAnimationView.setProgress(0.0f);
                this.f2382c.k();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void g(String str) {
        if (this.f2382c == null || this.f2380a) {
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = getContext().getAssets().open(str);
                    float progress = this.f2382c.getProgress();
                    this.f2382c.k();
                    this.f2382c.setAnimation(str);
                    this.f2382c.z();
                    this.f2382c.setProgress(progress);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (Exception e10) {
                    Log.e("LoadingView", "open asset file error", e10);
                    if (inputStreamOpen == null) {
                    } else {
                        inputStreamOpen.close();
                    }
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th2) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public void h() {
        String str;
        int i10 = this.f2384e;
        if (i10 == 2) {
            str = "loading_small_night.json";
        } else {
            str = i10 == 1 ? "loading_large_night.json" : "loading_medium_night.json";
        }
        g(str);
    }

    public void i() {
        String str;
        int i10 = this.f2384e;
        if (i10 == 2) {
            str = "loading_small.json";
        } else {
            str = i10 == 1 ? "loading_large.json" : "loading_medium.json";
        }
        g(str);
    }

    public void j(boolean z10) {
        this.f2380a = z10;
        f();
        e();
    }

    public void k() {
        LottieAnimationView lottieAnimationView;
        if (this.f2381b || this.f2382c.v() || (lottieAnimationView = this.f2382c) == null) {
            return;
        }
        lottieAnimationView.z();
    }

    public void setAutoAnim(boolean z10) {
        this.f2381b = z10;
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2381b = true;
        e();
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2381b = true;
        e();
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f2381b = true;
        e();
    }
}
