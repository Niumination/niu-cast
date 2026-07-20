package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ExtensionList;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumValueOptionsKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EnumValueOptionsKt {
    public static final EnumValueOptionsKt INSTANCE = new EnumValueOptionsKt();

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0018\u0010 \u001a\u00020!2\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u001f\u0012\u0002\b\u00030#J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020!J\u001b\u0010'\u001a\u00020\u00062\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00020\u001f\u0012\u0002\b\u00030#H\u0086\u0002J,\u0010(\u001a\u0002H)\"\b\b\u0000\u0010)*\u00020\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H)0#H\u0086\u0002¢\u0006\u0002\u0010*J>\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+\"\b\b\u0000\u0010,*\u00020\u00012\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H,0-0#H\u0087\u0002¢\u0006\u0002\b.J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u0006J4\u00102\u001a\u00020!\"\b\b\u0000\u0010)*\u0002032\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H)0#2\u0006\u0010\u0005\u001a\u0002H)H\u0086\n¢\u0006\u0002\u00104J:\u00102\u001a\u00020!\"\u000e\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H)0#2\u0006\u0010\u0005\u001a\u0002H)H\u0086\n¢\u0006\u0002\u00106J%\u00102\u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002070#2\u0006\u0010\u0005\u001a\u000207H\u0086\nJ1\u00108\u001a\u00020!\"\b\b\u0000\u0010)*\u00020\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H)0#2\u0006\u0010\u0005\u001a\u0002H)¢\u0006\u0002\u00109J%\u0010:\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0007¢\u0006\u0002\b;J-\u0010:\u001a\u00020!\"\b\b\u0000\u0010,*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+2\u0006\u0010\u0005\u001a\u0002H,¢\u0006\u0002\u0010<J+\u0010=\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170?H\u0007¢\u0006\u0002\b@J.\u0010=\u001a\u00020!\"\b\b\u0000\u0010,*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H,0?J\u001d\u0010 \u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0007¢\u0006\u0002\bAJ\u0017\u0010 \u001a\u00020!*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u001f0+H\u0086\bJ&\u0010B\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\n¢\u0006\u0002\bCJ,\u0010B\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170?H\u0087\n¢\u0006\u0002\bDJ0\u0010B\u001a\u00020!\"\b\b\u0000\u0010,*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+2\u0006\u0010\u0005\u001a\u0002H,H\u0086\n¢\u0006\u0002\u0010<J1\u0010B\u001a\u00020!\"\b\b\u0000\u0010,*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H,0?H\u0086\nJ.\u00102\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0002\bGJ8\u00102\u001a\u00020!\"\b\b\u0000\u0010,*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001f0+2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0005\u001a\u0002H,H\u0086\u0002¢\u0006\u0002\u0010HR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u000f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006K"}, d2 = {"Lcom/google/protobuf/EnumValueOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$EnumValueOptions$Builder;)V", "value", "", "debugRedact", "getDebugRedact", "()Z", "setDebugRedact", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "uninterpretedOption", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/EnumValueOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "()Lcom/google/protobuf/kotlin/DslList;", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/EnumValueOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearDebugRedact", "clearDeprecated", "clearFeatures", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasDebugRedact", "hasDeprecated", "hasFeatures", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllUninterpretedOption", "clearUninterpretedOption", "plusAssign", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", "index", "", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.EnumValueOptions.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumValueOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumValueOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$EnumValueOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.EnumValueOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumValueOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class UninterpretedOptionProxy extends DslProxy {
            private UninterpretedOptionProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.EnumValueOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @JvmName(name = "-getRepeatedExtension")
        /* JADX INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m74getRepeatedExtension(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Object extension2 = this._builder.getExtension((ExtensionLite<MessageT, Object>) extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "_builder.getExtension(extension)");
            return new ExtensionList(extension, (List) extension2);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.EnumValueOptions _build() {
            DescriptorProtos.EnumValueOptions enumValueOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumValueOptionsBuild, "_builder.build()");
            return enumValueOptionsBuild;
        }

        public final /* synthetic */ void add(ExtensionList extensionList, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension((ExtensionLite<MessageT, List<Object>>) extensionList.getExtension(), value);
        }

        public final /* synthetic */ void addAll(ExtensionList extensionList, Iterable values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                add(extensionList, it.next());
            }
        }

        @JvmName(name = "addAllUninterpretedOption")
        public final /* synthetic */ void addAllUninterpretedOption(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllUninterpretedOption(values);
        }

        @JvmName(name = "addUninterpretedOption")
        public final /* synthetic */ void addUninterpretedOption(DslList dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addUninterpretedOption(value);
        }

        public final /* synthetic */ void clear(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            this._builder.clearExtension(extension);
        }

        public final void clearDebugRedact() {
            this._builder.clearDebugRedact();
        }

        public final void clearDeprecated() {
            this._builder.clearDeprecated();
        }

        public final void clearFeatures() {
            this._builder.clearFeatures();
        }

        @JvmName(name = "clearUninterpretedOption")
        public final /* synthetic */ void clearUninterpretedOption(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearUninterpretedOption();
        }

        public final /* synthetic */ boolean contains(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            return this._builder.hasExtension(extension);
        }

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.EnumValueOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension((ExtensionLite<MessageT, Object>) extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        @JvmName(name = "getDebugRedact")
        public final boolean getDebugRedact() {
            return this._builder.getDebugRedact();
        }

        @JvmName(name = "getDeprecated")
        public final boolean getDeprecated() {
            return this._builder.getDeprecated();
        }

        @JvmName(name = "getFeatures")
        public final DescriptorProtos.FeatureSet getFeatures() {
            DescriptorProtos.FeatureSet features = this._builder.getFeatures();
            Intrinsics.checkNotNullExpressionValue(features, "_builder.getFeatures()");
            return features;
        }

        public final DescriptorProtos.FeatureSet getFeaturesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return EnumValueOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        public final /* synthetic */ DslList getUninterpretedOption() {
            List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = this._builder.getUninterpretedOptionList();
            Intrinsics.checkNotNullExpressionValue(uninterpretedOptionList, "_builder.getUninterpretedOptionList()");
            return new DslList(uninterpretedOptionList);
        }

        public final boolean hasDebugRedact() {
            return this._builder.hasDebugRedact();
        }

        public final boolean hasDeprecated() {
            return this._builder.hasDeprecated();
        }

        public final boolean hasFeatures() {
            return this._builder.hasFeatures();
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.EnumValueOptions> extensionList, E value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(extensionList, value);
        }

        @JvmName(name = "plusAssignAllUninterpretedOption")
        public final /* synthetic */ void plusAssignAllUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, Iterable<DescriptorProtos.UninterpretedOption> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllUninterpretedOption(dslList, values);
        }

        @JvmName(name = "plusAssignUninterpretedOption")
        public final /* synthetic */ void plusAssignUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addUninterpretedOption(dslList, value);
        }

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.EnumValueOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        @JvmName(name = "setDebugRedact")
        public final void setDebugRedact(boolean z2) {
            this._builder.setDebugRedact(z2);
        }

        @JvmName(name = "setDeprecated")
        public final void setDeprecated(boolean z2) {
            this._builder.setDeprecated(z2);
        }

        public final /* synthetic */ void setExtension(ExtensionLite extension, Object value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension((ExtensionLite<MessageT, Object>) extension, value);
        }

        @JvmName(name = "setFeatures")
        public final void setFeatures(DescriptorProtos.FeatureSet value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFeatures(value);
        }

        @JvmName(name = "setUninterpretedOption")
        public final /* synthetic */ void setUninterpretedOption(DslList dslList, int i8, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUninterpretedOption(i8, value);
        }

        private Dsl(DescriptorProtos.EnumValueOptions.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.EnumValueOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.EnumValueOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.EnumValueOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.EnumValueOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ void set(ExtensionList extensionList, int i8, Object value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension((ExtensionLite<MessageT, List<Object>>) extensionList.getExtension(), i8, value);
        }
    }

    private EnumValueOptionsKt() {
    }
}
