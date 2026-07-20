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
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.WaitAcceptViewModel;
import qd.k;
import sa.d;
import ya.a;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentWaitAcceptBindingImpl extends FragmentWaitAcceptBinding implements a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f2602n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Button f2603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f2604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2605m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2602n = sparseIntArray;
        sparseIntArray.put(R$id.iv_pc_shadow, 4);
        sparseIntArray.put(R$id.iv_pc_item, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FragmentWaitAcceptBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding.IncludedLayouts) null, f2602n);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArrMapBindings[1];
        ImageView imageView = (ImageView) objArrMapBindings[5];
        super(dataBindingComponent, view, constraintLayout, imageView, (ConstraintLayout) objArrMapBindings[0], (TextView) objArrMapBindings[2]);
        this.f2605m = -1L;
        this.f2596a.setTag(null);
        Button button = (Button) objArrMapBindings[3];
        this.f2603k = button;
        button.setTag(null);
        this.f2598c.setTag(null);
        this.f2599d.setTag(null);
        setRootTag(view);
        this.f2604l = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        b bVar = this.f2600h;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentWaitAcceptBinding
    public final void d(b bVar) {
        this.f2600h = bVar;
        synchronized (this) {
            this.f2605m |= 4;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentWaitAcceptBinding
    public final void e(SearchActivityViewModel searchActivityViewModel) {
        this.e = searchActivityViewModel;
        synchronized (this) {
            this.f2605m |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        AnimationSet animationSet;
        synchronized (this) {
            j8 = this.f2605m;
            this.f2605m = 0L;
        }
        WaitAcceptViewModel waitAcceptViewModel = this.f2601i;
        SearchActivityViewModel searchActivityViewModel = this.e;
        int i8 = 0;
        AnimationSet animationSet2 = null;
        if ((43 & j8) != 0) {
            if ((j8 & 41) == 0) {
                animationSet = null;
            } else {
                MutableLiveData mutableLiveData = waitAcceptViewModel != null ? waitAcceptViewModel.f2862d : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    animationSet = (AnimationSet) mutableLiveData.getValue();
                } else {
                    animationSet = null;
                }
            }
            if ((j8 & 42) != 0) {
                MutableLiveData mutableLiveData2 = waitAcceptViewModel != null ? waitAcceptViewModel.f2860b : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    animationSet2 = (AnimationSet) mutableLiveData2.getValue();
                }
            }
        } else {
            animationSet = null;
        }
        long j10 = 48 & j8;
        if (j10 != 0 && searchActivityViewModel != null) {
            i8 = searchActivityViewModel.f2853h;
        }
        if ((42 & j8) != 0) {
            d.j(this.f2596a, animationSet2);
        }
        if (j10 != 0) {
            d.b(i8, this.f2603k);
        }
        if ((32 & j8) != 0) {
            this.f2603k.setOnClickListener(this.f2604l);
        }
        if ((j8 & 41) != 0) {
            d.j(this.f2599d, animationSet);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.FragmentWaitAcceptBinding
    public final void f(WaitAcceptViewModel waitAcceptViewModel) {
        this.f2601i = waitAcceptViewModel;
        synchronized (this) {
            this.f2605m |= 8;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2605m != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2605m = 32L;
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
                this.f2605m |= 1;
            }
            return true;
        }
        if (i8 != 1) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2605m |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (4 == i8) {
            d((b) obj);
        } else if (26 == i8) {
            f((WaitAcceptViewModel) obj);
        } else {
            if (20 != i8) {
                return false;
            }
            e((SearchActivityViewModel) obj);
        }
        return true;
    }
}
