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
public final class ApiKt {

    @l
    public static final ApiKt INSTANCE = new ApiKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Api.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Api.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public static final class MethodsProxy extends DslProxy {
            private MethodsProxy() {
            }
        }

        public static final class MixinsProxy extends DslProxy {
            private MixinsProxy() {
            }
        }

        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Api.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Api _build() {
            Api apiBuild = this._builder.build();
            l0.o(apiBuild, "_builder.build()");
            return apiBuild;
        }

        @i(name = "addAllMethods")
        public final /* synthetic */ void addAllMethods(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllMethods(iterable);
        }

        @i(name = "addAllMixins")
        public final /* synthetic */ void addAllMixins(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllMixins(iterable);
        }

        @i(name = "addAllOptions")
        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            this._builder.addAllOptions(iterable);
        }

        @i(name = "addMethods")
        public final /* synthetic */ void addMethods(DslList dslList, Method method) {
            l0.p(dslList, "<this>");
            l0.p(method, "value");
            this._builder.addMethods(method);
        }

        @i(name = "addMixins")
        public final /* synthetic */ void addMixins(DslList dslList, Mixin mixin) {
            l0.p(dslList, "<this>");
            l0.p(mixin, "value");
            this._builder.addMixins(mixin);
        }

        @i(name = "addOptions")
        public final /* synthetic */ void addOptions(DslList dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.addOptions(option);
        }

        @i(name = "clearMethods")
        public final /* synthetic */ void clearMethods(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearMethods();
        }

        @i(name = "clearMixins")
        public final /* synthetic */ void clearMixins(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearMixins();
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

        public final void clearVersion() {
            this._builder.clearVersion();
        }

        public final /* synthetic */ DslList getMethods() {
            List<Method> methodsList = this._builder.getMethodsList();
            l0.o(methodsList, "_builder.getMethodsList()");
            return new DslList(methodsList);
        }

        public final /* synthetic */ DslList getMixins() {
            List<Mixin> mixinsList = this._builder.getMixinsList();
            l0.o(mixinsList, "_builder.getMixinsList()");
            return new DslList(mixinsList);
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
            return ApiKtKt.getSourceContextOrNull(dsl._builder);
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

        @i(name = "getVersion")
        @l
        public final String getVersion() {
            String version = this._builder.getVersion();
            l0.o(version, "_builder.getVersion()");
            return version;
        }

        public final boolean hasSourceContext() {
            return this._builder.hasSourceContext();
        }

        @i(name = "plusAssignAllMethods")
        public final /* synthetic */ void plusAssignAllMethods(DslList<Method, MethodsProxy> dslList, Iterable<Method> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllMethods(dslList, iterable);
        }

        @i(name = "plusAssignAllMixins")
        public final /* synthetic */ void plusAssignAllMixins(DslList<Mixin, MixinsProxy> dslList, Iterable<Mixin> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllMixins(dslList, iterable);
        }

        @i(name = "plusAssignAllOptions")
        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> iterable) {
            l0.p(dslList, "<this>");
            l0.p(iterable, "values");
            addAllOptions(dslList, iterable);
        }

        @i(name = "plusAssignMethods")
        public final /* synthetic */ void plusAssignMethods(DslList<Method, MethodsProxy> dslList, Method method) {
            l0.p(dslList, "<this>");
            l0.p(method, "value");
            addMethods(dslList, method);
        }

        @i(name = "plusAssignMixins")
        public final /* synthetic */ void plusAssignMixins(DslList<Mixin, MixinsProxy> dslList, Mixin mixin) {
            l0.p(dslList, "<this>");
            l0.p(mixin, "value");
            addMixins(dslList, mixin);
        }

        @i(name = "plusAssignOptions")
        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            addOptions(dslList, option);
        }

        @i(name = "setMethods")
        public final /* synthetic */ void setMethods(DslList dslList, int i10, Method method) {
            l0.p(dslList, "<this>");
            l0.p(method, "value");
            this._builder.setMethods(i10, method);
        }

        @i(name = "setMixins")
        public final /* synthetic */ void setMixins(DslList dslList, int i10, Mixin mixin) {
            l0.p(dslList, "<this>");
            l0.p(mixin, "value");
            this._builder.setMixins(i10, mixin);
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

        @i(name = "setVersion")
        public final void setVersion(@l String str) {
            l0.p(str, "value");
            this._builder.setVersion(str);
        }

        private Dsl(Api.Builder builder) {
            this._builder = builder;
        }
    }

    private ApiKt() {
    }
}
