package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionViewModel;
import k3.pb;
import k3.sb;
import o.d;
import qd.k;
import vb.c;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class DialogPermissionGuideBindingImpl extends DialogPermissionGuideBinding implements a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final SparseIntArray f2545o;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f2546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f2547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2548n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2545o = sparseIntArray;
        sparseIntArray.put(R$id.scroll_view, 7);
        sparseIntArray.put(R$id.permission_include, 8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DialogPermissionGuideBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding.IncludedLayouts) null, f2545o);
        Button button = (Button) objArrMapBindings[5];
        Button button2 = (Button) objArrMapBindings[6];
        TextView textView = (TextView) objArrMapBindings[1];
        TextView textView2 = (TextView) objArrMapBindings[4];
        TextView textView3 = (TextView) objArrMapBindings[3];
        TextView textView4 = (TextView) objArrMapBindings[2];
        super(dataBindingComponent, view, button, button2, textView, textView2, textView3, textView4);
        this.f2548n = -1L;
        this.f2538a.setTag(null);
        this.f2539b.setTag(null);
        this.f2540c.setTag(null);
        ((ConstraintLayout) objArrMapBindings[0]).setTag(null);
        this.f2541d.setTag(null);
        this.e.setTag(null);
        this.f2542h.setTag(null);
        setRootTag(view);
        this.f2546l = new k(2, 2, this);
        this.f2547m = new k(1, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        c cVar;
        if (i8 != 1) {
            if (i8 == 2 && (cVar = this.f2544j) != null) {
                cVar.a();
                return;
            }
            return;
        }
        c cVar2 = this.f2544j;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogPermissionGuideBinding
    public final void d(c cVar) {
        this.f2544j = cVar;
        synchronized (this) {
            this.f2548n |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogPermissionGuideBinding
    public final void e(PermissionViewModel permissionViewModel) {
        this.f2543i = permissionViewModel;
        synchronized (this) {
            this.f2548n |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        int iA;
        String strN;
        int iA2;
        int iA3;
        synchronized (this) {
            j8 = this.f2548n;
            this.f2548n = 0L;
        }
        PermissionViewModel permissionViewModel = this.f2543i;
        long j10 = 6 & j8;
        if (j10 == 0 || permissionViewModel == null) {
            iA = 0;
            strN = null;
            iA2 = 0;
            iA3 = 0;
        } else {
            iA = permissionViewModel.a(R$string.permission_guide_title, R$string.pad_phone_screen_mirror_permission_title);
            iA2 = permissionViewModel.a(R$string.permission_guide_desc, R$string.pad_phone_screen_mirror_permission_des);
            iA3 = permissionViewModel.a(R$string.mirror_screen_permission, R$string.pad_phone_screen_mirror_function_desc);
            Integer num = (Integer) permissionViewModel.f.getValue();
            if (num == null || num.intValue() != 1) {
                String string = pb.a().getString(R$string.permission_nearby);
                String string2 = pb.a().getString(R$string.permission_notifications);
                String string3 = pb.a().getString(R$string.permission_camera);
                String string4 = pb.a().getString(R$string.permission_photos_and_videos);
                String string5 = pb.a().getString(R$string.permission_microphone);
                String string6 = pb.a().getString(R$string.permission_storage);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(", ");
                sb2.append(string2);
                sb2.append(", ");
                sb2.append(string3);
                d.A(sb2, ", ", string4, ", ", string5);
                strN = h0.a.n(sb2, ", ", string6);
            } else if (sb.b()) {
                strN = pb.a().getString(R$string.permission_nearby) + ", " + pb.a().getString(R$string.permission_notifications) + ", " + pb.a().getString(R$string.permission_microphone);
            } else {
                strN = d.l(pb.a().getString(R$string.permission_nearby), ", ", pb.a().getString(R$string.permission_microphone));
            }
        }
        if ((j8 & 4) != 0) {
            this.f2538a.setOnClickListener(this.f2547m);
            this.f2539b.setOnClickListener(this.f2546l);
        }
        if (j10 != 0) {
            this.f2540c.setText(iA3);
            TextViewBindingAdapter.setText(this.f2541d, strN);
            this.e.setText(iA2);
            this.f2542h.setText(iA);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2548n != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2548n = 4L;
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
            d((c) obj);
        } else {
            if (26 != i8) {
                return false;
            }
            e((PermissionViewModel) obj);
        }
        return true;
    }
}
