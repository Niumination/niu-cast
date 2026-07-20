package com.transsion.iotservice.multiscreen.pc.ue;

import android.content.Intent;
import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/PCConnectionSettingActivity;", "Lcom/transsion/iotservice/multiscreen/pc/helper/BaseSettingActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class PCConnectionSettingActivity extends BaseSettingActivity {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f2694l = 0;

    @Override // com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity, android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R$id.setting_menu_helper) {
            startActivity(new Intent(this, (Class<?>) PCConnectionHelperActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
