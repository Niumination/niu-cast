package fl;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a0 {

    @xm.f(c = "io.ktor.util.CryptoKt__CryptoJvmKt$generateNonceBlocking$1", f = "CryptoJvm.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super String>, Object> {
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                pq.l<String> lVarD = c1.d();
                this.label = 1;
                obj = lVarD.n(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super String> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class b extends kn.n0 implements jn.l<String, String> {
        final /* synthetic */ String $salt;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$salt = str;
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l String str) {
            kn.l0.p(str, "it");
            return this.$salt;
        }
    }

    public static final class c extends kn.n0 implements jn.l<String, byte[]> {
        final /* synthetic */ String $algorithm;
        final /* synthetic */ jn.l<String, String> $salt;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(String str, jn.l<? super String, String> lVar) {
            super(1);
            this.$algorithm = str;
            this.$salt = lVar;
        }

        @Override // jn.l
        @os.l
        public final byte[] invoke(@os.l String str) {
            kn.l0.p(str, "e");
            return a0.e(str, this.$algorithm, this.$salt);
        }
    }

    @xm.f(c = "io.ktor.util.CryptoKt__CryptoJvmKt$sha1$1", f = "CryptoJvm.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<nq.s0, um.d<? super byte[]>, Object> {
        final /* synthetic */ byte[] $bytes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(byte[] bArr, um.d<? super d> dVar) {
            super(2, dVar);
            this.$bytes = bArr;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new d(this.$bytes, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws NoSuchAlgorithmException {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                h0 h0VarA = a0.a("SHA1");
                h0VarA.a(this.$bytes);
                this.label = 1;
                obj = h0VarA.b(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super byte[]> dVar) {
            return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final h0 a(@os.l String str) throws NoSuchAlgorithmException {
        kn.l0.p(str, "name");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        kn.l0.o(messageDigest, "getInstance(name)");
        kn.l0.p(messageDigest, "delegate");
        return new i0(messageDigest);
    }

    @os.l
    public static final String c() {
        String strPoll = c1.d().poll();
        return strPoll != null ? strPoll : d();
    }

    public static final String d() {
        c1.b();
        return (String) nq.j.b(null, new a(null), 1, null);
    }

    public static final byte[] e(String str, String str2, jn.l<? super String, String> lVar) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        String strInvoke = lVar.invoke(str);
        Charset charset = jq.f.f8800b;
        byte[] bytes = strInvoke.getBytes(charset);
        kn.l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] bytes2 = str.getBytes(charset);
        kn.l0.o(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes2);
        kn.l0.o(bArrDigest, "with(MessageDigest.getIn…text.toByteArray())\n    }");
        return bArrDigest;
    }

    @lm.k(level = lm.m.ERROR, message = "Use getDigestFunction with non-constant salt.")
    @os.l
    public static final jn.l<String, byte[]> f(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "algorithm");
        kn.l0.p(str2, "salt");
        return g(str, new b(str2));
    }

    @os.l
    public static final jn.l<String, byte[]> g(@os.l String str, @os.l jn.l<? super String, String> lVar) {
        kn.l0.p(str, "algorithm");
        kn.l0.p(lVar, "salt");
        return new c(str, lVar);
    }

    @os.l
    public static final byte[] h(@os.l byte[] bArr) {
        kn.l0.p(bArr, "bytes");
        return (byte[]) nq.j.b(null, new d(bArr, null), 1, null);
    }
}
