import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import java.util.*;


//@RunWith(Parameterized.class)
public class ArrayOperationsTest {
    // !!!ВЫДАЕТ ОШИБКУ argument type mismatch!!!


 //   @Parameterized.Parameters
//    public static Collection<Integer[][]> dataArrayOperationsTest(){
//        return Arrays.asList(new Integer[][][] {
//                {{1, 2, 3, 6, 7, 8, 12, 5, 4, 6, 9, 2},{6, 9, 2}},
//                {{4, 21, 5, 8, 9, 16, 9, 7, 2, 0, 8},{21, 5, 8, 9, 16, 9, 7, 2, 0, 8}},
//                {{1, 6, 7, 8, 9, 0, 21, 6, 8, 90, 33, 18},{}}
//        });
//    }

    private ArrayOperations arrayOperations;
//    private int[] testArray;
//    private Integer[] expectArray;

//    public ArrayOperationsTest(Integer[] expectArray, int[] testArray) {
//        this.expectArray = expectArray;
//        this.testArray = testArray;
//    }

    @Before
    public void init() {
        arrayOperations = new ArrayOperations();
    }

    @Test
    public void testArrayOperations1() throws Exception {
        Integer[] expectArray = new Integer[]{6, 9, 2};
        int[] testArray = new int[]{1, 2, 3, 6, 7, 8, 12, 5, 4, 6, 9, 2};
        Assert.assertArrayEquals(expectArray, arrayOperations.returnAnotherArray(testArray));
    }

    @Test
    public void testArrayOperations2() throws Exception {
        Integer[] expectArray = new Integer[]{21, 5, 8, 9, 16, 9, 7, 2, 0, 8};
        int[] testArray = new int[]{4, 21, 5, 8, 9, 16, 9, 7, 2, 0, 8};
        Assert.assertArrayEquals(expectArray, arrayOperations.returnAnotherArray(testArray));
    }

    @Test
    public void testArrayOperations3() throws Exception {
        Integer[] expectArray = new Integer[]{};
        int[] testArray = new int[]{1, 6, 7, 8, 9, 0, 21, 6, 8, 90, 33, 18};
        Assert.assertArrayEquals(expectArray, arrayOperations.returnAnotherArray(testArray));
    }

        @Test
    public void testArrayOperations5() {
        int[] arr1 = {1, 4, 1, 4, 4, 4, 1, 1, 4, 1, 1, 4, 4};
        Assert.assertTrue( ArrayOperations.checkArray(arr1));
    }

    @Test
    public void testArrayOperations6() {
        int[] arr2 = {4, 4, 1, 1, 1, 4, 2, 1, 4, 4, 1, 1, 4};
        Assert.assertTrue( ArrayOperations.checkArray(arr2));
    }

    @Test
    public void testArrayOperations7() {
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertTrue( ArrayOperations.checkArray(arr3));
    }

    @Test
    public void testArrayOperations8() {
        int[] arr4 = {4, 4, 4 ,4 ,4 ,4, 4, 4, 4, 4, 4, 4, 4};
        Assert.assertTrue( ArrayOperations.checkArray(arr4));
    }
}


