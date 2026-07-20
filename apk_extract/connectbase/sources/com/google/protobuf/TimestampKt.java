package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class TimestampKt {

    @l
    public static final TimestampKt INSTANCE = new TimestampKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Timestamp.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Timestamp.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Timestamp.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Timestamp _build() {
            Timestamp timestampBuild = this._builder.build();
            l0.o(timestampBuild, "_builder.build()");
            return timestampBuild;
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

        private Dsl(Timestamp.Builder builder) {
            this._builder = builder;
        }
    }

    private TimestampKt() {
    }
}
