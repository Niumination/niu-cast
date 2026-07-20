package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class DurationKt {

    @l
    public static final DurationKt INSTANCE = new DurationKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Duration.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Duration.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Duration.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Duration _build() {
            Duration durationBuild = this._builder.build();
            l0.o(durationBuild, "_builder.build()");
            return durationBuild;
        }

        public final void clearNanos() {
            this._builder.clearNanos();
        }

        public final void clearSeconds() {
            this._builder.clearSeconds();
        }

        @i(name = "getNanos")
        public final int getNanos() {
            return this._builder.getNanos();
        }

        @i(name = "getSeconds")
        public final long getSeconds() {
            return this._builder.getSeconds();
        }

        @i(name = "setNanos")
        public final void setNanos(int i10) {
            this._builder.setNanos(i10);
        }

        @i(name = "setSeconds")
        public final void setSeconds(long j10) {
            this._builder.setSeconds(j10);
        }

        private Dsl(Duration.Builder builder) {
            this._builder = builder;
        }
    }

    private DurationKt() {
    }
}
