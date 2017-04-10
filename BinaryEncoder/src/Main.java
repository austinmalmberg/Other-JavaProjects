public class Main {
	public static void main(String[] args) {
		BinaryEncoder encoder = new BinaryEncoder();
		
		String[] binary = {
				"0100100001100101011011000110110001101111001000000101011101101111011100100110110001100100",
				
				"0111000001101100011001010110000101110011011001010010000001110100011000010110110001101011"
				+ "001000000111010001101111001000000110110101100101",
				
				"0110110001101001011001100110010100100000011100100110100101100111011010000111010000100000"
				+ "01101110011011110111011100100000011010010111001100100000011011000110111101101110011001"
				+ "010110110001111001"
				};
		
		for(String s : binary) {
			System.out.println(encoder.decode(s));
		}
		
		String str = "byte";
		System.out.println(encoder.decode(encoder.encode(str)));
		
	}
}

class BinaryEncoder {
	
	public BinaryEncoder() { }
	
	public String encode(String s) {
		String binaryText = "";
		
		for(char c : s.toCharArray()) {
			int bi = Integer.parseInt(Integer.toBinaryString(c));
			binaryText += String.format("%08d", bi);
		}
		
		return binaryText;
	}
	
	public String decode(String s) {
		String text = "";
		
		if(s.length() % 8 > 0 ||
				!s.matches("[01]+")) {
			System.out.println("\"" + s + "\" cannot be decoded.");
			return "";
		}
		
		for(int i = 0; i < s.length() / 8; i++) {
			int binary = Integer.parseInt(s.substring(8 * i, (i + 1) * 8), 2);
			text += (char) binary;
		}
		
		return text;
	}
}
