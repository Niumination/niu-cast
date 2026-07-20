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
public final class MethodKt {

    @l
    public static final MethodKt INSTANCE = new MethodKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Method.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Method.Builder builder) {
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

        public /* synthetic */ Dsl(Method.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Method _build() {
            Method methodBuild = this._builder.build();
            l0.o(methodBuild, "_builder.build()");
            return methodBuild;
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

        public final void clearName() {
            this._builder.clearName();
        }

        @i(name = "clearOptions")
        public final /* synthetic */ void clearOptions(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearRequestStreaming() {
            this._builder.clearRequestStreaming();
        }

        public final void clearRequestTypeUrl() {
            this._builder.clearRequestTypeUrl();
        }

        public final void clearResponseStreaming() {
            this._builder.clearResponseStreaming();
        }

        public final void clearResponseTypeUrl() {
            this._builder.clearResponseTypeUrl();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
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

        @i(name = "getRequestStreaming")
        public final boolean getRequestStreaming() {
            return this._builder.getRequestStreaming();
        }

        @i(name = "getRequestTypeUrl")
        @l
        public final String getRequestTypeUrl() {
            String requestTypeUrl = this._builder.getRequestTypeUrl();
            l0.o(requestTypeUrl, "_builder.getRequestTypeUrl()");
            return requestTypeUrl;
        }

        @i(name = "getResponseStreaming")
        public final boolean getResponseStreaming() {
            return this._builder.getResponseStreaming();
        }

        @i(name = "getResponseTypeUrl")
        @l
        public final String getResponseTypeUrl() {
            String responseTypeUrl = this._builder.getResponseTypeUrl();
            l0.o(responseTypeUrl, "_builder.getResponseTypeUrl()");
            return responseTypeUrl;
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

        @i(name = "setRequestStreaming")
        public final void setRequestStreaming(boolean z10) {
            this._builder.setRequestStreaming(z10);
        }

        @i(name = "setRequestTypeUrl")
        public final void setRequestTypeUrl(@l String str) {
            l0.p(str, "value");
            this._builder.setRequestTypeUrl(str);
        }

        @i(name = "setResponseStreaming")
        public final void setResponseStreaming(boolean z10) {
            this._builder.setResponseStreaming(z10);
        }

        @i(name = "setResponseTypeUrl")
        public final void setResponseTypeUrl(@l String str) {
            l0.p(str, "value");
            this._builder.setResponseTypeUrl(str);
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

        private Dsl(Method.Builder builder) {
            this._builder = builder;
        }
    }

    private MethodKt() {
    }
}
