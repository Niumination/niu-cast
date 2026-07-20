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
public final class EnumKt {

    @l
    public static final EnumKt INSTANCE = new EnumKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Enum.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Enum.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class EnumvalueProxy extends DslProxy {
            private EnumvalueProxy() {
            }
        }

        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Enum.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Enum _build() {
            Enum enumBuild = this._builder.build();
            l0.o(enumBuild, "_builder.build()");
            return enumBuild;
        }

        @i(name = "addAllEnumvalue")
        public final /* synthetic */ void addAllEnumvalue(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllEnumvalue(iterable);
        }

        @i(name = "addAllOptions")
        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllOptions(iterable);
        }

        @i(name = "addEnumvalue")
        public final /* synthetic */ void addEnumvalue(DslList dslList, EnumValue enumValue) {
            l0.p(dslList, "<this>");
            l0.p(enumValue, "value");
            this._builder.addEnumvalue(enumValue);
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

        @i(name = "clearEnumvalue")
        public final /* synthetic */ void clearEnumvalue(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearEnumvalue();
        }

        public final void clearName() {
            this._builder.clearName();
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

        public final /* synthetic */ DslList getEnumvalue() {
            List<EnumValue> enumvalueList = this._builder.getEnumvalueList();
            l0.o(enumvalueList, "_builder.getEnumvalueList()");
            return new DslList(enumvalueList);
        }

        @i(name = "getName")
        @l
        public final String getName() {
            String name = this._builder.getName();
            l0.o(name, "_builder.getName()");
            return name;
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
            return EnumKtKt.getSourceContextOrNull(dsl._builder);
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

        @i(name = "plusAssignAllEnumvalue")
        public final /* synthetic */ void plusAssignAllEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, Iterable<EnumValue> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllEnumvalue(dslList, iterable);
        }

        @i(name = "plusAssignAllOptions")
        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllOptions(dslList, iterable);
        }

        @i(name = "plusAssignEnumvalue")
        public final /* synthetic */ void plusAssignEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, EnumValue enumValue) {
            l0.p(dslList, "<this>");
            l0.p(enumValue, "value");
            addEnumvalue(dslList, enumValue);
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

        @i(name = "setEnumvalue")
        public final /* synthetic */ void setEnumvalue(DslList dslList, int i10, EnumValue enumValue) {
            l0.p(dslList, "<this>");
            l0.p(enumValue, "value");
            this._builder.setEnumvalue(i10, enumValue);
        }

        @i(name = "setName")
        public final void setName(@l String str) {
            l0.p(str, "value");
            this._builder.setName(str);
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

        private Dsl(Enum.Builder builder) {
            this._builder = builder;
        }
    }

    private EnumKt() {
    }
}
