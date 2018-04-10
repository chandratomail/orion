package online.orion.orion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass {

	@Test(dataProvider="MinDiffIndicesData")
	public void testMinDifference(int NoOfElements, int[] arrayElement, String expectedResult) throws Exception {
		int actual = Functions.pairOfIndicesMinDifference(NoOfElements, arrayElement);
		Assert.assertEquals(actual, Integer.parseInt(expectedResult), "Actual result is not as expected result");
	}
	
	@Test(dataProvider="failMinDiffIndicesData",expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = "Number in array list is out of range, the number should be >=1 and <=100000")
	public void testErrorMinDifference(int NoOfElements, int[] arrayElement, String expectedResult) throws Exception {
		int actual = Functions.pairOfIndicesMinDifference(NoOfElements, arrayElement);
		Assert.assertEquals(actual, Integer.parseInt(expectedResult), "Actual result is not as expected result");
	}

	@Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = "Provided no.of elements are : 10. But array elements are : 9")
	public void testError2MinDifference() throws Exception {
		int[] arrayData = {1,2,3,4,5,6,7,8,9};
		Functions.pairOfIndicesMinDifference(10, arrayData);
	}
	
	@Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = "Provided no.of elements are : 10. But array elements are : 0")
	public void testError3MinDifference() throws Exception {
		int[] arrayData = {};
		Functions.pairOfIndicesMinDifference(10, arrayData);
	}
	
	@Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = "No.of elements in array should be >=1 and <=1000")
	public void testError4MinDifference() throws Exception {
		int[] arrayData = {};
		Functions.pairOfIndicesMinDifference(0, arrayData);
	}
	
	@DataProvider(name="MinDiffIndicesData")
	public Object[][] successDPForMinDiff() {
				
		int[] arrayData1 = {1,2,3,4,5,6,7,8,9,10}; //-1
		int[] arrayData2 = {1,2,3,1,5,6,2,8,9,10}; //3
		int[] arrayData3 = {1,2,100000,4,5,6,100000,8,9,10}; //4
		int[] arrayData4 = {1}; //-1
		
		Object[][] data = {{10, arrayData1, "-1"},
							{10, arrayData2, "3"},
							{10, arrayData3, "4"},
							{1, arrayData4, "-1"}};
		
		return data;
	}
	
	@DataProvider(name="failMinDiffIndicesData")
	public Object[][] failureDPForMinDiff() {
				
		int[] arrayData1 = {1,-2,3,4,5,6,7,8,9,10}; //Error
		int[] arrayData2 = {1,2,3,0,5,6,7,8,9,10}; //Error
		int[] arrayData3 = {1,2,3,4,5,6,7,100001,9,10}; //Error
		
		Object[][] data = {{10, arrayData1, "Number in array list is out of range, the number should be >=1 and <=100000"},
							{10, arrayData2, "Number in array list is out of range, the number should be >=1 and <=100000"},
							{10, arrayData3, "Number in array list is out of range, the number should be >=1 and <=100000"}};
		
		return data;
	}
	



}
