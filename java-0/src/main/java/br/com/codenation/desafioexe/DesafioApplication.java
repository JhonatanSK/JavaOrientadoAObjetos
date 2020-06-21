package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		int result = 1;
		int position = 0;
		boolean verify = true;

		List<Integer> list = new ArrayList<>();
		list.add(0);

		while(verify){
			list.add(result);
			result = result + list.get(position);
			position++;
			if(result > 350){
				list.add(result);
				break;
			}
		}
		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> list = fibonacci();
		return list.contains(a);
	}

}