package com.transsion.iotservice.multiscreen.pc.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmDialog;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import ob.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/GestureHandleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class GestureHandleActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2816a;

    public final int j() {
        int intExtra = getIntent().getIntExtra("INTENT_FROM_PATH", 1);
        String action = getIntent().getAction();
        if (Intrinsics.areEqual(action, "com.transsion.wls.intent.action.EXTEND_SCREEN_AIR_TRANSFER")) {
            return 2;
        }
        if (Intrinsics.areEqual(action, "com.transsion.wls.intent.action.EXTEND_SCREEN_AIR_COPY")) {
            return 3;
        }
        return intExtra;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter("GestureHandleActivity", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("GestureHandleActivity"), "onCreate");
        }
        if (DeviceConnectState.INSTANCE.isConnected()) {
            Intrinsics.checkNotNullParameter("GestureHandleActivity", "tag");
            Intrinsics.checkNotNullParameter("isConnected send file", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("GestureHandleActivity"), "isConnected send file");
            }
            int iJ = j();
            String strM = d.m("dealAlreadyConnectTransferEvent: from=", "GestureHandleActivity", "tag", "log", iJ);
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GestureHandleActivity"), strM);
            }
            Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
            intent.putExtras(getIntent());
            intent.putExtra("INTENT_FROM_PATH", iJ);
            intent.setFlags(268435456);
            startActivity(intent);
        } else {
            int iJ2 = j();
            c onConnect = new c(25);
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNullParameter(this, "context");
            Intrinsics.checkNotNullParameter(onConnect, "onConnect");
            Intent intent2 = new Intent(this, (Class<?>) TCircleConfirmDialog.class);
            intent2.putExtras(getIntent());
            if (extras != null) {
                intent2.putExtras(extras);
            }
            intent2.putExtra("gestureType", iJ2);
            intent2.setFlags(268435456);
            startActivity(intent2);
            Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
            Intrinsics.checkNotNullParameter("TCircle confirm dialog shown", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("TCircleConfirmDialog"), "TCircle confirm dialog shown");
            }
            TCircleConfirmDialog.f2756d = onConnect;
        }
        finishAndRemoveTask();
    }
}
