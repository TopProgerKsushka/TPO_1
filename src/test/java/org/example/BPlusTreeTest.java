package org.example;

import org.example.part2.BPlusTree;
import org.example.part2.BTreeInnerNode;
import org.junit.Test;
import org.junit.Assert;

import java.util.Optional;

public class BPlusTreeTest extends Assert {

    BPlusTree<Integer, Integer> bplustree = new BPlusTree<>(4);

    @Test
    public void checkInitialState() {
        assertEquals(bplustree.getRoot().getKeyCount(), 0);
    }

    @Test
    public void checkSimpleInsertingElement() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        assertEquals(bplustree.getRoot().getKeyCount(), 3);
        assertEquals(bplustree.getRoot().getKey(0), 1);
        assertEquals(bplustree.getRoot().getKey(1), 4);
        assertEquals(bplustree.getRoot().getKey(2), 7);
    }
    @Test
    public void checkInsertingElement() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        bplustree.insert(10, 10);

        assertEquals(bplustree.getRoot().getKeyCount(), 1);
        assertEquals(bplustree.getRoot().getKey(0), 7);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKeyCount(), 2);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKeyCount(), 2);

        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKey(0), 1);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKey(1), 4);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKey(0), 7);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKey(1), 10);
    }
    @Test
    public void checkExistingSearch() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        bplustree.insert(10, 10);

        assertEquals(Optional.ofNullable(bplustree.search(1)),Optional.of(1));
        assertEquals(Optional.ofNullable(bplustree.search(4)), Optional.of(4));
        assertEquals(Optional.ofNullable(bplustree.search(7)), Optional.of(7));
        assertEquals(Optional.ofNullable(bplustree.search(10)), Optional.of(10));
    }

    @Test
    public void checkNotExistingSearch() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        bplustree.insert(10, 10);

        assertEquals(Optional.ofNullable(bplustree.search(0)), Optional.empty());
        assertEquals(Optional.ofNullable(bplustree.search(2)), Optional.empty());
        assertEquals(Optional.ofNullable(bplustree.search(5)), Optional.empty());
        assertEquals(Optional.ofNullable(bplustree.search(8)), Optional.empty());
        assertEquals(Optional.ofNullable(bplustree.search(11)), Optional.empty());
    }

    @Test
    public void checkNotExistingRemove() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        bplustree.insert(10, 10);

        bplustree.delete(0);
        bplustree.delete(2);
        bplustree.delete(5);
        bplustree.delete(8);
        bplustree.delete(11);

        assertEquals(bplustree.getRoot().getKeyCount(), 1);
        assertEquals(bplustree.getRoot().getKey(0), 7);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKeyCount(), 2);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKeyCount(), 2);

        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKey(0), 1);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(0).getKey(1), 4);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKey(0), 7);
        assertEquals(((BTreeInnerNode)bplustree.getRoot()).getChild(1).getKey(1), 10);

    }

    @Test
    public void checkExistingRemove() {
        bplustree.insert(1, 1);
        bplustree.insert(4, 4);
        bplustree.insert(7, 7);
        bplustree.delete(7);

        assertEquals(bplustree.getRoot().getKeyCount(), 2);
        assertEquals(bplustree.getRoot().getKey(0), 1);
        assertEquals(bplustree.getRoot().getKey(1), 4);
    }
}
