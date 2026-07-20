package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/transsion/iotcardsdk/bean/EmptyTemplateBean;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "Ljava/io/Serializable;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "controlId", "", "packageName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDataBundle", "getTemplateType", "", "toString", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EmptyTemplateBean extends IotCardTemplateBean implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVICE_TYPE = 3;
    public static final String KEY_CONTROL_ID = "controlId";
    public static final String KEY_PACKAGE_NAME = "packageName";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/transsion/iotcardsdk/bean/EmptyTemplateBean$Companion;", "", "()V", "DEVICE_TYPE", "", "getDEVICE_TYPE$annotations", "KEY_CONTROL_ID", "", "KEY_PACKAGE_NAME", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEVICE_TYPE$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyTemplateBean(String controlId, String packageName) {
        super(controlId, packageName, null, 0, false, 0, 0L, 0, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
    }

    @Override // com.transsion.iotcardsdk.bean.IotCardTemplateBean
    public Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putString("controlId", getControlId());
        dataBundle.putString("packageName", getPackageName());
        return dataBundle;
    }

    @Override // com.transsion.iotcardsdk.bean.IotCardTemplateBean
    public int getTemplateType() {
        return 3;
    }

    public String toString() {
        return a.l("DisplayTemplateBean(controlId='", getControlId(), "',packageName='", getPackageName(), "')");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EmptyTemplateBean(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("controlId", "");
        Intrinsics.checkNotNull(string);
        String string2 = bundle.getString("packageName", "");
        Intrinsics.checkNotNull(string2);
        this(string, string2);
    }
}
