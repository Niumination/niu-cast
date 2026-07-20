package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class FloatValueKt {

    @l
    public static final FloatValueKt INSTANCE = new FloatValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final FloatValue.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(FloatValue.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(FloatValue.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ FloatValue _build() {
            FloatValue floatValueBuild = this._builder.build();
            l0.o(floatValueBuild, "_builder.build()");
            return floatValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @i(name = "getValue")
        public final float getValue() {
            return this._builder.getValue();
        }

        @i(name = "setValue")
        public final void setValue(float f10) {
            this._builder.setValue(f10);
        }

        private Dsl(FloatValue.Builder builder) {
            this._builder = builder;
        }
    }

    private FloatValueKt() {
    }
}
