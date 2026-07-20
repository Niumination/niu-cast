package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class HeartbeatKt {

    @l
    public static final HeartbeatKt INSTANCE = new HeartbeatKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Heartbeat.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Heartbeat.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Heartbeat.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Heartbeat _build() {
            Heartbeat heartbeatBuild = this._builder.build();
            l0.o(heartbeatBuild, "build(...)");
            return heartbeatBuild;
        }

        public final void clearMsg() {
            this._builder.clearMsg();
        }

        @i(name = "getMsg")
        public final int getMsg() {
            return this._builder.getMsg();
        }

        @i(name = "setMsg")
        public final void setMsg(int i10) {
            this._builder.setMsg(i10);
        }

        private Dsl(Heartbeat.Builder builder) {
            this._builder = builder;
        }
    }

    private HeartbeatKt() {
    }
}
