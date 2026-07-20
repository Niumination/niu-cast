package com.transsion.iotservice.multiscreen.pc.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.pb;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pd.d;
import u6.a;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class BaseActivityDialog extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2695a = new a(12, false);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (sb.b()) {
            d.c(this, pb.a());
        }
        super.onCreate(bundle);
        b.a(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setRequestedOrientation((!sb.b() || na.d.a()) ? -1 : 1);
    }
}
