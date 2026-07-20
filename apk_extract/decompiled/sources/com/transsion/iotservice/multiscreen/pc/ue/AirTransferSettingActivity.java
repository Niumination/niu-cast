package com.transsion.iotservice.multiscreen.pc.ue;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$menu;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsLottieAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAssetList;
import com.transsion.iotservice.multiscreen.pc.bean.SettingItem;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcTransferSettingBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcTransferSettingViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import na.c;
import pb.a;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/AirTransferSettingActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "pb/a", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AirTransferSettingActivity extends BaseActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PcTransferSettingViewModel f2677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedViewModel f2678c;

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_pc_transfer_setting);
        ActivityPcTransferSettingBinding activityPcTransferSettingBinding = (ActivityPcTransferSettingBinding) contentView;
        PcTransferSettingViewModel pcTransferSettingViewModel = this.f2677b;
        SharedViewModel sharedViewModel = null;
        if (pcTransferSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewModel");
            pcTransferSettingViewModel = null;
        }
        activityPcTransferSettingBinding.f(pcTransferSettingViewModel);
        activityPcTransferSettingBinding.e(new a(this));
        SharedViewModel sharedViewModel2 = this.f2678c;
        if (sharedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareVM");
        } else {
            sharedViewModel = sharedViewModel2;
        }
        activityPcTransferSettingBinding.d(new SettingsLottieAdapter(sharedViewModel));
        activityPcTransferSettingBinding.f2489b.setUpOverScroll();
        Intrinsics.checkNotNullExpressionValue(contentView, "apply(...)");
        return contentView;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        u6.a aVar = this.f2329a;
        this.f2678c = (SharedViewModel) aVar.C(this);
        this.f2677b = (PcTransferSettingViewModel) aVar.A(this, PcTransferSettingViewModel.class);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b.e(this);
        PcTransferSettingViewModel pcTransferSettingViewModel = this.f2677b;
        if (pcTransferSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewModel");
            pcTransferSettingViewModel = null;
        }
        boolean zA = c.a();
        pcTransferSettingViewModel.getClass();
        SettingItem settingItem = new SettingItem(LottieAssetList.INSTANCE.getPcTransferSettingLottieData(zA), R$string.module_pc_air_transfer, null, false, 12, null);
        pcTransferSettingViewModel.f2879a.setValue(settingItem);
        l0.p(ViewModelKt.getViewModelScope(pcTransferSettingViewModel), null, null, new ac.b(pcTransferSettingViewModel, settingItem.getData().size(), null), 3);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R$menu.setting_action_bar_menu, menu);
        menu.findItem(R$id.setting_menu_scan).setVisible(false);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R$id.setting_menu_helper) {
            startActivity(new Intent(this, (Class<?>) PCConnectionHelperActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
