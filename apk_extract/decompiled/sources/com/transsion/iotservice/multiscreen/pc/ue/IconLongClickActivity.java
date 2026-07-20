package com.transsion.iotservice.multiscreen.pc.ue;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import eb.y0;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ue/IconLongClickActivity;", "Landroid/app/Activity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IconLongClickActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (((ComponentName) getIntent().getParcelableExtra("android.intent.extra.COMPONENT_NAME")) != null) {
                if (!DeviceConnectState.INSTANCE.isConnected()) {
                    y0.b("IconLongClickActivity");
                }
                int i8 = PCConnectionSettingActivity.f2694l;
                Intrinsics.checkNotNullParameter(this, "context");
                Intrinsics.checkNotNullParameter("shortcut_center", "entry");
                Intent intent = new Intent(this, (Class<?>) PCConnectionSettingActivity.class);
                intent.setFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                intent.putExtra("intent_track_entry_setting", "shortcut_center");
                intent.putExtra("ParallelUniverse", false);
                startActivity(intent);
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("IconLongClickActivity", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("IconLongClickActivity"), e.getMessage(), e);
        }
        finish();
    }
}
