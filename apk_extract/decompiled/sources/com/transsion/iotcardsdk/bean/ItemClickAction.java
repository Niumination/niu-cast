package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/transsion/iotcardsdk/bean/ItemClickAction;", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "()V", "pid", "", "(Ljava/lang/String;)V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", IotCardTemplateActionWrapper.KEY_ACTION_TYPE, "", "(ILjava/lang/String;)V", "getPid", "()Ljava/lang/String;", "getActionType", "getDataBundle", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ItemClickAction extends ControlAction {
    public static final int ACTION_TYPE = 2;
    public static final String KEY_ACTION_TYPE = "key_action_type";
    public static final String KEY_PID = "key_pid";
    private final String pid;

    public ItemClickAction(int i8, String str) {
        this.pid = str;
    }

    @Override // com.transsion.iotcardsdk.bean.ControlAction
    public int getActionType() {
        return 2;
    }

    @Override // com.transsion.iotcardsdk.bean.ControlAction
    public Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putString("key_pid", this.pid);
        return dataBundle;
    }

    public final String getPid() {
        return this.pid;
    }

    public ItemClickAction() {
        this(1, "");
    }

    public ItemClickAction(String str) {
        this(1, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemClickAction(Bundle bundle) {
        this(bundle.getInt("key_action_type"), bundle.getString("key_pid"));
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }
}
