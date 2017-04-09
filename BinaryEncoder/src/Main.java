
public class Main {
	public static void main(String[] args) {
		BinaryEncoder encoder = new BinaryEncoder();
		
//		encoder.decode("0100100001100101011011000110110001101111001000000101011101101111011100100110110001100100");
//		encoder.decode("0111000001101100011001010110000101110011011001010010000001110100011000010110110001101011001"
//				+ "000000111010001101111001000000110110101100101");
//		encoder.decode("0110110001101001011001100110010100100000011100100110100101100111011010000111010000100000011"
//				+ "01110011011110111011100100000011010010111001100100000011011000110111101101110011001010110110001111001");
		
//		String s = "byte";
//		System.out.println(encoder.decode(encoder.encode(s)));
		
		System.out.println();
	}
}

class BinaryEncoder {
	
	public BinaryEncoder() { }
	
	public String encode(String s) {
		String binaryText = "";
		
		for(int i = 0; i < s.length(); i++) {
		}
		
		return binaryText;
	}
	
	public String decode(String s) {
		String text = "";
		
		if(s.matches("[0-1]")) {
			System.out.println("Text cannot be decoded.");
			return null;
		}
		
		for(int i = 0; i < s.length() / 8; i++) {
			int binary = Integer.parseInt(s.substring(8 * i, (i + 1) * 8), 2);
			text += (char) binary;
		}
		
		return text;
	}
}
