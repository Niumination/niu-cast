package okhttp3.internal.publicsuffix;

import bd.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.sc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import lj.m;
import qj.t;
import vj.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "bd/b", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class PublicSuffixDatabase {
    public static final byte[] e = {(byte) 42};
    public static final List f = CollectionsKt.listOf(e.ANY_MARKER);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f8569g = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f8570a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f8571b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f8572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f8573d;

    public static List c(String str) {
        List listSplit$default = StringsKt__StringsKt.split$default(str, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual((String) CollectionsKt.last(listSplit$default), "") ? CollectionsKt___CollectionsKt.dropLast(listSplit$default, 1) : listSplit$default;
    }

    public final String a(String domain) {
        String strC;
        String strC2;
        String strC3;
        List listEmptyList;
        List listEmptyList2;
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List listC = c(unicodeDomain);
        if (this.f8570a.get() || !this.f8570a.compareAndSet(false, true)) {
            try {
                this.f8571b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z2 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (Throwable th2) {
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                        throw th2;
                    }
                } catch (InterruptedIOException unused2) {
                    Thread.interrupted();
                    z2 = true;
                } catch (IOException e4) {
                    m mVar = m.f7532a;
                    m.f7532a.getClass();
                    m.f("Failed to read public suffix list", 5, e4);
                    if (z2) {
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f8572c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i8 = 0; i8 < size3; i8++) {
            String str = (String) listC.get(i8);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i8] = bytes;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                strC = null;
                break;
            }
            byte[] bArr2 = this.f8572c;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            strC = b.c(bArr2, bArr, i9);
            if (strC != null) {
                break;
            }
            i9++;
        }
        if (size3 <= 1) {
            strC2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                strC2 = null;
                break;
            }
            bArr3[i10] = e;
            byte[] bArr4 = this.f8572c;
            if (bArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            strC2 = b.c(bArr4, bArr3, i10);
            if (strC2 != null) {
                break;
            }
            i10++;
        }
        if (strC2 == null) {
            strC3 = null;
            break;
        }
        int i11 = size3 - 1;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                strC3 = null;
                break;
            }
            byte[] bArr5 = this.f8573d;
            if (bArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
            }
            strC3 = b.c(bArr5, bArr, i12);
            if (strC3 != null) {
                break;
            }
            i12++;
        }
        if (strC3 != null) {
            listEmptyList2 = StringsKt__StringsKt.split$default("!".concat(strC3), new char[]{'.'}, false, 0, 6, (Object) null);
        } else if (strC == null && strC2 == null) {
            listEmptyList2 = f;
        } else {
            if (strC == null || (listEmptyList = StringsKt__StringsKt.split$default(strC, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (strC2 == null || (listEmptyList2 = StringsKt__StringsKt.split$default(strC2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            if (listEmptyList.size() > listEmptyList2.size()) {
                listEmptyList2 = listEmptyList;
            }
        }
        if (listC.size() == listEmptyList2.size() && ((String) listEmptyList2.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listEmptyList2.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listEmptyList2.size();
        } else {
            size = listC.size();
            size2 = listEmptyList2.size() + 1;
        }
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(c(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final void b() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            t tVarB = sc.b(new qj.m(sc.e(resourceAsStream)));
            try {
                long j8 = tVarB.readInt();
                tVarB.K(j8);
                byte[] bArrM = tVarB.f9222b.m(j8);
                long j10 = tVarB.readInt();
                tVarB.K(j10);
                byte[] bArrM2 = tVarB.f9222b.m(j10);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(tVarB, null);
                synchronized (this) {
                    Intrinsics.checkNotNull(bArrM);
                    this.f8572c = bArrM;
                    Intrinsics.checkNotNull(bArrM2);
                    this.f8573d = bArrM2;
                }
                this.f8571b.countDown();
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(tVarB, th2);
                    throw th3;
                }
            }
        }
    }
}
