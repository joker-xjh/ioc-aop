package furioussoul.test;

import org.junit.Assert;
import org.junit.Test;

import furioussoul.core.annotation.Component;
import furioussoul.core.packageScanner.PkgScanner;

import java.io.IOException;
import java.util.List;

/**
 * Created by whf on 8/29/15.
 */
@furioussoul.core.annotation.Component
public class SimpleTest {

    @Test
    public void testScanWithName() throws IOException {
        PkgScanner scanner = new PkgScanner("annotation");
        List<String> list = scanner.scan();

       
    }

    @Test
    public void testScanWithAnnotation() throws IOException {
        PkgScanner scanner = new PkgScanner("cn.fh.pkgscanner.test", Component.class);
        List<String> list = scanner.scan();

        Assert.assertTrue(list.indexOf("cn.fh.pkgscanner.test.SimpleTest") != -1);
        Assert.assertTrue(list.indexOf("cn.fh.pkgscanner.test.CannotFindThis") == -1);

    }
}
