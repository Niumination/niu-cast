package com.google.protobuf;

import cb.b;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import java.util.Map;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class StructKt {

    @l
    public static final StructKt INSTANCE = new StructKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Struct.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Struct.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class FieldsProxy extends DslProxy {
            private FieldsProxy() {
            }
        }

        public /* synthetic */ Dsl(Struct.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Struct _build() {
            Struct structBuild = this._builder.build();
            l0.o(structBuild, "_builder.build()");
            return structBuild;
        }

        @i(name = "clearFields")
        public final /* synthetic */ void clearFields(DslMap dslMap) {
            l0.p(dslMap, "<this>");
            this._builder.clearFields();
        }

        @i(name = "getFieldsMap")
        public final /* synthetic */ DslMap getFieldsMap() {
            Map<String, Value> fieldsMap = this._builder.getFieldsMap();
            l0.o(fieldsMap, "_builder.getFieldsMap()");
            return new DslMap(fieldsMap);
        }

        @i(name = "putAllFields")
        public final /* synthetic */ void putAllFields(DslMap dslMap, Map map) {
            l0.p(dslMap, "<this>");
            l0.p(map, "map");
            this._builder.putAllFields(map);
        }

        @i(name = "putFields")
        public final void putFields(@l DslMap<String, Value, FieldsProxy> dslMap, @l String str, @l Value value) {
            l0.p(dslMap, "<this>");
            l0.p(str, b.c.f1408o);
            l0.p(value, "value");
            this._builder.putFields(str, value);
        }

        @i(name = "removeFields")
        public final /* synthetic */ void removeFields(DslMap dslMap, String str) {
            l0.p(dslMap, "<this>");
            l0.p(str, b.c.f1408o);
            this._builder.removeFields(str);
        }

        @i(name = "setFields")
        public final /* synthetic */ void setFields(DslMap<String, Value, FieldsProxy> dslMap, String str, Value value) {
            l0.p(dslMap, "<this>");
            l0.p(str, b.c.f1408o);
            l0.p(value, "value");
            putFields(dslMap, str, value);
        }

        private Dsl(Struct.Builder builder) {
            this._builder = builder;
        }
    }

    private StructKt() {
    }
}
