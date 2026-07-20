package nk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends s.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final URI f11563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ik.i f11564c;

    public z(@os.l URI uri, @os.l ik.i iVar) {
        l0.p(uri, "uri");
        l0.p(iVar, "contentType");
        this.f11563b = uri;
        this.f11564c = iVar;
    }

    @Override // nk.s
    @os.l
    public ik.i c() {
        return this.f11564c;
    }

    @Override // nk.s.d
    @os.l
    public pl.k j() throws IOException {
        InputStream inputStreamOpenStream = this.f11563b.toURL().openStream();
        l0.o(inputStreamOpenStream, "uri.toURL().openStream()");
        return yl.i.d(inputStreamOpenStream, null, gl.b.a(), 1, null);
    }

    @os.l
    public final URI l() {
        return this.f11563b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ z(URI uri, ik.i iVar, int i10, kn.w wVar) {
        if ((i10 & 2) != 0) {
            ik.i.c cVar = ik.i.f7981f;
            String path = uri.getPath();
            l0.o(path, "class URIFileContent(\n  …pool = KtorDefaultPool)\n}");
            iVar = ik.w.b(cVar, path);
        }
        this(uri, iVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ z(URL url, ik.i iVar, int i10, kn.w wVar) {
        if ((i10 & 2) != 0) {
            ik.i.c cVar = ik.i.f7981f;
            String path = url.getPath();
            l0.o(path, "constructor(url: URL, co…        contentType\n    )");
            iVar = ik.w.b(cVar, path);
        }
        this(url, iVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public z(@os.l URL url, @os.l ik.i iVar) throws URISyntaxException {
        l0.p(url, RtspHeaders.Values.URL);
        l0.p(iVar, "contentType");
        URI uri = url.toURI();
        l0.o(uri, "url.toURI()");
        this(uri, iVar);
    }
}
