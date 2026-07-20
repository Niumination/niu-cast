package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/transsion/iotcardsdk/bean/SwitchAction;", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "switchOn", "", "(Z)V", "pid", "", "(ZLjava/lang/String;)V", IotCardTemplateActionWrapper.KEY_ACTION_TYPE, "", "(IZLjava/lang/String;)V", "getPid", "()Ljava/lang/String;", "getSwitchOn", "()Z", "getActionType", "getDataBundle", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchAction extends ControlAction {
    public static final int ACTION_TYPE = 1;
    public static final String KEY_ACTION_TYPE = "key_action_type";
    public static final String KEY_PID = "key_pid";
    public static final String KEY_SWITCH_STATUS = "key_switch_status";
    private final String pid;
    private final boolean switchOn;

    public SwitchAction(int i8, boolean z2, String str) {
        this.switchOn = z2;
        this.pid = str;
    }

    @Override // com.transsion.iotcardsdk.bean.ControlAction
    public int getActionType() {
        return 1;
    }

    @Override // com.transsion.iotcardsdk.bean.ControlAction
    public Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putBoolean(KEY_SWITCH_STATUS, this.switchOn);
        dataBundle.putString("key_pid", this.pid);
        return dataBundle;
    }

    public final String getPid() {
        return this.pid;
    }

    public final boolean getSwitchOn() {
        return this.switchOn;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchAction(Bundle bundle) {
        this(bundle.getInt("key_action_type"), bundle.getBoolean(KEY_SWITCH_STATUS), bundle.getString("key_pid"));
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public SwitchAction(boolean z2) {
        this(1, z2, "");
    }

    public SwitchAction(boolean z2, String str) {
        this(1, z2, str);
    }
}
