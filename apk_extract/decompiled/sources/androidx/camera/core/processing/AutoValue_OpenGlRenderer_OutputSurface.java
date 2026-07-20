package androidx.camera.core.processing;

import android.opengl.EGLSurface;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_OpenGlRenderer_OutputSurface extends OpenGlRenderer.OutputSurface {
    private final EGLSurface eglSurface;
    private final int height;
    private final int width;

    public AutoValue_OpenGlRenderer_OutputSurface(EGLSurface eGLSurface, int i8, int i9) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.eglSurface = eGLSurface;
        this.width = i8;
        this.height = i9;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpenGlRenderer.OutputSurface)) {
            return false;
        }
        OpenGlRenderer.OutputSurface outputSurface = (OpenGlRenderer.OutputSurface) obj;
        return this.eglSurface.equals(outputSurface.getEglSurface()) && this.width == outputSurface.getWidth() && this.height == outputSurface.getHeight();
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    @NonNull
    public EGLSurface getEglSurface() {
        return this.eglSurface;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.height ^ ((((this.eglSurface.hashCode() ^ 1000003) * 1000003) ^ this.width) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("OutputSurface{eglSurface=");
        sb2.append(this.eglSurface);
        sb2.append(", width=");
        sb2.append(this.width);
        sb2.append(", height=");
        return h0.a.m(sb2, "}", this.height);
    }
}
