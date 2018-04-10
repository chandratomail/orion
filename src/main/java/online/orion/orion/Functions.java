package online.orion.orion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Functions {

	
	/**
	 * @Description : The below method finds minimum difference between pair of indices and returns the value
	 * @param n : No.of array elements
	 * @param a : array to find minimum difference between pair of indices
	 * @return : returns the minimum difference between pair of indices
	 * @throws Exception
	 */
	public static int pairOfIndicesMinDifference(int n, int[] a) throws Exception {

		//n and array elements length should be equal as per the constraint
		if(n==a.length ) {

			//n range should be as below as per the constraint 1 <= n <= 1000
			if(n>=1 && n<=1000) {

				//list to store all duplicate number
				List<Integer> duplicatesList=new ArrayList<Integer>();
				//map to store duplicate indices
				Map<Integer, Integer> indicesMap = new HashMap<Integer, Integer>();

				for(int i=0;i<a.length;i++) {
					//array elements should be as below as per the constraint 1 <= a[i] <= 100000
					if(a[i]>=1 && a[i] <= 100000) {

						//Iterating for searching all duplicates
						for(int j=0;j<a.length;j++) {

							//Searching for an element in an array for finding duplicate, max is n operations to find for an element
							if(a[i]==a[j] && i!=j) {
								if(!(duplicatesList.contains(a[i]))) {
									indicesMap.put(i, a[i]);
									duplicatesList.add(a[j]);
								} else if(duplicatesList.contains(a[i]) && indicesMap.containsValue(a[i])) {
									for(Entry<Integer, Integer> entry:indicesMap.entrySet()) {
										if(entry.getValue()==a[i] && entry.getValue()!=entry.getKey()) {
											indicesMap.put(entry.getKey(), i);
										}
									}

								}
							}
						}
					} else {
						throw new Exception("Number in array list is out of range, the number should be >=1 and <=100000");
					}
				}
				return minDiffBetweenKeyValue(indicesMap);

			} else {
				throw new Exception("No.of elements in array should be >=1 and <=1000");
			}
		} else {
			throw new Exception("Provided no.of elements are : "+n+". But array elements are : "+a.length);
		}
	}


	/**
	 * Description: Finds differences of all keys and indices and returns the minimum one
	 * @param indexMap
	 * @return
	 */
	public static int minDiffBetweenKeyValue(Map<Integer, Integer> indexMap) {
		int minDiff=-1;
		for(Entry<Integer, Integer> entry:indexMap.entrySet()) {
			int diff = Math.abs(entry.getKey()-entry.getValue());
			if(minDiff==-1) {
				minDiff=diff;
			}
			else if(minDiff>diff){
				minDiff=diff;
			}
		}
		return minDiff;
	}
}
