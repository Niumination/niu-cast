package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.adapter.FunctionGuideAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideViewModel;
import com.transsion.widgetsliquid.view.OSLiquidBigButton;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sa.d;
import ub.b;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityFunctionGuideBindingImpl extends ActivityFunctionGuideBinding {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SparseIntArray f2435l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2436k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2435l = sparseIntArray;
        sparseIntArray.put(R$id.scroll_view, 3);
        sparseIntArray.put(R$id.indicator, 4);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding
    public final void d(b bVar) {
        this.f2434i = bVar;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding
    public final void e(FunctionGuideViewModel functionGuideViewModel) {
        this.f2432d = functionGuideViewModel;
        synchronized (this) {
            this.f2436k |= 64;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x0098  */
    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        List list;
        Integer num;
        Integer num2;
        OSLiquidBigButton view;
        List list2;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        synchronized (this) {
            j8 = this.f2436k;
            this.f2436k = 0L;
        }
        FunctionGuideAdapter functionGuideAdapter = this.e;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f2433h;
        FunctionGuideViewModel functionGuideViewModel = this.f2432d;
        long j10 = 205 & j8;
        long j11 = 160 & j8;
        if ((207 & j8) != 0) {
            if (j10 != 0) {
                if (functionGuideViewModel != null) {
                    mutableLiveData2 = functionGuideViewModel.e;
                    mutableLiveData3 = functionGuideViewModel.f2782c;
                } else {
                    mutableLiveData2 = null;
                    mutableLiveData3 = null;
                }
                updateLiveDataRegistration(0, mutableLiveData2);
                updateLiveDataRegistration(2, mutableLiveData3);
                num = mutableLiveData2 != null ? (Integer) mutableLiveData2.getValue() : null;
                list2 = mutableLiveData3 != null ? (List) mutableLiveData3.getValue() : null;
                if ((j8 & 194) != 0) {
                    if (functionGuideViewModel != null) {
                        mutableLiveData = functionGuideViewModel.f2786i;
                    } else {
                        mutableLiveData = null;
                    }
                    updateLiveDataRegistration(1, mutableLiveData);
                    if (mutableLiveData != null) {
                        List list3 = list2;
                        num2 = (Integer) mutableLiveData.getValue();
                        list = list3;
                    }
                    if ((194 & j8) != 0) {
                        view = this.f2429a;
                        Intrinsics.checkNotNullParameter(view, "view");
                        if (num2 != null) {
                            view.getOsBigButton().setText(num2.intValue());
                        }
                    }
                    if ((j8 & 128) != 0) {
                        this.f2430b.setOffscreenPageLimit(1);
                    }
                    if (j11 != 0) {
                        this.f2430b.registerOnPageChangeCallback(onPageChangeCallback);
                    }
                    if (j10 != 0) {
                        d.h(this.f2430b, functionGuideAdapter, list, this.f2431c, num);
                    }
                }
                list = list2;
            } else {
                num = null;
            }
            if ((j8 & 194) != 0) {
                if (functionGuideViewModel != null) {
                    mutableLiveData = functionGuideViewModel.f2786i;
                } else {
                    mutableLiveData = null;
                }
                updateLiveDataRegistration(1, mutableLiveData);
                if (mutableLiveData != null) {
                    List list4 = list2;
                    num2 = (Integer) mutableLiveData.getValue();
                    list = list4;
                }
                if ((194 & j8) != 0) {
                    view = this.f2429a;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (num2 != null) {
                        view.getOsBigButton().setText(num2.intValue());
                    }
                }
                if ((j8 & 128) != 0) {
                    this.f2430b.setOffscreenPageLimit(1);
                }
                if (j11 != 0) {
                    this.f2430b.registerOnPageChangeCallback(onPageChangeCallback);
                }
                if (j10 != 0) {
                    d.h(this.f2430b, functionGuideAdapter, list, this.f2431c, num);
                }
            }
            list = list2;
        } else {
            list = null;
            num = null;
        }
        num2 = null;
        if ((194 & j8) != 0) {
            view = this.f2429a;
            Intrinsics.checkNotNullParameter(view, "view");
            if (num2 != null) {
                view.getOsBigButton().setText(num2.intValue());
            }
        }
        if ((j8 & 128) != 0) {
            this.f2430b.setOffscreenPageLimit(1);
        }
        if (j11 != 0) {
            this.f2430b.registerOnPageChangeCallback(onPageChangeCallback);
        }
        if (j10 != 0) {
            d.h(this.f2430b, functionGuideAdapter, list, this.f2431c, num);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding
    public final void f(FunctionGuideAdapter functionGuideAdapter) {
        this.e = functionGuideAdapter;
        synchronized (this) {
            this.f2436k |= 8;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding
    public final void g(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f2433h = onPageChangeCallback;
        synchronized (this) {
            this.f2436k |= 32;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2436k != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2436k = 128L;
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
                this.f2436k |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2436k |= 2;
            }
            return true;
        }
        if (i8 != 2) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2436k |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (27 == i8) {
            f((FunctionGuideAdapter) obj);
        } else if (4 == i8) {
            this.f2434i = (b) obj;
        } else if (28 == i8) {
            g((ViewPager2.OnPageChangeCallback) obj);
        } else {
            if (26 != i8) {
                return false;
            }
            e((FunctionGuideViewModel) obj);
        }
        return true;
    }
}
