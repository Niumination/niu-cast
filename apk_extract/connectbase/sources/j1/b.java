package j1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public abstract class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8359b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r[] f8360a;

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s[] f8361a;

        public a(final s[] val$hashers) {
            this.f8361a = val$hashers;
        }

        @Override // j1.s
        public <T> s h(@i0 T instance, o<? super T> funnel) {
            for (s sVar : this.f8361a) {
                sVar.h(instance, funnel);
            }
            return this;
        }

        @Override // j1.s
        public q i() {
            return b.this.b(this.f8361a);
        }

        @Override // j1.s, j1.j0
        public s a(byte[] bytes) {
            for (s sVar : this.f8361a) {
                sVar.a(bytes);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s b(char c10) {
            for (s sVar : this.f8361a) {
                sVar.b(c10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s c(byte b10) {
            for (s sVar : this.f8361a) {
                sVar.c(b10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s d(CharSequence chars) {
            for (s sVar : this.f8361a) {
                sVar.d(chars);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s e(byte[] bytes, int off, int len) {
            for (s sVar : this.f8361a) {
                sVar.e(bytes, off, len);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s f(ByteBuffer bytes) {
            int iPosition = bytes.position();
            for (s sVar : this.f8361a) {
                bytes.position(iPosition);
                sVar.f(bytes);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s g(CharSequence chars, Charset charset) {
            for (s sVar : this.f8361a) {
                sVar.g(chars, charset);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putBoolean(boolean b10) {
            for (s sVar : this.f8361a) {
                sVar.putBoolean(b10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putDouble(double d10) {
            for (s sVar : this.f8361a) {
                sVar.putDouble(d10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putFloat(float f10) {
            for (s sVar : this.f8361a) {
                sVar.putFloat(f10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putInt(int i10) {
            for (s sVar : this.f8361a) {
                sVar.putInt(i10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putLong(long l10) {
            for (s sVar : this.f8361a) {
                sVar.putLong(l10);
            }
            return this;
        }

        @Override // j1.s, j1.j0
        public s putShort(short s10) {
            for (s sVar : this.f8361a) {
                sVar.putShort(s10);
            }
            return this;
        }
    }

    public b(r... functions) {
        for (r rVar : functions) {
            rVar.getClass();
        }
        this.f8360a = functions;
    }

    public final s a(s[] hashers) {
        return new a(hashers);
    }

    public abstract q b(s[] hashers);

    @Override // j1.r
    public s newHasher() {
        int length = this.f8360a.length;
        s[] sVarArr = new s[length];
        for (int i10 = 0; i10 < length; i10++) {
            sVarArr[i10] = this.f8360a[i10].newHasher();
        }
        return new a(sVarArr);
    }

    @Override // j1.c, j1.r
    public s newHasher(int expectedInputSize) {
        c1.h0.d(expectedInputSize >= 0);
        int length = this.f8360a.length;
        s[] sVarArr = new s[length];
        for (int i10 = 0; i10 < length; i10++) {
            sVarArr[i10] = this.f8360a[i10].newHasher(expectedInputSize);
        }
        return new a(sVarArr);
    }
}
