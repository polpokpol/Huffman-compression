import java.util.PriorityQueue;

public class HuffmanCode {
	
	public HuffmanTree buildTree(int[] charFrequencies){

		PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();

		for (int i = 0; i < charFrequencies.length; i++) {
			if(charFrequencies[i] > 0){
				queue.add(new HuffmanLeaf(charFrequencies[i], (char) i)); // ASCII
			}
		}

		while(queue.size() > 1){

			HuffmanTree tree1 = queue.poll();
			HuffmanTree tree2 = queue.poll();

			queue.add(new HuffmanNode(tree1, tree2));
		}

		return queue.poll();
	}

	public void printCodes(HuffmanTree tree, StringBuilder prefix){

		if( tree instanceof HuffmanLeaf ){
			HuffmanLeaf leaf = (HuffmanLeaf) tree;
			System.out.println(leaf.getValue() + "\t" + leaf.getFrequency() + "\t" + prefix);
		}
		else{

			HuffmanNode node = (HuffmanNode) tree;

			prefix.append("0");
			printCodes(node.getLeftTree(), prefix);
			prefix.deleteCharAt(prefix.length() - 1);

			prefix.append("1");
			printCodes(node.getRightTree(), prefix);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}