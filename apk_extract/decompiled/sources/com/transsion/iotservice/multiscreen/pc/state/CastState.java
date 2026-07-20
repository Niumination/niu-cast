package com.transsion.iotservice.multiscreen.pc.state;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/state/CastState;", "", "<init>", "()V", "CAST_STATE_IDLE", "", "CAST_STATE_PREPARE", "CAST_STATE_SUCCESS", "CAST_STATE_FAIL", "CAST_NOT_AUTO_OPEN", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CastState {
    public static final int CAST_NOT_AUTO_OPEN = 6;
    public static final int CAST_STATE_FAIL = 4;
    public static final int CAST_STATE_IDLE = 0;
    public static final int CAST_STATE_PREPARE = 1;
    public static final int CAST_STATE_SUCCESS = 3;
    public static final CastState INSTANCE = new CastState();

    private CastState() {
    }
}
