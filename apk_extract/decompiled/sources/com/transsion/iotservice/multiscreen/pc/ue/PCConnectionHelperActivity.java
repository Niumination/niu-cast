package com.transsion.iotservice.multiscreen.pc.ue;

import ag.d0;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import h0.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pb.b;
import va.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/PCConnectionHelperActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PCConnectionHelperActivity extends BaseActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f2689i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f2690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f2691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f2692d;
    public b e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f2693h;

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.module_pc_activity_helper);
        ModulePcActivityHelperBinding modulePcActivityHelperBinding = (ModulePcActivityHelperBinding) contentView;
        this.f2690b = new b(CollectionsKt.listOf(Integer.valueOf(R$string.module_pc_connect)), R$string.module_pc_helper_pc_client, R$string.module_pc_helper_pc_client_desc, R$drawable.module_pc_help_client);
        this.f2691c = new b(R$string.module_pc_helper_scan_connect, R$string.module_pc_helper_scan_connect_desc, R$drawable.module_pc_help_scan_connect);
        this.f2692d = new b(R$string.module_pc_helper_qr_connect, R$string.module_pc_helper_qr_connect_desc, R$drawable.module_pc_help_qr_connect);
        this.e = new b(R$string.module_pc_helper_nfc_connect, R$string.module_pc_helper_nfc_connect_desc, R$drawable.module_pc_help_nfc_connect);
        this.f2693h = new b(R$string.module_pc_helper_usb_connect, R$string.module_pc_helper_usb_connect_desc, R$drawable.module_pc_help_usb_connect);
        modulePcActivityHelperBinding.f2640h.setUpOverScroll();
        b bVar = this.e;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNfcConnectItem");
            bVar = null;
        }
        modulePcActivityHelperBinding.d(bVar);
        b bVar3 = this.f2690b;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPcConnectItem");
            bVar3 = null;
        }
        modulePcActivityHelperBinding.e(bVar3);
        b bVar4 = this.f2692d;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrConnectItem");
            bVar4 = null;
        }
        modulePcActivityHelperBinding.f(bVar4);
        b bVar5 = this.f2691c;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScanConnectItem");
            bVar5 = null;
        }
        modulePcActivityHelperBinding.g(bVar5);
        b bVar6 = this.f2693h;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsbConnectItem");
        } else {
            bVar2 = bVar6;
        }
        modulePcActivityHelperBinding.h(bVar2);
        TextView pcClientHelperDes = modulePcActivityHelperBinding.f2638c;
        Intrinsics.checkNotNullExpressionValue(pcClientHelperDes, "pcClientHelperDes");
        String strB = a.B(getString(R$string.module_pc_helper_pc_client_download, new Object[]{getString(R$string.module_pc_get_our_pc_connect_www)}), " ");
        String string = getString(R$string.module_pc_get_our_pc_connect_www);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        e.b(pcClientHelperDes, strB, string, new d0(this, 23));
        Intrinsics.checkNotNullExpressionValue(contentView, "apply(...)");
        return contentView;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        va.b.e(this);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
