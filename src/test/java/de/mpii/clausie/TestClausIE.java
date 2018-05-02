package de.mpii.clausie;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Kenneth.Tan
 * @since 2018-05-02
 */
@RunWith(JUnit4.class)
public class TestClausIE {
    private static File outDir;
    private static URL inputFile;

    @BeforeClass
    public static void setUp() {
        inputFile = TestClausIE.class.getResource("task2_ref1.txt");
        outDir = new File("test_output");
        outDir.mkdirs();
    }

    @Test
    public void main() throws IOException {
        ClausIE.main(new String[]{"-vf",
                                  inputFile.getFile(), "-o",
                                  outDir + "test"});
    }
}
