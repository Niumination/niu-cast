package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CancelReceiveReplyKt {

    @l
    public static final CancelReceiveReplyKt INSTANCE = new CancelReceiveReplyKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final CancelReceiveReply.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(CancelReceiveReply.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(CancelReceiveReply.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ CancelReceiveReply _build() {
            CancelReceiveReply cancelReceiveReplyBuild = this._builder.build();
            l0.o(cancelReceiveReplyBuild, "build(...)");
            return cancelReceiveReplyBuild;
        }

        public final void clearFileId() {
            this._builder.clearFileId();
        }

        public final void clearSentLength() {
            this._builder.clearSentLength();
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        @i(name = "getFileId")
        public final long getFileId() {
            return this._builder.getFileId();
        }

        @i(name = "getSentLength")
        public final long getSentLength() {
            return this._builder.getSentLength();
        }

        @i(name = "getTaskId")
        public final long getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "setFileId")
        public final void setFileId(long j10) {
            this._builder.setFileId(j10);
        }

        @i(name = "setSentLength")
        public final void setSentLength(long j10) {
            this._builder.setSentLength(j10);
        }

        @i(name = "setTaskId")
        public final void setTaskId(long j10) {
            this._builder.setTaskId(j10);
        }

        private Dsl(CancelReceiveReply.Builder builder) {
            this._builder = builder;
        }
    }

    private CancelReceiveReplyKt() {
    }
}
