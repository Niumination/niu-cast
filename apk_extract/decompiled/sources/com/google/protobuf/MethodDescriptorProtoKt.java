package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/MethodDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MethodDescriptorProtoKt {
    public static final MethodDescriptorProtoKt INSTANCE = new MethodDescriptorProtoKt();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0001J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020'J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020'J\u0006\u0010,\u001a\u00020'J\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u0017\u0010!\u001a\u0004\u0018\u00010\u0015*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/google/protobuf/MethodDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder;)V", "value", "", "clientStreaming", "getClientStreaming", "()Z", "setClientStreaming", "(Z)V", "", "inputType", "getInputType", "()Ljava/lang/String;", "setInputType", "(Ljava/lang/String;)V", "name", "getName", "setName", "Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$MethodOptions;)V", "outputType", "getOutputType", "setOutputType", "serverStreaming", "getServerStreaming", "setServerStreaming", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/MethodDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$MethodOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto;", "clearClientStreaming", "", "clearInputType", "clearName", "clearOptions", "clearOutputType", "clearServerStreaming", "hasClientStreaming", "hasInputType", "hasName", "hasOptions", "hasOutputType", "hasServerStreaming", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.MethodDescriptorProto.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/MethodDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/MethodDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$MethodDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.MethodDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.MethodDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.MethodDescriptorProto _build() {
            DescriptorProtos.MethodDescriptorProto methodDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(methodDescriptorProtoBuild, "_builder.build()");
            return methodDescriptorProtoBuild;
        }

        public final void clearClientStreaming() {
            this._builder.clearClientStreaming();
        }

        public final void clearInputType() {
            this._builder.clearInputType();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final void clearOutputType() {
            this._builder.clearOutputType();
        }

        public final void clearServerStreaming() {
            this._builder.clearServerStreaming();
        }

        @JvmName(name = "getClientStreaming")
        public final boolean getClientStreaming() {
            return this._builder.getClientStreaming();
        }

        @JvmName(name = "getInputType")
        public final String getInputType() {
            String inputType = this._builder.getInputType();
            Intrinsics.checkNotNullExpressionValue(inputType, "_builder.getInputType()");
            return inputType;
        }

        @JvmName(name = "getName")
        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        @JvmName(name = "getOptions")
        public final DescriptorProtos.MethodOptions getOptions() {
            DescriptorProtos.MethodOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final DescriptorProtos.MethodOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return MethodDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        @JvmName(name = "getOutputType")
        public final String getOutputType() {
            String outputType = this._builder.getOutputType();
            Intrinsics.checkNotNullExpressionValue(outputType, "_builder.getOutputType()");
            return outputType;
        }

        @JvmName(name = "getServerStreaming")
        public final boolean getServerStreaming() {
            return this._builder.getServerStreaming();
        }

        public final boolean hasClientStreaming() {
            return this._builder.hasClientStreaming();
        }

        public final boolean hasInputType() {
            return this._builder.hasInputType();
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final boolean hasOutputType() {
            return this._builder.hasOutputType();
        }

        public final boolean hasServerStreaming() {
            return this._builder.hasServerStreaming();
        }

        @JvmName(name = "setClientStreaming")
        public final void setClientStreaming(boolean z2) {
            this._builder.setClientStreaming(z2);
        }

        @JvmName(name = "setInputType")
        public final void setInputType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setInputType(value);
        }

        @JvmName(name = "setName")
        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        @JvmName(name = "setOptions")
        public final void setOptions(DescriptorProtos.MethodOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        @JvmName(name = "setOutputType")
        public final void setOutputType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOutputType(value);
        }

        @JvmName(name = "setServerStreaming")
        public final void setServerStreaming(boolean z2) {
            this._builder.setServerStreaming(z2);
        }

        private Dsl(DescriptorProtos.MethodDescriptorProto.Builder builder) {
            this._builder = builder;
        }
    }

    private MethodDescriptorProtoKt() {
    }
}
