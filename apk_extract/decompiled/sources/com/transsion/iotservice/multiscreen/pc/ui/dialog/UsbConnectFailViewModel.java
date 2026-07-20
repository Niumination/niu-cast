package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import kotlin.Metadata;
import ph.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/UsbConnectFailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UsbConnectFailViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchPageText f2764a = new SearchPageText(new TextBean(Integer.valueOf(R$string.usb_connect_fail_text), null), new TextBean(Integer.valueOf(R$string.module_pc_get_our_pc_connect_www), "https://www.pcconnection.online"), true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2765b = new c();
}
