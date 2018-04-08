package test.com.SoftwareQualityAndTesting; 

import com.SoftwareQualityAndTesting.wcMainProcess;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

/** 
* wcMainProcess Tester. 
* 
* @author 张付俊
* @since <pre>���� 6, 2018</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class wcMainProcessTest {

private static Vector<Map<String, Integer>> expectsOfWordFrequency = new Vector<>();
private Map<String,Integer> expectOfWordFrequency = new HashMap<>();
private Map<String, Integer> actualOfWordFrequency = new HashMap<>();

private static Vector<String> usecasesOfWordFrequency = new Vector<>();
private static Vector<String> usecasesOfWord = new Vector<>();
private static Vector<String> expectsOfWord = new Vector<>();
private String expectOfWord, actualOfWord;


@BeforeClass
public static void beforeClass() throws Exception {
    InputStreamReader isr = new InputStreamReader(new FileInputStream("testCountWordFrequency.txt"));
    BufferedReader br = new BufferedReader(isr);
    String s;
    while((s = br.readLine()) != null) {
        usecasesOfWordFrequency.addElement(s);
    }
    isr = new InputStreamReader(new FileInputStream("testCountWordFrequencyResult.txt"));
    br = new BufferedReader(isr);
    while((s = br.readLine()) != null)
    {
        if(s.isEmpty()) {
            expectsOfWordFrequency.addElement(new HashMap<>());
        } else
        {
            HashMap<String, Integer> each = new HashMap<>();
            String[] temp = s.split(";");
            for(String t:temp)
            {
                String[] tuple = t.split(" ");
                each.put(tuple[0], Integer.parseInt(tuple[1]));
            }
            expectsOfWordFrequency.addElement(each);
        }
    }


    isr = new InputStreamReader(new FileInputStream("testWord.txt"));
    br = new BufferedReader(isr);
    while((s = br.readLine()) != null) {
        usecasesOfWord.addElement(s);
    }
    isr = new InputStreamReader(new FileInputStream("testWordResult.txt"));
    br = new BufferedReader(isr);
    while((s = br.readLine()) != null) {
        expectsOfWord.addElement(s);
    }
} 

@Before
public void before() throws Exception{
}

@After
public void after() throws Exception { 
} 


public wcMainProcessTest(int index){
    wcMainProcess wcmp = new wcMainProcess(usecasesOfWord.elementAt(index));
    actualOfWord = wcmp.Word().toString();
    expectOfWord = expectsOfWord.elementAt(index);
    wcmp = new wcMainProcess(usecasesOfWordFrequency.elementAt(index));
    actualOfWordFrequency = wcmp.countWordFrequency();
    expectOfWordFrequency = expectsOfWordFrequency.elementAt(index);

}

@Parameterized.Parameters
public static Collection testData(){
    return Arrays.asList(new Object[][]
            {
            { 0 },
            { 1 },
            { 2 },
            { 3 },
            { 4 },
            { 5 },
            { 6 },
            { 7 },
            { 8 },
            { 9 },
            { 10 },
            { 11 },
            { 12 },
            { 13 },
            { 14 },
            });
}

/** 
* 
* Method: countWordFrequency() 
* 
*/ 
@Test
public void testCountWordFrequency() throws Exception {
    assertEquals(expectOfWordFrequency, actualOfWordFrequency);
} 

/** 
* 
* Method: Word() 
* 
*/ 
@Test
public void testWord() throws Exception
{
    assertEquals(expectOfWord,actualOfWord);
}


} 
