package com.transsion.widgetslib.view.damping;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b8.e;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.LoadingView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import ie.a;
import pd.j;
import rd.b;
import rd.c;
import rd.d;
import tj.w;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class DampingLayout extends OverBoundNestedScrollView {
    private static final int ANIM_DURATION = 300;
    private static final float REFRESHING_DELTA_ALPHA = 1.0f;
    private static final float REFRESHING_DELTA_SCALE = 0.5f;
    private static final float REFRESHING_DELTA_SCALE_LOADING_VIEW = 0.8f;
    private static final float REFRESHING_START_ALPHA = 0.0f;
    private static final float REFRESHING_START_SCALE = 0.5f;
    private static final float REFRESHING_START_SCALE_LOADING_VIEW = 0.2f;
    private static final String TAG = "DampingLayout";
    private Activity mActivity;
    private ValueAnimator mAnimRefreshFinish;
    private ValueAnimator mAnimScrollBarFade;
    private ValueAnimator mAnimatorUnfold;
    private int mBarCanSlideDistance;
    private final int mBarMarginRight;
    private final int mBarMarginTop;
    private int mBarMinLen;
    private int mBarPullMinLen;
    private int mBarWidth;
    private a mCubicInterpolator;
    private int mDampingLayoutHeight;
    private int mDampingMode;
    private boolean mHasScrollBar;
    private int mHeightRefreshLayout;
    private boolean mIsAbortRefreshing;
    private boolean mIsLimitDampingEdge;
    private boolean mIsRefreshing;
    private View mLayoutContent;
    private int mLayoutContentCanSlideDistance;
    private int mLayoutContentHeight;
    private LoadingView mLoadingView;
    private int mLoadingViewHeight;
    private float mLoadingViewTransDistance;
    private float mOffsetY;
    private d mOnRefreshListener;
    private e mOverScrollDecor;
    private float mOverScrollDistance;
    private final Rect mRect;
    private Runnable mRunnable;
    private final Runnable mRunnableFade;
    private TextView mTextRefreshing;
    private float mTextRefreshingTransDistance;
    private int mUseScene;
    private View mViewScrollBar;

    public DampingLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnim(Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.cancel();
    }

    private ViewGroup getBarLayoutAttach() {
        if (this.mUseScene != 1) {
            Activity activity = this.mActivity;
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return (ViewGroup) this.mActivity.getWindow().findViewById(R.id.content);
        }
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            return viewGroup;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        viewGroup.removeView(this);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this);
        viewGroup.addView(frameLayout, iIndexOfChild, layoutParams);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOverScrollDistance(float f) {
        onOverPull(f);
        this.mOverScrollDistance = f;
        if (this.mIsRefreshing && f == 0.0f && this.mIsAbortRefreshing) {
            refreshFinishAnim();
        }
    }

    private void handleTouchEvent(MotionEvent motionEvent) {
        LottieAnimationView lottieAnimationView;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f = this.mOverScrollDistance;
                if (f > 0.0f) {
                    if (f <= this.mHeightRefreshLayout) {
                        this.mLayoutContent.setTranslationY(f);
                        this.mTextRefreshing.setText(R$string.os_dampingl_down_pull_refresh);
                        refreshTitleLayout(this.mOverScrollDistance);
                        return;
                    } else {
                        this.mTextRefreshing.setText(R$string.os_dampingl_release_for_refresh);
                        if (this.mLayoutContent.getTranslationY() < this.mHeightRefreshLayout) {
                            playAnimatorUnfold();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        if (this.mOverScrollDistance < this.mHeightRefreshLayout) {
            refreshFinishAnim();
            return;
        }
        this.mIsRefreshing = true;
        this.mTextRefreshing.setText(R$string.os_dampingl_refreshing);
        LoadingView loadingView = this.mLoadingView;
        if (!loadingView.f3121a && !loadingView.f3122b.e.j() && (lottieAnimationView = loadingView.f3122b) != null) {
            lottieAnimationView.d();
        }
        if (this.mLayoutContent.getTranslationY() < this.mHeightRefreshLayout) {
            playAnimatorUnfold();
        }
        if (this.mRunnable == null) {
            this.mRunnable = new b(this, 3);
        }
        if (getHandler() != null) {
            getHandler().postDelayed(this.mRunnable, 2000L);
        }
    }

    private void init() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mTextRefreshingTransDistance = TypedValue.applyDimension(1, 15.0f, displayMetrics);
        this.mLoadingViewTransDistance = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.mHeightRefreshLayout = getResources().getDimensionPixelSize(R$dimen.os_damping_layout_loading_title);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_damping_layout_loading_view);
        this.mLoadingViewHeight = dimensionPixelSize;
        this.mTextRefreshingTransDistance += dimensionPixelSize;
        this.mBarPullMinLen = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        this.mBarMinLen = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
        if (getContext() instanceof Activity) {
            this.mActivity = (Activity) getContext();
        }
        setVerticalScrollbarThumbDrawable(new ColorDrawable(0));
        setVerticalScrollBarEnabled(true);
    }

    private void initAnimScrollBarFade() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mAnimScrollBarFade = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.mAnimScrollBarFade.setDuration(getScrollBarFadeDuration());
        this.mAnimScrollBarFade.addUpdateListener(new c(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUpOverScroll() {
        if (!j.f8769h && this.mOverScrollDecor == null) {
            e upOverScroll = setUpOverScroll();
            this.mOverScrollDecor = upOverScroll;
            if (upOverScroll == null) {
                return;
            }
            ((z1OoOnew) upOverScroll).A = new w(this, 16);
            onEdgeEffect();
        }
    }

    private void onEdgeEffect() {
        d8.d dVar;
        d8.d dVar2;
        if ((getEdgeGlowTop() instanceof b8.d) && (dVar2 = ((b8.d) getEdgeGlowTop()).f1222b) != null) {
            dVar2.a(new rd.a(this, 1));
        }
        if (!(getEdgeGlowBottom() instanceof b8.d) || (dVar = ((b8.d) getEdgeGlowBottom()).f1222b) == null) {
            return;
        }
        dVar.a(new rd.a(this, 0));
    }

    private void onOverPull(float f) {
        if (!this.mHasScrollBar || this.mViewScrollBar == null) {
            return;
        }
        cancelAnim(this.mAnimScrollBarFade);
        if (this.mViewScrollBar.getAlpha() != 1.0f) {
            this.mViewScrollBar.setAlpha(1.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.mViewScrollBar.getLayoutParams();
        float fAbs = Math.abs(f);
        if (f > 0.0f) {
            Rect rect = this.mRect;
            int i8 = (int) (layoutParams.height - fAbs);
            rect.bottom = i8;
            int i9 = this.mBarPullMinLen;
            if (i8 <= i9) {
                rect.bottom = i9;
            }
        } else if (f < 0.0f) {
            Rect rect2 = this.mRect;
            int i10 = (int) fAbs;
            rect2.top = i10;
            int i11 = this.mBarPullMinLen;
            int i12 = i10 + i11;
            int i13 = layoutParams.height;
            if (i12 >= i13) {
                rect2.top = i13 - i11;
            }
        } else {
            Rect rect3 = this.mRect;
            rect3.top = 0;
            rect3.bottom = layoutParams.height;
            sendScrollBarFadeMsg();
        }
        View view = this.mViewScrollBar;
        Rect rect4 = this.mRect;
        view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
    }

    private void playAnimatorUnfold() {
        int i8 = 0;
        if (this.mAnimatorUnfold == null) {
            this.mAnimatorUnfold = ValueAnimator.ofFloat(new float[0]);
        }
        if (this.mAnimatorUnfold.isRunning()) {
            return;
        }
        this.mAnimatorUnfold.setFloatValues(this.mLayoutContent.getTranslationY(), this.mHeightRefreshLayout);
        this.mAnimatorUnfold.setDuration(50L);
        this.mAnimatorUnfold.setInterpolator(new LinearInterpolator());
        this.mAnimatorUnfold.addUpdateListener(new c(this, i8));
        this.mAnimatorUnfold.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFinishAnim() {
        int i8 = 1;
        float translationY = this.mLayoutContent.getTranslationY();
        if (translationY < 0.0f) {
            return;
        }
        if (this.mAnimRefreshFinish == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
            this.mAnimRefreshFinish = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.mAnimRefreshFinish.setInterpolator(this.mCubicInterpolator);
            this.mAnimRefreshFinish.addUpdateListener(new c(this, i8));
            this.mAnimRefreshFinish.addListener(new ke.d(this, 4));
        }
        this.mAnimRefreshFinish.setFloatValues(translationY, 0.0f);
        this.mAnimRefreshFinish.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTitleLayout(float f) {
        try {
            int i8 = this.mHeightRefreshLayout;
            if (f > i8) {
                return;
            }
            float f4 = f / i8;
            this.mTextRefreshing.setScaleX((f4 * 0.5f) + 0.5f);
            TextView textView = this.mTextRefreshing;
            textView.setScaleY(textView.getScaleX());
            float f10 = (1.0f * f4) + 0.0f;
            this.mTextRefreshing.setAlpha(f10);
            float f11 = this.mTextRefreshingTransDistance;
            if (f <= f11) {
                f11 = f;
            }
            this.mTextRefreshing.setTranslationY(f11);
            float f12 = f - this.mLoadingViewHeight;
            float f13 = this.mLoadingViewTransDistance;
            if (f12 > f13) {
                f12 = f13;
            }
            this.mLoadingView.setScaleX((f4 * REFRESHING_DELTA_SCALE_LOADING_VIEW) + 0.2f);
            LoadingView loadingView = this.mLoadingView;
            loadingView.setScaleY(loadingView.getScaleX());
            this.mLoadingView.setAlpha(f10);
            this.mLoadingView.setTranslationY(f12);
        } catch (Exception e) {
            Log.e(TAG, "refreshTitleLayout, error", e);
        }
    }

    private void releaseResource() {
        cancelAnim(this.mAnimatorUnfold);
        cancelAnim(this.mAnimRefreshFinish);
        cancelAnim(this.mAnimScrollBarFade);
        LoadingView loadingView = this.mLoadingView;
        if (loadingView != null) {
            loadingView.b();
        }
        Handler handler = getHandler();
        if (handler != null) {
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            handler.removeCallbacks(this.mRunnableFade);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendScrollBarFadeMsg() {
        Handler handler = getHandler();
        if (handler != null) {
            if (handler.hasCallbacks(this.mRunnableFade)) {
                handler.removeCallbacks(this.mRunnableFade);
            }
            handler.postDelayed(this.mRunnableFade, 100L);
        }
    }

    private void translateScrollBar(int i8) {
        if (this.mViewScrollBar != null) {
            this.mHasScrollBar = true;
            cancelAnim(this.mAnimScrollBarFade);
            if (this.mViewScrollBar.getAlpha() != 1.0f) {
                this.mViewScrollBar.setAlpha(1.0f);
            }
            this.mViewScrollBar.setTranslationY(this.mOffsetY + (((i8 * 1.0f) / this.mLayoutContentCanSlideDistance) * this.mBarCanSlideDistance) + this.mBarMarginTop);
        }
    }

    public void abortRefreshing() {
        if (this.mOverScrollDistance == 0.0f) {
            this.mIsAbortRefreshing = false;
            if (this.mIsRefreshing) {
                refreshFinishAnim();
            }
        } else {
            this.mIsAbortRefreshing = true;
            this.mLoadingView.b();
            this.mTextRefreshing.setText(R$string.os_dampingl_refresh_finish);
        }
        postDelayed(new b(this, 4), 60L);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mOverScrollDecor == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.mIsRefreshing && this.mDampingMode == 0) {
            handleTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.View
    public void draw(Canvas canvas) {
        int safeInsetLeft;
        Activity activity;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        super.draw(canvas);
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        int height = getHeight();
        Drawable verticalScrollbarThumbDrawable = getVerticalScrollbarThumbDrawable();
        if (height <= 0 || height >= iComputeVerticalScrollRange || verticalScrollbarThumbDrawable == null || verticalScrollbarThumbDrawable.getBounds().isEmpty()) {
            if (this.mHasScrollBar && this.mViewScrollBar != null) {
                cancelAnim(this.mAnimScrollBarFade);
                this.mViewScrollBar.setAlpha(0.0f);
            }
            this.mHasScrollBar = false;
            return;
        }
        if (this.mLayoutContentHeight == iComputeVerticalScrollRange && this.mDampingLayoutHeight == height) {
            return;
        }
        if (this.mViewScrollBar == null) {
            ViewGroup barLayoutAttach = getBarLayoutAttach();
            if (barLayoutAttach == null) {
                return;
            }
            rd.e eVar = new rd.e(getContext(), 0);
            this.mViewScrollBar = eVar;
            barLayoutAttach.addView(eVar);
            this.mViewScrollBar.setBackgroundColor(Color.parseColor("#7FA1A1A1"));
            barLayoutAttach.bringChildToFront(this.mViewScrollBar);
        }
        if (this.mUseScene == 1) {
            int right = ((getRight() - getLeft()) - this.mBarWidth) - this.mBarMarginRight;
            View view = this.mViewScrollBar;
            if (j.v()) {
                right = -right;
            }
            view.setTranslationX(right);
            this.mOffsetY = getTop();
        } else {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            int i8 = iArr[0];
            int i9 = iArr[1];
            int right2 = (((getRight() + i8) - getLeft()) - this.mBarWidth) - this.mBarMarginRight;
            if (!j.v() || (activity = this.mActivity) == null || activity.getWindowManager() == null || (currentWindowMetrics = this.mActivity.getWindowManager().getCurrentWindowMetrics()) == null || currentWindowMetrics.getBounds() == null) {
                safeInsetLeft = 0;
            } else {
                Rect bounds = currentWindowMetrics.getBounds();
                safeInsetLeft = (getResources().getConfiguration().orientation != 2 || (windowInsets = currentWindowMetrics.getWindowInsets()) == null || windowInsets.getDisplayCutout() == null) ? 0 : windowInsets.getDisplayCutout().getSafeInsetLeft();
                right2 = (((i8 + this.mBarWidth) + this.mBarMarginRight) - bounds.width()) + safeInsetLeft;
            }
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
            Activity activity2 = this.mActivity;
            this.mOffsetY = (i9 - dimensionPixelSize) - ((activity2 == null || activity2.getActionBar() == null) ? 0 : this.mActivity.getActionBar().getHeight());
            Activity activity3 = this.mActivity;
            if (activity3 != null && activity3.getWindow() != null && this.mActivity.getWindow().getAttributes().layoutInDisplayCutoutMode == 1) {
                this.mOffsetY = i9;
                right2 -= safeInsetLeft;
            }
            this.mViewScrollBar.setTranslationX(right2);
        }
        Rect bounds2 = verticalScrollbarThumbDrawable.getBounds();
        ViewGroup.LayoutParams layoutParams = this.mViewScrollBar.getLayoutParams();
        int iHeight = bounds2.height();
        layoutParams.height = iHeight;
        layoutParams.width = this.mBarWidth;
        int i10 = this.mBarMinLen;
        if (iHeight < i10) {
            if (i10 > height) {
                this.mBarMinLen = height;
            }
            layoutParams.height = this.mBarMinLen;
        }
        ((ViewGroup) this.mViewScrollBar.getParent()).updateViewLayout(this.mViewScrollBar, layoutParams);
        this.mLayoutContentCanSlideDistance = iComputeVerticalScrollRange - height;
        int i11 = (height - layoutParams.height) - (this.mBarMarginTop * 2);
        this.mBarCanSlideDistance = i11;
        if (i11 < 0) {
            this.mBarCanSlideDistance = 0;
        }
        this.mLayoutContentHeight = iComputeVerticalScrollRange;
        this.mDampingLayoutHeight = height;
        postDelayed(new b(this, 0), 100L);
        translateScrollBar(getScrollY());
    }

    public LoadingView getLoadingView() {
        return this.mLoadingView;
    }

    public boolean isRefreshing() {
        return this.mIsRefreshing;
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i8;
        super.onAttachedToWindow();
        if (this.mDampingMode == 0 || (i8 = this.mUseScene) == 0) {
            initUpOverScroll();
        } else if (i8 == 1) {
            postDelayed(new b(this, 2), 100L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseResource();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            return;
        }
        View childAt = getChildAt(0);
        this.mLayoutContent = childAt;
        childAt.setNestedScrollingEnabled(false);
        this.mLayoutContent.setVerticalScrollBarEnabled(false);
        if (this.mDampingMode == 0) {
            setFillViewport(true);
            this.mCubicInterpolator = new a(0.25f, 0.0f);
            ViewGroup.LayoutParams layoutParams = this.mLayoutContent.getLayoutParams();
            removeView(this.mLayoutContent);
            View viewInflate = FrameLayout.inflate(getContext(), R$layout.os_damping_layout_title, null);
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.addView(viewInflate, -1, this.mHeightRefreshLayout);
            frameLayout.addView(this.mLayoutContent, -1, -1);
            addView(frameLayout, layoutParams);
            TextView textView = (TextView) findViewById(R$id.damping_text_loading);
            this.mTextRefreshing = textView;
            textView.setScaleX(0.5f);
            TextView textView2 = this.mTextRefreshing;
            textView2.setScaleY(textView2.getScaleX());
            this.mTextRefreshing.setAlpha(0.0f);
            LoadingView loadingView = (LoadingView) findViewById(R$id.loading_view);
            this.mLoadingView = loadingView;
            loadingView.setScaleX(0.2f);
            LoadingView loadingView2 = this.mLoadingView;
            loadingView2.setScaleY(loadingView2.getScaleX());
            this.mLoadingView.setAlpha(0.0f);
            this.mLoadingView.setAutoAnim(false);
        }
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.View
    public void onScrollChanged(int i8, int i9, int i10, int i11) {
        super.onScrollChanged(i8, i9, i10, i11);
        translateScrollBar(i9);
        sendScrollBarFadeMsg();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (!z2) {
            cancelAnim(this.mAnimScrollBarFade);
            return;
        }
        if (this.mAnimScrollBarFade == null) {
            initAnimScrollBarFade();
        }
        View view = this.mViewScrollBar;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        this.mAnimScrollBarFade.setStartDelay(((long) getScrollBarDefaultDelayBeforeFade()) * 4);
        this.mAnimScrollBarFade.start();
    }

    public void setBarWidth(int i8) {
        this.mBarWidth = i8;
    }

    public void setDampingMode(int i8) {
        this.mDampingMode = i8;
    }

    public void setLimitDampingEdge(boolean z2) {
        this.mIsLimitDampingEdge = z2;
    }

    public void setOnRefreshListener(d dVar) {
    }

    public void setTextColor(int i8) {
        TextView textView = this.mTextRefreshing;
        if (textView != null) {
            textView.setTextColor(i8);
        }
    }

    public void setUseScene(int i8) {
        this.mUseScene = i8;
    }

    public DampingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DampingLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mRect = new Rect();
        this.mRunnableFade = new b(this, 1);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DampingLayout, i8, 0);
        this.mDampingMode = typedArrayObtainStyledAttributes.getInt(R$styleable.DampingLayout_os_damping_mode, 0);
        this.mUseScene = typedArrayObtainStyledAttributes.getInt(R$styleable.DampingLayout_os_damping_bar_use_scene, 0);
        this.mBarMarginRight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.DampingLayout_os_damping_bar_margin_right, (int) TypedValue.applyDimension(1, 6.0f, displayMetrics));
        this.mBarMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.DampingLayout_os_damping_bar_margin_top, 0);
        this.mBarWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.DampingLayout_os_damping_bar_width, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        this.mIsLimitDampingEdge = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DampingLayout_os_limit_damping_edge, true);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }
}
