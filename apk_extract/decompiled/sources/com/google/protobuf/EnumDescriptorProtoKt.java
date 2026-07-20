package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt;", "", "()V", "enumReservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeenumReservedRange", "Dsl", "EnumReservedRangeKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nEnumDescriptorProtoKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumDescriptorProtoKt.kt\ncom/google/protobuf/EnumDescriptorProtoKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,377:1\n1#2:378\n*E\n"})
public final class EnumDescriptorProtoKt {
    public static final EnumDescriptorProtoKt INSTANCE = new EnumDescriptorProtoKt();

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0002\b*J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u0005\u001a\u00020\u001bH\u0007¢\u0006\u0002\b+J%\u0010)\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b,J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0007¢\u0006\u0002\b0J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0/H\u0007¢\u0006\u0002\b1J+\u0010-\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0007¢\u0006\u0002\b2J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0013H\u0007¢\u0006\u0002\b4J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0013H\u0007¢\u0006\u0002\b5J\u001d\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¢\u0006\u0002\b6J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0002\b8J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0087\n¢\u0006\u0002\b9J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u0005\u001a\u00020\u001bH\u0087\n¢\u0006\u0002\b:J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0/H\u0087\n¢\u0006\u0002\b;J&\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\n¢\u0006\u0002\b<J,\u00107\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0087\n¢\u0006\u0002\b=J.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\u0002¢\u0006\u0002\bAJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u001bH\u0087\u0002¢\u0006\u0002\bBJ.\u0010>\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\bCR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006H"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$EnumOptions;)V", "reservedName", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedNameProxy;", "getReservedName", "()Lcom/google/protobuf/kotlin/DslList;", "reservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedRangeProxy;", "getReservedRange", "Lcom/google/protobuf/DescriptorProtos$EnumValueDescriptorProto;", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ValueProxy;", "getValue", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$EnumOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;", "clearName", "", "clearOptions", "hasName", "", "hasOptions", "add", "addReservedRange", "addValue", "addReservedName", "addAll", "values", "", "addAllReservedRange", "addAllValue", "addAllReservedName", "clear", "clearReservedRange", "clearValue", "clearReservedName", "plusAssign", "plusAssignReservedRange", "plusAssignAllReservedRange", "plusAssignValue", "plusAssignAllValue", "plusAssignReservedName", "plusAssignAllReservedName", "set", "index", "", "setReservedRange", "setValue", "setReservedName", "Companion", "ReservedNameProxy", "ReservedRangeProxy", "ValueProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.EnumDescriptorProto.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.EnumDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedNameProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ReservedNameProxy extends DslProxy {
            private ReservedNameProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ReservedRangeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ReservedRangeProxy extends DslProxy {
            private ReservedRangeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$Dsl$ValueProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ValueProxy extends DslProxy {
            private ValueProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.EnumDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.EnumDescriptorProto _build() {
            DescriptorProtos.EnumDescriptorProto enumDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumDescriptorProtoBuild, "_builder.build()");
            return enumDescriptorProtoBuild;
        }

        @JvmName(name = "addAllReservedName")
        public final /* synthetic */ void addAllReservedName(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedName(values);
        }

        @JvmName(name = "addAllReservedRange")
        public final /* synthetic */ void addAllReservedRange(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedRange(values);
        }

        @JvmName(name = "addAllValue")
        public final /* synthetic */ void addAllValue(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllValue(values);
        }

        @JvmName(name = "addReservedName")
        public final /* synthetic */ void addReservedName(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedName(value);
        }

        @JvmName(name = "addReservedRange")
        public final /* synthetic */ void addReservedRange(DslList dslList, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedRange(value);
        }

        @JvmName(name = "addValue")
        public final /* synthetic */ void addValue(DslList dslList, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addValue(value);
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        @JvmName(name = "clearReservedName")
        public final /* synthetic */ void clearReservedName(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedName();
        }

        @JvmName(name = "clearReservedRange")
        public final /* synthetic */ void clearReservedRange(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedRange();
        }

        @JvmName(name = "clearValue")
        public final /* synthetic */ void clearValue(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearValue();
        }

        @JvmName(name = "getName")
        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        @JvmName(name = "getOptions")
        public final DescriptorProtos.EnumOptions getOptions() {
            DescriptorProtos.EnumOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final DescriptorProtos.EnumOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return EnumDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        public final /* synthetic */ DslList getReservedName() {
            ProtocolStringList reservedNameList = this._builder.getReservedNameList();
            Intrinsics.checkNotNullExpressionValue(reservedNameList, "_builder.getReservedNameList()");
            return new DslList(reservedNameList);
        }

        public final /* synthetic */ DslList getReservedRange() {
            List<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> reservedRangeList = this._builder.getReservedRangeList();
            Intrinsics.checkNotNullExpressionValue(reservedRangeList, "_builder.getReservedRangeList()");
            return new DslList(reservedRangeList);
        }

        public final /* synthetic */ DslList getValue() {
            List<DescriptorProtos.EnumValueDescriptorProto> valueList = this._builder.getValueList();
            Intrinsics.checkNotNullExpressionValue(valueList, "_builder.getValueList()");
            return new DslList(valueList);
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        @JvmName(name = "plusAssignAllReservedName")
        public final /* synthetic */ void plusAssignAllReservedName(DslList<String, ReservedNameProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedName(dslList, values);
        }

        @JvmName(name = "plusAssignAllReservedRange")
        public final /* synthetic */ void plusAssignAllReservedRange(DslList<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, ReservedRangeProxy> dslList, Iterable<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedRange(dslList, values);
        }

        @JvmName(name = "plusAssignAllValue")
        public final /* synthetic */ void plusAssignAllValue(DslList<DescriptorProtos.EnumValueDescriptorProto, ValueProxy> dslList, Iterable<DescriptorProtos.EnumValueDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllValue(dslList, values);
        }

        @JvmName(name = "plusAssignReservedName")
        public final /* synthetic */ void plusAssignReservedName(DslList<String, ReservedNameProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedName(dslList, value);
        }

        @JvmName(name = "plusAssignReservedRange")
        public final /* synthetic */ void plusAssignReservedRange(DslList<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, ReservedRangeProxy> dslList, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedRange(dslList, value);
        }

        @JvmName(name = "plusAssignValue")
        public final /* synthetic */ void plusAssignValue(DslList<DescriptorProtos.EnumValueDescriptorProto, ValueProxy> dslList, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addValue(dslList, value);
        }

        @JvmName(name = "setName")
        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        @JvmName(name = "setOptions")
        public final void setOptions(DescriptorProtos.EnumOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        @JvmName(name = "setReservedName")
        public final /* synthetic */ void setReservedName(DslList dslList, int i8, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedName(i8, value);
        }

        @JvmName(name = "setReservedRange")
        public final /* synthetic */ void setReservedRange(DslList dslList, int i8, DescriptorProtos.EnumDescriptorProto.EnumReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedRange(i8, value);
        }

        @JvmName(name = "setValue")
        public final /* synthetic */ void setValue(DslList dslList, int i8, DescriptorProtos.EnumValueDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setValue(i8, value);
        }

        private Dsl(DescriptorProtos.EnumDescriptorProto.Builder builder) {
            this._builder = builder;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class EnumReservedRangeKt {
        public static final EnumReservedRangeKt INSTANCE = new EnumReservedRangeKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;)V", "value", "", "end", "getEnd", "()I", "setEnd", "(I)V", "start", "getStart", "setStart", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange;", "clearEnd", "", "clearStart", "hasEnd", "", "hasStart", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumDescriptorProtoKt$EnumReservedRangeKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.EnumDescriptorProto.EnumReservedRange _build() {
                DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRangeBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(enumReservedRangeBuild, "_builder.build()");
                return enumReservedRangeBuild;
            }

            public final void clearEnd() {
                this._builder.clearEnd();
            }

            public final void clearStart() {
                this._builder.clearStart();
            }

            @JvmName(name = "getEnd")
            public final int getEnd() {
                return this._builder.getEnd();
            }

            @JvmName(name = "getStart")
            public final int getStart() {
                return this._builder.getStart();
            }

            public final boolean hasEnd() {
                return this._builder.hasEnd();
            }

            public final boolean hasStart() {
                return this._builder.hasStart();
            }

            @JvmName(name = "setEnd")
            public final void setEnd(int i8) {
                this._builder.setEnd(i8);
            }

            @JvmName(name = "setStart")
            public final void setStart(int i8) {
                this._builder.setStart(i8);
            }

            private Dsl(DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builder) {
                this._builder = builder;
            }
        }

        private EnumReservedRangeKt() {
        }
    }

    private EnumDescriptorProtoKt() {
    }

    @JvmName(name = "-initializeenumReservedRange")
    /* JADX INFO: renamed from: -initializeenumReservedRange, reason: not valid java name */
    public final DescriptorProtos.EnumDescriptorProto.EnumReservedRange m67initializeenumReservedRange(Function1<? super EnumReservedRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EnumReservedRangeKt.Dsl.Companion companion = EnumReservedRangeKt.Dsl.INSTANCE;
        DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder builderNewBuilder = DescriptorProtos.EnumDescriptorProto.EnumReservedRange.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EnumReservedRangeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
