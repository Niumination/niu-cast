package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt;", "", "()V", "Dsl", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IotcardListMapKt {
    public static final IotcardListMapKt INSTANCE = new IotcardListMapKt();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0001J#\u0010\u000e\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0007¢\u0006\u0002\b\u0010J3\u0010\u0011\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0014J7\u0010\u0015\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0017H\u0007¢\u0006\u0002\b\u0018J+\u0010\u0019\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001aJ4\u0010\u001b\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\bH\u0087\n¢\u0006\u0002\b\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00068G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl;", "", "_builder", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap$Builder;", "(Lcom/transsion/iotservice/iotcard/proto/IotcardListMap$Builder;)V", "displayTemplates", "Lcom/google/protobuf/kotlin/DslMap;", "", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl$DisplayTemplatesProxy;", "getDisplayTemplatesMap", "()Lcom/google/protobuf/kotlin/DslMap;", "_build", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "clear", "", "clearDisplayTemplates", "put", "key", "value", "putDisplayTemplates", "putAll", "map", "", "putAllDisplayTemplates", "remove", "removeDisplayTemplates", "set", "setDisplayTemplates", "Companion", "DisplayTemplatesProxy", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final IotcardListMap.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl$Companion;", "", "()V", "_create", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl;", "builder", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap$Builder;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(IotcardListMap.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardListMapKt$Dsl$DisplayTemplatesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class DisplayTemplatesProxy extends DslProxy {
            private DisplayTemplatesProxy() {
            }
        }

        public /* synthetic */ Dsl(IotcardListMap.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ IotcardListMap _build() {
            IotcardListMap iotcardListMapBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(iotcardListMapBuild, "_builder.build()");
            return iotcardListMapBuild;
        }

        @JvmName(name = "clearDisplayTemplates")
        public final /* synthetic */ void clearDisplayTemplates(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearDisplayTemplates();
        }

        @JvmName(name = "getDisplayTemplatesMap")
        public final /* synthetic */ DslMap getDisplayTemplatesMap() {
            Map<String, IotcardList> displayTemplatesMap = this._builder.getDisplayTemplatesMap();
            Intrinsics.checkNotNullExpressionValue(displayTemplatesMap, "_builder.getDisplayTemplatesMap()");
            return new DslMap(displayTemplatesMap);
        }

        @JvmName(name = "putAllDisplayTemplates")
        public final /* synthetic */ void putAllDisplayTemplates(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllDisplayTemplates(map);
        }

        @JvmName(name = "putDisplayTemplates")
        public final void putDisplayTemplates(DslMap<String, IotcardList, DisplayTemplatesProxy> dslMap, String key, IotcardList value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putDisplayTemplates(key, value);
        }

        @JvmName(name = "removeDisplayTemplates")
        public final /* synthetic */ void removeDisplayTemplates(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removeDisplayTemplates(key);
        }

        @JvmName(name = "setDisplayTemplates")
        public final /* synthetic */ void setDisplayTemplates(DslMap<String, IotcardList, DisplayTemplatesProxy> dslMap, String key, IotcardList value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putDisplayTemplates(dslMap, key, value);
        }

        private Dsl(IotcardListMap.Builder builder) {
            this._builder = builder;
        }
    }

    private IotcardListMapKt() {
    }
}
