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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt;", "", "()V", "featureSetEditionDefault", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializefeatureSetEditionDefault", "Dsl", "FeatureSetEditionDefaultKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFeatureSetDefaultsKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureSetDefaultsKt.kt\ncom/google/protobuf/FeatureSetDefaultsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,235:1\n1#2:236\n*E\n"})
public final class FeatureSetDefaultsKt {
    public static final FeatureSetDefaultsKt INSTANCE = new FeatureSetDefaultsKt();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ%\u0010\u001d\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001eJ+\u0010\u001f\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0007¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b$J&\u0010%\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b&J,\u0010%\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0087\n¢\u0006\u0002\b'J.\u0010(\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006."}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$Builder;)V", "defaults", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault;", "Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl$DefaultsProxy;", "getDefaults", "()Lcom/google/protobuf/kotlin/DslList;", "value", "Lcom/google/protobuf/DescriptorProtos$Edition;", "maximumEdition", "getMaximumEdition", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setMaximumEdition", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "minimumEdition", "getMinimumEdition", "setMinimumEdition", "_build", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults;", "clearMaximumEdition", "", "clearMinimumEdition", "hasMaximumEdition", "", "hasMinimumEdition", "add", "addDefaults", "addAll", "values", "", "addAllDefaults", "clear", "clearDefaults", "plusAssign", "plusAssignDefaults", "plusAssignAllDefaults", "set", "index", "", "setDefaults", "Companion", "DefaultsProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FeatureSetDefaults.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.FeatureSetDefaults.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$Dsl$DefaultsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class DefaultsProxy extends DslProxy {
            private DefaultsProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.FeatureSetDefaults.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.FeatureSetDefaults _build() {
            DescriptorProtos.FeatureSetDefaults featureSetDefaultsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(featureSetDefaultsBuild, "_builder.build()");
            return featureSetDefaultsBuild;
        }

        @JvmName(name = "addAllDefaults")
        public final /* synthetic */ void addAllDefaults(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllDefaults(values);
        }

        @JvmName(name = "addDefaults")
        public final /* synthetic */ void addDefaults(DslList dslList, DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addDefaults(value);
        }

        @JvmName(name = "clearDefaults")
        public final /* synthetic */ void clearDefaults(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearDefaults();
        }

        public final void clearMaximumEdition() {
            this._builder.clearMaximumEdition();
        }

        public final void clearMinimumEdition() {
            this._builder.clearMinimumEdition();
        }

        public final /* synthetic */ DslList getDefaults() {
            List<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault> defaultsList = this._builder.getDefaultsList();
            Intrinsics.checkNotNullExpressionValue(defaultsList, "_builder.getDefaultsList()");
            return new DslList(defaultsList);
        }

        @JvmName(name = "getMaximumEdition")
        public final DescriptorProtos.Edition getMaximumEdition() {
            DescriptorProtos.Edition maximumEdition = this._builder.getMaximumEdition();
            Intrinsics.checkNotNullExpressionValue(maximumEdition, "_builder.getMaximumEdition()");
            return maximumEdition;
        }

        @JvmName(name = "getMinimumEdition")
        public final DescriptorProtos.Edition getMinimumEdition() {
            DescriptorProtos.Edition minimumEdition = this._builder.getMinimumEdition();
            Intrinsics.checkNotNullExpressionValue(minimumEdition, "_builder.getMinimumEdition()");
            return minimumEdition;
        }

        public final boolean hasMaximumEdition() {
            return this._builder.hasMaximumEdition();
        }

        public final boolean hasMinimumEdition() {
            return this._builder.hasMinimumEdition();
        }

        @JvmName(name = "plusAssignAllDefaults")
        public final /* synthetic */ void plusAssignAllDefaults(DslList<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault, DefaultsProxy> dslList, Iterable<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllDefaults(dslList, values);
        }

        @JvmName(name = "plusAssignDefaults")
        public final /* synthetic */ void plusAssignDefaults(DslList<DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault, DefaultsProxy> dslList, DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addDefaults(dslList, value);
        }

        @JvmName(name = "setDefaults")
        public final /* synthetic */ void setDefaults(DslList dslList, int i8, DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDefaults(i8, value);
        }

        @JvmName(name = "setMaximumEdition")
        public final void setMaximumEdition(DescriptorProtos.Edition value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMaximumEdition(value);
        }

        @JvmName(name = "setMinimumEdition")
        public final void setMinimumEdition(DescriptorProtos.Edition value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMinimumEdition(value);
        }

        private Dsl(DescriptorProtos.FeatureSetDefaults.Builder builder) {
            this._builder = builder;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class FeatureSetEditionDefaultKt {
        public static final FeatureSetEditionDefaultKt INSTANCE = new FeatureSetEditionDefaultKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$Edition;", "edition", "getEdition", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setEdition", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault;", "clearEdition", "", "clearFeatures", "hasEdition", "", "hasFeatures", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FeatureSetDefaultsKt$FeatureSetEditionDefaultKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault _build() {
                DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault featureSetEditionDefaultBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(featureSetEditionDefaultBuild, "_builder.build()");
                return featureSetEditionDefaultBuild;
            }

            public final void clearEdition() {
                this._builder.clearEdition();
            }

            public final void clearFeatures() {
                this._builder.clearFeatures();
            }

            @JvmName(name = "getEdition")
            public final DescriptorProtos.Edition getEdition() {
                DescriptorProtos.Edition edition = this._builder.getEdition();
                Intrinsics.checkNotNullExpressionValue(edition, "_builder.getEdition()");
                return edition;
            }

            @JvmName(name = "getFeatures")
            public final DescriptorProtos.FeatureSet getFeatures() {
                DescriptorProtos.FeatureSet features = this._builder.getFeatures();
                Intrinsics.checkNotNullExpressionValue(features, "_builder.getFeatures()");
                return features;
            }

            public final DescriptorProtos.FeatureSet getFeaturesOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return FeatureSetDefaultsKtKt.getFeaturesOrNull(dsl._builder);
            }

            public final boolean hasEdition() {
                return this._builder.hasEdition();
            }

            public final boolean hasFeatures() {
                return this._builder.hasFeatures();
            }

            @JvmName(name = "setEdition")
            public final void setEdition(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEdition(value);
            }

            @JvmName(name = "setFeatures")
            public final void setFeatures(DescriptorProtos.FeatureSet value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFeatures(value);
            }

            private Dsl(DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder builder) {
                this._builder = builder;
            }
        }

        private FeatureSetEditionDefaultKt() {
        }
    }

    private FeatureSetDefaultsKt() {
    }

    @JvmName(name = "-initializefeatureSetEditionDefault")
    /* JADX INFO: renamed from: -initializefeatureSetEditionDefault, reason: not valid java name */
    public final DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault m79initializefeatureSetEditionDefault(Function1<? super FeatureSetEditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FeatureSetEditionDefaultKt.Dsl.Companion companion = FeatureSetEditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.Builder builderNewBuilder = DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FeatureSetEditionDefaultKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
