package i3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kn.l0;
import os.l;
import r2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends f3.c<g> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final Socket f7716d;

    public f(@l Socket socket) {
        l0.p(socket, t2.a.f15434a);
        this.f7716d = socket;
    }

    @Override // f3.c
    @l
    public z2.a<g> a() throws IOException {
        InputStream inputStream = this.f7716d.getInputStream();
        l0.o(inputStream, "getInputStream(...)");
        return new c(inputStream);
    }

    @Override // f3.c
    @l
    public z2.b<g> b() throws IOException {
        OutputStream outputStream = this.f7716d.getOutputStream();
        l0.o(outputStream, "getOutputStream(...)");
        return new d(outputStream);
    }

    @Override // f3.c, z2.c
    public void stop() {
        super.stop();
        try {
            this.f7716d.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
