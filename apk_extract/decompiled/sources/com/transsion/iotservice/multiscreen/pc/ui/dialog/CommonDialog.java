package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import ag.b;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CommonDialog;
import kotlin.Metadata;
import ld.k;
import ld.m;
import ld.n;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/CommonDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CommonDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f2728c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2729d = "";
    public static String e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f2730h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f2731i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f2732b;

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k kVar = new k(this);
        String str = f2728c;
        n nVar = kVar.f7400b;
        nVar.f7403b = str;
        nVar.f7405d = f2729d;
        nVar.f7409j = false;
        nVar.f7410k = false;
        final int i8 = 0;
        kVar.b(f2730h, new DialogInterface.OnClickListener(this) { // from class: sb.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CommonDialog f9616b;

            {
                this.f9616b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                switch (i8) {
                    case 0:
                        CommonDialog commonDialog = this.f9616b;
                        ld.m mVar = commonDialog.f2732b;
                        if (mVar != null) {
                            mVar.dismiss();
                        }
                        commonDialog.finishAndRemoveTask();
                        ag.b bVar = CommonDialog.f2731i;
                        if (bVar != null) {
                            bVar.invoke(1);
                        }
                        break;
                    default:
                        CommonDialog commonDialog2 = this.f9616b;
                        ld.m mVar2 = commonDialog2.f2732b;
                        if (mVar2 != null) {
                            mVar2.dismiss();
                        }
                        commonDialog2.finishAndRemoveTask();
                        ag.b bVar2 = CommonDialog.f2731i;
                        if (bVar2 != null) {
                            bVar2.invoke(2);
                        }
                        break;
                }
            }
        });
        final int i9 = 1;
        kVar.c(e, new DialogInterface.OnClickListener(this) { // from class: sb.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CommonDialog f9616b;

            {
                this.f9616b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                switch (i9) {
                    case 0:
                        CommonDialog commonDialog = this.f9616b;
                        ld.m mVar = commonDialog.f2732b;
                        if (mVar != null) {
                            mVar.dismiss();
                        }
                        commonDialog.finishAndRemoveTask();
                        ag.b bVar = CommonDialog.f2731i;
                        if (bVar != null) {
                            bVar.invoke(1);
                        }
                        break;
                    default:
                        CommonDialog commonDialog2 = this.f9616b;
                        ld.m mVar2 = commonDialog2.f2732b;
                        if (mVar2 != null) {
                            mVar2.dismiss();
                        }
                        commonDialog2.finishAndRemoveTask();
                        ag.b bVar2 = CommonDialog.f2731i;
                        if (bVar2 != null) {
                            bVar2.invoke(2);
                        }
                        break;
                }
            }
        });
        this.f2732b = kVar.e();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = this.f2732b;
        if (mVar != null) {
            mVar.dismiss();
        }
        this.f2732b = null;
    }
}
