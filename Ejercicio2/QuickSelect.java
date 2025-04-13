package Ejer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSelect {
	public static int quickSelect(List<Integer> arr, int k) {
		if (arr == null || arr.isEmpty() || k < 1 || k > arr.size()) {
			throw new IllegalArgumentException("Entrada inválida");
		}

		Random random = new Random();
		int pivot = arr.get(random.nextInt(arr.size()));

		List<Integer> lows = new ArrayList<>();
		List<Integer> highs = new ArrayList<>();
		List<Integer> pivots = new ArrayList<>();

		for (int num : arr) {
			if (num < pivot) {
				lows.add(num);
			} else if (num > pivot) {
				highs.add(num);
			} else {
				pivots.add(num);
			}
		}

		if (k <= lows.size()) {
			return quickSelect(lows, k);
		} else if (k <= lows.size() + pivots.size()) {
			return pivot;
		} else {
			return quickSelect(highs, k - lows.size() - pivots.size());
		}
	}
}
