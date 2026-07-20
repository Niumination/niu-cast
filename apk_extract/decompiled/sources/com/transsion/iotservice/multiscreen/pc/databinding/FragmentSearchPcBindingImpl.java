package com.transsion.iotservice.multiscreen.pc.databinding;

import ag.d0;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import cj.d;
import com.airbnb.lottie.LottieAnimationView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapRecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.adapter.SearchPcItemAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchFragmentViewModel;
import dc.c;
import java.util.List;
import k3.ed;
import k3.pb;
import k3.wb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import va.e;
import yb.b;
import yb.f;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentSearchPcBindingImpl extends FragmentSearchPcBinding {
    public long p;

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void d(SearchPcItemAdapter searchPcItemAdapter) {
        this.f2590j = searchPcItemAdapter;
        synchronized (this) {
            this.p |= 512;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void e(f fVar) {
        this.f2594n = fVar;
        synchronized (this) {
            this.p |= 64;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x024c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0257  */
    /* JADX WARN: Code duplicated, block: B:113:0x0285  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:64:0x00de  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:71:0x0103  */
    /* JADX WARN: Code duplicated, block: B:77:0x0157 A[PHI: r32 r33
      0x0157: PHI (r32v3 com.transsion.iotservice.multiscreen.pc.bean.SearchPageText) = 
      (r32v2 com.transsion.iotservice.multiscreen.pc.bean.SearchPageText)
      (r32v6 com.transsion.iotservice.multiscreen.pc.bean.SearchPageText)
     binds: [B:79:0x015e, B:76:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x0157: PHI (r33v3 yb.f) = (r33v2 yb.f), (r33v6 yb.f) binds: [B:79:0x015e, B:76:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0161  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:94:0x0220  */
    /* JADX WARN: Code duplicated, block: B:97:0x022f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0236  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        Boolean bool;
        List list;
        String str;
        LottieAsset lottieAsset;
        SearchPageText searchPageText;
        VapResource vapResource;
        SearchPageText searchPageText2;
        f fVar;
        int i8;
        TextView textView;
        GravitySnapRecyclerView recyclerView;
        LottieAnimationView view;
        final d dVar;
        List list2;
        GravitySnapRecyclerView view2;
        final d dVar2;
        synchronized (this) {
            j8 = this.p;
            this.p = 0L;
        }
        SharedViewModel sharedViewModel = this.f2591k;
        f fVar2 = this.f2594n;
        DeviceViewModel deviceViewModel = this.f2589i;
        b bVar = this.f2593m;
        SearchPcItemAdapter searchPcItemAdapter = this.f2590j;
        SearchFragmentViewModel searchFragmentViewModel = this.f2592l;
        if ((3117 & j8) == 0) {
            bool = null;
        } else {
            MutableLiveData mutableLiveData = sharedViewModel != null ? sharedViewModel.f2701b : null;
            updateLiveDataRegistration(3, mutableLiveData);
            if (mutableLiveData != null) {
                bool = (Boolean) mutableLiveData.getValue();
            } else {
                bool = null;
            }
        }
        int i9 = ((j8 & 3138) > 0L ? 1 : ((j8 & 3138) == 0L ? 0 : -1));
        long j10 = j8 & 2704;
        if (j10 == 0) {
            list = null;
        } else {
            MutableLiveData mutableLiveData2 = deviceViewModel != null ? deviceViewModel.f2846m : null;
            updateLiveDataRegistration(4, mutableLiveData2);
            if (mutableLiveData2 != null) {
                list = (List) mutableLiveData2.getValue();
            } else {
                list = null;
            }
        }
        long j11 = j8 & 2304;
        if ((j8 & 3183) != 0) {
            if ((j8 & 3113) == 0) {
                lottieAsset = null;
            } else {
                MutableLiveData mutableLiveData3 = searchFragmentViewModel != null ? searchFragmentViewModel.f2855b : null;
                updateLiveDataRegistration(0, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    lottieAsset = (LottieAsset) mutableLiveData3.getValue();
                } else {
                    lottieAsset = null;
                }
            }
            str = ((j8 & 3072) == 0 || searchFragmentViewModel == null) ? null : (String) searchFragmentViewModel.f2858g.getValue();
            if (i9 == 0) {
                searchPageText = null;
            } else {
                MutableLiveData mutableLiveData4 = searchFragmentViewModel != null ? searchFragmentViewModel.f : null;
                updateLiveDataRegistration(1, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    searchPageText = (SearchPageText) mutableLiveData4.getValue();
                } else {
                    searchPageText = null;
                }
            }
            if ((j8 & 3116) != 0) {
                MutableLiveData mutableLiveData5 = searchFragmentViewModel != null ? searchFragmentViewModel.f2857d : null;
                updateLiveDataRegistration(2, mutableLiveData5);
                vapResource = mutableLiveData5 != null ? (VapResource) mutableLiveData5.getValue() : null;
            }
            if ((j8 & 3116) != 0) {
                sa.d.g(this.f2584a, vapResource, bool, null);
            }
            if ((2192 & j8) != 0) {
                view = this.f2585b;
                Intrinsics.checkNotNullParameter(view, "view");
                view.clearAnimation();
                dVar = ed.f6431a;
                if (dVar != null) {
                    final int i10 = 0;
                    view.removeCallbacks(new Runnable() { // from class: sa.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case 0:
                                    dVar.invoke();
                                    break;
                                default:
                                    dVar.invoke();
                                    break;
                            }
                        }
                    });
                }
                list2 = list;
                i8 = i9;
                if (list2 != null || list2.isEmpty()) {
                    searchPageText2 = searchPageText;
                    fVar = fVar2;
                    if (view.getVisibility() != 0) {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -wb.a(30.0f), 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        i8 = i8;
                        c cVar = new c(0.2f, 0.1f);
                        final int i11 = 1;
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setDuration(450L);
                        animationSet.setFillAfter(true);
                        animationSet.setInterpolator(cVar);
                        final d dVar3 = new d(4, view, animationSet);
                        ed.f6431a = dVar3;
                        view.postOnAnimationDelayed(new Runnable() { // from class: sa.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i11) {
                                    case 0:
                                        dVar3.invoke();
                                        break;
                                    default:
                                        dVar3.invoke();
                                        break;
                                }
                            }
                        }, 330L);
                    }
                    view2 = this.f2587d;
                    Intrinsics.checkNotNullParameter(view2, "view");
                    dVar2 = ed.f6432b;
                    if (dVar2 != null) {
                        final int i12 = 0;
                        view2.removeCallbacks(new Runnable() { // from class: sa.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i12) {
                                    case 0:
                                        dVar2.invoke();
                                        break;
                                    default:
                                        dVar2.invoke();
                                        break;
                                }
                            }
                        });
                    }
                    if (list2 != null || list2.isEmpty()) {
                        view2.setVisibility(4);
                    } else if (view2.getVisibility() != 0) {
                        view2.clearAnimation();
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, wb.a(13.0f), 0.0f);
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                        final int i13 = 1;
                        AnimationSet animationSet2 = new AnimationSet(true);
                        animationSet2.addAnimation(translateAnimation2);
                        animationSet2.addAnimation(alphaAnimation2);
                        animationSet2.setDuration(330L);
                        animationSet2.setFillAfter(true);
                        animationSet2.setInterpolator(new c(0.2f, 0.1f));
                        final d dVar4 = new d(3, view2, animationSet2);
                        ed.f6432b = dVar4;
                        view2.postOnAnimationDelayed(new Runnable() { // from class: sa.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i13) {
                                    case 0:
                                        dVar4.invoke();
                                        break;
                                    default:
                                        dVar4.invoke();
                                        break;
                                }
                            }
                        }, 450L);
                    }
                } else {
                    if (view.getVisibility() == 4) {
                        searchPageText2 = searchPageText;
                        fVar = fVar2;
                    } else {
                        view.setVisibility(4);
                        searchPageText2 = searchPageText;
                        TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -wb.a(30.0f));
                        fVar = fVar2;
                        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                        AnimationSet animationSet3 = new AnimationSet(true);
                        animationSet3.addAnimation(translateAnimation3);
                        animationSet3.addAnimation(alphaAnimation3);
                        animationSet3.setDuration(450L);
                        animationSet3.setFillAfter(true);
                        animationSet3.setInterpolator(new c(0.33f, 0.67f));
                        view.startAnimation(animationSet3);
                    }
                    view2 = this.f2587d;
                    Intrinsics.checkNotNullParameter(view2, "view");
                    dVar2 = ed.f6432b;
                    if (dVar2 != null) {
                        final int i14 = 0;
                        view2.removeCallbacks(new Runnable() { // from class: sa.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i14) {
                                    case 0:
                                        dVar2.invoke();
                                        break;
                                    default:
                                        dVar2.invoke();
                                        break;
                                }
                            }
                        });
                    }
                    if (list2 != null) {
                        view2.setVisibility(4);
                    } else {
                        view2.setVisibility(4);
                    }
                }
                view2 = this.f2587d;
                Intrinsics.checkNotNullParameter(view2, "view");
                dVar2 = ed.f6432b;
                if (dVar2 != null) {
                    final int i15 = 0;
                    view2.removeCallbacks(new Runnable() { // from class: sa.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i15) {
                                case 0:
                                    dVar2.invoke();
                                    break;
                                default:
                                    dVar2.invoke();
                                    break;
                            }
                        }
                    });
                }
                if (list2 != null) {
                    view2.setVisibility(4);
                } else {
                    view2.setVisibility(4);
                }
            } else {
                searchPageText2 = searchPageText;
                fVar = fVar2;
                list = list;
                i8 = i9;
            }
            if ((j8 & 3113) != 0) {
                sa.d.a(this.f2585b, lottieAsset, bool);
            }
            if (j10 != 0) {
                recyclerView = this.f2587d;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (recyclerView.getAdapter() == null && searchPcItemAdapter != null) {
                    recyclerView.setAdapter(searchPcItemAdapter);
                    Unit unit = Unit.INSTANCE;
                }
                if (searchPcItemAdapter != null) {
                    searchPcItemAdapter.submitList(list);
                }
            }
            if ((j8 & 3072) != 0) {
                TextViewBindingAdapter.setText(this.e, str);
            }
            if (j11 != 0 && (textView = this.e) != null) {
                String string = textView.getText().toString();
                String string2 = pb.a().getString(R$string.pc_module_qrscan_connect);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                e.b(textView, string, string2, new d0(bVar, 29));
            }
            if (i8 != 0) {
                ed.b(this.f2588h, searchPageText2, fVar);
            }
        }
        str = null;
        lottieAsset = null;
        searchPageText = null;
        if ((j8 & 3116) != 0) {
            sa.d.g(this.f2584a, vapResource, bool, null);
        }
        if ((2192 & j8) != 0) {
            view = this.f2585b;
            Intrinsics.checkNotNullParameter(view, "view");
            view.clearAnimation();
            dVar = ed.f6431a;
            if (dVar != null) {
                final int i16 = 0;
                view.removeCallbacks(new Runnable() { // from class: sa.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i16) {
                            case 0:
                                dVar.invoke();
                                break;
                            default:
                                dVar.invoke();
                                break;
                        }
                    }
                });
            }
            list2 = list;
            i8 = i9;
            if (list2 != null) {
                searchPageText2 = searchPageText;
                fVar = fVar2;
                if (view.getVisibility() != 0) {
                    TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, -wb.a(30.0f), 0.0f);
                    AlphaAnimation alphaAnimation4 = new AlphaAnimation(0.0f, 1.0f);
                    i8 = i8;
                    c cVar2 = new c(0.2f, 0.1f);
                    final int i17 = 1;
                    AnimationSet animationSet4 = new AnimationSet(true);
                    animationSet4.addAnimation(translateAnimation4);
                    animationSet4.addAnimation(alphaAnimation4);
                    animationSet4.setDuration(450L);
                    animationSet4.setFillAfter(true);
                    animationSet4.setInterpolator(cVar2);
                    final d dVar5 = new d(4, view, animationSet4);
                    ed.f6431a = dVar5;
                    view.postOnAnimationDelayed(new Runnable() { // from class: sa.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i17) {
                                case 0:
                                    dVar5.invoke();
                                    break;
                                default:
                                    dVar5.invoke();
                                    break;
                            }
                        }
                    }, 330L);
                }
            } else {
                searchPageText2 = searchPageText;
                fVar = fVar2;
                if (view.getVisibility() != 0) {
                    TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, 0.0f, -wb.a(30.0f), 0.0f);
                    AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 1.0f);
                    i8 = i8;
                    c cVar3 = new c(0.2f, 0.1f);
                    final int i18 = 1;
                    AnimationSet animationSet5 = new AnimationSet(true);
                    animationSet5.addAnimation(translateAnimation5);
                    animationSet5.addAnimation(alphaAnimation5);
                    animationSet5.setDuration(450L);
                    animationSet5.setFillAfter(true);
                    animationSet5.setInterpolator(cVar3);
                    final d dVar6 = new d(4, view, animationSet5);
                    ed.f6431a = dVar6;
                    view.postOnAnimationDelayed(new Runnable() { // from class: sa.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i18) {
                                case 0:
                                    dVar6.invoke();
                                    break;
                                default:
                                    dVar6.invoke();
                                    break;
                            }
                        }
                    }, 330L);
                }
            }
            view2 = this.f2587d;
            Intrinsics.checkNotNullParameter(view2, "view");
            dVar2 = ed.f6432b;
            if (dVar2 != null) {
                final int i19 = 0;
                view2.removeCallbacks(new Runnable() { // from class: sa.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i19) {
                            case 0:
                                dVar2.invoke();
                                break;
                            default:
                                dVar2.invoke();
                                break;
                        }
                    }
                });
            }
            if (list2 != null) {
                view2.setVisibility(4);
            } else {
                view2.setVisibility(4);
            }
        } else {
            searchPageText2 = searchPageText;
            fVar = fVar2;
            list = list;
            i8 = i9;
        }
        if ((j8 & 3113) != 0) {
            sa.d.a(this.f2585b, lottieAsset, bool);
        }
        if (j10 != 0) {
            recyclerView = this.f2587d;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(searchPcItemAdapter);
                Unit unit2 = Unit.INSTANCE;
            }
            if (searchPcItemAdapter != null) {
                searchPcItemAdapter.submitList(list);
            }
        }
        if ((j8 & 3072) != 0) {
            TextViewBindingAdapter.setText(this.e, str);
        }
        if (j11 != 0) {
            String string3 = textView.getText().toString();
            String string4 = pb.a().getString(R$string.pc_module_qrscan_connect);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            e.b(textView, string3, string4, new d0(bVar, 29));
        }
        if (i8 != 0) {
            ed.b(this.f2588h, searchPageText2, fVar);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void f(b bVar) {
        this.f2593m = bVar;
        synchronized (this) {
            this.p |= 256;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void g(DeviceViewModel deviceViewModel) {
        this.f2589i = deviceViewModel;
        synchronized (this) {
            this.p |= 128;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void h(SearchFragmentViewModel searchFragmentViewModel) {
        this.f2592l = searchFragmentViewModel;
        synchronized (this) {
            this.p |= 1024;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.p != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding
    public final void i(SharedViewModel sharedViewModel) {
        this.f2591k = sharedViewModel;
        synchronized (this) {
            this.p |= 32;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.p = 2048L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 == 0) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.p |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.p |= 2;
            }
            return true;
        }
        if (i8 == 2) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.p |= 4;
            }
            return true;
        }
        if (i8 == 3) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.p |= 8;
            }
            return true;
        }
        if (i8 != 4) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (22 == i8) {
            i((SharedViewModel) obj);
            return true;
        }
        if (4 == i8) {
            e((f) obj);
            return true;
        }
        if (8 == i8) {
            g((DeviceViewModel) obj);
            return true;
        }
        if (5 == i8) {
            f((b) obj);
            return true;
        }
        if (1 == i8) {
            d((SearchPcItemAdapter) obj);
            return true;
        }
        if (20 != i8) {
            return false;
        }
        h((SearchFragmentViewModel) obj);
        return true;
    }
}
