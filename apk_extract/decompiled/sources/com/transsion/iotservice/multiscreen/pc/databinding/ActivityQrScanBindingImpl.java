package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import kotlin.jvm.internal.Intrinsics;
import qd.k;
import wb.d;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityQrScanBindingImpl extends ActivityQrScanBinding implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final SparseIntArray f2501m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f2502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f2503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2504l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2501m = sparseIntArray;
        sparseIntArray.put(R$id.previewView, 4);
        sparseIntArray.put(R$id.tv_qr_scan, 5);
        sparseIntArray.put(R$id.sv_qr_scan_background, 6);
        sparseIntArray.put(R$id.iv_qr_scan_line, 7);
        sparseIntArray.put(R$id.iv_qr_scan_frame, 8);
        sparseIntArray.put(R$id.tv_qr_scan_matter_tips, 9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityQrScanBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding.IncludedLayouts) null, f2501m);
        ImageView imageView = (ImageView) objArrMapBindings[1];
        ImageView imageView2 = (ImageView) objArrMapBindings[3];
        ImageView imageView3 = (ImageView) objArrMapBindings[7];
        PreviewView previewView = (PreviewView) objArrMapBindings[4];
        super(dataBindingComponent, view, imageView, imageView2, imageView3, previewView, (TextView) objArrMapBindings[2]);
        this.f2504l = -1L;
        this.f2495a.setTag(null);
        this.f2496b.setTag(null);
        ((ConstraintLayout) objArrMapBindings[0]).setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        this.f2502j = new k(1, 2, this);
        this.f2503k = new k(2, 2, this);
        invalidateAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.a
    public final void b(int i8) {
        d dVar;
        CameraInfo cameraInfo;
        Camera camera;
        CameraControl cameraControl;
        if (i8 == 1) {
            d dVar2 = this.f2499h;
            if (dVar2 != null) {
                dVar2.f10706a.finish();
                return;
            }
            return;
        }
        if (i8 == 2 && (dVar = this.f2499h) != null) {
            QrScanViewModel qrScanViewModel = dVar.f10706a.f2805b;
            if (qrScanViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQrScanViewModel");
                qrScanViewModel = null;
            }
            MutableLiveData mutableLiveData = qrScanViewModel.f2808c;
            Boolean bool = (Boolean) mutableLiveData.getValue();
            mutableLiveData.setValue(Boolean.valueOf(!(bool != null ? bool.booleanValue() : false)));
            Camera camera2 = qrScanViewModel.f2809d;
            if (camera2 == null || (cameraInfo = camera2.getCameraInfo()) == null || !cameraInfo.hasFlashUnit() || (camera = qrScanViewModel.f2809d) == null || (cameraControl = camera.getCameraControl()) == null) {
                return;
            }
            Boolean bool2 = (Boolean) mutableLiveData.getValue();
            cameraControl.enableTorch(bool2 != null ? bool2.booleanValue() : false);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityQrScanBinding
    public final void d(d dVar) {
        this.f2499h = dVar;
        synchronized (this) {
            this.f2504l |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.databinding.ActivityQrScanBinding
    public final void e(QrScanViewModel qrScanViewModel) {
        this.f2500i = qrScanViewModel;
        synchronized (this) {
            this.f2504l |= 4;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        boolean z2;
        int iIntValue;
        MutableLiveData mutableLiveData;
        int iIntValue2;
        synchronized (this) {
            j8 = this.f2504l;
            this.f2504l = 0L;
        }
        QrScanViewModel qrScanViewModel = this.f2500i;
        long j10 = 13 & j8;
        String str = null;
        int i8 = 0;
        if (j10 != 0) {
            if (qrScanViewModel != null) {
                iIntValue = ((Number) qrScanViewModel.f2807b.getValue()).intValue();
                iIntValue2 = ((Number) qrScanViewModel.f2806a.getValue()).intValue();
                mutableLiveData = qrScanViewModel.f2808c;
            } else {
                mutableLiveData = null;
                iIntValue = 0;
                iIntValue2 = 0;
            }
            updateLiveDataRegistration(0, mutableLiveData);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? (Boolean) mutableLiveData.getValue() : null);
            if ((j8 & 12) != 0 && qrScanViewModel != null) {
                str = (String) qrScanViewModel.f2814k.getValue();
            }
            z2 = zSafeUnbox;
            i8 = iIntValue2;
        } else {
            z2 = false;
            iIntValue = 0;
        }
        if ((8 & j8) != 0) {
            this.f2495a.setOnClickListener(this.f2502j);
            this.f2496b.setOnClickListener(this.f2503k);
        }
        if (j10 != 0) {
            ImageView view = this.f2496b;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!z2) {
                i8 = iIntValue;
            }
            view.setImageResource(i8);
        }
        if ((j8 & 12) != 0) {
            TextViewBindingAdapter.setText(this.e, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2504l != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2504l = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        if (i8 != 0) {
            return false;
        }
        if (i9 != 0) {
            return false;
        }
        synchronized (this) {
            this.f2504l |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (4 == i8) {
            d((d) obj);
        } else {
            if (29 != i8) {
                return false;
            }
            e((QrScanViewModel) obj);
        }
        return true;
    }
}
