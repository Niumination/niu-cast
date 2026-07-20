package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PackageNameKt;", "", "()V", "Dsl", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PackageNameKt {
    public static final PackageNameKt INSTANCE = new PackageNameKt();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0001J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PackageNameKt$Dsl;", "", "_builder", "Lcom/transsion/iotservice/iotcard/proto/PackageName$Builder;", "(Lcom/transsion/iotservice/iotcard/proto/PackageName$Builder;)V", "value", "", "packageName", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "_build", "Lcom/transsion/iotservice/iotcard/proto/PackageName;", "clearPackageName", "", "Companion", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final PackageName.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/PackageNameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/transsion/iotservice/iotcard/proto/PackageNameKt$Dsl;", "builder", "Lcom/transsion/iotservice/iotcard/proto/PackageName$Builder;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(PackageName.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(PackageName.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ PackageName _build() {
            PackageName packageNameBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(packageNameBuild, "_builder.build()");
            return packageNameBuild;
        }

        public final void clearPackageName() {
            this._builder.clearPackageName();
        }

        @JvmName(name = "getPackageName")
        public final String getPackageName() {
            String packageName = this._builder.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
            return packageName;
        }

        @JvmName(name = "setPackageName")
        public final void setPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackageName(value);
        }

        private Dsl(PackageName.Builder builder) {
            this._builder = builder;
        }
    }

    private PackageNameKt() {
    }
}
