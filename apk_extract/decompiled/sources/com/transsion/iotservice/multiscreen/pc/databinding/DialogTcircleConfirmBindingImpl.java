package com.transsion.iotservice.multiscreen.pc.databinding;

import androidx.databinding.adapters.TextViewBindingAdapter;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmViewModel;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import na.c;

/* JADX INFO: loaded from: classes2.dex */
public class DialogTcircleConfirmBindingImpl extends DialogTcircleConfirmBinding {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2551c;

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.DialogTcircleConfirmBinding
    public final void d(TCircleConfirmViewModel tCircleConfirmViewModel) {
        this.f2550b = tCircleConfirmViewModel;
        synchronized (this) {
            this.f2551c |= 1;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        String string;
        int i8;
        synchronized (this) {
            j8 = this.f2551c;
            this.f2551c = 0L;
        }
        TCircleConfirmViewModel tCircleConfirmViewModel = this.f2550b;
        long j10 = j8 & 3;
        if (j10 == 0 || tCircleConfirmViewModel == null) {
            string = null;
        } else {
            int i9 = tCircleConfirmViewModel.f2760b;
            if (i9 != 2) {
                i8 = (i9 == 3 || i9 != 5) ? R$string.tcircle_confirm_dialog_air_copy : R$string.tcircle_confirm_dialog_mirror;
            } else {
                i8 = R$string.tcircle_confirm_dialog_swift_send;
            }
            string = pb.a().getString(i8, new Object[]{pb.a().getString(StringsKt__StringsKt.contains$default((String) c.f8133a.getValue(), "hios", false, 2, (Object) null) ? R$string.md_t_circle : R$string.md_x_circle)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        if (j10 != 0) {
            TextViewBindingAdapter.setText(this.f2549a, string);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2551c != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2551c = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (26 != i8) {
            return false;
        }
        d((TCircleConfirmViewModel) obj);
        return true;
    }
}
