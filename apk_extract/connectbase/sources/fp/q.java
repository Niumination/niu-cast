package fp;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface q extends r {

    public interface a extends Cloneable, r {
        q build();

        a c(e eVar, g gVar) throws IOException;
    }

    s<? extends q> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(f fVar) throws IOException;
}
