package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import com.transsion.widgetPerGuide.perguide.PerGuideAdapter;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.d;
import qd.k;
import vb.c;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class DialogPadExtendPermissionGuideBindingImpl extends DialogPadExtendPermissionGuideBinding implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final SparseIntArray f2522m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f2523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f2524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2525l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2522m = sparseIntArray;
        sparseIntArray.put(R$id.scroll_view, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DialogPadExtendPermissionGuideBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding.IncludedLayouts) null, f2522m);
        Button button = (Button) objArrMapBindings[3];
        Button button2 = (Button) objArrMapBindings[4];
        TextView textView = (TextView) objArrMapBindings[1];
        RecyclerView recyclerView = (RecyclerView) objArrMapBindings[2];
        super(dataBindingComponent, view, button, button2, textView, recyclerView);
        this.f2525l = -1L;
        this.f2516a.setTag(null);
        this.f2517b.setTag(null);
        this.f2518c.setTag(null);
        ((ConstraintLayout) objArrMapBindings[0]).setTag(null);
        this.f2519d.setTag(null);
        setRootTag(view);
        this.f2523j = new k(1, 2, this);
        this.f2524k = new k(2, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        c cVar;
        if (i8 != 1) {
            if (i8 == 2 && (cVar = this.f2520h) != null) {
                cVar.a();
                return;
            }
            return;
        }
        c cVar2 = this.f2520h;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        String strQ;
        synchronized (this) {
            j8 = this.f2525l;
            this.f2525l = 0L;
        }
        PerGuideAdapter perGuideAdapter = this.f2521i;
        PermissionViewModel permissionViewModel = this.e;
        long j10 = 10 & j8;
        long j11 = 12 & j8;
        if (j11 == 0 || permissionViewModel == null) {
            strQ = null;
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = pb.a().getString(R$string.pad_extend_permission_intro);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            strQ = d.q(new Object[]{pb.a().getString(R$string.module_pc_expand_screen_title)}, 1, string, "format(...)");
        }
        if ((j8 & 8) != 0) {
            this.f2516a.setOnClickListener(this.f2523j);
            this.f2517b.setOnClickListener(this.f2524k);
        }
        if (j11 != 0) {
            TextViewBindingAdapter.setText(this.f2518c, strQ);
        }
        if (j10 != 0) {
            RecyclerView recyclerView = this.f2519d;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getAdapter() != null || perGuideAdapter == null) {
                return;
            }
            recyclerView.setAdapter(perGuideAdapter);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2525l != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2525l = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (3 == i8) {
            this.f2520h = (c) obj;
            synchronized (this) {
                this.f2525l |= 1;
            }
            notifyPropertyChanged(3);
            super.requestRebind();
            return true;
        }
        if (1 == i8) {
            this.f2521i = (PerGuideAdapter) obj;
            synchronized (this) {
                this.f2525l |= 2;
            }
            notifyPropertyChanged(1);
            super.requestRebind();
            return true;
        }
        if (26 != i8) {
            return false;
        }
        this.e = (PermissionViewModel) obj;
        synchronized (this) {
            this.f2525l |= 4;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
        return true;
    }
}
