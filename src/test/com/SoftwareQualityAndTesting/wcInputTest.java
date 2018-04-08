package test.com.SoftwareQualityAndTesting; 

import com.SoftwareQualityAndTesting.wcInput;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Collection;

/** 
* wcInput Tester. 
* 
* @author <Authors name> 
* @since <pre>ËÄÔÂ 8, 2018</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class wcInputTest {
    String expected1="";
    String []input1;
    String expected2="";
    String []input2;

    @Parameterized.Parameters
    public static Collection t()
    {
        return Arrays.asList(new Object[][]{
                {"no file",new String[]{},"",new String[]{}},
                {"so many files",new String[]{"test.txt","test1.txt"},"",new String[]{}},
                {"not correct file",new String[]{""},"",new String[]{}},
                {"not correct file",new String[]{"test"},"",new String[]{}},
                {"not correct file",new String[]{"test.c"},"",new String[]{}},
                {"not correct file",new String[]{"test.java"},"",new String[]{}},
                {"so many files",new String[]{"test1.c","test1.txt"},"",new String[]{}},
                {"so many files",new String[]{"test1.java","test1.c"},"",new String[]{}},
                {"so many files",new String[]{"test1.txt","test1.c"},"",new String[]{}},
                {"test.txt",new String[]{"test.txt"},"",new String[]{}},
                {"test1.txt",new String[]{"test1.txt"},"w",new String[]{"test1.txt"}},
                {"test2.txt",new String[]{"test2.txt"},"wc wc wc",new String[]{"test2.txt"}},
                {"test3.txt",new String[]{"test3.txt"},"wcwcwc",new String[]{"test3.txt"}},
                {"test4.txt",new String[]{"test4.txt"},"wc wc# wc",new String[]{"test4.txt"}},
                {"test5.txt",new String[]{"test5.txt"},"wc$%^&@#$%^&",new String[]{"test5.txt"}},
                {"test6.txt",new String[]{"test6.txt"},"wc usw\r\n" +
                        "awdc",new String[]{"test6.txt"}},
                {"test7.txt",new String[]{"test7.txt"},"wc cua\r\n" +
                        "wcq\r\n" +
                        "qcq\r\n" +
                        "qc",new String[]{"test7.txt"}},
                {"test8.txt",new String[]{"test8.txt"},"wc \r\n" +
                        "wc  \r\n" +
                        "wc   ",new String[]{"test8.txt"}},
                {"test9.txt",new String[]{"test9.txt"},"wc wc\r\n" + "wc#$%\r\n",new String[]{"test9.txt"}},
                {"test10.txt",new String[]{"test10.txt"},"wc acrs\r\n" +
                        "wcsvsrvdt\r\n" +
                        "cwcsrbdbskjnvfdnsvnlmbs\r\n" +
                        "wcsnvkjnsnvlsmlm\r\n" +
                        "canjdshva",new String[]{"test10.txt"}},
                {"test11.txt",new String[]{"test11.txt"},"nvsknfdnvlankvdnkjlanvkjldvkjnaskjvdjdncaknckdcnakvbnkjbvkdankbksjdckadbskcdbskcba",new String[]{"test11.txt"}},
                {"test12.txt",new String[]{"test12.txt"},"jkzbcan@#$^&@*(@(@)ncbddsnlnakj&^#%@^!(!^#&^!(&($^@!($",new String[]{"test12.txt"}},
                {"test13.txt",new String[]{"test13.txt"},"zcncdkn msc\r\n" + "\r\n" + "\r\n" + "dsdcbdkb\r\n" + "\r\n" + "\r\n" + "cbdk",new String[]{"test13.txt"}},
                {"test14.txt",new String[]{"test14.txt"},"ncskdbja !!!!\r\n" + "csnekjnk!!!!!\r\n" + "\r\n" + "\r\n" + "\r\n" + "hdhs    cs\r\n" + "bcjhb\r\n" + "\r\n" + "\r\n" + "\r\n" + "nks",new String[]{"test14.txt"}},
                {"test15.txt",new String[]{"test15.txt"},"iiiiiiiiii\r\n" + "iiiiiiiiiiii\r\n" + "iiiiiiiiiiiiii\r\n" + "iiiiiiiiiiiiiiii\r\n" + "iiiiiiiiiiiiiiiiii\r\n" + "iiiiiiiiiiiiiiiiiiiii",new String[]{"test15.txt"}}


        });

    }

    public wcInputTest(String expected1,String[] input1,String expected2,String[] input2)
    {
        this.expected1=expected1;
        this.input1=input1;
        this.expected2=expected2;
        this.input2=input2;
    }

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: judgeInput(String[] args) 
* 
*/ 
@Test
public void testJudgeInput() throws Exception { 
//TODO: Test goes here...
    wcInput wci = new wcInput();
    String res=wci.judgeInput(input1);
    assertEquals(expected1, res);

} 

/** 
* 
* Method: readFileContent() 
* 
*/ 
@Test
public void testReadFileContent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getFileContent() 
* 
*/ 
@Test
public void testGetFileContent() throws Exception {
//TODO: Test goes here...
    if(!expected2.equals(""))
    {
        wcInput wci = new wcInput();
        wci.judgeInput(input2);
        wci.readFileContent();
        String res1 = wci.getFileContent();
        assertEquals(expected2, res1);
    }
} 


} 
