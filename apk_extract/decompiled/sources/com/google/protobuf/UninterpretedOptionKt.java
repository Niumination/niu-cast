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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt;", "", "()V", "namePart", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializenamePart", "Dsl", "NamePartKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nUninterpretedOptionKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UninterpretedOptionKt.kt\ncom/google/protobuf/UninterpretedOptionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,326:1\n1#2:327\n*E\n"})
public final class UninterpretedOptionKt {
    public static final UninterpretedOptionKt INSTANCE = new UninterpretedOptionKt();

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0001J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J\u0006\u00109\u001a\u000204J%\u0010:\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0007¢\u0006\u0002\b;J+\u0010<\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170>H\u0007¢\u0006\u0002\b?J\u001d\u0010@\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0007¢\u0006\u0002\bAJ&\u0010B\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\n¢\u0006\u0002\bCJ,\u0010B\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170>H\u0087\n¢\u0006\u0002\bDJ.\u0010E\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010F\u001a\u00020G2\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0002\bHR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006K"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$Builder;", "(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$Builder;)V", "value", "", "aggregateValue", "getAggregateValue", "()Ljava/lang/String;", "setAggregateValue", "(Ljava/lang/String;)V", "", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "(D)V", "identifierValue", "getIdentifierValue", "setIdentifierValue", "name", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;", "Lcom/google/protobuf/UninterpretedOptionKt$Dsl$NameProxy;", "getName", "()Lcom/google/protobuf/kotlin/DslList;", "", "negativeIntValue", "getNegativeIntValue", "()J", "setNegativeIntValue", "(J)V", "positiveIntValue", "getPositiveIntValue", "setPositiveIntValue", "Lcom/google/protobuf/ByteString;", "stringValue", "getStringValue", "()Lcom/google/protobuf/ByteString;", "setStringValue", "(Lcom/google/protobuf/ByteString;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "clearAggregateValue", "", "clearDoubleValue", "clearIdentifierValue", "clearNegativeIntValue", "clearPositiveIntValue", "clearStringValue", "hasAggregateValue", "", "hasDoubleValue", "hasIdentifierValue", "hasNegativeIntValue", "hasPositiveIntValue", "hasStringValue", "add", "addName", "addAll", "values", "", "addAllName", "clear", "clearName", "plusAssign", "plusAssignName", "plusAssignAllName", "set", "index", "", "setName", "Companion", "NameProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.UninterpretedOption.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/UninterpretedOptionKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.UninterpretedOption.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$Dsl$NameProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class NameProxy extends DslProxy {
            private NameProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.UninterpretedOption.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.UninterpretedOption _build() {
            DescriptorProtos.UninterpretedOption uninterpretedOptionBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(uninterpretedOptionBuild, "_builder.build()");
            return uninterpretedOptionBuild;
        }

        @JvmName(name = "addAllName")
        public final /* synthetic */ void addAllName(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllName(values);
        }

        @JvmName(name = "addName")
        public final /* synthetic */ void addName(DslList dslList, DescriptorProtos.UninterpretedOption.NamePart value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addName(value);
        }

        public final void clearAggregateValue() {
            this._builder.clearAggregateValue();
        }

        public final void clearDoubleValue() {
            this._builder.clearDoubleValue();
        }

        public final void clearIdentifierValue() {
            this._builder.clearIdentifierValue();
        }

        @JvmName(name = "clearName")
        public final /* synthetic */ void clearName(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearName();
        }

        public final void clearNegativeIntValue() {
            this._builder.clearNegativeIntValue();
        }

        public final void clearPositiveIntValue() {
            this._builder.clearPositiveIntValue();
        }

        public final void clearStringValue() {
            this._builder.clearStringValue();
        }

        @JvmName(name = "getAggregateValue")
        public final String getAggregateValue() {
            String aggregateValue = this._builder.getAggregateValue();
            Intrinsics.checkNotNullExpressionValue(aggregateValue, "_builder.getAggregateValue()");
            return aggregateValue;
        }

        @JvmName(name = "getDoubleValue")
        public final double getDoubleValue() {
            return this._builder.getDoubleValue();
        }

        @JvmName(name = "getIdentifierValue")
        public final String getIdentifierValue() {
            String identifierValue = this._builder.getIdentifierValue();
            Intrinsics.checkNotNullExpressionValue(identifierValue, "_builder.getIdentifierValue()");
            return identifierValue;
        }

        public final /* synthetic */ DslList getName() {
            List<DescriptorProtos.UninterpretedOption.NamePart> nameList = this._builder.getNameList();
            Intrinsics.checkNotNullExpressionValue(nameList, "_builder.getNameList()");
            return new DslList(nameList);
        }

        @JvmName(name = "getNegativeIntValue")
        public final long getNegativeIntValue() {
            return this._builder.getNegativeIntValue();
        }

        @JvmName(name = "getPositiveIntValue")
        public final long getPositiveIntValue() {
            return this._builder.getPositiveIntValue();
        }

        @JvmName(name = "getStringValue")
        public final ByteString getStringValue() {
            ByteString stringValue = this._builder.getStringValue();
            Intrinsics.checkNotNullExpressionValue(stringValue, "_builder.getStringValue()");
            return stringValue;
        }

        public final boolean hasAggregateValue() {
            return this._builder.hasAggregateValue();
        }

        public final boolean hasDoubleValue() {
            return this._builder.hasDoubleValue();
        }

        public final boolean hasIdentifierValue() {
            return this._builder.hasIdentifierValue();
        }

        public final boolean hasNegativeIntValue() {
            return this._builder.hasNegativeIntValue();
        }

        public final boolean hasPositiveIntValue() {
            return this._builder.hasPositiveIntValue();
        }

        public final boolean hasStringValue() {
            return this._builder.hasStringValue();
        }

        @JvmName(name = "plusAssignAllName")
        public final /* synthetic */ void plusAssignAllName(DslList<DescriptorProtos.UninterpretedOption.NamePart, NameProxy> dslList, Iterable<DescriptorProtos.UninterpretedOption.NamePart> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllName(dslList, values);
        }

        @JvmName(name = "plusAssignName")
        public final /* synthetic */ void plusAssignName(DslList<DescriptorProtos.UninterpretedOption.NamePart, NameProxy> dslList, DescriptorProtos.UninterpretedOption.NamePart value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addName(dslList, value);
        }

        @JvmName(name = "setAggregateValue")
        public final void setAggregateValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAggregateValue(value);
        }

        @JvmName(name = "setDoubleValue")
        public final void setDoubleValue(double d7) {
            this._builder.setDoubleValue(d7);
        }

        @JvmName(name = "setIdentifierValue")
        public final void setIdentifierValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIdentifierValue(value);
        }

        @JvmName(name = "setName")
        public final /* synthetic */ void setName(DslList dslList, int i8, DescriptorProtos.UninterpretedOption.NamePart value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(i8, value);
        }

        @JvmName(name = "setNegativeIntValue")
        public final void setNegativeIntValue(long j8) {
            this._builder.setNegativeIntValue(j8);
        }

        @JvmName(name = "setPositiveIntValue")
        public final void setPositiveIntValue(long j8) {
            this._builder.setPositiveIntValue(j8);
        }

        @JvmName(name = "setStringValue")
        public final void setStringValue(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStringValue(value);
        }

        private Dsl(DescriptorProtos.UninterpretedOption.Builder builder) {
            this._builder = builder;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class NamePartKt {
        public static final NamePartKt INSTANCE = new NamePartKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder;", "(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder;)V", "value", "", "isExtension", "getIsExtension", "()Z", "setIsExtension", "(Z)V", "", "namePart", "getNamePart", "()Ljava/lang/String;", "setNamePart", "(Ljava/lang/String;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart;", "clearIsExtension", "", "clearNamePart", "hasIsExtension", "hasNamePart", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.UninterpretedOption.NamePart.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/UninterpretedOptionKt$NamePartKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$NamePart$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.UninterpretedOption.NamePart.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.UninterpretedOption.NamePart.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.UninterpretedOption.NamePart _build() {
                DescriptorProtos.UninterpretedOption.NamePart namePartBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(namePartBuild, "_builder.build()");
                return namePartBuild;
            }

            public final void clearIsExtension() {
                this._builder.clearIsExtension();
            }

            public final void clearNamePart() {
                this._builder.clearNamePart();
            }

            @JvmName(name = "getIsExtension")
            public final boolean getIsExtension() {
                return this._builder.getIsExtension();
            }

            @JvmName(name = "getNamePart")
            public final String getNamePart() {
                String namePart = this._builder.getNamePart();
                Intrinsics.checkNotNullExpressionValue(namePart, "_builder.getNamePart()");
                return namePart;
            }

            public final boolean hasIsExtension() {
                return this._builder.hasIsExtension();
            }

            public final boolean hasNamePart() {
                return this._builder.hasNamePart();
            }

            @JvmName(name = "setIsExtension")
            public final void setIsExtension(boolean z2) {
                this._builder.setIsExtension(z2);
            }

            @JvmName(name = "setNamePart")
            public final void setNamePart(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setNamePart(value);
            }

            private Dsl(DescriptorProtos.UninterpretedOption.NamePart.Builder builder) {
                this._builder = builder;
            }
        }

        private NamePartKt() {
        }
    }

    private UninterpretedOptionKt() {
    }

    @JvmName(name = "-initializenamePart")
    /* JADX INFO: renamed from: -initializenamePart, reason: not valid java name */
    public final DescriptorProtos.UninterpretedOption.NamePart m123initializenamePart(Function1<? super NamePartKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NamePartKt.Dsl.Companion companion = NamePartKt.Dsl.INSTANCE;
        DescriptorProtos.UninterpretedOption.NamePart.Builder builderNewBuilder = DescriptorProtos.UninterpretedOption.NamePart.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        NamePartKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
