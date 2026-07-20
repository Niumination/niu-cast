package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper;", "", IotCardTemplateActionWrapper.KEY_ACTION_TYPE, "", "controlAction", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "(Ljava/lang/String;Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)V", "getActionType", "()Ljava/lang/String;", "getControlAction", "()Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "component1", "component2", "copy", "equals", "", "other", "getDataBundle", "Landroid/os/Bundle;", "hashCode", "", "toString", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class IotCardTemplateActionWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_ACTION_TYPE = "actionType";
    public static final String TAG = "IotCardTemplateActionWrapper";
    private final String actionType;
    private final IotCardTemplateBean controlAction;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper$Companion;", "", "()V", "KEY_ACTION_TYPE", "", "TAG", "createIotCardTemplateActionWrapperFromBundle", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateActionWrapper;", "bundle", "Landroid/os/Bundle;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(23)
        public final IotCardTemplateActionWrapper createIotCardTemplateActionWrapperFromBundle(Bundle bundle) {
            if (bundle == null) {
                Log.e(IotCardTemplateActionWrapper.TAG, "bundle in data class IotCardTemplateActionWrapper is null");
                return null;
            }
            String string = bundle.getString(IotCardTemplateActionWrapper.KEY_ACTION_TYPE, "");
            if (string == null) {
                return null;
            }
            int iHashCode = string.hashCode();
            if (iHashCode == -838846263) {
                if (string.equals(AppActionKt.UPDATE)) {
                    return new IotCardTemplateActionWrapper(AppActionKt.UPDATE, IotCardTemplateBean.INSTANCE.createTemplateFromBundle(bundle));
                }
                return null;
            }
            if (iHashCode == -690213213) {
                if (string.equals(AppActionKt.REGISTER)) {
                    return new IotCardTemplateActionWrapper(AppActionKt.REGISTER, IotCardTemplateBean.INSTANCE.createTemplateFromBundle(bundle));
                }
                return null;
            }
            if (iHashCode == 900659292 && string.equals(AppActionKt.UNREGISTER)) {
                return new IotCardTemplateActionWrapper(AppActionKt.UNREGISTER, IotCardTemplateBean.INSTANCE.createTemplateFromBundle(bundle));
            }
            return null;
        }

        private Companion() {
        }
    }

    public IotCardTemplateActionWrapper(String actionType, IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.actionType = actionType;
        this.controlAction = iotCardTemplateBean;
    }

    public static /* synthetic */ IotCardTemplateActionWrapper copy$default(IotCardTemplateActionWrapper iotCardTemplateActionWrapper, String str, IotCardTemplateBean iotCardTemplateBean, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = iotCardTemplateActionWrapper.actionType;
        }
        if ((i8 & 2) != 0) {
            iotCardTemplateBean = iotCardTemplateActionWrapper.controlAction;
        }
        return iotCardTemplateActionWrapper.copy(str, iotCardTemplateBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IotCardTemplateBean getControlAction() {
        return this.controlAction;
    }

    public final IotCardTemplateActionWrapper copy(String actionType, IotCardTemplateBean controlAction) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        return new IotCardTemplateActionWrapper(actionType, controlAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IotCardTemplateActionWrapper)) {
            return false;
        }
        IotCardTemplateActionWrapper iotCardTemplateActionWrapper = (IotCardTemplateActionWrapper) other;
        return Intrinsics.areEqual(this.actionType, iotCardTemplateActionWrapper.actionType) && Intrinsics.areEqual(this.controlAction, iotCardTemplateActionWrapper.controlAction);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final IotCardTemplateBean getControlAction() {
        return this.controlAction;
    }

    public final Bundle getDataBundle() {
        Bundle bundle;
        IotCardTemplateBean iotCardTemplateBean = this.controlAction;
        if (iotCardTemplateBean == null || (bundle = iotCardTemplateBean.getDataBundle()) == null) {
            bundle = new Bundle();
        }
        bundle.putString(KEY_ACTION_TYPE, this.actionType);
        return bundle;
    }

    public int hashCode() {
        int iHashCode = this.actionType.hashCode() * 31;
        IotCardTemplateBean iotCardTemplateBean = this.controlAction;
        return iHashCode + (iotCardTemplateBean == null ? 0 : iotCardTemplateBean.hashCode());
    }

    public String toString() {
        return "IotCardTemplateActionWrapper(actionType=" + this.actionType + ", controlAction=" + this.controlAction + ")";
    }
}
