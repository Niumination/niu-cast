package com.transsion.iotservice.multiscreen.pc.databinding;

import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import k3.ed;
import sa.d;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutFunctionGuideItemBindingImpl extends LayoutFunctionGuideItemBinding {
    public long e;

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.LayoutFunctionGuideItemBinding
    public final void d(FunctionGuideBean functionGuideBean) {
        this.f2626d = functionGuideBean;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        TextBean functionDescBean;
        VapResource vapResource;
        TextBean functionTitleBean;
        synchronized (this) {
            j8 = this.e;
            this.e = 0L;
        }
        FunctionGuideBean functionGuideBean = this.f2626d;
        long j10 = j8 & 5;
        if (j10 == 0 || functionGuideBean == null) {
            functionDescBean = null;
            vapResource = null;
            functionTitleBean = null;
        } else {
            functionDescBean = functionGuideBean.getFunctionDescBean();
            vapResource = functionGuideBean.getVapResource();
            functionTitleBean = functionGuideBean.getFunctionTitleBean();
        }
        if (j10 != 0) {
            d.g(this.f2623a, vapResource, null, null);
            ed.a(this.f2624b, functionDescBean);
            ed.a(this.f2625c, functionTitleBean);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.e != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (11 == i8) {
            d((FunctionGuideBean) obj);
        } else {
            if (26 != i8) {
                return false;
            }
        }
        return true;
    }
}
