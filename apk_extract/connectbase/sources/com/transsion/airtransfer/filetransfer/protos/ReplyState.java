package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum ReplyState implements Internal.EnumLite {
    REPLY_STATE_ERROR(0),
    REPLY_STATE_SUCCESS(1),
    UNRECOGNIZED(-1);

    public static final int REPLY_STATE_ERROR_VALUE = 0;
    public static final int REPLY_STATE_SUCCESS_VALUE = 1;
    private static final Internal.EnumLiteMap<ReplyState> internalValueMap = new Internal.EnumLiteMap<ReplyState>() { // from class: com.transsion.airtransfer.filetransfer.protos.ReplyState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ReplyState findValueByNumber(int i10) {
            return ReplyState.forNumber(i10);
        }
    };
    private final int value;

    public static final class ReplyStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ReplyStateVerifier();

        private ReplyStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return ReplyState.forNumber(i10) != null;
        }
    }

    ReplyState(int i10) {
        this.value = i10;
    }

    public static ReplyState forNumber(int i10) {
        if (i10 == 0) {
            return REPLY_STATE_ERROR;
        }
        if (i10 != 1) {
            return null;
        }
        return REPLY_STATE_SUCCESS;
    }

    public static Internal.EnumLiteMap<ReplyState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ReplyStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ReplyState valueOf(int i10) {
        return forNumber(i10);
    }
}
