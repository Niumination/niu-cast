package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.ChannelOccupyDialog;
import dc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld.k;
import ld.m;
import ld.n;
import ob.b;
import sb.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/ChannelOccupyDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ChannelOccupyDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f2726c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f2727b;

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getIntent().getIntExtra("serviceType", 6) == 8 ? getString(R$string.pad_conflict_tip) : getString(R$string.pad_conflict_tip);
        k kVar = new k(this);
        String string2 = getString(R$string.pad_tip);
        n nVar = kVar.f7400b;
        nVar.f7403b = string2;
        nVar.f7405d = string;
        nVar.f7410k = false;
        nVar.f7411l = new l(this, 0);
        final int i8 = 0;
        kVar.b(getString(R$string.pad_cancel), new DialogInterface.OnClickListener(this) { // from class: sb.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ChannelOccupyDialog f9614b;

            {
                this.f9614b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                switch (i8) {
                    case 0:
                        ChannelOccupyDialog channelOccupyDialog = this.f9614b;
                        ld.m mVar = channelOccupyDialog.f2727b;
                        if (mVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dialog");
                            mVar = null;
                        }
                        mVar.dismiss();
                        ob.b bVar = ob.b.f8417b;
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter("cancel", "handleResult");
                        bVar.f8437a.J("cancel");
                        channelOccupyDialog.finishAndRemoveTask();
                        dc.d dVar = ChannelOccupyDialog.f2726c;
                        if (dVar != null) {
                            dVar.invoke(Boolean.FALSE);
                        }
                        break;
                    default:
                        ChannelOccupyDialog channelOccupyDialog2 = this.f9614b;
                        ld.m mVar2 = channelOccupyDialog2.f2727b;
                        if (mVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dialog");
                            mVar2 = null;
                        }
                        mVar2.dismiss();
                        ob.b bVar2 = ob.b.f8417b;
                        bVar2.getClass();
                        Intrinsics.checkNotNullParameter("contine", "handleResult");
                        bVar2.f8437a.J("contine");
                        channelOccupyDialog2.finishAndRemoveTask();
                        dc.d dVar2 = ChannelOccupyDialog.f2726c;
                        if (dVar2 != null) {
                            dVar2.invoke(Boolean.TRUE);
                        }
                        break;
                }
            }
        });
        final int i9 = 1;
        kVar.c(getString(R$string.pad_continue), new DialogInterface.OnClickListener(this) { // from class: sb.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ChannelOccupyDialog f9614b;

            {
                this.f9614b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                switch (i9) {
                    case 0:
                        ChannelOccupyDialog channelOccupyDialog = this.f9614b;
                        ld.m mVar = channelOccupyDialog.f2727b;
                        if (mVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dialog");
                            mVar = null;
                        }
                        mVar.dismiss();
                        ob.b bVar = ob.b.f8417b;
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter("cancel", "handleResult");
                        bVar.f8437a.J("cancel");
                        channelOccupyDialog.finishAndRemoveTask();
                        dc.d dVar = ChannelOccupyDialog.f2726c;
                        if (dVar != null) {
                            dVar.invoke(Boolean.FALSE);
                        }
                        break;
                    default:
                        ChannelOccupyDialog channelOccupyDialog2 = this.f9614b;
                        ld.m mVar2 = channelOccupyDialog2.f2727b;
                        if (mVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dialog");
                            mVar2 = null;
                        }
                        mVar2.dismiss();
                        ob.b bVar2 = ob.b.f8417b;
                        bVar2.getClass();
                        Intrinsics.checkNotNullParameter("contine", "handleResult");
                        bVar2.f8437a.J("contine");
                        channelOccupyDialog2.finishAndRemoveTask();
                        dc.d dVar2 = ChannelOccupyDialog.f2726c;
                        if (dVar2 != null) {
                            dVar2.invoke(Boolean.TRUE);
                        }
                        break;
                }
            }
        });
        this.f2727b = kVar.e();
        b.f8417b.f8437a.K();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = null;
        f2726c = null;
        m mVar2 = this.f2727b;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            mVar = mVar2;
        }
        mVar.dismiss();
    }
}
