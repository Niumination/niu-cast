package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PortKt;", "", "()V", "Dsl", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PortKt {
    public static final PortKt INSTANCE = new PortKt();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PortKt$Dsl;", "", "_builder", "Lcom/transsion/iotservice/iotcard/proto/Port$Builder;", "(Lcom/transsion/iotservice/iotcard/proto/Port$Builder;)V", "value", "", "packageName", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "", "port", "getPort", "()I", "setPort", "(I)V", "_build", "Lcom/transsion/iotservice/iotcard/proto/Port;", "clearPackageName", "", "clearPort", "Companion", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Port.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PortKt$Dsl$Companion;", "", "()V", "_create", "Lcom/transsion/iotservice/iotcard/proto/PortKt$Dsl;", "builder", "Lcom/transsion/iotservice/iotcard/proto/Port$Builder;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(Port.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Port.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ Port _build() {
            Port portBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(portBuild, "_builder.build()");
            return portBuild;
        }

        public final void clearPackageName() {
            this._builder.clearPackageName();
        }

        public final void clearPort() {
            this._builder.clearPort();
        }

        @JvmName(name = "getPackageName")
        public final String getPackageName() {
            String packageName = this._builder.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
            return packageName;
        }

        @JvmName(name = "getPort")
        public final int getPort() {
            return this._builder.getPort();
        }

        @JvmName(name = "setPackageName")
        public final void setPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackageName(value);
        }

        @JvmName(name = "setPort")
        public final void setPort(int i8) {
            this._builder.setPort(i8);
        }

        private Dsl(Port.Builder builder) {
            this._builder = builder;
        }
    }

    private PortKt() {
    }
}
