package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class HandshakeRequestKt {

    @l
    public static final HandshakeRequestKt INSTANCE = new HandshakeRequestKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final HandshakeRequest.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(HandshakeRequest.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(HandshakeRequest.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ HandshakeRequest _build() {
            HandshakeRequest handshakeRequestBuild = this._builder.build();
            l0.o(handshakeRequestBuild, "build(...)");
            return handshakeRequestBuild;
        }

        public final void clearData() {
            this._builder.clearData();
        }

        @i(name = "getData")
        @l
        public final String getData() {
            String data = this._builder.getData();
            l0.o(data, "getData(...)");
            return data;
        }

        @i(name = "setData")
        public final void setData(@l String str) {
            l0.p(str, "value");
            this._builder.setData(str);
        }

        private Dsl(HandshakeRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private HandshakeRequestKt() {
    }
}
