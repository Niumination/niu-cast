package com.transsion.iotcardsdk.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/transsion/iotcardsdk/bean/SwitchActionType;", "", "()V", "CAMARA_SHUTTER", "", "NORMAL_SWITCH", "NULL_SWITCH", "POWER_SWITCH", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchActionType {
    public static final int CAMARA_SHUTTER = 3;
    public static final SwitchActionType INSTANCE = new SwitchActionType();
    public static final int NORMAL_SWITCH = 1;
    public static final int NULL_SWITCH = 0;
    public static final int POWER_SWITCH = 2;

    private SwitchActionType() {
    }
}
