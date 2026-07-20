package com.transsion.connectx.mirror.source.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.FloatingWindowViewModel;
import com.transsion.connectx.mirror.source.pad.view.TriangleView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ItemExtendTipBindingImpl extends ItemExtendTipBinding {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f1988g = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f1989i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f1990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1991f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1989i = sparseIntArray;
        sparseIntArray.put(R.id.tr_up, 2);
        sparseIntArray.put(R.id.window_button_content, 3);
    }

    public ItemExtendTipBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f1988g, f1989i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f1991f;
            this.f1991f = 0L;
        }
        FloatingWindowViewModel floatingWindowViewModel = this.f1987d;
        long j11 = j10 & 7;
        String str = null;
        if (j11 != 0) {
            LiveData<List<String>> liveData = floatingWindowViewModel != null ? floatingWindowViewModel.f2099d : null;
            updateLiveDataRegistration(0, liveData);
            List<String> value = liveData != null ? liveData.getValue() : null;
            if (value != null) {
                str = value.get(3);
            }
        }
        if (j11 != 0) {
            TextViewBindingAdapter.setText(this.f1990e, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f1991f != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.transsion.connectx.mirror.source.databinding.ItemExtendTipBinding
    public void i(@Nullable FloatingWindowViewModel floatingWindowViewModel) {
        this.f1987d = floatingWindowViewModel;
        synchronized (this) {
            this.f1991f |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1991f = 4L;
        }
        requestRebind();
    }

    public final boolean j(LiveData<List<String>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f1991f |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return j((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 != i10) {
            return false;
        }
        i((FloatingWindowViewModel) obj);
        return true;
    }

    public ItemExtendTipBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[0], (TriangleView) objArr[2], (LinearLayout) objArr[3]);
        this.f1991f = -1L;
        this.f1984a.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f1990e = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
