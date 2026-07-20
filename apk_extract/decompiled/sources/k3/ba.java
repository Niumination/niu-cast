package k3;

import android.opengl.GLES20;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ba {
    public static int a(int i8, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i8);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String msg = Intrinsics.stringPlus("Error compiling shader: ", GLES20.glGetShaderInfoLog(iGlCreateShader));
                Intrinsics.checkNotNullParameter("AnimPlayer.ShaderUtil", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                GLES20.glDeleteShader(iGlCreateShader);
                iGlCreateShader = 0;
            }
        }
        if (iGlCreateShader != 0) {
            return iGlCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    public static int b(String vertexSource, String fragmentSource) {
        Intrinsics.checkNotNullParameter(vertexSource, "vertexSource");
        Intrinsics.checkNotNullParameter(fragmentSource, "fragmentSource");
        int iA = a(35633, vertexSource);
        int iA2 = a(35632, fragmentSource);
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iA);
            GLES20.glAttachShader(iGlCreateProgram, iA2);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                String msg = Intrinsics.stringPlus("Error compiling program: ", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                Intrinsics.checkNotNullParameter("AnimPlayer.ShaderUtil", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        if (iGlCreateProgram != 0) {
            return iGlCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }
}
