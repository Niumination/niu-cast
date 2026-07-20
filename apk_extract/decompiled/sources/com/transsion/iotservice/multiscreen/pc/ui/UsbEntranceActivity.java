package com.transsion.iotservice.multiscreen.pc.ui;

import ag.a;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import bf.u;
import k3.gc;
import k3.o1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ob.b;
import se.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/UsbEntranceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UsbEntranceActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2702a = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Byte bValueOf = intent != null ? Byte.valueOf(intent.getByteExtra("clickEntrance", (byte) -1)) : null;
        String log = "UsbEntranceActivity clickEntrance:" + bValueOf;
        Intrinsics.checkNotNullParameter("UsbEntranceActivity", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("UsbEntranceActivity"), log);
        }
        b.f8417b.f8437a.n();
        if (bValueOf == null || bValueOf.byteValue() != 0) {
            finish();
            return;
        }
        a aVar = new a(this, 9);
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new u(7, aVar, this));
        if (h.m(this, activityResultLauncherRegisterForActivityResult, 0)) {
            return;
        }
        o1.d(this, activityResultLauncherRegisterForActivityResult, aVar);
    }
}
