package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class MixinKt {

    @l
    public static final MixinKt INSTANCE = new MixinKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Mixin.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Mixin.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Mixin.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Mixin _build() {
            Mixin mixinBuild = this._builder.build();
            l0.o(mixinBuild, "_builder.build()");
            return mixinBuild;
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearRoot() {
            this._builder.clearRoot();
        }

        @i(name = "getName")
        @l
        public final String getName() {
            String name = this._builder.getName();
            l0.o(name, "_builder.getName()");
            return name;
        }

        @i(name = "getRoot")
        @l
        public final String getRoot() {
            String root = this._builder.getRoot();
            l0.o(root, "_builder.getRoot()");
            return root;
        }

        @i(name = "setName")
        public final void setName(@l String str) {
            l0.p(str, "value");
            this._builder.setName(str);
        }

        @i(name = "setRoot")
        public final void setRoot(@l String str) {
            l0.p(str, "value");
            this._builder.setRoot(str);
        }

        private Dsl(Mixin.Builder builder) {
            this._builder = builder;
        }
    }

    private MixinKt() {
    }
}
