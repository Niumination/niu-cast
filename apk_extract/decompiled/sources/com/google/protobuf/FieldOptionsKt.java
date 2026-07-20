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
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt;", "", "()V", "editionDefault", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeeditionDefault", "Dsl", "EditionDefaultKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFieldOptionsKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FieldOptionsKt.kt\ncom/google/protobuf/FieldOptionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,660:1\n1#2:661\n*E\n"})
public final class FieldOptionsKt {
    public static final FieldOptionsKt INSTANCE = new FieldOptionsKt();

    @Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u0089\u00012\u00020\u0001:\b\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010D\u001a\u00020EH\u0001J\u0018\u0010F\u001a\u00020G2\u0010\u0010H\u001a\f\u0012\u0004\u0012\u00020E\u0012\u0002\b\u00030IJ\u0006\u0010J\u001a\u00020GJ\u0006\u0010K\u001a\u00020GJ\u0006\u0010L\u001a\u00020GJ\u0006\u0010M\u001a\u00020GJ\u0006\u0010N\u001a\u00020GJ\u0006\u0010O\u001a\u00020GJ\u0006\u0010P\u001a\u00020GJ\u0006\u0010Q\u001a\u00020GJ\u0006\u0010R\u001a\u00020GJ\u0006\u0010S\u001a\u00020GJ\u001b\u0010T\u001a\u00020\f2\u0010\u0010H\u001a\f\u0012\u0004\u0012\u00020E\u0012\u0002\b\u00030IH\u0086\u0002J,\u0010U\u001a\u0002HV\"\b\b\u0000\u0010V*\u00020\u00012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u0002HV0IH\u0086\u0002¢\u0006\u0002\u0010WJ>\u0010U\u001a\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X\"\b\b\u0000\u0010Y*\u00020\u00012\u0018\u0010H\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\n\u0012\b\u0012\u0004\u0012\u0002HY0Z0IH\u0087\u0002¢\u0006\u0002\b[J\u0006\u0010\\\u001a\u00020\fJ\u0006\u0010]\u001a\u00020\fJ\u0006\u0010^\u001a\u00020\fJ\u0006\u0010_\u001a\u00020\fJ\u0006\u0010`\u001a\u00020\fJ\u0006\u0010a\u001a\u00020\fJ\u0006\u0010b\u001a\u00020\fJ\u0006\u0010c\u001a\u00020\fJ\u0006\u0010d\u001a\u00020\fJ\u0006\u0010e\u001a\u00020\fJ4\u0010f\u001a\u00020G\"\b\b\u0000\u0010V*\u00020g2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u0002HV0I2\u0006\u0010\u0005\u001a\u0002HVH\u0086\n¢\u0006\u0002\u0010hJ:\u0010f\u001a\u00020G\"\u000e\b\u0000\u0010V*\b\u0012\u0004\u0012\u0002HV0i2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u0002HV0I2\u0006\u0010\u0005\u001a\u0002HVH\u0086\n¢\u0006\u0002\u0010jJ%\u0010f\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020k0I2\u0006\u0010\u0005\u001a\u00020kH\u0086\nJ1\u0010l\u001a\u00020G\"\b\b\u0000\u0010V*\u00020\u00012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u0002HV0I2\u0006\u0010\u0005\u001a\u0002HV¢\u0006\u0002\u0010mJ%\u0010n\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0007¢\u0006\u0002\boJ%\u0010n\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00162\u0006\u0010\u0005\u001a\u000204H\u0007¢\u0006\u0002\bpJ%\u0010n\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00162\u0006\u0010\u0005\u001a\u000208H\u0007¢\u0006\u0002\bqJ-\u0010n\u001a\u00020G\"\b\b\u0000\u0010Y*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X2\u0006\u0010\u0005\u001a\u0002HY¢\u0006\u0002\u0010rJ+\u0010s\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00170uH\u0007¢\u0006\u0002\bvJ+\u0010s\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u0002040uH\u0007¢\u0006\u0002\bwJ+\u0010s\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u0002080uH\u0007¢\u0006\u0002\bxJ.\u0010s\u001a\u00020G\"\b\b\u0000\u0010Y*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X2\f\u0010t\u001a\b\u0012\u0004\u0012\u0002HY0uJ\u001d\u0010F\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0007¢\u0006\u0002\byJ\u001d\u0010F\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u0016H\u0007¢\u0006\u0002\bzJ\u001d\u0010F\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u0016H\u0007¢\u0006\u0002\b{J\u0017\u0010F\u001a\u00020G*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020E0XH\u0086\bJ&\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\n¢\u0006\u0002\b}J,\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00170uH\u0087\n¢\u0006\u0002\b~J&\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00162\u0006\u0010\u0005\u001a\u000204H\u0087\n¢\u0006\u0002\b\u007fJ-\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u0002040uH\u0087\n¢\u0006\u0003\b\u0080\u0001J'\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00162\u0006\u0010\u0005\u001a\u000208H\u0087\n¢\u0006\u0003\b\u0081\u0001J-\u0010|\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00162\f\u0010t\u001a\b\u0012\u0004\u0012\u0002080uH\u0087\n¢\u0006\u0003\b\u0082\u0001J0\u0010|\u001a\u00020G\"\b\b\u0000\u0010Y*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X2\u0006\u0010\u0005\u001a\u0002HYH\u0086\n¢\u0006\u0002\u0010rJ1\u0010|\u001a\u00020G\"\b\b\u0000\u0010Y*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X2\f\u0010t\u001a\b\u0012\u0004\u0012\u0002HY0uH\u0086\nJ1\u0010f\u001a\u00020G*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u0005\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0003\b\u0085\u0001J1\u0010f\u001a\u00020G*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00162\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u0005\u001a\u000204H\u0087\u0002¢\u0006\u0003\b\u0086\u0001J1\u0010f\u001a\u00020G*\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00162\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u0005\u001a\u000208H\u0087\u0002¢\u0006\u0003\b\u0087\u0001J;\u0010f\u001a\u00020G\"\b\b\u0000\u0010Y*\u00020\u0001*\u000e\u0012\u0004\u0012\u0002HY\u0012\u0004\u0012\u00020E0X2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010\u0005\u001a\u0002HYH\u0086\u0002¢\u0006\u0003\u0010\u0088\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R$\u0010*\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R$\u0010.\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020-8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002050\u00168F¢\u0006\u0006\u001a\u0004\b6\u0010\u001aR\u001d\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u00168F¢\u0006\u0006\u001a\u0004\b:\u0010\u001aR$\u0010;\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R$\u0010>\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R\u0017\u0010A\u001a\u0004\u0018\u00010\u001b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006\u008d\u0001"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;", "ctype", "getCtype", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;", "setCtype", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$CType;)V", "", "debugRedact", "getDebugRedact", "()Z", "setDebugRedact", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "editionDefaults", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$EditionDefaultsProxy;", "getEditionDefaults", "()Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "features", "getFeatures", "()Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "setFeatures", "(Lcom/google/protobuf/DescriptorProtos$FeatureSet;)V", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;", "jstype", "getJstype", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;", "setJstype", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$JSType;)V", "lazy", "getLazy", "setLazy", "packed", "getPacked", "setPacked", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;", "retention", "getRetention", "()Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;", "setRetention", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionRetention;)V", "targets", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$OptionTargetType;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$TargetsProxy;", "getTargets", "uninterpretedOption", "Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;", "Lcom/google/protobuf/FieldOptionsKt$Dsl$UninterpretedOptionProxy;", "getUninterpretedOption", "unverifiedLazy", "getUnverifiedLazy", "setUnverifiedLazy", "weak", "getWeak", "setWeak", "featuresOrNull", "getFeaturesOrNull", "(Lcom/google/protobuf/FieldOptionsKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FeatureSet;", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldOptions;", "clear", "", "extension", "Lcom/google/protobuf/ExtensionLite;", "clearCtype", "clearDebugRedact", "clearDeprecated", "clearFeatures", "clearJstype", "clearLazy", "clearPacked", "clearRetention", "clearUnverifiedLazy", "clearWeak", "contains", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", "Lcom/google/protobuf/kotlin/ExtensionList;", ExifInterface.LONGITUDE_EAST, "", "-getRepeatedExtension", "hasCtype", "hasDebugRedact", "hasDeprecated", "hasFeatures", "hasJstype", "hasLazy", "hasPacked", "hasRetention", "hasUnverifiedLazy", "hasWeak", "set", "Lcom/google/protobuf/MessageLite;", "(Lcom/google/protobuf/ExtensionLite;Lcom/google/protobuf/MessageLite;)V", "", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Comparable;)V", "Lcom/google/protobuf/ByteString;", "setExtension", "(Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "add", "addEditionDefaults", "addTargets", "addUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;Ljava/lang/Object;)V", "addAll", "values", "", "addAllEditionDefaults", "addAllTargets", "addAllUninterpretedOption", "clearEditionDefaults", "clearTargets", "clearUninterpretedOption", "plusAssign", "plusAssignEditionDefaults", "plusAssignAllEditionDefaults", "plusAssignTargets", "plusAssignAllTargets", "plusAssignUninterpretedOption", "plusAssignAllUninterpretedOption", "index", "", "setEditionDefaults", "setTargets", "setUninterpretedOption", "(Lcom/google/protobuf/kotlin/ExtensionList;ILjava/lang/Object;)V", "Companion", "EditionDefaultsProxy", "TargetsProxy", "UninterpretedOptionProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FieldOptions.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldOptionsKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.FieldOptions.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$EditionDefaultsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class EditionDefaultsProxy extends DslProxy {
            private EditionDefaultsProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$TargetsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class TargetsProxy extends DslProxy {
            private TargetsProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$Dsl$UninterpretedOptionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class UninterpretedOptionProxy extends DslProxy {
            private UninterpretedOptionProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.FieldOptions.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @JvmName(name = "-getRepeatedExtension")
        /* JADX INFO: renamed from: -getRepeatedExtension, reason: not valid java name */
        public final /* synthetic */ ExtensionList m87getRepeatedExtension(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Object extension2 = this._builder.getExtension((ExtensionLite<MessageT, Object>) extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "_builder.getExtension(extension)");
            return new ExtensionList(extension, (List) extension2);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.FieldOptions _build() {
            DescriptorProtos.FieldOptions fieldOptionsBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fieldOptionsBuild, "_builder.build()");
            return fieldOptionsBuild;
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

        @JvmName(name = "addAllEditionDefaults")
        public final /* synthetic */ void addAllEditionDefaults(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllEditionDefaults(values);
        }

        @JvmName(name = "addAllTargets")
        public final /* synthetic */ void addAllTargets(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllTargets(values);
        }

        @JvmName(name = "addAllUninterpretedOption")
        public final /* synthetic */ void addAllUninterpretedOption(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllUninterpretedOption(values);
        }

        @JvmName(name = "addEditionDefaults")
        public final /* synthetic */ void addEditionDefaults(DslList dslList, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addEditionDefaults(value);
        }

        @JvmName(name = "addTargets")
        public final /* synthetic */ void addTargets(DslList dslList, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addTargets(value);
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

        public final void clearCtype() {
            this._builder.clearCtype();
        }

        public final void clearDebugRedact() {
            this._builder.clearDebugRedact();
        }

        public final void clearDeprecated() {
            this._builder.clearDeprecated();
        }

        @JvmName(name = "clearEditionDefaults")
        public final /* synthetic */ void clearEditionDefaults(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearEditionDefaults();
        }

        public final void clearFeatures() {
            this._builder.clearFeatures();
        }

        public final void clearJstype() {
            this._builder.clearJstype();
        }

        public final void clearLazy() {
            this._builder.clearLazy();
        }

        public final void clearPacked() {
            this._builder.clearPacked();
        }

        public final void clearRetention() {
            this._builder.clearRetention();
        }

        @JvmName(name = "clearTargets")
        public final /* synthetic */ void clearTargets(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearTargets();
        }

        @JvmName(name = "clearUninterpretedOption")
        public final /* synthetic */ void clearUninterpretedOption(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearUninterpretedOption();
        }

        public final void clearUnverifiedLazy() {
            this._builder.clearUnverifiedLazy();
        }

        public final void clearWeak() {
            this._builder.clearWeak();
        }

        public final /* synthetic */ boolean contains(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            return this._builder.hasExtension(extension);
        }

        public final /* synthetic */ Object get(ExtensionLite extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (extension.isRepeated()) {
                Object obj = get(extension);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.google.protobuf.FieldOptionsKt.Dsl.get");
                return obj;
            }
            Object extension2 = this._builder.getExtension((ExtensionLite<MessageT, Object>) extension);
            Intrinsics.checkNotNullExpressionValue(extension2, "{\n        _builder.getExtension(extension)\n      }");
            return extension2;
        }

        @JvmName(name = "getCtype")
        public final DescriptorProtos.FieldOptions.CType getCtype() {
            DescriptorProtos.FieldOptions.CType ctype = this._builder.getCtype();
            Intrinsics.checkNotNullExpressionValue(ctype, "_builder.getCtype()");
            return ctype;
        }

        @JvmName(name = "getDebugRedact")
        public final boolean getDebugRedact() {
            return this._builder.getDebugRedact();
        }

        @JvmName(name = "getDeprecated")
        public final boolean getDeprecated() {
            return this._builder.getDeprecated();
        }

        public final /* synthetic */ DslList getEditionDefaults() {
            List<DescriptorProtos.FieldOptions.EditionDefault> editionDefaultsList = this._builder.getEditionDefaultsList();
            Intrinsics.checkNotNullExpressionValue(editionDefaultsList, "_builder.getEditionDefaultsList()");
            return new DslList(editionDefaultsList);
        }

        @JvmName(name = "getFeatures")
        public final DescriptorProtos.FeatureSet getFeatures() {
            DescriptorProtos.FeatureSet features = this._builder.getFeatures();
            Intrinsics.checkNotNullExpressionValue(features, "_builder.getFeatures()");
            return features;
        }

        public final DescriptorProtos.FeatureSet getFeaturesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FieldOptionsKtKt.getFeaturesOrNull(dsl._builder);
        }

        @JvmName(name = "getJstype")
        public final DescriptorProtos.FieldOptions.JSType getJstype() {
            DescriptorProtos.FieldOptions.JSType jstype = this._builder.getJstype();
            Intrinsics.checkNotNullExpressionValue(jstype, "_builder.getJstype()");
            return jstype;
        }

        @JvmName(name = "getLazy")
        public final boolean getLazy() {
            return this._builder.getLazy();
        }

        @JvmName(name = "getPacked")
        public final boolean getPacked() {
            return this._builder.getPacked();
        }

        @JvmName(name = "getRetention")
        public final DescriptorProtos.FieldOptions.OptionRetention getRetention() {
            DescriptorProtos.FieldOptions.OptionRetention retention = this._builder.getRetention();
            Intrinsics.checkNotNullExpressionValue(retention, "_builder.getRetention()");
            return retention;
        }

        public final /* synthetic */ DslList getTargets() {
            List<DescriptorProtos.FieldOptions.OptionTargetType> targetsList = this._builder.getTargetsList();
            Intrinsics.checkNotNullExpressionValue(targetsList, "_builder.getTargetsList()");
            return new DslList(targetsList);
        }

        public final /* synthetic */ DslList getUninterpretedOption() {
            List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = this._builder.getUninterpretedOptionList();
            Intrinsics.checkNotNullExpressionValue(uninterpretedOptionList, "_builder.getUninterpretedOptionList()");
            return new DslList(uninterpretedOptionList);
        }

        @JvmName(name = "getUnverifiedLazy")
        public final boolean getUnverifiedLazy() {
            return this._builder.getUnverifiedLazy();
        }

        @JvmName(name = "getWeak")
        public final boolean getWeak() {
            return this._builder.getWeak();
        }

        public final boolean hasCtype() {
            return this._builder.hasCtype();
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

        public final boolean hasJstype() {
            return this._builder.hasJstype();
        }

        public final boolean hasLazy() {
            return this._builder.hasLazy();
        }

        public final boolean hasPacked() {
            return this._builder.hasPacked();
        }

        public final boolean hasRetention() {
            return this._builder.hasRetention();
        }

        public final boolean hasUnverifiedLazy() {
            return this._builder.hasUnverifiedLazy();
        }

        public final boolean hasWeak() {
            return this._builder.hasWeak();
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FieldOptions> extensionList, E value) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(extensionList, value);
        }

        @JvmName(name = "plusAssignAllEditionDefaults")
        public final /* synthetic */ void plusAssignAllEditionDefaults(DslList<DescriptorProtos.FieldOptions.EditionDefault, EditionDefaultsProxy> dslList, Iterable<DescriptorProtos.FieldOptions.EditionDefault> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllEditionDefaults(dslList, values);
        }

        @JvmName(name = "plusAssignAllTargets")
        public final /* synthetic */ void plusAssignAllTargets(DslList<DescriptorProtos.FieldOptions.OptionTargetType, TargetsProxy> dslList, Iterable<? extends DescriptorProtos.FieldOptions.OptionTargetType> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllTargets(dslList, values);
        }

        @JvmName(name = "plusAssignAllUninterpretedOption")
        public final /* synthetic */ void plusAssignAllUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, Iterable<DescriptorProtos.UninterpretedOption> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllUninterpretedOption(dslList, values);
        }

        @JvmName(name = "plusAssignEditionDefaults")
        public final /* synthetic */ void plusAssignEditionDefaults(DslList<DescriptorProtos.FieldOptions.EditionDefault, EditionDefaultsProxy> dslList, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addEditionDefaults(dslList, value);
        }

        @JvmName(name = "plusAssignTargets")
        public final /* synthetic */ void plusAssignTargets(DslList<DescriptorProtos.FieldOptions.OptionTargetType, TargetsProxy> dslList, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addTargets(dslList, value);
        }

        @JvmName(name = "plusAssignUninterpretedOption")
        public final /* synthetic */ void plusAssignUninterpretedOption(DslList<DescriptorProtos.UninterpretedOption, UninterpretedOptionProxy> dslList, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addUninterpretedOption(dslList, value);
        }

        public final /* synthetic */ <T extends Comparable<? super T>> void set(ExtensionLite<DescriptorProtos.FieldOptions, T> extension, T value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        @JvmName(name = "setCtype")
        public final void setCtype(DescriptorProtos.FieldOptions.CType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCtype(value);
        }

        @JvmName(name = "setDebugRedact")
        public final void setDebugRedact(boolean z2) {
            this._builder.setDebugRedact(z2);
        }

        @JvmName(name = "setDeprecated")
        public final void setDeprecated(boolean z2) {
            this._builder.setDeprecated(z2);
        }

        @JvmName(name = "setEditionDefaults")
        public final /* synthetic */ void setEditionDefaults(DslList dslList, int i8, DescriptorProtos.FieldOptions.EditionDefault value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEditionDefaults(i8, value);
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

        @JvmName(name = "setJstype")
        public final void setJstype(DescriptorProtos.FieldOptions.JSType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJstype(value);
        }

        @JvmName(name = "setLazy")
        public final void setLazy(boolean z2) {
            this._builder.setLazy(z2);
        }

        @JvmName(name = "setPacked")
        public final void setPacked(boolean z2) {
            this._builder.setPacked(z2);
        }

        @JvmName(name = "setRetention")
        public final void setRetention(DescriptorProtos.FieldOptions.OptionRetention value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRetention(value);
        }

        @JvmName(name = "setTargets")
        public final /* synthetic */ void setTargets(DslList dslList, int i8, DescriptorProtos.FieldOptions.OptionTargetType value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTargets(i8, value);
        }

        @JvmName(name = "setUninterpretedOption")
        public final /* synthetic */ void setUninterpretedOption(DslList dslList, int i8, DescriptorProtos.UninterpretedOption value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUninterpretedOption(i8, value);
        }

        @JvmName(name = "setUnverifiedLazy")
        public final void setUnverifiedLazy(boolean z2) {
            this._builder.setUnverifiedLazy(z2);
        }

        @JvmName(name = "setWeak")
        public final void setWeak(boolean z2) {
            this._builder.setWeak(z2);
        }

        private Dsl(DescriptorProtos.FieldOptions.Builder builder) {
            this._builder = builder;
        }

        public final /* synthetic */ void clear(ExtensionList<?, DescriptorProtos.FieldOptions> extensionList) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            clear(extensionList.getExtension());
        }

        public final /* synthetic */ <E> void plusAssign(ExtensionList<E, DescriptorProtos.FieldOptions> extensionList, Iterable<? extends E> values) {
            Intrinsics.checkNotNullParameter(extensionList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAll(extensionList, values);
        }

        public final /* synthetic */ void set(ExtensionLite<DescriptorProtos.FieldOptions, ByteString> extension, ByteString value) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            Intrinsics.checkNotNullParameter(value, "value");
            setExtension(extension, value);
        }

        public final /* synthetic */ <T extends MessageLite> void set(ExtensionLite<DescriptorProtos.FieldOptions, T> extension, T value) {
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class EditionDefaultKt {
        public static final EditionDefaultKt INSTANCE = new EditionDefaultKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;)V", "value", "Lcom/google/protobuf/DescriptorProtos$Edition;", "edition", "getEdition", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setEdition", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "_build", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault;", "clearEdition", "", "clearValue", "hasEdition", "", "hasValue", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.FieldOptions.EditionDefault.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FieldOptionsKt$EditionDefaultKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FieldOptions$EditionDefault$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.FieldOptions.EditionDefault.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.FieldOptions.EditionDefault.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.FieldOptions.EditionDefault _build() {
                DescriptorProtos.FieldOptions.EditionDefault editionDefaultBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(editionDefaultBuild, "_builder.build()");
                return editionDefaultBuild;
            }

            public final void clearEdition() {
                this._builder.clearEdition();
            }

            public final void clearValue() {
                this._builder.clearValue();
            }

            @JvmName(name = "getEdition")
            public final DescriptorProtos.Edition getEdition() {
                DescriptorProtos.Edition edition = this._builder.getEdition();
                Intrinsics.checkNotNullExpressionValue(edition, "_builder.getEdition()");
                return edition;
            }

            @JvmName(name = "getValue")
            public final String getValue() {
                String value = this._builder.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "_builder.getValue()");
                return value;
            }

            public final boolean hasEdition() {
                return this._builder.hasEdition();
            }

            public final boolean hasValue() {
                return this._builder.hasValue();
            }

            @JvmName(name = "setEdition")
            public final void setEdition(DescriptorProtos.Edition value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEdition(value);
            }

            @JvmName(name = "setValue")
            public final void setValue(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setValue(value);
            }

            private Dsl(DescriptorProtos.FieldOptions.EditionDefault.Builder builder) {
                this._builder = builder;
            }
        }

        private EditionDefaultKt() {
        }
    }

    private FieldOptionsKt() {
    }

    @JvmName(name = "-initializeeditionDefault")
    /* JADX INFO: renamed from: -initializeeditionDefault, reason: not valid java name */
    public final DescriptorProtos.FieldOptions.EditionDefault m86initializeeditionDefault(Function1<? super EditionDefaultKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EditionDefaultKt.Dsl.Companion companion = EditionDefaultKt.Dsl.INSTANCE;
        DescriptorProtos.FieldOptions.EditionDefault.Builder builderNewBuilder = DescriptorProtos.FieldOptions.EditionDefault.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EditionDefaultKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
