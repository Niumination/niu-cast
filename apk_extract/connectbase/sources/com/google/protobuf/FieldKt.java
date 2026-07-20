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
public final class FieldKt {

    @l
    public static final FieldKt INSTANCE = new FieldKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Field.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Field.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Field.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Field _build() {
            Field fieldBuild = this._builder.build();
            l0.o(fieldBuild, "_builder.build()");
            return fieldBuild;
        }

        @i(name = "addAllOptions")
        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllOptions(iterable);
        }

        @i(name = "addOptions")
        public final /* synthetic */ void addOptions(DslList dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.addOptions(option);
        }

        public final void clearCardinality() {
            this._builder.clearCardinality();
        }

        public final void clearDefaultValue() {
            this._builder.clearDefaultValue();
        }

        public final void clearJsonName() {
            this._builder.clearJsonName();
        }

        public final void clearKind() {
            this._builder.clearKind();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearNumber() {
            this._builder.clearNumber();
        }

        public final void clearOneofIndex() {
            this._builder.clearOneofIndex();
        }

        @i(name = "clearOptions")
        public final /* synthetic */ void clearOptions(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearPacked() {
            this._builder.clearPacked();
        }

        public final void clearTypeUrl() {
            this._builder.clearTypeUrl();
        }

        @i(name = "getCardinality")
        @l
        public final Field.Cardinality getCardinality() {
            Field.Cardinality cardinality = this._builder.getCardinality();
            l0.o(cardinality, "_builder.getCardinality()");
            return cardinality;
        }

        @i(name = "getCardinalityValue")
        public final int getCardinalityValue() {
            return this._builder.getCardinalityValue();
        }

        @i(name = "getDefaultValue")
        @l
        public final String getDefaultValue() {
            String defaultValue = this._builder.getDefaultValue();
            l0.o(defaultValue, "_builder.getDefaultValue()");
            return defaultValue;
        }

        @i(name = "getJsonName")
        @l
        public final String getJsonName() {
            String jsonName = this._builder.getJsonName();
            l0.o(jsonName, "_builder.getJsonName()");
            return jsonName;
        }

        @i(name = "getKind")
        @l
        public final Field.Kind getKind() {
            Field.Kind kind = this._builder.getKind();
            l0.o(kind, "_builder.getKind()");
            return kind;
        }

        @i(name = "getKindValue")
        public final int getKindValue() {
            return this._builder.getKindValue();
        }

        @i(name = "getName")
        @l
        public final String getName() {
            String name = this._builder.getName();
            l0.o(name, "_builder.getName()");
            return name;
        }

        @i(name = "getNumber")
        public final int getNumber() {
            return this._builder.getNumber();
        }

        @i(name = "getOneofIndex")
        public final int getOneofIndex() {
            return this._builder.getOneofIndex();
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            l0.o(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        @i(name = "getPacked")
        public final boolean getPacked() {
            return this._builder.getPacked();
        }

        @i(name = "getTypeUrl")
        @l
        public final String getTypeUrl() {
            String typeUrl = this._builder.getTypeUrl();
            l0.o(typeUrl, "_builder.getTypeUrl()");
            return typeUrl;
        }

        @i(name = "plusAssignAllOptions")
        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllOptions(dslList, iterable);
        }

        @i(name = "plusAssignOptions")
        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            addOptions(dslList, option);
        }

        @i(name = "setCardinality")
        public final void setCardinality(@l Field.Cardinality cardinality) {
            l0.p(cardinality, "value");
            this._builder.setCardinality(cardinality);
        }

        @i(name = "setCardinalityValue")
        public final void setCardinalityValue(int i10) {
            this._builder.setCardinalityValue(i10);
        }

        @i(name = "setDefaultValue")
        public final void setDefaultValue(@l String str) {
            l0.p(str, "value");
            this._builder.setDefaultValue(str);
        }

        @i(name = "setJsonName")
        public final void setJsonName(@l String str) {
            l0.p(str, "value");
            this._builder.setJsonName(str);
        }

        @i(name = "setKind")
        public final void setKind(@l Field.Kind kind) {
            l0.p(kind, "value");
            this._builder.setKind(kind);
        }

        @i(name = "setKindValue")
        public final void setKindValue(int i10) {
            this._builder.setKindValue(i10);
        }

        @i(name = "setName")
        public final void setName(@l String str) {
            l0.p(str, "value");
            this._builder.setName(str);
        }

        @i(name = "setNumber")
        public final void setNumber(int i10) {
            this._builder.setNumber(i10);
        }

        @i(name = "setOneofIndex")
        public final void setOneofIndex(int i10) {
            this._builder.setOneofIndex(i10);
        }

        @i(name = "setOptions")
        public final /* synthetic */ void setOptions(DslList dslList, int i10, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.setOptions(i10, option);
        }

        @i(name = "setPacked")
        public final void setPacked(boolean z10) {
            this._builder.setPacked(z10);
        }

        @i(name = "setTypeUrl")
        public final void setTypeUrl(@l String str) {
            l0.p(str, "value");
            this._builder.setTypeUrl(str);
        }

        private Dsl(Field.Builder builder) {
            this._builder = builder;
        }
    }

    private FieldKt() {
    }
}
