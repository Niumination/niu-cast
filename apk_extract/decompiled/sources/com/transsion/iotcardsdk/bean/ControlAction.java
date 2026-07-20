package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/transsion/iotcardsdk/bean/ControlAction;", "", "()V", "getActionType", "", "getDataBundle", "Landroid/os/Bundle;", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class ControlAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_ACTION_TYPE = "key_action_type";
    public static final String TAG = "ControlAction";
    private static final int TYPE_ERROR = -1;
    public static final int TYPE_ITEM_CLICK = 2;
    public static final int TYPE_SWITCH = 1;
    public static final int TYPE_UNREGISTER = 3;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/transsion/iotcardsdk/bean/ControlAction$Companion;", "", "()V", "KEY_ACTION_TYPE", "", "TAG", "TYPE_ERROR", "", "TYPE_ITEM_CLICK", "TYPE_SWITCH", "TYPE_UNREGISTER", "createActionFromBundle", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "bundle", "Landroid/os/Bundle;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ControlAction createActionFromBundle(Bundle bundle) {
            ControlAction switchAction;
            ControlAction controlAction = null;
            if (bundle == null) {
                Log.e(ControlAction.TAG, "Null bundle");
                return null;
            }
            int i8 = bundle.getInt("key_action_type", -1);
            try {
                if (i8 == 1) {
                    switchAction = new SwitchAction(bundle);
                } else if (i8 == 2) {
                    switchAction = new ItemClickAction(bundle);
                } else {
                    if (i8 != 3) {
                        return null;
                    }
                    switchAction = new UnregisterAction(bundle);
                }
                controlAction = switchAction;
                return controlAction;
            } catch (Exception e) {
                Log.e(ControlAction.TAG, "Error creating action", e);
                return controlAction;
            }
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final ControlAction createActionFromBundle(Bundle bundle) {
        return INSTANCE.createActionFromBundle(bundle);
    }

    public abstract int getActionType();

    public Bundle getDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_type", getActionType());
        return bundle;
    }
}
