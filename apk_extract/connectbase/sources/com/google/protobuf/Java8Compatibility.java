package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    public static void clear(Buffer b10) {
        b10.clear();
    }

    public static void flip(Buffer b10) {
        b10.flip();
    }

    public static void limit(Buffer b10, int limit) {
        b10.limit(limit);
    }

    public static void mark(Buffer b10) {
        b10.mark();
    }

    public static void position(Buffer b10, int position) {
        b10.position(position);
    }

    public static void reset(Buffer b10) {
        b10.reset();
    }
}
