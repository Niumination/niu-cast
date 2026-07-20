package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.transsion.iotcardsdk.bean.SwitchTemplateBean;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/SwitchClickActionKt;", "", "()V", "Dsl", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchClickActionKt {
    public static final SwitchClickActionKt INSTANCE = new SwitchClickActionKt();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/SwitchClickActionKt$Dsl;", "", "_builder", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction$Builder;", "(Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction$Builder;)V", "value", "", "controlId", "getControlId", "()Ljava/lang/String;", "setControlId", "(Ljava/lang/String;)V", "", SwitchTemplateBean.KEY_DEVICE_SWITCH, "getDeviceSwitch", "()Z", "setDeviceSwitch", "(Z)V", "packageName", "getPackageName", "setPackageName", "pid", "getPid", "setPid", "_build", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction;", "clearControlId", "", "clearDeviceSwitch", "clearPackageName", "clearPid", "Companion", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final SwitchClickAction.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/SwitchClickActionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickActionKt$Dsl;", "builder", "Lcom/transsion/iotservice/iotcard/proto/SwitchClickAction$Builder;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SwitchClickAction.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(SwitchClickAction.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ SwitchClickAction _build() {
            SwitchClickAction switchClickActionBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(switchClickActionBuild, "_builder.build()");
            return switchClickActionBuild;
        }

        public final void clearControlId() {
            this._builder.clearControlId();
        }

        public final void clearDeviceSwitch() {
            this._builder.clearDeviceSwitch();
        }

        public final void clearPackageName() {
            this._builder.clearPackageName();
        }

        public final void clearPid() {
            this._builder.clearPid();
        }

        @JvmName(name = "getControlId")
        public final String getControlId() {
            String controlId = this._builder.getControlId();
            Intrinsics.checkNotNullExpressionValue(controlId, "_builder.getControlId()");
            return controlId;
        }

        @JvmName(name = "getDeviceSwitch")
        public final boolean getDeviceSwitch() {
            return this._builder.getDeviceSwitch();
        }

        @JvmName(name = "getPackageName")
        public final String getPackageName() {
            String packageName = this._builder.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
            return packageName;
        }

        @JvmName(name = "getPid")
        public final String getPid() {
            String pid = this._builder.getPid();
            Intrinsics.checkNotNullExpressionValue(pid, "_builder.getPid()");
            return pid;
        }

        @JvmName(name = "setControlId")
        public final void setControlId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setControlId(value);
        }

        @JvmName(name = "setDeviceSwitch")
        public final void setDeviceSwitch(boolean z2) {
            this._builder.setDeviceSwitch(z2);
        }

        @JvmName(name = "setPackageName")
        public final void setPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackageName(value);
        }

        @JvmName(name = "setPid")
        public final void setPid(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPid(value);
        }

        private Dsl(SwitchClickAction.Builder builder) {
            this._builder = builder;
        }
    }

    private SwitchClickActionKt() {
    }
}
