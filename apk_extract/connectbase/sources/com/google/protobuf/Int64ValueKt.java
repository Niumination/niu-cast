package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class Int64ValueKt {

    @l
    public static final Int64ValueKt INSTANCE = new Int64ValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Int64Value.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Int64Value.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Int64Value.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Int64Value _build() {
            Int64Value int64ValueBuild = this._builder.build();
            l0.o(int64ValueBuild, "_builder.build()");
            return int64ValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @i(name = "getValue")
        public final long getValue() {
            return this._builder.getValue();
        }

        @i(name = "setValue")
        public final void setValue(long j10) {
            this._builder.setValue(j10);
        }

        private Dsl(Int64Value.Builder builder) {
            this._builder = builder;
        }
    }

    private Int64ValueKt() {
    }
}
