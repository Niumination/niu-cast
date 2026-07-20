package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.QrConnectFailedDialog;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ld.k;
import ld.m;
import ld.n;
import li.l0;
import ob.b;
import sb.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/QrConnectFailedDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QrConnectFailedDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function1 f2754c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f2755b;

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b bVar = b.f8417b;
        bVar.getClass();
        Intrinsics.checkNotNullParameter("connect_fail", "conStatus");
        if (TextUtils.equals("qr_code_connect", b.f8423j)) {
            b.g();
            String entry = b.e;
            Intrinsics.checkNotNullParameter("connect_fail", "conStatus");
            Intrinsics.checkNotNullParameter("pc_connection", "workMode");
            Intrinsics.checkNotNullParameter(entry, "entry");
            bVar.f8437a.U("connect_fail", entry);
        }
        if (getIntent().getIntExtra("serviceType", 0) != 6) {
            k kVar = new k(this);
            int i8 = R$string.connection_failed_try_cable;
            n nVar = kVar.f7400b;
            nVar.f7405d = nVar.f7402a.getText(i8);
            nVar.f7410k = false;
            final int i9 = 0;
            nVar.f7412m = new DialogInterface.OnKeyListener(this) { // from class: sb.t

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ QrConnectFailedDialog f9626b;

                {
                    this.f9626b = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    QrConnectFailedDialog qrConnectFailedDialog = this.f9626b;
                    switch (i9) {
                        case 0:
                            Function1 function1 = QrConnectFailedDialog.f2754c;
                            if (i10 != 4) {
                                return false;
                            }
                            qrConnectFailedDialog.finishAndRemoveTask();
                            Function1 function2 = QrConnectFailedDialog.f2754c;
                            if (function2 != null) {
                                function2.invoke(Boolean.FALSE);
                            }
                            return true;
                        default:
                            Function1 function3 = QrConnectFailedDialog.f2754c;
                            if (i10 != 4) {
                                return false;
                            }
                            qrConnectFailedDialog.finishAndRemoveTask();
                            Function1 function4 = QrConnectFailedDialog.f2754c;
                            if (function4 != null) {
                                function4.invoke(Boolean.FALSE);
                            }
                            return true;
                    }
                }
            };
            nVar.f7411l = new l(this, 2);
            final int i10 = 0;
            kVar.c(getString(com.transsion.widgetsThemes.R$string.os_preference_dialog_positive_string), new DialogInterface.OnClickListener(this) { // from class: sb.u

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ QrConnectFailedDialog f9628b;

                {
                    this.f9628b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    QrConnectFailedDialog qrConnectFailedDialog = this.f9628b;
                    switch (i10) {
                        case 0:
                            Function1 function1 = QrConnectFailedDialog.f2754c;
                            qrConnectFailedDialog.finishAndRemoveTask();
                            Function1 function2 = QrConnectFailedDialog.f2754c;
                            if (function2 != null) {
                                function2.invoke(Boolean.TRUE);
                            }
                            break;
                        case 1:
                            Function1 function3 = QrConnectFailedDialog.f2754c;
                            qrConnectFailedDialog.finishAndRemoveTask();
                            Function1 function4 = QrConnectFailedDialog.f2754c;
                            if (function4 != null) {
                                function4.invoke(Boolean.FALSE);
                            }
                            break;
                        default:
                            Function1 function5 = QrConnectFailedDialog.f2754c;
                            l0.p(LifecycleOwnerKt.getLifecycleScope(qrConnectFailedDialog), null, null, new v(qrConnectFailedDialog, null), 3);
                            break;
                    }
                }
            });
            this.f2755b = kVar.e();
            return;
        }
        k kVar2 = new k(this);
        kVar2.d(R$string.pad_connect_fail);
        int i11 = R$string.pad_connect_fail_tips;
        n nVar2 = kVar2.f7400b;
        nVar2.f7405d = nVar2.f7402a.getText(i11);
        nVar2.f7410k = false;
        final int i12 = 1;
        nVar2.f7412m = new DialogInterface.OnKeyListener(this) { // from class: sb.t

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QrConnectFailedDialog f9626b;

            {
                this.f9626b = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i13, KeyEvent keyEvent) {
                QrConnectFailedDialog qrConnectFailedDialog = this.f9626b;
                switch (i12) {
                    case 0:
                        Function1 function1 = QrConnectFailedDialog.f2754c;
                        if (i13 != 4) {
                            return false;
                        }
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function2 = QrConnectFailedDialog.f2754c;
                        if (function2 != null) {
                            function2.invoke(Boolean.FALSE);
                        }
                        return true;
                    default:
                        Function1 function3 = QrConnectFailedDialog.f2754c;
                        if (i13 != 4) {
                            return false;
                        }
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function4 = QrConnectFailedDialog.f2754c;
                        if (function4 != null) {
                            function4.invoke(Boolean.FALSE);
                        }
                        return true;
                }
            }
        };
        final int i13 = 1;
        kVar2.b(getString(R$string.pad_cancel), new DialogInterface.OnClickListener(this) { // from class: sb.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QrConnectFailedDialog f9628b;

            {
                this.f9628b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i14) {
                QrConnectFailedDialog qrConnectFailedDialog = this.f9628b;
                switch (i13) {
                    case 0:
                        Function1 function1 = QrConnectFailedDialog.f2754c;
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function2 = QrConnectFailedDialog.f2754c;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE);
                        }
                        break;
                    case 1:
                        Function1 function3 = QrConnectFailedDialog.f2754c;
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function4 = QrConnectFailedDialog.f2754c;
                        if (function4 != null) {
                            function4.invoke(Boolean.FALSE);
                        }
                        break;
                    default:
                        Function1 function5 = QrConnectFailedDialog.f2754c;
                        l0.p(LifecycleOwnerKt.getLifecycleScope(qrConnectFailedDialog), null, null, new v(qrConnectFailedDialog, null), 3);
                        break;
                }
            }
        });
        final int i14 = 2;
        kVar2.c(getString(R$string.pad_reset), new DialogInterface.OnClickListener(this) { // from class: sb.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ QrConnectFailedDialog f9628b;

            {
                this.f9628b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i15) {
                QrConnectFailedDialog qrConnectFailedDialog = this.f9628b;
                switch (i14) {
                    case 0:
                        Function1 function1 = QrConnectFailedDialog.f2754c;
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function2 = QrConnectFailedDialog.f2754c;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE);
                        }
                        break;
                    case 1:
                        Function1 function3 = QrConnectFailedDialog.f2754c;
                        qrConnectFailedDialog.finishAndRemoveTask();
                        Function1 function4 = QrConnectFailedDialog.f2754c;
                        if (function4 != null) {
                            function4.invoke(Boolean.FALSE);
                        }
                        break;
                    default:
                        Function1 function5 = QrConnectFailedDialog.f2754c;
                        l0.p(LifecycleOwnerKt.getLifecycleScope(qrConnectFailedDialog), null, null, new v(qrConnectFailedDialog, null), 3);
                        break;
                }
            }
        });
        this.f2755b = kVar2.e();
        bVar.k("fail", System.currentTimeMillis() - QrConnectViewModel.f2800d);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = null;
        f2754c = null;
        m mVar2 = this.f2755b;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQrConnectFailedDialog");
        } else {
            mVar = mVar2;
        }
        mVar.dismiss();
    }
}
