package Greedy;

import java.io.IOException;
import java.util.*;

class Huffman_encode_decode {
    int len;
    char c;
    Huffman_encode_decode left, right;

    Huffman_encode_decode(char c, int len) {
        this.c = c;
        this.len = len;
    }

    static HashMap<Character, String> codes = new HashMap<>();
    static int[] arr = new int[26];
    static PriorityQueue<Huffman_encode_decode> p = new PriorityQueue<>(Comparator.comparingInt((Huffman_encode_decode h) -> h.len));

    public static void main(String[] args) throws IOException {
        String s = "Athithyan";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                char c1 = (char) (i + 97);
                p.add(new Huffman_encode_decode(c1, arr[i]));
            }
        }
        while (p.size() != 1) {
            Huffman_encode_decode h1 = p.poll();
            Huffman_encode_decode h2 = p.poll();
            Huffman_encode_decode h3 = new Huffman_encode_decode('$', (h1.len + h2.len));
            if (h1.len <= h2.len) {
                h3.left = h1;
                h3.right = h2;
            } else {
                h3.right = h1;
                h3.left = h2;
            }
            p.add(h3);
        }
        Huffman_encode_decode root = p.peek();
        // Generate Huffman codes
        generateCodes(root, "");
        // Print Huffman codes
        for (char c : codes.keySet()) {
            System.out.println(c + " : " + codes.get(c));
        }/*for (Map.Entry<Character, String> c : codes.entrySet()) {
            System.out.println(c.getKey() + " : " + c.getValue());
        }*/

        String encodedMessage = encodeMessage(s);
        System.out.println("Encoded message: " + encodedMessage);

        String decodedMessage = decodeMessage("01100011100101", root);
        System.out.println("Decoded message: " + decodedMessage);
    }

    static void generateCodes(Huffman_encode_decode root, String code) {
        if (root == null) return;
        if (root.c != '$') {
            codes.put(root.c, code);
            return;
        }
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    static String encodeMessage(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            encoded.append(codes.get(c));
        }
        return encoded.toString();
    }

    static String decodeMessage(String encodedMessage, Huffman_encode_decode root) {
        StringBuilder decoded = new StringBuilder();
        Huffman_encode_decode current = root;
        for (char bit : encodedMessage.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.c != '$') {
                decoded.append(current.c);
                current = root; // Reset to root for next character
            }
        }
        return decoded.toString();
    }
}
