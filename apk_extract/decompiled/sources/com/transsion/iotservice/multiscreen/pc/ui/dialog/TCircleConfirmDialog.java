package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.transsion.capability.bean.FileInfo;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogTcircleConfirmBinding;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmViewModel;
import com.transsion.iotservice.pc.bean.ThumbBean;
import dc.l;
import eb.l2;
import eb.v;
import eb.y;
import eb.z1;
import java.util.ArrayList;
import k3.gc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ld.k;
import ld.n;
import li.l0;
import ob.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/TCircleConfirmDialog;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivityDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTCircleConfirmDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TCircleConfirmDialog.kt\ncom/transsion/iotservice/multiscreen/pc/ui/dialog/TCircleConfirmDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1557#2:230\n1628#2,3:231\n*S KotlinDebug\n*F\n+ 1 TCircleConfirmDialog.kt\ncom/transsion/iotservice/multiscreen/pc/ui/dialog/TCircleConfirmDialog\n*L\n209#1:230\n209#1:231,3\n*E\n"})
public final class TCircleConfirmDialog extends BaseActivityDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f2756d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TCircleConfirmViewModel f2757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogTcircleConfirmBinding f2758c;

    public static void j(Function0 task) {
        Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
        Intrinsics.checkNotNullParameter("addConnectSuccessTask", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TCircleConfirmDialog"), "addConnectSuccessTask");
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        Intrinsics.checkNotNullParameter(task, "task");
        l2.e.add(new z1(0, task));
    }

    public static void k(int i8, ArrayList fileList) {
        if (fileList == null || fileList.isEmpty()) {
            Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
            Intrinsics.checkNotNullParameter("dealFileTransfer: file info is empty", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("TCircleConfirmDialog"), "dealFileTransfer: file info is empty");
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
        Intrinsics.checkNotNullParameter("dealFileTransfer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TCircleConfirmDialog"), "dealFileTransfer");
        }
        y yVar = y.f4799a;
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        l0.p(y.f4800b, null, null, new v(fileList, i8, null), 3);
    }

    public static ArrayList l(Intent intent) {
        ArrayList<ThumbBean> arrayList = (ArrayList) intent.getSerializableExtra("fileList", new ArrayList().getClass());
        if (arrayList == null) {
            return null;
        }
        String log = "intent2FileList:" + arrayList;
        Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TCircleConfirmDialog"), log);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(arrayList));
        for (ThumbBean thumbBean : arrayList) {
            arrayList2.add(new FileInfo(thumbBean.getUri(), thumbBean.getThumbnail(), thumbBean.getName(), thumbBean.getFormat(), thumbBean.getType(), thumbBean.getFileSize()));
        }
        return arrayList2;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setDimAmount(0.0f);
        TCircleConfirmViewModel tCircleConfirmViewModel = (TCircleConfirmViewModel) this.f2695a.A(this, TCircleConfirmViewModel.class);
        this.f2757b = tCircleConfirmViewModel;
        DialogTcircleConfirmBinding dialogTcircleConfirmBinding = null;
        if (tCircleConfirmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
            tCircleConfirmViewModel = null;
        }
        tCircleConfirmViewModel.f2760b = getIntent().getIntExtra("gestureType", 0);
        TCircleConfirmViewModel tCircleConfirmViewModel2 = this.f2757b;
        if (tCircleConfirmViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
            tCircleConfirmViewModel2 = null;
        }
        tCircleConfirmViewModel2.f2759a = new c(12);
        DialogTcircleConfirmBinding dialogTcircleConfirmBinding2 = (DialogTcircleConfirmBinding) DataBindingUtil.inflate(LayoutInflater.from(this), R$layout.dialog_tcircle_confirm, null, false);
        TCircleConfirmViewModel tCircleConfirmViewModel3 = this.f2757b;
        if (tCircleConfirmViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
            tCircleConfirmViewModel3 = null;
        }
        dialogTcircleConfirmBinding2.d(tCircleConfirmViewModel3);
        dialogTcircleConfirmBinding2.setLifecycleOwner(this);
        this.f2758c = dialogTcircleConfirmBinding2;
        k kVar = new k(this);
        DialogTcircleConfirmBinding dialogTcircleConfirmBinding3 = this.f2758c;
        if (dialogTcircleConfirmBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogTcircleConfirmBinding = dialogTcircleConfirmBinding3;
        }
        View root = dialogTcircleConfirmBinding.getRoot();
        n nVar = kVar.f7400b;
        nVar.f7413n = root;
        nVar.getClass();
        nVar.f7403b = getString(R$string.tcircle_connect_title);
        final int i8 = 0;
        kVar.c(getString(R$string.tcircle_connect), new DialogInterface.OnClickListener(this) { // from class: sb.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TCircleConfirmDialog f9630b;

            {
                this.f9630b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i9) {
                TCircleConfirmViewModel tCircleConfirmViewModel4 = null;
                TCircleConfirmViewModel tCircleConfirmViewModel5 = null;
                stringExtra = null;
                String stringExtra = null;
                final int i10 = 0;
                switch (i8) {
                    case 0:
                        final TCircleConfirmDialog tCircleConfirmDialog = this.f9630b;
                        TCircleConfirmViewModel tCircleConfirmViewModel6 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel6 = null;
                        }
                        tCircleConfirmViewModel6.getClass();
                        Intrinsics.checkNotNullParameter("TCircleConfirmViewModel", "tag");
                        Intrinsics.checkNotNullParameter("jump to t-circle to connect", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("TCircleConfirmViewModel"), "jump to t-circle to connect");
                        }
                        ob.c cVar = tCircleConfirmViewModel6.f2759a;
                        if (cVar != null) {
                            cVar.invoke();
                        }
                        TCircleConfirmViewModel tCircleConfirmViewModel7 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel7 = null;
                        }
                        gc.a("TCircleConfirmDialog", "dealFromTag:" + tCircleConfirmViewModel7.f2760b);
                        l2.d();
                        TCircleConfirmViewModel tCircleConfirmViewModel8 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel8 = null;
                        }
                        if (tCircleConfirmViewModel8.f2760b != 4) {
                            TCircleConfirmViewModel tCircleConfirmViewModel9 = tCircleConfirmDialog.f2757b;
                            if (tCircleConfirmViewModel9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                tCircleConfirmViewModel9 = null;
                            }
                            if (tCircleConfirmViewModel9.f2760b != 2) {
                                TCircleConfirmViewModel tCircleConfirmViewModel10 = tCircleConfirmDialog.f2757b;
                                if (tCircleConfirmViewModel10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                } else {
                                    tCircleConfirmViewModel4 = tCircleConfirmViewModel10;
                                }
                                if (tCircleConfirmViewModel4.f2760b == 3) {
                                    eb.y yVar = eb.y.f4799a;
                                    eb.y.f = 5;
                                    gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_COPY");
                                    Intent intent = tCircleConfirmDialog.getIntent();
                                    Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                                    final ArrayList arrayListL = TCircleConfirmDialog.l(intent);
                                    gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_COPY : " + arrayListL);
                                    ob.b.f8417b.t(arrayListL, 5, false);
                                    final int i11 = 1;
                                    TCircleConfirmDialog.j(new Function0() { // from class: sb.y
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            TCircleConfirmDialog tCircleConfirmDialog2 = tCircleConfirmDialog;
                                            ArrayList arrayList = arrayListL;
                                            switch (i11) {
                                                case 0:
                                                    ob.c cVar2 = TCircleConfirmDialog.f2756d;
                                                    tCircleConfirmDialog2.getClass();
                                                    TCircleConfirmDialog.k(3, arrayList);
                                                    break;
                                                default:
                                                    ob.c cVar3 = TCircleConfirmDialog.f2756d;
                                                    tCircleConfirmDialog2.getClass();
                                                    TCircleConfirmDialog.k(5, arrayList);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            } else {
                                eb.y yVar2 = eb.y.f4799a;
                                eb.y.f = 3;
                                gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_TRANSFER");
                                Intent intent2 = tCircleConfirmDialog.getIntent();
                                Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                                final ArrayList arrayListL2 = TCircleConfirmDialog.l(intent2);
                                gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_TRANSFER : " + arrayListL2);
                                ob.b.f8417b.t(arrayListL2, 3, false);
                                TCircleConfirmDialog.j(new Function0() { // from class: sb.y
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        TCircleConfirmDialog tCircleConfirmDialog2 = tCircleConfirmDialog;
                                        ArrayList arrayList = arrayListL2;
                                        switch (i10) {
                                            case 0:
                                                ob.c cVar2 = TCircleConfirmDialog.f2756d;
                                                tCircleConfirmDialog2.getClass();
                                                TCircleConfirmDialog.k(3, arrayList);
                                                break;
                                            default:
                                                ob.c cVar3 = TCircleConfirmDialog.f2756d;
                                                tCircleConfirmDialog2.getClass();
                                                TCircleConfirmDialog.k(5, arrayList);
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        } else {
                            eb.y yVar3 = eb.y.f4799a;
                            eb.y.f = 4;
                            Intrinsics.checkNotNullParameter("textContent", "key");
                            Intent intent3 = tCircleConfirmDialog.getIntent();
                            if (intent3 != null && intent3.hasExtra("textContent")) {
                                stringExtra = intent3.getStringExtra("textContent");
                            }
                            TCircleConfirmDialog.j(new x(stringExtra, i10));
                        }
                        break;
                    default:
                        TCircleConfirmViewModel tCircleConfirmViewModel11 = this.f9630b.f2757b;
                        if (tCircleConfirmViewModel11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                        } else {
                            tCircleConfirmViewModel5 = tCircleConfirmViewModel11;
                        }
                        tCircleConfirmViewModel5.getClass();
                        Intrinsics.checkNotNullParameter("TCircleConfirmViewModel", "tag");
                        Intrinsics.checkNotNullParameter("Cancel", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("TCircleConfirmViewModel"), "Cancel");
                        }
                        l2.d();
                        break;
                }
            }
        });
        final int i9 = 1;
        kVar.b(getString(R$string.tcircle_cancel), new DialogInterface.OnClickListener(this) { // from class: sb.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TCircleConfirmDialog f9630b;

            {
                this.f9630b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                TCircleConfirmViewModel tCircleConfirmViewModel4 = null;
                TCircleConfirmViewModel tCircleConfirmViewModel5 = null;
                stringExtra = null;
                String stringExtra = null;
                final int i11 = 0;
                switch (i9) {
                    case 0:
                        final TCircleConfirmDialog tCircleConfirmDialog = this.f9630b;
                        TCircleConfirmViewModel tCircleConfirmViewModel6 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel6 = null;
                        }
                        tCircleConfirmViewModel6.getClass();
                        Intrinsics.checkNotNullParameter("TCircleConfirmViewModel", "tag");
                        Intrinsics.checkNotNullParameter("jump to t-circle to connect", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("TCircleConfirmViewModel"), "jump to t-circle to connect");
                        }
                        ob.c cVar = tCircleConfirmViewModel6.f2759a;
                        if (cVar != null) {
                            cVar.invoke();
                        }
                        TCircleConfirmViewModel tCircleConfirmViewModel7 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel7 = null;
                        }
                        gc.a("TCircleConfirmDialog", "dealFromTag:" + tCircleConfirmViewModel7.f2760b);
                        l2.d();
                        TCircleConfirmViewModel tCircleConfirmViewModel8 = tCircleConfirmDialog.f2757b;
                        if (tCircleConfirmViewModel8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                            tCircleConfirmViewModel8 = null;
                        }
                        if (tCircleConfirmViewModel8.f2760b != 4) {
                            TCircleConfirmViewModel tCircleConfirmViewModel9 = tCircleConfirmDialog.f2757b;
                            if (tCircleConfirmViewModel9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                tCircleConfirmViewModel9 = null;
                            }
                            if (tCircleConfirmViewModel9.f2760b != 2) {
                                TCircleConfirmViewModel tCircleConfirmViewModel10 = tCircleConfirmDialog.f2757b;
                                if (tCircleConfirmViewModel10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                                } else {
                                    tCircleConfirmViewModel4 = tCircleConfirmViewModel10;
                                }
                                if (tCircleConfirmViewModel4.f2760b == 3) {
                                    eb.y yVar = eb.y.f4799a;
                                    eb.y.f = 5;
                                    gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_COPY");
                                    Intent intent = tCircleConfirmDialog.getIntent();
                                    Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
                                    final ArrayList arrayListL = TCircleConfirmDialog.l(intent);
                                    gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_COPY : " + arrayListL);
                                    ob.b.f8417b.t(arrayListL, 5, false);
                                    final int i12 = 1;
                                    TCircleConfirmDialog.j(new Function0() { // from class: sb.y
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            TCircleConfirmDialog tCircleConfirmDialog2 = tCircleConfirmDialog;
                                            ArrayList arrayList = arrayListL;
                                            switch (i12) {
                                                case 0:
                                                    ob.c cVar2 = TCircleConfirmDialog.f2756d;
                                                    tCircleConfirmDialog2.getClass();
                                                    TCircleConfirmDialog.k(3, arrayList);
                                                    break;
                                                default:
                                                    ob.c cVar3 = TCircleConfirmDialog.f2756d;
                                                    tCircleConfirmDialog2.getClass();
                                                    TCircleConfirmDialog.k(5, arrayList);
                                                    break;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            } else {
                                eb.y yVar2 = eb.y.f4799a;
                                eb.y.f = 3;
                                gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_TRANSFER");
                                Intent intent2 = tCircleConfirmDialog.getIntent();
                                Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
                                final ArrayList arrayListL2 = TCircleConfirmDialog.l(intent2);
                                gc.c("TCircleConfirmDialog", "SearchActivity.INTENT_FROM_AIR_TRANSFER : " + arrayListL2);
                                ob.b.f8417b.t(arrayListL2, 3, false);
                                TCircleConfirmDialog.j(new Function0() { // from class: sb.y
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        TCircleConfirmDialog tCircleConfirmDialog2 = tCircleConfirmDialog;
                                        ArrayList arrayList = arrayListL2;
                                        switch (i11) {
                                            case 0:
                                                ob.c cVar2 = TCircleConfirmDialog.f2756d;
                                                tCircleConfirmDialog2.getClass();
                                                TCircleConfirmDialog.k(3, arrayList);
                                                break;
                                            default:
                                                ob.c cVar3 = TCircleConfirmDialog.f2756d;
                                                tCircleConfirmDialog2.getClass();
                                                TCircleConfirmDialog.k(5, arrayList);
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        } else {
                            eb.y yVar3 = eb.y.f4799a;
                            eb.y.f = 4;
                            Intrinsics.checkNotNullParameter("textContent", "key");
                            Intent intent3 = tCircleConfirmDialog.getIntent();
                            if (intent3 != null && intent3.hasExtra("textContent")) {
                                stringExtra = intent3.getStringExtra("textContent");
                            }
                            TCircleConfirmDialog.j(new x(stringExtra, i11));
                        }
                        break;
                    default:
                        TCircleConfirmViewModel tCircleConfirmViewModel11 = this.f9630b.f2757b;
                        if (tCircleConfirmViewModel11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mTCircleConfirmVM");
                        } else {
                            tCircleConfirmViewModel5 = tCircleConfirmViewModel11;
                        }
                        tCircleConfirmViewModel5.getClass();
                        Intrinsics.checkNotNullParameter("TCircleConfirmViewModel", "tag");
                        Intrinsics.checkNotNullParameter("Cancel", "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("TCircleConfirmViewModel"), "Cancel");
                        }
                        l2.d();
                        break;
                }
            }
        });
        nVar.f7410k = true;
        nVar.f7409j = true;
        kVar.e().setOnDismissListener(new l(this, 2));
        if (this.f2758c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
    }
}
