package com.transsion.widgetsliquid.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import hd.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import k3.z8;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSLiquidSearchAnimManager {
    private static final float LIQUID_SEARCH_DAMPING = 0.99f;
    private static final float LIQUID_SEARCH_STIFFNESS = 300.0f;
    public static final int POLICY_GO = 2;
    public static final int POLICY_NOSEARCH_SEARCH = 1;
    public static final int POLICY_SEARCH_SEARCH = 0;
    private static final String TAG = "OSLiquidSearchAnimManager";
    public static final int TRANS_Y_DEFAULT = 50;
    public static final int TYPE_ACTIVITY = 0;
    public static final int TYPE_VIEW = 1;
    private static OSLiquidSearchAnimManager sInstance;
    private WeakReference<List<SpringAnimation>> mAnimatorSet;
    private WeakReference<ViewGroup> mFirstPageRootViewWR;
    private WeakReference<OSLiquidSearchBar> mFirstPageSearchBarWR;
    private boolean mIsInSearch;
    private int mPolicy;
    private WeakReference<View>[] mSecondPageAlphaViewWR;
    private boolean mSecondPageReCreate;
    private WeakReference<View> mSecondPageRootViewWR;
    private WeakReference<OSLiquidSearchBar> mSecondPageSearchBarWR;
    private float mScale = 1.0f;
    private float mOffset = 0.0f;
    int totalAnimation = 0;
    AtomicInteger animationsCompleted = new AtomicInteger(0);

    public interface CallBack {
        void onAnimationEnd();
    }

    public static class ExitEndInternalListener implements DynamicAnimation.OnAnimationEndListener {
        private CallBack callBack;
        private final AtomicInteger countPending;
        private final int countTotal;
        private final WeakReference<OSLiquidSearchAnimManager> searchAnimManagerWeakReference;

        public ExitEndInternalListener(AtomicInteger atomicInteger, int i8, CallBack callBack, OSLiquidSearchAnimManager oSLiquidSearchAnimManager) {
            this.countPending = atomicInteger;
            this.countTotal = i8;
            this.callBack = callBack;
            this.searchAnimManagerWeakReference = new WeakReference<>(oSLiquidSearchAnimManager);
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
            OSLiquidSearchAnimManager oSLiquidSearchAnimManager = this.searchAnimManagerWeakReference.get();
            if (oSLiquidSearchAnimManager != null) {
                this.countPending.incrementAndGet();
                if (this.countPending.get() == this.countTotal) {
                    oSLiquidSearchAnimManager.initSearchBar();
                    this.countPending.set(0);
                    CallBack callBack = this.callBack;
                    if (callBack != null) {
                        callBack.onAnimationEnd();
                    }
                    this.callBack = null;
                }
            }
        }
    }

    public static class ExitSearchInternalListener implements DynamicAnimation.OnAnimationEndListener {
        private final WeakReference<Object> mHostViewWR;
        private final WeakReference<OSLiquidSearchBar> mSearchBarSecondWR;
        private final WeakReference<OSLiquidSearchBar> mSearchBarWR;

        public ExitSearchInternalListener(Object obj, OSLiquidSearchBar oSLiquidSearchBar, OSLiquidSearchBar oSLiquidSearchBar2) {
            this.mHostViewWR = new WeakReference<>(obj);
            this.mSearchBarWR = new WeakReference<>(oSLiquidSearchBar);
            this.mSearchBarSecondWR = new WeakReference<>(oSLiquidSearchBar2);
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
            if (this.mHostViewWR.get() != null) {
                OSLiquidSearchBar oSLiquidSearchBar = this.mSearchBarWR.get();
                if (oSLiquidSearchBar != null) {
                    oSLiquidSearchBar.setVisibility(0);
                }
                OSLiquidSearchBar oSLiquidSearchBar2 = this.mSearchBarSecondWR.get();
                if (oSLiquidSearchBar2 != null) {
                    oSLiquidSearchBar2.setVisibility(4);
                    oSLiquidSearchBar2.requireSearchAnimManagerTrans(false);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Policy {
    }

    public static class TranslationAnimatorUpdateListener implements DynamicAnimation.OnAnimationUpdateListener {
        private final int mFlag;
        private final WeakReference<View> mHostViewWR;
        private final int mTransY;

        public TranslationAnimatorUpdateListener(@NonNull View view, int i8, int i9) {
            this.mHostViewWR = new WeakReference<>(view);
            this.mFlag = i8;
            this.mTransY = i9;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
            if (this.mHostViewWR.get() != null) {
                View view = this.mHostViewWR.get();
                int i8 = this.mFlag;
                if (i8 == 0) {
                    view.setTranslationY(this.mTransY - f);
                    return;
                }
                if (i8 == 1) {
                    view.setTranslationY(-f);
                } else if (i8 == 2) {
                    view.setTranslationY(f);
                } else if (i8 == 3) {
                    view.setTranslationY(f - this.mTransY);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private OSLiquidSearchAnimManager() {
    }

    private void calculateScaleAndOffset(@NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull OSLiquidSearchBar oSLiquidSearchBar2) {
        if (oSLiquidSearchBar2.getMeasuredWidth() != oSLiquidSearchBar.getMeasuredWidth()) {
            this.mScale = (oSLiquidSearchBar2.getMeasuredWidth() * 1.0f) / oSLiquidSearchBar.getMeasuredWidth();
            this.mOffset = (oSLiquidSearchBar2.getMeasuredWidth() - oSLiquidSearchBar.getMeasuredWidth()) / 2.0f;
            oSLiquidSearchBar.requireSearchAnimManagerTrans(true);
        } else {
            setScaleAndOffset(1.0f, 0.0f);
        }
        z8.f(TAG, "calculateScaleAndOffset: mScale = " + this.mScale + " mOffset = " + this.mOffset);
    }

    private List<SpringAnimation> enterSearchForPolicy() {
        OSLiquidSearchBar oSLiquidSearchBar = (OSLiquidSearchBar) getWRObject(this.mFirstPageSearchBarWR);
        OSLiquidSearchBar oSLiquidSearchBar2 = (OSLiquidSearchBar) getWRObject(this.mSecondPageSearchBarWR);
        SpringAnimation springAnimationStartSearchForTransition = null;
        if (this.mPolicy == 0) {
            if (oSLiquidSearchBar == null || oSLiquidSearchBar2 == null) {
                z8.c(null, "object recycled", null);
                return null;
            }
        } else if (oSLiquidSearchBar2 == null) {
            z8.c(null, "object recycled", null);
            return null;
        }
        Context context = oSLiquidSearchBar2.getContext();
        String[] strArr = j.f8764a;
        int iA = a.a(context, 50);
        z8.b(TAG, "enterSearchForPolicyA: transY = " + iA);
        View view = (View) getWRObject(this.mSecondPageRootViewWR);
        if (view != null) {
            view.setTranslationY(iA);
        }
        SpringAnimation springAnimationGenerateEnterSecondPageSpringAnimation = generateEnterSecondPageSpringAnimation(iA);
        springAnimationGenerateEnterSecondPageSpringAnimation.addUpdateListener(new TranslationAnimatorUpdateListener(view, 0, iA));
        SpringAnimation springAnimationGenerateAlphaSpringAnimation = generateAlphaSpringAnimation(100.0f);
        springAnimationGenerateAlphaSpringAnimation.setStartValue(0.0f);
        springAnimationGenerateAlphaSpringAnimation.addUpdateListener(new AlphaAnimatorUpdateListener(this.mSecondPageAlphaViewWR, true));
        SpringAnimation springAnimationGenerateEnterFirstPageSpringAnimation = generateEnterFirstPageSpringAnimation(iA);
        springAnimationGenerateEnterFirstPageSpringAnimation.addUpdateListener(new TranslationAnimatorUpdateListener(this.mFirstPageRootViewWR.get(), 1, iA));
        initPageAlphaView();
        if (this.mPolicy == 0) {
            calculateScaleAndOffset(oSLiquidSearchBar, oSLiquidSearchBar2);
            springAnimationStartSearchForTransition = oSLiquidSearchBar2.startSearchForTransition(this.mScale, this.mOffset);
        }
        springAnimationGenerateEnterSecondPageSpringAnimation.start();
        springAnimationGenerateEnterFirstPageSpringAnimation.start();
        springAnimationGenerateAlphaSpringAnimation.start();
        ArrayList arrayList = new ArrayList();
        arrayList.add(springAnimationGenerateEnterSecondPageSpringAnimation);
        arrayList.add(springAnimationGenerateEnterFirstPageSpringAnimation);
        arrayList.add(springAnimationGenerateAlphaSpringAnimation);
        if (this.mPolicy == 0) {
            arrayList.add(springAnimationStartSearchForTransition);
        }
        return arrayList;
    }

    private SpringAnimation generateAlphaSpringAnimation(float f) {
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce(f);
        springForce.setDampingRatio(LIQUID_SEARCH_DAMPING);
        springForce.setStiffness(300.0f);
        springAnimation.setSpring(springForce);
        return springAnimation;
    }

    private SpringAnimation generateEnterFirstPageSpringAnimation(int i8) {
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce(i8);
        springForce.setDampingRatio(LIQUID_SEARCH_DAMPING);
        springForce.setStiffness(300.0f);
        springAnimation.setSpring(springForce);
        return springAnimation;
    }

    private SpringAnimation generateEnterSecondPageSpringAnimation(int i8) {
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
        SpringForce springForce = new SpringForce(i8);
        springForce.setDampingRatio(LIQUID_SEARCH_DAMPING);
        springForce.setStiffness(300.0f);
        springAnimation.setSpring(springForce);
        return springAnimation;
    }

    public static OSLiquidSearchAnimManager getInstance() {
        if (sInstance == null) {
            sInstance = new OSLiquidSearchAnimManager();
        }
        return sInstance;
    }

    private <T> T getWRObject(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void initPageAlphaView() {
        OSLiquidSearchBar oSLiquidSearchBar;
        View view;
        for (WeakReference<View> weakReference : this.mSecondPageAlphaViewWR) {
            if (weakReference != null && (view = weakReference.get()) != null) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
            }
        }
        if (this.mPolicy != 0 || (oSLiquidSearchBar = (OSLiquidSearchBar) getWRObject(this.mFirstPageSearchBarWR)) == null) {
            return;
        }
        oSLiquidSearchBar.setAlpha(0.0f);
        OSLiquidSearchBar oSLiquidSearchBar2 = (OSLiquidSearchBar) getWRObject(this.mSecondPageSearchBarWR);
        if (oSLiquidSearchBar2 != null) {
            oSLiquidSearchBar2.setAlpha(1.0f);
            oSLiquidSearchBar2.copyScale(oSLiquidSearchBar);
        }
    }

    private void initSecondPageStatus() {
        z8.f(TAG, "initSecondPageStatus: getSecondPageReCreate() = " + getSecondPageReCreate());
        WeakReference<View> weakReference = this.mSecondPageRootViewWR;
        View view = weakReference != null ? weakReference.get() : null;
        if (!getSecondPageReCreate()) {
            if (view != null) {
                view.setAlpha(0.0f);
            }
            OSLiquidSearchBar oSLiquidSearchBar = (OSLiquidSearchBar) getWRObject(this.mSecondPageSearchBarWR);
            if (oSLiquidSearchBar != null) {
                oSLiquidSearchBar.setAlpha(0.0f);
                return;
            }
            return;
        }
        if (view != null) {
            view.setAlpha(1.0f);
        }
        OSLiquidSearchBar oSLiquidSearchBar2 = (OSLiquidSearchBar) getWRObject(this.mSecondPageSearchBarWR);
        if (oSLiquidSearchBar2 != null) {
            oSLiquidSearchBar2.setSearchBarState(-1, 1, false, Boolean.FALSE);
        }
        OSLiquidSearchBar oSLiquidSearchBar3 = (OSLiquidSearchBar) getWRObject(this.mFirstPageSearchBarWR);
        if (oSLiquidSearchBar3 != null) {
            oSLiquidSearchBar3.setAlpha(0.0f);
        }
    }

    private WeakReference<View>[] wrapperAlphaViews(View[] viewArr) {
        if (viewArr == null || viewArr.length == 0) {
            return new WeakReference[0];
        }
        WeakReference<View>[] weakReferenceArr = new WeakReference[viewArr.length];
        for (int i8 = 0; i8 < viewArr.length; i8++) {
            weakReferenceArr[i8] = new WeakReference<>(viewArr[i8]);
        }
        return weakReferenceArr;
    }

    public List<SpringAnimation> enterSearch() {
        z8.f(TAG, "enterSearch: getSecondPageReCreate() = " + getSecondPageReCreate());
        if (getSecondPageReCreate()) {
            setSecondPageReCreate(false);
            return null;
        }
        this.mIsInSearch = true;
        WeakReference<List<SpringAnimation>> weakReference = new WeakReference<>(enterSearchForPolicy());
        this.mAnimatorSet = weakReference;
        return weakReference.get();
    }

    public List<SpringAnimation> exitSearch(CallBack callBack) {
        if (!this.mIsInSearch || isEnterAnimRunning()) {
            return null;
        }
        this.mIsInSearch = false;
        List<SpringAnimation> listExitSearchPolicyA = exitSearchPolicyA();
        if (listExitSearchPolicyA != null) {
            this.totalAnimation = listExitSearchPolicyA.size();
            Iterator<SpringAnimation> it = listExitSearchPolicyA.iterator();
            while (it.hasNext()) {
                it.next().addEndListener(new ExitEndInternalListener(this.animationsCompleted, this.totalAnimation, callBack, sInstance));
            }
        }
        return listExitSearchPolicyA;
    }

    public List<SpringAnimation> exitSearchPolicyA() {
        OSLiquidSearchBar oSLiquidSearchBar = (OSLiquidSearchBar) getWRObject(this.mFirstPageSearchBarWR);
        OSLiquidSearchBar oSLiquidSearchBar2 = (OSLiquidSearchBar) getWRObject(this.mSecondPageSearchBarWR);
        SpringAnimation springAnimationEndSearchForTransition = null;
        if (this.mPolicy == 0) {
            if (oSLiquidSearchBar == null || oSLiquidSearchBar2 == null) {
                z8.c(null, "object recycled", null);
                return null;
            }
        } else if (oSLiquidSearchBar2 == null) {
            z8.c(null, "object recycled", null);
            return null;
        }
        Context context = oSLiquidSearchBar2.getContext();
        String[] strArr = j.f8764a;
        int iA = a.a(context, 50);
        SpringAnimation springAnimationGenerateEnterSecondPageSpringAnimation = generateEnterSecondPageSpringAnimation(iA);
        springAnimationGenerateEnterSecondPageSpringAnimation.addUpdateListener(new TranslationAnimatorUpdateListener(this.mSecondPageRootViewWR.get(), 2, iA));
        SpringAnimation springAnimationGenerateAlphaSpringAnimation = generateAlphaSpringAnimation(0.0f);
        springAnimationGenerateAlphaSpringAnimation.setStartValue(100.0f);
        springAnimationGenerateAlphaSpringAnimation.addUpdateListener(new AlphaAnimatorUpdateListener(this.mSecondPageAlphaViewWR, false));
        SpringAnimation springAnimationGenerateEnterFirstPageSpringAnimation = generateEnterFirstPageSpringAnimation(iA);
        springAnimationGenerateEnterFirstPageSpringAnimation.addUpdateListener(new TranslationAnimatorUpdateListener(this.mFirstPageRootViewWR.get(), 3, iA));
        if (this.mPolicy == 0) {
            calculateScaleAndOffset(oSLiquidSearchBar, oSLiquidSearchBar2);
            springAnimationEndSearchForTransition = oSLiquidSearchBar2.endSearchForTransition(this.mScale, this.mOffset);
        }
        springAnimationGenerateAlphaSpringAnimation.start();
        springAnimationGenerateEnterSecondPageSpringAnimation.start();
        springAnimationGenerateEnterFirstPageSpringAnimation.start();
        ArrayList arrayList = new ArrayList();
        arrayList.add(springAnimationGenerateEnterSecondPageSpringAnimation);
        arrayList.add(springAnimationGenerateEnterFirstPageSpringAnimation);
        if (this.mPolicy == 0) {
            arrayList.add(springAnimationEndSearchForTransition);
        }
        return arrayList;
    }

    public int getActionPolicy() {
        return this.mPolicy;
    }

    public String getActionPolicyString(int i8) {
        if (i8 != 1) {
            return i8 != 2 ? h0.a.g(i8, " : policy_search_search") : h0.a.g(i8, " : policy_go");
        }
        return h0.a.g(i8, " : policy_nosearch_search");
    }

    public float getOffset() {
        return this.mOffset;
    }

    public float getScale() {
        return this.mScale;
    }

    public boolean getSecondPageReCreate() {
        return this.mSecondPageReCreate;
    }

    public void initSearchBar() {
        View view = (View) getWRObject(this.mSecondPageSearchBarWR);
        if (view != null) {
            view.setAlpha(0.0f);
            view.invalidate();
        }
        View view2 = (View) getWRObject(this.mFirstPageSearchBarWR);
        if (view2 != null) {
            view2.setAlpha(1.0f);
            view2.invalidate();
        }
    }

    public boolean isEnterAnimRunning() {
        List<SpringAnimation> list;
        WeakReference<List<SpringAnimation>> weakReference = this.mAnimatorSet;
        if (weakReference == null || (list = weakReference.get()) == null) {
            return false;
        }
        for (SpringAnimation springAnimation : list) {
            if (springAnimation != null && springAnimation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInSearch() {
        return this.mIsInSearch;
    }

    public void reset() {
        sInstance = null;
    }

    public void resetFirstPageStatus() {
        OSLiquidSearchBar oSLiquidSearchBar;
        ViewGroup viewGroup;
        WeakReference<ViewGroup> weakReference = this.mFirstPageRootViewWR;
        if (weakReference != null && (viewGroup = weakReference.get()) != null && viewGroup.getTranslationY() != 0.0f) {
            viewGroup.setTranslationY(0.0f);
        }
        WeakReference<OSLiquidSearchBar> weakReference2 = this.mFirstPageSearchBarWR;
        if (weakReference2 == null || (oSLiquidSearchBar = weakReference2.get()) == null) {
            return;
        }
        oSLiquidSearchBar.setAlpha(1.0f);
    }

    public void setActionPolicy(int i8) {
        this.mPolicy = i8;
    }

    public void setFirstPageSearchViews(@NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull ViewGroup viewGroup) {
        this.mFirstPageSearchBarWR = new WeakReference<>(oSLiquidSearchBar);
        this.mFirstPageRootViewWR = new WeakReference<>(viewGroup);
    }

    public void setScaleAndOffset(float f, float f4) {
        this.mScale = f;
        this.mOffset = f4;
    }

    public void setSecondPageReCreate(boolean z2) {
        this.mSecondPageReCreate = z2;
    }

    public void setSecondPageSearchViews(Bundle bundle, @NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull View view, View... viewArr) {
        setSecondPageReCreate(bundle != null);
        setSecondPageSearchViews(oSLiquidSearchBar, view, viewArr);
    }

    public static class AlphaAnimatorUpdateListener implements DynamicAnimation.OnAnimationUpdateListener {
        private WeakReference<View> mHostViewWR;
        private WeakReference<View>[] mHostViewWRS;
        private boolean mShowIn;

        public AlphaAnimatorUpdateListener(View view, boolean z2) {
            this.mHostViewWR = new WeakReference<>(view);
            this.mShowIn = z2;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
            View view;
            View view2;
            float f10 = f / 100.0f;
            float f11 = 1.0f;
            if (!this.mShowIn) {
                f11 = f10 > 0.8f ? 1.0f - ((1.0f - f10) * 5.0f) : 0.0f;
            } else if (f10 < 0.2f) {
                f11 = f10 * 5.0f;
            }
            WeakReference<View> weakReference = this.mHostViewWR;
            if (weakReference != null && (view2 = weakReference.get()) != null) {
                view2.setAlpha(f11);
            }
            WeakReference<View>[] weakReferenceArr = this.mHostViewWRS;
            if (weakReferenceArr != null) {
                for (WeakReference<View> weakReference2 : weakReferenceArr) {
                    if (weakReference2 != null && (view = weakReference2.get()) != null) {
                        view.setAlpha(f11);
                    }
                }
            }
        }

        public AlphaAnimatorUpdateListener(WeakReference<View>[] weakReferenceArr, boolean z2) {
            this.mHostViewWRS = weakReferenceArr;
            this.mShowIn = z2;
        }
    }

    public void setFirstPageSearchViews(@NonNull ViewGroup viewGroup) {
        this.mFirstPageRootViewWR = new WeakReference<>(viewGroup);
    }

    public void setSecondPageSearchViews(@NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull View view, View... viewArr) {
        this.mSecondPageRootViewWR = new WeakReference<>(view);
        View[] viewArr2 = (View[]) Arrays.copyOf(viewArr, viewArr.length + 1);
        viewArr2[viewArr.length] = view;
        this.mSecondPageAlphaViewWR = wrapperAlphaViews(viewArr2);
        this.mSecondPageSearchBarWR = new WeakReference<>(oSLiquidSearchBar);
        initSecondPageStatus();
    }

    public void setSecondPageSearchViews(Bundle bundle, @NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull View view) {
        setSecondPageReCreate(bundle != null);
        setSecondPageSearchViews(oSLiquidSearchBar, view);
    }

    public void setSecondPageSearchViews(@NonNull OSLiquidSearchBar oSLiquidSearchBar, @NonNull View view) {
        this.mSecondPageRootViewWR = new WeakReference<>(view);
        this.mSecondPageAlphaViewWR = wrapperAlphaViews(new View[]{view});
        this.mSecondPageSearchBarWR = new WeakReference<>(oSLiquidSearchBar);
        initSecondPageStatus();
    }
}
