package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class AnyKt {

    @l
    public static final AnyKt INSTANCE = new AnyKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Any.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Any.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Any.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Any _build() {
            Any anyBuild = this._builder.build();
            l0.o(anyBuild, "_builder.build()");
            return anyBuild;
        }

        public final void clearTypeUrl() {
            this._builder.clearTypeUrl();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @i(name = "getTypeUrl")
        @l
        public final String getTypeUrl() {
            String typeUrl = this._builder.getTypeUrl();
            l0.o(typeUrl, "_builder.getTypeUrl()");
            return typeUrl;
        }

        @i(name = "getValue")
        @l
        public final ByteString getValue() {
            ByteString value = this._builder.getValue();
            l0.o(value, "_builder.getValue()");
            return value;
        }

        @i(name = "setTypeUrl")
        public final void setTypeUrl(@l String str) {
            l0.p(str, "value");
            this._builder.setTypeUrl(str);
        }

        @i(name = "setValue")
        public final void setValue(@l ByteString byteString) {
            l0.p(byteString, "value");
            this._builder.setValue(byteString);
        }

        private Dsl(Any.Builder builder) {
            this._builder = builder;
        }
    }

    private AnyKt() {
    }
}
