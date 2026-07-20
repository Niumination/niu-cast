package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FieldDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FieldDescriptorProtoKt {
    public static final FieldDescriptorProtoKt INSTANCE = new FieldDescriptorProtoKt();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001UB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010<\u001a\u00020=H\u0001J\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\u0006\u0010D\u001a\u00020?J\u0006\u0010E\u001a\u00020?J\u0006\u0010F\u001a\u00020?J\u0006\u0010G\u001a\u00020?J\u0006\u0010H\u001a\u00020?J\u0006\u0010I\u001a\u00020?J\u0006\u0010J\u001a\u00020*J\u0006\u0010K\u001a\u00020*J\u0006\u0010L\u001a\u00020*J\u0006\u0010M\u001a\u00020*J\u0006\u0010N\u001a\u00020*J\u0006\u0010O\u001a\u00020*J\u0006\u0010P\u001a\u00020*J\u0006\u0010Q\u001a\u00020*J\u0006\u0010R\u001a\u00020*J\u0006\u0010S\u001a\u00020*J\u0006\u0010T\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020*8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u0002008G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u0017\u00109\u001a\u0004\u0018\u00010$*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006V"}, d2 = {"Lcom/google/protobuf/FieldDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder;)V", "value", "", "defaultValue", "getDefaultValue", "()Ljava/lang/String;", "setDefaultValue", "(Ljava/lang/String;)V", "extendee", "getExtendee", "setExtendee", "jsonName", "getJsonName", "setJsonName", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label;", "label", "getLabel", "()Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label;", "setLabel", "(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Label;)V", "name", "getName", "setName", "", "number", "getNumber", "()I", "setNumber", "(I)V", "oneofIndex", "getOneofIndex", "setOneofIndex", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions;)V", "", "proto3Optional", "getProto3Optional", "()Z", "setProto3Optional", "(Z)V", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type;", MessageBank.KEY_TYPE, "getType", "()Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type;", "setType", "(Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Type;)V", "typeName", "getTypeName", "setTypeName", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/FieldDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;", "clearDefaultValue", "", "clearExtendee", "clearJsonName", "clearLabel", "clearName", "clearNumber", "clearOneofIndex", "clearOptions", "clearProto3Optional", "clearType", "clearTypeName", "hasDefaultValue", "hasExtendee", "hasJsonName", "hasLabel", "hasName", "hasNumber", "hasOneofIndex", "hasOptions", "hasProto3Optional", "hasType", "hasTypeName", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FieldDescriptorProto.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.FieldDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.FieldDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.FieldDescriptorProto _build() {
            DescriptorProtos.FieldDescriptorProto fieldDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fieldDescriptorProtoBuild, "_builder.build()");
            return fieldDescriptorProtoBuild;
        }

        public final void clearDefaultValue() {
            this._builder.clearDefaultValue();
        }

        public final void clearExtendee() {
            this._builder.clearExtendee();
        }

        public final void clearJsonName() {
            this._builder.clearJsonName();
        }

        public final void clearLabel() {
            this._builder.clearLabel();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearNumber() {
            this._builder.clearNumber();
        }

        public final void clearOneofIndex() {
            this._builder.clearOneofIndex();
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final void clearProto3Optional() {
            this._builder.clearProto3Optional();
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final void clearTypeName() {
            this._builder.clearTypeName();
        }

        @JvmName(name = "getDefaultValue")
        public final String getDefaultValue() {
            String defaultValue = this._builder.getDefaultValue();
            Intrinsics.checkNotNullExpressionValue(defaultValue, "_builder.getDefaultValue()");
            return defaultValue;
        }

        @JvmName(name = "getExtendee")
        public final String getExtendee() {
            String extendee = this._builder.getExtendee();
            Intrinsics.checkNotNullExpressionValue(extendee, "_builder.getExtendee()");
            return extendee;
        }

        @JvmName(name = "getJsonName")
        public final String getJsonName() {
            String jsonName = this._builder.getJsonName();
            Intrinsics.checkNotNullExpressionValue(jsonName, "_builder.getJsonName()");
            return jsonName;
        }

        @JvmName(name = "getLabel")
        public final DescriptorProtos.FieldDescriptorProto.Label getLabel() {
            DescriptorProtos.FieldDescriptorProto.Label label = this._builder.getLabel();
            Intrinsics.checkNotNullExpressionValue(label, "_builder.getLabel()");
            return label;
        }

        @JvmName(name = "getName")
        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        @JvmName(name = "getNumber")
        public final int getNumber() {
            return this._builder.getNumber();
        }

        @JvmName(name = "getOneofIndex")
        public final int getOneofIndex() {
            return this._builder.getOneofIndex();
        }

        @JvmName(name = "getOptions")
        public final DescriptorProtos.FieldOptions getOptions() {
            DescriptorProtos.FieldOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final DescriptorProtos.FieldOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FieldDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        @JvmName(name = "getProto3Optional")
        public final boolean getProto3Optional() {
            return this._builder.getProto3Optional();
        }

        @JvmName(name = "getType")
        public final DescriptorProtos.FieldDescriptorProto.Type getType() {
            DescriptorProtos.FieldDescriptorProto.Type type = this._builder.getType();
            Intrinsics.checkNotNullExpressionValue(type, "_builder.getType()");
            return type;
        }

        @JvmName(name = "getTypeName")
        public final String getTypeName() {
            String typeName = this._builder.getTypeName();
            Intrinsics.checkNotNullExpressionValue(typeName, "_builder.getTypeName()");
            return typeName;
        }

        public final boolean hasDefaultValue() {
            return this._builder.hasDefaultValue();
        }

        public final boolean hasExtendee() {
            return this._builder.hasExtendee();
        }

        public final boolean hasJsonName() {
            return this._builder.hasJsonName();
        }

        public final boolean hasLabel() {
            return this._builder.hasLabel();
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasNumber() {
            return this._builder.hasNumber();
        }

        public final boolean hasOneofIndex() {
            return this._builder.hasOneofIndex();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final boolean hasProto3Optional() {
            return this._builder.hasProto3Optional();
        }

        public final boolean hasType() {
            return this._builder.hasType();
        }

        public final boolean hasTypeName() {
            return this._builder.hasTypeName();
        }

        @JvmName(name = "setDefaultValue")
        public final void setDefaultValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDefaultValue(value);
        }

        @JvmName(name = "setExtendee")
        public final void setExtendee(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtendee(value);
        }

        @JvmName(name = "setJsonName")
        public final void setJsonName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJsonName(value);
        }

        @JvmName(name = "setLabel")
        public final void setLabel(DescriptorProtos.FieldDescriptorProto.Label value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLabel(value);
        }

        @JvmName(name = "setName")
        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        @JvmName(name = "setNumber")
        public final void setNumber(int i8) {
            this._builder.setNumber(i8);
        }

        @JvmName(name = "setOneofIndex")
        public final void setOneofIndex(int i8) {
            this._builder.setOneofIndex(i8);
        }

        @JvmName(name = "setOptions")
        public final void setOptions(DescriptorProtos.FieldOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        @JvmName(name = "setProto3Optional")
        public final void setProto3Optional(boolean z2) {
            this._builder.setProto3Optional(z2);
        }

        @JvmName(name = "setType")
        public final void setType(DescriptorProtos.FieldDescriptorProto.Type value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setType(value);
        }

        @JvmName(name = "setTypeName")
        public final void setTypeName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTypeName(value);
        }

        private Dsl(DescriptorProtos.FieldDescriptorProto.Builder builder) {
            this._builder = builder;
        }
    }

    private FieldDescriptorProtoKt() {
    }
}
