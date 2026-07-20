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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt;", "", "()V", "location", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializelocation", "Dsl", "LocationKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSourceCodeInfoKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SourceCodeInfoKt.kt\ncom/google/protobuf/SourceCodeInfoKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,382:1\n1#2:383\n*E\n"})
public final class SourceCodeInfoKt {
    public static final SourceCodeInfoKt INSTANCE = new SourceCodeInfoKt();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0001J%\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u0016J&\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u0018J,\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0087\n¢\u0006\u0002\b\u0019J.\u0010\u001a\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder;", "(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder;)V", "location", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;", "Lcom/google/protobuf/SourceCodeInfoKt$Dsl$LocationProxy;", "getLocation", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "add", "", "value", "addLocation", "addAll", "values", "", "addAllLocation", "clear", "clearLocation", "plusAssign", "plusAssignLocation", "plusAssignAllLocation", "set", "index", "", "setLocation", "Companion", "LocationProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.SourceCodeInfo.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/SourceCodeInfoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.SourceCodeInfo.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$Dsl$LocationProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class LocationProxy extends DslProxy {
            private LocationProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.SourceCodeInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.SourceCodeInfo _build() {
            DescriptorProtos.SourceCodeInfo sourceCodeInfoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(sourceCodeInfoBuild, "_builder.build()");
            return sourceCodeInfoBuild;
        }

        @JvmName(name = "addAllLocation")
        public final /* synthetic */ void addAllLocation(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllLocation(values);
        }

        @JvmName(name = "addLocation")
        public final /* synthetic */ void addLocation(DslList dslList, DescriptorProtos.SourceCodeInfo.Location value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addLocation(value);
        }

        @JvmName(name = "clearLocation")
        public final /* synthetic */ void clearLocation(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearLocation();
        }

        public final /* synthetic */ DslList getLocation() {
            List<DescriptorProtos.SourceCodeInfo.Location> locationList = this._builder.getLocationList();
            Intrinsics.checkNotNullExpressionValue(locationList, "_builder.getLocationList()");
            return new DslList(locationList);
        }

        @JvmName(name = "plusAssignAllLocation")
        public final /* synthetic */ void plusAssignAllLocation(DslList<DescriptorProtos.SourceCodeInfo.Location, LocationProxy> dslList, Iterable<DescriptorProtos.SourceCodeInfo.Location> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllLocation(dslList, values);
        }

        @JvmName(name = "plusAssignLocation")
        public final /* synthetic */ void plusAssignLocation(DslList<DescriptorProtos.SourceCodeInfo.Location, LocationProxy> dslList, DescriptorProtos.SourceCodeInfo.Location value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addLocation(dslList, value);
        }

        @JvmName(name = "setLocation")
        public final /* synthetic */ void setLocation(DslList dslList, int i8, DescriptorProtos.SourceCodeInfo.Location value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLocation(i8, value);
        }

        private Dsl(DescriptorProtos.SourceCodeInfo.Builder builder) {
            this._builder = builder;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class LocationKt {
        public static final LocationKt INSTANCE = new LocationKt();

        @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u0018\b\u0007\u0018\u0000 =2\u00020\u0001:\u0004=>?@B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J%\u0010#\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0005\u001a\u00020\u0012H\u0007¢\u0006\u0002\b$J%\u0010#\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r2\u0006\u0010\u0005\u001a\u00020\u0012H\u0007¢\u0006\u0002\b%J%\u0010#\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b&J+\u0010'\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120)H\u0007¢\u0006\u0002\b*J+\u0010'\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120)H\u0007¢\u0006\u0002\b+J+\u0010'\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0007¢\u0006\u0002\b,J\u001d\u0010-\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\rH\u0007¢\u0006\u0002\b.J\u001d\u0010-\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\rH\u0007¢\u0006\u0002\b/J\u001d\u0010-\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0002\b0J&\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0005\u001a\u00020\u0012H\u0087\n¢\u0006\u0002\b2J,\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120)H\u0087\n¢\u0006\u0002\b3J&\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r2\u0006\u0010\u0005\u001a\u00020\u0012H\u0087\n¢\u0006\u0002\b4J,\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120)H\u0087\n¢\u0006\u0002\b5J&\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\n¢\u0006\u0002\b6J,\u00101\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0087\n¢\u0006\u0002\b7J.\u00108\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r2\u0006\u00109\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0012H\u0087\u0002¢\u0006\u0002\b:J.\u00108\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r2\u0006\u00109\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0012H\u0087\u0002¢\u0006\u0002\b;J.\u00108\u001a\u00020\u001e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u00109\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006A"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder;", "(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder;)V", "value", "", "leadingComments", "getLeadingComments", "()Ljava/lang/String;", "setLeadingComments", "(Ljava/lang/String;)V", "leadingDetachedComments", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$LeadingDetachedCommentsProxy;", "getLeadingDetachedComments", "()Lcom/google/protobuf/kotlin/DslList;", "path", "", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$PathProxy;", "getPath", "span", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$SpanProxy;", "getSpan", "trailingComments", "getTrailingComments", "setTrailingComments", "_build", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location;", "clearLeadingComments", "", "clearTrailingComments", "hasLeadingComments", "", "hasTrailingComments", "add", "addPath", "addSpan", "addLeadingDetachedComments", "addAll", "values", "", "addAllPath", "addAllSpan", "addAllLeadingDetachedComments", "clear", "clearPath", "clearSpan", "clearLeadingDetachedComments", "plusAssign", "plusAssignPath", "plusAssignAllPath", "plusAssignSpan", "plusAssignAllSpan", "plusAssignLeadingDetachedComments", "plusAssignAllLeadingDetachedComments", "set", "index", "setPath", "setSpan", "setLeadingDetachedComments", "Companion", "LeadingDetachedCommentsProxy", "PathProxy", "SpanProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.SourceCodeInfo.Location.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo$Location$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.SourceCodeInfo.Location.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$LeadingDetachedCommentsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class LeadingDetachedCommentsProxy extends DslProxy {
                private LeadingDetachedCommentsProxy() {
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$PathProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class PathProxy extends DslProxy {
                private PathProxy() {
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/SourceCodeInfoKt$LocationKt$Dsl$SpanProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class SpanProxy extends DslProxy {
                private SpanProxy() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.SourceCodeInfo.Location.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.SourceCodeInfo.Location _build() {
                DescriptorProtos.SourceCodeInfo.Location locationBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(locationBuild, "_builder.build()");
                return locationBuild;
            }

            @JvmName(name = "addAllLeadingDetachedComments")
            public final /* synthetic */ void addAllLeadingDetachedComments(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllLeadingDetachedComments(values);
            }

            @JvmName(name = "addAllPath")
            public final /* synthetic */ void addAllPath(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllPath(values);
            }

            @JvmName(name = "addAllSpan")
            public final /* synthetic */ void addAllSpan(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllSpan(values);
            }

            @JvmName(name = "addLeadingDetachedComments")
            public final /* synthetic */ void addLeadingDetachedComments(DslList dslList, String value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addLeadingDetachedComments(value);
            }

            @JvmName(name = "addPath")
            public final /* synthetic */ void addPath(DslList dslList, int i8) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.addPath(i8);
            }

            @JvmName(name = "addSpan")
            public final /* synthetic */ void addSpan(DslList dslList, int i8) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.addSpan(i8);
            }

            public final void clearLeadingComments() {
                this._builder.clearLeadingComments();
            }

            @JvmName(name = "clearLeadingDetachedComments")
            public final /* synthetic */ void clearLeadingDetachedComments(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearLeadingDetachedComments();
            }

            @JvmName(name = "clearPath")
            public final /* synthetic */ void clearPath(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearPath();
            }

            @JvmName(name = "clearSpan")
            public final /* synthetic */ void clearSpan(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearSpan();
            }

            public final void clearTrailingComments() {
                this._builder.clearTrailingComments();
            }

            @JvmName(name = "getLeadingComments")
            public final String getLeadingComments() {
                String leadingComments = this._builder.getLeadingComments();
                Intrinsics.checkNotNullExpressionValue(leadingComments, "_builder.getLeadingComments()");
                return leadingComments;
            }

            public final /* synthetic */ DslList getLeadingDetachedComments() {
                ProtocolStringList leadingDetachedCommentsList = this._builder.getLeadingDetachedCommentsList();
                Intrinsics.checkNotNullExpressionValue(leadingDetachedCommentsList, "_builder.getLeadingDetachedCommentsList()");
                return new DslList(leadingDetachedCommentsList);
            }

            public final /* synthetic */ DslList getPath() {
                List<Integer> pathList = this._builder.getPathList();
                Intrinsics.checkNotNullExpressionValue(pathList, "_builder.getPathList()");
                return new DslList(pathList);
            }

            public final /* synthetic */ DslList getSpan() {
                List<Integer> spanList = this._builder.getSpanList();
                Intrinsics.checkNotNullExpressionValue(spanList, "_builder.getSpanList()");
                return new DslList(spanList);
            }

            @JvmName(name = "getTrailingComments")
            public final String getTrailingComments() {
                String trailingComments = this._builder.getTrailingComments();
                Intrinsics.checkNotNullExpressionValue(trailingComments, "_builder.getTrailingComments()");
                return trailingComments;
            }

            public final boolean hasLeadingComments() {
                return this._builder.hasLeadingComments();
            }

            public final boolean hasTrailingComments() {
                return this._builder.hasTrailingComments();
            }

            @JvmName(name = "plusAssignAllLeadingDetachedComments")
            public final /* synthetic */ void plusAssignAllLeadingDetachedComments(DslList<String, LeadingDetachedCommentsProxy> dslList, Iterable<String> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllLeadingDetachedComments(dslList, values);
            }

            @JvmName(name = "plusAssignAllPath")
            public final /* synthetic */ void plusAssignAllPath(DslList<Integer, PathProxy> dslList, Iterable<Integer> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllPath(dslList, values);
            }

            @JvmName(name = "plusAssignAllSpan")
            public final /* synthetic */ void plusAssignAllSpan(DslList<Integer, SpanProxy> dslList, Iterable<Integer> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllSpan(dslList, values);
            }

            @JvmName(name = "plusAssignLeadingDetachedComments")
            public final /* synthetic */ void plusAssignLeadingDetachedComments(DslList<String, LeadingDetachedCommentsProxy> dslList, String value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addLeadingDetachedComments(dslList, value);
            }

            @JvmName(name = "plusAssignPath")
            public final /* synthetic */ void plusAssignPath(DslList<Integer, PathProxy> dslList, int i8) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                addPath(dslList, i8);
            }

            @JvmName(name = "plusAssignSpan")
            public final /* synthetic */ void plusAssignSpan(DslList<Integer, SpanProxy> dslList, int i8) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                addSpan(dslList, i8);
            }

            @JvmName(name = "setLeadingComments")
            public final void setLeadingComments(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setLeadingComments(value);
            }

            @JvmName(name = "setLeadingDetachedComments")
            public final /* synthetic */ void setLeadingDetachedComments(DslList dslList, int i8, String value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setLeadingDetachedComments(i8, value);
            }

            @JvmName(name = "setPath")
            public final /* synthetic */ void setPath(DslList dslList, int i8, int i9) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.setPath(i8, i9);
            }

            @JvmName(name = "setSpan")
            public final /* synthetic */ void setSpan(DslList dslList, int i8, int i9) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.setSpan(i8, i9);
            }

            @JvmName(name = "setTrailingComments")
            public final void setTrailingComments(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setTrailingComments(value);
            }

            private Dsl(DescriptorProtos.SourceCodeInfo.Location.Builder builder) {
                this._builder = builder;
            }
        }

        private LocationKt() {
        }
    }

    private SourceCodeInfoKt() {
    }

    @JvmName(name = "-initializelocation")
    /* JADX INFO: renamed from: -initializelocation, reason: not valid java name */
    public final DescriptorProtos.SourceCodeInfo.Location m114initializelocation(Function1<? super LocationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LocationKt.Dsl.Companion companion = LocationKt.Dsl.INSTANCE;
        DescriptorProtos.SourceCodeInfo.Location.Builder builderNewBuilder = DescriptorProtos.SourceCodeInfo.Location.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        LocationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
