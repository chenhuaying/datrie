package org.digitalstain.datrie;

import org.digitalstain.datrie.store.IntegerArrayList;
import org.digitalstain.datrie.store.IntegerList;
import org.junit.Test;

public class TestDatrie {
	@Test
	public void testDatrie() {
		IntegerList string1 = new IntegerArrayList();
		string1.add(6);
		string1.add(1);
		string1.add(0);
		string1.add(0);
		string1.add(1);

		IntegerList string2 = new IntegerArrayList();
		string2.add(6);
		string2.add(1);
		string2.add(0);
		string2.add(1);
		string2.add(1);

		IntegerList string3 = new IntegerArrayList();
		string3.add(5);
		string3.add(1);
		string3.add(1);
		string3.add(0);
		string3.add(1);

		IntegerList string4 = new IntegerArrayList();
		string4.add(5);
		string4.add(1);
		string4.add(1);
		string4.add(0);
		string4.add(2);

		AbstractDoubleArrayTrie trie = new DoubleArrayTrieImpl(10);
		trie.addToTrie(string1);
		trie.addToTrie(string2);
		trie.addToTrie(string3);
		// trie.addToTrie(string4);

		System.out.println("base and check size: " + trie.getSize());
		for (int i = 0; i < trie.getSize(); i++) {
			System.out.println(i + "\t base: " + trie.getBase(i) + ", check: " + trie.getCheck(i));
		}
	}
}
