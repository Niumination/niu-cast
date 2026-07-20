package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import bb.s;
import cj.b;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import com.transsion.message.cast.analytics.p000const.EAnalyticsParams;
import eb.g0;
import eb.k1;
import eb.y;
import hc.c;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import ld.k;
import ld.m;
import ld.n;
import o.d;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/DialogUtilActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "k3/fd", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DialogUtilActivity extends BaseActivityDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f2733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f2734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static b f2735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static s f2736m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2737b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f2738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f2739d;
    public m e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f2740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f2741i;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        final int i8 = 3;
        final int i9 = 2;
        final int i10 = 0;
        final int i11 = 1;
        final int i12 = 4;
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("DialogType", -1);
        this.f2737b = intExtra;
        String strM = d.m("mInterruptType: ", "DialogUtilActivity", "tag", "log", intExtra);
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DialogUtilActivity"), strM);
        }
        int i13 = this.f2737b;
        if (i13 == 0) {
            k1 k1Var = k1.f4765a;
            c cVar = k1.e;
            if (cVar == null || (str = cVar.f5287b) == null) {
                str = "???";
            }
            String log = "deviceName: ".concat(str);
            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("DialogUtilActivity"), log);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R$string.bkp_backup_interrupt_sure);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strQ = d.q(new Object[]{str}, 1, string, "format(...)");
            k kVar = new k(this);
            kVar.d(R$string.bkp_tip);
            n nVar = kVar.f7400b;
            nVar.f7405d = strQ;
            nVar.f7410k = false;
            nVar.f7411l = new DialogInterface.OnCancelListener(this) { // from class: sb.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9618b;

                {
                    this.f9618b = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    DialogUtilActivity dialogUtilActivity = this.f9618b;
                    switch (i9) {
                        case 0:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z3 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z11 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            };
            kVar.c(getString(R$string.bkp_interrupt_connection), new DialogInterface.OnClickListener(this) { // from class: sb.p

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9620b;

                {
                    this.f9620b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i14) {
                    DialogUtilActivity dialogUtilActivity = this.f9620b;
                    switch (i8) {
                        case 0:
                            bb.s sVar = DialogUtilActivity.f2736m;
                            if (sVar != null) {
                                sVar.invoke();
                            }
                            DialogUtilActivity.f2736m = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            cj.b bVar = DialogUtilActivity.f2735l;
                            if (bVar != null) {
                                bVar.invoke();
                            }
                            DialogUtilActivity.f2735l = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z3 = DialogUtilActivity.f2733j;
                            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                            Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                            }
                            dialogUtilActivity.finishAndRemoveTask();
                            wa.c.a();
                            ob.b.f8417b.b("disable_pcconnect_via_phone");
                            break;
                        case 4:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            });
            kVar.b(getString(R$string.bkp_cancel), new DialogInterface.OnClickListener(this) { // from class: sb.p

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9620b;

                {
                    this.f9620b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i14) {
                    DialogUtilActivity dialogUtilActivity = this.f9620b;
                    switch (i12) {
                        case 0:
                            bb.s sVar = DialogUtilActivity.f2736m;
                            if (sVar != null) {
                                sVar.invoke();
                            }
                            DialogUtilActivity.f2736m = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            cj.b bVar = DialogUtilActivity.f2735l;
                            if (bVar != null) {
                                bVar.invoke();
                            }
                            DialogUtilActivity.f2735l = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z3 = DialogUtilActivity.f2733j;
                            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                            Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                            }
                            dialogUtilActivity.finishAndRemoveTask();
                            wa.c.a();
                            ob.b.f8417b.b("disable_pcconnect_via_phone");
                            break;
                        case 4:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            });
            this.f2738c = kVar.e();
            return;
        }
        if (i13 == 1) {
            k kVar2 = new k(this);
            kVar2.d(R$string.bkp_gallery_backup_interrupt);
            int i14 = R$string.bkp_backup_interrupt_desc;
            n nVar2 = kVar2.f7400b;
            nVar2.f7405d = nVar2.f7402a.getText(i14);
            n nVar3 = kVar2.f7400b;
            nVar3.f7410k = false;
            nVar3.f7411l = new DialogInterface.OnCancelListener(this) { // from class: sb.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9618b;

                {
                    this.f9618b = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    DialogUtilActivity dialogUtilActivity = this.f9618b;
                    switch (i8) {
                        case 0:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z3 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z11 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            };
            final int i15 = 5;
            kVar2.c(getString(R$string.bkp_sure), new DialogInterface.OnClickListener(this) { // from class: sb.p

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9620b;

                {
                    this.f9620b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    DialogUtilActivity dialogUtilActivity = this.f9620b;
                    switch (i15) {
                        case 0:
                            bb.s sVar = DialogUtilActivity.f2736m;
                            if (sVar != null) {
                                sVar.invoke();
                            }
                            DialogUtilActivity.f2736m = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            cj.b bVar = DialogUtilActivity.f2735l;
                            if (bVar != null) {
                                bVar.invoke();
                            }
                            DialogUtilActivity.f2735l = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z3 = DialogUtilActivity.f2733j;
                            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                            Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                            }
                            dialogUtilActivity.finishAndRemoveTask();
                            wa.c.a();
                            ob.b.f8417b.b("disable_pcconnect_via_phone");
                            break;
                        case 4:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            });
            this.f2739d = kVar2.e();
            wa.c.a();
            return;
        }
        if (i13 == 2) {
            k kVar3 = new k(this);
            kVar3.d(R$string.pad_phone_screen_mirror);
            int i16 = R$string.wifi_connection_suggestion;
            y yVar = y.f4799a;
            String strD = va.b.d(i16, y.f == 1 ? R$string.module_pc_expand_screen_title : R$string.pad_phone_screen_mirror);
            n nVar4 = kVar3.f7400b;
            nVar4.f7405d = strD;
            nVar4.f7410k = false;
            nVar4.f7411l = new DialogInterface.OnCancelListener(this) { // from class: sb.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9618b;

                {
                    this.f9618b = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    DialogUtilActivity dialogUtilActivity = this.f9618b;
                    switch (i10) {
                        case 0:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z3 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z11 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            };
            kVar3.c(getString(R$string.dialog_connect_fail_confirm), new DialogInterface.OnClickListener(this) { // from class: sb.p

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9620b;

                {
                    this.f9620b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    DialogUtilActivity dialogUtilActivity = this.f9620b;
                    switch (i11) {
                        case 0:
                            bb.s sVar = DialogUtilActivity.f2736m;
                            if (sVar != null) {
                                sVar.invoke();
                            }
                            DialogUtilActivity.f2736m = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            cj.b bVar = DialogUtilActivity.f2735l;
                            if (bVar != null) {
                                bVar.invoke();
                            }
                            DialogUtilActivity.f2735l = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z3 = DialogUtilActivity.f2733j;
                            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                            Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                            }
                            dialogUtilActivity.finishAndRemoveTask();
                            wa.c.a();
                            ob.b.f8417b.b("disable_pcconnect_via_phone");
                            break;
                        case 4:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            });
            this.e = kVar3.e();
            wa.c.a();
            ConnectedDevice connectedDevice = (ConnectedDevice) g0.e.getValue();
            String connectType = Intrinsics.areEqual(connectedDevice != null ? connectedDevice.getType() : null, ExifInterface.GPS_MEASUREMENT_2D) ? "pc" : EAnalyticsParams.DEVICE_TYPE_PAD;
            ob.b bVar = ob.b.f8417b;
            bVar.getClass();
            Intrinsics.checkNotNullParameter(connectType, "connectType");
            Intrinsics.checkNotNullParameter(connectType, "connectType");
            bVar.f8437a.getClass();
            Intrinsics.checkNotNullParameter(connectType, "connectType");
            Bundle bundle2 = new Bundle();
            bundle2.putString("connect_type", connectType);
            w.X("iot_multi_con_wifi_tip_ex", bundle2);
            return;
        }
        if (i13 == 3) {
            k kVar4 = new k(this);
            kVar4.d(R$string.bkp_tip);
            int i17 = R$string.pad_share_call_off_message;
            n nVar5 = kVar4.f7400b;
            nVar5.f7405d = nVar5.f7402a.getText(i17);
            n nVar6 = kVar4.f7400b;
            nVar6.f7410k = false;
            nVar6.f7411l = new DialogInterface.OnCancelListener(this) { // from class: sb.o

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9618b;

                {
                    this.f9618b = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    DialogUtilActivity dialogUtilActivity = this.f9618b;
                    switch (i12) {
                        case 0:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z3 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z11 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            };
            kVar4.c(getString(R$string.md_know), new DialogInterface.OnClickListener(this) { // from class: sb.p

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ DialogUtilActivity f9620b;

                {
                    this.f9620b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i18) {
                    DialogUtilActivity dialogUtilActivity = this.f9620b;
                    switch (i10) {
                        case 0:
                            bb.s sVar = DialogUtilActivity.f2736m;
                            if (sVar != null) {
                                sVar.invoke();
                            }
                            DialogUtilActivity.f2736m = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 1:
                            boolean z2 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 2:
                            cj.b bVar2 = DialogUtilActivity.f2735l;
                            if (bVar2 != null) {
                                bVar2.invoke();
                            }
                            DialogUtilActivity.f2735l = null;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        case 3:
                            boolean z3 = DialogUtilActivity.f2733j;
                            Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                            Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                            }
                            dialogUtilActivity.finishAndRemoveTask();
                            wa.c.a();
                            ob.b.f8417b.b("disable_pcconnect_via_phone");
                            break;
                        case 4:
                            boolean z5 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                        default:
                            boolean z10 = DialogUtilActivity.f2733j;
                            dialogUtilActivity.finishAndRemoveTask();
                            break;
                    }
                }
            });
            this.f2740h = kVar4.e();
            return;
        }
        if (i13 != 4) {
            return;
        }
        g0 g0Var = g0.f4753a;
        String strB = g0.b();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getString(R$string.pad_not_same_network_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String strQ2 = d.q(new Object[]{strB}, 1, string2, "format(...)");
        k kVar5 = new k(this);
        kVar5.d(R$string.pad_not_same_network_title);
        n nVar7 = kVar5.f7400b;
        nVar7.f7405d = strQ2;
        nVar7.f7410k = false;
        nVar7.f7411l = new DialogInterface.OnCancelListener(this) { // from class: sb.o

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DialogUtilActivity f9618b;

            {
                this.f9618b = this;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogUtilActivity dialogUtilActivity = this.f9618b;
                switch (i11) {
                    case 0:
                        boolean z2 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 1:
                        boolean z3 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 2:
                        boolean z5 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 3:
                        boolean z10 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    default:
                        boolean z11 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                }
            }
        };
        kVar5.c(getString(R$string.md_know), new DialogInterface.OnClickListener(this) { // from class: sb.p

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DialogUtilActivity f9620b;

            {
                this.f9620b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i18) {
                DialogUtilActivity dialogUtilActivity = this.f9620b;
                switch (i9) {
                    case 0:
                        bb.s sVar = DialogUtilActivity.f2736m;
                        if (sVar != null) {
                            sVar.invoke();
                        }
                        DialogUtilActivity.f2736m = null;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 1:
                        boolean z2 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 2:
                        cj.b bVar2 = DialogUtilActivity.f2735l;
                        if (bVar2 != null) {
                            bVar2.invoke();
                        }
                        DialogUtilActivity.f2735l = null;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    case 3:
                        boolean z3 = DialogUtilActivity.f2733j;
                        Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
                        Intrinsics.checkNotNullParameter("backup is interrupt", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("DialogUtilActivity"), "backup is interrupt");
                        }
                        dialogUtilActivity.finishAndRemoveTask();
                        wa.c.a();
                        ob.b.f8417b.b("disable_pcconnect_via_phone");
                        break;
                    case 4:
                        boolean z5 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                    default:
                        boolean z10 = DialogUtilActivity.f2733j;
                        dialogUtilActivity.finishAndRemoveTask();
                        break;
                }
            }
        });
        this.f2741i = kVar5.e();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        m mVar = this.f2738c;
        if (mVar != null) {
            mVar.dismiss();
        }
        m mVar2 = this.f2739d;
        if (mVar2 != null) {
            mVar2.dismiss();
        }
        m mVar3 = this.e;
        if (mVar3 != null) {
            mVar3.dismiss();
        }
        m mVar4 = this.f2740h;
        if (mVar4 != null) {
            mVar4.dismiss();
        }
        m mVar5 = this.f2741i;
        if (mVar5 != null) {
            mVar5.dismiss();
        }
    }
}
