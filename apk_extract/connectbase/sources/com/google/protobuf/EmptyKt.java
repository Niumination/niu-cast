package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyKt {

    @l
    public static final EmptyKt INSTANCE = new EmptyKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Empty.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Empty.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Empty.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Empty _build() {
            Empty emptyBuild = this._builder.build();
            l0.o(emptyBuild, "_builder.build()");
            return emptyBuild;
        }

        private Dsl(Empty.Builder builder) {
            this._builder = builder;
        }
    }

    private EmptyKt() {
    }
}
