package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import in.i;
import kn.l0;
import kn.w;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ValueKt {

    @l
    public static final ValueKt INSTANCE = new ValueKt();

    @ProtoDslMarker
    public static final class Dsl {

        @l
        public static final Companion Companion = new Companion(null);

        @l
        private final Value.Builder _builder;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @z0
            public final /* synthetic */ Dsl _create(Value.Builder builder) {
                l0.p(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(Value.Builder builder, w wVar) {
            this(builder);
        }

        @z0
        public final /* synthetic */ Value _build() {
            Value valueBuild = this._builder.build();
            l0.o(valueBuild, "_builder.build()");
            return valueBuild;
        }

        public final void clearBoolValue() {
            this._builder.clearBoolValue();
        }

        public final void clearKind() {
            this._builder.clearKind();
        }

        public final void clearListValue() {
            this._builder.clearListValue();
        }

        public final void clearNullValue() {
            this._builder.clearNullValue();
        }

        public final void clearNumberValue() {
            this._builder.clearNumberValue();
        }

        public final void clearStringValue() {
            this._builder.clearStringValue();
        }

        public final void clearStructValue() {
            this._builder.clearStructValue();
        }

        @i(name = "getBoolValue")
        public final boolean getBoolValue() {
            return this._builder.getBoolValue();
        }

        @i(name = "getKindCase")
        @l
        public final Value.KindCase getKindCase() {
            Value.KindCase kindCase = this._builder.getKindCase();
            l0.o(kindCase, "_builder.getKindCase()");
            return kindCase;
        }

        @i(name = "getListValue")
        @l
        public final ListValue getListValue() {
            ListValue listValue = this._builder.getListValue();
            l0.o(listValue, "_builder.getListValue()");
            return listValue;
        }

        @i(name = "getNullValue")
        @l
        public final NullValue getNullValue() {
            NullValue nullValue = this._builder.getNullValue();
            l0.o(nullValue, "_builder.getNullValue()");
            return nullValue;
        }

        @i(name = "getNullValueValue")
        public final int getNullValueValue() {
            return this._builder.getNullValueValue();
        }

        @i(name = "getNumberValue")
        public final double getNumberValue() {
            return this._builder.getNumberValue();
        }

        @i(name = "getStringValue")
        @l
        public final String getStringValue() {
            String stringValue = this._builder.getStringValue();
            l0.o(stringValue, "_builder.getStringValue()");
            return stringValue;
        }

        @i(name = "getStructValue")
        @l
        public final Struct getStructValue() {
            Struct structValue = this._builder.getStructValue();
            l0.o(structValue, "_builder.getStructValue()");
            return structValue;
        }

        public final boolean hasBoolValue() {
            return this._builder.hasBoolValue();
        }

        public final boolean hasListValue() {
            return this._builder.hasListValue();
        }

        public final boolean hasNullValue() {
            return this._builder.hasNullValue();
        }

        public final boolean hasNumberValue() {
            return this._builder.hasNumberValue();
        }

        public final boolean hasStringValue() {
            return this._builder.hasStringValue();
        }

        public final boolean hasStructValue() {
            return this._builder.hasStructValue();
        }

        @i(name = "setBoolValue")
        public final void setBoolValue(boolean z10) {
            this._builder.setBoolValue(z10);
        }

        @i(name = "setListValue")
        public final void setListValue(@l ListValue listValue) {
            l0.p(listValue, "value");
            this._builder.setListValue(listValue);
        }

        @i(name = "setNullValue")
        public final void setNullValue(@l NullValue nullValue) {
            l0.p(nullValue, "value");
            this._builder.setNullValue(nullValue);
        }

        @i(name = "setNullValueValue")
        public final void setNullValueValue(int i10) {
            this._builder.setNullValueValue(i10);
        }

        @i(name = "setNumberValue")
        public final void setNumberValue(double d10) {
            this._builder.setNumberValue(d10);
        }

        @i(name = "setStringValue")
        public final void setStringValue(@l String str) {
            l0.p(str, "value");
            this._builder.setStringValue(str);
        }

        @i(name = "setStructValue")
        public final void setStructValue(@l Struct struct) {
            l0.p(struct, "value");
            this._builder.setStructValue(struct);
        }

        private Dsl(Value.Builder builder) {
            this._builder = builder;
        }
    }

    private ValueKt() {
    }
}
