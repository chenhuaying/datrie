/*
 * Copyright 2010 Christos Gioran
 *
 * This file is part of DoubleArrayTrie.
 *
 * DoubleArrayTrie is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DoubleArrayTrie is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DoubleArrayTrie.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.digitalstain.datrie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.digitalstain.datrie.mapping.CharacterNaturalMapping;
import org.digitalstain.datrie.store.IntegerArrayList;
import org.digitalstain.datrie.store.IntegerList;

public class TestDoubleArrayTrie extends TestCase {

	// public void testRobustnessUnderStress() {

	// 	// final int NUMBER_OF_STRINGS = 100000;
	// 	// final int MAXIMUM_STRING_SIZE = 100;
	// 	// final int ALPHABET_SIZE = 120;
	// 	final int ALPHABET_SIZE = 10;
	// 	final int NUMBER_OF_STRINGS = 5;
	// 	final int MAXIMUM_STRING_SIZE = 5;

	// 	List<IntegerList> data = new ArrayList<IntegerList>(NUMBER_OF_STRINGS);
	// 	AbstractDoubleArrayTrie trie = new DoubleArrayTrieImpl(ALPHABET_SIZE);
	// 	Random rng = new Random();

	// 	for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
	// 		IntegerList toAdd = new IntegerArrayList(MAXIMUM_STRING_SIZE);
	// 		for (int j = 0; j < MAXIMUM_STRING_SIZE; j++) {
	// 			toAdd.add(rng.nextInt(ALPHABET_SIZE));
	// 		}
	// 		data.add(toAdd);
	// 	}

	// 	for (IntegerList list : data) {
	// 		assertTrue(trie.addToTrie(list));
	// 		assertFalse(trie.addToTrie(list));
	// 	}

	// 	for (IntegerList list : data) {
	// 		assertEquals(SearchResult.PERFECT_MATCH, trie.containsPrefix(list));
	// 	}

	// 	for (IntegerList list : data) {
	// 		int removeSize = rng.nextInt(list.size()) + 1;
	// 		for (; removeSize > 0; removeSize--) {
	// 			list.remove(list.size() - 1);
	// 		}
	// 		assertEquals(SearchResult.PURE_PREFIX, trie.containsPrefix(list));
	// 	}

	// 	// TODO
	// 	// Insert a NOT_FOUND test here that is on the one hand random and
	// 	// on the other succeeds always regardless of the generated strings.
	// 	System.out.println(".>>>>>>> alphabet size: " + trie.getAlphabetSize());
	// 	System.out.println(".>>>>>>> base size: " + trie.getSize());
	// 	int baseSize = trie.getSize();
	// 	for (int i = 0; i < baseSize; i++) {
	// 		System.out.println(trie.getBase(i));
	// 	}
	// }

	// public void testMarginCases() {
	// 	AbstractDoubleArrayTrie trie = new DoubleArrayTrieImpl(3);

	// 	IntegerList empty = new IntegerArrayList();
	// 	assertEquals(SearchResult.PURE_PREFIX, trie.containsPrefix(empty));

	// 	IntegerList notIn = new IntegerArrayList();
	// 	notIn.add(1);
	// 	notIn.add(2);
	// 	assertEquals(SearchResult.NOT_FOUND, trie.containsPrefix(notIn));
	// 	assertEquals(SearchResult.PURE_PREFIX, trie.containsPrefix(empty));

	// 	IntegerList one = new IntegerArrayList();
	// 	one.add(2);

	// 	assertFalse(trie.addToTrie(empty));
	// 	assertTrue(trie.addToTrie(one));
	// 	assertFalse(trie.addToTrie(empty));
	// 	assertEquals(SearchResult.PURE_PREFIX, trie.containsPrefix(empty));

	// 	assertEquals(SearchResult.PERFECT_MATCH, trie.containsPrefix(one));
	// 	assertEquals(SearchResult.PURE_PREFIX, trie.containsPrefix(empty));

	// 	one.add(1);
	// 	assertEquals(SearchResult.NOT_FOUND, trie.containsPrefix(one));
	// }

	// public void testCountingTrie() {
	// 	CountingTrie trie = new CountingTrie(4);
	// 	IntegerList string1 = new IntegerArrayList();
	// 	string1.add(0);
	// 	string1.add(1);
	// 	string1.add(2);
	// 	string1.add(3);
	// 	IntegerList string2 = new IntegerArrayList();
	// 	string2.add(1);
	// 	string2.add(2);
	// 	string2.add(3);
	// 	trie.addToTrie(string1);
	// 	trie.addToTrie(string2);
	// 	assertEquals(SearchResult.PERFECT_MATCH, trie.containsPrefix(string1));
	// 	assertEquals(SearchResult.PERFECT_MATCH, trie.containsPrefix(string2));
	// 	assertEquals(2, trie.getSearchCountFor(string1));
	// 	assertEquals(3, trie.getSearchCountFor(string1));
	// 	assertEquals(2, trie.getSearchCountFor(string2));
	// 	assertEquals(3, trie.getSearchCountFor(string2));

	// 	IntegerList string3 = new IntegerArrayList();
	// 	string3.add(1);
	// 	string3.add(2);
	// 	assertEquals(0, trie.getSearchCountFor(string3));
	// }

	public void testMappingCases() {
		CharacterNaturalMapping cnm = CharacterNaturalMapping.getInstance();
		String toMap1 = "abc12\n3H\tiThere!!!()";
		AbstractDoubleArrayTrie trie;
		int nat;
		IntegerList list1 = new IntegerArrayList();
		for(Character c : toMap1.toCharArray()) {
			nat = cnm.toNatural(c);
			list1.add(nat);
		}

		String toMap2 = "abcABCHi";
		IntegerList list2 = new IntegerArrayList();
		for(Character c : toMap2.toCharArray()) {
			nat = cnm.toNatural(c);
			list2.add(nat);
		}
		for(int i = 0; i < list1.size(); i++) {
			list1.set(i, list1.get(i));
		}
		for(int i = 0; i < list2.size(); i++) {
			list2.set(i, list2.get(i));
		}
		trie = new DoubleArrayTrieImpl(cnm.getN());
		trie.addToTrie(list1);
		trie.addToTrie(list2);
		assert trie.containsPrefix(list1) == SearchResult.PERFECT_MATCH;
		assert trie.containsPrefix(list2) == SearchResult.PERFECT_MATCH;
		list2.remove(list2.size() - 1);
		assert trie.containsPrefix(list2) == SearchResult.PURE_PREFIX;
		list1.set(list1.size() - 1, 90);
		assert trie.containsPrefix(list1) == SearchResult.NOT_FOUND;
		System.out.println("alphabet size: " + trie.getAlphabetSize());	
		System.out.println("base and check size: " + trie.getSize());	
	}
}
