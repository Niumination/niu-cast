package com.transsion.iotservice.multiscreen.pc.ui;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.transsion.base.arch.mvvm.DataBindingActivity;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.d;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "Lcom/transsion/base/arch/mvvm/DataBindingActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class BaseActivity extends DataBindingActivity {
    @Override // com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b.b(this, true);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setRequestedOrientation((!sb.b() || d.a()) ? -1 : 1);
        Intrinsics.checkNotNullParameter(this, "<this>");
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullParameter(this, "<this>");
        insetsController.setAppearanceLightNavigationBars(true ^ ((getResources().getConfiguration().uiMode & 48) == 32));
        super.onCreate(bundle);
    }
}
