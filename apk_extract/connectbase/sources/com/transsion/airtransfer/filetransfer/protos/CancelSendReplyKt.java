package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class CancelSendReplyKt {

    @l
    public static final CancelSendReplyKt INSTANCE = new CancelSendReplyKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final CancelSendReply.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(CancelSendReply.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(CancelSendReply.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ CancelSendReply _build() {
            CancelSendReply cancelSendReplyBuild = this._builder.build();
            l0.o(cancelSendReplyBuild, "build(...)");
            return cancelSendReplyBuild;
        }

        public final void clearState() {
            this._builder.clearState();
        }

        public final void clearTaskId() {
            this._builder.clearTaskId();
        }

        @i(name = "getState")
        @l
        public final ReplyState getState() {
            ReplyState state = this._builder.getState();
            l0.o(state, "getState(...)");
            return state;
        }

        @i(name = "getStateValue")
        public final int getStateValue() {
            return this._builder.getStateValue();
        }

        @i(name = "getTaskId")
        public final long getTaskId() {
            return this._builder.getTaskId();
        }

        @i(name = "setState")
        public final void setState(@l ReplyState replyState) {
            l0.p(replyState, "value");
            this._builder.setState(replyState);
        }

        @i(name = "setStateValue")
        public final void setStateValue(int i10) {
            this._builder.setStateValue(i10);
        }

        @i(name = "setTaskId")
        public final void setTaskId(long j10) {
            this._builder.setTaskId(j10);
        }

        private Dsl(CancelSendReply.Builder builder) {
            this._builder = builder;
        }
    }

    private CancelSendReplyKt() {
    }
}
