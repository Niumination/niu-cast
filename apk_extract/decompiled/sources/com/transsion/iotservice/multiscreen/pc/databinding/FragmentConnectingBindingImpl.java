package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.ConnectingViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import qd.k;
import sa.d;
import ya.a;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentConnectingBindingImpl extends FragmentConnectingBinding implements a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final SparseIntArray f2569s;
    public final k p;
    public final k q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2570r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2569s = sparseIntArray;
        sparseIntArray.put(R$id.iv_pc_shadow, 8);
        sparseIntArray.put(R$id.iv_pc_item, 9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FragmentConnectingBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding.IncludedLayouts) null, f2569s);
        TextView textView = (TextView) objArrMapBindings[7];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArrMapBindings[1];
        ImageView imageView = (ImageView) objArrMapBindings[9];
        super(dataBindingComponent, view, textView, constraintLayout, imageView, (LottieAnimationView) objArrMapBindings[2], (ConstraintLayout) objArrMapBindings[0], (Button) objArrMapBindings[6], (Button) objArrMapBindings[5], (TextView) objArrMapBindings[3], (ConstraintLayout) objArrMapBindings[4]);
        this.f2570r = -1L;
        this.f2558a.setTag(null);
        this.f2559b.setTag(null);
        this.f2561d.setTag(null);
        this.e.setTag(null);
        this.f2562h.setTag(null);
        this.f2563i.setTag(null);
        this.f2564j.setTag(null);
        this.f2565k.setTag(null);
        setRootTag(view);
        this.p = new k(2, 2, this);
        this.q = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        b bVar;
        if (i8 != 1) {
            if (i8 == 2 && (bVar = this.f2567m) != null) {
                bVar.b();
                return;
            }
            return;
        }
        b bVar2 = this.f2567m;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentConnectingBinding
    public final void d(b bVar) {
        this.f2567m = bVar;
        synchronized (this) {
            this.f2570r |= 16;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentConnectingBinding
    public final void e(SearchActivityViewModel searchActivityViewModel) {
        this.f2566l = searchActivityViewModel;
        synchronized (this) {
            this.f2570r |= 64;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        LottieAsset lottieAsset;
        AnimationSet animationSet;
        AnimationSet animationSet2;
        int i8;
        int i9;
        synchronized (this) {
            j8 = this.f2570r;
            this.f2570r = 0L;
        }
        ConnectingViewModel connectingViewModel = this.f2568n;
        SearchActivityViewModel searchActivityViewModel = this.f2566l;
        if ((175 & j8) != 0) {
            if ((j8 & 161) == 0) {
                animationSet = null;
            } else {
                MutableLiveData mutableLiveData = connectingViewModel != null ? connectingViewModel.f2831b : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    animationSet = (AnimationSet) mutableLiveData.getValue();
                } else {
                    animationSet = null;
                }
            }
            long j10 = j8 & 162;
            if (j10 != 0) {
                MutableLiveData mutableLiveData2 = connectingViewModel != null ? connectingViewModel.f : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? (Boolean) mutableLiveData2.getValue() : null);
                if (j10 != 0) {
                    j8 |= zSafeUnbox ? 2560L : 1280L;
                }
                i8 = 8;
                i9 = zSafeUnbox ? 8 : 0;
                if (zSafeUnbox) {
                    i8 = 0;
                }
            } else {
                i8 = 0;
                i9 = 0;
            }
            if ((j8 & 164) == 0) {
                animationSet2 = null;
            } else {
                MutableLiveData mutableLiveData3 = connectingViewModel != null ? connectingViewModel.f2833d : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    animationSet2 = (AnimationSet) mutableLiveData3.getValue();
                } else {
                    animationSet2 = null;
                }
            }
            if ((j8 & 168) == 0) {
                lottieAsset = null;
            } else {
                MutableLiveData mutableLiveData4 = connectingViewModel != null ? connectingViewModel.f2835h : null;
                updateLiveDataRegistration(3, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    lottieAsset = (LottieAsset) mutableLiveData4.getValue();
                } else {
                    lottieAsset = null;
                }
            }
        } else {
            lottieAsset = null;
            animationSet = null;
            animationSet2 = null;
            i8 = 0;
            i9 = 0;
        }
        long j11 = j8 & 192;
        int i10 = (j11 == 0 || searchActivityViewModel == null) ? 0 : searchActivityViewModel.f2853h;
        if ((162 & j8) != 0) {
            this.f2558a.setVisibility(i9);
            this.f2564j.setVisibility(i8);
        }
        if ((164 & j8) != 0) {
            d.j(this.f2559b, animationSet2);
            d.j(this.f2561d, animationSet2);
            d.j(this.f2564j, animationSet2);
        }
        if ((168 & j8) != 0) {
            d.a(this.f2561d, lottieAsset, null);
        }
        if ((128 & j8) != 0) {
            this.f2562h.setOnClickListener(this.p);
            this.f2563i.setOnClickListener(this.q);
        }
        if ((j8 & 161) != 0) {
            d.j(this.f2565k, animationSet);
        }
        if (j11 != 0) {
            d.b(i10, this.f2565k);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentConnectingBinding
    public final void f(ConnectingViewModel connectingViewModel) {
        this.f2568n = connectingViewModel;
        synchronized (this) {
            this.f2570r |= 32;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2570r != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2570r = 128L;
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
                this.f2570r |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2570r |= 2;
            }
            return true;
        }
        if (i8 == 2) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2570r |= 4;
            }
            return true;
        }
        if (i8 != 3) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2570r |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (4 == i8) {
            d((b) obj);
        } else if (26 == i8) {
            f((ConnectingViewModel) obj);
        } else {
            if (20 != i8) {
                return false;
            }
            e((SearchActivityViewModel) obj);
        }
        return true;
    }
}
