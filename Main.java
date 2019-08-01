public class Main{
	public static void main(String[] args) {
		
		String sample = "i love my car hahaha";

		int[] charFrequencies = new int[256];

		for(char c: sample.toCharArray()){
			charFrequencies[c]++;
		}

		HuffmanCode code = new HuffmanCode();
		HuffmanTree huffmanTree = code.buildTree(charFrequencies);
		code.printCodes(huffmanTree, new StringBuilder());
	}
}