package com.algos.structure.tree;

import com.algos.sort.InsertionSorter;
import com.algos.sort.Sorter;
import com.algos.sort.SorterHelper;
import com.algos.structure.simple.TableIterator;
import com.algos.structure.symboltable.ComparableSymbolTable;
import com.algos.structure.symboltable.TableSupplier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * User: sennen
 * Date: 05/04/2014
 * Time: 20:14
 */
public class BinarySearchTree<X extends Comparable<X>, Y> implements ComparableSymbolTable<X, Y> {
    private final TableSupplier<X> keysTableSupplier;
    private BinaryTreeNode<X, Y> root;
    private int size;

    public BinarySearchTree(TableSupplier<X> keysTableSupplier) {
        this.keysTableSupplier = keysTableSupplier;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
        size--;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
        size--;
    }

    @Override
    public void put(X key, Y value) {
        root = put(root, key, value);
    }

    @Override
    public Y get(X key) {
        return get(root, key);
    }

    @Override
    public void delete(X key) {
        root = delete(root, key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public X min() {
        return getExtreme(BinaryTreeNode<X, Y>::getLeftNode, root).getKey();
    }

    @Override
    public X max() {
        return getExtreme(BinaryTreeNode<X, Y>::getRightNode, root).getKey();
    }

    @Override
    public X floor(X key) {
        BinaryTreeNode<X, Y> floorNode = floor(root, key);
        return floorNode == null ? null : floorNode.getKey();
    }

    @Override
    public X ceiling(X key) {
        BinaryTreeNode<X, Y> ceilingNode = ceiling(root, key);
        return ceilingNode == null ? null : ceilingNode.getKey();
    }

    @Override
    public int rank(X key) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public X select(int k) {
        return select(root, k);
    }

    @Override
    public int size(X lo, X hi) {
        Counter counter = new Counter();
        counter.plus(size(root, lo, hi));
        return counter.size();
    }

    @Override
    public Iterable<X> keys(X lo, X hi) {
        X[] keys = keys(root, lo, hi);
        return () -> new TableIterator<>(keys, 0, keys.length - 1);
    }

    private BinaryTreeNode<X, Y> floor(BinaryTreeNode<X, Y> node, X key) {
        if (node == null) {
            return null;
        }
        X nodeKey = node.getKey();
        if (nodeKey.equals(key)) {
            return node;
        }
        if (SorterHelper.strictlyLesser(key, nodeKey)) {
            return floor(node.getLeftNode(), key);
        }
        BinaryTreeNode<X, Y> maxOfLesserNodes = floor(node.getRightNode(), key);
        return maxOfLesserNodes != null ? maxOfLesserNodes : node;
    }

    private BinaryTreeNode<X, Y> ceiling(BinaryTreeNode<X, Y> node, X key) {
        if (node == null) {
            return null;
        }
        X nodeKey = node.getKey();
        if (nodeKey.equals(key)) {
            return node;
        }
        if (SorterHelper.strictlyGreater(key, nodeKey)) {
            return ceiling(node.getRightNode(), key);
        }
        BinaryTreeNode<X, Y> minOfGreaterNodes = ceiling(node.getLeftNode(), key);
        return minOfGreaterNodes != null ? minOfGreaterNodes : node;
    }

    private X select(BinaryTreeNode<X, Y> node, int k) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<X, Y> leftNode = node.getLeftNode();
        int leftSize = leftNode != null ? leftNode.getSize() : 0;
        if (leftSize > k) {
            return select(leftNode, k);
        }
        if (leftSize < k) {
            return select(node.getRightNode(), k - leftSize - 1);
        }
        return node.getKey();
    }

    private BinaryTreeNode<X, Y> put(BinaryTreeNode<X, Y> node, X key, Y value) {
        if (node == null) {
            return createBinaryTreeNode(key, value);
        }
        X nodeKey = node.getKey();
        if (nodeKey.equals(key)) {
            node.setValue(value);
        } else if (SorterHelper.strictlyLesser(key, nodeKey)) {
            node.setLeftNode(put(node.getLeftNode(), key, value));
        } else {
            node.setRightNode(put(node.getRightNode(), key, value));
        }
        return node;
    }

    private BinaryTreeNode<X, Y> createBinaryTreeNode(X key, Y value) {
        size++;
        return new BinaryTreeNode<>(key, value);
    }

    // TODO Dessiner delete
    private BinaryTreeNode<X, Y> delete(BinaryTreeNode<X, Y> node, X key) {
        if (node == null) {
            return null;
        }
        if (SorterHelper.strictlyLesser(key, node.getKey())) {
            node.setLeftNode(delete(node.getLeftNode(), key));
        } else if (SorterHelper.strictlyGreater(key, node.getKey())) {
            node.setRightNode(delete(node.getRightNode(), key));
        } else {
            if (node.getRightNode() == null) {
                return node.getLeftNode();
            }
            if (node.getLeftNode() == null) {
                return node.getRightNode();
            }
            BinaryTreeNode<X, Y> t = node;
            node = min(t.getRightNode());
            node.setRightNode(deleteMin(t.getRightNode()));
            node.setLeftNode(t.getLeftNode());
            size--;
        }
        return node;
    }

    private BinaryTreeNode<X, Y> deleteMin(BinaryTreeNode<X, Y> node) {
        if (node.getLeftNode() == null) {
            return node.getRightNode();
        }
        node.setLeftNode(deleteMin(node.getLeftNode()));
        return node;
    }

    private BinaryTreeNode<X, Y> deleteMax(BinaryTreeNode<X, Y> node) {
        if (node.getRightNode() == null) {
            return node.getLeftNode();
        }
        node.setRightNode(deleteMax(node.getRightNode()));
        return node;
    }

    private BinaryTreeNode<X, Y> min(BinaryTreeNode<X, Y> node) {
        return getExtreme(BinaryTreeNode<X, Y>::getLeftNode, node);
    }

    private Y get(BinaryTreeNode<X, Y> node, X key) {
        if (node == null) {
            return null;
        }
        X nodeKey = node.getKey();
        if (nodeKey.equals(key)) {
            return node.getValue();
        } else if (SorterHelper.strictlyLesser(key, nodeKey)) {
            return get(node.getLeftNode(), key);
        } else {
            return get(node.getRightNode(), key);
        }
    }

    private BinaryTreeNode<X, Y> getExtreme(Function<BinaryTreeNode<X, Y>, BinaryTreeNode<X, Y>> extremeFunction,
                                            BinaryTreeNode<X, Y> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<X, Y> extremeNode = node;
        while (extremeFunction.apply(extremeNode) != null) {
            extremeNode = extremeFunction.apply(extremeNode);
        }
        return extremeNode;
    }

    private Counter size(BinaryTreeNode<X, Y> node, X lo, X hi) {
        return scanTree(node, lo, hi, SizeTreeScanHandler::new);
    }

    private X[] keys(BinaryTreeNode<X, Y> node, X lo, X hi) {
        return scanTree(node, lo, hi, () -> new KeysTreeScanHandler<>(keysTableSupplier));
    }

    // TODO dessiner keys
    private <U extends TreeScanHandler<T, X>, T> T scanTree(BinaryTreeNode<X, Y> node, X lo, X hi,
                                                            Supplier<U> supplier) {
        if (node == null) {
            return supplier.get().getResult();
        }
        TreeScanHandler<T, X> treeScanHandler = supplier.get();
        X nodeKey = node.getKey();
        if (SorterHelper.greater(nodeKey, lo) && SorterHelper.lesser(nodeKey, hi)) {
            treeScanHandler.consume(nodeKey);
        }
        if (SorterHelper.strictlyGreater(nodeKey, lo)) {
            treeScanHandler.consumeAll(scanTree(node.getLeftNode(), lo, hi, supplier));
        }
        if (SorterHelper.strictlyLesser(nodeKey, hi)) {
            treeScanHandler.consumeAll(scanTree(node.getRightNode(), lo, hi, supplier));
        }
        return treeScanHandler.getResult();
    }

    private static interface TreeScanHandler<T, X> {
        void consume(X nodeKey);

        void consumeAll(T result);

        T getResult();
    }

    private static class KeysTreeScanHandler<X extends Comparable<X>> implements TreeScanHandler<X[], X> {
        private final Sorter<X> sorter = new InsertionSorter<>();
        private final TableSupplier<X> keysTableSupplier;
        private X[] keys;

        public KeysTreeScanHandler(TableSupplier<X> keysTableSupplier) {
            this.keysTableSupplier = keysTableSupplier;
        }

        @Override
        public void consume(X nodeKey) {
            if (keys == null) {
                keys = keysTableSupplier.get(1);
                keys[0] = nodeKey;
            } else {
                X[] keys = keysTableSupplier.get(this.keys.length + 1);
                System.arraycopy(this.keys, 0, keys, 1, this.keys.length);
                this.keys = sorter.sort(keys);
            }
        }

        @Override
        public void consumeAll(X[] result) {
            if (result.length == 0) {
                return;
            }
            if (keys == null) {
                keys = keysTableSupplier.get(result.length);
                System.arraycopy(result, 0, keys, 0, result.length);
            } else {
                X[] keys = keysTableSupplier.get(this.keys.length + result.length);
                System.arraycopy(this.keys, 0, keys, 0, this.keys.length);
                System.arraycopy(result, 0, keys, this.keys.length, result.length);
                if (keys.length >= 2) {
                    SorterHelper.mergeSortedParts(keys, 0, this.keys.length - 1, keys.length - 1);
                }
                this.keys = keys;
            }
        }

        @Override
        public X[] getResult() {
            return keys == null ? keysTableSupplier.get(0) : keys;
        }
    }

    private static class SizeTreeScanHandler<X> implements TreeScanHandler<Counter, X> {
        private final Counter counter = new Counter();

        @Override
        public void consume(X nodeKey) {
            counter.increment();
        }

        @Override
        public void consumeAll(Counter counter) {
            this.counter.plus(counter);
        }

        @Override
        public Counter getResult() {
            return counter;
        }
    }

    private static class Counter {
        private int size;

        private void increment() {
            size++;
        }

        private void plus(Counter counter) {
            size += counter.size;
        }

        private int size() {
            return size;
        }
    }

}
