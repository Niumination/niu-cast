package l2;

import android.opengl.GLES20;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final l f9670a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f9671b = "AnimPlayer.ShaderUtil";

    public final int a(int i10, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                a.f9640a.b(f9671b, l0.C("Error compiling shader: ", GLES20.glGetShaderInfoLog(iGlCreateShader)));
                GLES20.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        if (iGlCreateShader != 0) {
            return iGlCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    public final int b(int i10, int i11) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, i10);
            GLES20.glAttachShader(iGlCreateProgram, i11);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                a.f9640a.b(f9671b, l0.C("Error compiling program: ", GLES20.glGetProgramInfoLog(iGlCreateProgram)));
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        if (iGlCreateProgram != 0) {
            return iGlCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    public final int c(@os.l String str, @os.l String str2) {
        l0.p(str, "vertexSource");
        l0.p(str2, "fragmentSource");
        return b(a(35633, str), a(35632, str2));
    }
}
