package com.transsion.iotservice.multiscreen.pc.databinding;

import android.app.NotificationManager;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import bb.v;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import qd.k;
import sb.d;
import sb.e;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityCastControlBindingImpl extends ActivityCastControlBinding implements a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final SparseIntArray f2415s;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f2416o;
    public final k p;
    public final k q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2417r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2415s = sparseIntArray;
        sparseIntArray.put(R$id.os_damping_layout, 6);
        sparseIntArray.put(R$id.vapView, 7);
        sparseIntArray.put(R$id.mirror_button_inner, 8);
        sparseIntArray.put(R$id.phone_phone_mirror, 9);
        sparseIntArray.put(R$id.mirror_button_subtitle, 10);
        sparseIntArray.put(R$id.extend_button_inner, 11);
        sparseIntArray.put(R$id.extend_button_title, 12);
        sparseIntArray.put(R$id.extend_button_subtitle, 13);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityCastControlBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding.IncludedLayouts) null, f2415s);
        AppCompatButton appCompatButton = (AppCompatButton) objArrMapBindings[5];
        FrameLayout frameLayout = (FrameLayout) objArrMapBindings[4];
        LinearLayout linearLayout = (LinearLayout) objArrMapBindings[11];
        FrameLayout frameLayout2 = (FrameLayout) objArrMapBindings[3];
        LinearLayout linearLayout2 = (LinearLayout) objArrMapBindings[8];
        OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) objArrMapBindings[6];
        OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) objArrMapBindings[0];
        TextView textView = (TextView) objArrMapBindings[1];
        super(dataBindingComponent, view, appCompatButton, frameLayout, linearLayout, frameLayout2, linearLayout2, overBoundNestedScrollView, oSScrollbarLayout, textView, (AnimView) objArrMapBindings[2]);
        this.f2417r = -1L;
        this.f2405a.setTag(null);
        this.f2406b.setTag(null);
        this.f2408d.setTag(null);
        this.f2410i.setTag(null);
        this.f2411j.setTag(null);
        this.f2412k.setTag(null);
        setRootTag(view);
        this.f2416o = new k(3, 2, this);
        this.p = new k(2, 2, this);
        this.q = new k(1, 2, this);
        invalidateAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.a
    public final void b(int i8) {
        e eVar;
        CastControlViewModel castControlViewModel = null;
        if (i8 == 1) {
            e eVar2 = this.f2414m;
            if (eVar2 != null) {
                CastControlViewModel castControlViewModel2 = eVar2.f9608a.f2712k;
                if (castControlViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    castControlViewModel = castControlViewModel2;
                }
                Boolean bool = (Boolean) castControlViewModel.f.getValue();
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                Boolean bool2 = (Boolean) castControlViewModel.f2721g.getValue();
                boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
                castControlViewModel.a(true ^ zBooleanValue, (!zBooleanValue2 || zBooleanValue) ? zBooleanValue2 : false);
                Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
                Intrinsics.checkNotNullParameter("onMirrorSwitch", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("CastControlDialog"), "onMirrorSwitch");
                    return;
                }
                return;
            }
            return;
        }
        if (i8 != 2) {
            if (i8 == 3 && (eVar = this.f2414m) != null) {
                CastControlDialog castControlDialog = eVar.f9608a;
                castControlDialog.finish();
                l0.p(castControlDialog.f2711j, null, null, new d(null), 3);
                CastControlViewModel.f2715l = true;
                CastControlViewModel.f2716m = false;
                NotificationManager notificationManager = v.f1256a;
                v.a();
                Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
                Intrinsics.checkNotNullParameter("disconnectDevice", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("CastControlDialog"), "disconnectDevice");
                    return;
                }
                return;
            }
            return;
        }
        e eVar3 = this.f2414m;
        if (eVar3 != null) {
            CastControlViewModel castControlViewModel3 = eVar3.f9608a.f2712k;
            if (castControlViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                castControlViewModel = castControlViewModel3;
            }
            Boolean bool3 = (Boolean) castControlViewModel.f.getValue();
            boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : false;
            Boolean bool4 = (Boolean) castControlViewModel.f2721g.getValue();
            boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : false;
            castControlViewModel.a((!zBooleanValue3 || zBooleanValue4) ? zBooleanValue3 : false, true ^ zBooleanValue4);
            Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
            Intrinsics.checkNotNullParameter("onExtendSwitch", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("CastControlDialog"), "onExtendSwitch");
            }
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityCastControlBinding
    public final void d(e eVar) {
        this.f2414m = eVar;
        synchronized (this) {
            this.f2417r |= 32;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityCastControlBinding
    public final void e(CastControlViewModel castControlViewModel) {
        this.f2413l = castControlViewModel;
        synchronized (this) {
            this.f2417r |= 8;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        String str;
        VapResource vapResource;
        int i8;
        String string;
        synchronized (this) {
            j8 = this.f2417r;
            this.f2417r = 0L;
        }
        CastControlViewModel castControlViewModel = this.f2413l;
        if ((79 & j8) != 0) {
            if ((j8 & 73) == 0) {
                vapResource = null;
            } else {
                MutableLiveData mutableLiveData = castControlViewModel != null ? castControlViewModel.f2725k : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    vapResource = (VapResource) mutableLiveData.getValue();
                } else {
                    vapResource = null;
                }
            }
            if ((j8 & 74) != 0) {
                MutableLiveData mutableLiveData2 = castControlViewModel != null ? castControlViewModel.f2723i : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                string = this.f2411j.getResources().getString(R$string.md_connect_title, mutableLiveData2 != null ? (String) mutableLiveData2.getValue() : null);
            } else {
                string = null;
            }
            long j10 = j8 & 76;
            if (j10 != 0) {
                MutableLiveData mutableLiveData3 = castControlViewModel != null ? castControlViewModel.f2722h : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData3 != null ? (Boolean) mutableLiveData3.getValue() : null);
                if (j10 != 0) {
                    j8 |= zSafeUnbox ? 256L : 128L;
                }
                int i9 = zSafeUnbox ? 0 : 8;
                str = string;
                i8 = i9;
            } else {
                str = string;
            }
            if ((64 & j8) != 0) {
                this.f2405a.setOnClickListener(this.f2416o);
                this.f2406b.setOnClickListener(this.p);
                this.f2408d.setOnClickListener(this.q);
            }
            if ((76 & j8) != 0) {
                this.f2406b.setVisibility(i8);
            }
            if ((j8 & 74) != 0) {
                TextViewBindingAdapter.setText(this.f2411j, str);
            }
            if ((j8 & 73) != 0) {
                sa.d.g(this.f2412k, vapResource, null, Boolean.FALSE);
            }
        }
        str = null;
        vapResource = null;
        i8 = 0;
        if ((64 & j8) != 0) {
            this.f2405a.setOnClickListener(this.f2416o);
            this.f2406b.setOnClickListener(this.p);
            this.f2408d.setOnClickListener(this.q);
        }
        if ((76 & j8) != 0) {
            this.f2406b.setVisibility(i8);
        }
        if ((j8 & 74) != 0) {
            TextViewBindingAdapter.setText(this.f2411j, str);
        }
        if ((j8 & 73) != 0) {
            sa.d.g(this.f2412k, vapResource, null, Boolean.FALSE);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2417r != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2417r = 64L;
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
                this.f2417r |= 1;
            }
            return true;
        }
        if (i8 == 1) {
            if (i9 != 0) {
                return false;
            }
            synchronized (this) {
                this.f2417r |= 2;
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
            this.f2417r |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (12 == i8) {
            e((CastControlViewModel) obj);
        } else if (24 == i8) {
        } else {
            if (3 != i8) {
                return false;
            }
            d((e) obj);
        }
        return true;
    }
}
