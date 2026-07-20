package com.transsion.connectx.mirror.source.databinding;

import a6.e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import com.transsion.connectx.mirror.source.pad.view.LongButton;
import com.transsion.connectx.mirror.source.pad.view.SquareButton;
import com.transsion.connectx.mirror.source.pad.view.TriangleView;
import java.util.List;
import z4.g;

/* JADX INFO: loaded from: classes2.dex */
public class ItemWindowHelperBindingImpl extends ItemWindowHelperBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts L = null;

    @Nullable
    public static final SparseIntArray M;

    @NonNull
    public final LongButton H;

    @NonNull
    public final LongButton I;

    @NonNull
    public final LongButton J;
    public long K;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final SquareButton f2012i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final LongButton f2013n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final LongButton f2014p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final SquareButton f2015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final SquareButton f2016w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final SquareButton f2017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final View f2018y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2019z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.btn_circle, 12);
        sparseIntArray.put(R.id.window_button, 13);
        sparseIntArray.put(R.id.tr_up, 14);
        sparseIntArray.put(R.id.window_button_content, 15);
        sparseIntArray.put(R.id.tr_down, 16);
    }

    public ItemWindowHelperBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, L, M));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0073  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        long j11;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        int i10;
        g gVar6;
        g gVar7;
        g gVar8;
        g gVar9;
        synchronized (this) {
            j10 = this.K;
            this.K = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f2011g;
        if ((15 & j10) != 0) {
            if ((j10 & 13) == 0) {
                gVar2 = null;
                gVar3 = null;
                gVar7 = null;
                gVar5 = null;
                gVar = null;
                gVar8 = null;
                gVar9 = null;
                gVar4 = null;
                gVar6 = null;
            } else {
                LiveData<List<g>> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2097b : null;
                updateLiveDataRegistration(0, liveData);
                List<g> value = liveData != null ? liveData.getValue() : null;
                if (value != null) {
                    gVar9 = value.get(2);
                    gVar = value.get(7);
                    gVar4 = value.get(1);
                    gVar3 = value.get(6);
                    gVar7 = value.get(5);
                    gVar8 = value.get(4);
                    gVar6 = value.get(0);
                    gVar5 = value.get(3);
                    gVar2 = value.get(8);
                } else {
                    gVar2 = null;
                    gVar3 = null;
                    gVar7 = null;
                    gVar5 = null;
                    gVar = null;
                    gVar8 = null;
                    gVar9 = null;
                    gVar4 = null;
                    gVar6 = null;
                }
            }
            long j12 = j10 & 14;
            if (j12 != 0) {
                LiveData<Boolean> liveData2 = floatingWindowViewModel != null ? floatingWindowViewModel.f2103h : null;
                updateLiveDataRegistration(1, liveData2);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(liveData2 != null ? liveData2.getValue() : null);
                if (j12 != 0) {
                    j10 |= zSafeUnbox ? 32L : 16L;
                }
                i10 = zSafeUnbox ? 0 : 8;
            } else {
                i10 = 0;
            }
            j11 = 13;
        } else {
            j11 = 13;
            gVar = null;
            gVar2 = null;
            gVar3 = null;
            gVar4 = null;
            gVar5 = null;
            i10 = 0;
            gVar6 = null;
            gVar7 = null;
            gVar8 = null;
            gVar9 = null;
        }
        if ((j10 & j11) != 0) {
            e.d(this.f2012i, gVar6);
            e.d(this.f2013n, gVar);
            e.d(this.f2014p, gVar2);
            e.d(this.f2015v, gVar4);
            e.d(this.f2016w, gVar9);
            e.d(this.f2017x, gVar5);
            e.d(this.H, gVar8);
            e.d(this.I, gVar7);
            e.d(this.J, gVar3);
        }
        if ((j10 & 14) != 0) {
            this.f2018y.setVisibility(i10);
            this.f2019z.setVisibility(i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.K != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemWindowHelperBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f2011g = floatingWindowViewModel;
        synchronized (this) {
            this.K |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K = 8L;
        }
        requestRebind();
    }

    public final boolean j(LiveData<List<g>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 1;
        }
        return true;
    }

    public final boolean k(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.K |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return j((LiveData) obj, i11);
        }
        if (i10 != 1) {
            return false;
        }
        return k((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ItemWindowHelperBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[12], (TriangleView) objArr[16], (TriangleView) objArr[14], (ConstraintLayout) objArr[13], (LinearLayout) objArr[15], (ConstraintLayout) objArr[0]);
        this.K = -1L;
        SquareButton squareButton = (SquareButton) objArr[1];
        this.f2012i = squareButton;
        squareButton.setTag(null);
        LongButton longButton = (LongButton) objArr[10];
        this.f2013n = longButton;
        longButton.setTag(null);
        LongButton longButton2 = (LongButton) objArr[11];
        this.f2014p = longButton2;
        longButton2.setTag(null);
        SquareButton squareButton2 = (SquareButton) objArr[2];
        this.f2015v = squareButton2;
        squareButton2.setTag(null);
        SquareButton squareButton3 = (SquareButton) objArr[3];
        this.f2016w = squareButton3;
        squareButton3.setTag(null);
        SquareButton squareButton4 = (SquareButton) objArr[4];
        this.f2017x = squareButton4;
        squareButton4.setTag(null);
        View view2 = (View) objArr[5];
        this.f2018y = view2;
        view2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[6];
        this.f2019z = linearLayout;
        linearLayout.setTag(null);
        LongButton longButton3 = (LongButton) objArr[7];
        this.H = longButton3;
        longButton3.setTag(null);
        LongButton longButton4 = (LongButton) objArr[8];
        this.I = longButton4;
        longButton4.setTag(null);
        LongButton longButton5 = (LongButton) objArr[9];
        this.J = longButton5;
        longButton5.setTag(null);
        this.f2010f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
