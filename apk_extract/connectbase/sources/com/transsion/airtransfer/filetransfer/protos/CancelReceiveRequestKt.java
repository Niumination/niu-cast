package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CancelReceiveRequestKt {

    @l
    public static final CancelReceiveRequestKt INSTANCE = new CancelReceiveRequestKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final CancelReceiveRequest.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(CancelReceiveRequest.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(CancelReceiveRequest.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ CancelReceiveRequest _build() {
            CancelReceiveRequest cancelReceiveRequestBuild = this._builder.build();
            l0.o(cancelReceiveRequestBuild, "build(...)");
            return cancelReceiveRequestBuild;
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        @i(name = "getTaskId")
        public final long getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "setTaskId")
        public final void setTaskId(long j10) {
            this._builder.setTaskId(j10);
        }

        private Dsl(CancelReceiveRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private CancelReceiveRequestKt() {
    }
}
