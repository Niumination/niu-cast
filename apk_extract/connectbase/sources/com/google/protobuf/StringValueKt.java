package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class StringValueKt {

    @l
    public static final StringValueKt INSTANCE = new StringValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final StringValue.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(StringValue.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(StringValue.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ StringValue _build() {
            StringValue stringValueBuild = this._builder.build();
            l0.o(stringValueBuild, "_builder.build()");
            return stringValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @i(name = "getValue")
        @l
        public final String getValue() {
            String value = this._builder.getValue();
            l0.o(value, "_builder.getValue()");
            return value;
        }

        @i(name = "setValue")
        public final void setValue(@l String str) {
            l0.p(str, "value");
            this._builder.setValue(str);
        }

        private Dsl(StringValue.Builder builder) {
            this._builder = builder;
        }
    }

    private StringValueKt() {
    }
}
