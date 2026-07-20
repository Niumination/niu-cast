package com.google.protobuf;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import java.util.List;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class FieldMaskKt {

    @l
    public static final FieldMaskKt INSTANCE = new FieldMaskKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final FieldMask.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(FieldMask.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class PathsProxy extends DslProxy {
            private PathsProxy() {
            }
        }

        public /* synthetic */ Dsl(FieldMask.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ FieldMask _build() {
            FieldMask fieldMaskBuild = this._builder.build();
            l0.o(fieldMaskBuild, "_builder.build()");
            return fieldMaskBuild;
        }

        @i(name = "addAllPaths")
        public final /* synthetic */ void addAllPaths(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllPaths(iterable);
        }

        @i(name = "addPaths")
        public final /* synthetic */ void addPaths(DslList dslList, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            this._builder.addPaths(str);
        }

        @i(name = "clearPaths")
        public final /* synthetic */ void clearPaths(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearPaths();
        }

        @l
        public final DslList<String, PathsProxy> getPaths() {
            List<String> pathsList = this._builder.getPathsList();
            l0.o(pathsList, "_builder.getPathsList()");
            return new DslList<>(pathsList);
        }

        @i(name = "plusAssignAllPaths")
        public final /* synthetic */ void plusAssignAllPaths(DslList<String, PathsProxy> dslList, Iterable<String> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllPaths(dslList, iterable);
        }

        @i(name = "plusAssignPaths")
        public final /* synthetic */ void plusAssignPaths(DslList<String, PathsProxy> dslList, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            addPaths(dslList, str);
        }

        @i(name = "setPaths")
        public final /* synthetic */ void setPaths(DslList dslList, int i10, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            this._builder.setPaths(i10, str);
        }

        private Dsl(FieldMask.Builder builder) {
            this._builder = builder;
        }
    }

    private FieldMaskKt() {
    }
}
