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
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class TypeKt {

    @l
    public static final TypeKt INSTANCE = new TypeKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Type.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Type.Builder builder) {
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

        public static final class OneofsProxy extends DslProxy {
            private OneofsProxy() {
            }
        }

        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Type.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Type _build() {
            Type typeBuild = this._builder.build();
            l0.o(typeBuild, "_builder.build()");
            return typeBuild;
        }

        @i(name = "addAllFields")
        public final /* synthetic */ void addAllFields(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllFields(iterable);
        }

        @i(name = "addAllOneofs")
        public final /* synthetic */ void addAllOneofs(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllOneofs(iterable);
        }

        @i(name = "addAllOptions")
        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllOptions(iterable);
        }

        @i(name = "addFields")
        public final /* synthetic */ void addFields(DslList dslList, Field field) {
            l0.p(dslList, "<this>");
            l0.p(field, "value");
            this._builder.addFields(field);
        }

        @i(name = "addOneofs")
        public final /* synthetic */ void addOneofs(DslList dslList, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            this._builder.addOneofs(str);
        }

        @i(name = "addOptions")
        public final /* synthetic */ void addOptions(DslList dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.addOptions(option);
        }

        public final void clearEdition() {
            this._builder.clearEdition();
        }

        @i(name = "clearFields")
        public final /* synthetic */ void clearFields(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearFields();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        @i(name = "clearOneofs")
        public final /* synthetic */ void clearOneofs(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearOneofs();
        }

        @i(name = "clearOptions")
        public final /* synthetic */ void clearOptions(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearSourceContext() {
            this._builder.clearSourceContext();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
        }

        @i(name = "getEdition")
        @l
        public final String getEdition() {
            String edition = this._builder.getEdition();
            l0.o(edition, "_builder.getEdition()");
            return edition;
        }

        public final /* synthetic */ DslList getFields() {
            List<Field> fieldsList = this._builder.getFieldsList();
            l0.o(fieldsList, "_builder.getFieldsList()");
            return new DslList(fieldsList);
        }

        @i(name = "getName")
        @l
        public final String getName() {
            String name = this._builder.getName();
            l0.o(name, "_builder.getName()");
            return name;
        }

        @l
        public final DslList<String, OneofsProxy> getOneofs() {
            List<String> oneofsList = this._builder.getOneofsList();
            l0.o(oneofsList, "_builder.getOneofsList()");
            return new DslList<>(oneofsList);
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            l0.o(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        @i(name = "getSourceContext")
        @l
        public final SourceContext getSourceContext() {
            SourceContext sourceContext = this._builder.getSourceContext();
            l0.o(sourceContext, "_builder.getSourceContext()");
            return sourceContext;
        }

        @m
        public final SourceContext getSourceContextOrNull(@l Dsl dsl) {
            l0.p(dsl, "<this>");
            return TypeKtKt.getSourceContextOrNull(dsl._builder);
        }

        @i(name = "getSyntax")
        @l
        public final Syntax getSyntax() {
            Syntax syntax = this._builder.getSyntax();
            l0.o(syntax, "_builder.getSyntax()");
            return syntax;
        }

        @i(name = "getSyntaxValue")
        public final int getSyntaxValue() {
            return this._builder.getSyntaxValue();
        }

        public final boolean hasSourceContext() {
            return this._builder.hasSourceContext();
        }

        @i(name = "plusAssignAllFields")
        public final /* synthetic */ void plusAssignAllFields(DslList<Field, FieldsProxy> dslList, Iterable<Field> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllFields(dslList, iterable);
        }

        @i(name = "plusAssignAllOneofs")
        public final /* synthetic */ void plusAssignAllOneofs(DslList<String, OneofsProxy> dslList, Iterable<String> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllOneofs(dslList, iterable);
        }

        @i(name = "plusAssignAllOptions")
        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllOptions(dslList, iterable);
        }

        @i(name = "plusAssignFields")
        public final /* synthetic */ void plusAssignFields(DslList<Field, FieldsProxy> dslList, Field field) {
            l0.p(dslList, "<this>");
            l0.p(field, "value");
            addFields(dslList, field);
        }

        @i(name = "plusAssignOneofs")
        public final /* synthetic */ void plusAssignOneofs(DslList<String, OneofsProxy> dslList, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            addOneofs(dslList, str);
        }

        @i(name = "plusAssignOptions")
        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            addOptions(dslList, option);
        }

        @i(name = "setEdition")
        public final void setEdition(@l String str) {
            l0.p(str, "value");
            this._builder.setEdition(str);
        }

        @i(name = "setFields")
        public final /* synthetic */ void setFields(DslList dslList, int i10, Field field) {
            l0.p(dslList, "<this>");
            l0.p(field, "value");
            this._builder.setFields(i10, field);
        }

        @i(name = "setName")
        public final void setName(@l String str) {
            l0.p(str, "value");
            this._builder.setName(str);
        }

        @i(name = "setOneofs")
        public final /* synthetic */ void setOneofs(DslList dslList, int i10, String str) {
            l0.p(dslList, "<this>");
            l0.p(str, "value");
            this._builder.setOneofs(i10, str);
        }

        @i(name = "setOptions")
        public final /* synthetic */ void setOptions(DslList dslList, int i10, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.setOptions(i10, option);
        }

        @i(name = "setSourceContext")
        public final void setSourceContext(@l SourceContext sourceContext) {
            l0.p(sourceContext, "value");
            this._builder.setSourceContext(sourceContext);
        }

        @i(name = "setSyntax")
        public final void setSyntax(@l Syntax syntax) {
            l0.p(syntax, "value");
            this._builder.setSyntax(syntax);
        }

        @i(name = "setSyntaxValue")
        public final void setSyntaxValue(int i10) {
            this._builder.setSyntaxValue(i10);
        }

        private Dsl(Type.Builder builder) {
            this._builder = builder;
        }
    }

    private TypeKt() {
    }
}
