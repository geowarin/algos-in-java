package com.algos.structure.graph;

import com.algos.structure.symboltable.SeparateChainingHashSymbolTable;
import com.algos.structure.symboltable.SymbolTable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

/**
 * @author Sennen
 * @since 05/01/14 03:16
 */
public class ExtensibleUndirectedSymbolGraph<T> implements UndirectedSymbolGraph<T> {
    private final SymbolTable<T, Integer> indicesByVertex = new SeparateChainingHashSymbolTable<>();
    private final Function<Integer, T[]> verticesTableSupplier;
    private final UndirectedGraph<Integer> underlyingGraph;
    private T[] vertices;
    private int numberOfVertices;

    public ExtensibleUndirectedSymbolGraph(Function<Integer, T[]> verticesTableSupplier) {
        this.verticesTableSupplier = verticesTableSupplier;
        underlyingGraph = new ExtensibleUndirectedGraph();
    }

    @Override
    public boolean contains(T key) {
        return indicesByVertex.contains(key);
    }

    @Override
    public UndirectedGraph<Integer> getUnderlyingGraph() {
        return underlyingGraph;
    }

    @Override
    public int getIndex(T vertex) {
        return indicesByVertex.get(vertex);
    }

    @Override
    public T getVertex(int index) {
        return vertices[index];
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int getNumberOfEdges() {
        return underlyingGraph.getNumberOfEdges();
    }

    @Override
    public void addEdge(T vertex, T otherVertex) {
        int vertexIndex = getOrCreateIndex(vertex);
        int otherVertexIndex = getOrCreateIndex(otherVertex);
        underlyingGraph.addEdge(vertexIndex, otherVertexIndex);
    }

    @Override
    public Iterable<T> getAdjacentVertices(T vertex) {
        if (!contains(vertex)) {
            return null;
        }
        final Iterator<Integer> underlyingIterator =
                underlyingGraph.getAdjacentVertices(getOrCreateIndex(vertex)).iterator();
        return () -> new IteratorConverter(underlyingIterator);
    }

    private int getOrCreateIndex(T key) {
        if (!contains(key)) {
            indicesByVertex.put(key, numberOfVertices);
            numberOfVertices++;
            updateVertices(key);
        }
        return indicesByVertex.get(key);
    }

    private void updateVertices(T key) {
        if (this.vertices == null) {
            this.vertices = verticesTableSupplier.apply(1);
            this.vertices[0] = key;
        } else {
            T[] vertices = verticesTableSupplier.apply(numberOfVertices);
            Arrays.setAll(vertices, index -> index < ExtensibleUndirectedSymbolGraph.this.vertices.length ?
                                             ExtensibleUndirectedSymbolGraph.this.vertices[index] :
                                             key);
            this.vertices = vertices;
        }
    }

    private class IteratorConverter implements Iterator<T> {
        private final Iterator<Integer> underlyingIterator;

        public IteratorConverter(Iterator<Integer> underlyingIterator) {
            this.underlyingIterator = underlyingIterator;
        }

        @Override
        public boolean hasNext() {
            return underlyingIterator.hasNext();
        }

        @Override
        public T next() {
            Integer vertexIndex = underlyingIterator.next();
            return vertices[vertexIndex];
        }
    }
}
