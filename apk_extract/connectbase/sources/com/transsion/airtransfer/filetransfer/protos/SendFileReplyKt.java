package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class SendFileReplyKt {

    @l
    public static final SendFileReplyKt INSTANCE = new SendFileReplyKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final SendFileReply.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(SendFileReply.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(SendFileReply.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ SendFileReply _build() {
            SendFileReply sendFileReplyBuild = this._builder.build();
            l0.o(sendFileReplyBuild, "build(...)");
            return sendFileReplyBuild;
        }

        public final void clearExtend() {
            this._builder.clearExtend();
        }

        public final void clearIsAccept() {
            this._builder.clearIsAccept();
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        @i(name = "getExtend")
        @l
        public final String getExtend() {
            String extend = this._builder.getExtend();
            l0.o(extend, "getExtend(...)");
            return extend;
        }

        @i(name = "getIsAccept")
        public final boolean getIsAccept() {
            return this._builder.getIsAccept();
        }

        @i(name = "getTaskId")
        public final long getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "setExtend")
        public final void setExtend(@l String str) {
            l0.p(str, "value");
            this._builder.setExtend(str);
        }

        @i(name = "setIsAccept")
        public final void setIsAccept(boolean z10) {
            this._builder.setIsAccept(z10);
        }

        @i(name = "setTaskId")
        public final void setTaskId(long j10) {
            this._builder.setTaskId(j10);
        }

        private Dsl(SendFileReply.Builder builder) {
            this._builder = builder;
        }
    }

    private SendFileReplyKt() {
    }
}
