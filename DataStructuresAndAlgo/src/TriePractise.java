import java.util.HashMap;
import java.util.Map;

class Trie {
	class TrieNode {
		public boolean isWord;
		public Map<Character, TrieNode> childrenMap = new HashMap<>();
	}

	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.childrenMap.get(c) == null) {
				// insert a new node if the path does not exist
				cur.childrenMap.put(c, new TrieNode());
			}
			// We have that character so go to next level
			cur = cur.childrenMap.get(c);
		}
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.childrenMap.get(c) == null) {
				return false;
			}
			cur = cur.childrenMap.get(c);
		}
		return cur.isWord; // We store true and false at end of word
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 *
	 */
	// Exactly same as search
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.childrenMap.get(c) == null) {
				return false;
			}
			cur = cur.childrenMap.get(c);
		}
		return true;
	}
}