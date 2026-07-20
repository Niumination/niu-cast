package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class OptionKt {

    @l
    public static final OptionKt INSTANCE = new OptionKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Option.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Option.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Option.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Option _build() {
            Option optionBuild = this._builder.build();
            l0.o(optionBuild, "_builder.build()");
            return optionBuild;
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @i(name = "getName")
        @l
        public final String getName() {
            String name = this._builder.getName();
            l0.o(name, "_builder.getName()");
            return name;
        }

        @i(name = "getValue")
        @l
        public final Any getValue() {
            Any value = this._builder.getValue();
            l0.o(value, "_builder.getValue()");
            return value;
        }

        @m
        public final Any getValueOrNull(@l Dsl dsl) {
            l0.p(dsl, "<this>");
            return OptionKtKt.getValueOrNull(dsl._builder);
        }

        public final boolean hasValue() {
            return this._builder.hasValue();
        }

        @i(name = "setName")
        public final void setName(@l String str) {
            l0.p(str, "value");
            this._builder.setName(str);
        }

        @i(name = "setValue")
        public final void setValue(@l Any any) {
            l0.p(any, "value");
            this._builder.setValue(any);
        }

        private Dsl(Option.Builder builder) {
            this._builder = builder;
        }
    }

    private OptionKt() {
    }
}
