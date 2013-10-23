package com.algos.structure.symboltable;

import java.util.function.Supplier;

/**
 * @author Sennen
 * @since 21/10/13 18:11
 */
public interface SymbolTableSupplier<X extends SymbolTable<Y,Z>, Y, Z> extends Supplier<X> {
}
