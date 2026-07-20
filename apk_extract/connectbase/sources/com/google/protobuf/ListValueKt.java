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
public final class ListValueKt {

    @l
    public static final ListValueKt INSTANCE = new ListValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final ListValue.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(ListValue.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class ValuesProxy extends DslProxy {
            private ValuesProxy() {
            }
        }

        public /* synthetic */ Dsl(ListValue.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ ListValue _build() {
            ListValue listValueBuild = this._builder.build();
            l0.o(listValueBuild, "_builder.build()");
            return listValueBuild;
        }

        @i(name = "addAllValues")
        public final /* synthetic */ void addAllValues(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllValues(iterable);
        }

        @i(name = "addValues")
        public final /* synthetic */ void addValues(DslList dslList, Value value) {
            l0.p(dslList, "<this>");
            l0.p(value, "value");
            this._builder.addValues(value);
        }

        @i(name = "clearValues")
        public final /* synthetic */ void clearValues(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearValues();
        }

        public final /* synthetic */ DslList getValues() {
            List<Value> valuesList = this._builder.getValuesList();
            l0.o(valuesList, "_builder.getValuesList()");
            return new DslList(valuesList);
        }

        @i(name = "plusAssignAllValues")
        public final /* synthetic */ void plusAssignAllValues(DslList<Value, ValuesProxy> dslList, Iterable<Value> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllValues(dslList, iterable);
        }

        @i(name = "plusAssignValues")
        public final /* synthetic */ void plusAssignValues(DslList<Value, ValuesProxy> dslList, Value value) {
            l0.p(dslList, "<this>");
            l0.p(value, "value");
            addValues(dslList, value);
        }

        @i(name = "setValues")
        public final /* synthetic */ void setValues(DslList dslList, int i10, Value value) {
            l0.p(dslList, "<this>");
            l0.p(value, "value");
            this._builder.setValues(i10, value);
        }

        private Dsl(ListValue.Builder builder) {
            this._builder = builder;
        }
    }

    private ListValueKt() {
    }
}
