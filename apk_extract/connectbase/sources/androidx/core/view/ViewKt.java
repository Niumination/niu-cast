package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewKt;
import gq.m;
import gq.q;
import gq.s;
import in.i;
import k4.f;
import kn.l0;
import kn.r1;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,432:1\n40#1:433\n56#1:434\n329#1,4:438\n43#2,3:435\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n71#1:433\n71#1:434\n315#1:438,4\n238#1:435,3\n*E\n"})
public final class ViewKt {
    public static final void doOnAttach(@l final View view, @l final jn.l<? super View, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, f.f8937e);
        if (ViewCompat.isAttachedToWindow(view)) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnAttach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@l View view2) {
                    l0.p(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@l View view2) {
                    l0.p(view2, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@l final View view, @l final jn.l<? super View, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, f.f8937e);
        if (ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt.doOnDetach.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@l View view2) {
                    l0.p(view2, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@l View view2) {
                    l0.p(view2, "view");
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnLayout(@l View view, @l final jn.l<? super View, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, f.f8937e);
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@l View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    l0.p(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    lVar.invoke(view2);
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(@l View view, @l final jn.l<? super View, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, f.f8937e);
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt.doOnNextLayout.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@l View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                l0.p(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                lVar.invoke(view2);
            }
        });
    }

    @l
    public static final OneShotPreDrawListener doOnPreDraw(@l final View view, @l final jn.l<? super View, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, f.f8937e);
        OneShotPreDrawListener oneShotPreDrawListenerAdd = OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt.doOnPreDraw.1
            @Override // java.lang.Runnable
            public final void run() {
                lVar.invoke(view);
            }
        });
        l0.o(oneShotPreDrawListenerAdd, "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        return oneShotPreDrawListenerAdd;
    }

    @l
    public static final Bitmap drawToBitmap(@l View view, @l Bitmap.Config config) {
        l0.p(view, "<this>");
        l0.p(config, "config");
        if (!ViewCompat.isLaidOut(view)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    @l
    public static final m<View> getAllViews(@l View view) {
        l0.p(view, "<this>");
        return q.b(new ViewKt$allViews$1(view, null));
    }

    @l
    public static final m<ViewParent> getAncestors(@l View view) {
        l0.p(view, "<this>");
        return s.l(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@l View view) {
        l0.p(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@l View view) {
        l0.p(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(@l View view) {
        l0.p(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(@l View view) {
        l0.p(view, "<this>");
        return view.getVisibility() == 0;
    }

    @l
    public static final Runnable postDelayed(@l View view, long j10, @l final jn.a<l2> aVar) {
        l0.p(view, "<this>");
        l0.p(aVar, f.f8937e);
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                aVar.invoke();
            }
        };
        view.postDelayed(runnable, j10);
        return runnable;
    }

    @RequiresApi(16)
    @l
    public static final Runnable postOnAnimationDelayed(@l View view, long j10, @l final jn.a<l2> aVar) {
        l0.p(view, "<this>");
        l0.p(aVar, f.f8937e);
        Runnable runnable = new Runnable() { // from class: y.h
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.postOnAnimationDelayed$lambda$1(aVar);
            }
        };
        Api16Impl.postOnAnimationDelayed(view, runnable, j10);
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(jn.a aVar) {
        l0.p(aVar, "$action");
        aVar.invoke();
    }

    public static final void setGone(@l View view, boolean z10) {
        l0.p(view, "<this>");
        view.setVisibility(z10 ? 8 : 0);
    }

    public static final void setInvisible(@l View view, boolean z10) {
        l0.p(view, "<this>");
        view.setVisibility(z10 ? 4 : 0);
    }

    public static final void setPadding(@l View view, @Px int i10) {
        l0.p(view, "<this>");
        view.setPadding(i10, i10, i10, i10);
    }

    public static final void setVisible(@l View view, boolean z10) {
        l0.p(view, "<this>");
        view.setVisibility(z10 ? 0 : 8);
    }

    public static final void updateLayoutParams(@l View view, @l jn.l<? super ViewGroup.LayoutParams, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        lVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    @i(name = "updateLayoutParamsTyped")
    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, jn.l<? super T, l2> lVar) {
        l0.p(view, "<this>");
        l0.p(lVar, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        l0.P();
        lVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@l View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        l0.p(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingLeft();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingRight();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        l0.p(view, "<this>");
        view.setPadding(i10, i11, i12, i13);
    }

    @RequiresApi(17)
    @b.a({"ClassVerificationFailure"})
    public static final void updatePaddingRelative(@l View view, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        l0.p(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = view.getPaddingStart();
        }
        if ((i14 & 2) != 0) {
            i11 = view.getPaddingTop();
        }
        if ((i14 & 4) != 0) {
            i12 = view.getPaddingEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = view.getPaddingBottom();
        }
        l0.p(view, "<this>");
        view.setPaddingRelative(i10, i11, i12, i13);
    }
}
