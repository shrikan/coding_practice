package Commons;

import java.util.ArrayList;
import java.util.List;

public class WeightedNode {
	public int val;
	public List<WeightedNode> neighbors;
	public List<Integer> weights;

	public WeightedNode() {
		val = 0;
		neighbors = new ArrayList<>();
		weights = new ArrayList<>();
	}

	public WeightedNode(int _val) {
		val = _val;
		neighbors = new ArrayList<>();
		weights = new ArrayList<>();
	}

	public WeightedNode(int _val, ArrayList<WeightedNode> _neighbors, ArrayList<Integer> _weights) {
		val = _val;
		neighbors = _neighbors;
		weights = _weights;
	}
}
