package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import l3.b1;
import l3.c0;
import l3.f0;
import y5.a;

/* JADX INFO: loaded from: classes.dex */
public class BarhopperV3 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2214a;

    private native void closeNative(long j8);

    private native long createNativeWithClientOptions(byte[] bArr);

    public static a i(byte[] bArr) {
        bArr.getClass();
        try {
            return a.o(bArr, f0.f7234b);
        } catch (b1 e) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e);
        }
    }

    private native byte[] recognizeBitmapNative(long j8, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j8, int i8, int i9, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j8, int i8, int i9, byte[] bArr, RecognitionOptions recognitionOptions);

    public final void a(g4.a aVar) {
        if (this.f2214a != 0) {
            Log.w("BarhopperV3", "Native context already exists.");
            return;
        }
        try {
            int iC = aVar.c();
            byte[] bArr = new byte[iC];
            c0 c0Var = new c0(bArr, iC);
            aVar.l(c0Var);
            if (iC - c0Var.f7210d != 0) {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            long jCreateNativeWithClientOptions = createNativeWithClientOptions(bArr);
            this.f2214a = jCreateNativeWithClientOptions;
            if (jCreateNativeWithClientOptions == 0) {
                throw new IllegalArgumentException("Failed to create native context with client options.");
            }
        } catch (IOException e) {
            throw new RuntimeException(h0.a.j("Serializing ", g4.a.class.getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public final a c(int i8, int i9, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions) {
        long j8 = this.f2214a;
        if (j8 != 0) {
            return i(recognizeBufferNative(j8, i8, i9, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j8 = this.f2214a;
        if (j8 != 0) {
            closeNative(j8);
            this.f2214a = 0L;
        }
    }

    public final a g(int i8, int i9, byte[] bArr, RecognitionOptions recognitionOptions) {
        long j8 = this.f2214a;
        if (j8 != 0) {
            return i(recognizeNative(j8, i8, i9, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native context does not exist.");
    }

    public final a h(Bitmap bitmap, RecognitionOptions recognitionOptions) {
        if (this.f2214a == 0) {
            throw new IllegalStateException("Native context does not exist.");
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            Log.d("BarhopperV3", "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
            bitmap = bitmap.copy(config2, bitmap.isMutable());
        }
        return i(recognizeBitmapNative(this.f2214a, bitmap, recognitionOptions));
    }
}
