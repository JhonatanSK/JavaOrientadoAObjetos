package br.com.codenation;

public class StatisticUtil {

	public static int average(int[] elements) {
		int result = 0;
		for(int x: elements){
			result += x;
		}
		result = (result/elements.length);
		return result;
	}

	public static int mode(int[] elements) {
		int maxValue = 0;
		int maxCount = 0;

		for (int i = 0; i < elements.length; ++i) {
			int count = 0;
			for (int j = 0; j < elements.length; ++j) {
				if (elements[j] == elements[i]) ++count;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = elements[i];
			}
		}

		return maxValue;
	}

	public static int median(int[] elements) {
		int size = elements.length;
		elements = selectionSort(elements, size);

		if(size % 2 != 0) return elements[size/2];
		else return ((elements[size/2] + elements[(size/2)-1])/2);

	}

	public static int[] selectionSort(int vetor[], int a) {
		int posicao;
		int aux;

		for(int i = 0; i < a-1; i++) {
			posicao = i;
			aux = vetor[i];

			for(int j = i+1; j < a; j++) {
				if(vetor[j] < aux) {
					posicao = j;
					aux = vetor[j];
				}
			}
			vetor[posicao] = vetor[i];
			vetor[i] = aux;
		}
		return vetor;
	}
}