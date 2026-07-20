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
public final class EnumValueKt {

    @l
    public static final EnumValueKt INSTANCE = new EnumValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final EnumValue.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(EnumValue.Builder builder) {
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

        public /* synthetic */ Dsl(EnumValue.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ EnumValue _build() {
            EnumValue enumValueBuild = this._builder.build();
            l0.o(enumValueBuild, "_builder.build()");
            return enumValueBuild;
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

        public final void clearNumber() {
            this._builder.clearNumber();
        }

        @i(name = "clearOptions")
        public final /* synthetic */ void clearOptions(DslList dslList) {
            l0.p(dslList, "<this>");
            this._builder.clearOptions();
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

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            l0.o(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
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

        @i(name = "setNumber")
        public final void setNumber(int i10) {
            this._builder.setNumber(i10);
        }

        @i(name = "setOptions")
        public final /* synthetic */ void setOptions(DslList dslList, int i10, Option option) {
            l0.p(dslList, "<this>");
            l0.p(option, "value");
            this._builder.setOptions(i10, option);
        }

        private Dsl(EnumValue.Builder builder) {
            this._builder = builder;
        }
    }

    private EnumValueKt() {
    }
}
