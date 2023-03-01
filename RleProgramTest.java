import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RleProgramTest {
    @Test
    public void countRunsTest() {
        byte[] flatData = {4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 7};
        int group = 6; //expected result
        assertEquals(group, RleProgram.countRuns(flatData));
    }

    @Test
    public void getDecodedLengthTest() {
        byte[] rleData = {3, 15, 6, 4};
        int integer = 9;
        assertEquals(integer, RleProgram.getDecodedLength(rleData));
    }

    @Test
    public void decodeRleTest() {
        byte[] rleData = {2, 4, 15, 1, 15, 1, 5, 1, 1, 8, 1, 7};
        byte[] answer = {4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 7};
        assertArrayEquals(answer, RleProgram.decodeRle(rleData));
    }

    @Test
    public void toHexStringTest() {
        byte[] data = {3, 15, 6, 4};
        String yields = "3f64";
        assertEquals(yields, RleProgram.toHexString(data));
    }

    @Test
    public void stringtoDataTest() {
        String rleData = "3f64";
        byte[] answer = {3, 15, 6, 4};
        assertArrayEquals(answer, RleProgram.stringToData(rleData));

    }

    @Test
    public void encodeRleTest() {
        byte[] flatData = {4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 7};
        //{ 15, 15, 15, 4, 4, 4, 4, 4, 4};
        //{4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,7};
        byte[] rleData = {2, 4, 15, 1, 15, 1, 5, 1, 1, 8, 1, 7};
        //{ 3, 15, 6, 4};
        //{2,4,15,1,15,1,5,1,1,8,1,7};
        byte[] actualResults = RleProgram.encodeRle(flatData);
        assertArrayEquals(rleData, RleProgram.encodeRle(flatData));
    }

    @Test
    public void toRleStringTest() {
        byte[] rleData = {15, 15, 6, 4};
        String answer = "15f:64";
        assertEquals(answer, RleProgram.toRleString(rleData));

    }
    @Test
    public void stringtoRleTest(){
        String rleString = "15f:64";
        byte[] answer = {15, 15, 6, 4 };
        assertArrayEquals(answer, RleProgram.stringToRle(rleString));
    }
}

