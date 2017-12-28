public static int percentile(int [] inputArray, double rank) {
		int arrayLength	=	inputArray.length;
		double rankCalc	=	Math.round((rank / 100) * arrayLength);
		int rankpos		=	0;
		for (int i = 1 ; i < inputArray.length; i++) {
			if(i  == rankCalc) {
				rankpos =  inputArray[i-1];
			}
		
		}
		
		return rankpos;
	}